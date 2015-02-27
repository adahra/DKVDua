/*
 * ProsesPermainan.java
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

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Kelas yang digunakan untuk melakukan proses pengulangan dari permainan, kelas
 * ini memanggil method perbarui dan gambar dari kelas permainan
 * 
 * @author nauin
 *
 */
public class ProsesPermainan extends Thread {
	/**
	 * Waktu perdetik dari permainan;
	 */
	private final static int FPS_MAKSIMUM = 30;
	/**
	 * Angka maksimum dari FPS yang diloncati
	 */
	private final static int LONCATAN_MAKSIMUM = 5;
	/**
	 * Periode bingkai
	 */
	private final static int PERIODE_BINGKAI = 1000 / FPS_MAKSIMUM;

	/**
	 * Digunakan untuk mengakses fisik surface
	 */
	private SurfaceHolder surfaceHolder;

	private Permainan permainan;

	/**
	 * Waktu permainan dalam mili detik
	 */
	private long waktuPermainan;

	/**
	 * Status dari pengulangan permainan
	 */
	public boolean berjalan;

	/**
	 * Mengatur surface holder dan permainan. Mengatur waktu berjalan dari
	 * permainan
	 * 
	 * @param surfaceHolder
	 *            Memanggil surface holder
	 * @param permainan
	 *            Memanggil permainan agar dimasukkan ke proses pengulangan
	 */
	public ProsesPermainan(SurfaceHolder surfaceHolder, Permainan permainan) {
		// TODO Auto-generated constructor stub
		super();

		this.surfaceHolder = surfaceHolder;
		this.permainan = permainan;

		this.waktuPermainan = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Canvas kanvas;

		// waktu mulai dari proses pengulangan
		long waktuMulai;
		// waktu yang diambil dari proses pengulangan ketika di eksekusi
		long waktuPerbedaan;
		// mili detik untuk tidur
		int waktuTidur;
		// jumlah bingkai yang diloncati
		int loncatanBingkai;

		waktuTidur = 0;

		while (berjalan) {
			kanvas = null;

			try {
				// Mencoba untuk mengunci kanvas untuk pengeditan pixel dalam
				// surface
				kanvas = this.surfaceHolder.lockCanvas();

				synchronized (surfaceHolder) {
					waktuMulai = System.currentTimeMillis();
					// Mengatur ulang loncatan bingkai
					loncatanBingkai = 0;

					this.permainan.perbarui(this.waktuPermainan);
					this.permainan.gambar(kanvas);

					// Mengkalkulasi berapa lama proses pengulangan dilakukan
					waktuPerbedaan = System.currentTimeMillis() - waktuMulai;
					// Mengkalkulasi waktu tidur
					waktuTidur = (int) (PERIODE_BINGKAI - waktuPerbedaan);

					if (waktuTidur > 0) {
						try {
							// Mengirim thread untuk tidur dalam periode pendek
							Thread.sleep(waktuTidur);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}

					while (waktuTidur < 0
							&& loncatanBingkai < LONCATAN_MAKSIMUM) {
						// Perbarui tanpa menggambar ulang layar permainan
						this.permainan.perbarui(this.waktuPermainan);
						waktuTidur += PERIODE_BINGKAI;
						loncatanBingkai++;
					}
					
					this.waktuPermainan += System.currentTimeMillis() - waktuMulai;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (kanvas != null) {
					surfaceHolder.unlockCanvasAndPost(kanvas);
				}
			}
		}
	}

}
