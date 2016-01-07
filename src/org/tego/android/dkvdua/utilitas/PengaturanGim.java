/**
 * 
 */
package org.tego.android.dkvdua.utilitas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author blackshadow
 *
 */
public class PengaturanGim {
	public static final PengaturanGim pengaturan = new PengaturanGim();
	public boolean suara;
	public boolean musik;
	public float volumeSuara;
	public float volumeMusik;
	private Preferences pengatur;

	/**
	 * 
	 */
	private PengaturanGim() {
		// TODO Auto-generated constructor stub
		pengatur = Gdx.app.getPreferences("DorKot");
	}

	public void muat() {
		suara = pengatur.getBoolean("suara", true);
		musik = pengatur.getBoolean("musik", true);
		volumeSuara = MathUtils.clamp(pengatur.getFloat("volumeSuara", 0.5f),
				0.0f, 1.0f);
		volumeMusik = MathUtils.clamp(pengatur.getFloat("volumeMusik", 0.5f),
				0.0f, 1.0f);
	}

	public void simpan() {
		pengatur.putBoolean("suara", suara);
		pengatur.putBoolean("musik", musik);
		pengatur.putFloat("volumeSuara", volumeSuara);
		pengatur.putFloat("volumeMusik", volumeMusik);
		pengatur.flush();
	}
}
