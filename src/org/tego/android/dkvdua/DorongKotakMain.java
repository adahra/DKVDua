package org.tego.android.dkvdua;

import org.tego.android.dkvdua.game.Assets;
import org.tego.android.dkvdua.game.WorldController;
import org.tego.android.dkvdua.game.WorldRenderer;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class DorongKotakMain implements ApplicationListener {
	public static final String TAG = DorongKotakMain.class.getSimpleName();

	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;

	public DorongKotakMain() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Assets.instance.init(new AssetManager());
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		paused = false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		worldRenderer.resize(width, height);
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		if (!paused) {
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		
		Gdx.gl.glClearColor(0 / 255.0f, 255 / 255.0f, 255 / 255.0f, 255 / 255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		paused = true;
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Assets.instance.init(new AssetManager());
		paused = false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		worldRenderer.dispose();
		Assets.instance.dispose();
	}

}
