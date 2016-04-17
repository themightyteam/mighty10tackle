package ai.decision;

public class StatePropOnlyEnemyAttack extends StateProp 
{

	public StatePropOnlyEnemyAttack()
	{
		this.propGoToOtherBase = 0.05;
		this.propGoToMyBase = 0.3;
		this.propGoToRandomSquareInZone = 0.35;
		this.propGoToRandomSquare = 0.40;
		this.propGoToClosestEnemy = 0.7;
		this.propGoToClosestEnemyWithFlag = 1;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}
	
}
