package org.nauin.android.dkvdua.gameworld;

public class GameWorld {
	private GameState currentState;
	private float gameWidth;
	private float gameHeight;
	
	public enum GameState {
		MENU, READY, RUNNING, GAMEOVER
	}
	
	public GameWorld(float gameWidth, float gameHeight) {
		currentState = GameState.MENU;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
	}
	
	public void update(float delta) {
		switch (currentState) {
		case MENU:
			updateMenu(delta);
			break;
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
			updateRunning(delta);
			break;
		case GAMEOVER:
			updateGameOver(delta);
		default:
			break;
		}
	}
	
	private void updateMenu(float delta) {
		
	}
	
	public void updateRunning(float delta) {
		
	}
	
	private void updateReady(float delta) {
		
	}
	
	private void updateGameOver(float delta) {
		
	}
	
	public boolean isReady() {
		return currentState == GameState.READY;
	}
	
	public boolean isMenu() {
		return currentState == GameState.MENU;
	}
	
	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}
	
	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}
	
	public void start() {
		currentState = GameState.RUNNING;
	}
	
	public void restart() {
		currentState = GameState.READY;
	}
	
	public void ready() {
		currentState = GameState.READY;
	}
}
