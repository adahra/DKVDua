package org.tego.android.dkvdua;

import org.tego.android.dkvdua.gamescreen.Permainan;
import org.tego.android.dkvdua.layar.LayarMenuUtama;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Kelas utama dari aplikasi
 * 
 * @author blackshadow
 *
 */
public class DKVDuaMain extends Permainan {
	public AssetManager manager = new AssetManager();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tego.android.dkvdua.gamescreen.Permainan#create()
	 */
	@Override
	public void create() {
		PemuatAktiva.load();
		this.setScreen(new LayarMenuUtama(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tego.android.dkvdua.gamescreen.Permainan#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		PemuatAktiva.dispose();
	}
}
