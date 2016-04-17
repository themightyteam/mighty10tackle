package ludum.mighty.square.player;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import ai.world.AIWorld;
import ludum.mighty.square.noPlayer.Bullet;
import ludum.mighty.square.world.pathnodes.PathNode;


/**
 * 
 * @author The Mighty Team
 * 
 *         Normal player: normal movement, normal action (shooting). Loses the
 *         action when in possession of the flag.
 *
 */
public class NormalPlayer extends Player 
{

	// type of player (Normal, Spy, etc)
	int type;

	// True if the player has the flag
	boolean hasFlag;

	// True if the player was invisible
	boolean invisible;

	// Team of the square
	int squareTeam;

	Vector2 position;

	PathNode lastSeenNode;

	AIWorld aiWorld;
	
	ArrayList<Player> greenTeamList;
	ArrayList<Player> violetTeamList;

	public NormalPlayer() {
	};

	public NormalPlayer(int type, 
			int squareTeam, 
			Vector2 initPosition,
			AIWorld aiWorld, 
			ArrayList<Player> myTeamList,
			ArrayList<Player> enemyList
			)
	{
		//Update the lists
		this.greenTeamList = myTeamList;
		this.violetTeamList = enemyList;
		
		
		this.type = type;
		this.squareTeam = squareTeam;		

		this.position = initPosition;

		this.aiWorld = aiWorld;

		//Detect the square in which the player is located	
		this.lastSeenNode = this.aiWorld.obtainCurrentNode(this.position);



		this.invisible = false;
		this.hasFlag = false;

		System.out.println("ONE SQUARE PLAYER");

		this.printCurrentSquare();
	}

	public void printCurrentSquare() {
		if (this.lastSeenNode != null)
			System.out.println("CURS " + this.lastSeenNode.getIdNode());
		else
			System.out.println("CURS NULL");
	}

	/**
	 * Obtain the position of the player (in tiled, not in box2d)
	 * 
	 * @return
	 */
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;

		// Obtain the square

		// Check if Pathnode should be updated
		if (this.lastSeenNode != null) {
			if (this.lastSeenNode.getNodeShape().contains(position))
				// No need of update (same node)
				return;
		}

		// Detect the square in which the player is located
		PathNode newNode = this.aiWorld.obtainCurrentNode(this.position);

		if (newNode != null) {
			// Updating the node
			this.lastSeenNode = newNode;

			this.printCurrentSquare();
		}
	}

	/**
	 * @brief Updates player's Box2D body velocity and records the current
	 *        position.
	 * @param playerBody
	 *            player's Box2D body.
	 * @param timeEpoch
	 *            current time.
	 * @param upKeyPressed
	 *            if up key is pressed.
	 * @param downKeyPressed
	 *            if down key is pressed.
	 * @param leftKeyPressed
	 *            if left key is pressed.
	 * @param rightKeyPressed
	 *            if right key pressed.
	 * @param fireKeyPressed
	 *            if fire key is pressed.
	 */
	public void updatePlayerPosition(Body playerBody, long timeEpoch, boolean upKeyPressed, boolean downKeyPressed,
			boolean leftKeyPressed, boolean rightKeyPressed, boolean fireKeyPressed, ArrayList<Bullet> bulletsList) {

		// H FIX Set the current position
		// Update position
		Vector2 newPos = playerBody.getPosition();
		this.setPosition(new Vector2(newPos.x, newPos.y));

		Vector2 currentVelocity = playerBody.getLinearVelocity();
		if (upKeyPressed) {
			// TODO rethink this jumpingSinceEpoch logic (do it like
			// firingSinceEpoch)
			if ((this.jumpingSinceEpoch == 0) || (timeEpoch - this.jumpingSinceEpoch < 300)) {
				if (this.jumpingSinceEpoch == 0)
					this.jumpingSinceEpoch = timeEpoch;
				if (this.isTouching() == true) {
					currentVelocity = currentVelocity.add(0, impulse.y);
					if (currentVelocity.y > maxVelocity.y)
						currentVelocity.y = maxVelocity.y;
					this.setTouching(false);
				}
			} else {
				currentVelocity = currentVelocity.add(0, impulse.y * -0.2f);
				if (currentVelocity.y < maxVelocity.y * -1)
					currentVelocity.y = maxVelocity.y * -1;
			}

		} else if (downKeyPressed) {
			this.jumpingSinceEpoch = 0;
			currentVelocity = currentVelocity.add(0, impulse.y * -1);
			if (currentVelocity.y < maxVelocity.y * -1)
				currentVelocity.y = maxVelocity.y * -1;
		} else {
			this.jumpingSinceEpoch = 0;
			currentVelocity = currentVelocity.add(0, impulse.y * -0.5f);
			if (currentVelocity.y < maxVelocity.y * -1)
				currentVelocity.y = maxVelocity.y * -1;
		}

		if (leftKeyPressed == rightKeyPressed) {
			currentVelocity = currentVelocity.sub(currentVelocity.x / 2, 0);

		} else {
			if (leftKeyPressed) {
				currentVelocity = currentVelocity.add(impulse.x * -1, 0);
				if (currentVelocity.x < maxVelocity.x * -1)
					currentVelocity.x = maxVelocity.x * -1;
			}
			if (rightKeyPressed) {
				currentVelocity = currentVelocity.add(impulse.x, 0);
				if (currentVelocity.x > maxVelocity.x)
					currentVelocity.x = maxVelocity.x;
			}
		}

		playerBody.setLinearVelocity(currentVelocity);
		this.addRecordedStep(timeEpoch, playerBody.getWorldCenter().x - (float) 0.5,
				playerBody.getWorldCenter().y - (float) 0.5, fireKeyPressed);


		if (fireKeyPressed) {
			if (timeEpoch - this.firingSinceEpoch > 300) {
				createBullet(playerBody.getWorld(), playerBody.getWorldCenter().x, playerBody.getWorldCenter().y,
						playerBody.getLinearVelocity().limit(1), bulletsList);
				this.firingSinceEpoch = timeEpoch;
			}
		}
	}

	private void createBullet(World world, float x, float y, Vector2 direction, ArrayList<Bullet> bulletsList) {
		float directionX = 0, directionY = 0;

		if (direction.x > 0) {
			directionX = 1;
		} else {
			directionX = -1;
		}

		Bullet bullet = new Bullet();
		// create Box2D objects related to the body:
		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't
		// move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		// bodyDef.position.set(x + 1, y);
		bodyDef.position.set(x + directionX, y + directionY);

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		// Create a circle shape
		CircleShape shape = new CircleShape();
		shape.setRadius(0.2f); // 1 = 16 pixels = 1 tile width

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 20f;
		fixtureDef.friction = 0f;
		fixtureDef.restitution = 0f;

		// Create our fixture and attach it to the body
		body.createFixture(fixtureDef);

		body.setLinearVelocity(directionX * 30, directionY);
		// Put player object as user data

		body.setUserData(bullet);

		// Remember to dispose of any shapes after you're done with them!
		// BodyDef and FixtureDef don't need disposing, but shapes do.
		shape.dispose();

		bullet.setMyBody(body);
		bulletsList.add(bullet);
	}

}
