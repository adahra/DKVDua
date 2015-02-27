/*
 * Layar.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Kelas abstrak Layar digunakan untuk membuat dan mengatur layar yang tampil
 * 
 * @author nauin
 *
 */
public abstract class Layar {

	/*
	 * Mengakses interface permainan agar dapat memainkan kembali bunyi,
	 * menggambar ke layar, mendapat masukan user, dan membaca dan menulis
	 * berkas
	 */
	protected final Permainan permainan;

	/**
	 * Konstruktor mendapatkan instan dari Permainan agar dapat mendapatkan
	 * akses ke semua subkelas
	 * 
	 * @param permainan
	 *            mendefinisikan nilai yang diambil dari interface Permainan
	 *            agar dapat mengakses semua subkelas Permainan
	 */
	public Layar(Permainan permainan) {
		this.permainan = permainan;
	}

	/**
	 * Method yang digunakan untuk melakukan update posisi layar
	 * 
	 * @param waktuDelta
	 *            mendefinisikan nilai dari waktu
	 */
	public abstract void perbarui(float waktuDelta);

	/**
	 * Method yang digunakan untuk melakukan update posisi layar sekarang
	 * 
	 * @param waktuDelta
	 *            mendefinisikan nilai dari waktu
	 */
	public abstract void waktuKini(float waktuDelta);

	/**
	 * Method yang dipanggil ketika permainan di pause
	 */
	public abstract void waktuIstirahat();

	/**
	 * Method yang dipanggil ketika permainan di resume
	 */
	public abstract void mulaiLagi();

	/**
	 * Method yang digunakan untuk menutup layar dan membuat layar baru, menutup
	 * semua sumber daya yang ada dalam memori
	 */
	public abstract void tutup();

	/**
	 * Method yang digunakan untuk membuat layar kembali ke layar sebelumnya
	 */
	public abstract void tombolKembali();

}
