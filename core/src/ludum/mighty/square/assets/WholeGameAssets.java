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

	public static final int WICKED_RED_IDLE_LEFT = 10;
	public static final int WICKED_RED_IDLE_RIGHT = 11;
	public static final int WICKED_RED_RUNNING_LEFT = 12;
	public static final int WICKED_RED_RUNNING_RIGHT = 13;
	public static final int WICKED_RED_JUMPING_LEFT = 14;
	public static final int WICKED_RED_JUMPING_RIGHT = 15;
	public static final int WICKED_RED_CHARRED = 93; //Shared
	
	public static final int WICKED_PURPLE_IDLE_LEFT = 16;
	public static final int WICKED_PURPLE_IDLE_RIGHT = 17;
	public static final int WICKED_PURPLE_RUNNING_LEFT = 18;
	public static final int WICKED_PURPLE_RUNNING_RIGHT = 19;
	public static final int WICKED_PURPLE_JUMPING_LEFT = 20;
	public static final int WICKED_PURPLE_JUMPING_RIGHT = 21;
	public static final int WICKED_PURPLE_CHARRED = 91; //Shared
	
	public static final int WICKED_BLUE_IDLE_LEFT = 22;
	public static final int WICKED_BLUE_IDLE_RIGHT = 23;
	public static final int WICKED_BLUE_RUNNING_LEFT = 24;
	public static final int WICKED_BLUE_RUNNING_RIGHT = 25;
	public static final int WICKED_BLUE_JUMPING_LEFT = 26;
	public static final int WICKED_BLUE_JUMPING_RIGHT = 27;
	public static final int WICKED_BLUE_CHARRED = 92; //Shared
	
	public static final int BLOB_GREEN_IDLE_LEFT = 28;
	public static final int BLOB_GREEN_IDLE_RIGHT = 29;
	public static final int BLOB_GREEN_RUNNING_LEFT = 30;
	public static final int BLOB_GREEN_RUNNING_RIGHT = 31;
	public static final int BLOB_GREEN_DEAD = 32;
	public static final int BLOB_GREEN_CHARRED = 33; //Shared
	
	public static final int BLOB_PURPLE_IDLE_LEFT = 34;
	public static final int BLOB_PURPLE_IDLE_RIGHT = 35;
	public static final int BLOB_PURPLE_RUNNING_LEFT = 36;
	public static final int BLOB_PURPLE_RUNNING_RIGHT = 37;
	public static final int BLOB_PURPLE_DEAD = 38;
	public static final int BLOB_PURPLE_CHARRED = 331; //Shared
	
	public static final int PLAYER_BULLET = 39;
	public static final int WICKED_BULLET = 40;
	
	public static final int BAT_IDLE = 41;
	public static final int BAT_FLYING_LEFT = 42;
	public static final int BAT_FLYING_RIGHT = 421;
	public static final int BAT_CHARRED = 43;
	
	public static final int GARGOYLE_IDLE = 44;
	public static final int GARGOYLE_SHOOT = 45;
	
	public static final int GUILLOTINE = 46;
	
	public static final int DOORUP_OPEN = 47;
	public static final int DOORUP_CLOSED = 48;
	public static final int DOORDOWN_OPEN =49;
	public static final int DOORDOWN_CLOSED = 50;
	
	public static final int LEVER_ON = 51;
	public static final int LEVER_OFF = 52;	

	public static final int KEY = 53;
	public static final int BEER = 54;
	public static final int JEWEL = 55;
	
	public static final int NORMAL_BLOCK = 56;
	public static final int PART_BLOCK = 57;
	
	public static final int WHOLEDOOR_OPEN= 58;
	public static final int WHOLEDOOR_CLOSED = 59;
	
	public static final int GHOST_IDLE_LEFT = 60;
	public static final int GHOST_IDLE_RIGHT = 61;
	public static final int GHOST_RUNNING_LEFT = 62;
	public static final int GHOST_RUNNING_RIGHT = 63;
	public static final int GHOST_JUMPING_LEFT = 64;
	public static final int GHOST_JUMPING_RIGHT = 65;
	public static final int GHOST_IN_STAIR = 66;
	public static final int GHOST_DEATH = 67;
	public static final int GHOST_CHARRED = 68;
	
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

	//Ghost Animations and Textures
	Animation ghostIdle;
	Animation ghostRunning;
	Animation ghostUpDown;
	
	TextureRegion ghostIdleTexture;
	TextureRegion ghostRunning1Texture;
	TextureRegion ghostRunning2Texture; 
	TextureRegion ghostJumpingTexture;
	TextureRegion ghostDeadTexture;
	TextureRegion ghostUpDown1Texture;
	TextureRegion ghostUpDown2Texture;
	
	//WickedMages Animations and Textures
	//Wicked Red
	Animation wickedRedIdle;
	Animation wickedRedRunning;
	
	TextureRegion wickedRedIdleTexture;
	TextureRegion wickedRedRunning1Texture;
	TextureRegion wickedRedRunning2Texture; 
	TextureRegion wickedRedJumpingTexture;
	
	//Blue
	Animation wickedBlueIdle;
	Animation wickedBlueRunning;
	
	TextureRegion wickedBlueIdleTexture;
	TextureRegion wickedBlueRunning1Texture;
	TextureRegion wickedBlueRunning2Texture; 
	TextureRegion wickedBlueJumpingTexture;
	
	//Purple
	Animation wickedPurpleIdle;
	Animation wickedPurpleRunning;
	
	TextureRegion wickedPurpleIdleTexture;
	TextureRegion wickedPurpleRunning1Texture;
	TextureRegion wickedPurpleRunning2Texture; 
	TextureRegion wickedPurpleJumpingTexture;
	
	//Common mage Animations
	
	TextureRegion mageCharredTexture;
	
	//Player Bullet Animation

	TextureRegion bulletPlayerThrowTexture;
	
	//Wicked Bullet Animation

	TextureRegion bulletWickedThrowTexture;
	
	//Animations blob
	//Green
	Animation blobGreenIdle;
	Animation blobGreenRunning;
	
	TextureRegion blobGreenRunning1Texture;
	TextureRegion blobGreenRunning2Texture;
	TextureRegion blobGreenDeadTexture;
	

	//Purple
	Animation blobPurpleIdle;
	Animation blobPurpleRunning;
	
	
	TextureRegion blobPurpleRunning1Texture;
	TextureRegion blobPurpleRunning2Texture;
	TextureRegion blobPurpleDeadTexture;
	
	//Common blob Anims
	
	TextureRegion blobCharredTexture;
	
	//Bat Animations
	Animation batFlying;
	
	TextureRegion batIdleTexture;
	TextureRegion batFlying1Texture;
	TextureRegion batFlying2Texture;
	TextureRegion batCharredTexture;
	
	//Gargoyle Animations
	TextureRegion gargoyle1Texture;
	TextureRegion gargoyle2Texture;
	
	//Guillotine Animations
	
	TextureRegion guillotineTexture;
	
	//Other objects Animations and textures
	//Door
	
	TextureRegion doorOpenUpTexture;
	TextureRegion doorOpenDownTexture;
	TextureRegion doorCloseUpTexture;
	TextureRegion doorCloseDownTexture;
	
	TextureRegion wholeDoorOpenTexture;
	TextureRegion wholeDoorCloseTexture;
	
	//Lever
	
	TextureRegion leverOnTexture;
	TextureRegion leverOffTexture;
	
	//Key
	TextureRegion keyTexture;
	TextureRegion beerTexture;
	TextureRegion jewelTexture;
	
	//Blocks
	Animation breakBlock;
	
	TextureRegion normalBlockTexture;
	TextureRegion part1BlockTexture;
	TextureRegion part2BlockTexture;
	TextureRegion part3BlockTexture;
	
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
			

		case GHOST_IDLE_LEFT:
			texture = new TextureRegion(this.ghostIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
		
		case GHOST_IDLE_RIGHT:
			texture = new TextureRegion(this.ghostIdle.getKeyFrame(time, true));
			return texture;
			
		case GHOST_RUNNING_LEFT:
			texture = new TextureRegion(this.ghostRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
		
		case GHOST_RUNNING_RIGHT:
			texture = new TextureRegion(this.ghostRunning.getKeyFrame(time, true));
			return texture;
			
		case GHOST_JUMPING_LEFT:
			texture = new TextureRegion(this.ghostJumpingTexture);
			texture.flip(true, false);
			return texture;
			
		case GHOST_JUMPING_RIGHT:
			texture = new TextureRegion(this.ghostJumpingTexture);
			return texture;
			
		case GHOST_IN_STAIR:
			texture = new TextureRegion(this.ghostUpDown.getKeyFrame(time, true));
			return texture;
			
		case GHOST_DEATH:
			texture = new TextureRegion(this.ghostDeadTexture);
			return texture;		
			
			
		case WICKED_PURPLE_CHARRED:
		case WICKED_RED_CHARRED:
		case WICKED_BLUE_CHARRED:
		case PLAYER_GREEN_CHARRED:
		case PLAYER_GREEN_WITHFLAG_CHARRED:
		case PLAYER_VIOLET_CHARRED:
		case PLAYER_VIOLET_WITHFLAG_CHARRED:
		case GHOST_CHARRED:
			texture = new TextureRegion(this.mageCharredTexture);
			return texture;
	
		case WICKED_RED_IDLE_LEFT:
			texture = new TextureRegion(this.wickedRedIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case WICKED_RED_IDLE_RIGHT:
			texture = new TextureRegion(this.wickedRedIdle.getKeyFrame(time, true));
			return texture;
		
		case WICKED_RED_RUNNING_LEFT:
			texture = new TextureRegion(this.wickedRedRunning.getKeyFrame(time, true));
			texture.flip(true,false);
			return texture;
			
		case WICKED_RED_RUNNING_RIGHT:
			texture = new TextureRegion(this.wickedRedRunning.getKeyFrame(time, true));
			return texture;
	
		case WICKED_RED_JUMPING_LEFT:
			texture = new TextureRegion(this.wickedRedJumpingTexture);
			texture.flip(true,false);
			return texture;
			
		case WICKED_RED_JUMPING_RIGHT:
			texture = new TextureRegion(this.wickedRedJumpingTexture);
			return texture;			
		

		case WICKED_PURPLE_IDLE_LEFT:
			texture = new TextureRegion(this.wickedPurpleIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case WICKED_PURPLE_IDLE_RIGHT:
			texture = new TextureRegion(this.wickedPurpleIdle.getKeyFrame(time, true));
			return texture;
		
		case WICKED_PURPLE_RUNNING_LEFT:
			texture = new TextureRegion(this.wickedPurpleRunning.getKeyFrame(time, true));
			texture.flip(true,false);
			return texture;
			
		case WICKED_PURPLE_RUNNING_RIGHT:
			texture = new TextureRegion(this.wickedPurpleRunning.getKeyFrame(time, true));
			return texture;
	
		case WICKED_PURPLE_JUMPING_LEFT:
			texture = new TextureRegion(this.wickedPurpleJumpingTexture);
			texture.flip(true,false);
			return texture;
			
		case WICKED_PURPLE_JUMPING_RIGHT:
			texture = new TextureRegion(this.wickedPurpleJumpingTexture);
			return texture;			
			
			
		case WICKED_BLUE_IDLE_LEFT:
			texture = new TextureRegion(this.wickedBlueIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case WICKED_BLUE_IDLE_RIGHT:
			texture = new TextureRegion(this.wickedBlueIdle.getKeyFrame(time, true));
			return texture;
		
		case WICKED_BLUE_RUNNING_LEFT:
			texture = new TextureRegion(this.wickedBlueRunning.getKeyFrame(time, true));
			texture.flip(true,false);
			return texture;
			
		case WICKED_BLUE_RUNNING_RIGHT:
			texture = new TextureRegion(this.wickedBlueRunning.getKeyFrame(time, true));
			return texture;
	
		case WICKED_BLUE_JUMPING_LEFT:
			texture = new TextureRegion(this.wickedBlueJumpingTexture);
			texture.flip(true,false);
			return texture;
			
		case WICKED_BLUE_JUMPING_RIGHT:
			texture = new TextureRegion(this.wickedBlueJumpingTexture);
			return texture;			
			
		case BLOB_GREEN_IDLE_LEFT:
			texture = new TextureRegion(this.blobGreenIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case BLOB_GREEN_IDLE_RIGHT:
			texture = new TextureRegion(this.blobGreenIdle.getKeyFrame(time, true));
			return texture;
	
		case BLOB_GREEN_RUNNING_LEFT:
			texture = new TextureRegion(this.blobGreenRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case BLOB_GREEN_RUNNING_RIGHT:
			texture = new TextureRegion(this.blobGreenRunning.getKeyFrame(time, true));
			return texture;

		case BLOB_GREEN_DEAD:
			texture = new TextureRegion(this.blobGreenDeadTexture);
			return texture;
		
		case BLOB_GREEN_CHARRED:
		case BLOB_PURPLE_CHARRED:
			texture = new TextureRegion(this.blobCharredTexture);
			return texture;
			
		
		case BLOB_PURPLE_IDLE_LEFT:
			texture = new TextureRegion(this.blobPurpleIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case BLOB_PURPLE_IDLE_RIGHT:
			texture = new TextureRegion(this.blobPurpleIdle.getKeyFrame(time, true));
			return texture;
	
		case BLOB_PURPLE_RUNNING_LEFT:
			texture = new TextureRegion(this.blobPurpleRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
			
		case BLOB_PURPLE_RUNNING_RIGHT:
			texture = new TextureRegion(this.blobPurpleRunning.getKeyFrame(time, true));
			return texture;

		case BLOB_PURPLE_DEAD:
			texture = new TextureRegion(this.blobPurpleDeadTexture);
			return texture;
		
		case PLAYER_BULLET:
			texture = new TextureRegion(this.bulletPlayerThrowTexture);
			return texture;
		
		case WICKED_BULLET:
			texture = new TextureRegion(this.bulletWickedThrowTexture);
			return texture;
		
		case BAT_IDLE:
			texture = new TextureRegion(this.batIdleTexture);
			return texture;
			
		case BAT_FLYING_LEFT:
			texture = new TextureRegion(this.batFlying.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
		
		case BAT_FLYING_RIGHT:
			texture = new TextureRegion(this.batFlying.getKeyFrame(time, true));
			return texture;	
		
		case BAT_CHARRED:
			texture = new TextureRegion(this.batCharredTexture);
			return texture;
			
		case GARGOYLE_IDLE:
			texture = new TextureRegion(this.gargoyle1Texture);
			return texture;
			
		case GARGOYLE_SHOOT:
			texture = new TextureRegion(this.gargoyle2Texture);
			return texture;
			
		case GUILLOTINE:
			texture = new TextureRegion(this.guillotineTexture);
			return texture;
			

		case DOORUP_OPEN:
			texture = new TextureRegion(this.doorOpenUpTexture);
			return texture;
			
		case DOORUP_CLOSED:
			texture = new TextureRegion(this.doorCloseUpTexture);
			return texture;
			
		case DOORDOWN_OPEN:
			texture = new TextureRegion(this.doorOpenDownTexture);
			return texture;
			
		case DOORDOWN_CLOSED:
			texture = new TextureRegion(this.doorCloseDownTexture);
			return texture;

		case WHOLEDOOR_OPEN:
			texture = new TextureRegion(this.wholeDoorOpenTexture);
			return texture;
		
		case WHOLEDOOR_CLOSED:
			texture = new TextureRegion(this.wholeDoorCloseTexture);
			return texture;
			
		case LEVER_ON:
			texture = new TextureRegion(this.leverOnTexture);
			return texture;
			
		case LEVER_OFF:
			texture = new TextureRegion(this.leverOffTexture);
			return texture;
		
		case KEY:
			texture = new TextureRegion(this.keyTexture);
			return texture;
		
		case BEER:
			texture = new TextureRegion(this.beerTexture);
			return texture;

		case JEWEL:
			texture = new TextureRegion(this.jewelTexture);
			return texture;
			
		case NORMAL_BLOCK:
			texture = new TextureRegion(this.normalBlockTexture);
			return texture;
			
		case PART_BLOCK:
			texture = new TextureRegion(this.breakBlock.getKeyFrame(time, true));
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

		//Ghost Texture
		this.ghostIdleTexture = new TextureRegion(allThingsSheet, 0,7 * 16,16, 16);
		this.ghostRunning1Texture = new TextureRegion(allThingsSheet, 3* 16, 7 * 16, 16, 16);
		this.ghostRunning2Texture = new TextureRegion(allThingsSheet, 4* 16, 7 * 16, 16, 16);
		this.ghostJumpingTexture = new TextureRegion(allThingsSheet, 6 * 16, 7 *16, 16, 16);
		this.ghostDeadTexture = new TextureRegion(allThingsSheet, 5 * 16, 7* 16, 16, 16);
		this.ghostUpDown1Texture = new TextureRegion(allThingsSheet, 1 * 16, 7 * 16, 16, 16);
		this.ghostUpDown2Texture = new TextureRegion(allThingsSheet, 2 * 16, 7 * 16, 16, 16);
		
		this.ghostIdle =  new Animation(0.20f,
				this.ghostIdleTexture,
				this.ghostRunning1Texture);
		
		this.ghostIdle.setPlayMode(PlayMode.LOOP);
		
		this.ghostRunning = new Animation(0.10f,
				this.ghostRunning1Texture,
				this.ghostIdleTexture,
				this.ghostRunning2Texture
				);
		
		this.ghostRunning.setPlayMode(PlayMode.LOOP);
		
		
		this.ghostUpDown = new Animation(0.15f,
				this.ghostUpDown1Texture,
				this.ghostUpDown2Texture);
		this.ghostUpDown.setPlayMode(PlayMode.LOOP);
		
		
		//Wicked Mage Textures
		this.wickedRedIdleTexture = new TextureRegion(allThingsSheet, 9 * 16, 0, 16, 16 );
		this.wickedRedRunning1Texture = new TextureRegion(allThingsSheet, 5 *16, 2 *16, 16, 16);
		this.wickedRedRunning2Texture = new TextureRegion(allThingsSheet, 6 * 16, 2 * 16, 16, 16);
		this.wickedRedJumpingTexture = new TextureRegion(allThingsSheet, 9 * 16, 16, 16, 16);
		
		this.wickedRedIdle = new Animation(0.20f,
				this.wickedRedIdleTexture,
				this.wickedRedRunning1Texture);
		
		this.wickedRedIdle.setPlayMode(PlayMode.LOOP);
		
		this.wickedRedRunning = new Animation(0.10f, 
				this.wickedRedRunning1Texture, 
				this.wickedRedIdleTexture,
				this.wickedRedRunning2Texture);
		
		this.wickedRedRunning.setPlayMode(PlayMode.LOOP);
		
		
		this.wickedBlueIdleTexture = new TextureRegion(allThingsSheet, 6 * 16, 4 * 16, 16, 16 );
		this.wickedBlueRunning1Texture = new TextureRegion(allThingsSheet, 8 * 16 , 4 * 16, 16, 16);
		this.wickedBlueRunning2Texture = new TextureRegion(allThingsSheet, 9 * 16, 4 * 16, 16, 16);
		this.wickedBlueJumpingTexture = new TextureRegion(allThingsSheet,7 * 16, 4 * 16, 16, 16);
		
		this.wickedBlueIdle = new Animation(0.20f,
				this.wickedBlueIdleTexture,
				this.wickedBlueRunning1Texture);
		this.wickedBlueIdle.setPlayMode(PlayMode.LOOP);
		
		this.wickedBlueRunning = new Animation(0.10f, 
				this.wickedBlueRunning1Texture, 
				this.wickedBlueIdleTexture,
				this.wickedBlueRunning2Texture);
		
		this.wickedBlueRunning.setPlayMode(PlayMode.LOOP);
		
		this.wickedPurpleIdleTexture = new TextureRegion(allThingsSheet, 0, 5 * 16, 16, 16 );
		this.wickedPurpleRunning1Texture = new TextureRegion(allThingsSheet,2* 16  , 5 * 16, 16, 16);
		this.wickedPurpleRunning2Texture = new TextureRegion(allThingsSheet, 3 * 16, 5 * 16, 16, 16);
		this.wickedPurpleJumpingTexture = new TextureRegion(allThingsSheet, 16, 5 * 16, 16, 16);
		
		this.wickedPurpleIdle = new Animation(0.20f,
				this.wickedPurpleIdleTexture,
				this.wickedPurpleRunning1Texture);
		
		this.wickedPurpleIdle.setPlayMode(PlayMode.LOOP);
		
		
		this.wickedPurpleRunning = new Animation(0.10f, 
				this.wickedPurpleRunning1Texture, 
				this.wickedPurpleIdleTexture,
				this.wickedPurpleRunning2Texture);
		
		this.wickedPurpleRunning.setPlayMode(PlayMode.LOOP);
		
		this.mageCharredTexture = new TextureRegion(allThingsSheet, 8 *16, 16, 16, 16);
	
		//Bullets
		this.bulletPlayerThrowTexture = new TextureRegion(allThingsSheet, 4 *16, 5 * 16, 16, 16);
		this.bulletWickedThrowTexture = new TextureRegion(allThingsSheet, 4 * 16, 2 * 16, 16, 16);
		
		//Blob Textures
		//Green
		this.blobGreenRunning1Texture = new TextureRegion(allThingsSheet, 5 *16, 3 * 16, 16, 16);
		this.blobGreenRunning2Texture = new TextureRegion(allThingsSheet, 6 *16, 3 * 16, 16, 16);
		this.blobGreenDeadTexture = new TextureRegion(allThingsSheet, 7 * 16, 3 * 16, 16, 16);
		
		this.blobGreenIdle = new Animation(0.20f, 
				this.blobGreenRunning1Texture,
				this.blobGreenRunning2Texture);
		this.blobGreenIdle.setPlayMode(PlayMode.LOOP);
		
		this.blobGreenRunning = new Animation(0.10f, 
				this.blobGreenRunning1Texture,
				this.blobGreenRunning2Texture);
		this.blobGreenRunning.setPlayMode(PlayMode.LOOP);
		
		//Purple
		this.blobPurpleRunning1Texture = new TextureRegion(allThingsSheet, 5 * 16, 5 * 16, 16, 16);
		this.blobPurpleRunning2Texture = new TextureRegion(allThingsSheet, 6 *16, 5 * 16, 16, 16);
		this.blobPurpleDeadTexture = new TextureRegion(allThingsSheet, 7 * 16, 5 * 16, 16, 16);
		
		this.blobPurpleIdle = new Animation(0.20f, 
				this.blobPurpleRunning1Texture,
				this.blobPurpleRunning2Texture);
		this.blobPurpleIdle.setPlayMode(PlayMode.LOOP);
		
		this.blobPurpleRunning = new Animation(0.10f, 
				this.blobPurpleRunning1Texture,
				this.blobPurpleRunning2Texture);
		this.blobPurpleRunning.setPlayMode(PlayMode.LOOP);
		
		//Common
		this.blobCharredTexture = new TextureRegion(allThingsSheet, 8 * 16, 3 * 16, 16, 16);
		
		
		//Bat Textures and Animations
		this.batIdleTexture = new TextureRegion(allThingsSheet, 16, 6 * 16, 16, 16);
		this.batFlying1Texture = new TextureRegion(allThingsSheet, 8 * 16, 5 * 16, 16, 16);
		this.batFlying2Texture = new TextureRegion(allThingsSheet, 9 * 16, 5 * 16, 16, 16);
		this.batCharredTexture = new TextureRegion(allThingsSheet, 3 * 16, 6 * 16, 16, 16);
		
		this.batFlying = new Animation(0.10f,
				this.batFlying1Texture, 
				this.batFlying2Texture);
		
		this.batFlying.setPlayMode(PlayMode.LOOP);
		
		//Gargoyle Texture
		this.gargoyle1Texture = new TextureRegion(allThingsSheet, 9 * 16, 2* 16, 16, 16);
		this.gargoyle2Texture = new TextureRegion(allThingsSheet, 9 * 16, 3 * 16, 16, 16);
		
		//Guillotine Textures
		this.guillotineTexture = new TextureRegion(allThingsSheet, 0, 6 * 16, 16 , 16);
		
		//Door Textures
		this.doorOpenUpTexture = new TextureRegion(allThingsSheet, 2 * 16, 0, 16, 16);
		this.doorOpenDownTexture = new TextureRegion(allThingsSheet, 2 * 16, 16, 16, 16);
		
		this.doorCloseUpTexture = new TextureRegion(allThingsSheet, 16, 0, 16, 16);
		this.doorCloseDownTexture = new TextureRegion(allThingsSheet, 16, 16, 16, 16);
		
		this.wholeDoorOpenTexture = new TextureRegion(allThingsSheet, 2 * 16, 0, 16, 32);
		this.wholeDoorCloseTexture = new TextureRegion(allThingsSheet, 16, 0, 16, 32);
			
		//Lever Textures
		this.leverOnTexture = new TextureRegion(allThingsSheet, 0, 2 *16, 16, 16);
		this.leverOffTexture = new TextureRegion(allThingsSheet, 16, 2 * 16, 16, 16);
		
		
		//Other Textures
		this.keyTexture = new TextureRegion(allThingsSheet, 4 * 16, 16, 16, 16);
		this.beerTexture = new TextureRegion(allThingsSheet, 7 * 16, 2 * 16, 16, 16);
		this.jewelTexture = new TextureRegion(allThingsSheet, 5 *16, 0, 16, 16);
		
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
		
	}

}
