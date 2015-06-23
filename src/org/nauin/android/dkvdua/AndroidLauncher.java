package org.nauin.android.dkvdua;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Kelas yang digunakan untuk memulai permainan, merupakan kelas utama
 * 
 * @author nauin
 *
 */
public class AndroidLauncher extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;
		// initialize(new DKVDuaMain(), config);
		initialize(new SuperKoalio(), config);
	}
}
