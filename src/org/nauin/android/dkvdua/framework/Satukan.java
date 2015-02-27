/*
 * Satukan.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas yang digunakan untuk membuat obyek yang digunakan untuk menyatukan
 * obyek lain
 * 
 * @author nauin
 *
 * @param <T>
 *            obyek
 */
public class Satukan<T> {

	/**
	 * Interface yang digunakan untuk menyatukan obyek membuat obyek yang dapat
	 * dimanipulasi
	 * 
	 * @author nauin
	 *
	 * @param <T>
	 *            obyek
	 */
	public interface SatukanObjek<T> {

		/**
		 * Method yang digunakan untuk menciptakan obyek
		 * 
		 * @return T
		 */
		public T ciptakanObjek();
	}

	// Ketika obyek bebas belum dimanipulasi
	private final List<T> bebaskanObjek;
	// Ketika obyek sudah dibuat/dimanipulasi
	private final SatukanObjek<T> pabrikObjek;
	private final int ukuranMaksimal; // Ukuran maksimal dari obyek yang dibuat

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param pabrikObjek
	 *            mendefinisikan nilai dari pabrik objek
	 * @param ukuranMaksimal
	 *            mendefinisikan nilai dari ukuran maksimal
	 */
	public Satukan(SatukanObjek<T> pabrikObjek, int ukuranMaksimal) {
		this.pabrikObjek = pabrikObjek; // Mengatur nilai pabrikObjek
		this.ukuranMaksimal = ukuranMaksimal; // Mengatur nilai maksimal
		// Membuat obyek baru
		this.bebaskanObjek = new ArrayList<T>(ukuranMaksimal);
	}

	/**
	 * Method yang digunakan untuk membuat obyek baru
	 * 
	 * @return objek
	 */
	public T objekBaru() {
		T objek = null; // Membuat obyek bernilai null

		// Cek ukuran dari obyek bebas, apakah sama dengan nol
		if (bebaskanObjek.size() == 0) {
			objek = pabrikObjek.ciptakanObjek(); // Ciptakan obyek baru
		} else { // Jika tidak
			// Hapus obyek yang ada dan kurangi satu
			objek = bebaskanObjek.remove(bebaskanObjek.size() - 1);
		}

		return objek; // Kembalikan ke obyek
	}

	/**
	 * Method yang digunakan untuk membebaskan obyek
	 * 
	 * @param objek
	 *            mendefinisikan nilai dari obyek
	 */
	public void bebas(T objek) {
		// Cek jika ukuran obyek kurang dari ukuran maksimal
		if (bebaskanObjek.size() < ukuranMaksimal) {
			bebaskanObjek.add(objek); // Tambah obyek
		}
	}
}
