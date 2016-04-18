package ludum.mighty.square.assets;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundAssets 
{
	Random generator = new Random();


	public static final float LOW_SOUND = (float) 0.2;
	public static final float SOUND_RANGE = (float) 10;

	Music themeSong;
	Sound deathSound;
	Sound jumpSound;
	Sound spawnSound;
	Sound shotSound;
	Sound flagCatchSound;
	Sound flagInBase;
	Sound randomChideSound0;
	Sound randomChideSound1;
	Sound randomChideSound2;
	Sound randomChideSound3;
	Sound randomChideSound4;
	Sound randomChideSound5;
	Sound randomChideSound6;
	Sound randomChideSound7;
	Sound randomChideSound8;
	Sound randomChideSound9;
	Sound randomChideSound10;
	Sound randomChideSound11;
	Sound randomChideSound12;
	Sound randomChideSound13;
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


		this.randomChideSound0 = Gdx.audio.newSound(Gdx.files.internal("sound/strongest_square.wav"));				
		this.randomChideSound1 = Gdx.audio.newSound(Gdx.files.internal("sound/hasta_la_vista.wav"));
		this.randomChideSound2 = Gdx.audio.newSound(Gdx.files.internal("sound/kippee_ya_kai_2.wav"));
		this.randomChideSound3 = Gdx.audio.newSound(Gdx.files.internal("sound/all_your_flag.wav"));
		this.randomChideSound4 = Gdx.audio.newSound(Gdx.files.internal("sound/dead_squares.wav"));
		this.randomChideSound5 = Gdx.audio.newSound(Gdx.files.internal("sound/en_taro_square_2.wav"));
		this.randomChideSound6 = Gdx.audio.newSound(Gdx.files.internal("sound/i_am_your_square_2.wav"));
		this.randomChideSound7 = Gdx.audio.newSound(Gdx.files.internal("sound/james_square.wav"));
		this.randomChideSound8 = Gdx.audio.newSound(Gdx.files.internal("sound/my_square.wav"));
		this.randomChideSound9 = Gdx.audio.newSound(Gdx.files.internal("sound/square_base_phone.wav"));
		this.randomChideSound10 = Gdx.audio.newSound(Gdx.files.internal("sound/three_headed_2.wav"));
		this.randomChideSound11 = Gdx.audio.newSound(Gdx.files.internal("sound/more_squares.wav"));
		this.randomChideSound12 = Gdx.audio.newSound(Gdx.files.internal("sound/run_square.wav"));
		this.randomChideSound13 = Gdx.audio.newSound(Gdx.files.internal("sound/too_mighty.wav"));










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
		int nextSound = this.generator.nextInt(14);

		if (nextSound == 0)
			this.randomChideSound0.play();
		else if (nextSound == 1)
			this.randomChideSound1.play();
		else if (nextSound == 2)
			this.randomChideSound2.play();
		else if (nextSound == 3)
			this.randomChideSound3.play();
		else if (nextSound == 4)
			this.randomChideSound4.play();
		else if (nextSound == 5)
			this.randomChideSound5.play();
		else if (nextSound == 6)
			this.randomChideSound6.play();
		else if (nextSound == 7)
			this.randomChideSound7.play();
		else if (nextSound == 8)
			this.randomChideSound8.play();
		else if (nextSound == 9)
			this.randomChideSound9.play();
		else if (nextSound == 10)
			this.randomChideSound10.play();
		else if (nextSound == 11)
			this.randomChideSound11.play();
		else if (nextSound == 12)
			this.randomChideSound12.play();
		else if (nextSound == 13)
			this.randomChideSound13.play();
		else
			this.randomChideSound0.play();
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


		this.randomChideSound0.dispose();
		this.randomChideSound1.dispose();
		this.randomChideSound2.dispose();
		this.randomChideSound3.dispose();
		this.randomChideSound4.dispose();
		this.randomChideSound5.dispose();
		this.randomChideSound6.dispose();
		this.randomChideSound7.dispose();
		this.randomChideSound8.dispose();
		this.randomChideSound9.dispose();
		this.randomChideSound10.dispose();
		this.randomChideSound11.dispose();
		this.randomChideSound12.dispose();
		this.randomChideSound13.dispose();
		this.victorySound.dispose();

		this.loseSound.dispose();

	}
}
