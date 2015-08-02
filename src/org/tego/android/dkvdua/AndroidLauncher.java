package org.tego.android.dkvdua;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Kelas yang digunakan untuk memulai permainan, merupakan kelas utama
 * 
 * @author blackshadow
 *
 */
public class AndroidLauncher extends AndroidApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;
		initialize(new DKVDuaMain(), config);
	}
}
