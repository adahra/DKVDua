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

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

/**
 * Kelas yang digunakan untuk mengatur pemain, menampilkan pemain, pergerakan
 * pemain, dan ketika pemain melakukan kontak dengan musuh
 * 
 * @author blackshadow
 *
 */
public class Pemain extends Obyek {
	
	private Rectangle kotakPemain;
	private Level level;
	private float ukuran = 0.3f;
	private float sudut;

	public Pemain(float x, float y, int lebar, int tinggi, float kecepatan) {
		super(x, y, lebar, tinggi, kecepatan);
		kotakPemain = new Rectangle();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		super.update(delta);
		kotakPemain.set(posisi.x, posisi.y, lebar, tinggi);
	}
	
	@Override
	public void reset(float posisiXBaru, float posisiYBaru) {
		// TODO Auto-generated method stub
		super.reset(posisiXBaru, posisiYBaru);
		
	}
	
	public Rectangle getKotakPemain() {
		return kotakPemain;
	}
	
	@Override
	public boolean bergerak(int posisiDX, int posisiDY) {
		// TODO Auto-generated method stub
		super.bergerak(posisiDX, posisiDY);
		float nx = posisi.x + posisiDX;
		float ny = posisi.x + posisiDY;
		
		if (lokasiValid(nx, ny)) {
			posisi.x = nx;
			posisi.y = ny;
			
			sudut = (float) (MathUtils.atan2(posisiDX, posisiDY) - (MathUtils.PI / 2));
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean lokasiValid(float posisiNX, float posisiNY) {
		// TODO Auto-generated method stub
		if (level.halangan(posisiNX - ukuran, posisiNY - ukuran)) {
			return false;
		} else if (level.halangan(posisiNX + ukuran, posisiNY - ukuran)) {
			return false;
		} else if (level.halangan(posisiNX - ukuran, posisiNY + ukuran)) {
			return false;
		} else if (level.halangan(posisiNX + ukuran, posisiNY + ukuran)) {
			return false;
		} else {
			return true;
		}
	}
}
