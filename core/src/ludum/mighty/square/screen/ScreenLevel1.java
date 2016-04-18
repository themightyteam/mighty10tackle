package ludum.mighty.square.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import ai.tiled.TiledMapProcessor;
import ai.world.AIWorld;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.player.RecordedStep;
import ludum.mighty.square.render.MightyRender;
import ludum.mighty.square.settings.CommonSettings;
import ludum.mighty.square.world.MightyWorld;

public class ScreenLevel1 extends DefaultScreen {

	private static final int STATE_INIT = 0;
	private static final int STATE_NORMALPLAY = 1;
	private static final int STATE_DEAD = 2;
	private static final int STATE_DEADPARADOX = 3;
	private static final int STATE_VICTORY = 4;
	private static final int STATE_LOSE = 5;
	private static final int STATE_DRAW = 6;

	private static final long TIME_TO_FINISH = 200000; //200 seconds

	OrthographicCamera guiCam;

	private TiledMap map;

	MightyWorld gameWorld;
	SpriteBatch batcher; //FIXME delete
	int state;

	long epochsInDead = -1; //Epochs when dead

	MightyRender mightyRender;

	int currentLevel;

	AIWorld aiWorld;

	public ScreenLevel1(Game game) {
		super(game);
		// TODO Auto-generated constructor stub


		this.state = STATE_INIT;

		this.guiCam = new OrthographicCamera();
		this.guiCam.setToOrtho(false, CommonSettings.CAMERA_WIDTH, CommonSettings.CAMERA_HEIGHT);
		this.guiCam.update();



		this.batcher = new SpriteBatch();

		//Create world and render;                                                                                                    
		this.gameWorld = new MightyWorld();

		//Init map
		this.map = new TmxMapLoader().load("maps/minimalist_mapv2.tmx");

		// Init the AI
		this.aiWorld = new AIWorld(new TiledMapProcessor(this.map), "zoning", "pathfinding");

		// FIXME perform the test of A-star (only for DEBUG)
		//this.aiWorld.aStarFullTest();

		//Init the world
		this.gameWorld.init(this.map, this.currentLevel,null, TIME_TO_FINISH, this.aiWorld);

		//Create rendered
		this.mightyRender = new MightyRender(this.gameWorld, this.map);

	}

	public void initWorld()
	{
		//Doing init stuff here

		this.state = STATE_NORMALPLAY;
	}


	public void updateWorld()
	{
		//Pick the pad

		//Update the world

		//FIXME Hector Stuff for debug
		this.gameWorld.updateTime();
		this.gameWorld.updateEnemyPosition();
		this.gameWorld.updateGhostPosition();
		this.gameWorld.updateAI();

		// if (this.gameWorld.getTimeEpoch() > 30000 &&
		// this.gameWorld.getTimeEpoch() < 40000)
		// {
		// this.gameWorld.setAllEnemiesDeath();
		// }
		// else if (this.gameWorld.getTimeEpoch() > 40000)
		// {
		// this.gameWorld.setAllEnemiesCharred();
		// }
	}

	/**                                                                                                                                   
	 *                                                                                                                                    
	 * @param deltaTime                                                                                                                   
	 */
	public void update(float deltaTime)
	{
		if (deltaTime > 0.1f) deltaTime = 0.1f;

		switch(state)
		{

		case STATE_INIT:
			initWorld();
			// initEnemies();
			break;

		case STATE_NORMALPLAY:
			updatePad();
			updateWorld();
			checkEndCondition();
			break;

		case STATE_VICTORY:	
		case STATE_LOSE:
		case STATE_DRAW:
		case STATE_DEAD:	
			changeOfScreen();
			break;
		}


	}


	private void changeOfScreen()
	{
		long currentTime = TimeUtils.millis();

		if ((this.state == STATE_DEAD)||
				(this.state == STATE_VICTORY) ||
				(this.state == STATE_LOSE)|| 
				(this.state == STATE_DRAW))
		{	
			if (currentTime - this.epochsInDead > CommonSettings.MSWAIT_AFTER_DEAD)
			{
				this.gameWorld.getSound().disposeObjects();	
				
				this.mightyGame.setScreen(new ScreenLevel1(this.mightyGame));
			}
		}

	}

	private void checkEndCondition() {

		if (this.gameWorld.getPlayerStatus() == Player.STATE_TIMEOUT)
		{
			if (this.gameWorld.getGreenScore() > this.gameWorld.getVioletScore())
			{

				this.epochsInDead = TimeUtils.millis();
				this.state = STATE_VICTORY;
				this.gameWorld.getSound().playVictorySound();
			}
			else if (this.gameWorld.getGreenScore() < this.gameWorld.getVioletScore())
			{

				this.epochsInDead = TimeUtils.millis();
				this.state = STATE_LOSE;
				this.gameWorld.getSound().playLoseSound();
			}
			else
			{
				this.state = STATE_DRAW;
			}

		}



	}

	private void updatePad() {
		boolean up = false, down = false, left = false, right = false, fire = false;
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			left = true;
		}

		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			right = true;
		}

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			up = true;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			down = true;
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			fire = true;
		}
		this.gameWorld.updatePlayer(up, down, left, right, fire);
	}

	/**                                                                                                                                   
	 *                                                                                                                                    
	 * @param deltaTime                                                                                                                   
	 */
	public void draw(float deltaTime)
	{

		// clear the screen
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch (state) {
		case STATE_INIT:
			break;
		case STATE_DEAD:
		case STATE_DEADPARADOX:	
		case STATE_NORMALPLAY:

			// measured in "real units" = 16 pixels
			this.guiCam.position.x = this.gameWorld.getCameraPositionX();
			this.guiCam.position.y = this.gameWorld.getCameraPositionY();
			this.guiCam.update();

			this.mightyRender.setCameraView(this.guiCam);

			this.mightyRender.render();
			break;
		}

	}

	/**                                                                                                                                   
	 *                                                                                                                                    
	 * @param delta                                                                                                                       
	 */
	public void physicStep(float delta)
	{
		this.gameWorld.stepBox2D();
	}


	@Override
	public void render(float delta)
	{
		update(delta);
		draw(delta);
		physicStep(delta);
	}



}
