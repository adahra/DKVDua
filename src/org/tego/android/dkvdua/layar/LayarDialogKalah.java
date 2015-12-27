/**
 * 
 */
package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.gameobject.PembuatArena;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * @author blackshadow
 *
 */
public class LayarDialogKalah extends LayarAbstrak {
	private static boolean tampilDialog;
	private Stage stage = null;
	

	/**
	 * 
	 */
	public LayarDialogKalah(DKVDuaMain game) {
		// TODO Auto-generated constructor stub
		super(game);
	}

	public void tampilDialogKalah(Stage stage) {
		TextureAtlas textureAtlas;
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));
		Skin skin = new Skin();
		skin.addRegions(textureAtlas);

		BitmapFont bitmapFont;
		bitmapFont = new BitmapFont(Gdx.files.internal("data/gfx/font/dkvduafont/text.fnt"),
				Gdx.files.internal("data/gfx/font/dkvduafont/text.png"), false);

		Window.WindowStyle windowStyle = new Window.WindowStyle();
		windowStyle.titleFont = bitmapFont;
		NinePatch background = skin.getPatch("background");
		windowStyle.background = new NinePatchDrawable(background);

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button");
		textButtonStyle.down = skin.getDrawable("touched-button");
		textButtonStyle.font = bitmapFont;

		Label.LabelStyle labelStyle = new Label.LabelStyle(bitmapFont,
				Color.WHITE);
		Label label = new Label("Anda Kalah!\nMulai Lagi?", labelStyle);
		label.setAlignment(Align.center);

		Dialog dialog = new Dialog("", windowStyle) {

			@Override
			protected void result(Object object) {
				boolean keluar = (Boolean) object;
				if (keluar) {
					game.setScreen(new PembuatArena(game));
				} else {
					game.setScreen(new LayarMenuUtama(game));
				}
				
				tampilDialog = false;
			}

			@Override
			public Dialog show(Stage stage) {
				tampilDialog = true;
				return super.show(stage);
			}

			@Override
			public void cancel() {
				tampilDialog = false;
				super.cancel();
			}
		};
		dialog.button("Ya", true, textButtonStyle);
		dialog.button("Tidak", false, textButtonStyle);
		dialog.getContentTable().add(label);
		if (!tampilDialog) {
			dialog.show(stage);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(new StretchViewport(480, 640));
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		tampilDialogKalah(stage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
