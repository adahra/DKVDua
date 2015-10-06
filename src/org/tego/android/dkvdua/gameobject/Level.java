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

import org.tego.android.dkvdua.game.Assets;
import org.tego.android.dkvdua.game.WorldRenderer;
import org.tego.android.dkvdua.gameobject.Dinding.TipeDinding;
import org.tego.android.dkvdua.gameworld.GameWorld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Kelas yang digunakan untuk menggambar peta level pada permainan
 * 
 * @author blackshadow
 *
 */
public class Level {
	public static final int KOSONG = 0;

	public static final int DINDING_KIRI_ATAS = 1;
	public static final int DINDING_ATAS = 2;
	public static final int DINDING_KANAN_ATAS = 3;
	public static final int DINDING_KIRI = 4;
	public static final int DINDING = 5;
	public static final int DINDING_KANAN = 6;
	public static final int DINDING_KIRI_BAWAH = 7;
	public static final int DINDING_BAWAH = 8;
	public static final int DINDING_KANAN_BAWAH = 9;

	public static final int KOTAK = 10;
	public static final int LUBANG = 11;

	public static final int LEBAR = 12;
	public static final int TINGGI = 20;
	public static final int UKURAN_UBIN = 16;

	public int[][] data = new int[LEBAR][TINGGI];

	public Rectangle kotak;

	private Dinding dinding;
	
	public int lebarLayar;
	public int tinggiLayar;
	private WorldRenderer worldRenderer;

	public Level(WorldRenderer worldRenderer) {
		this.worldRenderer = worldRenderer;
		
		init();
		
		gambarLevel();
	}
	
	public Level(GameWorld duniaGim, int lebarDuniaGim, int tinggiDuniaGim) {
		// TODO Auto-generated constructor stub
		init();
		
		lebarLayar = lebarDuniaGim;
		tinggiLayar = lebarDuniaGim;

		gambarLevel();
	}

	private void init() {
		kotak = new Rectangle();
		dinding = new Dinding();
	}
	
	public void update(float delta) {

	}

	private void gambarLevel() {
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
		data[1][8] = KOSONG;
	}
	
	private void tampilPetaLevel(SpriteBatch batcher) {
		for (int x = 0; x < LEBAR; x++) {
			for (int y = 0; y < TINGGI; y++) {
				switch (data[x][y]) {
				case DINDING:
					batcher.draw(AssetLoader.dkvduaTexture, x * UKURAN_UBIN, y
							* UKURAN_UBIN);
					break;
				case KOSONG:
					batcher.draw(AssetLoader.dkvduaTexture, x * UKURAN_UBIN, y
							* UKURAN_UBIN);
					break;
				default:
					break;
				}
			}
		}
	}

	public void render(SpriteBatch batch) {
		tampilPetaLevel(batch);
	}
	
	public boolean halangan(float x, float y) {
		switch (data[(int) x][(int) y]) {
		case DINDING_KIRI_ATAS:
			return true;
		case DINDING_ATAS:
			return true;
		case DINDING_KANAN_ATAS:
			return true;
		case DINDING_KIRI:
			return true;
		case DINDING:
			return true;
		case DINDING_KANAN:
			return true;
		case DINDING_KIRI_BAWAH:
			return true;
		case DINDING_BAWAH:
			return true;
		case DINDING_KANAN_BAWAH:
			return true;
		case KOTAK:
			return true;
		case LUBANG:
			return true;
		default:
			return false;
		}
	}
}
