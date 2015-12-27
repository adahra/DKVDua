package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.gameobject.PembuatArena;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Kelas yang digunakan untuk melakukan penggambaran dari layar menu utama
 * 
 * @author blackshadow
 *
 */
public class LayarMenuUtama extends LayarAbstrak {
	private final static String TAG = LayarMenuUtama.class.getSimpleName();

	private SpriteBatch batcher;
	private OrthographicCamera camera;

	private int lebarLayar;
	private int tinggiLayar;

	private int lebarDuniaGim;
	private int tinggiDuniaGim;

	/**
	 * Konstruktor dari kelas
	 */
	public LayarMenuUtama(DKVDuaMain game) {
		super(game);
		buatLayar();
	}

	/**
	 * Method yang digunakan untuk membuat layar atau menampilkan semua grafik
	 * ke layar sehingga sedemikian rupa membentuk layar menu utama
	 */
	public void buatLayar() {
		lebarLayar = Gdx.graphics.getWidth();
		tinggiLayar = Gdx.graphics.getHeight();
		lebarDuniaGim = 192;
		tinggiDuniaGim = 272;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, lebarDuniaGim, tinggiDuniaGim);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);

		Gdx.app.log(TAG, "Lebar Layar : " + lebarDuniaGim
				+ " \nTinggi Layar : " + tinggiDuniaGim);

		Gdx.app.log(TAG, "Lebar Layar HP : " + lebarLayar
				+ " \nTinggi Layar HP : " + tinggiLayar);
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
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		PemuatAktiva.dkvduaMusicMysteryBox.pause();
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
		PemuatAktiva.dkvduaMusicMysteryBox.dispose();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.begin();
		batcher.draw(PemuatAktiva.dkvduaPopup, 0, 0, lebarDuniaGim,
				tinggiDuniaGim);
		batcher.draw(PemuatAktiva.dkvduaTitle, (lebarDuniaGim / 4),
				(tinggiDuniaGim / 2) + 50, PemuatAktiva.dkvduaTitle.getWidth(),
				PemuatAktiva.dkvduaTitle.getHeight());
		PemuatAktiva.dkvduaFont.draw(batcher, "Dorong Kotak", lebarLayar,
				tinggiLayar);
		batcher.end();
		
		if (Gdx.input.isTouched()) {
			game.setScreen(new PembuatArena(game));
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.begin();
		batcher.draw(PemuatAktiva.dkvduaPopup, 0, 0, lebarLayar, tinggiLayar);
		batcher.draw(PemuatAktiva.dkvduaTitle, 35, 550, 400, 178);
		PemuatAktiva.dkvduaFont.draw(batcher, "Dorong Kotak", lebarLayar / 2,
				tinggiLayar / 2);
		batcher.end();

		PemuatAktiva.dkvduaMusicMysteryBox.play();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		PemuatAktiva.dkvduaMusicMysteryBox.stop();
	}
}
