package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Entity;

public class Empty extends Entity {

    public Empty() {
        super("Empty");
    }

    public Empty(int x, int y) { super("Empty", x, y); }
}
