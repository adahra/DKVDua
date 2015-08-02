/**
 * 
 */
package org.tego.android.dkvdua;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Kelas yang digunakan untuk mengatur/membentuk aplikasi permainan
 * 
 * @author blackshadow
 *
 */
public class Game implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private TextureRegion textureRegion;
	private Sprite sprite;

	private float SCREEN_WIDTH;
	private float SCREEN_HEIGHT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		// TODO Auto-generated method stub
		SCREEN_WIDTH = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.update();
		batch = new SpriteBatch();

		texture = new Texture(Gdx.files.internal("data/gfx/dkvduaPopup.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		textureRegion = new TextureRegion(texture, 0, 0, 500, 368);

		sprite = new Sprite(textureRegion);
		sprite.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		// batch.draw(textureRegion, 0, 0);
		sprite.draw(batch);
		batch.end();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		texture.dispose();
	}

}
