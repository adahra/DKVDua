/*
 * LevelGenerator.java
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

import java.util.ArrayList;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.layar.LayarAbstrak;
import org.tego.android.dkvdua.layar.LayarDialogKalah;
import org.tego.android.dkvdua.layar.LayarDialogMenang;
import org.tego.android.dkvdua.layar.LayarMenuUtama;
import org.tego.android.dkvdua.utilitas.MetodePengacakan;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Kelas yang digunakan untuk membuat level pada permainan
 * 
 * @author blackshadow
 *
 */
public class PembuatArena extends LayarAbstrak {
	public static final String TAG = PembuatArena.class.getSimpleName();

	private int lebarLayar;
	private int tinggiLayar;

	private int lebarDuniaGim;
	private int tinggiDuniaGim;

	public final int UKURAN_UBIN = 16;
	public final int TABRAKAN_KIRI = 1;
	public final int TABRAKAN_KANAN = 2;
	public final int TABRAKAN_ATAS = 3;
	public final int TABRAKAN_BAWAH = 4;

	private final ArrayList<Kotak> aKotak = new ArrayList<Kotak>();
	private final ArrayList<Musuh> aMusuh = new ArrayList<Musuh>();
	private final ArrayList<Lubang> aLubang = new ArrayList<Lubang>();
	private final ArrayList<Dinding> aDinding = new ArrayList<Dinding>();
	private final ArrayList<Lantai> aLantai = new ArrayList<Lantai>();
	private final ArrayList<Angka> aAngka = new ArrayList<Angka>();

	private Pemain pemain;
	private Dinding dinding;
	private Kotak kotak;
	private Lubang lubang;
	private Lantai lantai;
	private Musuh musuh;

	private boolean kotakSelesai = false;
	private boolean pemainDiAtasLubang = false;
	private boolean tombolDiTekan = false;
	private boolean jawabanBenar = false;

	private int nilaiSatu;
	private int nilaiDua;
	// private int angkaAcakSatu;
	// private int angkaAcakDua;
	private int hasil;

	private OrthographicCamera camera;
	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;
	private LabelStyle labelStyle;
	private Label lblPertanyaan;
	private TextFieldStyle textFieldStyle;
	private TextField txtJawaban;
	private InputMultiplexer inputMultiplexer;
	private BitmapFont bitmapFont;
	private Skin skin;
	private Table table;
	private Table tTable;
	private Texture textureTextField;
	private Stage stage;

	public int[][] petaLevel = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 },
			{ 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9 } };

	public int[][] obyek = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public PembuatArena(DKVDuaMain game) {
		super(game);
		init();
	}

	/*
	 * public PembuatArena(DuniaPermainan duniaGim, int lebarDuniaGim, int
	 * tinggiDuniaGim) { setDuniaGim(duniaGim); lebarLayar = lebarDuniaGim;
	 * tinggiLayar = tinggiDuniaGim; init(); }
	 */

	private void init() {
		acakObyek();
		initDunia();
		initPertanyaan();
		pengaturanLayar();

		pemain.setNyawa(3);

		if (kotakSelesai) {
			kotakSelesai = false;
		}
	}

	private void pengaturanLayar() {
		lebarLayar = Gdx.graphics.getWidth();
		tinggiLayar = Gdx.graphics.getHeight();
		lebarDuniaGim = 192;
		tinggiDuniaGim = 272;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, lebarDuniaGim, tinggiDuniaGim);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
	}

	private void initPertanyaan() {
		// angkaAcakSatu = MathUtils.random(1, 9);
		// angkaAcakDua = MathUtils.random(1, 9);
		nilaiSatu = MathUtils.random(1, 9);
		nilaiDua = MathUtils.random(1, 9);
		hasil = nilaiSatu + nilaiDua;
	}

	private static void mainkanMusik() {
		PemuatAktiva.dkvduaMusicKremKaakkuja.play();
	}

	private static void hentikanMusik() {
		PemuatAktiva.dkvduaMusicKremKaakkuja.stop();
	}

	private void gambarKontrolLayar(SpriteBatch sbGambar) {
		sbGambar.draw(PemuatAktiva.arTombolPanahAtas, 0, 240);
		sbGambar.draw(PemuatAktiva.arTombolPanahBawah, 0, 208);
		sbGambar.draw(PemuatAktiva.arTombolPanahKanan, 160, 240);
		sbGambar.draw(PemuatAktiva.arTombolPanahKiri, 128, 240);
	}

	private void gambarHati(SpriteBatch sbGambar) {
		float x = lebarDuniaGim - 51 - pemain.getNyawaMaksimal();
		float y = 0;

		for (int i = 0; i < pemain.getNyawaMaksimal(); i++) {
			if (pemain.getNyawa() <= i) {
				sbGambar.setColor(0.2f, 0.2f, 0.2f, 0.2f);
			}

			sbGambar.draw(PemuatAktiva.gambarHati, x + i * 17, y, 16, 16);
			sbGambar.setColor(1, 1, 1, 1);
		}
	}

	// private void gambarPertanyaan(SpriteBatch sbGambar) {
	// PemuatAktiva.dkvduaFont.draw(sbGambar, nilaiSatu + " + " + nilaiDua
	// + " = ", 1, 1);
	// }

	// private void gambarAngka(SpriteBatch sbGambar) {
	// angkaSatu.setAngka(angkaAcakSatu);
	// angkaSatu.render(sbGambar);
	/*
	 * angkaJawaban = new Angka(4, 4, Integer.toString(hasil));
	 * angkaJawaban.setSbGambar(sbGambar); angkaDua = new Angka(6, 4,
	 * Integer.toString(angkaAcakDua)); angkaDua.setSbGambar(sbGambar);
	 */
	// aAngka.add(angkaDua);
	// aAngka.add(angkaJawaban);
	// aAngka.add(angkaSatu);

	// PemuatAktiva.dkvduaFont.draw(sbGambar,
	// Integer.toString(angkaAcakSatu),
	// 32, 64);
	// PemuatAktiva.dkvduaFont.draw(sbGambar, Integer.toString(hasil), 64,
	// 64);
	// PemuatAktiva.dkvduaFont.draw(sbGambar,
	// Integer.toString(angkaAcakDua),
	// 96, 64);

	// }

	private void gambarDunia(SpriteBatch sbGambar) {
		ArrayList<Obyek> dunia = new ArrayList<Obyek>();
		dunia.addAll(aDinding);
		dunia.addAll(aLantai);
		dunia.addAll(aLubang);
		dunia.addAll(aMusuh);
		if (jawabanBenar) {
			dunia.addAll(aKotak);
		}

		dunia.addAll(aAngka);
		dunia.add(pemain);

		for (Obyek duniaSatu : dunia) {
			Obyek item = (Obyek) duniaSatu;
			if ((item instanceof Musuh) || (item instanceof Kotak)
					|| (item instanceof Pemain)) {
				sbGambar.draw(item.getTrGambar(), item.getX(), item.getY());
			} else {
				sbGambar.draw(item.getTrGambar(), item.getX(), item.getY());
			}

			if (kotakSelesai) {

			}
		}
	}

	private void pemainDiAtasLubang() {
		int jumlahLubang = aLubang.size();

		for (int i = 0; i < jumlahLubang; i++) {
			Lubang lubang = (Lubang) aLubang.get(i);
			for (int j = 0; j < jumlahLubang; j++) {
				if (pemain.getX() == lubang.getX()) {
					if (pemain.getY() == lubang.getY()) {
						pemain.setNyawa(pemain.getNyawa() - 1);
						pemainDiAtasLubang = true;
					}
				}
			}
		}
	}

	public void update(float waktuDelta) {
		kontrolGerakan(waktuDelta);
		pemainDiAtasLubang();
	}

	public void render(SpriteBatch sbGambar) {
		// gambarPertanyaan(sbGambar);
		gambarDunia(sbGambar);
		// gambarAngka(sbGambar);
		gambarHati(sbGambar);
		gambarKontrolLayar(sbGambar);
	}

	public void acakObyek() {
		MetodePengacakan.shuffle(obyek);
	}

	public void isSelesai() {
		int jumlahKotak = aKotak.size();
		int jumlahSelesai = 0;

		for (int i = 0; i < jumlahKotak; i++) {
			Kotak kotak = (Kotak) aKotak.get(i);
			for (int j = 0; j < jumlahKotak; j++) {
				Lubang lubang = (Lubang) aLubang.get(j);
				if (kotak.getX() == lubang.getX()) {
					if (kotak.getY() == lubang.getY()) {
						jumlahSelesai += 1;
					}
				}
			}
		}

		if (jumlahSelesai == jumlahKotak) {
			kotakSelesai = true;
		}
	}

	private void kontrolGerakan(float delta) {
		float x0 = (Gdx.input.getX(0) / (float) Gdx.graphics.getWidth()) * 192;
		float x1 = (Gdx.input.getX(1) / (float) Gdx.graphics.getWidth()) * 192;
		float y0 = 272 - (Gdx.input.getY(0) / (float) Gdx.graphics.getHeight()) * 272;
		float y1 = 272 - (Gdx.input.getY(1) / (float) Gdx.graphics.getHeight()) * 272;

		boolean tombolAtas = (Gdx.input.isTouched(0) && y0 > 32 && y0 < 208)
				|| (Gdx.input.isTouched(1) && y1 > 32 && y1 < 208);
		boolean tombolBawah = (Gdx.input.isTouched(0) && x0 > 0 && x0 < 208)
				|| (Gdx.input.isTouched(1) && x1 > 0 && x1 < 208);
		boolean tombolKiri = (Gdx.input.isTouched(0) && x0 > 32 && x0 < 160)
				|| (Gdx.input.isTouched(1) && x1 > 32 && x1 < 160);
		boolean tombolKanan = (Gdx.input.isTouched(0) && x0 > 64 && y0 < 64)
				|| (Gdx.input.isTouched(1) && x1 > 64 && y0 < 64);

		if (kotakSelesai) {
			game.setScreen(new LayarDialogMenang(game));
			hentikanMusik();
			return;
		}

		if (pemainDiAtasLubang) {
			game.setScreen(new LayarDialogKalah(game));
			hentikanMusik();
			return;
		}
		
		if (pemain.pemainMati()) {
			game.setScreen(new LayarDialogKalah(game));
			hentikanMusik();
		}

		if (Gdx.input.isKeyPressed(Keys.LEFT) || tombolKiri) {
			if (!tombolDiTekan) {
				if (cekTabrakanDinding(pemain, TABRAKAN_KIRI)) {
					return;
				}

				if (cekTabrakanKotak(TABRAKAN_KIRI)) {
					return;
				}

				pemain.bergerak(-UKURAN_UBIN, 0);
				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT) || tombolKanan) {
			if (!tombolDiTekan) {
				if (cekTabrakanDinding(pemain, TABRAKAN_KANAN)) {
					return;
				}

				if (cekTabrakanKotak(TABRAKAN_KANAN)) {
					return;
				}

				pemain.bergerak(UKURAN_UBIN, 0);
				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.UP) || tombolAtas) {
			if (!tombolDiTekan) {
				if (cekTabrakanDinding(pemain, TABRAKAN_ATAS)) {
					return;
				}

				if (cekTabrakanKotak(TABRAKAN_ATAS)) {
					return;
				}

				pemain.bergerak(0, -UKURAN_UBIN);
				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.DOWN) || tombolBawah) {
			if (!tombolDiTekan) {
				if (cekTabrakanDinding(pemain, TABRAKAN_BAWAH)) {
					return;
				}

				if (cekTabrakanKotak(TABRAKAN_BAWAH)) {
					return;
				}

				pemain.bergerak(0, UKURAN_UBIN);
				tombolDiTekan = true;
			}
		} else {
			if (tombolDiTekan) {
				tombolDiTekan = false;
			}
		}
	}

	public boolean cekTabrakanKotak(int tipe) {
		if (tipe == TABRAKAN_KIRI) {
			for (Obyek oKotakSatu : aKotak) {
				Kotak kotak = (Kotak) oKotakSatu;
				if (pemain.isTabrakanKiri(kotak)) {
					for (Obyek oKotakDua : aKotak) {
						Kotak item = (Kotak) oKotakDua;
						if (!kotak.equals(item)) {
							if (kotak.isTabrakanKiri(item)) {
								return true;
							}
						}

						if (cekTabrakanDinding(kotak, TABRAKAN_KIRI)) {
							return true;
						}
					}

					kotak.bergerak(-UKURAN_UBIN, 0);
					isSelesai();
				}
			}

			return false;
		} else if (tipe == TABRAKAN_KANAN) {
			for (Obyek oKotakSatu : aKotak) {
				Kotak kotak = (Kotak) oKotakSatu;
				if (pemain.isTabrakanKanan(kotak)) {
					for (Obyek oKotakDua : aKotak) {
						Kotak item = (Kotak) oKotakDua;
						if (!kotak.equals(item)) {
							if (kotak.isTabrakanKanan(item)) {
								return true;
							}
						}

						if (cekTabrakanDinding(kotak, TABRAKAN_KANAN)) {
							return true;
						}
					}

					kotak.bergerak(UKURAN_UBIN, 0);
					isSelesai();
				}
			}

			return false;
		} else if (tipe == TABRAKAN_ATAS) {
			for (Obyek oKotakSatu : aKotak) {
				Kotak kotak = (Kotak) oKotakSatu;
				if (pemain.isTabrakanAtas(kotak)) {
					for (Obyek oKotakDua : aKotak) {
						Kotak item = (Kotak) oKotakDua;
						if (!kotak.equals(item)) {
							if (kotak.isTabrakanAtas(item)) {
								return true;
							}
						}

						if (cekTabrakanDinding(kotak, TABRAKAN_ATAS)) {
							return true;
						}
					}

					kotak.bergerak(0, -UKURAN_UBIN);
					isSelesai();
				}
			}

			return false;
		} else if (tipe == TABRAKAN_BAWAH) {
			for (Obyek oKotakSatu : aKotak) {
				Kotak kotak = (Kotak) oKotakSatu;
				if (pemain.isTabrakanBawah(kotak)) {
					for (Obyek oKotakDua : aKotak) {
						Kotak item = (Kotak) oKotakDua;
						if (!kotak.equals(item)) {
							if (kotak.isTabrakanBawah(item)) {
								return true;
							}
						}

						if (cekTabrakanDinding(kotak, TABRAKAN_BAWAH)) {
							return true;
						}
					}

					kotak.bergerak(0, UKURAN_UBIN);
					isSelesai();
				}
			}

			return false;
		}

		return false;
	}

	public boolean cekTabrakanDinding(Obyek obyek, int tipe) {
		if (tipe == TABRAKAN_KIRI) {
			for (Obyek oDinding : aDinding) {
				Dinding dinding = (Dinding) oDinding;
				if (obyek.isTabrakanKiri(dinding)) {
					return true;
				}
			}

			return false;
		} else if (tipe == TABRAKAN_KANAN) {
			for (Obyek oDinding : aDinding) {
				Dinding dDinding = (Dinding) oDinding;
				if (obyek.isTabrakanKanan(dDinding)) {
					return true;
				}
			}

			return false;
		} else if (tipe == TABRAKAN_ATAS) {
			for (Obyek oDinding : aDinding) {
				Dinding dDinding = (Dinding) oDinding;
				if (obyek.isTabrakanAtas(dDinding)) {
					return true;
				}
			}

			return false;
		} else if (tipe == TABRAKAN_BAWAH) {
			for (Obyek oDinding : aDinding) {
				Dinding dDinding = (Dinding) oDinding;
				if (obyek.isTabrakanBawah(dDinding)) {
					return true;
				}
			}

			return false;
		}

		return false;
	}

	public final void initDunia() {
		for (int i = 0; i < petaLevel.length; i++) {
			for (int j = 0; j < petaLevel[i].length; j++) {
				switch (petaLevel[i][j]) {
				case 1:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinPojokKiriAtas);
					aDinding.add(dinding);
					break;
				case 2:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinAtas);
					aDinding.add(dinding);
					break;
				case 3:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinPojokKananAtas);
					aDinding.add(dinding);
					break;
				case 4:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinKiri);
					aDinding.add(dinding);
					break;
				case 5:
					lantai = new Lantai(j * UKURAN_UBIN, i * UKURAN_UBIN);
					lantai.setTrGambar(PemuatAktiva.gambarUbin);
					aLantai.add(lantai);
					break;
				case 6:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinKanan);
					aDinding.add(dinding);
					break;
				case 7:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinPojokKiriBawah);
					aDinding.add(dinding);
					break;
				case 8:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinBawah);
					aDinding.add(dinding);
					break;
				case 9:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(PemuatAktiva.gambarUbinPojokKananBawah);
					aDinding.add(dinding);
					break;
				default:
					break;
				}
			}
		}

		for (int x = 0; x < obyek.length; x++) {
			for (int y = 0; y < obyek[x].length; y++) {
				switch (obyek[x][y]) {
				case 1:
					lubang = new Lubang(y * UKURAN_UBIN, x * UKURAN_UBIN);
					lubang.setTrGambar(PemuatAktiva.gambarLubang);
					aLubang.add(lubang);
					musuh = new Musuh(y * UKURAN_UBIN, x * UKURAN_UBIN);
					musuh.setTrGambar(PemuatAktiva.gambarMusuh);
					aMusuh.add(musuh);
					break;
				case 2:
					pemain = new Pemain(y * UKURAN_UBIN, x * UKURAN_UBIN);
					pemain.setTrGambar(PemuatAktiva.gambarPemainDepan);
					break;
				case 3:
					kotak = new Kotak(y * UKURAN_UBIN, x * UKURAN_UBIN);
					kotak.setTrGambar(PemuatAktiva.gambarKotak);
					aKotak.add(kotak);
					break;
				default:
					break;
				}
			}
		}
	}

	public int getLebarLayar() {
		return lebarLayar;
	}

	public void setLebarLayar(int lebarLayar) {
		this.lebarLayar = lebarLayar;
	}

	public int getTinggiLayar() {
		return tinggiLayar;
	}

	public void setTinggiLayar(int tinggiLayar) {
		this.tinggiLayar = tinggiLayar;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(new StretchViewport(480, 640));
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
		Gdx.input.setCatchBackKey(true);

		textureTextField = new Texture(
				Gdx.files.internal("data/gfx/ui/window/grey_button05.png"));

		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.fnt"),
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.png"),
				false);

		skin = new Skin();
		skin.add("textField", textureTextField);

		table = new Table(skin);
		tTable = new Table(skin);

		labelStyle = new LabelStyle();
		labelStyle.font = bitmapFont;
		labelStyle.fontColor = Color.WHITE;

		lblPertanyaan = new Label(nilaiSatu + " + " + nilaiDua + " = ",
				labelStyle);
		lblPertanyaan.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if (txtJawaban.getText().equals(String.valueOf(hasil))) {
					txtJawaban.setDisabled(true);
					jawabanBenar = true;
				} else {
					pemain.setNyawa(pemain.getNyawa() - 1);
					if (pemain.pemainMati()) {
						Gdx.app.log(TAG, "Nyawa pemain habis");
						jawabanBenar = false;
					}
				}

				return super.touchDown(event, x, y, pointer, button);
			}
		});

		textFieldStyle = new TextFieldStyle();
		textFieldStyle.background = skin.getDrawable("textField");
		textFieldStyle.font = bitmapFont;
		textFieldStyle.fontColor = Color.GREEN;

		txtJawaban = new TextField("", textFieldStyle);
		txtJawaban.setSize(50, 100);

		table.defaults().pad(3f);
		table.row().center();
		table.add(lblPertanyaan).left().expandX();
		table.add(txtJawaban).left().expandX();

		tTable.setPosition(150, 610);
		tTable.defaults().pad(2f);
		tTable.row();
		tTable.add(table);

		stage.addActor(tTable);

		mainkanMusik();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		hentikanMusik();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(114 / 255.0f, 129 / 255.0f, 146 / 255.0f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(114 / 255.0f, 129 / 255.0f, 146 / 255.0f, 0);
		shapeRenderer.rect(0, 0, lebarLayar, 32);
		shapeRenderer.end();

		batcher.begin();
		render(batcher);
		batcher.end();
		update(delta);

		stage.act(delta);
		stage.draw();

		if (Gdx.input.isKeyPressed(Keys.BACK)) {
			game.setScreen(new LayarMenuUtama(game));
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		PemuatAktiva.dkvduaMusicKremKaakkuja.pause();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		PemuatAktiva.dkvduaMusicKremKaakkuja.play();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		skin.dispose();
		textureTextField.dispose();
		bitmapFont.dispose();
		hentikanMusik();
	}
}
