package org.nauin.android.dkvdua.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Kelas yang menyimpan semua variabel static yang berupa gambar, suara, dan
 * pengaturan yang ada pada layar pengaturan
 * 
 * @author nauin
 *
 */
public class AssetLoader {
	public static Texture dkvduaMatchButtonClick;
	public static Texture dkvduaMatchButtonNormal;
	public static Texture dkvduaMatchUI;
	public static Texture dkvduaTitle;

	public static BitmapFont dkvduaFont;
	public static BitmapFont dkvduaFontShadow;

	public static Sound dkvduaSoundClick;
	public static Sound dkvduaSoundExplode;
	public static Sound dkvduaSoundGameOver;
	public static Sound dkvduaSoundLaser;
	public static Sound dkvduaSoundMonsterCome;
	public static Sound dkvduaSoundPickItem;

	public static Music dkvduaMusicHappyEnding;
	public static Music dkvduaMusicKremKaakkuja;
	public static Music dkvduaMusicLonely;
	public static Music dkvduaMusicMysteryBox;

	public static Preferences pengaturan;

	public static void load() {
		antarMuka();
		dengarSuara();
		dengarMusik();
		tampilFont();
		konfigurasi();
	}

	private static void antarMuka() {
		dkvduaMatchUI = new Texture(
				Gdx.files.internal("data/gfx/dkvduaMatchUI.png"));
		dkvduaMatchUI.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		dkvduaMatchButtonNormal = new Texture(
				Gdx.files.internal("data/gfx/dkvduaMatchButtonNormal.png"));
		dkvduaMatchButtonNormal.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);

		dkvduaMatchButtonNormal = new Texture(
				Gdx.files.internal("data/gfx/dkvduaMatchButtonClick.png"));
		dkvduaMatchButtonNormal.setFilter(TextureFilter.Nearest,
				TextureFilter.Nearest);

		dkvduaTitle = new Texture(
				Gdx.files.internal("data/gfx/dkvduaTitle.png"));
		dkvduaTitle.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
	}

	private static void dengarSuara() {
		dkvduaSoundClick = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaClick.ogg"));
		dkvduaSoundExplode = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaExplode.ogg"));
		dkvduaSoundGameOver = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaGameOver.ogg"));
		dkvduaSoundLaser = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaLaser.ogg"));
		dkvduaSoundMonsterCome = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaMonsterCome.ogg"));
		dkvduaSoundPickItem = Gdx.audio.newSound(Gdx.files
				.internal("data/sfx/dkvduaPickItem.ogg"));
	}

	private static void dengarMusik() {
		dkvduaMusicHappyEnding = Gdx.audio.newMusic(Gdx.files
				.internal("data/sfx/dkvduaHappyEnding.ogg"));
		dkvduaMusicKremKaakkuja = Gdx.audio.newMusic(Gdx.files
				.internal("data/sfx/dkvduaKremKaakkuja.ogg"));
		dkvduaMusicLonely = Gdx.audio.newMusic(Gdx.files
				.internal("data/sfx/dkvduaLonely.ogg"));
		dkvduaMusicMysteryBox = Gdx.audio.newMusic(Gdx.files
				.internal("data/sfx/dkvduaMysteryBox.ogg"));
		dkvduaMusicMysteryBox.setLooping(true);
	}

	private static void tampilFont() {
		dkvduaFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/dkvduafont/text.fnt"));
		dkvduaFont.setScale(.25f, -.25f);

		dkvduaFontShadow = new BitmapFont(
				Gdx.files.internal("data/gfx/font/dkvduafont/shadow.fnt"));
		dkvduaFontShadow.setScale(.25f, -.25f);
	}

	private static void konfigurasi() {
		pengaturan = Gdx.app.getPreferences("DKVDUA");

		if (!pengaturan.contains("dkvduaMusic")) {
			pengaturan.putBoolean("dkvduaMusic", true);
		}

		if (!pengaturan.contains("dkvduaSound")) {
			pengaturan.putBoolean("dkvduaSound", true);
		}
	}

	public static void setMusik(boolean nilai) {
		pengaturan.putBoolean("dkvduaMusic", nilai);
		pengaturan.flush();
	}

	public static boolean getMusik() {
		return pengaturan.getBoolean("dkvduaMusic");
	}

	public static void setSuara(boolean nilai) {
		pengaturan.putBoolean("dkvduaSound", nilai);
		pengaturan.flush();
	}

	public static boolean getSuara() {
		return pengaturan.getBoolean("dkvduaSound");
	}

	public static void dispose() {
		// dkvduaMatchButtonClick.dispose();
		// dkvduaMatchButtonNormal.dispose();
		dkvduaMatchUI.dispose();
		dkvduaTitle.dispose();

		dkvduaFont.dispose();
		dkvduaFontShadow.dispose();

		/*
		 * dkvduaSoundClick.dispose(); dkvduaSoundExplode.dispose();
		 * dkvduaSoundGameOver.dispose(); dkvduaSoundLaser.dispose();
		 * dkvduaSoundMonsterCome.dispose(); dkvduaSoundPickItem.dispose();
		 */

		/*
		 * dkvduaMusicHappyEnding.dispose(); dkvduaMusicKremKaakkuja.dispose();
		 * dkvduaMusicLonely.dispose(); dkvduaMusicMysteryBox.dispose();
		 */
		dkvduaMusicMysteryBox.dispose();
	}
}
