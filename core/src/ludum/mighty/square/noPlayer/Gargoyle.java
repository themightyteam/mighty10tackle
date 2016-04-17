package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

public class Gargoyle extends NoPlayer {

	public Gargoyle(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_GARGOYLE;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		//Doing nothing (this enemy cannot be killed)
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
		
		//Doing nothing (this enemy cannot be killed)
		
	}

}
