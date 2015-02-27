/*
 * Masukan.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework;

import java.util.List;

/**
 * Interface masukan yang mengaut masukan/input
 * 
 * @author nauin
 *
 */
public interface Masukan {

	/**
	 * Kelas yang digunakan untuk mendefinisikan konstanta yang mengencode
	 * sebuah tipe KeyEvent
	 * 
	 * @author nauin
	 *
	 */
	public static class KunciKejadian {
		public static final int KUNCI_BAWAH = 0; // Ketika papan kunci ditekan
		public static final int KUNCI_ATAS = 1; // Ketika papan kunci dilepaskan

		public int tipe; // Tipe dari masukan
		public int kodeKunci; // Kode dari papan kunci
		public char karakterKunci; // Karakter dari papan kunci

		/**
		 * Kelas yang digunakan untuk merubah kode papan kunci ke dalam string
		 * 
		 * @return string
		 */
		public String rubahKeTeks() {
			StringBuilder pembuatTeks = new StringBuilder(); // Obyek strin
			if (tipe == KUNCI_BAWAH) { // Cek apakah papan kunci ditekan
				pembuatTeks.append("kunci bawah, "); // Jika iya, rubah ke teks
			} else { // Jika tidak
				pembuatTeks.append("kunci atas, "); // Rubah ke teks
			}

			pembuatTeks.append(kodeKunci);
			pembuatTeks.append(",");
			pembuatTeks.append(karakterKunci);

			return pembuatTeks.toString();
		}
	}

	/**
	 * Kelas yang sama seperti kelas KunciKejadian
	 * 
	 * @author nauin
	 *
	 */
	public static class KejadianSentuh {
		public static final int SENTUH_BAWAH = 0;
		public static final int SENTUH_ATAS = 1;
		public static final int SENTUH_GESER = 2;
		public static final int SENTUH_TAHAN = 3;

		public int tipe;
		public int x;
		public int y;
		public int penunjuk;

		public String rubahKeTeks() {
			StringBuilder pembuatTeks = new StringBuilder();
			if (tipe == SENTUH_BAWAH) {
				pembuatTeks.append("sentuh bawah, ");
			} else if (tipe == SENTUH_GESER) {
				pembuatTeks.append("sentuh geser, ");
			} else if (tipe == SENTUH_TAHAN) {
				pembuatTeks.append("sentuh tahan, ");
			} else {
				pembuatTeks.append("sentuh atas, ");
			}

			pembuatTeks.append(penunjuk);
			pembuatTeks.append(",");
			pembuatTeks.append(x);
			pembuatTeks.append(",");
			pembuatTeks.append(y);

			return pembuatTeks.toString();
		}
	}

	/**
	 * Method yang digunakan untuk mengecek apakah tombol ditekan
	 * 
	 * @param kodeTombol
	 *            kode dari tombol
	 * @return boolean
	 */
	public boolean isTombolDiTekan(int kodeTombol);

	/**
	 * Method yang digunakan untuk mengecek apakah layar disentuh
	 * 
	 * @param penunjuk
	 *            penujuk ketika layar disentuh
	 * @return boolean
	 */
	public boolean isDiSentuh(int penunjuk);

	/**
	 * Method yang digunakan untuk mendapatkan nilai sentuh dari X
	 * 
	 * @param penunjuk
	 *            penunjuk ketika layar disentuh
	 * @return penunjuk
	 */
	public int getSentuhX(int penunjuk);

	/**
	 * Method yang digunakan untuk mendapatkan nilai sentuh dari Y
	 * 
	 * @param penunjuk
	 *            penunjuk ketika layar disentuh
	 * @return penunjuk
	 */
	public int getSentuhY(int penunjuk);

	/**
	 * Method yang digunakan untuk mendapatkan nilai azimut
	 * 
	 * @return penunjuk
	 */
	public float getAzimut();

	/**
	 * Method yang digunakan untuk mendapatkan kunci kejadian atau event dari
	 * keyboard
	 * 
	 * @return kunci kejadian
	 */
	public List<KunciKejadian> getKunciKejadian();

	/**
	 * Method yang digunakan untuk mendapatkan kejadian sentuh atau event dari
	 * layar sentuh
	 * 
	 * @return kejadian sentuh
	 */
	public List<KejadianSentuh> getKejadianSentuh();
}
