package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.utilitas.ManajemenSuara;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Kelas yang digunakan untuk menggambar layar Tentang Aplikasi
 * 
 * @author blackshadow
 *
 */
public class LayarTentangAplikasi extends LayarAbstrak {

	private Stage stage;
	private InputMultiplexer inputMultiplexer;
	private TextureAtlas textureAtlas;
	private Skin skin;
	private BitmapFont bitmapFont;
	private Table tabelDalam;
	private Table tabelLuar;
	private LabelStyle labelStyle;
	private Label lblTentang;
	private Label lblDorKot;
	private Label lblIsi;
	private TextButtonStyle textButtonStyle;
	private TextButton txtBtnKembali;
	private String teks = null;
	
	/**
	 * Konstruktor kelas
	 */
	public LayarTentangAplikasi(DKVDuaMain game) {
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

		teks = "Adalah pengembangan permainan dari Sokoban \n"
				+ "yang dibuat oleh Hiroyuki Imabayashi";
		
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));

		skin = new Skin();
		skin.addRegions(textureAtlas);

		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.fnt"),
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.png"),
				false);

		tabelDalam = new Table(skin);
		tabelLuar = new Table(skin);

		labelStyle = new LabelStyle();
		labelStyle.font = bitmapFont;
		labelStyle.fontColor = Color.WHITE;

		lblTentang = new Label("Tentang", labelStyle);
		lblTentang.setFontScale(1.5f);
		lblTentang.setAlignment(Align.center);

		lblDorKot = new Label("Dorong Kotak", labelStyle);
		lblDorKot.setFontScale(0.6f);
		lblDorKot.setAlignment(Align.center);

		lblIsi = new Label(teks, labelStyle);
		lblIsi.setFontScale(0.4f);
		lblIsi.setAlignment(Align.center);
		
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button");
		textButtonStyle.down = skin.getDrawable("touched-button");
		textButtonStyle.font = bitmapFont;

		txtBtnKembali = new TextButton("Kembali", textButtonStyle);
		txtBtnKembali.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
				game.setScreen(new LayarPengaturan(game));
			}
		});

		tabelDalam.setBackground(skin.getDrawable("background"));
		tabelDalam.defaults().pad(3f);
		tabelDalam.row();
		tabelDalam.add(lblTentang);
		tabelDalam.row();
		tabelDalam.add(lblDorKot);
		tabelDalam.row();
		tabelDalam.add(lblIsi);

		tabelLuar.setBackground(skin.getDrawable("background"));
		tabelLuar.setFillParent(true);
		tabelLuar.defaults().pad(6f);
		tabelLuar.row().center();
		tabelLuar.add(tabelDalam);
		tabelLuar.row();
		tabelLuar.add(txtBtnKembali).right().expandX();

		stage.addActor(tabelLuar);

		ManajemenSuara.manajemen.mainkan(PemuatAktiva.dkvduaMusicHappyEnding);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		ManajemenSuara.manajemen.hentikanMusik();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		ManajemenSuara.manajemen.hentikanMusik();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		ManajemenSuara.manajemen.mainkan(PemuatAktiva.dkvduaMusicHappyEnding);
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
