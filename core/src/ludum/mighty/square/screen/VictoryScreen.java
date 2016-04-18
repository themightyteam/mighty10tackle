package ludum.mighty.square.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludum.mighty.square.settings.CommonSettings;

public class VictoryScreen extends DefaultScreen implements Screen {

	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;

	int waitFramesForHandle = 100;
	private int tw;
	private int th;
	private int w;
	private int h;

	public VictoryScreen(Game game) {
		super(game);

		this.w = Gdx.graphics.getWidth();
		this.h = Gdx.graphics.getHeight();
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false, 2f, 2f * w / h);
		this.cam.position.set(w / 2f, h / 2f, 0);
		this.cam.zoom = 1.7f;
		this.cam.update();

		this.batch = new SpriteBatch();
		this.img = new Texture("theme/mighty10tackle_win.png");
		this.tw = this.img.getDepth();
		this.th = this.img.getHeight();
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.waitFramesForHandle -= 1;
		if (this.waitFramesForHandle <= 0)
			handleInput();

		this.w = Gdx.graphics.getWidth();
		this.h = Gdx.graphics.getHeight();
		this.cam.position.set(w / 2f, h / 2f, 0);
		this.cam.update();
		batch.setProjectionMatrix(this.cam.combined);

		this.batch.begin();
		batch.draw(this.img, 0, this.cam.position.y - (th / 2));
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
			this.mightyGame.setScreen(new ScreenLevel1(this.mightyGame));
		}
	}
}
