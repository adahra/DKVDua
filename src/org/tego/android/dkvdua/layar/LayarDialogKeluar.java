package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
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

public class LayarDialogKeluar implements Screen, InputProcessor {

	private DKVDuaMain permainan;
	private static boolean tampilDialogKeluar;
	public Stage stage;
	private BitmapFont bitmapFont;

	public LayarDialogKeluar(DKVDuaMain permainan) {
		this.setPermainan(permainan);
		bitmapFont = new BitmapFont(Gdx.files.internal("data/gfx/font/chancery.fnt"),
				Gdx.files.internal("data/gfx/font/chancery.png"), false);
	}

	public void tampilDialogKeluar(Stage stage) {
		TextureAtlas textureAtlas;
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));
		Skin skin = new Skin();
		skin.addRegions(textureAtlas);

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
		Label label = new Label("Anda yakin mau keluar?", labelStyle);
		label.setAlignment(Align.center);

		Dialog dialog = new Dialog("", windowStyle) {

			@Override
			protected void result(Object object) {
				boolean keluar = (Boolean) object;
				if (keluar) {
					Gdx.app.exit();
				} else {
					remove();
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

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {
		Gdx.input.setCatchBackKey(true);
		stage = new Stage(new StretchViewport(480, 640));
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(this);
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		tampilDialogKeluar(stage);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public DKVDuaMain getPermainan() {
		return permainan;
	}

	public void setPermainan(DKVDuaMain permainan) {
		this.permainan = permainan;
	}

}
