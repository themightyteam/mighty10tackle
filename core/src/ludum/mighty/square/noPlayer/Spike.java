package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

public class Spike extends NoPlayer {

	public Spike(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = TYPE_SPIKE;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
	}

}
