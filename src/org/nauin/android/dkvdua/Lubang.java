/*
 * Lubang.java
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
 * Kelas yang digunakan untuk membuat lubang yang digunakan untuk keluar monster
 * 
 * @author nauin
 *
 */
public class Lubang {
	private int posisiX;
	private int posisiY;
	private Rect rect;
	private Pixmap gambarLubang;

	/**
	 * 
	 */
	public Lubang(int posisiX, int posisiY) {
		this.setPosisiX(posisiX);
		this.setPosisiY(posisiY);
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
	public Pixmap getGambarLubang() {
		return gambarLubang;
	}

	/**
	 * 
	 * @param gambarLubang
	 */
	public void setGambarLubang(Pixmap gambarLubang) {
		this.gambarLubang = gambarLubang;
	}

}
