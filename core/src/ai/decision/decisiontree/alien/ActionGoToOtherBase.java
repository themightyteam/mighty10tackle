package ai.decision.decisiontree.alien;

import ai.decision.AlienFSMDecisor;
import ai.decision.decisiontree.DecisionTreeNode;

public class ActionGoToOtherBase extends DecisionTreeFSMNode {


	int nextNode;
	
	public ActionGoToOtherBase(AlienFSMDecisor alienFSM) {
		super(alienFSM);

	}

	@Override
	public DecisionTreeNode makeDecision() {

		this.nextNode = alienFSM.obtainOtherBaseSquare();
	
		return this;
	}

}
