package org.nauin.android.dkvdua.gamescreen;

import org.nauin.android.dkvdua.gameworld.GameRenderer;
import org.nauin.android.dkvdua.gameworld.GameWorld;
import org.nauin.android.dkvdua.helper.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class LayarPermainan implements Screen {
	private GameWorld world;
	private GameRenderer renderer;

	public LayarPermainan() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);

		world = new GameWorld(gameWidth, gameHeight);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth
				/ gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, (int) gameWidth, (int) gameHeight);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
