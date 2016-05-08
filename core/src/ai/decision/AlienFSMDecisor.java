package ai.decision;

import java.util.List;

import ludum.mighty.square.player.AINormalPlayer;
import ludum.mighty.square.player.NormalPlayer;
import ludum.mighty.square.player.Player;
import ludum.mighty.square.world.pathnodes.PathNode;
import ai.world.AIWorld;

import com.badlogic.gdx.math.Vector2;

public class AlienFSMDecisor extends BasicDecisor 
{
	//No team has the flag
	public static int STATE_STATUS_QUO = 0;

	//Enemy team has the flag
	public static int ONLY_ENEMY_ATTACK = 1;

	//Only we have the flag
	public static int ONLY_WE_ATTACK = 2;

	//Both teams have the flag
	public static int TOTAL_MAYHEM = 3;


	public static final double SHOOTING_RANGE = 5;

	/////////////////////////////
	//    State variables
	//    FIXME: Move to a new class
	//
	///////////////////////////
	
	//Current State
	int currentState;
	
	//Time in which the player reached the node
	long firstTimeInNode = 0;
	
	//Closest Enemy instance
	NormalPlayer closestEnemy = null;
	
	//Closest Teammate instance
	NormalPlayer closestTeammate = null;
	
	//Closest Teammate with flag
	NormalPlayer teamMateWithFlag = null;
	
	//Closest enemy with flag
	NormalPlayer enemyWithFlag = null;
	
	//My base position
	Vector2 myBase = null;
	
	//Enemy Base position
	Vector2 otherBase = null;

	//True if enemy team has the flag
	boolean enemyTeamHasFlag = false;
	
	//True if my team has the flag
	boolean myTeamHasFlag = false;
	
	//True if i have the flag
	boolean iHaveTheFlag = false;

	//New state transition (change in state during tick execution)
	boolean stateTransition = false;

	public AlienFSMDecisor( )
	{
		
		//Sets initial state 
		this.currentState = STATE_STATUS_QUO;
	}



	/**
	 * 
	 * Obtains the target node over which pathfinding will be calculated
	 * 
	 * Parameters:
	 * 
	 * @param aiWorld : representation of the world (graph nodes)
	 * @param aiPlayer: current alien player
	 * 
	 * @return the node in the world graph of nodes with the target
	 * (if no change in state occurred and there was a current pathfinding in use
	 * the target node would be the same)
	 * 
	 * 
	 */
	@Override
	public int getTransition(AIWorld aiWorld, AINormalPlayer aiPlayer)
	{
		if (aiPlayer.getSquareTeam() == Player.GREEN_TEAM)
		{
			//Obtains the state/Update state variables
			this.obtainState(aiPlayer.getGreenTeamList(), 
					aiPlayer.getVioletTeamList(), aiPlayer);


		}
		else
		{
			//Obtains the state/Updates state variables
			this.obtainState(aiPlayer.getVioletTeamList(), 
					aiPlayer.getGreenTeamList(), aiPlayer);


		}

		//Check if there was a change in state (someone captured/freed the flag
		this.checkChangeInState();

		//Obtain the next target node
		return this.obtainNextTarget(aiWorld, aiPlayer);
	}

	/**
	 * 
	 * Obtains next target node if function of the current state 
	 * 
	 * @param aiWorld : current world state 
	 * @param aiPlayer : current player
	 * @return next node in state
	 */
	private int obtainNextTarget(AIWorld aiWorld, AINormalPlayer aiPlayer)
	{

		int nextState = -1;

		//If i have the flag, return always to base (the node where the base is located)
		if (this.iHaveTheFlag)
			return this.obtainMyBaseSquare(aiWorld);

		if (this.currentState ==  AlienFSMDecisor.STATE_STATUS_QUO)
		{


			if (aiPlayer.getCurrentPath() != null)
			{ 
				if (!aiPlayer.getCurrentPath().getPredConn().isEmpty())
				{
					//Changing of state only if i have no path and 
					// 	no state transition had happened
					if (!this.stateTransition)
						return -1;
				}
			}

			nextState = new StatePropStatusQuo().getNextState();

		} else if (this.currentState ==  AlienFSMDecisor.ONLY_ENEMY_ATTACK)
		{

			if (aiPlayer.getCurrentPath() != null)
			{ 
				if (!aiPlayer.getCurrentPath().getPredConn().isEmpty())
				{
					if (!this.stateTransition)
						return -1;
				}
			}

			nextState = new StatePropOnlyEnemyAttack().getNextState();
		}
		else if (this.currentState ==  AlienFSMDecisor.ONLY_WE_ATTACK)
		{
			if (aiPlayer.getCurrentPath() != null)
			{ 
				if (!aiPlayer.getCurrentPath().getPredConn().isEmpty())
				{
					if (!this.stateTransition)
						return -1;
				}
			}

			nextState = new StatePropOnlyWeAttack().getNextState();
		}
		else 
		{
			if (aiPlayer.getCurrentPath() != null)
			{ 

				if (!aiPlayer.getCurrentPath().getPredConn().isEmpty())
				{

					if (!this.stateTransition)
						return -1;
				}
			}

			nextState = new StatePropTotalMayhem().getNextState();
		}


		//Obtain the target node in function of the nextState
		if (nextState == StateProp.GOTOOTHERBASE)
		{
			/*System.out.println("TEAM "+ aiPlayer.getSquareTeam() + " " +
		this.obtainOtherBaseSquare(aiWorld));
			 */

			return this.obtainOtherBaseSquare(aiWorld);
		}

		else if (nextState == StateProp.GOTOMYBASE)
			return this.obtainMyBaseSquare(aiWorld);

		else if( nextState == StateProp.GOTORANDOMSQUAREZONE)
			return this.obtainRandomSquareInMyZone(aiWorld, aiPlayer);

		else if (nextState == StateProp.GOTORANDOMSQUARE)
			return this.obtainRandomSquare(aiWorld, aiPlayer);

		else if (nextState == StateProp.GOTOCLOSESTENEMY)
			return this.obtainClosestEnemySquare();

		else if (nextState == StateProp.GOTOCLOSESTENEMYWITHFLAG)
		{
			//			System.out.println("CHASE WHO "+this.enemyWithFlag.getLastSeenNode());

			return this.obtainClosestEnemyWithFlagSquare();
		}
		else if (nextState == StateProp.GOTOCLOSESTTEAMMATE)
			return this.obtainClosestTeamMateSquare();

		else if (nextState == StateProp.GOTOCLOSESTTEAMMATEWITHFLAG)
		{

			return this.obtainClosestTeamMateWithFlagSquare();
		}
		else
		{
			return this.obtainRandomSquare(aiWorld, aiPlayer);
		}

	}

	/**
	 * Obtains the base node id in the path of nodes
	 * 
	 * @param aiWorld : current world state
	 * @return the id of the enemy base node
	 */
	public int obtainOtherBaseSquare(AIWorld aiWorld)
	{
		if (this.otherBase != null)
		{
			int baseNode = aiWorld.obtainCurrentNode(this.otherBase).getIdNode();

			return baseNode;
		}

		return -1;
	}

	/**
	 * 
	 * Obtains the node of the players base
	 * 
	 * @param aiWorld current world state
	 * @return the node id of the player base or -1 if no base was
	 * 	specified
	 */
	public int obtainMyBaseSquare(AIWorld aiWorld)
	{
		if (this.myBase != null)
		{
			//System.out.println("My Base "+ this.myBase.x+ " "+ this.myBase.y );

			int baseNode = aiWorld.obtainCurrentNode(this.myBase).getIdNode();

			return baseNode;
		}

		return -1;
	}

	public int obtainRandomSquareInMyZone(AIWorld aiWorld, AINormalPlayer aiPlayer)
	{
		if (aiPlayer.getPosition() != null)
		{
			int zone = aiWorld.obtainCurrentZone(aiPlayer.getPosition());

			if (zone > -1)
			{
				List<PathNode> pathsInZone = 
						aiWorld.getZonePathMap().get(zone);

				int randomPath =  (int) ( Math.floor(Math.random() * pathsInZone.size() ) );

				return pathsInZone.get(randomPath).getIdNode();
			}
		}

		return -1;
	}

	public int obtainRandomSquare(AIWorld aiWorld, AINormalPlayer aiPlayer)
	{
		if (aiPlayer.getPosition() != null)
		{
			int randomPath = (int) (Math.floor(Math.random() * aiWorld.getPathList().size()));

			return aiWorld.getPathList().get(randomPath).getIdNode();

		}

		return -1;
	}


	public int obtainClosestEnemySquare()
	{
		if (this.closestEnemy != null)
		{
			if (this.closestEnemy.getLastSeenNode() != null)

				return this.closestEnemy.getLastSeenNode().getIdNode();

		} 
		return -1;
	}

	public int obtainClosestEnemyWithFlagSquare()
	{
		if (this.enemyWithFlag != null)
		{
			if (this.enemyWithFlag.getLastSeenNode() != null)

				return this.enemyWithFlag.getLastSeenNode().getIdNode();

		} 
		return -1;
	}

	public int obtainClosestTeamMateSquare()
	{
		if (this.closestTeammate != null)
		{
			if (this.closestTeammate.getLastSeenNode() != null)

				return this.closestTeammate.getLastSeenNode().getIdNode();

		} 
		return -1;
	}

	public int obtainClosestTeamMateWithFlagSquare()
	{
		if (this.teamMateWithFlag != null)
		{
			if (this.teamMateWithFlag.getLastSeenNode() != null)

				return this.teamMateWithFlag.getLastSeenNode().getIdNode();

		} 
		return -1;
	}


	/**
	 * 
	 * Update the state of the player
	 * 
	 * @param myTeamList : teammate list
	 * @param enemyTeamList : enemy list
	 * @param aiPlayer : current player
	 */
	private void obtainState(List<Player> myTeamList, 
			List<Player> enemyTeamList, AINormalPlayer aiPlayer)
	{
		this.iHaveTheFlag = aiPlayer.isHasFlag();

		//this.closestTeammate = null;
		//this.teamMateWithFlag = null;

		this.enemyTeamHasFlag = false;
		this.myTeamHasFlag = false;

		for (Player inListPlayer : myTeamList )
		{


			if ((inListPlayer instanceof NormalPlayer ) ||
					(inListPlayer instanceof AINormalPlayer))
			{

				NormalPlayer player = (NormalPlayer) inListPlayer;	

				if (player.isHasFlag())
				{
					this.myTeamHasFlag = true;

					if (this.teamMateWithFlag == null)
					{
						this.teamMateWithFlag = player;
					}
					else
					{
						if (this.isTeammateCloser(player.getPosition(), 
								this.teamMateWithFlag.getPosition(), 
								aiPlayer.getPosition()))
						{
							this.teamMateWithFlag = player;
						}
					}
				}

				//Check if the player is the closest teammate
				if (this.closestTeammate == null)
					this.closestTeammate = player;
				else
				{
					if (this.isTeammateCloser(player.getPosition(), 
							this.closestTeammate.getPosition(), 
							aiPlayer.getPosition()))
					{
						this.closestTeammate = player;
					}
				}
			}

		}

		//Check enemy information

		//this.enemyWithFlag = null;
		//this.closestEnemy = null;


		for (Player inListPlayer : enemyTeamList )
		{

			if ((inListPlayer instanceof NormalPlayer ) ||
					(inListPlayer instanceof AINormalPlayer))
			{

				NormalPlayer player = (NormalPlayer) inListPlayer;		

				if (player.isHasFlag())
				{
					this.enemyTeamHasFlag = true;

					if (this.enemyWithFlag == null)
					{
						this.enemyWithFlag = player;

						//System.out.println(this.enemyWithFlag.getLastSeenNode().getIdNode());
					}
					else
					{
						if (this.isTeammateCloser(player.getPosition(), 
								this.enemyWithFlag.getPosition(), 
								aiPlayer.getPosition()))
						{
							this.enemyWithFlag = player;
						}
					}
				}


				//Check if the player is the closest enemy
				if (this.closestEnemy == null)
					this.closestEnemy = player;
				else
				{
					if (this.isTeammateCloser(player.getPosition(), 
							this.closestEnemy.getPosition(), 
							aiPlayer.getPosition()))
					{
						this.closestEnemy = player;
					}
				}

			}
		}	
	}

	/**
	 * 
	 * Changes the macro state (FSM State)
	 * 
	 * It flags if the transition of state occurred during this tick
	 * 
	 */
	private void checkChangeInState() 
	{

		this.stateTransition = false;
		if ((!this.enemyTeamHasFlag) && (!this.myTeamHasFlag))
		{
			if (this.currentState != AlienFSMDecisor.STATE_STATUS_QUO)
				this.stateTransition = true;
			this.currentState = AlienFSMDecisor.STATE_STATUS_QUO;
		}
		else if (this.enemyTeamHasFlag && !this.myTeamHasFlag)
		{
			if (this.currentState != AlienFSMDecisor.ONLY_ENEMY_ATTACK)	
				this.stateTransition = true;
			this.currentState = AlienFSMDecisor.ONLY_ENEMY_ATTACK;

		}
		else if (!this.enemyTeamHasFlag && this.myTeamHasFlag)
		{
			if (this.currentState != AlienFSMDecisor.ONLY_WE_ATTACK)
				this.stateTransition = true;
			this.currentState = AlienFSMDecisor.ONLY_WE_ATTACK;
		}
		else if (this.enemyTeamHasFlag && this.myTeamHasFlag)
		{
			if (this.currentState != AlienFSMDecisor.TOTAL_MAYHEM)
				this.stateTransition = true;
			this.currentState = AlienFSMDecisor.TOTAL_MAYHEM;
		}


	}


	private boolean isTeammateCloser(Vector2 position, Vector2 prevPosition, Vector2 myPosition)
	{
		if ((this.euclideanDistance(position, myPosition)) < 
				(this.euclideanDistance(prevPosition, myPosition)))
		{
			return true;
		}
		else
			return false;

	}

	private double euclideanDistance(Vector2 one, Vector2 other)
	{
		return 0.5 * Math.pow(one.x - other.x, 2 ) + Math.pow(other.y - other.y, 2);
	}


	public boolean shouldIshoot(AINormalPlayer aiPlayer)
	{
		if ((this.closestEnemy != null) && (aiPlayer.getPosition() != null))
		{
			if (this.closestEnemy.getPosition() != null)
			{
				if (Math.abs(aiPlayer.getPosition().x - 
						closestEnemy.getPosition().x) < AlienFSMDecisor.SHOOTING_RANGE)
				{
					return true;
				}
			}

		}


		return false;
	}


	public Vector2 getMyBase() {
		return myBase;
	}


	public void setMyBase(Vector2 myBase) {
		this.myBase = myBase;
	}


	public Vector2 getOtherBase() {
		return otherBase;
	}


	public void setOtherBase(Vector2 otherBase) {
		this.otherBase = otherBase;
	}




}
