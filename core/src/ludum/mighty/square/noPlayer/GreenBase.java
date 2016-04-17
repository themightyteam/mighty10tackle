package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

/**
 * 
 * @author The Mighty Team
 * 
 *         A green base, where the green team has to bring the violet flag.
 *
 */
public class GreenBase extends NoPlayer {


	public GreenBase(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_GREEN_BASE;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		ArrayList<String> stepList = new ArrayList<String>();
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
	}

}
