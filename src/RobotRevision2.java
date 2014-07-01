import java.util.ArrayList;

public class RobotRevision2 {

	int positionx;
	int positiony;
	String facing;
	ArrayList<Moves> planRobotMovement = new ArrayList<Moves>();

	RobotRevision2() {
		positionx = 0;
		positiony = 0;
		facing = "north";
	}

	RobotRevision2(int x, int y, String Initfacing) {
		positionx = x;
		positiony = y;
		facing = Initfacing;
	}

	public void turnLeft() {
		DoLeft l = new DoLeft();
		planRobotMovement.add(l);
	}

	public void turnRight() {
		DoRight r = new DoRight();
		planRobotMovement.add(r);
	}

	
	public void forward(int speed) {
		if (speed >= 1 && speed <= 3) {
			DoForward f = new DoForward(speed);
			planRobotMovement.add(f);
		} else {
			DoForward f = new DoForward(1);
			planRobotMovement.add(f);
		}
	}

	public void backward() {
		DoBackward b = new DoBackward();
		planRobotMovement.add(b);
	}

	public void doLeft() {
		if (facing.equals("north")) {
			facing = "west";
		} else if (facing.equals("east")) {
			facing = "north";
		} else if (facing.equals("south")) {
			facing = "east";
		} else if (facing.equals("west")) {
			facing = "south";
		}
	}

	public void doRight() {
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

	public void doForward(int speed) {
		if (facing.equals("north")) {
			positiony = positiony + speed;
		} else if (facing.equals("east")) {
			positionx = positionx + speed;
		} else if (facing.equals("south")) {
			positiony = positiony - speed;
		} else if (facing.equals("west")) {
			positionx = positionx - speed;
		}
	}

	public void doBackward() {
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

	public void printState() {
		System.out.println("Now facing: '" + facing + "' at: (" + positionx
				+ "," + positiony + ")");
	}

	public void executePlan() {
		System.out.println(planRobotMovement.size());
		for (Moves m : planRobotMovement) {
			m.doMove(this);
		}
		}
	}

