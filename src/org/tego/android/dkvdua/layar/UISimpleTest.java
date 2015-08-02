package org.tego.android.dkvdua.layar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Kelas yang digunakan untuk membuat/melakukan test terhadap layar yang dibuat
 * (User Interface)
 * 
 * @author blackshadow
 *
 */
public class UISimpleTest implements Screen {
	private Skin mSkin;
	private Stage mStage;
	private SpriteBatch mSpriteBatch;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		mStage.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		mStage.getViewport().update(width, height, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		mSpriteBatch = new SpriteBatch();
		mStage = new Stage();
		Gdx.input.setInputProcessor(mStage);

		mSkin = new Skin();

		Pixmap mPixmap = new Pixmap(1, 1, Format.RGBA8888);
		mPixmap.setColor(Color.WHITE);
		mPixmap.fill();
		mSkin.add("white", new Texture(mPixmap));
		mSkin.add("default", new BitmapFont());

		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = mSkin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = mSkin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = mSkin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = mSkin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = mSkin.getFont("default");
		mSkin.add("default", textButtonStyle);

		Table mTable = new Table();
		mTable.setFillParent(true);
		mStage.addActor(mTable);

		final TextButton button = new TextButton("Click Me!", mSkin);
		mTable.add(button);

		button.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Clicked! Is checked: " + button.isChecked());
				button.setText("Good job!");
			}
		});

		mTable.add(new Image(mSkin.newDrawable("white", Color.RED))).size(64);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		mStage.dispose();
		mSkin.dispose();
	}

}
