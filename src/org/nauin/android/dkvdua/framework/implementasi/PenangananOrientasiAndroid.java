/*
 * PenangananOrientasiAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * 
 * @author nauin
 *
 */
public class PenangananOrientasiAndroid implements PenangananOrientasi,
		SensorEventListener {
	SensorManager sensorManager;
	Sensor sensor;
	float azimut = 0.0F;

	public PenangananOrientasiAndroid(Context context) {
		sensorManager = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, sensor,
				SensorManager.SENSOR_DELAY_GAME);
	}

	@Override
	public float getAzimuth() {
		return azimut;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		azimut = (float) (Math.atan2((double) event.values[1],
				(double) event.values[0]) / (Math.PI * 2) * 360);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

}
