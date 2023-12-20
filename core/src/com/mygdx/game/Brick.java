package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick extends Block {
    private boolean isDestroyed;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        isDestroyed = false;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}
