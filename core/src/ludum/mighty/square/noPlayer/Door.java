package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

public class Door extends NoPlayer {

	public Door(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		
		this.noPlayerType = NoPlayer.TYPE_DOOR;
	}

	@Override
	public void nowIsDead(long newTime) {

		/*
		 * //open the door String deathPattern = MessageFormat.format(
		 * "{0} {1} {2} {3} {4} {5} {6} {7}", new Object [] {
		 * Long.toString(newTime), Long.toString(Long.MAX_VALUE),
		 * Float.toString(this.currentX), Float.toString(this.currentY),
		 * Float.toString(this.currentX), Float.toString(this.currentY),
		 * Integer.toString(1), Integer.toString(58)
		 * 
		 * } );
		 * 
		 */

		String deathPattern = Long.toString(newTime) + " " + Long.toString(Long.MAX_VALUE) + " "
				+ Float.toString(this.currentX) + " " + Float.toString(this.currentY) + " "
				+ Float.toString(this.currentX) + " " + Float.toString(this.currentY) + " " + 
				Integer.toString(1) + " "+ Integer.toString(58);

				
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(deathPattern);
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
		
	}

}
