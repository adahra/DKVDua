/*
 * PermainanAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import org.nauin.android.dkvdua.framework.Berkas;
import org.nauin.android.dkvdua.framework.Bunyi;
import org.nauin.android.dkvdua.framework.Getaran;
import org.nauin.android.dkvdua.framework.Grafik;
import org.nauin.android.dkvdua.framework.Layar;
import org.nauin.android.dkvdua.framework.Masukan;
import org.nauin.android.dkvdua.framework.Permainan;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

/**
 * 
 * @author nauin
 *
 */
public class PermainanAndroid extends Activity implements Permainan {
	RenderAndroid renderAndroid;
	Grafik grafik;
	Bunyi bunyi;
	Masukan masukan;
	Berkas berkas;
	Getaran getaran;
	Layar layar;
	WakeLock wakeLock;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		
		int penahanBingkaiLebar = isLandscape ? 380 : 320;
		int penahanBingkaiTinggi = isLandscape ? 320 : 380;
		
		// int penahanBingkaiLebar = getWindowManager().getDefaultDisplay().getWidth();
		// int penahanBingkaiTinggi = getWindowManager().getDefaultDisplay().getHeight();
		
		// Bitmap penahanBingkai = Bitmap.createBitmap(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(), Config.RGB_565);
		Bitmap penahanBingkai = Bitmap.createBitmap(penahanBingkaiLebar, penahanBingkaiTinggi, Config.RGB_565);
		
		float skalaX = (float) penahanBingkaiLebar / getWindowManager().getDefaultDisplay().getWidth();
		float skalaY = (float) penahanBingkaiTinggi / getWindowManager().getDefaultDisplay().getHeight();
		
		renderAndroid = new RenderAndroid(this, penahanBingkai);
		grafik = new GrafikAndroid(getAssets(), penahanBingkai);
		berkas = new BerkasAndroid(this);
		bunyi = new BunyiAndroid(this);
		masukan = new MasukanAndroid(this, renderAndroid, skalaX, skalaY);
		// masukan = new MasukanAndroid(this, renderAndroid, penahanBingkaiLebar, penahanBingkaiTinggi);
		layar = getLayarMulai();
		setContentView(renderAndroid);
		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "NauiNGame");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		wakeLock.acquire();
		layar.mulaiLagi();
		renderAndroid.mulaiLagi();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		wakeLock.release();
		renderAndroid.waktuIstirahat();
		layar.waktuIstirahat();
		if (isFinishing()) layar.tutup();
	}
	
	@Override
	public Masukan getMasukan() {
		return masukan;
	}

	@Override
	public Getaran getGetaran() {
		return getaran;
	}

	@Override
	public Bunyi getBunyi() {
		return bunyi;
	}

	@Override
	public Berkas getBerkas() {
		return berkas;
	}

	@Override
	public Grafik getGrafik() {
		return grafik;
	}

	@Override
	public void setLayar(Layar layar) {
		if (layar == null) throw new IllegalArgumentException("Layar tidak boleh null");
		this.layar.waktuIstirahat();
		this.layar.tutup();
		layar.mulaiLagi();
		layar.perbarui(0);
		this.layar = layar;
	}

	@Override
	public Layar getLayarSekarang() {
		return layar;
	}

	@Override
	public Layar getLayarMulai() {
		return layar;
	}

}
