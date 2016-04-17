package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

public class WickedBullet extends NoPlayer {

	public WickedBullet(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_WICKEDBULLET;
		
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		//Simply disappear (no step)
		
		ArrayList<String> stepList = new ArrayList<String>();
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
		//Simply disappear (no step)
		
		ArrayList<String> stepList = new ArrayList<String>();
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
	}

}
