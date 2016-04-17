package ludum.mighty.square.player;

public class RecordedStep {

	public long timestamp;
	public float x, y;
	public boolean fire;


	public RecordedStep(long timestamp, float x, float y, boolean fire) {
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
		this.fire = fire;
	}
}
