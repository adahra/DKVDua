/**
 * 
 */
package org.tego.android.dkvdua.ui;

import org.tego.android.dkvdua.gameobject.Obyek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * @author blackshadow
 *
 */
public class Tulisan extends Obyek {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2685992405433737543L;
	/**
	 * Fonta huruf internal digunakan
	 */
	private BitmapFont bitmapFont = null;
	/**
	 * Tulisan yang akan ditampilkan
	 */
	private String teks = null;

	/**
	 * @param x
	 * @param y
	 */
	public Tulisan(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
	}

	public Tulisan(int x, int y, String lokasi, boolean flip) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.bitmapFont = new BitmapFont(Gdx.files.internal(lokasi), flip);
	}

	public Tulisan(int x, int y, String lokasi, boolean flip, String teks) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.bitmapFont = new BitmapFont(Gdx.files.internal(lokasi), flip);
		this.setTeks(teks);
	}

	public void setTeks(String teks) {
		// TODO Auto-generated method stub
		this.teks = teks;
	}

	public Tulisan(int x, int y, String lokasi, boolean flip, Vector2 posisi) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.bitmapFont = new BitmapFont(Gdx.files.internal(lokasi), flip);
		this.setPosition(posisi);
	}

	public Tulisan(int x, int y, String lokasi, boolean flip, float skala,
			Vector2 posisi) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.bitmapFont = new BitmapFont(Gdx.files.internal(lokasi), flip);
		this.setSkala(skala);
		this.setPosition(posisi);
	}

	public void setSkala(float skala) {
		// TODO Auto-generated method stub
		this.bitmapFont.setScale(skala);
	}

	public void setSkala(float skalaX, float skalaY) {
		this.bitmapFont.setScale(skalaX, skalaY);
	}

	public Tulisan(int x, int y, String lokasi, boolean flip, float skala,
			Vector2 posisi, String teks) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.bitmapFont = new BitmapFont(Gdx.files.internal(lokasi), flip);
		this.setSkala(skala);
		this.setPosition(posisi);
		this.setTeks(teks);
	}

	public void render(SpriteBatch sbGambar, float ppuX, float ppuY) {
		this.bitmapFont.draw(sbGambar, teks, this.getX() * ppuX,
				this.getY() * ppuY);
	}

	public void render(SpriteBatch sbGambar) {
		this.bitmapFont.draw(sbGambar, teks, this.getX(),
				this.getY());
	}

	public float getSkalaX() {
		return bitmapFont.getScaleX();
	}

	public float getSkalaY() {
		return bitmapFont.getScaleY();
	}

	public String getTeks() {
		return this.teks;
	}

	public float getLebarPixel() {
		return bitmapFont.getBounds(teks).width;
	}

	public float getTinggiPixel() {
		return bitmapFont.getBounds(teks).height;
	}

	public float getLebarRelatif(float lebarLayar) {
		return (bitmapFont.getBounds(teks).width / lebarLayar);
	}

	public float getTinggiRelatif(float tinggiLayar) {
		return (bitmapFont.getBounds(teks).height / tinggiLayar);
	}

	public boolean disentuh(Vector2 posisiSentuh, float lebarLayar,
			float tinggiLayar) {
		return posisiSentuh.x > this.getX()
				&& posisiSentuh.x < this.getX()
						+ getLebarRelatif(lebarLayar)
				&& posisiSentuh.y > this.getY()
						- getTinggiRelatif(tinggiLayar)
				&& posisiSentuh.y < this.getY();
	}
}
