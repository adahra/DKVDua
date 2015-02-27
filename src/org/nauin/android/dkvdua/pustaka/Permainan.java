/*
 * Permainan.java
 * 
 * Copyleft 2014 Genius Team
 * Copyleft 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 * 
 * Game pustaka terinspirasi dari http://www.gametutorial.net/
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
package org.nauin.android.dkvdua.pustaka;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Kelas permainan, kelas yang digunakan untuk menggambar permainan yang sedang
 * berjalan, kelas yang digunakan untuk melakukan loading gambar dari game
 * 
 * @author nauin
 *
 */
public class Permainan {
	/**
	 * Digunakan untuk menyimpan berapa lebar layar HandHeld yang digunakan
	 */
	public static int lebarLayar;
	/**
	 * Digunakan untuk menyimpan berapa tinggi layar HandHeld yang digunakan
	 */
	public static int tinggiLayar;
	/**
	 * Digunakan untuk menyimpan berapa kepadatan layar HandHeld yang digunakan
	 */
	public static float kepadatanLayar;

	/**
	 * Konstruktor dari kelas permainan yang digunakan untuk mengatur lebar,
	 * tinggi, dan kepadatan layar. Digunakan juga untuk memuat konten dari
	 * permainan berupa gambar dan suara. Digunakan juga untuk mengatur ulang
	 * permainan yang sedang berjalan
	 */
	public Permainan(int lebarLayar, int tinggiLayar, Resources sumber) {
		// TODO Auto-generated constructor stub
		Permainan.lebarLayar = lebarLayar;
		Permainan.tinggiLayar = tinggiLayar;
		Permainan.kepadatanLayar = sumber.getDisplayMetrics().density;

		this.muatKonten(sumber);

		this.aturPermainan();
	}

	/**
	 * Digunakan untuk melakukan pengaturan dari variabel permainan sebelum
	 * permainan dapat dimulai
	 */
	private void aturPermainan() {
		// TODO Auto-generated method stub

	}

	/**
	 * Digunakan untuk memuat berkas berupa gambar, suara, dan musik
	 * 
	 * @param sumber
	 *            Semua berkas yang ada di dalam direktori res
	 */
	private void muatKonten(Resources sumber) {
		// TODO Auto-generated method stub

	}

	/**
	 * Digunakan untuk memperbarui permainan
	 * 
	 * @param waktuPermainan
	 *            Waktu dari permainan
	 */
	public void perbarui(long waktuPermainan) {
	}

	/**
	 * Digunakan untuk menggambar permainan ke layar
	 * 
	 * @param kanvas
	 *            Kanvas yang digunakan untuk menggambar permainan
	 */
	public void gambar(Canvas kanvas) {
		kanvas.drawColor(Color.BLACK);

	}

	/**
	 * Digunakan untuk melakukan aksi ketika layar disentuh oleh pengguna
	 * 
	 * @param sentuhan
	 *            Sentuhan yang diperoleh
	 */
	public void aksiSentuhBawah(MotionEvent sentuhan) {

	}

	/**
	 * Digunakan untuk melakukan aksi ketika layar disentuh dan digeser oleh
	 * pengguna
	 * 
	 * @param sentuhan
	 *            Sentuhan yang diperoleh
	 */
	public void aksiSentuhGeser(MotionEvent sentuhan) {

	}

	/**
	 * Digunakan untuk melakukan aksi ketika pengguna melepaskan sentuhan dari
	 * layar
	 * 
	 * @param sentuhan
	 *            Sentuhan yang diperoleh
	 */
	public void aksiSentuhAtas(MotionEvent sentuhan) {

	}

}
