package org.tego.android.dkvdua.layar;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.gameobject.AssetLoader;
import org.tego.android.dkvdua.gamescreen.Game;
import org.tego.android.dkvdua.gameworld.GameRenderer;
import org.tego.android.dkvdua.gameworld.GameWorld;
import org.tego.android.dkvdua.helper.InputHandler;
import org.tego.android.dkvdua.ui.Tombol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Kelas yang digunakan untuk melakukan penggambaran dari layar menu utama
 * 
 * @author blackshadow
 *
 */
public class LayarMenuUtama implements Screen {
	private SpriteBatch mSpriteBatch;
	private Sprite mSprite;
	private GameWorld mGameWorld;
	private GameRenderer mGameRenderer;
	private float lebar = Gdx.graphics.getWidth();
	private float tinggi = Gdx.graphics.getHeight();
	private List<Tombol> tombolMenu;

	/**
	 * Konstruktor dari kelas
	 */
	public LayarMenuUtama() {
		buatLayar();
	}

	/**
	 * Method yang digunakan untuk membuat layar atau menampilkan semua grafik
	 * ke layar sehingga sedemikian rupa membentuk layar menu utama
	 */
	public void buatLayar() {
		float gameWidth = 136;
		float gameHeight = tinggi / (lebar / gameWidth);

		mGameWorld = new GameWorld(gameWidth, gameHeight);
		Gdx.input
				.setInputProcessor(new InputHandler(mGameWorld, lebar, tinggi));
		mGameRenderer = new GameRenderer(mGameWorld, (int) gameWidth, (int) gameHeight);
		mSpriteBatch = new SpriteBatch();

		this.tombolMenu = ((InputHandler) Gdx.input.getInputProcessor())
				.getTombolMenu();

		AssetLoader.dkvduaMusicMysteryBox.play();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		mSpriteBatch.begin();
		mSpriteBatch.draw(AssetLoader.dkvduaPopup, 0, 0, lebar, tinggi);
		mSpriteBatch.draw(AssetLoader.dkvduaTitle, 35, 550, 400, 178);

		for (Tombol tombol : tombolMenu) {
			tombol.gambar(mSpriteBatch);
		}

		mSpriteBatch.end();
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
		AssetLoader.dkvduaMusicMysteryBox.pause();
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
		AssetLoader.dkvduaMusicMysteryBox.dispose();
	}

	/**
	 * Method yang digunakan untuk mengatur event dari tombol menu
	 */
	private void tombolMenu() {

	}

}
