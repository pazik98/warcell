package com.pixplaze.warcell.entity.behaviour;

import com.pixplaze.warcell.entity.Entity;

public interface Movable {

    /**
     * Responsible for generalizing all movable objects in the simulation
     */

    public void move();

    public void turnLeft();

    public void turnRight();

    public Entity checkFront();
}
