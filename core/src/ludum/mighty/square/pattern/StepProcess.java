package ludum.mighty.square.pattern;

public class StepProcess {

	public static DistanceStep processStep(PatternStep step, long time)
	{
		DistanceStep newStep; 
		
		if (step.getFunction() == PatternStep.LINEAR_FUNCTION )
		{
			//TODO
			float targetX = (step.getTargetPosX() - step.getOrigPosX()) * 
					(time - step.getStartTime())/(step.getEndTime() - step.getStartTime()) 
					+ step.getOrigPosX();
			
			float targetY = (step.getTargetPosY() - step.getOrigPosY()) * 
					( time - step.getStartTime())/(step.getEndTime() - step.getStartTime())
					+ step.getOrigPosY();
			
			return new DistanceStep(targetX, targetY);
		}
		else if (step.getFunction() == PatternStep.QUADRATIC_FUNCTION )
		{
			float targetX = (step.getTargetPosX() - step.getOrigPosX()) * 
					(time - step.getStartTime())* (time- step.getStartTime())/((step.getEndTime() - step.getStartTime())
							* (step.getEndTime() - step.getStartTime()))
					+ step.getOrigPosX();
			
			float targetY = (step.getTargetPosY() - step.getOrigPosY()) * 
					(time - step.getStartTime())* (time- step.getStartTime())/((step.getEndTime() - step.getStartTime())
							* (step.getEndTime() - step.getStartTime()))
					+ step.getOrigPosY();
			
			return new DistanceStep(targetX, targetY);
		
		}
		
		
		
		return null;
	}
	
}
