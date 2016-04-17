package ludum.mighty.square.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundAssets 
{
	
	public static final float LOW_SOUND = (float) 0.2;
	public static final float SOUND_RANGE = (float) 10;
	
	Music themeSong;
	Sound deathSound;
	Sound jumpSound;
	Sound spawnSound;
	Sound shotSound;
	Sound flagCatchSound;
	Sound flagInBase;
	Sound randomChideSound1;
	Sound randomChideSound2;
	Sound victorySound;
	Sound loseSound;
	
	public SoundAssets()
	{
	
		this.themeSong = Gdx.audio.newMusic(Gdx.files.internal("sound/theme_1.mp3"));
		
		this.deathSound = Gdx.audio.newSound(Gdx.files.internal("sound/death_1.wav"));
	
		
		this.jumpSound = Gdx.audio.newSound(Gdx.files.internal("sound/jump_1.wav"));
		
		this.spawnSound = Gdx.audio.newSound(Gdx.files.internal("sound/spawn_1.wav"));
		
		this.shotSound = Gdx.audio.newSound(Gdx.files.internal("sound/shot_1.wav"));
		
		this.flagCatchSound = Gdx.audio.newSound(Gdx.files.internal("sound/flag_1.wav"));
		
		this.flagInBase = Gdx.audio.newSound(Gdx.files.internal("sound/goal_1.wav"));
		
		
		this.randomChideSound1 = Gdx.audio.newSound(Gdx.files.internal("sound/hasta_la_vista.wav"));
		
		this.randomChideSound2 = Gdx.audio.newSound(Gdx.files.internal("sound/kippee_yi_kay.wav"));
		
		this.victorySound = Gdx.audio.newSound(Gdx.files.internal("sound/you_win.wav"));

		this.loseSound = Gdx.audio.newSound(Gdx.files.internal("sound/you_lose.wav"));
		
		
	}
	
	
	public void playTheme()
	{
		this.themeSong.play();
		this.themeSong.setLooping(true);
	}

	public void playDeath()
	{
		this.deathSound.play((float) LOW_SOUND);
	}
	
	
	public void playJump()
	{
		this.jumpSound.play((float) LOW_SOUND);
	}
	
	public void playSpawn()
	{
		this.spawnSound.play((float) LOW_SOUND);
	}
	
	public void playShot()
	{
		this.shotSound.play((float) LOW_SOUND);
	}
	
	public void playFlagCatch()
	{
		this.flagCatchSound.play();	
	}	
	
	public void playFlagInBase()
	{
		this.flagInBase.play((float) LOW_SOUND);
	}
	
	public void playChideSound()
	{
		double chideProb = Math.random();
		
		if (chideProb < 0.5)
		{
			this.randomChideSound1.play();
		}
		else 
			this.randomChideSound2.play();
	}
	
	public void playVictorySound()
	{
		this.victorySound.play();
	}
	
	public void playLoseSound()
	{
		this.loseSound.play();
	}
	
	public void disposeObjects()
	{
		this.themeSong.stop();
		
		this.themeSong.dispose();
		this.deathSound.dispose();
		
		this.jumpSound.dispose();
		
		this.spawnSound.dispose(); 
		this.shotSound.dispose();
		
		this.flagCatchSound.dispose();
		
		this.flagInBase.dispose();
		
		this.randomChideSound1.dispose();
		
		this.randomChideSound2.dispose();
		
		this.victorySound.dispose();
		
		this.loseSound.dispose();
		
	}
}
