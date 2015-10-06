/**
 * 
 */
package org.tego.android.dkvdua.game.obyek;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Kelas yang menangani pemain dalam permainan
 * 
 * @author blackshadow
 *
 */
public class Pemain extends Actor {
	private PermainanDorongKotak permainanDorongKotak;
	private Rectangle batas;
	private final int UKURAN = 16;
	private PosisiKarakter posisiKarakter;

	private enum PosisiKarakter {
		DEPAN, BELAKANG, KIRI, KANAN
	}

	/**
	 * 
	 */
	public Pemain(PermainanDorongKotak permainanDorongKotak) {
		// TODO Auto-generated constructor stub
		this.permainanDorongKotak = permainanDorongKotak;
		setWidth(UKURAN);
		setHeight(UKURAN);
		posisiKarakter = PosisiKarakter.DEPAN;
	}

	public void setPosisiKarakter(PosisiKarakter posisiKarakter) {
		this.posisiKarakter = posisiKarakter;
	}

	public PosisiKarakter getPosisiKarakter() {
		return this.posisiKarakter;
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		perbaruiBatas();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		switch (getPosisiKarakter()) {
		case DEPAN:
			batch.draw(Kekayaan.pemain, getX(), getY(), getWidth() / 2,
					getHeight() / 2, getWidth(), getHeight(), 1, 1,
					getRotation());
			break;
		case BELAKANG:
			batch.draw(Kekayaan.pemainBelakang, getX(), getY(), getWidth() / 2,
					getHeight() / 2, getWidth(), getHeight(), 1, 1,
					getRotation());
			break;
		case KANAN:
			batch.draw(Kekayaan.pemainKanan, getX(), getY(), getWidth() / 2,
					getHeight() / 2, getWidth(), getHeight(), 1, 1,
					getRotation());
			break;
		case KIRI:
			batch.draw(Kekayaan.pemainKiri, getX(), getY(), getWidth() / 2,
					getHeight() / 2, getWidth(), getHeight(), 1, 1,
					getRotation());
			break;
		default:
			batch.draw(Kekayaan.pemain, getX(), getY(), getWidth() / 2,
					getHeight() / 2, getWidth(), getHeight(), 1, 1,
					getRotation());
			break;
		}
	}

	private void perbaruiBatas() {
		batas.set(getX(), getY(), getWidth(), getHeight());
	}

	public Rectangle getBatas() {
		return batas;
	}

	public void bergerakKeAtas() {

	}

	public void bergerakKeBawah() {

	}

	public void bergerakKeKiri() {

	}

	public void bergerakKeKanan() {

	}
}
