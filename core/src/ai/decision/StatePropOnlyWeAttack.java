package ai.decision;

public class StatePropOnlyWeAttack extends StateProp 
{
	public StatePropOnlyWeAttack()
	{
		this.propGoToOtherBase = 0.1;
		this.propGoToMyBase = 0.4;
		this.propGoToRandomSquareInZone = 0.5;
		this.propGoToRandomSquare = 0.6;
		this.propGoToClosestEnemy = 0.7;
		this.propGoToClosestEnemyWithFlag = this.propGoToClosestEnemy;
		this.propGoToClosestTeammate = 0.8;
		this.propGoToClosestTeamMateWithFlag = 1;
	}
	
	
}
