package ludum.mighty.square.world;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import ai.world.AIWorld;
import ludum.mighty.square.collisions.CollisionsListener;
import ludum.mighty.square.noPlayer.Bullet;
import ludum.mighty.square.noPlayer.EnemyFactory;
import ludum.mighty.square.noPlayer.GreenBase;
import ludum.mighty.square.noPlayer.GreenFlag;
import ludum.mighty.square.noPlayer.GreenRespawnPoint;
import ludum.mighty.square.noPlayer.NoPlayer;
import ludum.mighty.square.noPlayer.VioletBase;
import ludum.mighty.square.noPlayer.VioletFlag;
import ludum.mighty.square.noPlayer.VioletRespawnPoint;
import ludum.mighty.square.player.AINormalPlayer;
import ludum.mighty.square.player.NormalPlayer;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.player.RecordedStep;
import ludum.mighty.square.settings.CommonSettings;
import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;

/**
 * @author Mighty Team
 *
 *
 *         The first level starts at t= NUM_LEVELS * 10 seconds. Each level
 *         starts 10 seconds before the previous level, so the current player
 *         could see himself playing the previous levels. If the player touches
 *         a previous player he dies.
 */
public class MightyWorld {

	private ArrayList<NoPlayer> enemyList; // only needed for backwards
											// compatibility
	/** list of all flying bullets **/
	private ArrayList<Bullet> bulletsList;

	/** Box2D World, used for collision and movement calculation. **/
	private World world;
	private CollisionsListener collisionListener;

	/** pointer to the player drived by the human **/
	private Player player = null;
	/** List of green players (human and IA drived) **/
	private ArrayList<Player> greenTeamList;
	/** List of violet players (human and IA drived) **/
	private ArrayList<Player> violetTeamList;

	/** list of green team respawn points **/
	private ArrayList<GreenRespawnPoint> greenRespawnPointList;
	/** list of violet team respawn points **/
	private ArrayList<VioletRespawnPoint> violetRespawnPointList;

	/** list of green flags (only one in this version) **/
	private ArrayList<GreenFlag> greenFlagsList;
	/** list of violet flags (only one in this version) **/
	private ArrayList<VioletFlag> violetFlagsList;

	/** list of green bases (only one in this version) **/
	private ArrayList<GreenBase> greenBasesList;
	/** list of violet bases (only one in this version) **/
	private ArrayList<VioletBase> violetBasesList;

	/** **/
	private int greenScore;
	/** **/
	private int violetScore;

	/** Real time of beginning of the game in milliseconds. */
	long startEpoch;
	/** Current time in the game. */
	long timeEpoch;
	/**
	 * difference between now and when the level is really played (in the
	 * future!!)
	 */
	long differenceEpoch;
	
	long timeToFinish;

	private int curentLevel;

	//FIXME massive destruction only for debug (Hector stuff)
	boolean massiveDeath = false;
	boolean massiveCharred = false;

	private Integer mapWidth;
	private Integer mapHeight;

	AIWorld aiWorld;

	/**
	 * @return Map width.
	 */
	public Integer getMapWidth() {
		return mapWidth;
	}

	/**
	 * 
	 * @param mapWidth
	 */
	public void setMapWidth(Integer mapWidth) {
		this.mapWidth = mapWidth;
	}

	/**
	 * 
	 * @return Map height.
	 */
	public Integer getMapHeight() {
		return mapHeight;
	}

	/**
	 * 
	 * @param mapHeight
	 */
	public void setMapHeight(Integer mapHeight) {
		this.mapHeight = mapHeight;
	}

	public MightyWorld()
	{

	}

	/**
	 * 
	 * @param map
	 * @param level
	 * @param allRecordedSteps
	 * @param timeToFinish
	 */
	public void init(TiledMap map, int level, Array<Array<RecordedStep>> allRecordedSteps, long timeToFinish,
			AIWorld aiWorld) {
		this.curentLevel = level;
		this.greenScore = 0;
		this.violetScore = 0;

		MapProperties prop = map.getProperties();

		this.mapWidth = prop.get("width", Integer.class);
		this.mapHeight = prop.get("height", Integer.class);
		
		this.enemyList = new ArrayList<NoPlayer>();
		this.bulletsList = new ArrayList<Bullet>();
		
		//Maximum time allowed to finish the level
		this.timeToFinish = timeToFinish;

		this.differenceEpoch = ((10 - this.curentLevel) * CommonSettings.SECONDS_PER_LEVEL) * 1000;
		this.startEpoch = TimeUtils.millis();

		// Set the artificial intelligence world
		this.aiWorld = aiWorld;

		// Create Box2D physics
		this.world = new World(new Vector2(0, 0), true);
		this.collisionListener = new CollisionsListener();
		world.setContactListener(this.collisionListener);


		// populate box2D with objects from the map
		Box2DMapObjectParser parser = new Box2DMapObjectParser(1 / 16f);
		parser.load(world, map.getLayers().get("physics"));

		// This commented code snippet is used for printing map objects
		// based in
		// https://bitbucket.org/dermetfan/somelibgdxtests/src/adac6846bf5cb74d413e23a6f538b35d9820486c/libgdx-utils/net/dermetfan/libgdx/box2d/Box2DMapObjectParser.java?at=default&fileviewer=file-view-default#Box2DMapObjectParser.java-567
		// not in this version of the library
		/*
		 * String hierarchy = map.getClass().getSimpleName() + "\n";
		 * 
		 * Iterator<String> keys = map.getProperties().getKeys(); while
		 * (keys.hasNext()) { String key = keys.next(); hierarchy += key + ": "
		 * + map.getProperties().get(key) + "\n"; }
		 * 
		 * for (MapLayer layer : map.getLayers()) { hierarchy += "\t" +
		 * layer.getName() + " (" + layer.getClass().getSimpleName() + "):\n";
		 * String layerHierarchy = "";
		 * 
		 * for (MapObject object : layer.getObjects()) { layerHierarchy +=
		 * object.getName() + " (" + object.getClass().getSimpleName() + "):\n";
		 * Iterator<String> keys0 = object.getProperties().getKeys(); while
		 * (keys0.hasNext()) { String key1 = keys0.next(); layerHierarchy +=
		 * "\t" + key1 + ": " + object.getProperties().get(key1) + "\n"; } }
		 * layerHierarchy = layerHierarchy.replace("\n", "\n\t\t");
		 * 
		 * layerHierarchy = layerHierarchy.endsWith("\n\t\t") ?
		 * layerHierarchy.substring(0, layerHierarchy.lastIndexOf("\n\t\t")) :
		 * layerHierarchy; hierarchy += !layerHierarchy.equals("") ? "\t\t" +
		 * layerHierarchy : layerHierarchy; }
		 * 
		 * System.out.println(hierarchy);
		 */

		// This commented code snippet is used for printing world objects
		// position and velocity
		// Array<Body> bodies = new Array<Body>();
		// world.getBodies(bodies);
		// for (Body body : bodies) {
		// System.out.println("Object X:" + body.getPosition().x + " Y:" +
		// body.getPosition().y + "\tvelocity "
		// + body.getLinearVelocity().x + " " + body.getLinearVelocity().y);
		// }

		// Find objects in the world and assign them a new player or noplayer
		// object. Only assign objects from this level or bellow
		// removes objects from the other levels.


		// This commented code snippet is used for printing all recorded steps
		// if (allRecordedSteps != null) {
		// for (Array<RecordedStep> recordedSteps : allRecordedSteps) {
		// System.out.println("__New List ");
		// for (RecordedStep step : recordedSteps) {
		// System.out.println(" " + String.valueOf(step.timestamp) + " up:" +
		// String.valueOf(step.up)
		// + " down:" + String.valueOf(step.down) + " left:" +
		// String.valueOf(step.left) + " right:"
		// + String.valueOf(step.right) + " fire:" + String.valueOf(step.fire));
		// }
		// }
		// }

		generateRespawnPointsLists(map.getLayers().get("respawn"));
		generateFlagsLists(map.getLayers().get("flags"));
		generateBasesLists(map.getLayers().get("bases"));
		generatePlayerTeamLists();

		/**
		 * For the player and all no players in the game (defined in the Tiled
		 * file) a object of its class is created and attached in the
		 * correspondent Box2D body. For no players, the new object is also
		 * added to the enemyList.
		 */

		/*
		 * Array<Body> bodies = new Array<Body>(); world.getBodies(bodies); for
		 * (Body body : bodies) { if (body.getUserData() instanceof String) {
		 * 
		 * StringTokenizer tokens = new StringTokenizer((String)
		 * body.getUserData(), ";"); String bodyType = tokens.nextToken();
		 * 
		 * int bodyLevel = Integer.parseInt(tokens.nextToken());
		 * 
		 * if (bodyType.equals("player")) { if (bodyLevel <= level) {
		 * this.player = new Player();
		 * player.setPlayerState(Player.STATE_PLAYING);
		 * player.setActiveInLevel(bodyLevel); System.out.println(
		 * "player found from level " + String.valueOf(bodyLevel)); if
		 * (bodyLevel < level) { player.setReplaying(true);
		 * player.setRecordedSteps(allRecordedSteps.get(bodyLevel - 1));
		 * System.out.println("Ghost player with recorded // steps: " +
		 * String.valueOf(player.getRecordedSteps().size)); } else {
		 * player.setReplaying(false); } body.setUserData(player); if
		 * (body.getUserData() instanceof Player) { System.out.println(
		 * "player found " + String.valueOf(((Player)
		 * body.getUserData()).getActiveInLevel())); } } else {
		 * world.destroyBody(body); }
		 * 
		 * } else if (bodyType.equals("noplayer")) { if (bodyLevel <= level) {
		 * String enemyPattern = tokens.nextToken(); while
		 * (tokens.hasMoreTokens()) { enemyPattern = enemyPattern + ";" +
		 * tokens.nextToken(); } NoPlayer noPlayer =
		 * EnemyFactory.buildEnemy(enemyPattern); body.setUserData(noPlayer);
		 * this.enemyList.add(noPlayer);
		 * 
		 * } else { world.destroyBody(body); } } } }
		 */

	}

	private void createPlayer(float x, float y, boolean isHuman, int team) {
		NormalPlayer tempPlayer = null;

		if (isHuman == Player.IS_HUMAN) {
			tempPlayer = new NormalPlayer(0, 0, new Vector2(x, y), this.aiWorld, this.greenTeamList, this.violetTeamList, this);
			tempPlayer.setHumanControlled(true);
			this.player = tempPlayer;
		} else {
			tempPlayer = new AINormalPlayer(0, 0, new Vector2(x, y), this.aiWorld, this.greenTeamList, this.violetTeamList, this);
			tempPlayer.setHumanControlled(false);
		}

		tempPlayer.setPlayerState(Player.STATE_PLAYING);
		tempPlayer.setReplaying(false);
		tempPlayer.setActiveInLevel(1);
		tempPlayer.setSquareTeam(team);

		if (team == Player.GREEN_TEAM) {
			this.greenTeamList.add(tempPlayer);
		} else {
			this.violetTeamList.add(tempPlayer);
		}

		// create Box2D objects related to the body:
		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't
		// move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(x, y);

		// Create our body in the world using our body definition
		Body body = this.world.createBody(bodyDef);

		// Create a rectangle shape
		PolygonShape box = new PolygonShape();
		box.setAsBox(0.5f, 0.5f); // 1 = 16 pixels = 1 tile width

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = box;
		fixtureDef.density = 20f;
		fixtureDef.friction = 0f;
		fixtureDef.restitution = 0f;

		// Create our fixture and attach it to the body
		Fixture fixture = body.createFixture(fixtureDef);

		// Put player object as user data

		body.setUserData(tempPlayer);

		// Remember to dispose of any shapes after you're done with them!
		// BodyDef and FixtureDef don't need disposing, but shapes do.
		box.dispose();
	}

	/**
	 * Populates green and violet players list. Currently, the players are
	 * created in this method. This method also creates the respective Box2D
	 * bodies and pushes them into the world.
	 */
	private void generatePlayerTeamLists() {
		if (this.greenTeamList == null) {
			this.greenTeamList = new ArrayList<Player>();
		} else {
			this.greenTeamList.clear();
		}

		if (this.violetTeamList == null) {
			this.violetTeamList = new ArrayList<Player>();
		} else {
			this.violetTeamList.clear();
		}

		// Create green team with 10 members (one human)
		// team members appear near then tree respawn points
		createPlayer(8f, 6f, Player.IS_HUMAN, Player.GREEN_TEAM);

		for (GreenRespawnPoint i : this.greenRespawnPointList){
			createPlayer(i.getX(), i.getY(), Player.IS_AI, Player.GREEN_TEAM);
			createPlayer(i.getX() + 1, i.getY() + 1, Player.IS_AI, Player.GREEN_TEAM);
			createPlayer(i.getX() - 1, i.getY(), Player.IS_AI, Player.GREEN_TEAM);
		}
		
		// create violet team with 10 AI members
		createPlayer(121f, 5f, Player.IS_AI, Player.VIOLET_TEAM);
		for (VioletRespawnPoint i : this.violetRespawnPointList) {
			createPlayer(i.getX(), i.getY(), Player.IS_AI, Player.VIOLET_TEAM);
			createPlayer(i.getX() + 1, i.getY() + 1, Player.IS_AI, Player.VIOLET_TEAM);
			createPlayer(i.getX() - 1, i.getY(), Player.IS_AI, Player.VIOLET_TEAM);
		}
	}

	/**
	 * 
	 * @param layer
	 *            Tiled MapLayer object where the respawn objects are defined.
	 */
	private void generateRespawnPointsLists(MapLayer layer) {
		if (this.greenRespawnPointList == null) {
			this.greenRespawnPointList = new ArrayList<GreenRespawnPoint>();
		} else {
			this.greenRespawnPointList.clear();
		}

		if (this.violetRespawnPointList == null) {
			this.violetRespawnPointList = new ArrayList<VioletRespawnPoint>();
		} else {
			this.violetRespawnPointList.clear();
		}

		for (MapObject object : layer.getObjects()) {
			String id = Integer.toString(Integer.parseInt(object.getProperties().get("id", String.class)) + 1000);
			String team = object.getProperties().get("team", String.class);

			int x = object.getProperties().get("x", Float.class).intValue() / 16;
			int y = object.getProperties().get("y", Float.class).intValue() / 16;

			// we don't need these (typed just for completeness)
			// float width = object.getProperties().get("width", Float.class);
			// float height = object.getProperties().get("height", Float.class);

			if (team.equalsIgnoreCase("green")) {
				GreenRespawnPoint gRP = (GreenRespawnPoint) EnemyFactory
						.buildEnemy("GREENRESPAWNPOINT 5000 -1 1000;0 1000 17 38 17 38 1 55");
				gRP.setX(x);
				gRP.setY(y);
				this.greenRespawnPointList.add(gRP);

			} else if (team.equalsIgnoreCase("violet")) {
				VioletRespawnPoint vRP = (VioletRespawnPoint) EnemyFactory
						.buildEnemy("VIOLETRESPAWNPOINT 5000 -1 1000;0 1000 17 38 17 38 1 55");
				vRP.setX(x);
				vRP.setY(y);
				this.violetRespawnPointList.add(vRP);
			}
		}
	}

	/**
	 * 
	 * @param layer
	 *            Tiled MapLayer object where the flag objects are defined.
	 */
	private void generateFlagsLists(MapLayer layer) {
		if (this.greenFlagsList == null) {
			this.greenFlagsList = new ArrayList<GreenFlag>();
		} else {
			this.greenFlagsList.clear();
		}

		if (this.violetFlagsList == null) {
			this.violetFlagsList = new ArrayList<VioletFlag>();
		} else {
			this.violetFlagsList.clear();
		}

		for (MapObject object : layer.getObjects()) {
			String id = Integer.toString(Integer.parseInt(object.getProperties().get("id", String.class)) + 1000);
			String team = object.getProperties().get("team", String.class);

			int x = object.getProperties().get("x", Float.class).intValue() / 16;
			int y = object.getProperties().get("y", Float.class).intValue() / 16;

			// we don't need these (typed just for completeness)
			// float width = object.getProperties().get("width", Float.class);
			// float height = object.getProperties().get("height", Float.class);

			if (team.equalsIgnoreCase("green")) {
				GreenFlag gF = (GreenFlag) EnemyFactory.buildEnemy("GREENFLAG 5000 -1 1000;0 1000 17 38 17 38 1 55");
				gF.setX(x);
				gF.setY(y);
				this.greenFlagsList.add(gF);
				// create Box2D objects related to the body:
				// First we create a body definition
				BodyDef bodyDef = new BodyDef();
				// We set our body to dynamic, for something like ground which
				// doesn't move we would set it to StaticBody
				bodyDef.type = BodyType.StaticBody;
				// Set our body's starting position in the world
				bodyDef.position.set(x + 0.5f, y + 0.5f);

				// Create our body in the world using our body definition
				Body body = this.world.createBody(bodyDef);

				// Create a rectangle shape
				PolygonShape box = new PolygonShape();
				box.setAsBox(0.5f, 0.5f); // 1 = 16 pixels = 1 tile width

				// Create a fixture definition to apply our shape to
				FixtureDef fixtureDef = new FixtureDef();
				fixtureDef.shape = box;
				fixtureDef.density = 20f;
				fixtureDef.friction = 0f;
				fixtureDef.restitution = 0f;
				fixtureDef.isSensor = true;

				// Create our fixture and attach it to the body
				Fixture fixture = body.createFixture(fixtureDef);

				// Put player object as user data

				body.setUserData(gF);

				// Remember to dispose of any shapes after you're done with
				// them!
				// BodyDef and FixtureDef don't need disposing, but shapes do.
				box.dispose();

			} else if (team.equalsIgnoreCase("violet")) {
				VioletFlag vF = (VioletFlag) EnemyFactory.buildEnemy("VIOLETFLAG 5000 -1 1000;0 1000 17 38 17 38 1 55");
				vF.setX(x);
				vF.setY(y);
				this.violetFlagsList.add(vF);
				// create Box2D objects related to the body:
				// First we create a body definition
				BodyDef bodyDef = new BodyDef();
				// We set our body to dynamic, for something like ground which
				// doesn't move we would set it to StaticBody
				bodyDef.type = BodyType.StaticBody;
				// Set our body's starting position in the world
				bodyDef.position.set(x + 0.5f, y + 0.5f);

				// Create our body in the world using our body definition
				Body body = this.world.createBody(bodyDef);

				// Create a rectangle shape
				PolygonShape box = new PolygonShape();
				box.setAsBox(0.5f, 0.5f); // 1 = 16 pixels = 1 tile width

				// Create a fixture definition to apply our shape to
				FixtureDef fixtureDef = new FixtureDef();
				fixtureDef.shape = box;
				fixtureDef.density = 20f;
				fixtureDef.friction = 0f;
				fixtureDef.restitution = 0f;
				fixtureDef.isSensor = true;

				// Create our fixture and attach it to the body
				Fixture fixture = body.createFixture(fixtureDef);

				// Put player object as user data

				body.setUserData(vF);

				// Remember to dispose of any shapes after you're done with
				// them!
				// BodyDef and FixtureDef don't need disposing, but shapes do.
				box.dispose();
			}
		}
	}

	/**
	 * 
	 * @param layer
	 *            Tiled MapLayer object where the base objects are defined.
	 */
	private void generateBasesLists(MapLayer layer) {
		if (this.greenBasesList == null) {
			this.greenBasesList = new ArrayList<GreenBase>();
		} else {
			this.greenBasesList.clear();
		}

		if (this.violetBasesList == null) {
			this.violetBasesList = new ArrayList<VioletBase>();
		} else {
			this.violetBasesList.clear();
		}

		for (MapObject object : layer.getObjects()) {
			String id = Integer.toString(Integer.parseInt(object.getProperties().get("id", String.class)) + 1000);
			String team = object.getProperties().get("team", String.class);

			int x = object.getProperties().get("x", Float.class).intValue() / 16;
			int y = object.getProperties().get("y", Float.class).intValue() / 16;
			float width = object.getProperties().get("width", Float.class) / 16;
			float height = object.getProperties().get("height", Float.class) / 16;

			if (team.equalsIgnoreCase("green")) {
				GreenBase gB = (GreenBase) EnemyFactory.buildEnemy("GREENBASE 5000 -1 1000;0 1000 17 38 17 38 1 55");
				gB.setX(x + width * 0.5f);
				gB.setY(y + height * 0.5f);
				this.greenBasesList.add(gB);
				// create Box2D objects related to the body:
				// First we create a body definition
				BodyDef bodyDef = new BodyDef();
				// We set our body to dynamic, for something like ground which
				// doesn't move we would set it to StaticBody
				bodyDef.type = BodyType.StaticBody;
				// Set our body's starting position in the world
				bodyDef.position.set(x + width * 0.5f, y + height * 0.5f);

				// Create our body in the world using our body definition
				Body body = this.world.createBody(bodyDef);

				// Create a rectangle shape
				PolygonShape box = new PolygonShape();
				box.setAsBox(width * 0.5f, height * 0.5f); // 1 = 16 pixels = 1
															// tile width

				// Create a fixture definition to apply our shape to
				FixtureDef fixtureDef = new FixtureDef();
				fixtureDef.shape = box;
				fixtureDef.density = 20f;
				fixtureDef.friction = 0f;
				fixtureDef.restitution = 0f;
				fixtureDef.isSensor = true;

				// Create our fixture and attach it to the body
				Fixture fixture = body.createFixture(fixtureDef);

				// Put player object as user data

				body.setUserData(gB);

				// Remember to dispose of any shapes after you're done with
				// them! BodyDef and FixtureDef don't need disposing, but shapes
				// do.
				box.dispose();

			} else if (team.equalsIgnoreCase("violet")) {
				VioletBase vB = (VioletBase) EnemyFactory.buildEnemy("VIOLETBASE 5000 -1 1000;0 1000 17 38 17 38 1 55");
				vB.setX(x + width * 0.5f);
				vB.setY(y + height * 0.5f);
				this.violetBasesList.add(vB);
				// create Box2D objects related to the body:
				// First we create a body definition
				BodyDef bodyDef = new BodyDef();
				// We set our body to dynamic, for something like ground which
				// doesn't move we would set it to StaticBody
				bodyDef.type = BodyType.StaticBody;
				// Set our body's starting position in the world
				bodyDef.position.set(x + width * 0.5f, y + height * 0.5f);

				// Create our body in the world using our body definition
				Body body = this.world.createBody(bodyDef);

				// Create a rectangle shape
				PolygonShape box = new PolygonShape();
				box.setAsBox(width * 0.5f, height * 0.5f); // 1 = 16 pixels = 1
															// tile width

				// Create a fixture definition to apply our shape to
				FixtureDef fixtureDef = new FixtureDef();
				fixtureDef.shape = box;
				fixtureDef.density = 20f;
				fixtureDef.friction = 0f;
				fixtureDef.restitution = 0f;
				fixtureDef.isSensor = true;

				// Create our fixture and attach it to the body
				Fixture fixture = body.createFixture(fixtureDef);

				// Put player object as user data

				body.setUserData(vB);

				// Remember to dispose of any shapes after you're done with
				// them!
				// BodyDef and FixtureDef don't need disposing, but shapes do.
				box.dispose();
			}
		}
	}

	/**
	 * @brief Updates Box2D engine's time.
	 */
	public void stepBox2D()
	{
		this.world.step(1f / 60f, 6, 2);
		updateBullets();
		updatePlayers();
	}

	/** removes collisioned bullets **/
	void updateBullets() {
		Iterator<Bullet> bulletIterator = this.bulletsList.iterator();
		while (bulletIterator.hasNext()) {
			Bullet b = bulletIterator.next();
			if (b.isRemovable()) {
				this.world.destroyBody(b.getMyBody());
				bulletIterator.remove();
				b = null;
			}
		}
	}

	/** killed players and player scores management **/
	void updatePlayers() {
		for (Body b : this.getPlayerBodysList()) {
			Player p = (Player) b.getUserData();
			if (p.getPlayerState() == Player.STATE_DEAD) {
				// Respawns at a random respawn point of it's team
				if (p.getSquareTeam() == Player.GREEN_TEAM) {
					if (p.hasFlag() == true) {
						// restores the flag
						p.setHasFlag(false);
						p.setHasScored(false);
						this.violetFlagsList.get(0).setTaken(false);
					}
					int x = this.greenRespawnPointList.get(0).getX();
					int y = this.greenRespawnPointList.get(0).getY();
					b.setTransform(x, y, 0);
					p.updatePlayerPosition(b, this.timeEpoch, false, false, false, false, false, this.bulletsList);
				} else {
					if (p.hasFlag() == true) {
						// restores the flag
						p.setHasFlag(false);
						p.setHasScored(false);
						this.greenFlagsList.get(0).setTaken(false);
					}
					int x = this.violetRespawnPointList.get(0).getX();
					int y = this.violetRespawnPointList.get(0).getY();
					b.setTransform(x, y, 0);
					p.updatePlayerPosition(b, this.timeEpoch, false, false, false, false, false, this.bulletsList);
				}
			}
			if (p.hasScored() == true) {
				if (p.getSquareTeam() == Player.GREEN_TEAM) {
					p.setHasFlag(false);
					p.setHasScored(false);
					this.violetFlagsList.get(0).setTaken(false);
					this.greenScore += 1;
					// System.out.println(
					// "Green team scores!! GreenTeam " + this.greenScore + " -
					// Violet Team " + this.violetScore);
				} else if (p.getSquareTeam() == Player.VIOLET_TEAM) {
					p.setHasFlag(false);
					p.setHasScored(false);
					this.greenFlagsList.get(0).setTaken(false);
					this.violetScore += 1;
					// System.out.println(
					// "Violet team scores!! GreenTeam " + this.greenScore + " -
					// Violet Team " + this.violetScore);
				}
			}
		}
	}

	//TODO: Hector stuff for debugging
	/**
	 * @brief Updates current game time.
	 */
	public void updateTime()
	{
		this.timeEpoch = TimeUtils.millis() - startEpoch + this.differenceEpoch;
		if (this.timeEpoch > this.timeToFinish)
		{
			//Time-out
			this.player.setPlayerState(Player.STATE_TIMEOUT);
		}
	}

	/**
	 * @brief Updates all enemies state and position.
	 */
	public void updateEnemyPosition() {
		// TODO Move relevant code to updatePlayersPosition
		/*
		 * for (NoPlayer enemy : this.enemyList) { if (enemy instanceof Lever) {
		 * if (((Lever) enemy).isTouched()) { if (enemy.isAlive())
		 * enemy.nowIsDead(this.timeEpoch);
		 * 
		 * ((Lever) enemy).setTouched(false);
		 * 
		 * enemy.setAlive(false); } } else if (enemy instanceof GreenBlob) { if
		 * (((GreenBlob) enemy).isTouched()) { if (enemy.isAlive())
		 * enemy.nowIsDead(this.timeEpoch);
		 * 
		 * ((GreenBlob) enemy).setTouched(false); enemy.setAlive(false); } }
		 * else if (enemy instanceof PurpleBlob) { if (((PurpleBlob)
		 * enemy).isTouched()) { if (enemy.isAlive())
		 * enemy.nowIsDead(this.timeEpoch); ((PurpleBlob)
		 * enemy).setTouched(false);
		 * 
		 * enemy.setAlive(false); } } else if (enemy instanceof BreakableBlock)
		 * { if (((BreakableBlock) enemy).isTouched()) { if (enemy.isAlive())
		 * enemy.nowIsDead(this.timeEpoch); ((BreakableBlock)
		 * enemy).setTouched(false);
		 * 
		 * enemy.setAlive(false); } } else if (enemy instanceof Beer) { if
		 * (((Beer) enemy).isTouched()) { if (enemy.isAlive()) {
		 * enemy.nowIsDead(this.timeEpoch); enemy.setAlive(false); } ((Beer)
		 * enemy).setTouched(false); } } else if (enemy instanceof
		 * GreenRespawnPoint) { if (((GreenRespawnPoint) enemy).isTouched()) {
		 * if (enemy.isAlive()) { enemy.nowIsDead(this.timeEpoch);
		 * enemy.setAlive(false); } ((GreenRespawnPoint)
		 * enemy).setTouched(false); } } else if (enemy instanceof Key) { if
		 * (((Key) enemy).isTouched()) { if (enemy.isAlive()) {
		 * enemy.nowIsDead(this.timeEpoch); enemy.setAlive(false); } ((Key)
		 * enemy).setTouched(false); } } else if (enemy instanceof Door) { if
		 * (this.player.getButtonsPushed() >= CommonSettings.LEVERS_TO_PUSH) {
		 * if (enemy.isAlive()) { enemy.nowIsDead(this.timeEpoch);
		 * enemy.setAlive(false); } } }
		 * 
		 * enemy.update(this.timeEpoch);
		 * 
		 * }
		 * 
		 * // Update position on the Box2D's world. Array<Body> bodies = new
		 * Array<Body>(); world.getBodies(bodies); for (Body body : bodies) { if
		 * (body.getUserData() instanceof NoPlayer) {
		 * body.setTransform(((NoPlayer) body.getUserData()).getCurrentX(),
		 * this.mapHeight - ((NoPlayer) body.getUserData()).getCurrentY() - 1,
		 * 0); } }
		 */
	}


	/**
	 * 
	 * @return the active player (not from other levels)
	 */
	private Body getPlayer() {
		// TODO: playerbody should be a variable in mightyworld so we don't have
		// to do all this?
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for (Body body : bodies) {
			if (body.getUserData() instanceof Player) {
				if (((Player) body.getUserData()).isHumanControlled() == true)
					return body;
			}
		}
		return null;
	}

	/**
	 * @brief Updates player velocity in the Box2D world.
	 * @param up
	 *            up key touched.
	 * @param down
	 *            down key touched.
	 * @param left
	 *            left key touched.
	 * @param right
	 *            right key touched.
	 * @param fire
	 *            fire key touched.
	 */
	public void updatePlayer(boolean up, boolean down, boolean left, boolean right, boolean fire) {
		Body playerBody = this.getPlayer();
		((Player) playerBody.getUserData()).updatePlayerPosition(playerBody, timeEpoch, up, down, left, right, fire,
				bulletsList);
	}

	public void updateAI() {
		for (Body b : this.getPlayerBodysList()) {
			Player p = (Player) b.getUserData();
			if (p.isHumanControlled() == false) {
				p.updatePlayerPosition(b, timeEpoch, false, false, false, false, false, this.bulletsList);
			}
		}
	}
	/**
	 * @details The method takes into account if the player is near to a map
	 *          border to stop following the player with the camera.
	 * 
	 * @return X of the position of the camera taking into account current
	 *         position of the player.
	 */
	public float getCameraPositionX() {
		Body playerBody = this.getPlayer();
		float camPosX = (float) playerBody.getWorldCenter().x;
		float camBorderX = ((float) CommonSettings.CAMERA_WIDTH) / 2;
		if (camPosX < camBorderX)
			return camBorderX;
		if (camPosX > this.mapWidth - camBorderX)
			return this.mapWidth - camBorderX;
		return playerBody.getWorldCenter().x;
	}

	/**
	 * @details The method takes into account if the player is near to a map
	 *          border to stop following the player with the camera.
	 * 
	 * @return Y of the position of the camera taking into account current
	 *         position of the player.
	 */
	public float getCameraPositionY() {
		Body playerBody = this.getPlayer();
		float camPosY = (float) playerBody.getWorldCenter().y;
		float camBorderY = ((float) CommonSettings.CAMERA_HEIGHT) / 2;
		if (camPosY < camBorderY)
			return camBorderY;
		if (camPosY > this.mapHeight - camBorderY)
			return this.mapHeight - camBorderY;
		return playerBody.getWorldCenter().y;
	}

	/**
	 * 
	 * @return Array of recorded steps for all the levels.
	 */
	public Array<Array<RecordedStep>> getAllRecordedSteps() {
		Array<Array<RecordedStep>> allRecordedSteps = new Array<Array<RecordedStep>>(true, 10);

		for (int i = 0; i < 10; i++)
			allRecordedSteps.add(null);

		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for (Body body : bodies) {
			if (body.getUserData() instanceof Player) {
				allRecordedSteps.set(((Player) body.getUserData()).getActiveInLevel() - 1,
						((Player) body.getUserData()).getRecordedSteps());
			}
		}

		return allRecordedSteps;
	}

	/**
	 * @brief Updates the position of all the players from past levels with the
	 *        recorded step in the current time.
	 */
	public void updateGhostPosition() {
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for (Body body : bodies) {
			if (body.getUserData() instanceof Player) {
				if (((Player) body.getUserData()).getActiveInLevel() < this.curentLevel) {

					RecordedStep step = ((Player) body.getUserData()).getCurrentRecordedStep(this.timeEpoch);
					if (step != null) {
						body.setTransform(step.x, step.y, 0);
						// TODO The recorded player fire is written here
					}

				}
			}
		}
	}
	/**
	 * 
	 * @return List of bodies of all players in the world.
	 */
	public ArrayList<Body> getPlayerBodysList() {
		ArrayList<Body> list = new ArrayList<Body>();
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for (Body body : bodies) {
			if (body.getUserData() instanceof Player) {
				list.add(body);
			}
		}
		return list;
	}
	/**
	 * 
	 * @return
	 */
	public int getPlayerStatus() {
		return ((Player) this.getPlayer().getUserData()).getPlayerState();
	}

	/**
	 * 
	 * @return
	 */
	public World getWorld() {
		return world;
	}
	/**
	 * 
	 * @param world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * 
	 * @return
	 */
	public long getTimeEpoch() {
		return timeEpoch;
	}
	/**
	 * 
	 * @param timeEpoch
	 */
	public void setTimeEpoch(long timeEpoch) {
		this.timeEpoch = timeEpoch;
	}
	/**
	 * 
	 * @return
	 */
	public long getStartEpoch() {
		return startEpoch;
	}
	/**
	 * 
	 * @param startEpoch
	 */
	public void setStartEpoch(long startEpoch) {
		this.startEpoch = startEpoch;
	}
	/**
	 * 
	 * @return
	 */
	public long getTimeToFinish() {
		return timeToFinish;
	}
	/**
	 * 
	 * @param timeToFinish
	 */
	public void setTimeToFinish(long timeToFinish) {
		this.timeToFinish = timeToFinish;
	}

	public ArrayList<NoPlayer> getEnemyList() {
		// TODO Auto-generated method stub
		return this.enemyList;
	}

	public ArrayList<GreenBase> getGreenBasesList() {
		return greenBasesList;
	}

	public void setGreenBasesList(ArrayList<GreenBase> greenBasesList) {
		this.greenBasesList = greenBasesList;
	}

	public ArrayList<VioletBase> getVioletBasesList() {
		return violetBasesList;
	}

	public void setVioletBasesList(ArrayList<VioletBase> violetBasesList) {
		this.violetBasesList = violetBasesList;
	}

	
	
}
