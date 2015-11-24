package org.tego.android.dkvdua.gameworld;

import org.tego.android.dkvdua.gameobject.Level;

/**
 * Kelas yang digunakan untuk mengatur dunia penggambaran dari permainan
 * 
 * @author blackshadow
 *
 */
public class GameWorld {
	private GameState currentState;
	// private float gameWidth;
	// private float gameHeight;
	// private GameRenderer renderer;
	private Level petaGim;

	/**
	 * Status dari permainan
	 * 
	 * @author blackshadow
	 *
	 */
	public enum GameState {
		MENU, READY, RUNNING, GAMEOVER, ABOUT, SETTING
	}

	/**
	 * Konstruktor dari kelas
	 * 
	 * @param gameWidth
	 *            Ukuran dari lebar layar permainan
	 * @param gameHeight
	 *            Ukuran dari tinggi layar permainan
	 */
	public GameWorld(float gameWidth, float gameHeight) {
		currentState = GameState.MENU;
		// this.gameWidth = gameWidth;
		// this.gameHeight = gameHeight;
	}

	/**
	 * Method yang digunakan untuk melakukan pembaruan pada gambar yang
	 * ditampilkan ke dalam permainan
	 * 
	 * @param delta
	 *            Waktu yang sedang berjalan
	 */
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
		case ABOUT:
			updateAbout(delta);
		case SETTING:
			updateSetting(delta);
		default:
			break;
		}
	}

	private void updateSetting(float delta) {
		// TODO Auto-generated method stub

	}

	private void updateAbout(float delta) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method yang digunakan untuk melakukan penggambaran dan pembaruan pada
	 * layar menu
	 * 
	 * @param delta
	 *            Waktu yang sedang berjalan
	 */
	private void updateMenu(float delta) {

	}

	/**
	 * Method yang digunakan untuk melakukan penggambaran dan pembaruan pada
	 * layar ketika permainan sedang berlangsung
	 * 
	 * @param delta
	 *            Waktu yang sedang berjalan
	 */
	public void updateRunning(float delta) {
		petaGim.update(delta);
	}

	/**
	 * Method yang digunakan untuk melakukan penggambaran dan pembaruan pada
	 * layar ketika permainan siap di jalankan
	 * 
	 * @param delta
	 *            Waktu yang sedang berjalan
	 */
	private void updateReady(float delta) {

	}

	/**
	 * Method yang digunakan untuk menggambar layar GameOver atau permainan
	 * selesai
	 * 
	 * @param delta
	 */
	private void updateGameOver(float delta) {

	}

	public boolean isSetting() {
		return currentState == GameState.SETTING;
	}

	public boolean isAbout() {
		return currentState == GameState.ABOUT;
	}

	/**
	 * Method yang digunakan untuk mengecek apakah permainan sudah siap
	 * dijalankan
	 * 
	 * @return
	 */
	public boolean isReady() {
		return currentState == GameState.READY;
	}

	/**
	 * Method yang digunakan untuk mengecek apakah layar menu sudah ditampilkan
	 * atau belum
	 * 
	 * @return
	 */
	public boolean isMenu() {
		return currentState == GameState.MENU;
	}

	/**
	 * Method yang digunakan untuk mengecek permainan sedang berjalan atau tidak
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}

	/**
	 * Method yang digunakan untuk mengecek permainan selesai atau belum
	 * 
	 * @return
	 */
	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}

	/**
	 * Method yang digunakan untuk memulai permainan
	 */
	public void start() {
		currentState = GameState.RUNNING;
	}

	/**
	 * Method yang digunakan untuk memulai ulang permainan
	 */
	public void restart() {
		currentState = GameState.READY;
	}

	/**
	 * Method yang digunakan ketika permainan siap dijalankan
	 */
	public void ready() {
		currentState = GameState.READY;
	}

	public void setRenderer(GameRenderer renderer) {
		// this.renderer = renderer;
	}
}
