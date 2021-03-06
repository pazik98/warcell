package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.entity.behaviour.*;
import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.Map;
import com.pixplaze.warcell.world.Position;
import com.pixplaze.warcell.world.World;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Unit extends Entity implements IProgrammable, IMovable {

    private final Queue<IUnitCommand> commandQueue = new LinkedList<>();

    public Unit() {
        super("Unit");
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

    @Override
    public BufferedImage getDefaultTexture() {
        return ResourceManager.getInstance().loadTexture("/entities/unit.jpg");
    }

    @Override
    public void executeActualCommand() {
        IUnitCommand command = commandQueue.poll();
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
