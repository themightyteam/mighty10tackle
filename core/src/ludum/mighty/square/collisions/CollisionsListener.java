package ludum.mighty.square.collisions;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import ludum.mighty.square.noPlayer.Bullet;
import ludum.mighty.square.noPlayer.GreenBase;
import ludum.mighty.square.noPlayer.GreenFlag;
import ludum.mighty.square.noPlayer.NoPlayer;
import ludum.mighty.square.noPlayer.VioletBase;
import ludum.mighty.square.noPlayer.VioletFlag;
import ludum.mighty.square.player.NormalPlayer;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.world.MightyWorld;

public class CollisionsListener implements ContactListener {

	@Override
	public void endContact(Contact contact) {

	}

	private final int COLLISION_TYPE_NONE = 0;
	private final int COLLISION_TYPE_BULLET_NULL = 1; // bullet against wall
	private final int COLLISION_TYPE_BULLET_BULLET = 2;
	private final int COLLISION_TYPE_BULLET_PLAYER = 3;
	private final int COLLISION_TYPE_GREENPLAYER_VIOLETFLAG = 4;
	private final int COLLISION_TYPE_VIOLETPLAYER_GREENFLAG = 5;
	private final int COLLISION_TYPE_GREENPLAYER_GREENBASE = 6;
	private final int COLLISION_TYPE_VIOLETPLAYER_VIOLETBASE = 7;

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
				} else if (contact.getFixtureA().getBody().getUserData() instanceof Player
						&& contact.getFixtureB().getBody().getUserData() instanceof VioletFlag) {
					body1 = contact.getFixtureA().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.GREEN_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_GREENPLAYER_VIOLETFLAG;
						body2 = contact.getFixtureB().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof VioletFlag
						&& contact.getFixtureB().getBody().getUserData() instanceof Player) {
					body1 = contact.getFixtureB().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.GREEN_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_GREENPLAYER_VIOLETFLAG;
						body2 = contact.getFixtureA().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof Player
						&& contact.getFixtureB().getBody().getUserData() instanceof GreenFlag) {
					body1 = contact.getFixtureA().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.VIOLET_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_VIOLETPLAYER_GREENFLAG;
						body2 = contact.getFixtureB().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof GreenFlag
						&& contact.getFixtureB().getBody().getUserData() instanceof Player) {
					body1 = contact.getFixtureB().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.VIOLET_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_VIOLETPLAYER_GREENFLAG;
						body2 = contact.getFixtureA().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof Player
						&& contact.getFixtureB().getBody().getUserData() instanceof GreenBase) {
					body1 = contact.getFixtureA().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.GREEN_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_GREENPLAYER_GREENBASE;
						body2 = contact.getFixtureB().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof GreenBase
						&& contact.getFixtureB().getBody().getUserData() instanceof Player) {
					body1 = contact.getFixtureB().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.GREEN_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_GREENPLAYER_GREENBASE;
						body2 = contact.getFixtureA().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof Player
						&& contact.getFixtureB().getBody().getUserData() instanceof VioletBase) {
					body1 = contact.getFixtureA().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.VIOLET_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_VIOLETPLAYER_VIOLETBASE;
						body2 = contact.getFixtureB().getBody();
					}
				} else if (contact.getFixtureA().getBody().getUserData() instanceof VioletBase
						&& contact.getFixtureB().getBody().getUserData() instanceof Player) {
					body1 = contact.getFixtureB().getBody();
					Player p = (Player) body1.getUserData();
					if (p.getSquareTeam() == Player.VIOLET_TEAM) {
						typeOfCollision = this.COLLISION_TYPE_VIOLETPLAYER_VIOLETBASE;
						body2 = contact.getFixtureA().getBody();
					}
				}


		if (typeOfCollision == this.COLLISION_TYPE_BULLET_NULL) {
			((Bullet) body1.getUserData()).declareRemovable();
		} else if (typeOfCollision == this.COLLISION_TYPE_BULLET_BULLET) {
			((Bullet) body1.getUserData()).declareRemovable();
			((Bullet) body2.getUserData()).declareRemovable();
		} else if (typeOfCollision == this.COLLISION_TYPE_BULLET_PLAYER) {
			((Bullet) body1.getUserData()).declareRemovable();
			((Player) body2.getUserData()).setPlayerState(Player.STATE_DEAD);
		} else if (typeOfCollision == this.COLLISION_TYPE_GREENPLAYER_VIOLETFLAG) {
			Player p = (Player) body1.getUserData();
			VioletFlag vF = (VioletFlag) body2.getUserData();
			if (vF.isTaken() == false) {
				
				((NormalPlayer) p).getWorld().setGreenScore(
						((NormalPlayer) p).getWorld().getGreenScore() +
						MightyWorld.FIRST_DOWN
						);
				
				NormalPlayer normalPlayer = ((NormalPlayer) p);
				normalPlayer.getWorld().getSound().playFlagCatch();

				p.setHasFlag(true);
				vF.setTaken(true);
				// System.out.print("VioletFlag conquered!");
			}
		} else if (typeOfCollision == this.COLLISION_TYPE_VIOLETPLAYER_GREENFLAG) {
			Player p = (Player) body1.getUserData();
			GreenFlag gF = (GreenFlag) body2.getUserData();
			if (gF.isTaken() == false) {

				((NormalPlayer) p).getWorld().setVioletScore(
						((NormalPlayer) p).getWorld().getVioletScore() +
						MightyWorld.FIRST_DOWN
						);
				
				NormalPlayer normalPlayer = ((NormalPlayer) p);
				normalPlayer.getWorld().getSound().playFlagCatch();

				p.setHasFlag(true);
				gF.setTaken(true);
				// System.out.print("GreenFlag conquered!");
			}
		} else if (typeOfCollision == this.COLLISION_TYPE_GREENPLAYER_GREENBASE) {
			Player p = (Player) body1.getUserData();
			if (p.hasFlag() == true) {
				
				NormalPlayer normalPlayer = ((NormalPlayer) p);
				normalPlayer.getWorld().getSound().playChideSound();
				
				p.setHasScored(true);
			}
		} else if (typeOfCollision == this.COLLISION_TYPE_VIOLETPLAYER_VIOLETBASE) {
			Player p = (Player) body1.getUserData();
			if (p.hasFlag() == true) {
				
				NormalPlayer normalPlayer = ((NormalPlayer) p);
				normalPlayer.getWorld().getSound().playChideSound();
				
				p.setHasScored(true);
			}
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
