package com.pixplaze.entity;

import com.pixplaze.entity.behaviour.IMovable;
import com.pixplaze.entity.behaviour.IProgrammable;
import com.pixplaze.entity.behaviour.IUnitCommand;
import com.pixplaze.entity.behaviour.MoveCommand;
import com.pixplaze.world.FacingType;
import com.pixplaze.world.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
                System.out.printf("Moving unit to x:%d y:%d\n", pos.getX(), pos.getY()+1);
                if (getWorld().isEmpty(pos.getX(), pos.getY() + 1)) {
                    pos.toUp();
                    System.out.println("Success!");
                }
                break;
            case EAST:
                if (getWorld().isEmpty(pos.getX() + 1, pos.getY())) {
                    pos.toRight();
                    System.out.println("Success!");
                }
                break;
            case SOUTH:
                System.out.printf("Moving unit to x:%d y:%d\n", pos.getX(), pos.getY()-1);
                if (getWorld().isEmpty(pos.getX(), pos.getY() - 1)) {
                    pos.toDown();
                    System.out.println("Success!");
                }
                break;
            case WEST:
                if (getWorld().isEmpty(pos.getX() - 1, pos.getY())) {
                    pos.toLeft();
                    System.out.println("Success!");
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
    public void executeActualCommand() {
        IUnitCommand command = commandQueue.poll();
        if (command == null) {
            System.out.println("No commands to execute!");
        } else {
            command.execute();
        }
    }

    public void initCommands() {
        MoveCommand moveCommand = new MoveCommand<Unit>(this);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
        commandQueue.add(moveCommand);
    }
}
