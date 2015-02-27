/*
 * Animasi.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a nauin <adnantoa@gmail.com>
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

package org.nauin.android.dkvdua;

import java.util.ArrayList;

import org.nauin.android.dkvdua.framework.Pixmap;

/**
 * Kelas yang digunakan untuk membuat animasi dari gambar yang ada
 * 
 * @author nauin
 *
 */
public class Animasi {
	@SuppressWarnings("rawtypes")
	private ArrayList bingkai;
	private int bingkaiSekarang;
	private long waktuAnimasi;
	private long durasiTotal;

	/**
	 * Konstruktor kelas
	 */
	@SuppressWarnings("rawtypes")
	public Animasi() {
		// TODO Auto-generated constructor stub
		bingkai = new ArrayList();
		durasiTotal = 0;

		synchronized (this) {
			waktuAnimasi = 0;
			bingkaiSekarang = 0;
		}
	}

	/**
	 * Method yang digunakan untuk menambahkan bingkai ke dalam animasi
	 * 
	 * @param gambar
	 *            Gambar dari animasi
	 * @param durasi
	 *            Durasi bingkai yang ditampilkan
	 */
	@SuppressWarnings("unchecked")
	public synchronized void tambahBingkai(Pixmap gambar, long durasi) {
		durasiTotal += durasi;
		bingkai.add(new BingkaiAnimasi(gambar, durasiTotal));
	}

	/**
	 * Method yang digunakan untuk memperbarui gambar animasi, memperbarui
	 * animasi yang ditampilkan
	 * 
	 * @param waktuBerlalu
	 *            Waktu yang sudah terlewatkan
	 */
	public synchronized void perbarui(long waktuBerlalu) {
		if (bingkai.size() > 1) {
			waktuAnimasi += waktuBerlalu;
			if (waktuAnimasi >= durasiTotal) {
				waktuAnimasi = waktuAnimasi % durasiTotal;
				bingkaiSekarang = 0;
			}

			while (waktuAnimasi > getBingkai(bingkaiSekarang).waktuAkhir) {
				bingkaiSekarang++;
			}
		}
	}

	/**
	 * Method yang digunakan untuk mengambil bingkai dari animasi
	 * 
	 * @param i
	 *            Nilai posisi gambar yang ada pada bingkai
	 * @return Bingkai
	 */
	private BingkaiAnimasi getBingkai(int i) {
		return (BingkaiAnimasi) bingkai.get(i);
	}

	/**
	 * Method yang digunakan untuk mengambil gambar yang ada pada animasi
	 * 
	 * @return Mengambil nilai dari bingkai
	 */
	public synchronized Pixmap getGambar() {
		if (bingkai.size() == 0) {
			return null;
		} else {
			return getBingkai(bingkaiSekarang).gambar;
		}
	}

	/**
	 * Kelas anonimous yang digunakan untuk mengatur bingkai animasi
	 * 
	 * @author nauin
	 *
	 */
	private class BingkaiAnimasi {
		Pixmap gambar;
		long waktuAkhir;

		/**
		 * Konstruktor dari kelas
		 * 
		 * @param gambar
		 *            Gambar yang digunakan untuk animasi
		 * @param waktuAkhir
		 *            Waktu yang digunakan untuk menampilkan gambar perbingkai
		 */
		public BingkaiAnimasi(Pixmap gambar, long waktuAkhir) {
			this.gambar = gambar;
			this.waktuAkhir = waktuAkhir;
		}
	}

}
