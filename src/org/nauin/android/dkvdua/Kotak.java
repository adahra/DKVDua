/*
 * Kotak.java
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
 * Kelas yang digunakan untuk membuat kotak yang akan didorong oleh pemain yang
 * akan digunakan untuk menutup lubang
 * 
 * @author nauin
 *
 */
public class Kotak {
	private int koordinatX;
	private int koordinatY;
	private int gerakAtas;
	private int gerakBawah;
	private int gerakKiri;
	private int gerakKanan;
	private Rect rect;
	private Pixmap gambarKotak;
	
	/**
	 * 
	 */
	public Kotak(int koordinatX, int koordinatY) {
		this.setKoordinatX(koordinatX);
		this.setKoordinatY(koordinatY);
		this.setRect(new Rect(0, 0, 0, 0));
		// this.setGambarKotak();
	}

	/**
	 * 
	 * @return
	 */
	public int getKoordinatX() {
		return koordinatX;
	}

	/**
	 * 
	 * @param koordinatX
	 */
	public void setKoordinatX(int koordinatX) {
		this.koordinatX = koordinatX;
	}

	/**
	 * 
	 * @return
	 */
	public int getKoordinatY() {
		return koordinatY;
	}

	/**
	 * 
	 * @param koordinatY
	 */
	public void setKoordinatY(int koordinatY) {
		this.koordinatY = koordinatY;
	}

	/**
	 * 
	 * @return
	 */
	public int getGerakAtas() {
		return gerakAtas;
	}

	/**
	 * 
	 * @param gerakAtas
	 */
	public void setGerakAtas(int gerakAtas) {
		this.gerakAtas = gerakAtas;
	}

	/**
	 * 
	 * @return
	 */
	public int getGerakBawah() {
		return gerakBawah;
	}

	/**
	 * 
	 * @param gerakBawah
	 */
	public void setGerakBawah(int gerakBawah) {
		this.gerakBawah = gerakBawah;
	}

	/**
	 * 
	 * @return
	 */
	public int getGerakKiri() {
		return gerakKiri;
	}

	/**
	 * 
	 * @param gerakKiri
	 */
	public void setGerakKiri(int gerakKiri) {
		this.gerakKiri = gerakKiri;
	}

	/**
	 * 
	 * @return
	 */
	public int getGerakKanan() {
		return gerakKanan;
	}

	/**
	 * 
	 * @param gerakKanan
	 */
	public void setGerakKanan(int gerakKanan) {
		this.gerakKanan = gerakKanan;
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
	public Pixmap getGambarKotak() {
		return gambarKotak;
	}

	/**
	 * 
	 * @param gambarKotak
	 */
	public void setGambarKotak(Pixmap gambarKotak) {
		this.gambarKotak = gambarKotak;
	}
	
}
