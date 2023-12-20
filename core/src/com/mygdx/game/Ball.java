package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x <= size || x >= Gdx.graphics.getWidth() - size) {
            xSpeed = -xSpeed;
        }
        if (y <= size || y >= Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Brick brick) {
        if (collidesWith(brick)) {
            ySpeed = -ySpeed;
            brick.setDestroyed(true);
        }
    }

    private <B extends Block> boolean collidesWith(B block) {
        // Find the closest point to the ball on the paddle
        int closestX = clamp(this.x, block.getX(), block.getX() + block.width);
        int closestY = clamp(this.y, block.getY(), block.getY() + block.height);

        // Calculate the distance between the ball's center to the closest point
        int distanceX = this.x - closestX;
        int distanceY = this.y - closestY;

        // Calculate the squared distance (avoids the need for square root)
        int distanceSquared = distanceX * distanceX + distanceY * distanceY;

        // Return True if the distance squared is less than the ball's radius squared
        return distanceSquared <= (this.size * this.size);
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
