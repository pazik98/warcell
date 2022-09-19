package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.entity.behaviour.*;
import com.pixplaze.warcell.entity.behaviour.command.MoveCommand;
import com.pixplaze.warcell.entity.behaviour.command.TurnLeftCommand;
import com.pixplaze.warcell.entity.behaviour.command.TurnRightCommand;
import com.pixplaze.warcell.entity.behaviour.command.UnitCommand;
import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.Position;
import com.pixplaze.warcell.world.World;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Unit extends Entity implements Programmable, Movable {

    private final Queue<UnitCommand> commandQueue = new LinkedList<>();
    private static final ResourceManager resourceManager = ResourceManager.getInstance();

    public Unit() {
        super("Unit");
        initCommands();
    }

    public Unit(String name) {
        super(name);
        initCommands();
    }

    public void move() {
        Position p = getPosition();
        FacingType facing = p.getFacing();
        World w = getWorld();

        switch (facing) {
            case NORTH:
                if (w.isEmpty(p.getX(), p.getY() + 1)) {
                    w.clearCell(p.getX(), p.getY());
                    p.toUp();
                    w.getMap().setEntityAtCell(p.getX(), p.getY(), this);
                }
                break;
            case EAST:
                if (w.isEmpty(p.getX() + 1, p.getY())) {
                    w.clearCell(p.getX(), p.getY());
                    p.toRight();
                    w.getMap().setEntityAtCell(p.getX(), p.getY(), this);
                }
                break;
            case SOUTH:
                if (w.isEmpty(p.getX(), p.getY() - 1)) {
                    w.clearCell(p.getX(), p.getY());
                    p.toDown();
                    w.getMap().setEntityAtCell(p.getX(), p.getY(), this);
                }
                break;
            case WEST:
                if (w.isEmpty(p.getX() - 1, p.getY())) {
                    w.clearCell(p.getX(), p.getY());
                    p.toLeft();
                    w.getMap().setEntityAtCell(p.getX(), p.getY(), this);
                }
        }
    }

    public void turnLeft() {
        Position p = getPosition();
        FacingType facing = p.getFacing();

        switch (facing) {
            case NORTH -> p.setFacing(FacingType.WEST);
            case EAST -> p.setFacing(FacingType.NORTH);
            case SOUTH -> p.setFacing(FacingType.EAST);
            case WEST -> p.setFacing(FacingType.SOUTH);
        }
    }

    public void turnRight() {
        Position p = getPosition();
        FacingType facing = p.getFacing();

        switch (facing) {
            case NORTH -> p.setFacing(FacingType.EAST);
            case EAST -> p.setFacing(FacingType.SOUTH);
            case SOUTH -> p.setFacing(FacingType.WEST);
            case WEST -> p.setFacing(FacingType.NORTH);
        }
    }

    public Entity checkFront() {
        switch (getPosition().getFacing()) {
            case NORTH -> {
                return getEntityRelatively(0, 1);
            }
            case EAST -> {
                return getEntityRelatively(1, 0);
            }
            case SOUTH -> {
                return getEntityRelatively(0, -1);
            }
            case WEST -> {
                return getEntityRelatively(-1, 0);
            }
        }
        return null;
    }

    private Entity getEntityRelatively(int x, int y) {
        int xCoord = getPosition().getX() + x;
        int yCoord = getPosition().getY() + y;

        return getWorld().getEntity(xCoord, yCoord);
    }

    @Override
    public BufferedImage getDefaultTexture() {
        return resourceManager.getTexture("entity.default-unit");
    }

    @Override
    public void executeActualCommand() {
        UnitCommand command = commandQueue.poll();
        assert command != null;
        command.execute();
        commandQueue.add(command);
    }

    public void initCommands() {
        MoveCommand<Unit> moveCommand = new MoveCommand<>(this);
        TurnLeftCommand<Unit> turnLeftCommand = new TurnLeftCommand<>(this);
        TurnRightCommand<Unit> turnRightCommand = new TurnRightCommand<>(this);
        commandQueue.add(turnRightCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(turnLeftCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(turnLeftCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
    }
}
