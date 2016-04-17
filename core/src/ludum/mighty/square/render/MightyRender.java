package ludum.mighty.square.render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import ludum.mighty.square.assets.WholeGameAssets;
import ludum.mighty.square.noPlayer.NoPlayer;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.world.MightyWorld;

public class MightyRender 
{

	private Box2DDebugRenderer box2DRenderer;
	private OrthogonalTiledMapRenderer renderer;
	OrthographicCamera guiCam;
	WholeGameAssets gameAssets;

	MightyWorld gameWorld;
	TiledMap map;

	public MightyRender(MightyWorld gameWorld, TiledMap map)
	{

		this.gameAssets = new WholeGameAssets();
		this.gameAssets.load();

		this.map = map;
		this.gameWorld = gameWorld;

		this.box2DRenderer = new Box2DDebugRenderer();	

		this.renderer = new OrthogonalTiledMapRenderer(map, 1 /16f);



	}

	public void setCameraView(OrthographicCamera guiCam)
	{
		this.guiCam = guiCam;
		this.renderer.setView(this.guiCam);
	}

	private void renderPlayer() {
		this.renderer.getBatch().begin();
		for (Body body : this.gameWorld.getPlayerBodysList()) {
			Player p = (Player) body.getUserData();
			if (p.getSquareTeam() == Player.GREEN_TEAM) {
				if (p.hasFlag() == true) {
					renderPlayerGreenWithFlag(body);
				} else {
					renderPlayerGreen(body);
				}
			} else {
				if (p.hasFlag() == true) {
					renderPlayerVioletWithFlag(body);
				} else {
					renderPlayerViolet(body);
				}
			}
		}
		this.renderer.getBatch().end();
	}

	private void renderPlayerGreen(Body body) {
		Player p = (Player) body.getUserData();
		if (!p.isReplaying()) {
			// Normal Player

			TextureRegion playerRegion = null;
			if ((p.getPlayerState() == Player.STATE_DEAD) || (p.getPlayerState() == Player.STATE_PARADOX)
					|| (p.getPlayerState() == Player.STATE_TIMEOUT)) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_DEATH,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else {

				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

				Vector2 currentVelocity = body.getLinearVelocity();
				float angle = currentVelocity.angle();
				if (angle == 0) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_IDLE_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (angle == 180) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_IDLE_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_JUMPING_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_JUMPING_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				}
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		} else {

			TextureRegion playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
					(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

			Vector2 currentVelocity = body.getLinearVelocity();
			float angle = currentVelocity.angle();
			if (angle == 0) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (angle == 180) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		}
	}

	private void renderPlayerGreenWithFlag(Body body) {
		Player p = (Player) body.getUserData();
		if (!p.isReplaying()) {
			// Normal Player

			TextureRegion playerRegion = null;
			if ((p.getPlayerState() == Player.STATE_DEAD) || (p.getPlayerState() == Player.STATE_PARADOX)
					|| (p.getPlayerState() == Player.STATE_TIMEOUT)) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_DEATH,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else {

				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

				Vector2 currentVelocity = body.getLinearVelocity();
				float angle = currentVelocity.angle();
				if (angle == 0) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_IDLE_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (angle == 180) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_IDLE_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_JUMPING_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_GREEN_WITHFLAG_JUMPING_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				}
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		} else {

			TextureRegion playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
					(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

			Vector2 currentVelocity = body.getLinearVelocity();
			float angle = currentVelocity.angle();
			if (angle == 0) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (angle == 180) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		}
	}

	private void renderPlayerViolet(Body body) {
		Player p = (Player) body.getUserData();
		if (!p.isReplaying()) {
			// Normal Player

			TextureRegion playerRegion = null;
			if ((p.getPlayerState() == Player.STATE_DEAD) || (p.getPlayerState() == Player.STATE_PARADOX)
					|| (p.getPlayerState() == Player.STATE_TIMEOUT)) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_DEATH,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else {

				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

				Vector2 currentVelocity = body.getLinearVelocity();
				float angle = currentVelocity.angle();
				if (angle == 0) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_IDLE_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (angle == 180) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_IDLE_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_JUMPING_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_JUMPING_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				}
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		} else {

			TextureRegion playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
					(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

			Vector2 currentVelocity = body.getLinearVelocity();
			float angle = currentVelocity.angle();
			if (angle == 0) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (angle == 180) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		}
	}

	private void renderPlayerVioletWithFlag(Body body) {
		Player p = (Player) body.getUserData();
		if (!p.isReplaying()) {
			// Normal Player

			TextureRegion playerRegion = null;
			if ((p.getPlayerState() == Player.STATE_DEAD) || (p.getPlayerState() == Player.STATE_PARADOX)
					|| (p.getPlayerState() == Player.STATE_TIMEOUT)) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_DEATH,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else {

				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

				Vector2 currentVelocity = body.getLinearVelocity();
				float angle = currentVelocity.angle();
				if (angle == 0) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_IDLE_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (angle == 180) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_IDLE_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_JUMPING_RIGHT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
					playerRegion = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_VIOLET_WITHFLAG_JUMPING_LEFT,
							(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
				}
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		} else {

			TextureRegion playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
					(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));

			Vector2 currentVelocity = body.getLinearVelocity();
			float angle = currentVelocity.angle();
			if (angle == 0) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (angle == 180) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_IDLE_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 0) && (angle < 90)) || ((angle > 270) && (angle < 360))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_RIGHT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			} else if (((angle > 90) && (angle < 180)) || ((angle > 180) && (angle < 270))) {
				playerRegion = this.gameAssets.getAnimation(WholeGameAssets.GHOST_JUMPING_LEFT,
						(float) ((this.gameWorld.getTimeEpoch() % 1000) / 1000.0));
			}

			this.renderer.getBatch().draw(playerRegion, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					playerRegion.getRegionWidth() / 16f, playerRegion.getRegionHeight() / 16f);
		}
	}

	public void renderBullets() {
		this.renderer.getBatch().begin();
		for (Body body : this.gameWorld.getBulletBodysList()) {
			TextureRegion region = this.gameAssets.getAnimation(WholeGameAssets.PLAYER_BULLET, 0);
			this.renderer.getBatch().draw(region, body.getWorldCenter().x - 0.5f, body.getWorldCenter().y - 0.5f,
					region.getRegionWidth() / 16f, region.getRegionHeight() / 16f);
		}
		this.renderer.getBatch().end();
	}

	public void renderEnemies()
	{
		this.renderer.getBatch().begin();

		//System.out.println("Time Epoch "+this.gameWorld.getTimeEpoch());

		for (NoPlayer enemy : this.gameWorld.getEnemyList())
		{
			if (enemy.getAnimation() > 0)
			{	

				TextureRegion enemyRegion = this.gameAssets.getAnimation(
						enemy.getAnimation(), (float) ((this.gameWorld.getTimeEpoch() % 1000)/1000.0));			


				if (enemyRegion != null)
					this.renderer.getBatch().draw(enemyRegion, enemy.getCurrentX(),
							this.gameWorld.getMapHeight() - enemy.getCurrentY() - 1,
							enemyRegion.getRegionWidth() / 16f, enemyRegion.getRegionHeight() / 16f);
			}
		}

		this.renderer.getBatch().end();
	}

	public void render()
	{

		this.renderer.render();
		//this.renderEnemies();
		this.renderPlayer();
		this.renderBullets();
		this.box2DRenderer.render(this.gameWorld.getWorld(), this.guiCam.combined);
	}



}
