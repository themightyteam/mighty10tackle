package ai.decision;

import ludum.mighty.square.player.AINormalPlayer;
import ai.pathfinding.commons.PredictedPath;
import ai.world.AIWorld;

import com.badlogic.gdx.math.Vector2;

public class BasicDecisor 
{
	
	

	

	//Returns a random target if none available
	
	public int obtainNextPathNode(AIWorld aiWorld)
	{
		int nextNode = (int) Math.floor(Math.random() * aiWorld.getNodeList().size());
		
		if (aiWorld.getNodeList().containsKey(nextNode))
		{
			return nextNode;
			
		}
		else
			return -1;
	}
	
	
	public int getTransition(AIWorld aiWorld, PredictedPath predPath)
	{
		if (predPath == null)
		{
			return this.obtainNextPathNode(aiWorld);
		}
		else
		{
			if (predPath.getPredConn().isEmpty())
			{
				return this.obtainNextPathNode(aiWorld);
			}
		}
		
		return -1;
	}
	
}
