/*
 * Lubang.java
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

import org.tego.android.dkvdua.utilitas.AssetLoader;

/**
 * Kelas yang digunakan untuk mengatur gambar lubang yang ada pada permainan dan
 * untuk mengatur tata letak dari lubang dimana musuh keluar
 * 
 * @author blackshadow
 *
 */
public class Lubang extends Obyek {
	public static final String TAG = Lubang.class.getSimpleName();
	
	public Lubang(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setTrGambar(AssetLoader.gambarLubang);
	}
}
