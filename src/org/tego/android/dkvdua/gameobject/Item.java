/*
 * Item.java
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

import com.badlogic.gdx.math.Vector2;

/**
 * Digunakan untuk mengatur semua konfigurasi dari item yang dijatuhkan oleh
 * Musuh
 * 
 * @author nauin
 *
 */
public class Item {
	protected Vector2 posisi;
	protected int lebar;
	protected int tinggi;
	
	public Item(float x, float y, int lebar, int tinggi) {
		// TODO Auto-generated constructor stub
		posisi = new Vector2(x, y);
		this.lebar = lebar;
		this.tinggi = tinggi;
	}
	
	public void update(float delta) {
		
	}
	
	public void reset() {
		
	}
	
	public void stop() {
		
	}
	
	public float getX() {
		return posisi.x;
	}
	
	public float getY() {
		return posisi.y;
	}
	
	public int getLebar() {
		return lebar;
	}
	
	public int getTinggi() {
		return tinggi;
	}
}
