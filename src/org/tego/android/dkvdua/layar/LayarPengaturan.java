package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Kelas yang digunakan untuk menggambar layar Pengaturan
 * 
 * @author blackshadow
 *
 */
public class LayarPengaturan extends LayarAbstrak {
	public static final String TAG = LayarPengaturan.class.getSimpleName();
	private Stage stage;
	private InputMultiplexer inputMultiplexer;
	private TextureAtlas textureAtlas;
	private Texture textureCheckBox;
	private Texture textureUnCheckBox;
	private Skin skin;
	private BitmapFont bitmapFont;
	private Table table;
	private Table tableC;
	private Table tableD;
	private LabelStyle labelStyle;
	private Label lblPengaturan;
	private CheckBoxStyle checkBoxStyle;
	private CheckBox chkSuara;
	private CheckBox chkMusik;
	private TextButtonStyle textButtonStyle;
	private TextButton txtBtnBantuan;
	private TextButton txtBtnKredit;
	private TextButton txtBtnKembali;

	/**
	 * Konstruktor dari kelas
	 */
	public LayarPengaturan(DKVDuaMain game) {
		super(game);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 3, 5, 0);
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
		stage.getViewport().update(width, height, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		stage = new Stage(new StretchViewport(480, 640));
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
		Gdx.input.setCatchBackKey(true);

		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));
		textureCheckBox = new Texture(
				Gdx.files.internal("data/gfx/ui/window/blue_boxCross.png"));
		textureUnCheckBox = new Texture(
				Gdx.files.internal("data/gfx/ui/window/grey_box.png"));

		skin = new Skin();
		skin.addRegions(textureAtlas);
		skin.add("checkBox", textureCheckBox);
		skin.add("unCheckBox", textureUnCheckBox);

		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.fnt"),
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.png"),
				false);

		table = new Table(skin);
		tableC = new Table(skin);
		tableD = new Table(skin);

		labelStyle = new LabelStyle();
		labelStyle.font = bitmapFont;
		labelStyle.fontColor = Color.WHITE;

		lblPengaturan = new Label("Pengaturan", labelStyle);
		lblPengaturan.setFontScale(1.5f);
		lblPengaturan.setAlignment(Align.center);
		lblPengaturan.setTouchable(Touchable.disabled);

		textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button");
		textButtonStyle.down = skin.getDrawable("touched-button");
		textButtonStyle.font = bitmapFont;

		txtBtnBantuan = new TextButton("Bantuan", textButtonStyle);
		txtBtnBantuan.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				PemuatAktiva.soundClick.play();
				game.setScreen(new LayarBantuan(game));
			}
		});

		txtBtnKredit = new TextButton("Credits", textButtonStyle);
		txtBtnKredit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				PemuatAktiva.soundClick.play();
			}
		});

		txtBtnKembali = new TextButton("Kembali", textButtonStyle);
		txtBtnKembali.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				PemuatAktiva.soundClick.play();
				game.setScreen(new LayarMenuUtama(game));
			}
		});

		checkBoxStyle = new CheckBoxStyle();
		checkBoxStyle.checkboxOn = skin.getDrawable("checkBox");
		checkBoxStyle.checkboxOff = skin.getDrawable("unCheckBox");
		checkBoxStyle.font = bitmapFont;

		chkSuara = new CheckBox("Suara", checkBoxStyle);
		chkSuara.setChecked(true);
		chkSuara.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub
				PemuatAktiva.soundClick.play();
			}
		});

		chkMusik = new CheckBox("Musik", checkBoxStyle);
		chkMusik.setChecked(true);
		chkMusik.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub
				PemuatAktiva.soundClick.play();
			}
		});

		table.setBackground(skin.getDrawable("background"));
		table.defaults().pad(3f);
		table.row();
		table.add(lblPengaturan);
		table.row();
		table.add(chkSuara);
		table.row();
		table.add(chkMusik);
		table.row();
		table.add(txtBtnBantuan);

		// tableC.setBackground(skin.getDrawable("background"));
		tableC.defaults().pad(3f);
		tableC.row();
		tableC.add(txtBtnKredit).left().expandX();
		tableC.add(txtBtnKembali).left().expandX();
		
		tableD.setBackground(skin.getDrawable("background"));
		tableD.setFillParent(true);
		tableD.defaults().pad(3f);
		tableD.row().center();
		tableD.add(table);
		tableD.row();
		tableD.add(tableC);

		stage.addActor(tableD);
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
		stage.dispose();
		textureAtlas.dispose();
		bitmapFont.dispose();
		skin.dispose();
	}

}
