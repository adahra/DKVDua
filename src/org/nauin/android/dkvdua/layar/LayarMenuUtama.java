package org.nauin.android.dkvdua.layar;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import org.nauin.android.dkvdua.DKVDuaMain;
import org.nauin.android.dkvdua.gameobject.AssetLoader;
import org.nauin.android.dkvdua.gamescreen.Game;
import org.nauin.android.dkvdua.gameworld.GameRenderer;
import org.nauin.android.dkvdua.gameworld.GameWorld;
import org.nauin.android.dkvdua.helper.InputHandler;
import org.nauin.android.dkvdua.ui.Tombol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LayarMenuUtama implements Screen {
	private SpriteBatch mSpriteBatch;
	private Sprite mSprite;
	private GameWorld mGameWorld;
	private GameRenderer mGameRenderer;
	private float lebar = Gdx.graphics.getWidth();
	private float tinggi = Gdx.graphics.getHeight();
	private List<Tombol> tombolMenu;

	public LayarMenuUtama() {
		buatLayar();
	}

	public void buatLayar() {
		float gameWidth = 136;
		float gameHeight = tinggi / (lebar / gameWidth);

		mGameWorld = new GameWorld(gameWidth, gameHeight);
		Gdx.input
				.setInputProcessor(new InputHandler(mGameWorld, lebar, tinggi));
		mGameRenderer = new GameRenderer(mGameWorld, gameWidth, gameHeight);
		mSpriteBatch = new SpriteBatch();

		this.tombolMenu = ((InputHandler) Gdx.input.getInputProcessor())
				.getTombolMenu();

		AssetLoader.dkvduaMusicMysteryBox.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		mSpriteBatch.begin();
		mSpriteBatch.draw(AssetLoader.dkvduaMatchUI, 0, 0, lebar, tinggi);
		mSpriteBatch.draw(AssetLoader.dkvduaTitle, 35, 550, 400, 178);

		for (Tombol tombol : tombolMenu) {
			tombol.gambar(mSpriteBatch);
		}

		mSpriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		AssetLoader.dkvduaMusicMysteryBox.pause();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		AssetLoader.dkvduaMusicMysteryBox.dispose();
	}

	private void tombolMenu() {

	}

}
