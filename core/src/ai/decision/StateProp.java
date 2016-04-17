package ai.decision;


public class StateProp 
{
	
	public static final int GOTOOTHERBASE = 0;
	public static final int GOTOMYBASE = 1;
	public static final int GOTORANDOMSQUAREZONE = 2;
	public static final int GOTORANDOMSQUARE = 3;
	public static final int GOTOCLOSESTENEMY = 4;
	public static final int GOTOCLOSESTENEMYWITHFLAG = 5;
	public static final int GOTOCLOSESTTEAMMATE = 6;
	public static final int GOTOCLOSESTTEAMMATEWITHFLAG = 7;
	
	double propGoToOtherBase;
	double propGoToMyBase;
	double propGoToRandomSquareInZone;
	double propGoToRandomSquare;
	double propGoToClosestEnemy;
	double propGoToClosestEnemyWithFlag;
	double propGoToClosestTeammate;
	double propGoToClosestTeamMateWithFlag;

	public int getNextState()
	{
		double nextStateProp = Math.random();
		
		if (nextStateProp <= this.propGoToOtherBase)
		{
			return StateProp.GOTOOTHERBASE;
		}
		else if (nextStateProp <= this.propGoToMyBase)
		{
			return StateProp.GOTOMYBASE;
		}
		else if (nextStateProp <= this.propGoToRandomSquareInZone)
		{
			return StateProp.GOTORANDOMSQUAREZONE;
		}
		else if (nextStateProp <= this.propGoToRandomSquare)
		{
			return StateProp.GOTORANDOMSQUARE;
		}
		else if (nextStateProp <= this.propGoToClosestEnemy)
		{
			return StateProp.GOTOCLOSESTENEMY;
		}
		else if (nextStateProp <= this.propGoToClosestEnemyWithFlag)
		{
			return StateProp.GOTOCLOSESTTEAMMATEWITHFLAG;
		}
		else if (nextStateProp <= this.propGoToClosestTeammate)
		{
			return StateProp.GOTOCLOSESTTEAMMATE;
		}
		else 
		{
			return StateProp.GOTOCLOSESTENEMYWITHFLAG;
		}
		
	}

}
