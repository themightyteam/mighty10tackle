package ai.decision;

public class StatePropStatusQuo extends StateProp {
	
	public StatePropStatusQuo()
	{
		this.propGoToOtherBase = 1;
		this.propGoToMyBase = 1;
		this.propGoToRandomSquareInZone = 1;
		this.propGoToRandomSquare = 1;
		this.propGoToClosestEnemy = 1;
		this.propGoToClosestEnemyWithFlag = this.propGoToClosestEnemy;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}

}
