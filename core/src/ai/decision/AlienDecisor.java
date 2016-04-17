package ai.decision;

import ludum.mighty.square.player.AINormalPlayer;
import ai.world.AIWorld;

import com.badlogic.gdx.math.Vector2;

public class AlienDecisor extends BasicDecisor 
{
	
	
	int lastNodeSeen = -1;
	long firstTimeInNode = 0;
	Vector2 closesEnemy;
	Vector2 enemyWithFlag;
	Vector2 myBase;
	Vector2 otherBase;

	
	
	public Vector2 nextTarget(AIWorld aiWorld, AINormalPlayer aiPlayer)
	{
		//TODO
		return null;
	}
	
	

}
