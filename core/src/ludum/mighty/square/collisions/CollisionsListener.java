package ludum.mighty.square.collisions;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import ludum.mighty.square.noPlayer.Beer;
import ludum.mighty.square.noPlayer.BreakableBlock;
import ludum.mighty.square.noPlayer.Bullet;
import ludum.mighty.square.noPlayer.GreenBlob;
import ludum.mighty.square.noPlayer.GreenRespawnPoint;
import ludum.mighty.square.noPlayer.Key;
import ludum.mighty.square.noPlayer.Lever;
import ludum.mighty.square.noPlayer.NoPlayer;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.settings.CommonSettings;

public class CollisionsListener implements ContactListener {

	@Override
	public void endContact(Contact contact) {

	}

	private final int COLLISION_TYPE_NONE = 0;
	private final int COLLISION_TYPE_BULLET_NULL = 1; // bullet against wall
	private final int COLLISION_TYPE_BULLET_BULLET = 2;
	private final int COLLISION_TYPE_BULLET_PLAYER = 3;
	@Override
	public void beginContact(Contact contact) {
		// System.out.println("collision!");
		int typeOfCollision = this.COLLISION_TYPE_NONE;
		
		Body body1 = null; // XXX body in COLLISION_TYPE_XXX_YYY
		Body body2 = null; // YYY body in COLLISION_TYPE_XXX_YYY
		
		if (contact.getFixtureA().getBody().getUserData() instanceof Bullet &&
				contact.getFixtureB().getBody().getUserData() instanceof Bullet){
			typeOfCollision = this.COLLISION_TYPE_BULLET_BULLET;
			body1 = contact.getFixtureA().getBody();
			body2 = contact.getFixtureB().getBody();
		} else 
			if (contact.getFixtureA().getBody().getUserData() instanceof Bullet &&
					contact.getFixtureB().getBody().getUserData() instanceof Player){
				typeOfCollision = this.COLLISION_TYPE_BULLET_PLAYER;
				body1 = contact.getFixtureA().getBody();
				body2 = contact.getFixtureB().getBody();
			} else
				if (contact.getFixtureA().getBody().getUserData() instanceof Player &&
						contact.getFixtureB().getBody().getUserData() instanceof Bullet){
					typeOfCollision = this.COLLISION_TYPE_BULLET_PLAYER;
					body1 = contact.getFixtureB().getBody();
					body2 = contact.getFixtureA().getBody();
		} else if (contact.getFixtureA().getBody().getUserData() instanceof Bullet
				&& contact.getFixtureB().getBody().getUserData() == null) {
			typeOfCollision = this.COLLISION_TYPE_BULLET_NULL;
			body1 = contact.getFixtureA().getBody();
		} else if (contact.getFixtureA().getBody().getUserData() == null
				&& contact.getFixtureB().getBody().getUserData() instanceof Bullet) {
			typeOfCollision = this.COLLISION_TYPE_BULLET_NULL;
			body1 = contact.getFixtureB().getBody();
		}
			
		
		if (typeOfCollision == this.COLLISION_TYPE_BULLET_NULL) {
			((Bullet) body1.getUserData()).declareRemovable();
		} else if (typeOfCollision == this.COLLISION_TYPE_BULLET_BULLET) {
			((Bullet) body1.getUserData()).declareRemovable();
			((Bullet) body2.getUserData()).declareRemovable();
		}
		
		Player player = null;
		NoPlayer noPlayer = null;

		if (contact.getFixtureA().getBody().getUserData() instanceof Player) {
			player = (Player) contact.getFixtureA().getBody().getUserData();
			player.setTouching(true);
		}
		if (contact.getFixtureB().getBody().getUserData() instanceof Player) {
			if (player != null) {
				// Paradox!!
				// player.setPlayerState(Player.STATE_PARADOX);
				// player = (Player)
				// contact.getFixtureB().getBody().getUserData();
				// player.setPlayerState(Player.STATE_PARADOX);
				return;
			}
			player = (Player) contact.getFixtureB().getBody().getUserData();
			player.setTouching(true);
		}

		if (contact.getFixtureA().getBody().getUserData() instanceof NoPlayer) {
			noPlayer = (NoPlayer) contact.getFixtureA().getBody().getUserData();
		} else if (contact.getFixtureB().getBody().getUserData() instanceof NoPlayer) {
			noPlayer = (NoPlayer) contact.getFixtureB().getBody().getUserData();
		}

		if ((player == null) || (noPlayer == null))
			return;
		// System.out.println("collision with " + noPlayer.getNoPlayerType());

		// resolve collision
		if (noPlayer.getNoPlayerType() == noPlayer.TYPE_DOOR) {
			if (player.getActiveInLevel() == 1) {
				// Next level or victory!
				if (player.getButtonsPushed() >= CommonSettings.LEVERS_TO_PUSH) 
				{
					player.setPlayerState(Player.STATE_VICTORY);
				}
			} else {
				player.setPlayerState(Player.STATE_VICTORY);
			}

		} else if ((noPlayer.getNoPlayerType() == noPlayer.TYPE_WICKEDBULLET)
				|| (noPlayer.getNoPlayerType() == noPlayer.TYPE_SPIKE)
				|| (noPlayer.getNoPlayerType() == noPlayer.TYPE_BULLET)
				|| (noPlayer.getNoPlayerType() == noPlayer.TYPE_GUILLOTINE)
				|| (noPlayer.getNoPlayerType() == noPlayer.TYPE_PURPLEBLOB)
				|| (noPlayer.getNoPlayerType() == noPlayer.TYPE_BAT)) {
			// Death


			player.setPlayerState(Player.STATE_DEAD);
		} else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_LEVER) {
			if (((Lever) noPlayer).isTouched() == false) {
				player.setButtonsPushed(player.getButtonsPushed() + 1);
				((Lever) noPlayer).setTouched(true);
				
				//FIXME : open the door if the number of buttons pushed is more than x
				
				
			}
		} else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_GREENBLOB) {
			((GreenBlob) noPlayer).setTouched(true);
		} else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_BREAKABLEBLOCK) {
			((BreakableBlock) noPlayer).setTouched(true);
		} 
		else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_BEER)
		{
			((Beer) noPlayer).setTouched(true);
		}
		else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_KEY)
		{
			((Key) noPlayer).setTouched(true);
		}
		else if (noPlayer.getNoPlayerType() == noPlayer.TYPE_RESPAWN_POINT)
		{
			((GreenRespawnPoint) noPlayer).setTouched(true);
		}

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}





}
