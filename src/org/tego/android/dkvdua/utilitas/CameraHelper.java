package org.tego.android.dkvdua.utilitas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraHelper {
	public static final String TAG = CameraHelper.class.getSimpleName();
	
	private final float MAX_ZOOM_IN = 0.25f;
	private final float MAX_ZOOM_OUT = 10.0f;
	
	private Vector2 position;
	private float zoom;
	
	public CameraHelper() {
		// TODO Auto-generated constructor stub
		position = new Vector2();
		zoom = 1.0f;
	}

	public void update(float deltaTime) {
		
	}
	
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void addZoom(float amount) {
		setZoom(zoom + amount);
	}
	
	public void setZoom(float zoom) {
		this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
	}
	
	public float getZoom() {
		return zoom;
	}
	
	public void setTarget() {
		
	}
	
	public boolean hasTarget() {
		return false;
	}
	
	public boolean hasTarget(String target) {
		return hasTarget() && target.equals(target);
	}
	
	public void applyTo(OrthographicCamera camera) {
		camera.position.x = position.x;
		camera.position.y = position.y;
		camera.zoom = zoom;
		camera.update();
	}
}
