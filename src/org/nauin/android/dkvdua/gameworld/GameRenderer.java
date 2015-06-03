package org.nauin.android.dkvdua.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;

	public GameRenderer(GameWorld world, int gameWidth, int gameHeight) {
		myWorld = world;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, gameWidth, gameHeight);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
	}

	public GameRenderer(GameWorld mGameWorld, float gameWidth, float gameHeight) {
		
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.end();

		batcher.begin();
		batcher.disableBlending();
		batcher.enableBlending();
		batcher.end();
	}
}
