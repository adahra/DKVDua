/*
 * Musik.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Interface yang digunakan untuk memutar efek suara dan musik dari berkas
 * 
 * @author nauin
 *
 */
public interface Musik {

	/**
	 * Method yang digunakan untuk memainkan musik
	 */
	public void putar();

	/**
	 * Method yang digunakan untuk menghentikan musik
	 */
	public void berhenti();

	/**
	 * Method yang digunakan untuk menghentikan musik sejenak
	 */
	public void selaan();

	/**
	 * Method yang digunakan untuk membuat musik dimainkan secara berulang
	 * terus-menerus
	 * 
	 * @param ulang
	 *            mendefinisikan pengulangan dari musik
	 */
	public void setUlang(boolean ulang);

	/**
	 * Method yang digunakan untuk mengatur volume dari musik yang diputar
	 * 
	 * @param volume
	 *            mendefinisikan nilai dari volume, 0 - silent, 1 - maksimum
	 *            volume
	 */
	public void setVolume(float volume);

	/**
	 * Method yang digunakan untuk mengecek apakah musik dimainkan atau tidak
	 * 
	 * @return boolean
	 */
	public boolean isPutar();

	/**
	 * Method yang digunakan untuk mengecek apakah musik berhenti
	 * 
	 * @return boolean
	 */
	public boolean isBerhenti();

	/**
	 * Method yang digunakan untuk mengecek apakah musik berulang atau tidak
	 * 
	 * @return boolean
	 */
	public boolean isUlang();

	/**
	 * Method yang digunakan untuk menutup semua berkas yang dimainkan
	 */
	public void tutup();

	/**
	 * Method yang digunakan untuk mengecek apakah musik sudah dimulai atau
	 * belum
	 */
	void mulaiMencoba();
}
