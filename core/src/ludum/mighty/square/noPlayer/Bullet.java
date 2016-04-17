package ludum.mighty.square.noPlayer;

import com.badlogic.gdx.physics.box2d.Body;

public class Bullet {

	boolean removeThis;
	Body myBody; // Box2D body of this bullet

	public Body getMyBody() {
		return myBody;
	}

	public void setMyBody(Body myBody) {
		this.myBody = myBody;
	}

	public Bullet() {
		this.removeThis = false;
	}

	public void declareRemovable() {
		removeThis = true;
	}

	public boolean isRemovable() {
		return this.removeThis;
	}
}