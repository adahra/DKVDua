package org.nauin.android.dkvdua.helper;

import java.util.ArrayList;
import java.util.List;

import org.nauin.android.dkvdua.gameobject.AssetLoader;
import org.nauin.android.dkvdua.gameworld.GameWorld;
import org.nauin.android.dkvdua.ui.Tombol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Kelas yang digunakan untuk menganani inputan/masukan pada aplikasi permainan
 * 
 * @author nauin
 *
 */
public class InputHandler implements InputProcessor {
	private GameWorld myWorld;
	private float scaleFactorX;
	private float scaleFactorY;
	private List<Tombol> tombolMenu;
	private Tombol tombolMulai;
	private Tombol tombolPengaturan;
	private Tombol tombolKeluar;

	public InputHandler(GameWorld myWorld, float scaleFactorX,
			float scaleFactorY) {
		this.myWorld = myWorld;
		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;

		tombolMenu = new ArrayList<Tombol>();
		tombolMulai = new Tombol((Gdx.graphics.getWidth() / 4) - 25,
				(Gdx.graphics.getHeight() / 4) - 25,
				(Gdx.graphics.getWidth() / 4), (Gdx.graphics.getHeight() / 4),
				AssetLoader.dkvduaMatchButtonNormal,
				AssetLoader.dkvduaMatchButtonClick);
		tombolPengaturan = new Tombol((Gdx.graphics.getWidth() / 4) - 25,
				(Gdx.graphics.getHeight() / 4) - 35,
				(Gdx.graphics.getWidth() / 4), (Gdx.graphics.getHeight() / 4),
				AssetLoader.dkvduaMatchButtonNormal,
				AssetLoader.dkvduaMatchButtonClick);
		tombolKeluar = new Tombol((Gdx.graphics.getWidth() / 4) - 25,
				(Gdx.graphics.getHeight() / 4) - 45,
				(Gdx.graphics.getWidth() / 4), (Gdx.graphics.getHeight() / 4),
				AssetLoader.dkvduaMatchButtonNormal,
				AssetLoader.dkvduaMatchButtonClick);
		tombolMenu.add(tombolMulai);
		tombolMenu.add(tombolPengaturan);
		tombolMenu.add(tombolKeluar);
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public List<Tombol> getTombolMenu() {
		return tombolMenu;
	}
}
