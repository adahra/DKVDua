/*
 * Grafik.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Interface untuk grafik
 * 
 * @author nauin
 *
 */
public interface Grafik {

	/**
	 * Digunakan untuk mengencode format pixel yang berbeda
	 */
	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}

	/**
	 * Method yang digunakan untuk memuat gambar yang berformat JPEG atau PNG
	 * 
	 * @param namaBerkas
	 *            mendefinisikan, memanggil aset yang ada dalam berkas APK
	 * 
	 * @param format
	 *            mendefinisikan hasil dari PixmapFormat digunakan untuk
	 *            mekanisme pemuatan berkas, hasil dari PixmapFormat mungkin
	 *            tergantung dari perbedaan format digunakan juga untuk
	 *            mengontrol memory untuk memuat gambar
	 */
	public Pixmap pixmapBaru(String namaBerkas, PixmapFormat format);

	/**
	 * Method yang digunakan untuk menghapus warna gambar dari memory
	 * 
	 * @param warna
	 *            semua warna yang digunakan dari pustaka ini menspesifikasikan
	 *            nilai 32-bit ARGB8888
	 */
	public void bersih(int warna);

	/**
	 * Method yang digunakan untuk mengatur pixel dari koordinat (x,y) dalam
	 * memory koordinat diluar layar akan dihiraukan, ini sering disebut
	 * clipping (pemotongan)
	 * 
	 * @param x
	 *            nilai dari x
	 * 
	 * @param y
	 *            nilai dari y
	 * 
	 * @param warna
	 *            warna yang digunakan
	 */
	public void gambarPixel(int x, int y, int warna);

	/**
	 * Method yang dianalogikan sama dengan method gambarPixel(), mendefinisikan
	 * titik awal dan titik akhir dari garis dengan sebuah warna sebuah gambar
	 * raster di luar titik-titik yang didefinisikan akan dihiraukan
	 * 
	 * @param x
	 *            nilai awal dari x
	 * 
	 * @param y
	 *            nilai awal dari y
	 * 
	 * @param x2
	 *            nilai akhir
	 * 
	 * @param y2
	 *            nilai akhir
	 * 
	 * @param warna
	 *            warna yang digunakan
	 */
	public void gambarGaris(int x, int y, int x2, int y2, int warna);

	/**
	 * Method yang digunakan untuk menggambar kotak
	 * 
	 * @param x
	 *            mendefinisikan posisi pojok kiri atas
	 * 
	 * @param y
	 *            mendefinisikan posisi pojok kiri atas
	 * 
	 * @param lebar
	 *            mendefinisikan lebar pixel dari x
	 * 
	 * @param tinggi
	 *            mendefinisikan tinggi pixel dari y
	 * 
	 * @param warna
	 *            digunakan untuk mengisi warna kotak
	 */
	public void gambarKotak(int x, int y, int lebar, int tinggi, int warna);

	/**
	 * Method yang digunakan untuk menggambar kotak pixmap
	 * 
	 * @param pixmap
	 *            mendefinisikan pixmap yang digunakan
	 * @param x
	 *            mendefinisikan koordinat dari posisi pojok kiri atas
	 * @param y
	 *            mendefinisikan koordinat dari posisi pojok kiri atas
	 * @param srcX
	 *            mendefinisikan koordinat dari posisi pojok kiri atas dari
	 *            daerah gambar
	 * @param srcY
	 *            mendefinisikan koordinat dari posisi pojok kiri atas dari
	 *            daerah gambar
	 * @param srcLebar
	 *            mendefinisikan ukuran yang diambil dari pixmap
	 * @param srcTinggi
	 *            mendefinisikan ukuran yang diambil dari pixmap
	 */
	public void gambarPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
			int srcLebar, int srcTinggi);

	/**
	 * Method yang digunakan untuk menggambar kotak pixmap
	 * 
	 * @param pixmap
	 *            mendefinisikan pixmap yang digunakan
	 * @param x
	 *            mendefinisikan koordinat dari posisi pojok kiri atas
	 * @param y
	 *            mendefinisikan koordinat dari posisi pojok kiri atas
	 */
	public void gambarPixmap(Pixmap pixmap, int x, int y);

	/**
	 * Method yang digunakan untuk mengembalikan lebar
	 * 
	 * @return integer
	 */
	public int getLebar();

	/**
	 * Method yang digunakan untuk mengembalikan tinggi
	 * 
	 * @return integer
	 */
	public int getTinggi();

	/**
	 * Method yang digunakan untuk mengembalikan kanvas
	 * 
	 * @return Canvas
	 */
	public Canvas getKanvas();

	/**
	 * Method yang digunakan untuk menggambar warna
	 * 
	 * @param i
	 *            nilai Alpha
	 * @param j
	 *            nilai Red
	 * @param k
	 *            nilai Green
	 * @param l
	 *            nilai Blue
	 */
	public void gambarARGB(int i, int j, int k, int l);

	/**
	 * Method yang digunakan untuk menggambar tulisan ke layar
	 * 
	 * @param teks
	 *            Tulisan
	 * @param x
	 *            Posisi x
	 * @param y
	 *            Posisi y
	 * @param warna
	 *            Warna dari tulisan
	 */
	void gambarTulisan(String teks, int x, int y, Paint warna);

}
