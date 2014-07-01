public class DoForward extends Moves {
	
	int speed;
	
	DoForward(int speedPlan) {
		speed = speedPlan;
	}

	
	public void doMove(RobotRevision2 robot) {
		robot.doForward(speed);
		
		
	}
}
