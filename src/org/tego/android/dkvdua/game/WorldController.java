package org.tego.android.dkvdua.game;

import org.tego.android.dkvdua.utilitas.CameraHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class WorldController extends InputAdapter {
	public static final String TAG = WorldController.class.getSimpleName();

	public CameraHelper cameraHelper;
	
	public WorldController() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init() {
		Gdx.input.setInputProcessor(this);
		cameraHelper = new CameraHelper();
	}
	
	public void update(float deltaTime) {
		cameraHelper.update(deltaTime);
	}
}
