package org.nauin.android.dkvdua;

import org.nauin.android.dkvdua.gameobject.AssetLoader;
import org.nauin.android.dkvdua.gamescreen.Game;
import org.nauin.android.dkvdua.layar.LayarMenuUtama;

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
		setScreen(new LayarMenuUtama(this));
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
