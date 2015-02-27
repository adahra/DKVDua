/*
 * SentuhTunggal.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.util.ArrayList;
import java.util.List;

import org.nauin.android.dkvdua.framework.Masukan.KejadianSentuh;
import org.nauin.android.dkvdua.framework.Satukan;
import org.nauin.android.dkvdua.framework.Satukan.SatukanObjek;

import android.view.MotionEvent;
import android.view.View;

/**
 * 
 * @author nauin
 *
 */
public class SentuhTunggal implements PenangananSentuh {
	boolean isTersentuh;
	int sentuhX;
	int sentuhY;
	Satukan<KejadianSentuh> satukanKejadianSentuh;
	List<KejadianSentuh> kejadianSentuh = new ArrayList<KejadianSentuh>();
	List<KejadianSentuh> penahanKejadianSentuh = new ArrayList<KejadianSentuh>();
	float skalaX;
	float skalaY;
	
	public SentuhTunggal(View view, float skalaX, float skalaY) {
		SatukanObjek<KejadianSentuh> pembuatObjek = new SatukanObjek<KejadianSentuh>() {

			@Override
			public KejadianSentuh ciptakanObjek() {
				return new KejadianSentuh();
			}
			
		};
	
		satukanKejadianSentuh = new Satukan<KejadianSentuh>(pembuatObjek, 100);
		view.setOnTouchListener(this);
		
		this.skalaX = skalaX;
		this.skalaY = skalaY;
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		synchronized (this) {
			KejadianSentuh kejadianSentuh = satukanKejadianSentuh.objekBaru();
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				kejadianSentuh.tipe = KejadianSentuh.SENTUH_BAWAH;
				isTersentuh = true;
				break;
			case MotionEvent.ACTION_MOVE:
				kejadianSentuh.tipe = KejadianSentuh.SENTUH_GESER;
				isTersentuh = true;
			case MotionEvent.ACTION_CANCEL:
			case MotionEvent.ACTION_UP:
				kejadianSentuh.tipe = KejadianSentuh.SENTUH_ATAS;
				isTersentuh = false;
			}
			
			kejadianSentuh.x = sentuhX = (int) (event.getX() * skalaX);
			kejadianSentuh.y = sentuhY = (int) (event.getY() * skalaY);
			penahanKejadianSentuh.add(kejadianSentuh);
			
			return true;
		}
	}

	@Override
	public boolean isSentuh(int penunjuk) {
		synchronized (this) {
			if (penunjuk == 0) return isTersentuh;
			else return false;
		}
	}

	@Override
	public int getSentuhX(int penunjuk) {
		synchronized (this) {
			return sentuhX;
		}
	}

	@Override
	public int getSentuhY(int penunjuk) {
		synchronized (this) {
			return sentuhY;
		}
	}

	@Override
	public List<KejadianSentuh> getKejadianSentuh() {
		synchronized (this) {
			int panjang = kejadianSentuh.size();
			for (int i = 0; i < panjang; i++) {
				satukanKejadianSentuh.bebas(kejadianSentuh.get(i));
			}
			
			kejadianSentuh.clear();
			kejadianSentuh.addAll(penahanKejadianSentuh);
			penahanKejadianSentuh.clear();
			
			return kejadianSentuh;
		}
	}

}
