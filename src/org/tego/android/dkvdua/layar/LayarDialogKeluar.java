package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.utilitas.ManajemenSuara;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

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

public class LayarDialogKeluar extends LayarAbstrak {
	private static boolean tampilDialogKeluar;
	public Stage stage;

	public LayarDialogKeluar(DKVDuaMain permainan) {
		super(permainan);
	}

	public void tampilDialogKeluar(Stage stage) {
		TextureAtlas textureAtlas;
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));
		Skin skin = new Skin();
		skin.addRegions(textureAtlas);

		BitmapFont bitmapFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.fnt"),
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.png"),
				false);

		Window.WindowStyle windowStyle = new Window.WindowStyle();
		windowStyle.titleFont = bitmapFont;
		windowStyle.stageBackground = skin.getDrawable("background");
		NinePatch background = skin.getPatch("background");
		windowStyle.background = new NinePatchDrawable(background);

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button");
		textButtonStyle.down = skin.getDrawable("touched-button");
		textButtonStyle.font = bitmapFont;

		Label.LabelStyle labelStyle = new Label.LabelStyle(bitmapFont,
				Color.WHITE);
		Label label = new Label("Anda yakin\nmau keluar?", labelStyle);
		label.setAlignment(Align.center);

		Dialog dialog = new Dialog("", windowStyle) {

			@Override
			protected void result(Object object) {
				boolean keluar = (Boolean) object;
				
				if (keluar) {
					ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
					Gdx.app.exit();
				} else {
					ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
					game.setScreen(new LayarMenuUtama(game));
				}

				tampilDialogKeluar = false;
			}

			@Override
			public Dialog show(Stage stage) {
				tampilDialogKeluar = true;
				return super.show(stage);
			}

			@Override
			public void cancel() {
				tampilDialogKeluar = false;
				super.cancel();
			}
		};
		dialog.button("Ya", true, textButtonStyle);
		dialog.button("Tidak", false, textButtonStyle);
		dialog.getContentTable().add(label);
		if (!tampilDialogKeluar)
			dialog.show(stage);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 3, 5, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {
		Gdx.input.setCatchBackKey(true);
		stage = new Stage(new StretchViewport(480, 640));
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);

		tampilDialogKeluar(stage);
	}

	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}

	@Override
	public void hide() {

	}
}
