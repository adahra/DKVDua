package org.nauin.android.dkvdua.utilitas;

import com.badlogic.gdx.math.MathUtils;

/**
 * Kelas yang mengimplementasikan metode/algoritma dari Fisher-Yates Shuffle
 * 
 * 
 * @author nauin
 *
 */
public class MetodePengacakan {
	
	public MetodePengacakan() {
	}
	
	public static void shuffle(int[] array) {
		int n = array.length;
		
		while (n > 1) {
			int k = MathUtils.random(n--);
			int temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}
	
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
