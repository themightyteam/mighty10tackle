package ai.decision;

import ai.pathfinding.commons.PredictedPath;
import ai.world.AIWorld;

public class BasicDecissor 
{

	//Returns a random target if none available
	
	public int obtainNextTarget(AIWorld aiWorld)
	{
		int nextNode = (int) Math.floor(Math.random() * aiWorld.getNodeList().size());
		
		if (aiWorld.getNodeList().containsKey(nextNode))
		{
			//return nextNode;
			return 177;
		}
		else
			return -1;
	}
	
	
	public int getTransition(AIWorld aiWorld, PredictedPath predPath)
	{
		if (predPath == null)
		{
			return this.obtainNextTarget(aiWorld);
		}
		else
		{
			if (predPath.getPredConn().isEmpty())
			{
				return this.obtainNextTarget(aiWorld);
			}
		}
		
		return -1;
	}
	
}
