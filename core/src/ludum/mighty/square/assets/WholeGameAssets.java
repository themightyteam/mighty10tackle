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
	public static final int PLAYER_IDLE_LEFT = 1;
	public static final int PLAYER_IDLE_RIGHT = 2;
	public static final int PLAYER_RUNNING_LEFT = 3;
	public static final int PLAYER_RUNNING_RIGHT = 4;
	public static final int PLAYER_JUMPING_LEFT = 5;
	public static final int PLAYER_JUMPING_RIGHT = 6;
	public static final int PLAYER_IN_STAIR = 7;
	public static final int PLAYER_DEATH = 8;
	public static final int PLAYER_CHARRED = 9;
	
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
	Animation playerIdle;
	Animation playerRunning;
	Animation playerUpDown;
	
	
	TextureRegion playerIdleTexture;
	TextureRegion playerRunning1Texture;
	TextureRegion playerRunning2Texture; 
	TextureRegion playerJumpingTexture;
	TextureRegion playerDeadTexture;
	TextureRegion playerUpDown1Texture;
	TextureRegion playerUpDown2Texture;
	
	
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
		
		case PLAYER_IDLE_LEFT:
			texture = new TextureRegion(this.playerIdle.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
		
		case PLAYER_IDLE_RIGHT:
			texture = new TextureRegion(this.playerIdle.getKeyFrame(time, true));
			return texture;
			
		case PLAYER_RUNNING_LEFT:
			texture = new TextureRegion(this.playerRunning.getKeyFrame(time, true));
			texture.flip(true, false);
			return texture;
		
		case PLAYER_RUNNING_RIGHT:
			texture = new TextureRegion(this.playerRunning.getKeyFrame(time, true));
			return texture;
			
		case PLAYER_JUMPING_LEFT:
			texture = new TextureRegion(this.playerJumpingTexture);
			texture.flip(true, false);
			return texture;
			
		case PLAYER_JUMPING_RIGHT:
			texture = new TextureRegion(this.playerJumpingTexture);
			return texture;
			
		case PLAYER_IN_STAIR:
			texture = new TextureRegion(this.playerUpDown.getKeyFrame(time, true));
			return texture;
			
		case PLAYER_DEATH:
			texture = new TextureRegion(this.playerDeadTexture);
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
		case PLAYER_CHARRED:
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
		
		//Player Textures
		this.playerIdleTexture = new TextureRegion(allThingsSheet, 5 * 16,16,16, 16);
		this.playerRunning1Texture = new TextureRegion(allThingsSheet, 7*16, 0, 16, 16);
		this.playerRunning2Texture = new TextureRegion(allThingsSheet, 6 *16, 16, 16, 16);
		this.playerJumpingTexture = new TextureRegion(allThingsSheet, 7 * 16, 16, 16, 16);
		this.playerDeadTexture = new TextureRegion(allThingsSheet, 8 * 16, 0, 16, 16);
		this.playerUpDown1Texture = new TextureRegion(allThingsSheet, 6 * 16, 0, 16, 16);
		this.playerUpDown2Texture = new TextureRegion(allThingsSheet, 2*16, 6 * 16, 16, 16);
		
		this.playerIdle =  new Animation(0.20f,
				this.playerIdleTexture,
				this.playerRunning1Texture);
		
		this.playerIdle.setPlayMode(PlayMode.LOOP);
		
		this.playerRunning = new Animation(0.10f,
				this.playerRunning1Texture,
				this.playerIdleTexture,
				this.playerRunning2Texture
				);
		
		this.playerRunning.setPlayMode(PlayMode.LOOP);
		
		
		this.playerUpDown = new Animation(0.15f,
				this.playerUpDown1Texture,
				this.playerUpDown2Texture);
		this.playerUpDown.setPlayMode(PlayMode.LOOP);
		
		
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
