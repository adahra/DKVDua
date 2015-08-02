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
	 * Method yang digunakan untuk melakukan pengacakan array
	 * 
	 * @param array
	 */
	public static void shuffle(int[] array) {
		int n = array.length;

		while (n > 1) {
			int k = MathUtils.random(n--);
			int temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}

	/**
	 * Method yang digunakan untuk melakukan pengacakan array yang berbentuk
	 * obyek
	 * 
	 * @param array
	 */
	public static void shuffle(Object[] array) {
		int n = array.length;

		while (n > 1) {
			int k = MathUtils.random(n--);
			Object temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}

}
