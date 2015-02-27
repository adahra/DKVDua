/*
 * Suara.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Interface suara yang digunakan untuk memanipulasi suara
 * 
 * @author nauin
 *
 */
public interface Suara {

	/**
	 * Method yang digunakan untuk memainkan suara dengan volume yang ditentukan
	 * 
	 * @param volume
	 *            mengontrol tingkat suara
	 */
	public void mainkan(float volume);

	/**
	 * Method yang digunakan untuk menutup suara
	 */
	public void tutup();

}
