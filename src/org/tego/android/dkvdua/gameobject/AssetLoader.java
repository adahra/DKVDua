/*
 * AssetLoader.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a BlackShadow <adnantoa@gmail.com>
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

package org.tego.android.dkvdua.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Kelas yang menyimpan semua variabel static yang berupa gambar, suara, dan
 * pengaturan yang ada pada layar pengaturan
 * 
 * @author blackshadow
 *
 */
public class AssetLoader {
	public static Texture dkvduaMatchButtonClick;
	public static Texture dkvduaMatchButtonNormal;
	public static Texture dkvduaMatchUI;
	public static Texture dkvduaTitle;
	public static Texture dkvduaPopup;
	public static Texture dkvduaTexture;
	public static Texture dkvduaBasicTile;
	public static Texture dkvduaCharacter;
	public static Texture dkvduaIcon;
	public static Texture dkvduaDead;

	public static TextureRegion gambarPemain;
	public static TextureRegion gambarMusuh;
	public static TextureRegion gambarKotak;
	public static TextureRegion gambarLubang;
	public static TextureRegion gambarUbinKiri;
	public static TextureRegion gambarUbinKanan;
	public static TextureRegion gambarUbinAtas;
	public static TextureRegion gambarUbinBawah;
	public static TextureRegion gambarUbin;
	public static TextureRegion gambarUbinPojokKiriAtas;
	public static TextureRegion gambarUbinPojokKananAtas;
	public static TextureRegion gambarUbinPojokKiriBawah;
	public static TextureRegion gambarUbinPojokKananBawah;

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
		muatGambarUbin();
		antarMuka();
		dengarSuara();
		dengarMusik();
		tampilFont();
		konfigurasi();
	}

	private static void muatGambarUbin() {
		dkvduaTexture = new Texture(
				Gdx.files.internal("data/gfx/dkvduaTextures.png"));
		dkvduaTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		gambarUbin = new TextureRegion(dkvduaTexture, 16, 16, 16, 16);
		gambarUbin.flip(false, true);

		gambarUbinAtas = new TextureRegion(dkvduaTexture, 16, 0, 16, 16);
		gambarUbinAtas.flip(false, true);

		gambarUbinBawah = new TextureRegion(dkvduaTexture, 16, 32, 16, 16);
		gambarUbinBawah.flip(false, true);

		gambarUbinKanan = new TextureRegion(dkvduaTexture, 32, 16, 16, 16);
		gambarUbinKanan.flip(false, true);

		gambarUbinKiri = new TextureRegion(dkvduaTexture, 0, 16, 16, 16);
		gambarUbinKiri.flip(false, true);
		
		gambarUbinPojokKananAtas = new TextureRegion(dkvduaTexture, 32, 0, 16, 16);
		gambarUbinPojokKananAtas.flip(false, true);
		
		gambarUbinPojokKiriAtas = new TextureRegion(dkvduaTexture, 0, 0, 16, 16);
		gambarUbinPojokKiriAtas.flip(false, true);
		
		gambarUbinPojokKananBawah = new TextureRegion(dkvduaTexture, 32, 32, 16, 16);
		gambarUbinPojokKananBawah.flip(false, true);
		
		gambarUbinPojokKiriBawah = new TextureRegion(dkvduaTexture, 0, 32, 16, 16);
		gambarUbinPojokKiriBawah.flip(false, true);
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

		dkvduaPopup = new Texture(
				Gdx.files.internal("data/gfx/dkvduaPopup.png"));
		dkvduaPopup.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
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
		dkvduaPopup.dispose();
		dkvduaTitle.dispose();

		dkvduaTexture.dispose();
		
		dkvduaFont.dispose();
		dkvduaFontShadow.dispose();

		dkvduaMusicMysteryBox.dispose();
	}
}
