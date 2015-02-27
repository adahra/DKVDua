/*
 * BunyiAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.io.IOException;

import org.nauin.android.dkvdua.framework.Bunyi;
import org.nauin.android.dkvdua.framework.Musik;
import org.nauin.android.dkvdua.framework.Suara;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

public class BunyiAndroid implements Bunyi {
	AssetManager assetManager;
	SoundPool soundPool;
	
	public BunyiAndroid(Activity activity) {
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		this.assetManager = activity.getAssets();
		this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
	}

	public Musik musikBaru(String namaBerkas) {
		try {
			AssetFileDescriptor assetDescriptor = assetManager.openFd(namaBerkas);
			return new MusikAndroid(assetDescriptor);
		} catch (IOException ioe) {
			throw new RuntimeException("Tidak dapat memuat musik '" +namaBerkas+ "'");
		}
	}
	
	@Override
	public Suara suaraBaru(String namaBerkas) {
		try {
			AssetFileDescriptor assetFileDescriptor = assetManager.openFd(namaBerkas);
			int idSuara = soundPool.load(assetFileDescriptor, 0);
			return new SuaraAndroid(soundPool, idSuara);
		} catch (IOException ioe) {
			throw new RuntimeException("Tidak dapat memuat suara \"" +namaBerkas+ "\"");
		}
	}

}
