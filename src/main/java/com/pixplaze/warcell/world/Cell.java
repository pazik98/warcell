package com.pixplaze.warcell.world;

import com.pixplaze.warcell.entity.Entity;

/**
 * The class is responsible for updating and storing world data.
 */
public class Cell implements Cloneable {

    private CellType cellType;
    private Entity placedEntity;

    public Cell() {
        this.cellType = CellType.VOID;
    }

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Entity getPlacedEntity() {
        return placedEntity;
    }

    public void setPlacedEntity(Entity placedEntity) {
        this.placedEntity = placedEntity;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void update() {
        updateEntity();
    }

    private void updateEntity() {
        //TODO Create update method for entity and use it
    }
}
