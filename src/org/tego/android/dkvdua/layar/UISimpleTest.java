package org.tego.android.dkvdua.layar;

import org.tego.android.dkvdua.gameobject.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

/**
 * Kelas yang digunakan untuk membuat/melakukan test terhadap layar yang dibuat
 * (User Interface)
 * 
 * @author blackshadow
 *
 */
public class UISimpleTest implements Screen {
	private TiledMap map;
	private MapLayers layers;
	private TiledMapTileLayer layerLantai;
	private TiledMapTileLayer layerDinding;
	private TiledMapRenderer renderer;
	private Texture tiles;
	private TextureRegion[][] splitTiles;
	private Cell cell;
	private SpriteBatch spriteBatch;
	private OrthographicCamera oCamera;
	private float lebar = Gdx.graphics.getWidth();
	private float tinggi = Gdx.graphics.getHeight();
	private int[][] arrayPetaLantai = new int[][] {
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 } };

	private int[][] arrayPetaHalangan = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9 } };

	private int[][] arrayPetaObyek = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	public UISimpleTest() {
		// TODO Auto-generated constructor stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		oCamera.update();
		renderer.setView(oCamera);
		renderer.render();
		spriteBatch.begin();

		spriteBatch.end();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// oCamera.viewportWidth = width;
		// oCamera.viewportHeight = height;
		oCamera.update();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		oCamera = new OrthographicCamera();
		oCamera.setToOrtho(false, (lebar / tinggi) * 320, 256);
		oCamera.update();

		spriteBatch = new SpriteBatch();

		tiles = new Texture(Gdx.files.internal("data/gfx/dkvduaTextures.png"));
		// tiles = new
		// Texture(Gdx.files.internal("data/gfx/dkvduaBasicTiles.png"));
		splitTiles = TextureRegion.split(tiles, 16, 16);

		map = new TiledMap();
		layers = map.getLayers();

		cell = new Cell();

		layerLantai = new TiledMapTileLayer(13, 20, 16, 16);
		
		/*
		for (int z = 0; z < 10; z++) {
			for (int x = 0; x < arrayPetaLantai.length; x++) {
				for (int y = 0; y < arrayPetaLantai[0].length; y++) {
					switch (arrayPetaLantai[x][y]) {
					case 5:
						cell.setTile(new StaticTiledMapTile(splitTiles[1][1]));
						layerLantai.setCell(x, y, cell);
						break;
					default:
						break;
					}
				}
			}
		}
		*/
		
		layers.add(layerLantai);

		renderer = new OrthogonalTiledMapRenderer(map);
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

	}

}
