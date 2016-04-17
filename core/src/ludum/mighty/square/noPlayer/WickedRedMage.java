package ludum.mighty.square.noPlayer;

import java.text.MessageFormat;
import java.util.ArrayList;

public class WickedRedMage extends NoPlayer {

	public WickedRedMage(int id, int dependentId, long duration,
			ArrayList<String> otherPatternList) {
		super(id, dependentId, duration, otherPatternList);
		// TODO Auto-generated constructor stub
		
		this.noPlayerType = NoPlayer.TYPE_WICKEDREDMAGE;
	}

	@Override
	public void nowIsDead(long newTime) {
		// TODO Auto-generated method stub
		
		/*
		String deathPattern = MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7}", 
				new Object [] {
				Long.toString(newTime),
				Long.toString(newTime + 1750),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Integer.toString(1),
				Integer.toString(93)
				
		} );*/
		
		String deathPattern = Long.toString(newTime)+" "+
				Long.toString(newTime + 1750)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Integer.toString(1)+" "+
				Integer.toString(93);
		
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(deathPattern);
		stepList.add(Long.toString(newTime + 1750)+" "+Long.toString(Long.MAX_VALUE)+" 0 0 0 0 1 92");
		
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
	}

	@Override
	public void nowIsCharred(long newTime) {
		// TODO Auto-generated method stub
		
		/*String deathPattern = MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7}", 
				new Object [] {
				Long.toString(newTime),
				Long.toString(newTime + 1750),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Float.toString(this.currentX),
				Float.toString(this.currentY),
				Integer.toString(1),
				Integer.toString(93),
				Long.toString(Long.MAX_VALUE)
				
		} );*/
		
		String deathPattern = Long.toString(newTime)+" "+
				Long.toString(newTime + 1750)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Float.toString(this.currentX)+" "+
				Float.toString(this.currentY)+" "+
				Integer.toString(1)+" "+
				Integer.toString(92);
		
		ArrayList<String> stepList = new ArrayList<String>();
		stepList.add(deathPattern);
		stepList.add(Long.toString(newTime + 1750)+" "+Long.toString(Long.MAX_VALUE)+" 0 0 0 0 1 92");
		
		
		this.updatePatternSteps(Long.MAX_VALUE, stepList);
		
	}

}
