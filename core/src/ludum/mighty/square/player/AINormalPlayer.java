package ludum.mighty.square.player;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import ai.decision.BasicDecissor;
import ai.movement.steering.BasicSteering;
import ai.pathfinding.AStar;
import ai.pathfinding.commons.Connection2D;
import ai.pathfinding.commons.PathfindingGraph;
import ai.pathfinding.commons.PredictedPath;
import ai.pathfinding.heu.EstimatedCostHeuristic;
import ai.pathfinding.heu.EuclideanDistanceHeuristic;
import ai.world.AIWorld;
import ludum.mighty.square.noPlayer.Bullet;

public class AINormalPlayer extends NormalPlayer 
{

	BasicDecissor decisor = new BasicDecissor();
	BasicSteering steering = new BasicSteering();


	AStar pathFinder;
	PredictedPath currentPath;

	int idTargetNode;

	Vector2 currentTarget = null;
	boolean targetIsJump = false;

	EstimatedCostHeuristic heuristic;

	public AINormalPlayer(int type, int squareTeam, Vector2 initPosition,
			AIWorld aiWorld) 
	{
		super(type, squareTeam, initPosition, aiWorld);

		//TODO Init AI here

		this.currentPath = null;

		this.pathFinder = new AStar();

		this.heuristic = 
				new EuclideanDistanceHeuristic( this.aiWorld.getNodeList());


		this.obtainPath();

		this.deleteNodesFromTarget();
	}


	private void obtainPath()
	{
		int newTransition = this.decisor.getTransition(this.aiWorld, this.currentPath);

		if ((newTransition != -1) && this.lastSeenNode != null )
		{
			//Calculate the pathfinding
			this.currentPath = this.pathFinder.pathfindAStar( new PathfindingGraph( this.aiWorld.getGraphMap()), 
					this.lastSeenNode.getIdNode(), newTransition, heuristic);
			if (!this.currentPath.getPredConn().isEmpty())
				//Setting the target
			{
				this.currentTarget = new Vector2(
						(float) this.aiWorld.getNodeList().get(this.currentPath.getPredConn().get(0).getSinkNodeId()).getX(),
						(float) this.aiWorld.getNodeList().get(this.currentPath.getPredConn().get(0).getSinkNodeId()).getY());

				this.targetIsJump = ((Connection2D) this.currentPath.getPredConn().get(0)).isJump();
			}
		}
	}

	private void deleteNodesFromTarget()
	{



		if ((this.currentPath != null) && this.lastSeenNode != null)

			if (!this.currentPath.getPredConn().isEmpty())
			{
			

				if (this.currentPath.getPredConn().get(0).getSinkNodeId() != 
						this.lastSeenNode.getIdNode())
				{
					if (this.currentPath.getPredConn().get(0).getSourceNodeId() != 
							this.lastSeenNode.getIdNode() )
					{
						//The path is no more suitable, delete!

						this.currentPath.getPredConn().clear();
					}
				}
				else
				{
					//Remove because the next step node was reached
					this.currentPath.getPredConn().remove(0);

					if (!this.currentPath.getPredConn().isEmpty())
					{
						//Reset the target path
						this.currentTarget = new Vector2(
								(float) this.aiWorld.getNodeList().get(this.currentPath.getPredConn().get(0).getSinkNodeId()).getX(),
								(float) this.aiWorld.getNodeList().get(this.currentPath.getPredConn().get(0).getSinkNodeId()).getY());

						this.targetIsJump = ((Connection2D) this.currentPath.getPredConn().get(0)).isJump();
					}
				}
			}

	

	}

	@Override
	public void setPosition(Vector2 position) 
	{
		super.setPosition(position);


		this.obtainPath();

		this.deleteNodesFromTarget();
		if (this.currentPath != null)
			if (!this.currentPath.getPredConn().isEmpty())
				System.out.println("Next Node In Path "+ this.currentPath.getPredConn()
						.get(0).getSinkNodeId() + " CURR "+ this.lastSeenNode.getIdNode());
	}

	@Override
	public void updatePlayerPosition(Body playerBody, long timeEpoch, boolean upKeyPressed, boolean downKeyPressed,
			boolean leftKeyPressed, boolean rightKeyPressed, boolean fireKeyPressed, ArrayList<Bullet> bulletsList) {

		// H FIX Set the current position
		// Update position
		Vector2 newPos = playerBody.getPosition();
		this.setPosition(new Vector2(newPos.x, newPos.y));

		//Picking the node 
		if (this.currentTarget != null)
		{
			Vector2 newSteering = this.steering.updateSteering(this.getPosition(), this.currentTarget, this.impulse);

			if ( newSteering.x < 0 )
			{
				leftKeyPressed = true;
			}
			else if (newSteering.x > 0)
				rightKeyPressed = true;

			if ( ( newSteering.y < 0) && this.targetIsJump ) 
			{
				upKeyPressed = true;
			}
			else if ( newSteering.y <= 0)
			{
				upKeyPressed = false;
				downKeyPressed = true;
			}

			if (newSteering.y > 0)
			{
				upKeyPressed = true;
			}


			//Check if we must block the y key
			if (this.jumpingSinceEpoch != 0)
				if ((timeEpoch - this.jumpingSinceEpoch > 300))
				{
					upKeyPressed = false;
				}
			
			if (Math.abs(newSteering.x/newSteering.y) < 0.02)
			{
				//Cancel the x
				leftKeyPressed = false;
				rightKeyPressed = false;
			}

			super.updatePlayerPosition(playerBody,
					timeEpoch,
					upKeyPressed, 
					downKeyPressed,
					leftKeyPressed, 
					rightKeyPressed,
 fireKeyPressed, bulletsList);
		}
	}
}
