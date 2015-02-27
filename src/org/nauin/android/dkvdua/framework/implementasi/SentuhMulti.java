/*
 * SentuhMulti.java
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
public class SentuhMulti implements PenangananSentuh {
	private static final int MAKS_SENTUH = 10;
	boolean[] isTersentuh = new boolean[MAKS_SENTUH];
	int[] sentuhX = new int[MAKS_SENTUH];
	int[] sentuhY = new int[MAKS_SENTUH];
	int[] id = new int[MAKS_SENTUH];
	Satukan<KejadianSentuh> satukanKejadianSentuh;
	List<KejadianSentuh> kejadianSentuh = new ArrayList<KejadianSentuh>();
	List<KejadianSentuh> penahanKejadianSentuh = new ArrayList<KejadianSentuh>();
	float skalaX;
	float skalaY;

	public SentuhMulti(View view, float skalaX, float skalaY) {
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

	@SuppressWarnings("deprecation")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		synchronized (this) {
			int aksi = event.getAction() & MotionEvent.ACTION_MASK;
			int indeksPenunjuk = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
			// int idPenunjuk = event.getPointerId(indeksPenunjuk);
			int jumlahPenunjuk = event.getPointerCount();
			KejadianSentuh kejadianSentuh;

			for (int i = 0; i < MAKS_SENTUH; i++) {
				if (i >= jumlahPenunjuk) {
					isTersentuh[i] = false;
					id[i] = -1;
					continue;
				}

				int idPenunjuk = event.getPointerId(i);
				if (event.getAction() != MotionEvent.ACTION_MOVE
						&& i != indeksPenunjuk) {
					continue;
				}

				switch (aksi) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_POINTER_DOWN:
					kejadianSentuh = satukanKejadianSentuh.objekBaru();
					kejadianSentuh.tipe = KejadianSentuh.SENTUH_BAWAH;
					kejadianSentuh.penunjuk = idPenunjuk;
					kejadianSentuh.x = sentuhX[i] = (int) (event.getX(i) * skalaX);
					kejadianSentuh.y = sentuhY[i] = (int) (event.getY(i) * skalaY);
					isTersentuh[i] = true;
					id[i] = idPenunjuk;
					penahanKejadianSentuh.add(kejadianSentuh);
					break;
				case MotionEvent.ACTION_UP:
				case MotionEvent.ACTION_POINTER_UP:
				case MotionEvent.ACTION_CANCEL:
					kejadianSentuh = satukanKejadianSentuh.objekBaru();
					kejadianSentuh.tipe = KejadianSentuh.SENTUH_ATAS;
					kejadianSentuh.penunjuk = idPenunjuk;
					kejadianSentuh.x = sentuhX[i] = (int) (event.getX(i) * skalaX);
					kejadianSentuh.y = sentuhY[i] = (int) (event.getY(i) * skalaY);
					isTersentuh[i] = false;
					id[i] = -1;
					penahanKejadianSentuh.add(kejadianSentuh);
					break;
				case MotionEvent.ACTION_MOVE:
					// int jumlahPenunjuk = event.getPointerCount();
					/*
					 * for (int i = 0; i < jumlahPenunjuk; i++) { indeksPenunjuk
					 * = i; idPenunjuk = event.getPointerId(indeksPenunjuk);
					 * 
					 * kejadianSentuh = satukanKejadianSentuh.objekBaru();
					 * kejadianSentuh.tipe = KejadianSentuh.SENTUH_GESER;
					 * kejadianSentuh.penunjuk = idPenunjuk; kejadianSentuh.x =
					 * sentuhX[idPenunjuk] = (int) event.getX(indeksPenunjuk);
					 * kejadianSentuh.y = sentuhY[idPenunjuk] = (int)
					 * event.getY(indeksPenunjuk);
					 * penahanKejadianSentuh.add(kejadianSentuh); }
					 */
					kejadianSentuh = satukanKejadianSentuh.objekBaru();
					kejadianSentuh.penunjuk = idPenunjuk;
					kejadianSentuh.x = sentuhX[i] = (int) (event.getX(i) * skalaX);
					kejadianSentuh.y = sentuhY[i] = (int) (event.getY(i) * skalaY);
					isTersentuh[i] = true;
					id[i] = idPenunjuk;
					penahanKejadianSentuh.add(kejadianSentuh);

					break;
				}
			}

			return true;
		}
	}

	@Override
	public boolean isSentuh(int penunjuk) {
		synchronized (this) {
			int indeks = getIndeks(penunjuk);
			// return (getPenunjukMaksimal() >= 0);
			if (indeks < 0 || indeks >= MAKS_SENTUH)
				return false;
			else
				return isTersentuh[indeks];
		}
	}

	@Override
	public int getSentuhX(int penunjuk) {
		synchronized (this) {
			/*
			 * int penunjuk = getPenunjukMaksimal(); if (penunjuk < 0 ||
			 * penunjuk >= 20) return 0; else return sentuhX[penunjuk];
			 */
			int indeks = getIndeks(penunjuk);
			if (indeks < 0 || indeks >= MAKS_SENTUH)
				return 0;
			else
				return sentuhX[indeks];
		}
	}

	@Override
	public int getSentuhY(int penunjuk) {
		synchronized (this) {
			/*
			 * int penunjuk = getPenunjukMaksimal(); if (penunjuk < 0 ||
			 * penunjuk >= 20) return 0; else return sentuhY[penunjuk];
			 */
			int indeks = getIndeks(penunjuk);
			if (indeks < 0 || indeks >= MAKS_SENTUH)
				return 0;
			else
				return sentuhY[indeks];
		}
	}

	@Override
	public List<KejadianSentuh> getKejadianSentuh() {
		synchronized (this) {
			int panjang = kejadianSentuh.size();
			for (int i = 0; i < panjang; i++)
				satukanKejadianSentuh.bebas(kejadianSentuh.get(i));
			kejadianSentuh.clear();
			kejadianSentuh.addAll(penahanKejadianSentuh);
			penahanKejadianSentuh.clear();

			return kejadianSentuh;
		}
	}

	private int getIndeks(int idPenunjuk) {
		for (int i = 0; i < MAKS_SENTUH; i++) {
			if (id[i] == idPenunjuk) {
				return i;
			}
		}

		return -1;
	}

	@SuppressWarnings("unused")
	private int getPenunjukMaksimal() {
		for (int i = 20 - 1; i >= 0; i--) {
			if (isTersentuh[i])
				return i;
		}

		return -1;
	}
}
