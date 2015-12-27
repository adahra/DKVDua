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
	private static final long serialVersionUID = 2114881509840914039L;

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

	public TextureRegion getTrGambar() {
		return trGambar;
	}

	public void setTrGambar(TextureRegion trGambar) {
		this.trGambar = trGambar;
	}

	public boolean isTabrakanKiri(Obyek obyek) {
		return ((this.getX() - JARAK) == obyek.getX())
				&& (this.getY() == obyek.getY());
	}

	public boolean isTabrakanKanan(Obyek obyek) {
		return ((this.getX() + JARAK) == obyek.getX())
				&& (this.getY() == obyek.getY());
	}

	public boolean isTabrakanAtas(Obyek obyek) {
		return ((this.getY() - JARAK) == obyek.getY())
				&& (this.getX() == obyek.getX());
	}

	public boolean isTabrakanBawah(Obyek obyek) {
		return ((this.getY() + JARAK) == obyek.getY())
				&& (this.getX() == obyek.getX());
	}
}
