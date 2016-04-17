package ludum.mighty.square.pattern;

public class PatternStep {

	public static final int LINEAR_FUNCTION = 1;
	public static final int QUADRATIC_FUNCTION = 2;

	long startTime;
	long endTime;
	float origPosX;
	float origPosY;
	float targetPosX;
	float targetPosY;
	int function;
	int animation;

	public PatternStep(
			long startTime, 
			long endTime,
			float origPosX,
			float origPosY,
			float targetPosX,
			float targetPosY,
			int function,
			int animation)
	{

		this.startTime = startTime;
		this.endTime = endTime;
		this.origPosX = origPosX;
		this.origPosY= origPosY;
		this.targetPosX = targetPosX;
		this.targetPosY = targetPosY;
		this.function = function;
		this.animation = animation;
	}

	//Getters and setters
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public float getOrigPosX() {
		return origPosX;
	}
	public void setOrigPosX(float origPosX) {
		this.origPosX = origPosX;
	}
	public float getOrigPosY() {
		return origPosY;
	}
	public void setOrigPosY(float origPosY) {
		this.origPosY = origPosY;
	}
	public float getTargetPosX() {
		return targetPosX;
	}
	public void setTargetPosX(float targetPosX) {
		this.targetPosX = targetPosX;
	}
	public float getTargetPosY() {
		return targetPosY;
	}
	public void setTargetPosY(float targetPosY) {
		this.targetPosY = targetPosY;
	}
	public int getFunction() {
		return function;
	}
	public void setFunction(int function) {
		this.function = function;
	}
	public int getAnimation() {
		return animation;
	}
	public void setAnimation(int animation) {
		this.animation = animation;
	}


}
