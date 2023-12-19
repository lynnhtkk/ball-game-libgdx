package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int width;
    int height;
    int xPosition;
    int yPosition;

    public Paddle(int width, int height, int yPosition) {
        this.width = width;
        this.height = height;
        this.xPosition = Gdx.graphics.getWidth() / 2 - width / 2;
        this.yPosition = yPosition;
    }

    public void update() {
        xPosition = Gdx.input.getX() - width / 2;
        xPosition = Math.max(xPosition, 0);
        xPosition = Math.min(xPosition, Gdx.graphics.getWidth() - width);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(xPosition, yPosition, width, height);
    }
}
