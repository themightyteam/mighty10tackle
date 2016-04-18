package ai.decision;

public class StatePropStatusQuo extends StateProp {
	
	public StatePropStatusQuo()
	{
		this.propGoToOtherBase = 0.7;
		this.propGoToMyBase = 0.75;
		this.propGoToRandomSquareInZone = 0.8;
		this.propGoToRandomSquare = 0.85;
		this.propGoToClosestEnemy = 0.95;
		this.propGoToClosestEnemyWithFlag = this.propGoToClosestEnemy;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}

}
