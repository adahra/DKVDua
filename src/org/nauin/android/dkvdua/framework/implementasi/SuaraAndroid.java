/*
 * SuaraAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import org.nauin.android.dkvdua.framework.Suara;

import android.media.SoundPool;

/**
 * 
 * @author nauin
 *
 */
public class SuaraAndroid implements Suara {
	int idSuara;
	SoundPool soundPool;
	
	public SuaraAndroid(SoundPool soundPool, int idSuara) {
		this.idSuara = idSuara;
		this.soundPool = soundPool;
	}

	@Override
	public void mainkan(float volume) {
		soundPool.play(idSuara, volume, volume, 0, 0, 1);
	}

	@Override
	public void tutup() {
		soundPool.unload(idSuara);
	}

}
