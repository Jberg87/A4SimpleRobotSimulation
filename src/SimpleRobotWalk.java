
public class SimpleRobotWalk {

	public static void main(String[] args) {
		// Meer een eigen interpretatie aan de opdracht gegeven: plan maken via de terminal
//		System.out.println("my_Robot_1");
//		Robot my_Robot_1 = new Robot();
//		my_Robot_1.initialState(0,0,"north");
//		my_Robot_1.printState();
//		boolean plan = my_Robot_1.planMovement();
//		my_Robot_1.executePlan(plan);
		
		// De assignment normaal
		System.out.println();
		System.out.println("my_Robot_2");
		RobotRevision2 my_Robot_2 = new RobotRevision2(0,0,"north");
//		my_Robot_2.initialState(0,0,"north");
		my_Robot_2.turnLeft();
		my_Robot_2.forward(1);
		my_Robot_2.turnRight();
		my_Robot_2.backward();
		my_Robot_2.printState();
		my_Robot_2.forward(3);
		my_Robot_2.forward(3);
		my_Robot_2.forward(0);
		my_Robot_2.turnRight();

		my_Robot_2.executePlan();
		my_Robot_2.printState();
		
	}
}
