package ludum.mighty.square.noPlayer;

import java.text.MessageFormat;
import java.util.ArrayList;

public class BreakableBlock extends NoPlayer {

	private boolean isTouched;

	public BreakableBlock(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_BREAKABLEBLOCK;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		/*
		String deathPattern = MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7}", 
				new Object [] {
				Long.toString(newTime),
				Long.toString(newTime + 750),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Float.toString(this.currentX),
				Float.toString(0),
				Integer.toString(1),
				Integer.toString(57)
				
		} );
		*/
		String deathPattern = Long.toString(newTime)+" "+
				Long.toString(newTime + 750)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(0)+" "+
				Integer.toString(1)+" "+
				Integer.toString(57);
		
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(deathPattern);
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		/*
		String deathPattern = MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7}", 
				new Object [] {
				Long.toString(newTime),
				Long.toString(newTime + 750),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Float.toString(this.currentX),
				Float.toString(0),
				Integer.toString(1),
				Integer.toString(57)
				
		} );
		*/
		String deathPattern = Long.toString(newTime)+" "+
				Long.toString(newTime + 750)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(0)+" "+
				Integer.toString(1)+" "+
				Integer.toString(57);
		
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(deathPattern);
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
	}

	public boolean isTouched() {
		return isTouched;
	}

	public void setTouched(boolean isTouched) {
		this.isTouched = isTouched;
	}

}
