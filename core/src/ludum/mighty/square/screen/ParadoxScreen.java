package ludum.mighty.square.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludum.mighty.square.settings.CommonSettings;

public class ParadoxScreen extends DefaultScreen {

	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;

	int waitFramesForHandle = 100;

	public ParadoxScreen(Game game) {
		super(game);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(CommonSettings.CAMERA_WIDTH * 8, CommonSettings.CAMERA_HEIGHT * 8);
		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		this.batch = new SpriteBatch();
		this.img = new Texture("paradox.jpg");
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.waitFramesForHandle -= 1;
		if (this.waitFramesForHandle <= 0)
			handleInput();

		cam.update();
		batch.setProjectionMatrix(cam.combined);

		this.batch.begin();
		this.batch.draw(img, 0, 0);
		this.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = CommonSettings.CAMERA_WIDTH * 8;
		cam.viewportHeight = CommonSettings.CAMERA_HEIGHT * 8;
		cam.update();
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
			this.mightyGame.setScreen(new ScreenLevel1(this.mightyGame, 1, null));
		}
	}
}
