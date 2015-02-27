/*
 * Pixmap.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

import org.nauin.android.dkvdua.framework.Grafik.PixmapFormat;

/**
 * Interface Pixmap
 * 
 * @author nauin
 *
 */
public interface Pixmap {

	/**
	 * Method yang digunakan untuk mengembalikan nilai lebar dari pixmap ke
	 * pixel
	 * 
	 * @return integer
	 */
	public int getLebar();

	/**
	 * Method yang digunakan untuk mengembalikan nilai tinggi dari pixmap ke
	 * pixel
	 * 
	 * @return integer
	 */
	public int getTinggi();

	/**
	 * Method yang digunakan untuk mengembalikan nilai dari PixelFormat yang
	 * disimpan di RAM
	 * 
	 * @return PixmapFormat
	 */
	public PixmapFormat getFormat();

	/**
	 * Method yang digunakan untuk menutup semua gambar yang sudah tidak dipakai
	 * lagi agar tidak memberatkan memori
	 */
	public void tutup();

}
