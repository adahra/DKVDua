/*
 * AcakAngka.java
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

import java.util.Random;

/**
 * Kelas yang digunakan untuk mengacak angka yang akan dimunculkan pada layar
 * permainan
 * 
 * @author nauin
 *
 */
public class AcakAngka {
	private int maks; // Batas maksimal angka
	private int min; // Batas minimal angka
	private Random rAcak; // Variabel random
	private int angkaSatu; // Angka satu
	private int angkaDua; // Angka dua

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param maks
	 *            Nilai maksimal angka
	 * @param min
	 *            Nilai minimum angka
	 */
	public AcakAngka(int maks, int min) {
		this.maks = maks;
		this.min = min;
		this.angkaAcak();
	}

	/**
	 * Method yang digunakan untuk mengatur nilai maksimal angka
	 * 
	 * @param maks
	 *            Nilai maksimal
	 */
	public void setMaks(int maks) {
		this.maks = maks;
	}

	/**
	 * Method yang digunakan untuk mengambil nilai maksimal
	 * 
	 * @return Nilai maksimal
	 */
	public int getMaks() {
		return this.maks;
	}

	/**
	 * Method yang digunakan untuk mengatur nilai minimal
	 * 
	 * @param min
	 *            Nilai minimal
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * Method yang digunakan untuk mengambil nilai minimal
	 * 
	 * @return Nilai minimal
	 */
	public int getMin() {
		return this.min;
	}

	/**
	 * Method yang digunakan untuk mengambil nilai angka satu
	 * 
	 * @return Nilai angka satu
	 */
	public int getAngkaSatu() {
		return this.angkaSatu;
	}

	/**
	 * Method yang digunakan untuk mengambil nilai angka dua
	 * 
	 * @return Nilai angka dua
	 */
	public int getAngkaDua() {
		return this.angkaDua;
	}

	/*
	 * Method yang digunakan untuk melakukan pengacakan nilai yang didapatkan
	 * dari nilai maksimal dan nilai minimal
	 */
	private void angkaAcak() {
		this.rAcak = new Random();
		this.angkaSatu = this.rAcak.nextInt(this.maks) + this.min;
		this.angkaDua = this.rAcak.nextInt(this.maks) + this.min;
	}

}
