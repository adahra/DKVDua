package org.tego.android.dkvdua.game;

import org.tego.android.dkvdua.utilitas.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {
	public static final String TAG = Assets.class.getSimpleName();
	public static final Assets instance = new Assets();

	private AssetManager assetManager;

	public AssetDinding dinding;
	public AssetHalangan halangan;
	public AssetHati hati;
	public AssetKotak kotak;
	public AssetLantai lantai;
	public AssetLubang lubang;
	public AssetMusuh musuh;
	public AssetPemain pemain;
	public AssetFonts huruf;

	private Assets() {
		// TODO Auto-generated constructor stub
	}

	public void init(AssetManager assetManager) {
		this.assetManager = assetManager;
		assetManager.setErrorListener(this);
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		assetManager.finishLoading();

		Gdx.app.debug(TAG, "# aset termuat: "
				+ assetManager.getAssetNames().size);
		for (String string : assetManager.getAssetNames()) {
			Gdx.app.debug(TAG, "aset: " + string);
		}

		TextureAtlas textureAtlas = assetManager
				.get(Constants.TEXTURE_ATLAS_OBJECTS);

		huruf = new AssetFonts();
		dinding = new AssetDinding(textureAtlas);
		halangan = new AssetHalangan(textureAtlas);
		hati = new AssetHati(textureAtlas);
		kotak = new AssetKotak(textureAtlas);
		lantai = new AssetLantai(textureAtlas);
		lubang = new AssetLubang(textureAtlas);
		musuh = new AssetMusuh(textureAtlas);
		pemain = new AssetPemain(textureAtlas);
	}

	public class AssetDinding {
		public final AtlasRegion dindingAtas;
		public final AtlasRegion dindingBawah;
		public final AtlasRegion dindingKanan;
		public final AtlasRegion dindingKananAtas;
		public final AtlasRegion dindingKananBawah;
		public final AtlasRegion dindingKiri;
		public final AtlasRegion dindingKiriAtas;
		public final AtlasRegion dindingKiriBawah;

		public AssetDinding(TextureAtlas textureAtlas) {
			dindingAtas = textureAtlas.findRegion("dinding-atas");
			dindingBawah = textureAtlas.findRegion("dinding-bawah");
			dindingKanan = textureAtlas.findRegion("dinding-kanan");
			dindingKananAtas = textureAtlas.findRegion("dinding-kanan-atas");
			dindingKananBawah = textureAtlas.findRegion("dinding-kanan-bawah");
			dindingKiri = textureAtlas.findRegion("dinding-kiri");
			dindingKiriAtas = textureAtlas.findRegion("dinding-kiri-atas");
			dindingKiriBawah = textureAtlas.findRegion("dinding-kiri-bawah");
		}
	}

	public class AssetHalangan {
		public final AtlasRegion halangan;
		public final AtlasRegion halanganAtas;
		public final AtlasRegion halanganBawah;
		public final AtlasRegion halanganTengah;

		public AssetHalangan(TextureAtlas textureAtlas) {
			halangan = textureAtlas.findRegion("halangan");
			halanganAtas = textureAtlas.findRegion("halangan-atas");
			halanganBawah = textureAtlas.findRegion("halangan-bawah");
			halanganTengah = textureAtlas.findRegion("halangan-tengah");
		}
	}

	public class AssetHati {
		public final AtlasRegion hati;

		public AssetHati(TextureAtlas textureAtlas) {
			hati = textureAtlas.findRegion("hati");
		}
	}

	public class AssetKotak {
		public final AtlasRegion kotak;

		public AssetKotak(TextureAtlas textureAtlas) {
			kotak = textureAtlas.findRegion("kotak");
		}
	}

	public class AssetLantai {
		public final AtlasRegion lantai;

		public AssetLantai(TextureAtlas textureAtlas) {
			lantai = textureAtlas.findRegion("lantai");
		}
	}

	public class AssetLubang {
		public final AtlasRegion lubang;

		public AssetLubang(TextureAtlas textureAtlas) {
			lubang = textureAtlas.findRegion("lubang");
		}
	}

	public class AssetMusuh {
		public final AtlasRegion musuhBelakang;
		public final AtlasRegion musuhDepan;
		public final AtlasRegion musuhKanan;
		public final AtlasRegion musuhKiri;

		public AssetMusuh(TextureAtlas textureAtlas) {
			musuhBelakang = textureAtlas.findRegion("musuh-belakang");
			musuhDepan = textureAtlas.findRegion("musuh-depan");
			musuhKanan = textureAtlas.findRegion("musuh-kanan");
			musuhKiri = textureAtlas.findRegion("musuh-kiri");
		}
	}

	public class AssetPemain {
		public final AtlasRegion pemain;
		public final AtlasRegion pemainBelakang;
		public final AtlasRegion pemainKanan;
		public final AtlasRegion pemainKiri;

		public AssetPemain(TextureAtlas textureAtlas) {
			pemain = textureAtlas.findRegion("pemain");
			pemainBelakang = textureAtlas.findRegion("pemain-belakang");
			pemainKanan = textureAtlas.findRegion("pemain-kanan");
			pemainKiri = textureAtlas.findRegion("pemain-kiri");
		}
	}

	public class AssetFonts {
		public final BitmapFont hurufKecil;
		public final BitmapFont hurufNormal;
		public final BitmapFont hurufBesar;

		public AssetFonts() {
			hurufKecil = new BitmapFont(
					Gdx.files.internal("data/gfx/font/dkvduafont/default.fnt"),
					true);
			hurufNormal = new BitmapFont(
					Gdx.files.internal("data/gfx/font/dkvduafont/default.fnt"),
					true);
			hurufBesar = new BitmapFont(
					Gdx.files.internal("data/gfx/font/dkvduafont/default.fnt"),
					true);

			hurufKecil.setScale(0.75f);
			hurufNormal.setColor(1.0f);
			hurufBesar.setScale(2.0f);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub
		Gdx.app.error(TAG, "Tidak dapat memuat aset " + asset + "'",
				(Exception) throwable);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		assetManager.dispose();
		huruf.hurufBesar.dispose();
		huruf.hurufKecil.dispose();
		huruf.hurufNormal.dispose();
	}

}
