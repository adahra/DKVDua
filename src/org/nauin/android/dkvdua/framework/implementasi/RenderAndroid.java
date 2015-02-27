/*
 * RenderAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 
 * @author nauin
 *
 */
public class RenderAndroid extends SurfaceView implements Runnable {
	PermainanAndroid permainanAndroid;
	Bitmap penahanBingkai;
	Thread renderThread = null;
	SurfaceHolder surfaceHolder;
	volatile boolean berjalan = false;
	
	public RenderAndroid(PermainanAndroid permainanAndroid, Bitmap penahanBingkai) {
		super(permainanAndroid);
		this.permainanAndroid = permainanAndroid;
		this.penahanBingkai = penahanBingkai;
		this.surfaceHolder = this.getHolder();
		this.setFocusable(true);
		this.setKeepScreenOn(true);
	}

	@Override
	public void run() {
		Rect dstKotak = new Rect();
		long waktuMulai = System.nanoTime();
		while (berjalan) {
			if (!surfaceHolder.getSurface().isValid()) continue;
			float waktuDelta = (System.nanoTime() - waktuMulai) / 1000000000.0F;
			waktuMulai = System.nanoTime();
			
			permainanAndroid.getLayarSekarang().perbarui(waktuDelta);
			permainanAndroid.getLayarSekarang().waktuKini(waktuDelta);
			
			Canvas kanvas = surfaceHolder.lockCanvas();
			kanvas.getClipBounds(dstKotak);
			kanvas.drawBitmap(penahanBingkai, null, dstKotak, null);
			surfaceHolder.unlockCanvasAndPost(kanvas);
		}
	}
	
	public void mulaiLagi() {
		berjalan = true;
		renderThread = new Thread(this);
		renderThread.start();
	}
	
	public void waktuIstirahat() {
		berjalan = false;
		while (true) {
			try {
				renderThread.join();
				// break;
				return;
			} catch (InterruptedException ie) {}
		}
	}

}
