package ai.decision;

public class StatePropStatusQuo extends StateProp {
	
	public StatePropStatusQuo()
	{
		this.propGoToOtherBase = 0.2;
		this.propGoToMyBase = 0.4;
		this.propGoToRandomSquareInZone = 0.5;
		this.propGoToRandomSquare = 0.7;
		this.propGoToClosestEnemy = 0.85;
		this.propGoToClosestEnemyWithFlag = this.propGoToClosestEnemy;
		this.propGoToClosestTeammate = 1;
		this.propGoToClosestTeamMateWithFlag = this.propGoToClosestTeammate;
	}

}
