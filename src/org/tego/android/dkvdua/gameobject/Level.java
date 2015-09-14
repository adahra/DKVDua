/*
 * Level.java
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

import com.badlogic.gdx.math.Rectangle;

/**
 * Kelas yang digunakan untuk menggambar peta level pada permainan
 * 
 * @author blackshadow
 *
 */
public class Level {
	public static final int KOSONG = 0;
	public static final int DINDING = 1;
	public static final int KOTAK = 2;
	public static final int LUBANG = 3;
	public static final int LEBAR = 12;
	public static final int TINGGI = 20;
	public static final int UKURAN_UBIN = 16;
	public int[][] data = new int[LEBAR][TINGGI];
	public Rectangle kotak;
	
	
	public Level() {
		// TODO Auto-generated constructor stub
		kotak = new Rectangle();
		
		for (int y = 0; y < TINGGI; y++) {
			data[0][y] = DINDING;
			data[LEBAR - 1][y] = DINDING;
		}
		
		for (int x = 0; x < LEBAR; x++) {
			if ((x > 0) && (x < LEBAR - 1)) {
				data[x][10] = KOSONG;
			}
			
			data[x][2] = DINDING;
			data[x][4] = DINDING;
			data[x][6] = DINDING;
			data[x][8] = DINDING;
			
			data[x][0] = DINDING;
			data[x][TINGGI - 1] = DINDING;
		}
		
		data[10][2] = KOSONG;
		data[1][4] = KOSONG;
		data[10][6] = KOSONG;
	}
	
	public void update(float delta) {
		
	}
	
	public boolean halangan(float x, float y) {
		if (data[(int) x][(int) y] == DINDING) {
			return true;
		} else if (data[(int) x][(int) y] == KOTAK) {
			return true;
		} else if (data[(int) x][(int) y] == LUBANG) {
			return true;
		} else {
			return false;
		}
	}
}
