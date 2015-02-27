/*
 * LayarMainMenu.java
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

import java.util.List;

import org.nauin.android.dkvdua.framework.Grafik;
import org.nauin.android.dkvdua.framework.Layar;
import org.nauin.android.dkvdua.framework.Permainan;
import org.nauin.android.dkvdua.framework.Masukan.KejadianSentuh;

/**
 * Kelas yang digunakan untuk melakukan penggambaran layar menu utama
 * 
 * @author nauin
 *
 */
public class LayarMainMenu extends Layar {
	private boolean pertamaKali = true;

	/**
	 * @param permainan
	 */
	public LayarMainMenu(Permainan permainan) {
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
		@SuppressWarnings("unused")
		Grafik grafik = permainan.getGrafik();
		List<KejadianSentuh> kejadianSentuh = permainan.getMasukan()
				.getKejadianSentuh();

		int panjang = kejadianSentuh.size();
		for (int i = 0; i < panjang; i++) {
			KejadianSentuh kejadian = kejadianSentuh.get(i);
			if (kejadian.tipe == KejadianSentuh.SENTUH_ATAS) {
				if (dalamKotak(kejadian, 96, 96, 128, 32)) {
					if (pertamaKali) {
						ManajemenAset.suaraTombol.mainkan(1f);
						pertamaKali = false;
					}
					
					permainan.setLayar(new LayarPermainan(permainan));
					return;
				}
			}
		}
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
		grafik.gambarPixmap(ManajemenAset.grafikLatarBelakang, 0, 0);
		grafik.gambarPixmap(ManajemenAset.grafikLogo, 32, 32);
		grafik.gambarPixmap(ManajemenAset.grafikTombolMulai, 96, 96);
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
		ManajemenAset.grafikLatarBelakang.tutup();
		ManajemenAset.grafikLogo.tutup();
		ManajemenAset.grafikTombolMulai.tutup();
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

	private boolean dalamKotak(KejadianSentuh kejadian, int x, int y,
			int lebar, int tinggi) {
		if (kejadian.x > x && kejadian.x < x + lebar - 1 && kejadian.y > y
				&& kejadian.y < y + tinggi - 1) {
			return true;
		} else {
			return false;
		}
	}

}
