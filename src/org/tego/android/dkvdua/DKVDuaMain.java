package org.tego.android.dkvdua;

import org.tego.android.dkvdua.gameobject.AssetLoader;
import org.tego.android.dkvdua.gamescreen.Game;
import org.tego.android.dkvdua.gamescreen.LayarPermainan;
import org.tego.android.dkvdua.layar.UISimpleTest;

/**
 * Kelas utama dari aplikasi
 * 
 * @author blackshadow
 *
 */
public class DKVDuaMain extends Game {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.gamescreen.Game#create()
	 */
	@Override
	public void create() {
		AssetLoader.load();
		// setScreen(new LayarMenuUtama());
		setScreen(new UISimpleTest());
		// setScreen(new LayarPermainan());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.gamescreen.Game#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
