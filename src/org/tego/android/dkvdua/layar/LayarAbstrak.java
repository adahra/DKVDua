package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * @author Mats Svensson
 */
public abstract class LayarAbstrak implements Screen {

	protected DKVDuaMain game;
	protected Screen screen;

	/**
	 * 
	 * @param game
	 */
	public LayarAbstrak(DKVDuaMain game) {
		this.game = game;
	}

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		if (screen != null) {
			screen.pause();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		if (screen != null) {
			screen.resume();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		if (screen != null) {
			screen.hide();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		if (screen != null) {
			screen.resize(width, height);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
	}

	/**
	 * 
	 * @return
	 */
	public Screen getScreen() {
		return screen;
	}

	/**
	 * 
	 * @param screen
	 */
	public void setScreen(Screen screen) {
		if (this.screen != null) {
			this.screen.hide();
		}

		this.screen = screen;

		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight());
		}
	}
}
