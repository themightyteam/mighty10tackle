package ai.decision;

public class StatePropOnlyEnemyAttack extends StateProp 
{

	public StatePropOnlyEnemyAttack()
	{
		this.propGoToOtherBase = 0.1;
		this.propGoToMyBase = 0.5;
		this.propGoToRandomSquareInZone = 0.55;
		this.propGoToRandomSquare = 0.6;
		this.propGoToClosestEnemy = 0.7;
		this.propGoToClosestEnemyWithFlag = 0.95;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}
	
}
