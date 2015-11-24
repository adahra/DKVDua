/**
 * 
 */
package org.tego.android.dkvdua.gameobject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author blackshadow
 *
 */
public class Obyek extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2146870618165367924L;

	public static final String TAG = Obyek.class.getSimpleName();

	private final int JARAK = 16;
	private TextureRegion trGambar = null;

	/**
	 * 
	 */
	public Obyek(int x, int y) {
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
		this.setWidth(JARAK);
		this.setHeight(JARAK);
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public TextureRegion getTrGambar() {
		return trGambar;
	}

	public void setTrGambar(TextureRegion trGambar) {
		this.trGambar = trGambar;
	}

	public boolean isTabrakanKiri(Obyek obyek) {
		return ((this.x - JARAK) == obyek.x)
				&& (this.y == obyek.y);
	}

	public boolean isTabrakanKanan(Obyek obyek) {
		return ((this.x + JARAK) == obyek.x)
				&& (this.y == obyek.y);
	}

	public boolean isTabrakanAtas(Obyek obyek) {
		return ((this.y - JARAK) == obyek.y)
				&& (this.x == obyek.x);
	}

	public boolean isTabrakanBawah(Obyek obyek) {
		return ((this.y + JARAK) == obyek.y)
				&& (this.x == obyek.x);
	}
}
