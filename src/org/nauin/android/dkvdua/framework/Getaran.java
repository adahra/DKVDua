/*
 * Getaran.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Interface getaran, digunakan untuk mengatur getaran
 * 
 * @author nauin
 *
 */
public interface Getaran {

	/**
	 * Method yang digunakan untuk membuat getar
	 * 
	 * @param waktu
	 *            Mendefinisikan nilai dari waktu yang digunakan untuk
	 *            menggetarkan
	 */
	public void getar(int waktu);

}
