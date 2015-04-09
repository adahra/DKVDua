package org.nauin.android.dkvdua;

import org.nauin.android.dkvdua.gameobject.AssetLoader;
import org.nauin.android.dkvdua.gamescreen.Game;

public class DKVDuaMain extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(getScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
