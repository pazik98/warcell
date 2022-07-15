package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.entity.behaviour.*;
import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.Position;

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
        Position pos = getPosition();
        FacingType facing = pos.getFacing();

        switch (facing) {
            case NORTH:
                if (getWorld().isEmpty(pos.getX(), pos.getY() + 1)) {
                    pos.toUp();
                }
                break;
            case EAST:
                if (getWorld().isEmpty(pos.getX() + 1, pos.getY())) {
                    pos.toRight();
                }
                break;
            case SOUTH:
                if (getWorld().isEmpty(pos.getX(), pos.getY() - 1)) {
                    pos.toDown();
                }
                break;
            case WEST:
                if (getWorld().isEmpty(pos.getX() - 1, pos.getY())) {
                    pos.toLeft();
                }
                break;
        }
    }

    public void turnLeft() {
        Position pos = getPosition();
        FacingType facing = pos.getFacing();

        switch (facing) {
            case NORTH -> pos.setFacing(FacingType.WEST);
            case EAST -> pos.setFacing(FacingType.NORTH);
            case SOUTH -> pos.setFacing(FacingType.EAST);
            case WEST -> pos.setFacing(FacingType.SOUTH);
        }
    }

    public void turnRight() {
        Position pos = getPosition();
        FacingType facing = pos.getFacing();

        switch (facing) {
            case NORTH -> pos.setFacing(FacingType.EAST);
            case EAST -> pos.setFacing(FacingType.SOUTH);
            case SOUTH -> pos.setFacing(FacingType.WEST);
            case WEST -> pos.setFacing(FacingType.NORTH);
        }
    }

    @Override
    public BufferedImage getDefaultTexture() {
        return ResourceManager.getInstance().loadTexture("/entities/unit.jpg");
    }

    @Override
    public void executeActualCommand() {
        IUnitCommand command = commandQueue.poll();
        if (command == null) {
            System.out.println("No commands to execute!");
        } else {
            command.execute();
        }
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
    }
}
