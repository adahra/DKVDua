/*
 * GetaranAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import org.nauin.android.dkvdua.framework.Getaran;

import android.content.Context;
import android.os.Vibrator;

/**
 * 
 * @author nauin
 *
 */
public class GetaranAndroid implements Getaran {
	Vibrator vibrator;
	
	public GetaranAndroid(Context context) {
		vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Override
	public void getar(int waktu) {
		vibrator.vibrate((long)(waktu));
	}

}
