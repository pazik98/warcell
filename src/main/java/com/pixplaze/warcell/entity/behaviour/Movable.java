package com.pixplaze.warcell.entity.behaviour;

public interface Movable {

    /**
     * Responsible for generalizing all movable objects in the simulation
     */

    public void move();

    public void turnLeft();

    public void turnRight();
}
