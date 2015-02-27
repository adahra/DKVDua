/*
 * PenangananSentuh.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.util.List;

import org.nauin.android.dkvdua.framework.Masukan.KejadianSentuh;

import android.view.View.OnTouchListener;

/**
 * 
 * @author nauin
 *
 */
public interface PenangananSentuh extends OnTouchListener {
	
	public boolean isSentuh(int penunjuk);
	
	public int getSentuhX(int penunjuk);
	
	public int getSentuhY(int penunjuk);
	
	public List<KejadianSentuh> getKejadianSentuh();
	
}
