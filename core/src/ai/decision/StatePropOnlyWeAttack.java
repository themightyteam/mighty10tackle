package ai.decision;

public class StatePropOnlyWeAttack extends StateProp 
{
	public StatePropOnlyWeAttack()
	{
		this.propGoToOtherBase = 0.05;
		this.propGoToMyBase = 0.3;
		this.propGoToRandomSquareInZone = 0.4;
		this.propGoToRandomSquare = 0.5;
		this.propGoToClosestEnemy = 0.55;
		this.propGoToClosestEnemyWithFlag = this.propGoToClosestEnemy;
		this.propGoToClosestTeammate = 0.65;
		this.propGoToClosestTeamMateWithFlag = 1;
	}
	
	
}
