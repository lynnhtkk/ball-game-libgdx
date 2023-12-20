package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends Brick {

    public Paddle(int width, int height) {
        super(0, 0, width, height);
    }

    public void update() {
        super.setX(Gdx.input.getX() - width / 2);
        super.setX(Math.max(super.getX(), 0));
        super.setX(Math.min(super.getX(), Gdx.graphics.getWidth() - width));
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(super.getX(), super.getY(), width, height);
    }
}
