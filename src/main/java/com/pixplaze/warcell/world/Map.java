package com.pixplaze.warcell.world;

import com.pixplaze.warcell.entity.Entity;

public class Map {

    private final int sizeX;
    private final int sizeY;
    private final Entity[][] cells;

    public Map(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.cells = new Entity[sizeX][sizeY];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setEntityAtCell(int x, int y, Entity entity) {
        entity.getPosition().setX(x);
        entity.getPosition().setY(y);
        cells[x][y] = entity;
    }

    public Entity getEntityAtCell(int x, int y) {
        return cells[x][y];
    }
}
