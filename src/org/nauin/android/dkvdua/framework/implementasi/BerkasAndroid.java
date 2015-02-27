/*
 * BerkasAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.nauin.android.dkvdua.framework.Berkas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;

/**
 * 
 * @author nauin
 *
 */
public class BerkasAndroid implements Berkas {
	Context context;
	AssetManager assetManager;
	String path;

	public BerkasAndroid(Context context) {
		// this.assetManager = assetManager;
		this.context = context;
		this.assetManager = context.getAssets();
		this.path = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator;
	}

	@Override
	public InputStream bacaAset(String namaBerkas) throws IOException {
		return assetManager.open(namaBerkas);
	}

	@Override
	public InputStream bacaBerkas(String namaBerkas) throws IOException {
		return new FileInputStream(path + namaBerkas);
	}

	@Override
	public OutputStream tulisBerkas(String namaBerkas) throws IOException {
		return new FileOutputStream(path + namaBerkas);
	}

	@Override
	public SharedPreferences getPilihanBersama() {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

}
