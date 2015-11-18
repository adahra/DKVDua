/*
 * Pemain.java
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
 * Kelas yang digunakan untuk mengatur pemain, menampilkan pemain, pergerakan
 * pemain, dan ketika pemain melakukan kontak dengan musuh
 * 
 * @author blackshadow
 *
 */
public class Pemain extends Obyek {
	public static final String TAG = Pemain.class.getSimpleName();

	public Pemain(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub

	}

	public void bergerak(int x, int y) {
		int nx = (int) this.getPosisiX() + x;
		int ny = (int) this.getPosisiY() + y;
		this.setPosisiX(nx);
		this.setPosisiY(ny);
	}
	
	public void tembakMusuh() {
		
	}
}
