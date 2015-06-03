package org.nauin.android.dkvdua.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Tombol {
	private float x;
	private float y;
	private float lebar;
	private float tinggi;
	
	private Texture tombolNormal;
	private Texture tombolDiTekan;
	
	private Rectangle kotak;
	
	private boolean isDiTekan = false;
	
	public Tombol(float x, float y, float lebar, float tinggi, Texture tombolNormal, Texture tombolDiTekan) {
		this.x = x;
		this.y = y;
		this.lebar = lebar;
		this.tinggi = tinggi;
		this.tombolNormal = tombolNormal;
		this.tombolDiTekan = tombolDiTekan;
		
		kotak = new Rectangle(x, y, lebar, tinggi);
	}
	
	public boolean isDiTekan(int layarX, int layarY) {
		return kotak.contains(layarX, layarY);
	}
	
	public void gambar(SpriteBatch batcher) {
		if (isDiTekan) {
			batcher.draw(tombolDiTekan, x, y, lebar, tinggi);
		} else {
			batcher.draw(tombolNormal, x, y, lebar, tinggi);
		}
	}

	public boolean isTouchDown(int layarX, int layarY) {
		if (kotak.contains(layarX, layarY)) {
			isDiTekan = true;
			return false;
		}
		
		return false;
	}
	
	public boolean isTouchUp(int layarX, int layarY) {
		if (kotak.contains(layarX, layarY)) {
			isDiTekan = false;
			return true;
		}
		
		isDiTekan = false;
		return false;
	}
}
