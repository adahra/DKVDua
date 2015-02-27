/*
 * PanelPermainan.java
 * 
 * Copyleft 2014 Genius Team
 * Copyleft 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 * 
 * Game pustaka terinspirasi dari http://www.gametutorial.net/
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
package org.nauin.android.dkvdua.pustaka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Kelas yang digunakan untuk berhubungan dengan surface untuk menggambar dan
 * sentuhan
 * 
 * @author nauin
 *
 */
public class PanelPermainan extends SurfaceView implements
		SurfaceHolder.Callback {
	private Permainan permainan;
	private ProsesPermainan prosesPermainan;

	public PanelPermainan(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		// Focus harus pada PanelPermainan supaya event bisa di dapat
		this.setFocusable(true);
		// Untuk membajak event pada surface
		this.getHolder().addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mulaiPermainan();
	}

	private void mulaiPermainan() {
		// TODO Auto-generated method stub
		permainan = new Permainan(getWidth(), getHeight(), getResources());

		prosesPermainan = new ProsesPermainan(this.getHolder(), permainan);
		prosesPermainan.berjalan = true;
		prosesPermainan.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		prosesPermainan.berjalan = false;

		// Matikan proses pengulangan permainan secara bersih
		boolean cobaLagi = true;
		while (cobaLagi) {
			try {
				prosesPermainan.join();
				cobaLagi = false;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// Untuk multi touch MotionEventCompat.getActionMasked(event);
		int aksi = event.getAction();

		if (aksi == MotionEvent.ACTION_DOWN) {
			permainan.aksiSentuhBawah(event);
		}

		if (aksi == MotionEvent.ACTION_MOVE) {
			permainan.aksiSentuhGeser(event);
		}

		if (aksi == MotionEvent.ACTION_UP) {
			permainan.aksiSentuhAtas(event);
		}

		return true;
	}

}
