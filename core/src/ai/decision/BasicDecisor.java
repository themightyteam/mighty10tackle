package ai.decision;

import ludum.mighty.square.player.AINormalPlayer;
import ai.pathfinding.commons.PredictedPath;
import ai.world.AIWorld;

import com.badlogic.gdx.math.Vector2;

public class BasicDecisor 
{
	
	AINormalPlayer aiPlayer;
	
	public BasicDecisor(AINormalPlayer aiNormalPlayer)
	{
		this.aiPlayer = aiNormalPlayer;
	}
	

	//Returns a random target if none available
	private int obtainNextPathNode()
	{
		int nextNode = (int) Math.floor(Math.random() * this.aiPlayer.getAiWorld()
				.getNodeList().size());
		
		if (this.aiPlayer.getAiWorld().getNodeList().containsKey(nextNode))
		{
			return nextNode;
			
		}
		else
			return -1;
	}
	
	
	public int getTransition()
	{
		PredictedPath predPath = this.aiPlayer.getCurrentPath();
		
		if (predPath == null)
		{
			return this.obtainNextPathNode();
		}
		else
		{
			if (predPath.getPredConn().isEmpty())
			{
				return this.obtainNextPathNode();
			}
		}
		
		return -1;
	}
	
}
