package org.nauin.android.dkvdua.layar;

import javax.microedition.khronos.opengles.GL10;

import org.nauin.android.dkvdua.DKVDuaMain;
import org.nauin.android.dkvdua.gamescreen.Game;
import org.nauin.android.dkvdua.gameworld.GameRenderer;
import org.nauin.android.dkvdua.gameworld.GameWorld;
import org.nauin.android.dkvdua.helper.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LayarMenuUtama implements Screen {
	private SpriteBatch mSpriteBatch;
	private GameWorld mGameWorld;
	private GameRenderer mGameRenderer;
	
	public LayarMenuUtama(DKVDuaMain dkvDuaMain) {
		buatLayar();
	}

	public void buatLayar() {
		float lebarLayar = Gdx.graphics.getWidth();
		float tinggiLayar = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = tinggiLayar / (lebarLayar / gameWidth);
		
		mGameWorld = new GameWorld(gameWidth, gameHeight);
		Gdx.input.setInputProcessor(new InputHandler(mGameWorld, lebarLayar, tinggiLayar));
		mGameRenderer = new GameRenderer(mGameWorld, gameWidth, gameHeight);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
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
