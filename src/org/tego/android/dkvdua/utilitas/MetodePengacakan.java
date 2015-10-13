package org.tego.android.dkvdua.utilitas;

import com.badlogic.gdx.math.MathUtils;

/**
 * Kelas yang mengimplementasikan metode/algoritma dari Fisher-Yates Shuffle
 * 
 * @author blackshadow
 *
 */
public class MetodePengacakan {

	/**
	 * Konstruktor dari kelas
	 */
	public MetodePengacakan() {
	}

	/**
	 * Method yang digunakan untuk melakukan pengacakan array dimensi satu
	 * 
	 * @param array
	 *            Nilai dari array dimensi satu
	 */
	public static void shuffle(int[] array) {
		int n = array.length;

		while (n > 0) {
			int k = MathUtils.random(n--);
			int temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengacakan array dimensi dua
	 * 
	 * @param array
	 *            Nilai dari array dimensi dua
	 */
	public static void shuffle(int[][] array) {
		for (int x = 0; x < array.length; x++) {
			for (int y = 0;  y < array[0].length; y++) {
				int i = MathUtils.random(x);
				int j = MathUtils.random(y);
				int temp = array[x][y];
				array[x][y] = array[i][j];
				array[i][j] = temp;
			}
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengacakan array dimensi satu yang
	 * berbentuk obyek
	 * 
	 * @param array
	 *            Nilai dari array dimensi satu
	 */
	public static void shuffle(Object[] array) {
		int n = array.length;

		while (n > 0) {
			int k = MathUtils.random(n--);
			Object temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}

}
