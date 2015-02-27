/*
 * LayarPemuat.java
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

import org.nauin.android.dkvdua.framework.Grafik;
import org.nauin.android.dkvdua.framework.Grafik.PixmapFormat;
import org.nauin.android.dkvdua.framework.Layar;
import org.nauin.android.dkvdua.framework.Permainan;

/**
 * Kelas yang digunakan untuk melakukan pemuatan berupa gambar, suara, dan musik
 * 
 * @author nauin
 *
 */
public class LayarPemuat extends Layar {

	/**
	 * @param permainan
	 */
	public LayarPemuat(Permainan permainan) {
		super(permainan);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#perbarui(float)
	 */
	@Override
	public void perbarui(float waktuDelta) {
		// TODO Auto-generated method stub
		Grafik grafik = permainan.getGrafik();
		ManajemenAset.grafikAktorBelakang = grafik.pixmapBaru(
				"gfx/aktor_belakang.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikAktorDepan = grafik.pixmapBaru(
				"gfx/aktor_depan.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikAktorKanan = grafik.pixmapBaru(
				"gfx/aktor_kanan.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikAktorKiri = grafik.pixmapBaru("gfx/aktor_kiri.png",
				PixmapFormat.ARGB4444);
		ManajemenAset.grafikHalangan = grafik.pixmapBaru("gfx/halangan.png",
				PixmapFormat.ARGB4444);
		ManajemenAset.grafikHalanganAtas = grafik.pixmapBaru(
				"gfx/halangan_atas.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikHalanganBawah = grafik.pixmapBaru(
				"gfx/halangan_bawah.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikHalanganTubuh = grafik.pixmapBaru(
				"gfx/halangan_tubuh.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikKunci = grafik.pixmapBaru("gfx/kunci.png",
				PixmapFormat.ARGB4444);
		ManajemenAset.grafikLatarBelakang = grafik.pixmapBaru(
				"gfx/latarbelakang.png", PixmapFormat.RGB565);
		ManajemenAset.grafikLBPermainan = grafik.pixmapBaru(
				"gfx/bgpermainan.png", PixmapFormat.RGB565);
		ManajemenAset.grafikLogo = grafik.pixmapBaru("gfx/logo.png",
				PixmapFormat.ARGB4444);
		ManajemenAset.grafikPintuTerbuka = grafik.pixmapBaru(
				"gfx/pintu_terbuka.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikPintuTertutup = grafik.pixmapBaru(
				"gfx/pintu_tertutup.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikTombol = grafik.pixmapBaru("gfx/tombol.png",
				PixmapFormat.ARGB4444);
		ManajemenAset.grafikTombolDitekan = grafik.pixmapBaru(
				"gfx/tombol_ditekan.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikTombolMulai = grafik.pixmapBaru(
				"gfx/tombolmulai.png", PixmapFormat.ARGB4444);
		ManajemenAset.grafikUbinSatu = grafik.pixmapBaru("gfx/ubin_satu.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinDua = grafik.pixmapBaru("gfx/ubin_dua.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinTiga = grafik.pixmapBaru("gfx/ubin_tiga.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinEmpat = grafik.pixmapBaru("gfx/ubin_empat.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinLima = grafik.pixmapBaru("gfx/ubin_lima.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinEnam = grafik.pixmapBaru("gfx/ubin_enam.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinTujuh = grafik.pixmapBaru("gfx/ubin_tujuh.png",
				PixmapFormat.RGB565);
		ManajemenAset.grafikUbinDelapan = grafik.pixmapBaru(
				"gfx/ubin_delapan.png", PixmapFormat.RGB565);
		ManajemenAset.grafikUbinSembilan = grafik.pixmapBaru(
				"gfx/ubin_sembilan.png", PixmapFormat.RGB565);
		ManajemenAset.grafikAngka = grafik.pixmapBaru("gfx/angka.png",
				PixmapFormat.ARGB4444);

		ManajemenAset.suaraMusuhDatang = permainan.getBunyi().suaraBaru(
				"sfx/monster-come.ogg");
		ManajemenAset.suaraPermainanSelesai = permainan.getBunyi().suaraBaru(
				"sfx/game-over.ogg");
		ManajemenAset.suaraTombol = permainan.getBunyi().suaraBaru(
				"sfx/sfxclick.ogg");

		permainan.setLayar(new LayarMainMenu(permainan));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#waktuKini(float)
	 */
	@Override
	public void waktuKini(float waktuDelta) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#waktuIstirahat()
	 */
	@Override
	public void waktuIstirahat() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#mulaiLagi()
	 */
	@Override
	public void mulaiLagi() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#tutup()
	 */
	@Override
	public void tutup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tombolKembali() {
		// TODO Auto-generated method stub

	}

}
