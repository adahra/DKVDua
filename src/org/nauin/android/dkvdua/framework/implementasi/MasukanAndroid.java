/*
 * MasukanAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.util.List;

import org.nauin.android.dkvdua.framework.Masukan;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

public class MasukanAndroid implements Masukan {
	PenangananOrientasi penangananOrientasi;
	PenangananKeyboard penangananKeyboard;
	PenangananSentuh penangananSentuh;
	
	@SuppressWarnings("deprecation")
	public MasukanAndroid(Context context, View view, float skalaX, float skalaY) {
		penangananOrientasi = new PenangananOrientasiAndroid(context);
		penangananKeyboard = new PenangananKeyboard(view);
		if (Integer.parseInt(VERSION.SDK) < 5) penangananSentuh = new SentuhTunggal(view, skalaX, skalaY);
		else penangananSentuh = new SentuhMulti(view, skalaX, skalaY);
	}

	@Override
	public boolean isTombolDiTekan(int kodeTombol) {
		return penangananKeyboard.isTombolDiTekan(kodeTombol);
	}

	@Override
	public boolean isDiSentuh(int penunjuk) {
		return penangananSentuh.isSentuh(penunjuk);
	}

	@Override
	public int getSentuhX(int penunjuk) {
		return penangananSentuh.getSentuhX(penunjuk);
	}

	@Override
	public int getSentuhY(int penunjuk) {
		return penangananSentuh.getSentuhY(penunjuk);
	}

	@Override
	public float getAzimut() {
		return penangananOrientasi.getAzimuth();
	}

	@Override
	public List<KunciKejadian> getKunciKejadian() {
		return penangananKeyboard.getKunciKejadian();
	}

	@Override
	public List<KejadianSentuh> getKejadianSentuh() {
		return penangananSentuh.getKejadianSentuh();
	}

}
