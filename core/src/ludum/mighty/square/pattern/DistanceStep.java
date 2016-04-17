package ludum.mighty.square.pattern;

/**
 * Container class
 * 
 * @author hector
 *
 */
public class DistanceStep {

	
	float x;
	float y;
	
	public DistanceStep(float x, float y)
	{
		this.x = x;
		this.y = y;
		
	}

	//Getters and setters
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
	
	
}
