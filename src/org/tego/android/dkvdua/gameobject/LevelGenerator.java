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

import org.tego.android.dkvdua.gameworld.GameWorld;
import org.tego.android.dkvdua.utilitas.AssetLoader;
import org.tego.android.dkvdua.utilitas.MetodePengacakan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

/**
 * Kelas yang digunakan untuk membuat level pada permainan
 * 
 * @author blackshadow
 *
 */
public class LevelGenerator {
	public static final String TAG = LevelGenerator.class.getSimpleName();

	private int lebarLayar;
	private int tinggiLayar;

	public final int OFFSET = 16;
	public final int UKURAN_UBIN = 16;
	public final int TABRAKAN_KIRI = 1;
	public final int TABRAKAN_KANAN = 2;
	public final int TABRAKAN_ATAS = 3;
	public final int TABRAKAN_BAWAH = 4;

	private final ArrayList<Kotak> aKotak = new ArrayList<Kotak>();
	// private final ArrayList<Musuh> aMusuh = new ArrayList<Musuh>();
	private final ArrayList<Lubang> aLubang = new ArrayList<Lubang>();
	private final ArrayList<Dinding> aDinding = new ArrayList<Dinding>();
	private final ArrayList<Lantai> aLantai = new ArrayList<Lantai>();

	private Pemain pemain;
	private Dinding dinding;
	private Kotak kotak;
	private Lubang lubang;
	private Lantai lantai;

	private GameWorld duniaGim;

	// private boolean completed = false;
	private boolean tombolDiTekan = false;

	private int nilaiSatu;
	private int nilaiDua;
	// private int hasil;

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

	public LevelGenerator(GameWorld duniaGim) {
		setDuniaGim(duniaGim);
		init();
	}

	public LevelGenerator(GameWorld duniaGim, int lebarDuniaGim,
			int tinggiDuniaGim) {
		setDuniaGim(duniaGim);
		lebarLayar = lebarDuniaGim;
		tinggiLayar = tinggiDuniaGim;
		init();
	}

	private void init() {
		acakObyek();
		initDunia();
		initPertanyaan();
		mainkanMusik();
	}

	private void initPertanyaan() {
		nilaiSatu = MathUtils.random(1, 9);
		nilaiDua = MathUtils.random(1, 9);
		// hasil = nilaiSatu + nilaiDua;
	}

	private static void mainkanMusik() {
		AssetLoader.dkvduaMusicKremKaakkuja.play();
	}

	private void gambarKontrolLayar(SpriteBatch sbGambar) {
		sbGambar.draw(AssetLoader.arTombolPanahAtas, 0, 240);
		sbGambar.draw(AssetLoader.arTombolPanahBawah, 0, 208);
		sbGambar.draw(AssetLoader.arTombolPanahKanan, 160, 240);
		sbGambar.draw(AssetLoader.arTombolPanahKiri, 128, 240);
	}

	private void gambarHati(SpriteBatch sbGambar) {
		sbGambar.draw(AssetLoader.gambarHati, lebarLayar - 51, 0);
		sbGambar.draw(AssetLoader.gambarHati, lebarLayar - 34, 0);
		sbGambar.draw(AssetLoader.gambarHati, lebarLayar - 17, 0);
	}

	private void gambarPertanyaan(SpriteBatch sbGambar) {
		AssetLoader.dkvduaFont.draw(sbGambar, nilaiSatu + " + " + nilaiDua
				+ " = ", 1, 1);
	}

	private void gambarDunia(SpriteBatch sbGambar) {
		ArrayList<Obyek> dunia = new ArrayList<Obyek>();
		dunia.addAll(aDinding);
		dunia.addAll(aLantai);
		dunia.addAll(aLubang);
		dunia.addAll(aKotak);
		dunia.add(pemain);

		for (Object duniaSatu : dunia) {
			Obyek item = (Obyek) duniaSatu;
			if ((item instanceof Kotak) || (item instanceof Pemain)) {
				sbGambar.draw(item.getTrGambar(), item.getX(), item.getY());
			} else {
				sbGambar.draw(item.getTrGambar(), item.getX(), item.getY());
			}
		}
	}
	
	public void update(float waktuDelta) {
		kontrolGerakan(waktuDelta);
	}

	public void render(SpriteBatch sbGambar) {
		gambarDunia(sbGambar);
		gambarPertanyaan(sbGambar);
		gambarHati(sbGambar);
		gambarKontrolLayar(sbGambar);
	}

	public void acakObyek() {
		MetodePengacakan.shuffle(obyek);
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
							if (kotak.isTabrakanKanan(item)) {
								return true;
							}
						}

						if (cekTabrakanDinding(kotak, TABRAKAN_ATAS)) {
							return true;
						}
					}

					kotak.bergerak(0, -UKURAN_UBIN);
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
					dinding.setTrGambar(AssetLoader.gambarUbinPojokKiriAtas);
					aDinding.add(dinding);
					break;
				case 2:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinAtas);
					aDinding.add(dinding);
					break;
				case 3:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinPojokKananAtas);
					aDinding.add(dinding);
					break;
				case 4:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinKiri);
					aDinding.add(dinding);
					break;
				case 5:
					lantai = new Lantai(j * UKURAN_UBIN, i * UKURAN_UBIN);
					lantai.setTrGambar(AssetLoader.gambarUbin);
					aLantai.add(lantai);
					break;
				case 6:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinKanan);
					aDinding.add(dinding);
					break;
				case 7:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinPojokKiriBawah);
					aDinding.add(dinding);
					break;
				case 8:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinBawah);
					aDinding.add(dinding);
					break;
				case 9:
					dinding = new Dinding(j * UKURAN_UBIN, i * UKURAN_UBIN);
					dinding.setTrGambar(AssetLoader.gambarUbinPojokKananBawah);
					aDinding.add(dinding);
					break;
				default:
					break;
				}
			}
		}

		acakObyek();

		for (int x = 0; x < obyek.length; x++) {
			for (int y = 0; y < obyek[x].length; y++) {
				switch (obyek[x][y]) {
				case 1:
					lubang = new Lubang(y * UKURAN_UBIN, x * UKURAN_UBIN);
					lubang.setTrGambar(AssetLoader.gambarLubang);
					aLubang.add(lubang);
					break;
				case 2:
					pemain = new Pemain(y * UKURAN_UBIN, x * UKURAN_UBIN);
					pemain.setTrGambar(AssetLoader.gambarPemainDepan);
					break;
				case 3:
					kotak = new Kotak(y * UKURAN_UBIN, x * UKURAN_UBIN);
					kotak.setTrGambar(AssetLoader.gambarKotak);
					aKotak.add(kotak);
					break;
				default:
					break;
				}
			}
		}
	}

	public GameWorld getDuniaGim() {
		return duniaGim;
	}

	public void setDuniaGim(GameWorld duniaGim) {
		this.duniaGim = duniaGim;
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
}
