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

/**
 * Kelas yang digunakan untuk mengatur pemain, menampilkan pemain, pergerakan
 * pemain, dan ketika pemain melakukan kontak dengan musuh
 * 
 * @author blackshadow
 *
 */
public class Pemain extends Obyek {
	private float x;
	private float y;
	private Texture pemainAtas;
	private Texture pemainBawah;
	private Texture pemainKiri;
	private Texture pemainKanan;
	public static int V_WIDTH = 800;
	public static int V_HEIGHT = 480;
	public static int VIEWPORT_WIDTH = 312;
	public static int VIEWPORT_HEIGHT = 192;

	public Pemain() {
		x = VIEWPORT_WIDTH / 2;
		y = VIEWPORT_HEIGHT / 2;

		muatGambarPemain();
	}

	public void update(float delta) {

	}

	public void render(SpriteBatch spriteBatch) {
		spriteBatch.draw(pemainAtas, x, y);
	}

	public void muatGambarPemain() {

	}

	/*
	 * (non-Javadoc)
	 * @see org.tego.android.dkvdua.gameobject.Obyek#bergerak(int, int)
	 */
	@Override
	public void bergerak(int x, int y) {
		// TODO Auto-generated method stub
		super.bergerak(x, y);
	}
}
