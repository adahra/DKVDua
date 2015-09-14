package org.tego.android.dkvdua.gameworld;

import org.tego.android.dkvdua.gameobject.AssetLoader;
import org.tego.android.dkvdua.gameobject.Kotak;
import org.tego.android.dkvdua.gameobject.Lubang;
import org.tego.android.dkvdua.gameobject.Musuh;
import org.tego.android.dkvdua.gameobject.Pemain;
import org.tego.android.dkvdua.ui.Tombol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.List;

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
	private Pemain pemain;
	private Musuh musuh;
	private Kotak kotak;
	private Lubang lubang;
	private TextureRegion trPemain;
	private TextureRegion trMusuh;
	private TextureRegion trKotak;
	private TextureRegion trLubang;
	private int lebarLayar;
	private int tinggiLayar;

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

		lebarLayar = gameWidth;
		tinggiLayar = gameHeight;
		
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
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, lebarLayar, tinggiLayar);
		shapeRenderer.setColor(119 / 255.0f, 79 / 255.0f, 4 / 255.0f, 1);
		shapeRenderer.rect(0, 32, lebarLayar, tinggiLayar);
		shapeRenderer.setColor(195 / 255.0f, 195 / 255.0f, 195 / 255.0f, 1);
		shapeRenderer.rect(0, tinggiLayar - 40, 20, 40);
		shapeRenderer.setColor(195 / 255.0f, 195 / 255.0f, 195 / 255.0f, 1);
		shapeRenderer.rect(lebarLayar - 40, tinggiLayar - 20, 40, 20);
		shapeRenderer.end();

		batcher.begin();
		// batcher.draw(AssetLoader.gambarUbin, 15, 15);
		batcher.end();
	}
	
	private void inisialisasiObyek() {
		
	}
	
	private void inisialisasiAset() {
		
	}
	
	private void gambarPeta() {
		
	}
	
	private void gambarPemain() {
		
	}
	
	private void gambarMusuh() {
		
	}
	
	private void gambarKotak() {
		
	}
	
	private void gambarLubang() {
		
	}
}
