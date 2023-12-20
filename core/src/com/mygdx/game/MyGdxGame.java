package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Brick> bricks = new ArrayList<>();

	@Override
	public void create() {
		int blockWidth = 63;
		int blockHeight = 20;
		shape = new ShapeRenderer();
		ball = new Ball(25, 25, 10, 5, 10);
		paddle = new Paddle(150, 10);
		for (int y = (int) (Gdx.graphics.getHeight() * 0.7); y  < Gdx.graphics.getHeight(); y += blockHeight + 5) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				bricks.add(new Brick(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		ball.draw(shape);
		ball.checkCollision(paddle);
		paddle.update();
		paddle.draw(shape);
		for (Brick brick : bricks) {
			brick.draw(shape);
			ball.checkCollision(brick);
		}
		for (int i = 0; i < bricks.size(); i++) {
			Brick b = bricks.get(i);
			if (b.isDestroyed()) {
				bricks.remove(b);
				i--;
			}
		}
		shape.end();
	}
}
