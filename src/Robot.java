import java.util.ArrayList;
import java.util.Scanner;

public class Robot {

	int positionx;
	int positiony;
	String facing;
	int moves;
	ArrayList<String> planRobotMovement = new ArrayList<String>();
	ArrayList<Integer> planRobotSpeed = new ArrayList<Integer>();

	// etc for the other possible facings

	public void initialState(int x, int y, String Initfacing) {
		positionx = x;
		positiony = y;
		facing = Initfacing;
	}

	public void turnLeft() {
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

	public void turnRight() {
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

	public void forward(int speed) {
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

	public void backward() {
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

	public boolean planMovement() {
		System.out.println("What do you want to plan for the Robot?:");
		System.out.println("Decide how many moves do you want to make:");
		Scanner inputmoves = new Scanner(System.in);
		moves = inputmoves.nextInt();
		System.out
				.println("Choose turn left, turn right, forward, backward or execute");
		Scanner input = new Scanner(System.in);
		Scanner speedDefiner = new Scanner(System.in);

		for (int i = 0; i < moves; i++) {
			String choice = input.nextLine();
			planRobotMovement.add(choice);
			if (planRobotMovement.get(i).equals("turn left")) {
				planRobotSpeed.add(0);
			} else if (planRobotMovement.get(i).equals("turn right")) {
				planRobotSpeed.add(0);
			} else if (planRobotMovement.get(i).equals("forward")) {
				System.out.println("With what speed?");
				int speed = speedDefiner.nextInt();
				if (speed >= 1 && speed <= 3) {
					planRobotSpeed.add(speed);
				} else {
					planRobotSpeed.add(1);
				}
			} else if (planRobotMovement.get(i).equals("backward")) {
				planRobotSpeed.add(-1);
			}
		}
		System.out.println("");
		System.out.println("Your planned movement is:");
		System.out.println(planRobotMovement);
		System.out.println("Your robot's speed will be: ");
		System.out.println(planRobotSpeed);
		boolean planCompleted = true;
		return planCompleted;
	}

	public void executePlan(boolean plan) {
		if (plan) {
			for (int i = 0; i < moves; i++) {
				if (this.planRobotMovement.get(i).equals("turn left")) {
					this.turnLeft();
				} else if (this.planRobotMovement.get(i).equals("turn right")) {
					this.turnRight();
				} else if (this.planRobotMovement.get(i).equals("forward")) {
					if (this.planRobotSpeed.get(i) >= 1
							&& this.planRobotSpeed.get(i) <= 3) {
						this.forward(this.planRobotSpeed.get(i));
					} else {
						this.forward(1);
					}
				} else if (this.planRobotMovement.get(i).equals("backward")) {
					this.backward();
				}
				this.printState();
			}
		} else {
			System.out.println("First make a plan!");
		}
	}
}