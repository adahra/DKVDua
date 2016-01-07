/**
 * 
 */
package org.tego.android.dkvdua.utilitas;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * @author blackshadow
 *
 */
public class ManajemenSuara {
	public static final ManajemenSuara manajemen = new ManajemenSuara();
	private Music mainkanMusik;
	
	/**
	 * 
	 */
	private ManajemenSuara() {
		// TODO Auto-generated constructor stub
	}

	public void mainkan(Sound suara) {
		mainkan(suara, 1);
	}
	
	public void mainkan(Music musik) {
		hentikanMusik();
		mainkanMusik = musik;
		
		if (PengaturanGim.pengaturan.musik) {
			mainkanMusik.setLooping(true);
			mainkanMusik.setVolume(PengaturanGim.pengaturan.volumeMusik);
			mainkanMusik.play();
		}
	}
	
	public void hentikanMusik() {
		if (mainkanMusik != null) {
			mainkanMusik.stop();
		}
	}
	
	public void perbaruiPengaturan() {
		if (mainkanMusik == null) {
			return;
		}
		
		mainkanMusik.setVolume(PengaturanGim.pengaturan.volumeMusik);
		
		if (PengaturanGim.pengaturan.musik) {
			if (!mainkanMusik.isPlaying()) {
				mainkanMusik.play();
			}
		} else {
			mainkanMusik.pause();
		}
	}
	
	public void mainkan(Sound suara, float volume) {
		mainkan(suara, volume, 1);
	}
	
	public void mainkan(Sound suara, float volume, float pitch) {
		mainkan(suara, volume, pitch, 0);
	}
	
	public void mainkan(Sound suara, float volume, float pitch, float pan) {
		if (!PengaturanGim.pengaturan.suara) {
			return;
		}
		
		suara.play(PengaturanGim.pengaturan.volumeSuara * volume, pitch, pan);
	}
}
