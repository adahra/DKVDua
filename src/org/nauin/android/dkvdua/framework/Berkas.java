/*
 * Berkas.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.SharedPreferences;

/**
 * Interface yang digunakan untuk menulis dan membaca berkas
 * 
 * @author nauin
 *
 */
public interface Berkas {

	/**
	 * Method yang digunakan untuk membaca aset berupa gambar, suara, dan musik
	 * 
	 * @param namaBerkas
	 *            nama dari berkas yang digunakan
	 * @return InputStream
	 * @throws IOException
	 */
	public InputStream bacaAset(String namaBerkas) throws IOException;

	/**
	 * Method yang digunakan untuk membaca file yang dibuat dari kelas ini
	 * 
	 * @param namaBerkas
	 *            nama dari berkas yang digunakan
	 * @return InputStream
	 * @throws IOException
	 */
	public InputStream bacaBerkas(String namaBerkas) throws IOException;

	/**
	 * Method yang digunakan untuk menulis file
	 * 
	 * @param namaBerkas
	 *            nama dari berkas yang digunakan
	 * @return OutputStream
	 * @throws IOException
	 */
	public OutputStream tulisBerkas(String namaBerkas) throws IOException;

	/**
	 * Method yang digunakan untuk mengambil pengaturan yang dipakai aplikasi
	 * 
	 * @return
	 */
	public SharedPreferences getPilihanBersama();

}
