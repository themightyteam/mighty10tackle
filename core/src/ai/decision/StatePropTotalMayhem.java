package ai.decision;

public class StatePropTotalMayhem extends StateProp {

	{
		this.propGoToOtherBase = 0.1;
		this.propGoToMyBase = 0.15;
		this.propGoToRandomSquareInZone = 0.2;
		this.propGoToRandomSquare = 0.25;
		this.propGoToClosestEnemy = 0.40;
		this.propGoToClosestEnemyWithFlag = 0.70; 
		this.propGoToClosestTeammate = 0.80;
		this.propGoToClosestTeamMateWithFlag = 1; 
	}

	
}
