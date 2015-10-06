/**
 * 
 */
package org.tego.android.dkvdua;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * @author blackshadow
 *
 */
public class BareBoneStage extends ApplicationAdapter {
	private Stage stage;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		
		Skin skin = new Skin(Gdx.files.internal("data/gfx/ui/uiskin.json"));
		BitmapFont bitmapFont = new BitmapFont(Gdx.files.internal("data/gfx/font/dkvduafont/default.fnt"));
		Label label = new Label("Some Label", skin);
		TextButton button = new TextButton("Some Button", skin);
		
		Table table = new Table();
		stage.addActor(table);
		table.setFillParent(true);
		
		table.debug();
		table.defaults().space(6);
		table.add(label);
		table.add(button);
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, true);
	}
}
