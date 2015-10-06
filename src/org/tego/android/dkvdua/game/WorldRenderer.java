package org.tego.android.dkvdua.game;

import org.tego.android.dkvdua.gameobject.Level;
import org.tego.android.dkvdua.utilitas.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {
	public static final String TAG = WorldRenderer.class.getSimpleName();

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	private Level level;

	public WorldRenderer(WorldController worldController) {
		// TODO Auto-generated constructor stub
		this.worldController = worldController;
		init();
	}

	private void init() {
		batch = new SpriteBatch();
		level = new Level(this);
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
				Constants.VIEWPORT_HEIGHT);
		camera.update();
	}

	public void update(float deltaTime) {

	}

	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		renderGUI(batch);
		renderLevel(batch);
		batch.end();
	}

	private void renderLevel(SpriteBatch batch) {
		level.render(batch);
	}

	private void renderGUI(SpriteBatch batch) {
		renderHuruf(batch);
		renderFpsCounter(batch);
	}

	private void renderFpsCounter(SpriteBatch batch) {
		// float x = camera.viewportWidth - 55;
		// float y = camera.viewportHeight - 15;
		int fps = Gdx.graphics.getFramesPerSecond();
		BitmapFont hurufFps = Assets.instance.huruf.hurufNormal;

		if (fps >= 45) {
			hurufFps.setColor(0, 1, 0, 1);
		} else if (fps >= 30) {
			hurufFps.setColor(1, 1, 0, 1);
		} else {
			hurufFps.setColor(1, 0, 0, 1);
		}

		hurufFps.draw(batch, "FPS: " + fps, 50, 50);
		hurufFps.setColor(1, 1, 1, 1);
	}

	private void renderHuruf(SpriteBatch batch) {
		// float x = -15;
		// float y = -15;
		Assets.instance.huruf.hurufNormal.draw(batch, "Ini hanya test saja",
				25, 25);
	}

	public void resize(int width, int height) {
		camera.viewportHeight = Constants.VIEWPORT_HEIGHT;
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / (float) height)
				* (float) width;
		camera.position.set(camera.viewportWidth / 2,
				camera.viewportHeight / 2, 0);
		camera.update();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
