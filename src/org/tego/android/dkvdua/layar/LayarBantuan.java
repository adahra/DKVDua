package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Kelas yang digunakan untuk membuat layar Bantuan
 * 
 * @author blackshadow
 *
 */
public class LayarBantuan extends LayarAbstrak {

	private Stage stage;
	private InputMultiplexer inputMultiplexer;
	private TextureAtlas textureAtlas;
	private Skin skin;
	private BitmapFont bitmapFont;
	private Table tabelDalam;
	private Table tabelLuar;
	private LabelStyle labelStyle;
	private Label lblBantuan;
	private Label lblIsiBantuan;
	private TextButtonStyle textButtonStyle;
	private TextButton txtBtnKembali;
	private String bantuan;

	/**
	 * Konstruktor dari kelas
	 */
	public LayarBantuan(DKVDuaMain game) {
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

		bantuan = "Jawab pertanyaan dengan\n" + "mengisi kotak isian\n"
				+ "yang ada pada pojok\n" + "kiri layar. Klik\n"
				+ "pertanyaan untuk\n" + "mengetahui jawaban. Setelah\n"
				+ "berhasil menjawab pertanyaan\n" + "yang ada maka kotak\n"
				+ "akan muncul dan dorong\n"
				+ "kotak ke dalam lubang yang ada.";

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

		lblBantuan = new Label("Bantuan", labelStyle);
		lblBantuan.setFontScale(1.5f);
		lblBantuan.setAlignment(Align.center);

		lblIsiBantuan = new Label(bantuan, labelStyle);
		lblIsiBantuan.setFontScale(0.6f);
		lblIsiBantuan.setAlignment(Align.center);

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
				PemuatAktiva.soundClick.play();
				game.setScreen(new LayarPengaturan(game));
			}
		});

		tabelDalam.setBackground(skin.getDrawable("background"));
		tabelDalam.defaults().pad(3f);
		tabelDalam.row();
		tabelDalam.add(lblBantuan);
		tabelDalam.row();
		tabelDalam.add(lblIsiBantuan);

		tabelLuar.setBackground(skin.getDrawable("background"));
		tabelLuar.setFillParent(true);
		tabelLuar.defaults().pad(6f);
		tabelLuar.row().center();
		tabelLuar.add(tabelDalam);
		tabelLuar.row();
		tabelLuar.add(txtBtnKembali).right().expandX();

		stage.addActor(tabelLuar);
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
