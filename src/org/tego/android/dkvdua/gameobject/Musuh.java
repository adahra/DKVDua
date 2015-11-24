/*
 * Musuh.java
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

import com.badlogic.gdx.math.MathUtils;

/**
 * Kelas yang digunakan untuk menangani pergerakah musuh, penampakan musuh, dan
 * semua kecerdasan yang ada pada musuh
 * 
 * @author blackshadow
 *
 */
public class Musuh extends Obyek {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5548666305239189785L;
	public static final String TAG = Musuh.class.getSimpleName();
	private Angka angka;
	private static int acakAngka;

	public Musuh(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void bergerak(int x, int y) {
		int nx = (int) this.getX() + x;
		int ny = (int) this.getY() + y;
		this.setX(nx);
		this.setY(ny);
	}

	public void jatuhkanAngka() {
		acakAngka = MathUtils.random(1, 50);
		if (acakAngka < 1) {
			this.angka.setX(this.getX());
			this.angka.setY(this.getY());
		}
	}
}
