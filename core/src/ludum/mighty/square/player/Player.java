package ludum.mighty.square.player;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import ludum.mighty.square.noPlayer.Bullet;

/**
 * @author The Mighty Team
 *
 *         Common Class that encapsulates functionality and data of all players
 *         (drived by humans or AI). Only game logic and movement, not
 *         rendering.
 */
public class Player {
	public static final boolean IS_AI = false;
	public static final boolean IS_HUMAN = true;

	private boolean touchingSomething; // true if player is on ground or
										// touching something (so it can jump)
	public static final int STATE_PLAYING = 1;
	public static final int STATE_DEAD = 2;
	public static final int STATE_VICTORY = 4;
	public static final int STATE_TIMEOUT = 5;
	public static final int STATE_ZOMBIE = 6;
	
	public static final long TIME_TILL_RESPAWN = 3000;  //FIXME: change location of here

	private boolean isReplaying;
	private int activeInLevel; // the level where the user controls this player

	int buttonsPushed;

	private int playerState;

	Vector2 maxVelocity = new Vector2(15, 20);
	Vector2 impulse = new Vector2(10, 12);

	/** true if this played is controlled by a human (no AI) **/
	boolean isHumanControlled;
	
	long timeDeath = -1;

	public boolean isHumanControlled() {
		return isHumanControlled;
	}

	public void setHumanControlled(boolean isHumanControlled) {
		this.isHumanControlled = isHumanControlled;
	}

	/**
	 * If the player is jumping, the epoch when it started. If not jumping this
	 * is 0.
	 */
	long jumpingSinceEpoch;

	/**
	 * If the player has fired, the epoch when it started. If not jumping this
	 * is 0.
	 */
	long firingSinceEpoch;

	/** type of player (Normal, Spy, etc) **/
	int type;

	/** True if the player has the flag. **/
	boolean hasFlag;

	public boolean hasFlag() {
		return hasFlag;
	}

	public void setHasFlag(boolean hasFlag) {
		this.hasFlag = hasFlag;
	}

	/** True if the player has just entered the base with the flag. **/
	boolean hasScored;

	public boolean hasScored() {
		return hasScored;
	}

	public void setHasScored(boolean hasScored) {
		this.hasScored = hasScored;
	}

	/** True if the player is invisible. **/
	boolean invisible;

	public static final int GREEN_TEAM = 0;
	public static final int VIOLET_TEAM = 1;
	// Team of the square
	private int squareTeam;

	public int getSquareTeam() {
		return squareTeam;
	}

	public void setSquareTeam(int squareTeam) {
		this.squareTeam = squareTeam;
	}

	/**
	 * 
	 */
	public Player() {
		touchingSomething = false;
		this.buttonsPushed = 0;
		this.jumpingSinceEpoch = 0;
		this.firingSinceEpoch = 0;
	}

	public int getButtonsPushed() {
		return buttonsPushed;
	}

	public void setButtonsPushed(int buttonsPushed) {
		this.buttonsPushed = buttonsPushed;
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

		Vector2 currentVelocity = playerBody.getLinearVelocity();
		if (upKeyPressed) {
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
			if (currentVelocity.y == 0)
				this.jumpingSinceEpoch = 0;
			currentVelocity = currentVelocity.add(0, impulse.y * -1);
			if (currentVelocity.y < maxVelocity.y * -1)
				currentVelocity.y = maxVelocity.y * -1;
		} else {
			if (currentVelocity.y == 0)
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
	}

	public boolean isTouching() {
		return this.touchingSomething;
	}

	public void setTouching(boolean touching) {
		this.touchingSomething = touching;
	}

	public int getPlayerState() {
		return this.playerState;
	}

	public void setPlayerState(final int playerState) {
		this.playerState = playerState;
	}

	public boolean isReplaying() {
		return this.isReplaying;
	}

	public void setReplaying(boolean isReplaying) {
		this.isReplaying = isReplaying;
	}

	public int getActiveInLevel() {
		return activeInLevel;
	}

	public void setActiveInLevel(int activeInLevel) {
		this.activeInLevel = activeInLevel;
	}

	public long getTimeDeath() {
		return timeDeath;
	}

	public void setTimeDeath(long timeDeath) {
		this.timeDeath = timeDeath;
	}


	
}

