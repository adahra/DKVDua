/**
 * 
 */
package org.tego.android.dkvdua.game.obyek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author blackshadow
 *
 */
public class Kekayaan {
	public static TextureAtlas textureAtlas;
	public static TextureRegion dindingAtas;
	public static TextureRegion dindingBawah;
	public static TextureRegion dindingKanan;
	public static TextureRegion dindingKananAtas;
	public static TextureRegion dindingKananBawah;
	public static TextureRegion dindingKiri;
	public static TextureRegion dindingKiriAtas;
	public static TextureRegion dindingKiriBawah;
	public static TextureRegion halangan;
	public static TextureRegion halanganAtas;
	public static TextureRegion halanganBawah;
	public static TextureRegion halanganTengah;
	public static TextureRegion hati;
	public static TextureRegion kotak;
	public static TextureRegion lantai;
	public static TextureRegion lubang;
	public static TextureRegion musuhBelakang;
	public static TextureRegion musuhDepan;
	public static TextureRegion musuhKanan;
	public static TextureRegion musuhKiri;
	public static TextureRegion pemain;
	public static TextureRegion pemainBelakang;
	public static TextureRegion pemainKanan;
	public static TextureRegion pemainKiri;
	
	public static void memuat() {
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/gdx/texture/dkvdua-texture.atlas"));
		dindingAtas = textureAtlas.findRegion("dinding-atas");
		dindingBawah = textureAtlas.findRegion("dinding-bawah");
		dindingKanan = textureAtlas.findRegion("dinding-kanan");
		dindingKananAtas = textureAtlas.findRegion("dinding-kanan-atas");
		dindingKananBawah = textureAtlas.findRegion("dinding-kanan-bawah");
		dindingKiri = textureAtlas.findRegion("dinding-kiri");
		dindingKiriAtas = textureAtlas.findRegion("dinding-kiri-atas");
		dindingKiriBawah = textureAtlas.findRegion("dinding-kiri-bawah");
		halangan = textureAtlas.findRegion("halangan");
		halanganAtas = textureAtlas.findRegion("halangan-atas");
		halanganBawah = textureAtlas.findRegion("halangan-bawah");
		halanganTengah = textureAtlas.findRegion("halangan-tengah");
		hati = textureAtlas.findRegion("hati");
		kotak = textureAtlas.findRegion("kotak");
		lantai = textureAtlas.findRegion("lantai");
		lubang = textureAtlas.findRegion("lubang");
		musuhBelakang = textureAtlas.findRegion("musuh-belakang");
		musuhDepan = textureAtlas.findRegion("musuh-depan");
		musuhKanan = textureAtlas.findRegion("musuh-kanan");
		musuhKiri = textureAtlas.findRegion("musuh-kiri");
		pemain = textureAtlas.findRegion("pemain");
		pemainBelakang = textureAtlas.findRegion("pemain-belakang");
		pemainKanan = textureAtlas.findRegion("pemain-kanan");
		pemainKiri = textureAtlas.findRegion("pemain-kiri");
	}
	
	public static void membuang() {
		textureAtlas.dispose();
	}
}
