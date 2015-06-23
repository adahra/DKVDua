package org.nauin.android.dkvdua;

import org.nauin.android.dkvdua.gameobject.AssetLoader;
import org.nauin.android.dkvdua.gamescreen.Game;
import org.nauin.android.dkvdua.gamescreen.LayarPermainan;

/**
 * Kelas utama dari aplikasi
 * 
 * @author nauin
 *
 */
public class DKVDuaMain extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new LayarPermainan());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
