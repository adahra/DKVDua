/*
 * Lubang.java
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
 * Kelas yang digunakan untuk mengatur gambar lubang yang ada pada permainan dan
 * untuk mengatur tata letak dari lubang dimana musuh keluar
 * 
 * @author blackshadow
 *
 */
public class Lubang extends AbstractGameObject {
	private TextureRegion texRegLubang;

	public Lubang() {
		init();
	}

	private void init() {
		dimension.set(1, 1);
		texRegLubang = Assets.instance.lubang.lubang;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		TextureRegion textureRegion = null;
		textureRegion = texRegLubang;
		batch.draw(textureRegion.getTexture(), position.x, position.y,
				origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
				0, textureRegion.getRegionX(), textureRegion.getRegionY(),
				textureRegion.getRegionWidth(),
				textureRegion.getRegionHeight(), false, false);
	}

}
