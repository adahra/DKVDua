package org.tego.android.dkvdua.gamescreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Kelas abstrak yang digunakan sebagai listener dari semua kelas yang
 * diturunkan dari kelas Screen
 * 
 * @author blackshadow
 *
 */
public abstract class Game implements ApplicationListener {
	private Screen screen;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		if (screen != null) {
			screen.resize(width, height);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#render()
	 */
	@Override
	public void render() {
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#pause()
	 */
	@Override
	public void pause() {
		if (screen != null) {
			screen.pause();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#resume()
	 */
	@Override
	public void resume() {
		if (screen != null) {
			screen.resume();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#dispose()
	 */
	@Override
	public void dispose() {
		if (screen != null) {
			screen.hide();
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
