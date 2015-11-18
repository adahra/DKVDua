/*
 * Dinding.java
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

import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * Kelas yang digunakan untuk mengatur atau menggambar dinding yang digunakan
 * dalam penggambaran game
 * 
 * @author blackshadow
 *
 */
public class Dinding extends Obyek {
	public static final String TAG = Dinding.class.getSimpleName();
	
	private TextureRegion trGambar;

	public static int UBIN_POJOK_KIRI_ATAS = 1;
	public static int UBIN_ATAS = 2;
	public static int UBIN_POJOK_KANAN_ATAS = 3;
	public static int UBIN_KIRI = 4;
	public static int UBIN = 5;
	public static int UBIN_KANAN = 6;
	public static int UBIN_POJOK_KIRI_BAWAH = 7;
	public static int UBIN_BAWAH = 8;
	public static int UBIN_POJOK_KANAN_BAWAH = 9;
	
	public int tipeDinding;
	
	public Dinding(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
	}
	
}
