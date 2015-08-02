package org.tego.android.dkvdua.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Kelas yang digunakan untuk membuat tombol pada menu
 * 
 * @author blackshadow
 *
 */
public class Tombol {
	private float x;
	private float y;
	private float lebar;
	private float tinggi;

	private Texture tombolNormal;
	private Texture tombolDiTekan;

	private Rectangle kotak;

	private boolean isDiTekan = false;

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param x
	 *            Posisi x dari tombol
	 * @param y
	 *            Posisi y dari tombol
	 * @param lebar
	 *            Lebar tombol
	 * @param tinggi
	 *            Tinggi tombol
	 * @param tombolNormal
	 *            Gambar ketika tombol tidak ditekan
	 * @param tombolDiTekan
	 *            Gambar ketika tombol ditekan
	 */
	public Tombol(float x, float y, float lebar, float tinggi,
			Texture tombolNormal, Texture tombolDiTekan) {
		this.x = x;
		this.y = y;
		this.lebar = lebar;
		this.tinggi = tinggi;
		this.tombolNormal = tombolNormal;
		this.tombolDiTekan = tombolDiTekan;

		kotak = new Rectangle(x, y, lebar, tinggi);
	}

	/**
	 * Method yang digunakan untuk mengetahui apakah tombol ditekan atau tidak
	 * 
	 * @param layarX
	 *            Posisi x dari sentuhan layar
	 * @param layarY
	 *            Posisi y dari sentuhan layar
	 * @return kotak
	 */
	public boolean isDiTekan(int layarX, int layarY) {
		return kotak.contains(layarX, layarY);
	}

	/**
	 * Method yang digunakan untuk membuat/mengatur gambar dari tombol
	 * 
	 * @param batcher
	 *            Gambar dari tombol
	 */
	public void gambar(SpriteBatch batcher) {
		if (isDiTekan) {
			batcher.draw(tombolDiTekan, x, y, lebar, tinggi);
		} else {
			batcher.draw(tombolNormal, x, y, lebar, tinggi);
		}
	}

	/**
	 * Method yang digunakan untuk mengetahui tombol ditekan terus
	 * 
	 * @param layarX
	 *            Posisi x dari sentuhan layar
	 * @param layarY
	 *            Posisi y dari sentuhan layar
	 * @return
	 */
	public boolean isTouchDown(int layarX, int layarY) {
		if (kotak.contains(layarX, layarY)) {
			isDiTekan = true;
			return false;
		}

		return false;
	}

	/**
	 * Method yang digunakan untuk mengetahui apakah tombol dilepas atau masih
	 * ditekan
	 * 
	 * @param layarX
	 *            Posisi x dari sentuhan layar
	 * @param layarY
	 *            Posisi y dari sentuhan layar
	 * @return
	 */
	public boolean isTouchUp(int layarX, int layarY) {
		if (kotak.contains(layarX, layarY)) {
			isDiTekan = false;
			return true;
		}

		isDiTekan = false;
		return false;
	}
}
