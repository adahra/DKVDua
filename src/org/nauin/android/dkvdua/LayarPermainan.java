/*
 * LayarPermainan.java
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
import java.util.List;
import java.util.Scanner;

import org.nauin.android.dkvdua.framework.Grafik;
import org.nauin.android.dkvdua.framework.Layar;
import org.nauin.android.dkvdua.framework.Masukan.KejadianSentuh;
import org.nauin.android.dkvdua.framework.Permainan;

import android.graphics.Paint;

/**
 * Kelas yang digunakan untuk melakukan penggambaran permainan ke layar,
 * menangani status permainan
 * 
 * @author nauin
 *
 */
public class LayarPermainan extends Layar {
	enum StatusPermainan {
		Siap, Jalan, Selaan, PermainanSelesai
	}

	StatusPermainan status = StatusPermainan.Siap;

	private ArrayList<Ubin> alUbin = new ArrayList<Ubin>();

	private AcakAngka acakAngka;

	private Paint warna;

	/**
	 * @param permainan
	 */
	public LayarPermainan(Permainan permainan) {
		super(permainan);
		// TODO Auto-generated constructor stub
		muatPeta();
		acakAngka = new AcakAngka(9, 1);
		warna = new Paint();
		warna.setARGB(50, 235, 235, 235);
		warna.setTextSize(32);
	}

	@SuppressWarnings("unchecked")
	private void muatPeta() {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		ArrayList alBaris = new ArrayList();
		int lebar = 0;
		int tinggi = 0;

		Scanner scanner = new Scanner(MainActivity.getPeta());
		while (scanner.hasNextLine()) {
			String baris = scanner.nextLine();
			if (baris == null) {
				break;
			}

			if (!baris.startsWith("!")) {
				alBaris.add(baris);
				lebar = Math.max(lebar, baris.length());
			}
		}

		tinggi = alBaris.size();

		for (int j = 0; j < tinggi; j++) {
			String baris = (String) alBaris.get(j);
			for (int i = 0; i < lebar; i++) {
				if (i < baris.length()) {
					char karakter = baris.charAt(i);
					Ubin ubin = new Ubin(i, j,
							Character.getNumericValue(karakter));
					alUbin.add(ubin);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#perbarui(float)
	 */
	@Override
	public void perbarui(float waktuDelta) {
		// TODO Auto-generated method stub
		List<KejadianSentuh> kejadianSentuh = permainan.getMasukan()
				.getKejadianSentuh();
		if (status == StatusPermainan.Siap) {
			perbaruiSiap(kejadianSentuh);
		}

		if (status == StatusPermainan.Jalan) {
			perbaruiJalan(kejadianSentuh, waktuDelta);
		}

		if (status == StatusPermainan.Selaan) {
			perbaruiSelaan(kejadianSentuh);
		}

		if (status == StatusPermainan.PermainanSelesai) {
			perbaruiPermainanSelesai(kejadianSentuh);
		}
	}

	private void perbaruiPermainanSelesai(List<KejadianSentuh> kejadianSentuh) {
		// TODO Auto-generated method stub

	}

	private void perbaruiSelaan(List<KejadianSentuh> kejadianSentuh) {
		// TODO Auto-generated method stub

	}

	private void perbaruiJalan(List<KejadianSentuh> kejadianSentuh,
			float waktuDelta) {
		// TODO Auto-generated method stub

	}

	private void perbaruiSiap(List<KejadianSentuh> kejadianSentuh) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#waktuKini(float)
	 */
	@Override
	public void waktuKini(float waktuDelta) {
		// TODO Auto-generated method stub
		Grafik grafik = permainan.getGrafik();
		grafik.gambarPixmap(ManajemenAset.grafikLBPermainan, 0, 0);
		gambarUbin(grafik);
		gambarAngka(grafik, Integer.toString(acakAngka.getAngkaSatu()), 0, 0);
		gambarAngka(grafik, Integer.toString(acakAngka.getAngkaDua()), 42, 0);

		if (status == StatusPermainan.Siap) {
			gambarSiapUI();
		}

		if (status == StatusPermainan.Jalan) {
			gambarJalanUI();
		}

		if (status == StatusPermainan.Selaan) {
			gambarSelaanUI();
		}

		if (status == StatusPermainan.PermainanSelesai) {
			gambarPermainanSelesaiUI();
		}
	}

	private void gambarPermainanSelesaiUI() {
		// TODO Auto-generated method stub

	}

	private void gambarSelaanUI() {
		// TODO Auto-generated method stub

	}

	private void gambarJalanUI() {
		// TODO Auto-generated method stub

	}

	private void gambarSiapUI() {
		// TODO Auto-generated method stub

	}

	private void gambarUbin(Grafik grafik) {
		// TODO Auto-generated method stub
		for (int i = 0; i < alUbin.size(); i++) {
			Ubin ubin = (Ubin) alUbin.get(i);
			if (ubin.getTipe() != 0) {
				grafik.gambarPixmap(ubin.getGambarUbin(), ubin.getUbinX(),
						ubin.getUbinY());
			}
		}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nauin.android.dkvdua.framework.Layar#tombolKembali()
	 */
	@Override
	public void tombolKembali() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	private boolean dalamKotak(KejadianSentuh kejadian, int x, int y,
			int lebar, int tinggi) {
		if (kejadian.x > x && kejadian.x < x + lebar - 1 && kejadian.y > y
				&& kejadian.y < y + tinggi - 1) {
			return true;
		} else {
			return false;
		}
	}

	private void gambarAngka(Grafik grafik, String baris, int x, int y) {
		int panjang = baris.length();
		for (int i = 0; i < panjang; i++) {
			char karakter = baris.charAt(i);

			if (karakter == ' ') {
				x += 20;
				continue;
			}

			int srcX = 0;
			int srcLebar = 0;
			if (karakter == '.') {
				srcX = 200;
				srcLebar = 10;
			} else {
				srcX = (karakter - '0') * 20;
				srcLebar = 20;
			}

			grafik.gambarPixmap(ManajemenAset.grafikAngka, x, y, srcX, 0,
					srcLebar, 32);
		}
	}

}
