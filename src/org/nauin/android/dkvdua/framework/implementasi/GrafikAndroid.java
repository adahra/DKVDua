/*
 * GrafikAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.io.IOException;
import java.io.InputStream;

import org.nauin.android.dkvdua.framework.Grafik;
import org.nauin.android.dkvdua.framework.Pixmap;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.Style;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GrafikAndroid implements Grafik {
	AssetManager assetManager;
	Bitmap penahanBingkai;
	Canvas kanvas;
	Paint paint;
	Rect srcKotak = new Rect();
	Rect dstKotak = new Rect();

	public GrafikAndroid(AssetManager assetManager, Bitmap penahanBingkai) {
		this.assetManager = assetManager;
		this.penahanBingkai = penahanBingkai;
		this.kanvas = new Canvas(penahanBingkai);
		this.paint = new Paint();
	}

	public Pixmap pixmapBaru(String namaBerkas, PixmapFormat format) {
		Config config = null;
		if (format == PixmapFormat.RGB565)
			config = Config.RGB_565;
		else if (format == PixmapFormat.ARGB4444)
			config = Config.ARGB_4444;
		else
			config = Config.ARGB_8888;

		Options pilihan = new Options();
		pilihan.inPreferredConfig = config;

		InputStream inputStream = null;
		Bitmap bitmap = null;
		try {
			inputStream = assetManager.open(namaBerkas);
			bitmap = BitmapFactory.decodeStream(inputStream);
			if (bitmap == null)
				throw new RuntimeException(
						"Tidak dapat memuat gambar dari aset '" + namaBerkas
								+ "'");
		} catch (IOException ioe) {
			throw new RuntimeException("Tidak dapat memuat gambar dari aset '"
					+ namaBerkas + "'");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ioe) {

				}
			}
		}

		if (bitmap.getConfig() == Config.RGB_565)
			format = PixmapFormat.RGB565;
		else if (bitmap.getConfig() == Config.ARGB_4444)
			format = PixmapFormat.ARGB4444;
		else
			format = PixmapFormat.ARGB8888;

		return new PixelAndroid(bitmap, format);
	}

	public void bersih(int warna) {
		kanvas.drawRGB((warna & 0xff0000) >> 16, (warna & 0xff00) >> 8,
				(warna & 0xff));
	}

	public void gambarPixel(int x, int y, int warna) {
		paint.setColor(warna);
		kanvas.drawPoint(x, y, paint);
	}

	public void gambarGaris(int x, int y, int x2, int y2, int warna) {
		paint.setColor(warna);
		kanvas.drawLine(x, y, x2, y2, paint);
	}

	public void gambarKotak(int x, int y, int lebar, int tinggi, int warna) {
		paint.setColor(warna);
		paint.setStyle(Style.FILL);
		kanvas.drawRect(x, y, x + lebar - 1, y + lebar - 1, paint);
	}

	public void gambarPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
			int srcLebar, int srcTinggi) {
		srcKotak.left = srcX;
		srcKotak.top = srcY;
		srcKotak.right = srcX + srcLebar - 1;
		srcKotak.bottom = srcY + srcTinggi - 1;

		dstKotak.left = x;
		dstKotak.top = y;
		dstKotak.right = x + srcLebar - 1;
		dstKotak.bottom = y + srcTinggi - 1;

		kanvas.drawBitmap(((PixelAndroid) pixmap).bitmap, srcKotak, dstKotak,
				null);
	}

	public void gambarPixmap(Pixmap pixmap, int x, int y) {
		kanvas.drawBitmap(((PixelAndroid) pixmap).bitmap, x, y, null);
	}

	@Override
	public int getLebar() {
		// return kanvas.getWidth();
		return penahanBingkai.getWidth();
	}

	@Override
	public int getTinggi() {
		// return kanvas.getHeight();
		return penahanBingkai.getHeight();
	}

	@Override
	public Canvas getKanvas() {
		return kanvas;
	}

	@Override
	public void gambarARGB(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		paint.setStyle(Style.FILL);
		kanvas.drawARGB(i, j, k, l);
	}

	@Override
	public void gambarTulisan(String teks, int x, int y, Paint warna) {
		// TODO Auto-generated method stub
		kanvas.drawText(teks, x, y, warna);
	}

}
