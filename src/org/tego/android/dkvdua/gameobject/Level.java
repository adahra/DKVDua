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

	private static final int BARIS = 12;
	private static final int KOLOM = 17;

	private GameWorld duniaGim;

	private boolean tombolDiTekan = false;

	/**
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

	/**
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

	/**
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

	/**
	 * Konstruktor dari kelas Level
	 * 
	 * @param duniaGim
	 *            dunia gim
	 */
	public Level(GameWorld duniaGim) {
		this.setDuniaGim(duniaGim);
		acakArray();
		mainkanMusik();
	}

	/**
	 * Konstruktor dari kelas level dengan tiga parameter
	 * 
	 * @param duniaGim
	 *            dunia gim yang ada
	 * @param lebarDuniaGim
	 *            lebar dari dunia gim
	 * @param tinggiDuniaGim
	 *            tinggi dari dunia gim
	 */
	public Level(GameWorld duniaGim, int lebarDuniaGim, int tinggiDuniaGim) {
		// TODO Auto-generated constructor stub
		this.setDuniaGim(duniaGim);
		lebarLayar = lebarDuniaGim;
		tinggiLayar = lebarDuniaGim;

		acakArray();
		mainkanMusik();
	}

	/**
	 * Method yang digunakan untuk memainkan musik yang akan digunakan untuk gim
	 */
	private static void mainkanMusik() {
		AssetLoader.dkvduaMusicKremKaakkuja.play();
	}

	/**
	 * Method yang digunakan untuk melakukan pembaharuan pada gim
	 * 
	 * @param delta
	 *            waktu dari pustaka, waktu yang berjalan
	 */
	public void update(float delta) {
		kontrolGerakan(delta);
	}

	/**
	 * Method yang digunakan untuk melakukan kontrol untuk melakukan gerakan
	 * terhadap pemain
	 * 
	 * @param delta
	 *            waktu yang berjalann
	 */
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

	/**
	 * Method yang digunakan untuk menggambar kontrol yang terdapat pada layar
	 * 
	 * @param spriteBatch
	 *            penggambaran yang dilakukan
	 */
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
		boolean acak = false;

		System.out.println("Array obyek sebelum diacak");
		for (int i = 0; i < obyek.length; i++) {
			for (int j = 0; j < obyek[i].length; j++) {
				System.out.print(obyek[i][j] + ", ");
			}

			System.out.println("");
		}

		if (!acak) {
			MetodePengacakan.shuffle(obyek);
			acak = false;
		}

		System.out.println("Array obyek sesudah diacak");
		for (int i = 0; i < obyek.length; i++) {
			for (int j = 0; j < obyek[i].length; j++) {
				System.out.print(obyek[i][j] + ", ");
			}

			System.out.println("");
		}

		/*
		 * for (int i = 0; i < KOLOM; i++) { for (int j = 0; j < BARIS; j++) {
		 * if (cekObyek(i, j) == cekLabirin(i, j)) { acak = true;
		 * System.out.println("Ada yang bertumpukan"); } else if (cekObyek(i, j)
		 * == cekPetaLevel(i, j)) { acak = true;
		 * System.out.println("Bertumpuk"); } else { acak = false; } } }
		 */

		for (int i = 0; i < KOLOM; i++) {
			for (int j = 0; j < BARIS; j++) {
				if (bandingkanArray(obyek, labirin)) {
					acak = true;
					System.out.println("Ada yang bertumpukan");
				} else if (bandingkanArray(obyek, petaLevel)) {
					acak = true;
					System.out.println("Bertumpuk");
				} else {
					acak = false;
				}
			}
		}
	}

	private static boolean bandingkanArray(int[][] larikSatu, int[][] larikDua) {
		if (larikSatu == larikDua) {
			return true;
		}

		if (larikSatu == null || larikDua == null) {
			return false;
		}

		int panjang = larikSatu.length;
		if (larikDua.length != panjang) {
			return false;
		}

		for (int i = 0; i < panjang; i++) {
			if (larikSatu[i] != larikDua[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Method yang digunakan untuk melakukan penggambaran pemain
	 * 
	 * @param spriteBatch
	 *            parameter yang digunakan untuk memanggil fungsi draw
	 */
	private void tampilPemain(SpriteBatch spriteBatch) {
		for (int x = 0; x < petaLevel.length; x++) {
			for (int y = 0; y < petaLevel[x].length; y++) {
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

	/**
	 * Method yang digunakan untuk menampilkan atau menggambar labirin
	 * 
	 * @param batcher
	 *            fungsi yang dipanggil ketika memanggil fungsi draw
	 */
	private void tampilLabirin(SpriteBatch batcher) {
		for (int x = 0; x < labirin.length; x++) {
			for (int y = 0; y < labirin[x].length; y++) {
				if (labirin[x][y] == 3) {
					batcher.draw(AssetLoader.gambarHalangan, y * UKURAN_UBIN, x
							* UKURAN_UBIN);
				}
			}
		}
	}

	/**
	 * Method yang digunakan untuk melakukan penggambaran obyek pada gim
	 * 
	 * @param batcher
	 *            untuk memanggil method draw
	 */
	private void tampilObyek(SpriteBatch batcher) {
		for (int x = 0; x < obyek.length; x++) {
			for (int y = 0; y < obyek[x].length; y++) {
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

	/**
	 * Method yang digunakan untuk melakukan penggambaran peta level gim
	 * 
	 * @param batcher
	 *            parameter yang digunakan untuk memanggil method draw
	 */
	private void tampilPetaLevel(SpriteBatch batcher) {
		for (int x = 0; x < petaLevel.length; x++) {
			for (int y = 0; y < petaLevel[x].length; y++) {
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

	/**
	 * Method yang digunakan untuk menggerakkan pemain
	 * 
	 * @param x
	 *            posisi X dari pemain
	 * @param y
	 *            posisi Y dari pemain
	 * @param arah
	 *            arah jalan, arah gambar dari pemain ketika berjalan
	 */
	public void gerakanPemain(int x, int y, int arah) {
		setX(x);
		setY(y);

		arahPemain = arah;

		posisiX += getX();
		posisiY += getY();
	}

	/**
	 * Method yang digunakan untuk melakukan render/penggambaran semua komponen
	 * dari gim
	 * 
	 * @param batch
	 *            parameter untuk memanggil method draw
	 */
	public void render(SpriteBatch batch) {
		tampilPetaLevel(batch);
		tampilLabirin(batch);
		tampilObyek(batch);
		tampilPemain(batch);
		gambarKontrolLayar(batch);
	}

	/**
	 * Method yang digunakan untuk melakukan pengecekan halangan pada gim
	 * 
	 * @param x
	 *            posisi X dari halangan
	 * @param y
	 *            posisi Y dari halangan
	 * @return jika terdapat halangan maka bernilai benar
	 */
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
	public boolean cekLabirin(int x, int y) {
		if (labirin[x][y] == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengecekan pada peta level gim
	 * 
	 * @param x
	 *            posisi X dari dinding dan lantai
	 * @param y
	 *            posisi Y dari dinding dan lantai
	 * @return jika terdapat peta level bernilai benar
	 */
	public boolean cekPetaLevel(int x, int y) {
		if (petaLevel[x][y] == 0 || petaLevel[x][y] == 1
				|| petaLevel[x][y] == 2 || petaLevel[x][y] == 3
				|| petaLevel[x][y] == 4 || petaLevel[x][y] == 5
				|| petaLevel[x][y] == 6 || petaLevel[x][y] == 7
				|| petaLevel[x][y] == 8 || petaLevel[x][y] == 9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengecekan pada obyek gim
	 * 
	 * @param x
	 *            posisi X dari obyek
	 * @param y
	 *            posisi Y dari obyek
	 * @return jika terdapat obyek bernilai benar
	 */
	public boolean cekObyek(int x, int y) {
		if (obyek[x][y] == 3 || obyek[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengambilan nilai X
	 * 
	 * @return nilai X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Method yang digunakan untuk melakukan pengaturan nilai X
	 * 
	 * @param x
	 *            nilai X
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Method yang digunakan untuk melakukan pengambilan nilai Y
	 * 
	 * @return nilai Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Method yang digunakan untuk mengatur nilai Y
	 * 
	 * @param y
	 *            nilai Y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Method yang digunakan untuk mengambil dunia gim
	 * 
	 * @return dunia gim
	 */
	public GameWorld getDuniaGim() {
		return duniaGim;
	}

	/**
	 * Method yang digunakan untuk mengatur dunia gim
	 * 
	 * @param duniaGim
	 *            dunia gim
	 */
	public void setDuniaGim(GameWorld duniaGim) {
		this.duniaGim = duniaGim;
	}
}
