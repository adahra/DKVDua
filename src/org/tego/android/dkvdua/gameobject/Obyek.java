/**
 * 
 */
package org.tego.android.dkvdua.gameobject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author blackshadow
 *
 */
public class Obyek {
	public static final String TAG = Obyek.class.getSimpleName();
	
	private final int JARAK = 16;
	private Vector2 vPosisi = new Vector2();
	private Rectangle rBatas = new Rectangle();
	private TextureRegion trGambar = null;
	
	/**
	 * 
	 */
	public Obyek(int x, int y) {
		// TODO Auto-generated constructor stub
		vPosisi.x = x;
		vPosisi.y = y;
		rBatas.x = x;
		rBatas.y = y;
		rBatas.width = rBatas.x;
		rBatas.height = rBatas.y;
	}

	public Vector2 getvPosisi() {
		return vPosisi;
	}

	public void setPosisiX(float vPosisi) {
		this.vPosisi.x = vPosisi;
	}
	
	public float getPosisiX() {
		return this.vPosisi.x;
	}
	
	public void setPosisiY(float vPosisi) {
		this.vPosisi.y = vPosisi;
	}
	
	public float getPosisiY() {
		return this.vPosisi.y;
	}
	
	public void setvPosisi(Vector2 vPosisi) {
		this.vPosisi = vPosisi;
	}

	public Rectangle getrBatas() {
		return rBatas;
	}

	public void setrBatas(Rectangle rBatas) {
		this.rBatas = rBatas;
	}

	public TextureRegion getTrGambar() {
		return trGambar;
	}

	public void setTrGambar(TextureRegion trGambar) {
		this.trGambar = trGambar;
	}
	
	public boolean isTabrakanKiri(Obyek obyek) {
		return ((getrBatas().x - JARAK) == obyek.rBatas.x ) && (getrBatas().y == obyek.rBatas.y);
	}
	
	public boolean isTabrakanKanan(Obyek obyek) {
		return ((getrBatas().x + JARAK) == obyek.rBatas.x) && (getrBatas().y == obyek.rBatas.y);
	}
	
	public boolean isTabrakanAtas(Obyek obyek) {
		return ((getrBatas().y - JARAK) == obyek.rBatas.y) && (getrBatas().x == obyek.rBatas.x); 
	}
	
	public boolean isTabrakanBawah(Obyek obyek) {
		return ((getrBatas().y + JARAK) == obyek.rBatas.y) && (getrBatas().x == obyek.rBatas.x);
	}
}
