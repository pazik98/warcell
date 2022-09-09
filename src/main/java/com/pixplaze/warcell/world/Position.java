package com.pixplaze.warcell.world;

import java.util.Objects;

public class Position {

    /**
     * The class is responsible for storing and changing the position of the object in the game world
     */

    private int x;
    private int y;
    private FacingType facing;

    public Position() {
        this.x = 0;
        this.y = 0;
        this.facing = FacingType.SOUTH;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.facing = FacingType.SOUTH;
    }

    public Position(int x, int y, FacingType facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public FacingType getFacing() {
        return facing;
    }

    public void setFacing(FacingType facing) {
        this.facing = facing;
    }

    public void toUp() {
        y++;
    }

    public void toRight() {
        x++;
    }

    public void toDown() {
        y--;
    }

    public void toLeft() {
        x--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && facing == position.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }
}
