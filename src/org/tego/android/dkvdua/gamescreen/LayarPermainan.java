package org.tego.android.dkvdua.gamescreen;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.gameworld.DuniaPermainan;
import org.tego.android.dkvdua.gameworld.RendDuniaPermainan;
import org.tego.android.dkvdua.helper.PenangananKontrol;
import org.tego.android.dkvdua.layar.LayarAbstrak;

import com.badlogic.gdx.Gdx;

/**
 * Kelas yang digunakan untuk mengatur penggambaran layar dari permainan
 * 
 * @author blackshadow
 *
 */
public class LayarPermainan extends LayarAbstrak {
	private static final String TAG = LayarPermainan.class.getSimpleName();

	private DuniaPermainan world;
	private RendDuniaPermainan renderer;
	private DKVDuaMain game;
	
	public LayarPermainan(DKVDuaMain game) {
		super(game);
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 192;
		// float gameHeight = screenHeight / (screenWidth / gameWidth);
		// float gameHeight = (screenHeight / screenWidth) * gameWidth;
		float gameHeight = 272;

		this.setGame(game);
		
		world = new DuniaPermainan(gameWidth, gameHeight);
		Gdx.input.setInputProcessor(new PenangananKontrol(world, screenWidth
				/ gameWidth, screenHeight / gameHeight));
		renderer = new RendDuniaPermainan(world, (int) gameWidth, (int) gameHeight);
		
		Gdx.app.log(TAG, "Lebar Layar HP : " + screenWidth
				+ " \nTinggi Layar HP : " + screenHeight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {

	}

	public DKVDuaMain getGame() {
		return game;
	}

	public void setGame(DKVDuaMain game) {
		this.game = game;
	}
}
