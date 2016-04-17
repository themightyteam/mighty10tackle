package ludum.mighty.square.game;

import com.badlogic.gdx.Game;

import ludum.mighty.square.screen.ScreenLevel1;

public class MightyGame extends Game {


	int highScore = 0;
	int lastScore = 0;
	
	private final int startLevel = 1;
	@Override
	public void create() {

		//FIXME: Set intro screen
		setScreen(new ScreenLevel1(this, startLevel, null));
		//setScreen(new ScoreScreen(this));	
	}
	
	public void updateHiScore()
	{
		if (this.lastScore > this.highScore)
		{
			this.highScore = this.lastScore;
		}
	}

	
	
	//Getters and setters
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getLastScore() {
		return lastScore;
	}

	public void setLastScore(int lastScore) {
		this.lastScore = lastScore;
	}
	
	

	
	
}

