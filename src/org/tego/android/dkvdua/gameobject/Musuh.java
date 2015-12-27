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
	private static final long serialVersionUID = 315584608560158430L;
	public static final String TAG = Musuh.class.getSimpleName();
	private Angka angka;
	private static int acakAngka;
	private float kecX;
	private float kecY;
	private float rotasi;

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
			this.angka.setY(this.getX());
		}
	}
	
	public void kejarPemain(Obyek pemain, float waktuDelta) {
		int tx = (int) this.getX() - (int) pemain.getX();
		int ty = (int) this.getY() - (int) pemain.getY();
		
		rotasi = (float) (MathUtils.atan2(ty, tx) * 180 / MathUtils.PI);
		kecX = waktuDelta * (90 - Math.abs(rotasi)) / 90;
		
		if (rotasi < 0) {
			kecY = -waktuDelta + Math.abs(kecX);
		} else {
			kecY = waktuDelta - Math.abs(kecX);
		}
		
		this.bergerak((int)kecX, (int)kecY);
	}
}
