/**
 * 
 */
package org.tego.android.dkvdua;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Kelas yang digunakan untuk mengatur/membentuk aplikasi permainan
 * 
 * @author blackshadow
 *
 */
public class Game implements ApplicationListener {
	private OrthographicCamera camera;
	
	private float SCREEN_WIDTH = 320;
	private float SCREEN_HEIGHT = 480;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		// TODO Auto-generated method stub
		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.update();
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
	}

}
