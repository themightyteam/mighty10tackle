package ludum.mighty.melee.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ludum.mighty.square.game.MightyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mighty 10tackle";
		config.width = 320;
		config.height = 160;
		new LwjglApplication(new MightyGame(), config);
	}

}
