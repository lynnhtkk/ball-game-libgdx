package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

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
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            color = Color.GREEN;
            ySpeed = -ySpeed;
        } else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        // Find the closest point to the ball on the paddle
        int closestX = clamp(this.x, paddle.xPosition, paddle.xPosition + paddle.width);
        int closestY = clamp(this.y, paddle.yPosition, paddle.yPosition + paddle.height);

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