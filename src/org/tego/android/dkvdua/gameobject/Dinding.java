/*
 * Dinding.java
 * 
 * Copyright (C) 2014 Adnanto A.R. a.k.a BlackShadow <adnantoa@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.tego.android.dkvdua.gameobject;

import org.tego.android.dkvdua.game.Assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Kelas yang digunakan untuk mengatur atau menggambar dinding yang digunakan
 * dalam penggambaran game
 * 
 * @author blackshadow
 *
 */
public class Dinding extends AbstractGameObject {
	private TextureRegion texRegDindingAtas;
	private TextureRegion texRegDindingBawah;
	private TextureRegion texRegDindingKanan;
	private TextureRegion texRegDindingKananAtas;
	private TextureRegion texRegDindingKananBawah;
	private TextureRegion texRegDindingKiri;
	private TextureRegion texRegDindingKiriAtas;
	private TextureRegion texRegDindingKiriBawah;
	private TextureRegion textureRegion;

	private TipeDinding tipeDinding;

	public enum TipeDinding {
		DINDING_ATAS, DINDING_BAWAH, DINDING_KANAN, DINDING_KANAN_ATAS, DINDING_KANAN_BAWAH, DINDING_KIRI, DINDING_KIRI_ATAS, DINDING_KIRI_BAWAH
	}

	public Dinding() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		/*
		 * dimension.set(1, 1); texRegDindingAtas =
		 * Assets.instance.dinding.dindingAtas; texRegDindingBawah =
		 * Assets.instance.dinding.dindingBawah; texRegDindingKanan =
		 * Assets.instance.dinding.dindingKanan; texRegDindingKananAtas =
		 * Assets.instance.dinding.dindingKananAtas; texRegDindingKananBawah =
		 * Assets.instance.dinding.dindingKananBawah; texRegDindingKiri =
		 * Assets.instance.dinding.dindingKiri; texRegDindingKiriAtas =
		 * Assets.instance.dinding.dindingKiriAtas; texRegDindingKiriBawah =
		 * Assets.instance.dinding.dindingKiriBawah;
		 */
	}

	public void setTipeDinding(TipeDinding tipeDinding) {
		this.tipeDinding = tipeDinding;
	}

	public TipeDinding getTipeDinding() {
		return tipeDinding;
	}

	public void setTexture(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public TextureRegion getTexture() {
		return textureRegion;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		textureRegion = null;

		switch (getTipeDinding()) {
		case DINDING_ATAS:
			setTexture(texRegDindingAtas);
			gambar(textureRegion, batch);
			break;
		case DINDING_BAWAH:
			setTexture(texRegDindingBawah);
			gambar(textureRegion, batch);
			break;
		case DINDING_KANAN:
			setTexture(texRegDindingKanan);
			gambar(textureRegion, batch);
			break;
		case DINDING_KANAN_ATAS:
			setTexture(texRegDindingKananAtas);
			gambar(textureRegion, batch);
			break;
		case DINDING_KANAN_BAWAH:
			setTexture(texRegDindingKananBawah);
			gambar(textureRegion, batch);
			break;
		case DINDING_KIRI:
			setTexture(texRegDindingKiri);
			gambar(textureRegion, batch);
			break;
		case DINDING_KIRI_ATAS:
			setTexture(texRegDindingKiriAtas);
			gambar(textureRegion, batch);
			break;
		case DINDING_KIRI_BAWAH:
			setTexture(texRegDindingKiriBawah);
			gambar(textureRegion, batch);
			break;
		default:
			getTexture();
			break;
		}
	}

	private void gambar(TextureRegion textureRegion, SpriteBatch batch) {
		batch.draw(textureRegion.getTexture(), position.x, position.y,
				origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
				0, textureRegion.getRegionX(), textureRegion.getRegionY(),
				textureRegion.getRegionWidth(),
				textureRegion.getRegionHeight(), false, false);
	}
}
