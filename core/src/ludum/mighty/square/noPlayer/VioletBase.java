package ludum.mighty.square.noPlayer;

import java.util.ArrayList;

/**
 * 
 * @author The Mighty Team
 * 
 *         A violet base, where the violet team has to bring the green flag.
 *
 */
public class VioletBase extends NoPlayer {

	private float x, y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public VioletBase(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_VIOLET_BASE;
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
