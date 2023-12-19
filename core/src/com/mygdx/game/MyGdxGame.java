package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Block> blocks = new ArrayList<>();

	@Override
	public void create() {
		int blockWidth = 63;
		int blockHeight = 20;
		shape = new ShapeRenderer();
		ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 20, 10, 5);
		paddle = new Paddle(150, 10, 20);
		for (int y = Gdx.graphics.getHeight() / 2; y  < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		for (Block block : blocks) {
			block.draw(shape);
		}
		ball.update();
		ball.draw(shape);
		ball.checkCollision(paddle);
		paddle.update();
		paddle.draw(shape);
		shape.end();
	}
}
