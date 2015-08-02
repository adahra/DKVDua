package org.tego.android.dkvdua.gameworld;

import org.tego.android.dkvdua.gameobject.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Kelas yang digunakan untuk melakukan penggambaran dalam permainan
 * 
 * @author blackshadow
 *
 */
public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param world
	 *            Dunia/Layar dari permainan
	 * @param gameWidth
	 *            Lebar layar dari permainan
	 * @param gameHeight
	 *            Tinggi layar dari permainan
	 */
	public GameRenderer(GameWorld world, int gameWidth, int gameHeight) {
		myWorld = world;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, gameWidth, gameHeight);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
	}

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param mGameWorld
	 * @param gameWidth
	 * @param gameHeight
	 */
	public GameRenderer(GameWorld mGameWorld, float gameWidth, float gameHeight) {

	}

	/**
	 * Method yang digunakan untuk merender/menggambar semua grafik dari
	 * permainan
	 * 
	 * @param delta
	 *            Waktu yang digunakan dalam permainan
	 */
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.end();

		batcher.begin();
		batcher.end();
	}
}
