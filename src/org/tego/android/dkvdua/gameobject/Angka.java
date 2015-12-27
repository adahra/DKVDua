/*
 * Angka.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a BlackShadow <adnantoa@gmail.com>
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

package org.tego.android.dkvdua.gameobject;

/**
 * Kelas yang digunakan untuk mengatur tampilan dan digunakan untuk menjatuhkan
 * item atau angka ketika musuh musnah
 * 
 * @author blackshadow
 *
 */
public class Angka extends Obyek {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3871739236764210722L;
	public static final String TAG = Angka.class.getSimpleName();
	public static final int SATU = 1;
	public static final int DUA = 2;
	public static final int TIGA = 3;
	public static final int EMPAT = 4;
	public static final int LIMA = 5;
	public static final int ENAM = 6;
	public static final int TUJUH = 7;
	public static final int DELAPAN = 8;
	public static final int SEMBILAN = 9;
	private int angka = 0;
	private int tipeAngka;

	public Angka(int x, int y, int tipeAngka) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public int getTipeAngka() {
		return this.tipeAngka;
	}

	public int getAngka() {
		return this.angka;
	}

	public void setTipeAngka(int tipeAngka) {
		this.tipeAngka = tipeAngka;
	}

	public void setAngka(int angka) {
		this.angka = angka;
	}
}
