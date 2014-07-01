import java.util.ArrayList;

public class RobotAssignment {

	int positionx;
	int positiony;
	String facing;
	boolean execution = false;
	ArrayList<String> planRobotMovement = new ArrayList<String>();
	ArrayList<Integer> planRobotSpeed = new ArrayList<Integer>();

	public void initialState(int x, int y, String Initfacing) {
		positionx = x;
		positiony = y;
		facing = Initfacing;
	}

	public void turnLeft() {
		if (!execution) {
			planRobotMovement.add("turn left");
			planRobotSpeed.add(0);

		} else if (facing.equals("north")) {
			facing = "west";
		} else if (facing.equals("east")) {
			facing = "north";
		} else if (facing.equals("south")) {
			facing = "east";
		} else if (facing.equals("west")) {
			facing = "south";
		}
	}

	public void turnRight() {
		if (!execution) {
			planRobotMovement.add("turn right");
			planRobotSpeed.add(0);
		} else {
			if (facing.equals("north")) {
				facing = "east";
			} else if (facing.equals("east")) {
				facing = "south";
			} else if (facing.equals("south")) {
				facing = "west";
			} else if (facing.equals("west")) {
				facing = "north";
			}
		}
	}

	public void forward(int speed) {
		if (!execution) {
			planRobotMovement.add("forward");
			if (speed >= 1 && speed <= 3) {
				planRobotSpeed.add(speed);
			} else {
				planRobotSpeed.add(1);
			}
		} else if (facing.equals("north")) {
			positiony = positiony + speed;
		} else if (facing.equals("east")) {
			positionx = positionx + speed;
		} else if (facing.equals("south")) {
			positiony = positiony - speed;
		} else if (facing.equals("west")) {
			positionx = positionx - speed;
		}
	}

	public void backward() {
		if (!execution) {
			planRobotMovement.add("backward");
			planRobotSpeed.add(-1);
		} else {

			if (facing.equals("north")) {
				positiony = positiony - 1;
			} else if (facing.equals("east")) {
				positionx = positionx - 1;
			} else if (facing.equals("south")) {
				positiony = positiony + 1;
			} else if (facing.equals("west")) {
				positionx = positionx + 1;
			}
		}
	}

	public void printState() {
		System.out.println("Now facing: '" + facing + "' at: (" + positionx
				+ "," + positiony + ")");
	}

	public void executePlan() {
		execution = true;
		for (int i = 0; i < planRobotMovement.size(); i++) {
			if (this.planRobotMovement.get(i).equals("turn left")) {
				this.turnLeft();
			} else if (planRobotMovement.get(i).equals("turn right")) {
				this.turnRight();
			} else if (planRobotMovement.get(i).equals("forward")) {
				this.forward(planRobotSpeed.get(i));
			} else if (planRobotMovement.get(i).equals("backward")) {
				this.backward();
			}
			this.printState();
		}
	}
}
