package ludum.mighty.square.pattern;

import java.util.ArrayList;

public class ObjectPattern {

	//total duration of the pattern (in Tics/ms)
	long duration;
	
	ArrayList<PatternStep> patternList;
	
	public ObjectPattern(long duration, ArrayList<PatternStep> patternList)
	{
		this.duration = duration;
		this.patternList = patternList;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public ArrayList<PatternStep> getPatternList() {
		return patternList;
	}

	public void setPatternList(ArrayList<PatternStep> patternList) {
		this.patternList = patternList;
	}
	
	
}
