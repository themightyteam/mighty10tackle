package ludum.mighty.square.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class WholeGameAssets extends AbstractAssets {

	static Texture allThingsSheet;
	
	public static final int DOING_NOTHING = 0;
	
	public static final int PLAYER_GREEN_DOING_NOTHING = 1000;
	public static final int PLAYER_GREEN_IDLE_LEFT = 1001;
	public static final int PLAYER_GREEN_IDLE_RIGHT = 1002;
	public static final int PLAYER_GREEN_RUNNING_LEFT = 1003;
	public static final int PLAYER_GREEN_RUNNING_RIGHT = 1004;
	public static final int PLAYER_GREEN_JUMPING_LEFT = 1005;
	public static final int PLAYER_GREEN_JUMPING_RIGHT = 1006;
	public static final int PLAYER_GREEN_IN_STAIR = 1007;
	public static final int PLAYER_GREEN_DEATH = 1008;
	public static final int PLAYER_GREEN_CHARRED = 1009;
	
	public static final int PLAYER_GREEN_WITHFLAG_DOING_NOTHING = 2000;
	public static final int PLAYER_GREEN_WITHFLAG_IDLE_LEFT = 2001;
	public static final int PLAYER_GREEN_WITHFLAG_IDLE_RIGHT = 2002;
	public static final int PLAYER_GREEN_WITHFLAG_RUNNING_LEFT = 2003;
	public static final int PLAYER_GREEN_WITHFLAG_RUNNING_RIGHT = 2004;
	public static final int PLAYER_GREEN_WITHFLAG_JUMPING_LEFT = 2005;
	public static final int PLAYER_GREEN_WITHFLAG_JUMPING_RIGHT = 2006;
	public static final int PLAYER_GREEN_WITHFLAG_IN_STAIR = 2007;
	public static final int PLAYER_GREEN_WITHFLAG_DEATH = 2008;
	public static final int PLAYER_GREEN_WITHFLAG_CHARRED = 2009;

	public static final int PLAYER_VIOLET_DOING_NOTHING = 3000;
	public static final int PLAYER_VIOLET_IDLE_LEFT = 3001;
	public static final int PLAYER_VIOLET_IDLE_RIGHT = 3002;
	public static final int PLAYER_VIOLET_RUNNING_LEFT = 3003;
	public static final int PLAYER_VIOLET_RUNNING_RIGHT = 3004;
	public static final int PLAYER_VIOLET_JUMPING_LEFT = 3005;
	public static final int PLAYER_VIOLET_JUMPING_RIGHT = 3006;
	public static final int PLAYER_VIOLET_IN_STAIR = 3007;
	public static final int PLAYER_VIOLET_DEATH = 3008;
	public static final int PLAYER_VIOLET_CHARRED = 3009;

	public static final int PLAYER_VIOLET_WITHFLAG_DOING_NOTHING = 4000;
	public static final int PLAYER_VIOLET_WITHFLAG_IDLE_LEFT = 4001;
	public static final int PLAYER_VIOLET_WITHFLAG_IDLE_RIGHT = 4002;
	public static final int PLAYER_VIOLET_WITHFLAG_RUNNING_LEFT = 4003;
	public static final int PLAYER_VIOLET_WITHFLAG_RUNNING_RIGHT = 4004;
	public static final int PLAYER_VIOLET_WITHFLAG_JUMPING_LEFT = 4005;
	public static final int PLAYER_VIOLET_WITHFLAG_JUMPING_RIGHT = 4006;
	public static final int PLAYER_VIOLET_WITHFLAG_IN_STAIR = 4007;
	public static final int PLAYER_VIOLET_WITHFLAG_DEATH = 4008;
	public static final int PLAYER_VIOLET_WITHFLAG_CHARRED = 4009;
	
	public static final int PLAYER_BULLET = 39;
	
	public static final int GREEN_TEAM_SCORES = 5001;
	public static final int VIOLET_TEAM_SCORES = 5002;
	public static final int GREEN_TEAM_HAS_FLAG = 5003;
	public static final int VIOLET_TEAM_HAS_FLAG = 5004;

	//Player Animations and Textures
	Animation playerGreenIdle;
	Animation playerGreenRunning;
	Animation playerGreenUpDown;

	TextureRegion playerGreenIdleTexture;
	TextureRegion playerGreenRunning1Texture;
	TextureRegion playerGreenRunning2Texture;
	TextureRegion playerGreenJumpingTexture;
	TextureRegion playerGreenDeadTexture;
	TextureRegion playerGreenUpDown1Texture;
	TextureRegion playerGreenUpDown2Texture;

	Animation playerGreenWithFlagIdle;
	Animation playerGreenWithFlagRunning;
	Animation playerGreenWithFlagUpDown;

	TextureRegion playerGreenWithFlagIdleTexture;
	TextureRegion playerGreenWithFlagRunning1Texture;
	TextureRegion playerGreenWithFlagRunning2Texture;
	TextureRegion playerGreenWithFlagJumpingTexture;
	TextureRegion playerGreenWithFlagDeadTexture;
	TextureRegion playerGreenWithFlagUpDown1Texture;
	TextureRegion playerGreenWithFlagUpDown2Texture;
	
	Animation playerVioletIdle;
	Animation playerVioletRunning;
	Animation playerVioletUpDown;

	TextureRegion playerVioletIdleTexture;
	TextureRegion playerVioletRunning1Texture;
	TextureRegion playerVioletRunning2Texture;
	TextureRegion playerVioletJumpingTexture;
	TextureRegion playerVioletDeadTexture;
	TextureRegion playerVioletUpDown1Texture;
	TextureRegion playerVioletUpDown2Texture;

	Animation playerVioletWithFlagIdle;
	Animation playerVioletWithFlagRunning;
	Animation playerVioletWithFlagUpDown;

	TextureRegion playerVioletWithFlagIdleTexture;
	TextureRegion playerVioletWithFlagRunning1Texture;
	TextureRegion playerVioletWithFlagRunning2Texture;
	TextureRegion playerVioletWithFlagJumpingTexture;
	TextureRegion playerVioletWithFlagDeadTexture;
	TextureRegion playerVioletWithFlagUpDown1Texture;
	TextureRegion playerVioletWithFlagUpDown2Texture;
	
	//Player Bullet Animation

	TextureRegion bulletPlayerThrowTexture;

	//Blocks
	Animation breakBlock;
	
	TextureRegion normalBlockTexture;
	TextureRegion part1BlockTexture;
	TextureRegion part2BlockTexture;
	TextureRegion part3BlockTexture;
	
	// Scores
	TextureRegion greenTeamScores;
	TextureRegion violetTeamScores;
	TextureRegion greenTeamHasFlag;
	TextureRegion violetTeamHasFlag;

	@Override
	public TextureRegion getAsset(int asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animation getAnimation(int anim) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public TextureRegion getAnimation(int anim, float time) {
		
		TextureRegion texture;
		
		switch(anim)
		{
		case PLAYER_GREEN_DOING_NOTHING:
			texture = new TextureRegion(this.playerGreenIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_IDLE_RIGHT:
			texture = new TextureRegion(this.playerGreenIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_IDLE_LEFT:
			texture = new TextureRegion(this.playerGreenIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_RUNNING_LEFT:
			texture = new TextureRegion(this.playerGreenRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_RUNNING_RIGHT:
			texture = new TextureRegion(this.playerGreenRunning.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_JUMPING_LEFT:
			texture = new TextureRegion(this.playerGreenJumpingTexture);
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_JUMPING_RIGHT:
			texture = new TextureRegion(this.playerGreenJumpingTexture);
			return texture;

		case PLAYER_GREEN_IN_STAIR:
			texture = new TextureRegion(this.playerGreenUpDown.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_DEATH:
			texture = new TextureRegion(this.playerGreenDeadTexture);
			return texture;
			
		case PLAYER_GREEN_WITHFLAG_DOING_NOTHING:
			texture = new TextureRegion(this.playerGreenWithFlagIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_WITHFLAG_IDLE_RIGHT:
			texture = new TextureRegion(this.playerGreenWithFlagIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_WITHFLAG_IDLE_LEFT:
			texture = new TextureRegion(this.playerGreenWithFlagIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_WITHFLAG_RUNNING_LEFT:
			texture = new TextureRegion(this.playerGreenWithFlagRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_WITHFLAG_RUNNING_RIGHT:
			texture = new TextureRegion(this.playerGreenWithFlagRunning.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_WITHFLAG_JUMPING_LEFT:
			texture = new TextureRegion(this.playerGreenWithFlagJumpingTexture);
			texture.flip(true, false);
			return texture;

		case PLAYER_GREEN_WITHFLAG_JUMPING_RIGHT:
			texture = new TextureRegion(this.playerGreenWithFlagJumpingTexture);
			return texture;

		case PLAYER_GREEN_WITHFLAG_IN_STAIR:
			texture = new TextureRegion(this.playerGreenWithFlagUpDown.getKeyFrame(time, true));
			return texture;

		case PLAYER_GREEN_WITHFLAG_DEATH:
			texture = new TextureRegion(this.playerGreenWithFlagDeadTexture);
			return texture;
			
		case PLAYER_VIOLET_DOING_NOTHING:
			texture = new TextureRegion(this.playerVioletIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_IDLE_RIGHT:
			texture = new TextureRegion(this.playerVioletIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_IDLE_LEFT:
			texture = new TextureRegion(this.playerVioletIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_RUNNING_LEFT:
			texture = new TextureRegion(this.playerVioletRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_RUNNING_RIGHT:
			texture = new TextureRegion(this.playerVioletRunning.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_JUMPING_LEFT:
			texture = new TextureRegion(this.playerVioletJumpingTexture);
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_JUMPING_RIGHT:
			texture = new TextureRegion(this.playerVioletJumpingTexture);
			return texture;

		case PLAYER_VIOLET_IN_STAIR:
			texture = new TextureRegion(this.playerVioletUpDown.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_DEATH:
			texture = new TextureRegion(this.playerVioletDeadTexture);
			return texture;
			
			
		case PLAYER_VIOLET_WITHFLAG_DOING_NOTHING:
			texture = new TextureRegion(this.playerVioletWithFlagIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_WITHFLAG_IDLE_RIGHT:
			texture = new TextureRegion(this.playerVioletWithFlagIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_WITHFLAG_IDLE_LEFT:
			texture = new TextureRegion(this.playerVioletWithFlagIdle.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_WITHFLAG_RUNNING_LEFT:
			texture = new TextureRegion(this.playerVioletWithFlagRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_WITHFLAG_RUNNING_RIGHT:
			texture = new TextureRegion(this.playerVioletWithFlagRunning.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_WITHFLAG_JUMPING_LEFT:
			texture = new TextureRegion(this.playerVioletWithFlagJumpingTexture);
			texture.flip(true, false);
			return texture;

		case PLAYER_VIOLET_WITHFLAG_JUMPING_RIGHT:
			texture = new TextureRegion(this.playerVioletWithFlagJumpingTexture);
			return texture;

		case PLAYER_VIOLET_WITHFLAG_IN_STAIR:
			texture = new TextureRegion(this.playerVioletWithFlagUpDown.getKeyFrame(time, true));
			return texture;

		case PLAYER_VIOLET_WITHFLAG_DEATH:
			texture = new TextureRegion(this.playerVioletWithFlagDeadTexture);
			return texture;
			

		case PLAYER_GREEN_CHARRED:
		case PLAYER_GREEN_WITHFLAG_CHARRED:
		case PLAYER_VIOLET_CHARRED:
		case PLAYER_VIOLET_WITHFLAG_CHARRED:
		
		case PLAYER_BULLET:
			texture = new TextureRegion(this.bulletPlayerThrowTexture);
			return texture;
			
		case GREEN_TEAM_SCORES:
			texture = new TextureRegion(this.greenTeamScores);
			return texture;

		case VIOLET_TEAM_SCORES:
			texture = new TextureRegion(this.violetTeamScores);
			return texture;

		case GREEN_TEAM_HAS_FLAG:
			texture = new TextureRegion(this.greenTeamHasFlag);
			return texture;

		case VIOLET_TEAM_HAS_FLAG:
			texture = new TextureRegion(this.violetTeamHasFlag);
			return texture;

		}

		return null;
	}

	@Override
	public Rectangle getPolygonon(int assetType, float time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
		//Load the sheet with the sprites
		
		allThingsSheet = loadTexture("maps/minimalist_tileset.png");
		
		allThingsSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//Load Textures here!
		
		// Green player Textures
		this.playerGreenIdleTexture = new TextureRegion(allThingsSheet, 0, 6 * 16, 16, 16);
		this.playerGreenRunning1Texture = new TextureRegion(allThingsSheet, 16, 6 * 16, 16, 16);
		this.playerGreenRunning2Texture = new TextureRegion(allThingsSheet, 2 * 16, 6 * 16, 16, 16);
		this.playerGreenJumpingTexture = new TextureRegion(allThingsSheet, 3 * 16, 6 * 16, 16, 16);
		this.playerGreenDeadTexture = new TextureRegion(allThingsSheet, 4 * 16, 6 * 16, 16, 16);
		this.playerGreenUpDown1Texture = new TextureRegion(allThingsSheet, 5 * 16, 6 * 16, 16, 16);
		this.playerGreenUpDown2Texture = new TextureRegion(allThingsSheet, 6 * 16, 6 * 16, 16, 16);
		
		this.playerGreenIdle = new Animation(0.20f, this.playerGreenIdleTexture, this.playerGreenRunning1Texture);
		
		this.playerGreenIdle.setPlayMode(PlayMode.LOOP);
		
		this.playerGreenRunning = new Animation(0.10f, this.playerGreenRunning1Texture, this.playerGreenIdleTexture,
				this.playerGreenRunning2Texture
				);
		
		this.playerGreenRunning.setPlayMode(PlayMode.LOOP);
		
		this.playerGreenUpDown = new Animation(0.15f, this.playerGreenUpDown1Texture, this.playerGreenUpDown2Texture);
		this.playerGreenUpDown.setPlayMode(PlayMode.LOOP);
		
		// Green player with flag Textures
		this.playerGreenWithFlagIdleTexture = new TextureRegion(allThingsSheet, 0, 7 * 16, 16, 16);
		this.playerGreenWithFlagRunning1Texture = new TextureRegion(allThingsSheet, 16, 7 * 16, 16, 16);
		this.playerGreenWithFlagRunning2Texture = new TextureRegion(allThingsSheet, 2 * 16, 7 * 16, 16, 16);
		this.playerGreenWithFlagJumpingTexture = new TextureRegion(allThingsSheet, 3 * 16, 7 * 16, 16, 16);
		this.playerGreenWithFlagDeadTexture = new TextureRegion(allThingsSheet, 4 * 16, 7 * 16, 16, 16);
		this.playerGreenWithFlagUpDown1Texture = new TextureRegion(allThingsSheet, 5 * 16, 7 * 16, 16, 16);
		this.playerGreenWithFlagUpDown2Texture = new TextureRegion(allThingsSheet, 6 * 16, 7 * 16, 16, 16);

		this.playerGreenWithFlagIdle = new Animation(0.20f, this.playerGreenWithFlagIdleTexture,
				this.playerGreenWithFlagRunning1Texture);

		this.playerGreenWithFlagIdle.setPlayMode(PlayMode.LOOP);

		this.playerGreenWithFlagRunning = new Animation(0.10f, this.playerGreenWithFlagRunning1Texture,
				this.playerGreenWithFlagIdleTexture, this.playerGreenWithFlagRunning2Texture);

		this.playerGreenWithFlagRunning.setPlayMode(PlayMode.LOOP);

		this.playerGreenWithFlagUpDown = new Animation(0.15f, this.playerGreenWithFlagUpDown1Texture,
				this.playerGreenWithFlagUpDown2Texture);
		this.playerGreenWithFlagUpDown.setPlayMode(PlayMode.LOOP);
		
		// Violet player Textures
		this.playerVioletIdleTexture = new TextureRegion(allThingsSheet, 0, 8 * 16, 16, 16);
		this.playerVioletRunning1Texture = new TextureRegion(allThingsSheet, 16, 8 * 16, 16, 16);
		this.playerVioletRunning2Texture = new TextureRegion(allThingsSheet, 2 * 16, 8 * 16, 16, 16);
		this.playerVioletJumpingTexture = new TextureRegion(allThingsSheet, 3 * 16, 8 * 16, 16, 16);
		this.playerVioletDeadTexture = new TextureRegion(allThingsSheet, 4 * 16, 8 * 16, 16, 16);
		this.playerVioletUpDown1Texture = new TextureRegion(allThingsSheet, 5 * 16, 8 * 16, 16, 16);
		this.playerVioletUpDown2Texture = new TextureRegion(allThingsSheet, 6 * 16, 8 * 16, 16, 16);

		this.playerVioletIdle = new Animation(0.20f, this.playerVioletIdleTexture, this.playerVioletRunning1Texture);

		this.playerVioletIdle.setPlayMode(PlayMode.LOOP);

		this.playerVioletRunning = new Animation(0.10f, this.playerVioletRunning1Texture, this.playerVioletIdleTexture,
				this.playerVioletRunning2Texture);

		this.playerVioletRunning.setPlayMode(PlayMode.LOOP);

		this.playerVioletUpDown = new Animation(0.15f, this.playerVioletUpDown1Texture,
				this.playerVioletUpDown2Texture);
		this.playerVioletUpDown.setPlayMode(PlayMode.LOOP);

		// Violet player with flag Textures
		this.playerVioletWithFlagIdleTexture = new TextureRegion(allThingsSheet, 0, 9 * 16, 16, 16);
		this.playerVioletWithFlagRunning1Texture = new TextureRegion(allThingsSheet, 16, 9 * 16, 16, 16);
		this.playerVioletWithFlagRunning2Texture = new TextureRegion(allThingsSheet, 2 * 16, 9 * 16, 16, 16);
		this.playerVioletWithFlagJumpingTexture = new TextureRegion(allThingsSheet, 3 * 16, 9 * 16, 16, 16);
		this.playerVioletWithFlagDeadTexture = new TextureRegion(allThingsSheet, 4 * 16, 9 * 16, 16, 16);
		this.playerVioletWithFlagUpDown1Texture = new TextureRegion(allThingsSheet, 5 * 16, 9 * 16, 16, 16);
		this.playerVioletWithFlagUpDown2Texture = new TextureRegion(allThingsSheet, 6 * 16, 9 * 16, 16, 16);

		this.playerVioletWithFlagIdle = new Animation(0.20f, this.playerVioletWithFlagIdleTexture,
				this.playerVioletWithFlagRunning1Texture);

		this.playerVioletWithFlagIdle.setPlayMode(PlayMode.LOOP);

		this.playerVioletWithFlagRunning = new Animation(0.10f, this.playerVioletWithFlagRunning1Texture,
				this.playerVioletWithFlagIdleTexture, this.playerVioletWithFlagRunning2Texture);

		this.playerVioletWithFlagRunning.setPlayMode(PlayMode.LOOP);

		this.playerVioletWithFlagUpDown = new Animation(0.15f, this.playerVioletWithFlagUpDown1Texture,
				this.playerVioletWithFlagUpDown2Texture);
		this.playerVioletWithFlagUpDown.setPlayMode(PlayMode.LOOP);

		//Bullets
		this.bulletPlayerThrowTexture = new TextureRegion(allThingsSheet, 4 *16, 5 * 16, 16, 16);
		
		//TODO
		//BLOCK TEXTURES
		this.normalBlockTexture = new TextureRegion(allThingsSheet, 3 * 16, 0, 16, 16);
		this.part1BlockTexture = new TextureRegion(allThingsSheet, 3 * 16, 4 * 16, 16, 16);
		this.part2BlockTexture = new TextureRegion(allThingsSheet, 4 * 16, 4 * 16, 16, 16);
		this.part3BlockTexture = new TextureRegion(allThingsSheet, 5 * 16, 4 * 16, 16, 16);
		
		this.breakBlock = new Animation(0.10f, 
				this.part1BlockTexture,
				this.part2BlockTexture,
				this.part3BlockTexture
				);
		this.breakBlock.setPlayMode(PlayMode.LOOP);
		
		// Scores textures
		this.greenTeamScores = new TextureRegion(allThingsSheet, 7 * 16, 9 * 16, 3 * 16, 16);
		this.violetTeamScores = new TextureRegion(allThingsSheet, 7 * 16, 6 * 16, 3 * 16, 16);
		this.greenTeamHasFlag = new TextureRegion(allThingsSheet, 7 * 16, 5 * 16, 3 * 16, 16);
		this.violetTeamHasFlag = new TextureRegion(allThingsSheet, 7 * 16, 4 * 16, 3 * 16, 16);
	}
}
