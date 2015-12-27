package org.tego.android.dkvdua.gameworld;

import org.tego.android.dkvdua.gameobject.PembuatArena;

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
public class RendDuniaPermainan {
	public static final String TAG = RendDuniaPermainan.class.getSimpleName();

	// private GameWorld myWorld;
	public OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	// private Pemain pemain;
	// private Musuh musuh;
	// private Kotak kotak;
	// private Lubang lubang;
	// private TextureRegion trPemain;
	// private TextureRegion trMusuh;
	// private TextureRegion trKotak;
	// private TextureRegion trLubang;
	private int lebarLayar;
	private int tinggiLayar;
	// private Level petaGim;
	private PembuatArena levelGenerator;

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
	public RendDuniaPermainan(DuniaPermainan world, int gameWidth, int gameHeight) {
		// myWorld = world;

		lebarLayar = gameWidth;
		tinggiLayar = gameHeight;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, lebarLayar, tinggiLayar);

		// petaGim = new Level(world, lebarLayar, tinggiLayar);
		// levelGenerator = new PembuatArena(world, lebarLayar, tinggiLayar);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		Gdx.app.log(TAG, "Lebar Layar : " + lebarLayar + " \nTinggi Layar : "
				+ tinggiLayar);
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
		shapeRenderer.setColor(114 / 255.0f, 129 / 255.0f, 146 / 255.0f, 1);
		shapeRenderer.rect(0, 0, lebarLayar, 32);
		shapeRenderer.end();

		batcher.begin();
		// petaGim.render(batcher);
		levelGenerator.render(batcher);
		levelGenerator.update(delta);
		batcher.end();

		// levelGenerator.update(delta);
		// petaGim.update(delta);
	}

	/*
	 * private void inisialisasiObyek() {
	 * 
	 * }
	 */

	/*
	 * private void inisialisasiAset() {
	 * 
	 * }
	 */

	/*
	 * private void gambarPeta() {
	 * 
	 * }
	 */

	/*
	 * private void gambarPemain() {
	 * 
	 * }
	 */

	/*
	 * private void gambarMusuh() {
	 * 
	 * }
	 */

	/*
	 * private void gambarKotak() {
	 * 
	 * }
	 */

	/*
	 * private void gambarLubang() {
	 * 
	 * }
	 */

	/*
	 * private void gambarHati() {
	 * 
	 * }
	 */
}
