/*
 * Musuh.java
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
 * Kelas yang digunakan untuk membuat musuh, membuat pergerakan musuh,
 * menampilkan musuh yang keluar dari lubang
 * 
 * @author nauin
 *
 */
public class Musuh {
	private int posisiX;
	private int posisiY;
	private int gerakAtas;
	private int gerakBawah;
	private int gerakKiri;
	private int gerakKanan;
	private int nyawa;
	private int tembakan;
	private Rect rect;
	private Pixmap gambarMusuh;
	
	/**
	 * 
	 * @param posisiX
	 * @param posisiY
	 * @param nyawa
	 * @param tembakan
	 */
	public Musuh(int posisiX, int posisiY, int nyawa, int tembakan) {
		this.setPosisiX(posisiX);
		this.setPosisiY(posisiY);
		this.setNyawa(nyawa);
		this.setTembakan(tembakan);
		this.setRect(new Rect(0, 0, 0, 0));
	}

	/**
	 * 
	 * @return
	 */
	public int getPosisiX() {
		return posisiX;
	}

	/**
	 * 
	 * @param posisiX
	 */
	public void setPosisiX(int posisiX) {
		this.posisiX = posisiX;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosisiY() {
		return posisiY;
	}

	/**
	 * 
	 * @param posisiY
	 */
	public void setPosisiY(int posisiY) {
		this.posisiY = posisiY;
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
	public int getNyawa() {
		return nyawa;
	}

	/**
	 * 
	 * @param nyawa
	 */
	public void setNyawa(int nyawa) {
		this.nyawa = nyawa;
	}

	/**
	 * 
	 * @return
	 */
	public int getTembakan() {
		return tembakan;
	}

	/**
	 * 
	 * @param tembakan
	 */
	public void setTembakan(int tembakan) {
		this.tembakan = tembakan;
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
	public Pixmap getGambarMusuh() {
		return gambarMusuh;
	}

	/**
	 * 
	 * @param gambarMusuh
	 */
	public void setGambarMusuh(Pixmap gambarMusuh) {
		this.gambarMusuh = gambarMusuh;
	}

}
