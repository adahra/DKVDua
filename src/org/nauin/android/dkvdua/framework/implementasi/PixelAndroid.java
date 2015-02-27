/*
 * PixelAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import org.nauin.android.dkvdua.framework.Pixmap;
import org.nauin.android.dkvdua.framework.Grafik.PixmapFormat;

import android.graphics.Bitmap;

/**
 * 
 * @author nauin
 *
 */
public class PixelAndroid implements Pixmap{
	Bitmap bitmap;
	PixmapFormat format;
	
	public PixelAndroid(Bitmap bitmap, PixmapFormat format) {
		this.bitmap = bitmap;
		this.format = format;
	}
	
	public int getLebar() {
		return bitmap.getWidth();
	}
	
	public int getTinggi() {
		return bitmap.getHeight();
	}
	
	public PixmapFormat getFormat() {
		return format;
	}
	
	public void tutup() {
		bitmap.recycle();
	}
}
