package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.DKVDuaMain;
import org.tego.android.dkvdua.gameobject.PembuatArena;
import org.tego.android.dkvdua.utilitas.ManajemenSuara;
import org.tego.android.dkvdua.utilitas.PemuatAktiva;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
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
 * Kelas yang digunakan untuk melakukan penggambaran dari layar menu utama
 * 
 * @author blackshadow
 *
 */
public class LayarMenuUtama extends LayarAbstrak {
	public final static String TAG = LayarMenuUtama.class.getSimpleName();
	private SpriteBatch batcher;
	private OrthographicCamera camera;
	private int lebarDuniaGim;
	private int tinggiDuniaGim;
	private Stage stage;
	private InputMultiplexer inputMultiplexer;
	private TextureAtlas textureAtlas;
	private Skin skin;
	private BitmapFont bitmapFont;
	private Table table;
	private Table tableD;
	private LabelStyle labelStyle;
	private Label lblDorongKotak;
	private TextButtonStyle textButtonStyle;
	private TextButton txtBtnMulai;
	private TextButton txtBtnPilihan;
	private TextButton txtBtnKeluar;

	/**
	 * Konstruktor dari kelas
	 */
	public LayarMenuUtama(DKVDuaMain game) {
		super(game);
		buatLayar();
	}

	/**
	 * Method yang digunakan untuk membuat layar atau menampilkan semua grafik
	 * ke layar sehingga sedemikian rupa membentuk layar menu utama
	 */
	public void buatLayar() {
		lebarDuniaGim = 192;
		tinggiDuniaGim = 272;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, lebarDuniaGim, tinggiDuniaGim);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
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
		ManajemenSuara.manajemen.mainkan(PemuatAktiva.dkvduaMusicMysteryBox);
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
		skin.dispose();
		bitmapFont.dispose();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 3, 5, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.begin();

		batcher.end();

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(new StretchViewport(480, 640));
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
		Gdx.input.setCatchBackKey(true);

		textureAtlas = new TextureAtlas(Gdx.files.internal("data/dialog.atlas"));
		skin = new Skin();
		skin.addRegions(textureAtlas);

		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.fnt"),
				Gdx.files.internal("data/gfx/font/kenvectorFutureThin.png"),
				false);

		table = new Table(skin);
		tableD = new Table(skin);

		labelStyle = new LabelStyle();
		labelStyle.font = bitmapFont;
		labelStyle.fontColor = Color.WHITE;

		lblDorongKotak = new Label("Dorong\nKotak", labelStyle);
		lblDorongKotak.setFontScale(2f);
		lblDorongKotak.setTouchable(Touchable.disabled);
		lblDorongKotak.setAlignment(Align.center);

		textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button");
		textButtonStyle.down = skin.getDrawable("touched-button");
		textButtonStyle.font = bitmapFont;

		txtBtnMulai = new TextButton("Mulai", textButtonStyle);
		txtBtnMulai.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
				game.setScreen(new PembuatArena(game));
			}
		});

		txtBtnPilihan = new TextButton("Pilihan", textButtonStyle);
		txtBtnPilihan.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
				game.setScreen(new LayarPengaturan(game));
			}
		});

		txtBtnKeluar = new TextButton("Keluar", textButtonStyle);
		txtBtnKeluar.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				ManajemenSuara.manajemen.mainkan(PemuatAktiva.soundClick);
				game.setScreen(new LayarDialogKeluar(game));
			}
		});

		table.setBackground(skin.getDrawable("background"));
		table.defaults().pad(3f);
		table.add(lblDorongKotak);
		table.row();
		table.add(txtBtnMulai).expandX().fill();
		table.row();
		table.add(txtBtnPilihan).expandX().fill();
		table.row();
		table.add(txtBtnKeluar).expandX().fill();

		tableD.setBackground(skin.getDrawable("background"));
		tableD.setFillParent(true);
		tableD.defaults().pad(6f);
		tableD.add(table);

		stage.addActor(tableD);

		ManajemenSuara.manajemen.mainkan(PemuatAktiva.dkvduaMusicMysteryBox);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		ManajemenSuara.manajemen.hentikanMusik();
	}
}
