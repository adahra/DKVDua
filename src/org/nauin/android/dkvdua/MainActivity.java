/*
 * MainActivity.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a nauin <adnantoa@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.nauin.android.dkvdua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.nauin.android.dkvdua.framework.Layar;
import org.nauin.android.dkvdua.framework.implementasi.PermainanAndroid;

import android.util.Log;

/**
 * Kelas utama dari permainan
 * 
 * @author nauin
 *
 */
public class MainActivity extends PermainanAndroid {
	private static String TAG = "MainActivity";
	private boolean muatMusik = true;
	private static String peta;

	@Override
	public Layar getLayarMulai() {
		if (muatMusik) {
			ManajemenAset.muatMusikMainMenu(this);
			muatMusik = false;
		}
		
		InputStream inputStream = getResources().openRawResource(R.raw.peta);
		setPeta(konversiStreamKeString(inputStream));
		
		return new LayarPemuat(this);
	}

	private String konversiStreamKeString(InputStream inputStream) {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder stringBuilder = new StringBuilder();
		
		String baris = null;
		
		try {
			while ((baris = bufferedReader.readLine()) != null) {
				stringBuilder.append((baris + "\n"));
			}
		} catch (IOException ioe) {
			Log.w(TAG, ioe.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch (IOException ioe) {
				Log.w(TAG, ioe.getMessage());
			}
		}
		
		return stringBuilder.toString();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		ManajemenAset.musikMainMenu.putar();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		ManajemenAset.musikMainMenu.selaan();
	}

	/**
	 * 
	 * @return
	 */
	public static String getPeta() {
		return peta;
	}

	/**
	 * 
	 * @param peta
	 */
	public static void setPeta(String peta) {
		MainActivity.peta = peta;
	}
}
