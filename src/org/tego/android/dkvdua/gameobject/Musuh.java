/*
 * Musuh.java
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
 * Kelas yang digunakan untuk menangani pergerakah musuh, penampakan musuh, dan
 * semua kecerdasan yang ada pada musuh
 * 
 * @author blackshadow
 *
 */
public class Musuh extends AbstractGameObject {
	private TextureRegion texRegMusuhBelakang;
	private TextureRegion texRegMusuhDepan;
	private TextureRegion texRegMusuhKanan;
	private TextureRegion texRegMusuhKiri;
	private TextureRegion textureRegion;
	private Lubang lubang;
	private TipeMusuh tipeMusuh;

	public enum TipeMusuh {
		MUSUH_BELAKANG, MUSUH_DEPAN, MUSUH_KANAN, MUSUH_KIRI
	}

	public Musuh() {
		init();
	}

	public void setTipeMusuh(TipeMusuh tipeMusuh) {
		this.tipeMusuh = tipeMusuh;
	}

	public TipeMusuh getTipeMusuh() {
		return tipeMusuh;
	}

	public void setLubang(float x, float y) {
		position.x = x;
		position.y = y;
	}

	public Lubang getLubang() {
		return lubang;
	}

	public void setTexture(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public TextureRegion getTexture() {
		return textureRegion;
	}

	private void init() {
		dimension.set(1, 1);
		texRegMusuhBelakang = Assets.instance.musuh.musuhBelakang;
		texRegMusuhDepan = Assets.instance.musuh.musuhDepan;
		texRegMusuhKanan = Assets.instance.musuh.musuhKanan;
		texRegMusuhKiri = Assets.instance.musuh.musuhKiri;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		textureRegion = null;

		switch (getTipeMusuh()) {
		case MUSUH_BELAKANG:
			setTexture(texRegMusuhBelakang);
			gambar(textureRegion, batch);
			break;
		case MUSUH_DEPAN:
			setTexture(texRegMusuhDepan);
			gambar(textureRegion, batch);
			break;
		case MUSUH_KANAN:
			setTexture(texRegMusuhKanan);
			gambar(textureRegion, batch);
			break;
		case MUSUH_KIRI:
			setTexture(texRegMusuhKiri);
			gambar(textureRegion, batch);
			break;
		default:
			getTexture();
			break;
		}
	}

	private void gambar(TextureRegion textureRegion, SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(textureRegion.getTexture(), position.x, position.y,
				origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
				0, textureRegion.getRegionX(), textureRegion.getRegionY(),
				textureRegion.getRegionWidth(),
				textureRegion.getRegionHeight(), false, false);
	}
}
