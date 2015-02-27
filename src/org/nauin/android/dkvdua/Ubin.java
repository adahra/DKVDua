/*
 * Ubin.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a nauin <adnantoa@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.nauin.android.dkvdua;

import org.nauin.android.dkvdua.framework.Pixmap;

import android.graphics.Rect;

/**
 * Kelas yang digunakan untuk membuat peta ubin dan menampilkannya ke layar
 * 
 * @author nauin
 *
 */
public class Ubin {
	private int ubinX;
	private int ubinY;

	private int tipe;
	private Pixmap gambarUbin;
	
	private Rect rect;

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param x
	 *            Posisi x dari ubin
	 * @param y
	 *            Posisi y dari ubin
	 * @param tipe
	 *            Tipe dari ubin
	 */
	public Ubin(int x, int y, int tipe) {
		// TODO Auto-generated constructor stub
		ubinX = x * 16;
		ubinY = y * 16;

		this.tipe = tipe;

		
		// Cek tipe dari semua bentuk ubin
		if (this.tipe == 1) {
			gambarUbin = ManajemenAset.grafikUbinSatu;
		} else if (this.tipe == 2) {
			gambarUbin = ManajemenAset.grafikUbinDua;
		} else if (this.tipe == 3) {
			gambarUbin = ManajemenAset.grafikUbinTiga;
		} else if (this.tipe == 4) {
			gambarUbin = ManajemenAset.grafikUbinEmpat;
		} else if (this.tipe == 5) {
			gambarUbin = ManajemenAset.grafikUbinLima;
		} else if (this.tipe == 6) {
			gambarUbin = ManajemenAset.grafikUbinEnam;
		} else if (this.tipe == 7) {
			gambarUbin = ManajemenAset.grafikUbinTujuh;
		} else if (this.tipe == 8) {
			gambarUbin = ManajemenAset.grafikUbinDelapan;
		} else if (this.tipe == 9) {
			gambarUbin = ManajemenAset.grafikUbinSembilan;
		} else {
			this.tipe = 0;
		}
	}

	/**
	 * Method yang digunakan untuk mengambil posisi x dari ubin
	 * 
	 * @return Posisi ubin x
	 */
	public int getUbinX() {
		return ubinX;
	}

	/**
	 * Method yang digunakan untuk mengatur posisi x dari ubin
	 * 
	 * @param ubinX
	 *            Nilai dari x
	 */
	public void setUbinX(int ubinX) {
		this.ubinX = ubinX;
	}

	/**
	 * Method yang digunakan untuk mengambil posisi y dari ubin
	 * 
	 * @return Posisi dari ubin y
	 */
	public int getUbinY() {
		return ubinY;
	}

	/**
	 * Method yang digunakan untuk mengatur posisi y dari ubin
	 * 
	 * @param ubinY
	 *            Nilai dari y
	 */
	public void setUbinY(int ubinY) {
		this.ubinY = ubinY;
	}

	/**
	 * Method yang digunakan untuk mengambil gambar ubin
	 * 
	 * @return Gambar ubin
	 */
	public Pixmap getGambarUbin() {
		return gambarUbin;
	}

	/**
	 * Method yang digunakan untuk mengatur gambar ubin
	 * 
	 * @param gambarUbin
	 *            Gambar ubin yang ada
	 */
	public void setGambarUbin(Pixmap gambarUbin) {
		this.gambarUbin = gambarUbin;
	}

	/**
	 * 
	 * @return
	 */
	public Rect getRect() {
		return rect;
	}

	/**
	 * 
	 * @param rect
	 */
	public void setRect(Rect rect) {
		this.rect = rect;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTipe() {
		return tipe;
	}
	
	/**
	 * 
	 * @param tipe
	 */
	public void setTipe(int tipe) {
		this.tipe = tipe;
	}
	
}
