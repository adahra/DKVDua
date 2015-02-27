/*
 * ManajemenAset.java
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

import org.nauin.android.dkvdua.framework.Musik;
import org.nauin.android.dkvdua.framework.Pixmap;
import org.nauin.android.dkvdua.framework.Suara;

/**
 * Kelas yang digunakan untuk menyimpan semua konstanta dari gambar, suara, dan
 * musik
 * 
 * @author nauin
 *
 */
public class ManajemenAset {
	public static Pixmap grafikAktorBelakang;
	public static Pixmap grafikAktorDepan;
	public static Pixmap grafikAktorKanan;
	public static Pixmap grafikAktorKiri;

	public static Pixmap grafikHalangan;
	public static Pixmap grafikHalanganAtas;
	public static Pixmap grafikHalanganBawah;
	public static Pixmap grafikHalanganTubuh;

	public static Pixmap grafikKunci;

	public static Pixmap grafikLatarBelakang;
	public static Pixmap grafikLBPermainan;

	public static Pixmap grafikLogo;

	public static Pixmap grafikPintuTerbuka;
	public static Pixmap grafikPintuTertutup;

	public static Pixmap grafikTombol;
	public static Pixmap grafikTombolDitekan;
	public static Pixmap grafikTombolMulai;

	public static Pixmap grafikUbinSatu;
	public static Pixmap grafikUbinDua;
	public static Pixmap grafikUbinTiga;
	public static Pixmap grafikUbinEmpat;
	public static Pixmap grafikUbinLima;
	public static Pixmap grafikUbinEnam;
	public static Pixmap grafikUbinTujuh;
	public static Pixmap grafikUbinDelapan;
	public static Pixmap grafikUbinSembilan;

	public static Pixmap grafikAngka;

	public static Suara suaraTombol;
	public static Suara suaraTembakan;
	public static Suara suaraMusuhDatang;
	public static Suara suaraPermainanSelesai;

	public static Musik musikMainMenu;
	public static Musik musikDalamPermainan;

	public static void muatMusikMainMenu(MainActivity mainActivity) {
		musikMainMenu = mainActivity.getBunyi().musikBaru("sfx/lonely.ogg");
		musikMainMenu.setUlang(true);
		musikMainMenu.setVolume(1f);
		musikMainMenu.putar();
	}

}
