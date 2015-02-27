/*
 * Bunyi.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

/**
 * Interface yang digunakan untuk memutar suara dan musik dari berkas
 * 
 * @author nauin
 *
 */
public interface Bunyi {

	/**
	 * Instansiasi dari suara yang merepresentasikan suara efek pendek
	 * 
	 * @param namaBerkas
	 *            nama dari berkas yang digunakan
	 * @return Suara
	 */
	public Suara suaraBaru(String namaBerkas);

	/**
	 * Instansiasi dari musik yang merepresentasikan bunyi dari berkas
	 * 
	 * @param namaBerkas
	 *            nama dari berkas yang digunakan
	 * @return Musik
	 */
	public Musik musikBaru(String namaBerkas);

}
