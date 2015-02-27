/*
 * Permainan.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Interface permainan yang menyimpan semua fungsi
 * 
 * @author nauin
 *
 */
public interface Permainan {

	/**
	 * Method yang digunakan untuk mengambil masukan
	 * 
	 * @return Masukan
	 */
	public Masukan getMasukan();

	/**
	 * Method yang digunakan untuk mengambil getaran
	 * 
	 * @return Getaran
	 */
	public Getaran getGetaran();

	/**
	 * Method yang digunakan untuk mengambil bunyi
	 * 
	 * @return Bunyi
	 */
	public Bunyi getBunyi();

	/**
	 * Method yang digunakan untuk mengambil berkas
	 * 
	 * @return Berkas
	 */
	public Berkas getBerkas();

	/**
	 * Method yang digunakan untuk mengambil grafik
	 * 
	 * @return Grafik
	 */
	public Grafik getGrafik();

	/**
	 * Method yang digunakan untuk mengatur layar
	 * 
	 * @param layar
	 *            mendefinisikan nilai dari layar yang diatur
	 */
	public void setLayar(Layar layar);

	/**
	 * Method yang digunakan untuk mengambil layar sekarang
	 * 
	 * @return Layar
	 */
	public Layar getLayarSekarang();

	/**
	 * Method yang digunakan untuk mengambil layar mulai
	 * 
	 * @return Layar
	 */
	public Layar getLayarMulai();

}
