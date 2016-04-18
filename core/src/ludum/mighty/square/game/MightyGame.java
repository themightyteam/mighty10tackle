package ludum.mighty.square.game;

import com.badlogic.gdx.Game;

import ludum.mighty.square.screen.IntroScreen;

public class MightyGame extends Game {


	int highScore = 0;
	int lastScore = 0;
	
	@Override
	public void create() {

		//FIXME: Set intro screen
		setScreen(new IntroScreen(this));
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

