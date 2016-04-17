package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

public class Beer extends NoPlayer {

	public Beer(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_BEER;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(Long.toString(newTime)+" "+Long.toString(Long.MAX_VALUE)+" 0 0 0 0 1 43");
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
	}

}
