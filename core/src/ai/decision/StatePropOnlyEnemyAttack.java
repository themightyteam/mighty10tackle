package ai.decision;

public class StatePropOnlyEnemyAttack extends StateProp 
{

	public StatePropOnlyEnemyAttack()
	{
		this.propGoToOtherBase = 0.5;
		this.propGoToMyBase = 0.7;
		this.propGoToRandomSquareInZone = 0.7;
		this.propGoToRandomSquare = 0.7;
		this.propGoToClosestEnemy = 0.75;
		this.propGoToClosestEnemyWithFlag = 1;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}
	
}
