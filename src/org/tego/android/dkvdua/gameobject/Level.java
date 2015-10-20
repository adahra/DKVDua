/*
 * Level.java
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

import org.tego.android.dkvdua.gameworld.GameWorld;
import org.tego.android.dkvdua.utilitas.AssetLoader;
import org.tego.android.dkvdua.utilitas.MetodePengacakan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Kelas yang digunakan untuk menggambar peta level pada permainan
 * 
 * @author blackshadow
 *
 */
public class Level {
	public static final String TAG = Level.class.getSimpleName();

	public static final int UKURAN_UBIN = 16;

	public int lebarLayar;
	public int tinggiLayar;

	private int posisiX = 1;
	private int posisiY = 3;

	private int arahPemain = 3;

	private int x;
	private int y;

	public static final int KIRI = 1;
	public static final int KANAN = 2;
	public static final int DEPAN = 3;
	public static final int BELAKANG = 4;

	private GameWorld duniaGim;

	private boolean tombolDiTekan = false;

	/*
	 * Array data dari peta level gim, sebagai layer satu yang digunakan untuk
	 * penggambaran lantai dan dinding angka 1, 2, 3, 4, 6, 7, 8, dan 9
	 * merepresentasikan lantai dan dinding dari peta level
	 */
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

	/*
	 * Array data dari peta level gim sebagai layer dua yang digunakan untuk
	 * penggambaran labirin angka 3 merupakan representasi dari labirin dan
	 * angka 2 merupakan representasi daerah di mana kotak dan lubang harus
	 * berada, jika di luar area tersebut dilakukan pengacakan lagi
	 */
	public int[][] labirin = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	/*
	 * Array data dari peta level gim sebagai layer tiga yang digunakan untuk
	 * penggambaran lubang dan kotak, angka 1 mereprentasikan lubang dan angka 3
	 * mereprentasikan kotak, ketika dilakukan pengacakan angka 1 dan 3 harus
	 * berada pada area yang terdapat pada array labirin angka nomor 2
	 */
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

	public Level(GameWorld duniaGim) {
		this.setDuniaGim(duniaGim);
		acakArray();
		mainkanMusik();
	}

	public Level(GameWorld duniaGim, int lebarDuniaGim, int tinggiDuniaGim) {
		// TODO Auto-generated constructor stub
		this.setDuniaGim(duniaGim);
		lebarLayar = lebarDuniaGim;
		tinggiLayar = lebarDuniaGim;

		acakArray();
		mainkanMusik();
	}

	private static void mainkanMusik() {
		AssetLoader.dkvduaMusicMysteryBox.play();
	}

	public void update(float delta) {
		kontrolGerakan(delta);
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
				if (petaLevel[posisiY][posisiX - 1] == 5) {
					if (!cekHalangan(posisiY, posisiX - 1)) {
						gerakanPemain(-1, 0, KIRI);
					}
				}

				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT) || tombolKanan) {
			if (!tombolDiTekan) {
				if (petaLevel[posisiY][posisiX + 1] == 5) {
					if (!cekHalangan(posisiY, posisiX + 1)) {
						gerakanPemain(1, 0, KANAN);
					}
				}

				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.UP) || tombolAtas) {
			if (!tombolDiTekan) {
				if (petaLevel[posisiY - 1][posisiX] == 5) {
					if (!cekHalangan(posisiY - 1, posisiX)) {
						gerakanPemain(0, -1, BELAKANG);
					}
				}

				tombolDiTekan = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.DOWN) || tombolBawah) {
			if (!tombolDiTekan) {
				if (petaLevel[posisiY + 1][posisiX] == 5) {
					if (!cekHalangan(posisiY + 1, posisiX)) {
						gerakanPemain(0, 1, DEPAN);
					}
				}

				tombolDiTekan = true;
			}
		} else {
			if (tombolDiTekan) {
				// gerakanPemain(0, 0, DEPAN);
				tombolDiTekan = false;
			}
		}
	}

	private void gambarKontrolLayar(SpriteBatch spriteBatch) {
		spriteBatch.draw(AssetLoader.arTombolPanahAtas, 0, 240);
		spriteBatch.draw(AssetLoader.arTombolPanahBawah, 0, 208);
		spriteBatch.draw(AssetLoader.arTombolPanahKanan, 160, 240);
		spriteBatch.draw(AssetLoader.arTombolPanahKiri, 128, 240);
	}

	/**
	 * Method yang digunakan untuk melakukan pengacakan pada peta level gim dan
	 * melakukan pengecekan posisi lantai dan lubang apakah bertumpuk dengan
	 * dinding atau labirin
	 */
	private void acakArray() {
		// MetodePengacakan.shuffle(obyek);

		for (int i = 0; i < labirin.length; i++) {
			for (int j = 0; j < labirin[0].length; j++) {
				if (!labirin.equals(obyek)) {
					if (cekBatasObyek(i, j)) {
						MetodePengacakan.shuffle(obyek);
					} else {

					}
				} else {

				}
			}
		}
	}

	private void tampilPemain(SpriteBatch spriteBatch) {
		for (int x = 0; x < petaLevel.length; x++) {
			for (int y = 0; y < petaLevel[0].length; y++) {
				if ((y == posisiX) && (x == posisiY)) {
					switch (arahPemain) {
					case DEPAN:
						spriteBatch.draw(AssetLoader.gambarPemainDepan, posisiX
								* UKURAN_UBIN, posisiY * UKURAN_UBIN);
						break;
					case BELAKANG:
						spriteBatch.draw(AssetLoader.gambarPemainBelakang,
								posisiX * UKURAN_UBIN, posisiY * UKURAN_UBIN);
						break;
					case KIRI:
						spriteBatch.draw(AssetLoader.gambarPemainKiri, posisiX
								* UKURAN_UBIN, posisiY * UKURAN_UBIN);
						break;
					case KANAN:
						spriteBatch.draw(AssetLoader.gambarPemainKanan, posisiX
								* UKURAN_UBIN, posisiY * UKURAN_UBIN);
					}
				}
			}
		}
	}

	private void tampilLabirin(SpriteBatch batcher) {
		for (int x = 0; x < labirin.length; x++) {
			for (int y = 0; y < labirin[0].length; y++) {
				if (labirin[x][y] == 3) {
					batcher.draw(AssetLoader.gambarHalangan, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
				}
			}
		}
	}

	private void tampilObyek(SpriteBatch batcher) {
		for (int x = 0; x < obyek.length; x++) {
			for (int y = 0; y < obyek[0].length; y++) {
				switch (obyek[x][y]) {
				case 1:
					batcher.draw(AssetLoader.gambarLubang, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
					break;
				case 2:
					break;
				case 3:
					batcher.draw(AssetLoader.gambarKotak, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
					break;
				}
			}
		}
	}

	private void tampilPetaLevel(SpriteBatch batcher) {
		for (int x = 0; x < petaLevel.length; x++) {
			for (int y = 0; y < petaLevel[0].length; y++) {
				switch (petaLevel[x][y]) {
				case 1:
					batcher.draw(AssetLoader.gambarUbinPojokKiriAtas, y
							* UKURAN_UBIN, x * UKURAN_UBIN);
					break;
				case 2:
					batcher.draw(AssetLoader.gambarUbinAtas, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
					break;
				case 3:
					batcher.draw(AssetLoader.gambarUbinPojokKananAtas, y
							* UKURAN_UBIN, x * UKURAN_UBIN);
					break;
				case 4:
					batcher.draw(AssetLoader.gambarUbinKiri, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
					break;
				case 5:
					batcher.draw(AssetLoader.gambarUbin, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
					break;
				case 6:
					batcher.draw(AssetLoader.gambarUbinKanan, y * UKURAN_UBIN,
							x * UKURAN_UBIN);
					break;
				case 7:
					batcher.draw(AssetLoader.gambarUbinPojokKiriBawah, y
							* UKURAN_UBIN, x * UKURAN_UBIN);
					break;
				case 8:
					batcher.draw(AssetLoader.gambarUbinBawah, y * UKURAN_UBIN,
							x * UKURAN_UBIN);
					break;
				case 9:
					batcher.draw(AssetLoader.gambarUbinPojokKananBawah, y
							* UKURAN_UBIN, x * UKURAN_UBIN);
					break;
				}
			}
		}
	}

	public void gerakanPemain(int x, int y, int arah) {
		setX(x);
		setY(y);

		arahPemain = arah;

		posisiX += getX();
		posisiY += getY();
	}

	public void render(SpriteBatch batch) {
		tampilPetaLevel(batch);
		tampilLabirin(batch);
		tampilObyek(batch);
		tampilPemain(batch);
		gambarKontrolLayar(batch);
	}

	public boolean cekHalangan(int x, int y) {
		if ((labirin[x][y] == 3) || (obyek[x][y] == 3) || (obyek[x][y] == 1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengecekan terhadap data pada array
	 * labirin apakah nilai baris dan kolom terdapat angka 2
	 * 
	 * @param x
	 *            Posisi dari baris
	 * @param y
	 *            Posisi dari kolom
	 * @return Bernilai benar
	 */
	public boolean cekBatasObyek(int x, int y) {
		if (labirin[x][y] == 2) {
			return true;
		} else {
			return false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public GameWorld getDuniaGim() {
		return duniaGim;
	}

	public void setDuniaGim(GameWorld duniaGim) {
		this.duniaGim = duniaGim;
	}
}
