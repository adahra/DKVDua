package org.tego.android.dkvdua.gamescreen;

import org.tego.android.dkvdua.gameworld.GameRenderer;
import org.tego.android.dkvdua.gameworld.GameWorld;
import org.tego.android.dkvdua.helper.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Kelas yang digunakan untuk mengatur penggambaran layar dari permainan
 * 
 * @author blackshadow
 *
 */
public class LayarPermainan implements Screen {
	private GameWorld world;
	private GameRenderer renderer;
	private static final int LEBAR_VIRTUAL = 320;
	private static final int TINGGI_VIRTUAL = 480;
	private static final float RASIO_ASPEK = (float) LEBAR_VIRTUAL / (float) TINGGI_VIRTUAL;
	private Rectangle viewport;

	public LayarPermainan() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 192;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		// float gameHeight = 320; 

		
		
		int nilaiTengah = (int) gameHeight / 2;
		
		world = new GameWorld(gameWidth, gameHeight);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth
				/ gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, LEBAR_VIRTUAL, TINGGI_VIRTUAL);
		
		System.out.println("Lebar Layar HP  : " +screenWidth);
		System.out.println("Tinggi Layar HP : " +screenHeight);
		
		System.out.println("Nilai Tengah    : " +nilaiTengah);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y, (int) viewport.width, (int) viewport.height);
		
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
		float rasioAspek = (float) width / (float) height;
		float skala = 1f;
		Vector2 crop = new Vector2(0f, 0f);
		
		if (rasioAspek > RASIO_ASPEK) {
			skala = (float) height / (float) TINGGI_VIRTUAL;
			crop.x = (width - LEBAR_VIRTUAL * skala) / 2f;
		} else if (rasioAspek < RASIO_ASPEK) {
			skala = (float) width / (float) LEBAR_VIRTUAL;
			crop.y = (height - TINGGI_VIRTUAL * skala) / 2f;
		} else {
			skala = (float) width / (float) LEBAR_VIRTUAL;
		}
		
		float w = (float) LEBAR_VIRTUAL * skala;
		float h = (float) TINGGI_VIRTUAL * skala;
		viewport = new Rectangle(crop.x, crop.y, w, h);
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
}
