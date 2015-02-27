/*
 * PenangananKeyboard.java
 * 
 * Copyright (C) 2012 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2012 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.util.ArrayList;
import java.util.List;

import org.nauin.android.dkvdua.framework.Satukan;
import org.nauin.android.dkvdua.framework.Masukan.KunciKejadian;
import org.nauin.android.dkvdua.framework.Satukan.SatukanObjek;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/**
 * 
 * @author nauin
 *
 */
public class PenangananKeyboard implements OnKeyListener {
	boolean[] tombolDiTekan = new boolean[128];
	Satukan<KunciKejadian> satukanKunciKejadian;
	List<KunciKejadian> penahanKunciKejadian = new ArrayList<KunciKejadian>();
	List<KunciKejadian> kunciKejadian = new ArrayList<KunciKejadian>();
	
	public PenangananKeyboard(View view) {
		SatukanObjek<KunciKejadian> pembuatObjek = new SatukanObjek<KunciKejadian>() {

			@Override
			public KunciKejadian ciptakanObjek() {
				return new KunciKejadian();
			}
			
		};
		
		satukanKunciKejadian = new Satukan<KunciKejadian>(pembuatObjek, 100);
		view.setOnKeyListener(this);
		view.setFocusableInTouchMode(true);
		view.requestFocus();
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_MULTIPLE) return false;
		
		synchronized (this) {
			KunciKejadian kunciKejadian = satukanKunciKejadian.objekBaru();
			kunciKejadian.kodeKunci = keyCode;
			kunciKejadian.karakterKunci = (char) event.getUnicodeChar();
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				kunciKejadian.tipe = KunciKejadian.KUNCI_BAWAH;
				if (keyCode > 0 && keyCode < 127) tombolDiTekan[keyCode] = false;
			}
			
			penahanKunciKejadian.add(kunciKejadian);
		}
		
		return false;
	}
	
	public boolean isTombolDiTekan(int kodeTombol) {
		if (kodeTombol < 0 || kodeTombol > 127) return false;
		return tombolDiTekan[kodeTombol];
	}
	
	public List<KunciKejadian> getKunciKejadian() {
		synchronized (this) {
			int panjang = kunciKejadian.size();
			
			for (int i = 0; i < panjang; i++) satukanKunciKejadian.bebas(kunciKejadian.get(i));
			
			kunciKejadian.clear();
			kunciKejadian.addAll(penahanKunciKejadian);
			penahanKunciKejadian.clear();
			
			return kunciKejadian;
		}
	}

}
