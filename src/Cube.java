
public class Cube {
	private Face[] cube;
	
	public Cube(int n) {
		cube = new Face[6];
		
		//manually code values for faces so the relationships of colors is right
		cube[FaceName.Up.getValue()] = new Face(Color.White, FaceName.Up, n);
		cube[FaceName.Down.getValue()] = new Face(Color.Yellow, FaceName.Down, n);
		cube[FaceName.Front.getValue()] = new Face(Color.Green, FaceName.Front, n);
		cube[FaceName.Back.getValue()] = new Face(Color.Blue, FaceName.Back, n);
		cube[FaceName.Left.getValue()] = new Face(Color.Orange, FaceName.Left, n);
		cube[FaceName.Right.getValue()] = new Face(Color.Red, FaceName.Right, n);
	}
	
	public Face getFace(FaceName fn) {
		return cube[fn.getValue()];
	}
	
	/* Takes a string with an algorithm and runs it on the cube.
	 * Each move is delimited by some input string.
	 * 2 and ' (apostrophe) are used to indicate
	 * turning a face twice or turning counter-clockwise.
	 * Standard notation is used (F B U D R L)
	 */
	
	public void runAlg(String alg) {
		runAlg(alg, " ");
	}
	
	public void runAlg(String alg, String del) {
		String[] toks = alg.split(del);
		String temp;
		FaceName face;
		for(int i = 0; i < toks.length; i++) {
			temp = toks[i];
			
			face = processMove(temp.charAt(0));
			
			//check if the input is valid
			if(face == null | temp.length() > 2) {
				System.out.println("Invalid input.");
				return;
			}
			
			//if there is only one character, then it can only be clockwise
			if(temp.length() == 1) turnFace(face);
			//check for other two move types
			else if(temp.charAt(1) == '2') turnFace2(face);
			else if(temp.charAt(1) == '\'') turnCounter(face);
			else {
				System.out.println("Invalid input.");
				return;
			}
		}
	}
	
	//maps a character to a facename type
	//returns null if not a valid character
	private FaceName processMove(char c) {
		if(c == 'F') return FaceName.Front;
		else if(c == 'B') return FaceName.Back;
		else if(c == 'U') return FaceName.Up;
		else if(c == 'D') return FaceName.Down;
		else if(c == 'L') return FaceName.Left;
		else if(c == 'R') return FaceName.Right;
		
		else return null;
	}
	
	//generic face turn for public use
	private void turnFace(FaceName fn) {
		if(fn == FaceName.Up) turnU();
		else if(fn == FaceName.Down) turnD();
		else if(fn == FaceName.Front) turnF();
		else if(fn == FaceName.Back) turnB();
		else if(fn == FaceName.Left) turnL();
		else if(fn == FaceName.Right) turnR();
		else {
			System.out.println("SOMETHING WENT WRONG.");
			System.exit(0);
		}
	}
	
	//turn a face twice
	private void turnFace2(FaceName fn) {
		turnFace(fn);
		turnFace(fn);
	}
	
	//turn a face counter-clockwise
	private void turnCounter(FaceName fn) {
		turnFace(fn);
		turnFace(fn);
		turnFace(fn);
	}
	
	//private functions for cube rotations
	
	//rotate the cube along the x-axis, similar to an R turn
	public void rotateX() {
		cube[FaceName.Right.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		
		//move faces around
		Face temp = cube[FaceName.Front.getValue()];
		cube[FaceName.Front.getValue()] = cube[FaceName.Down.getValue()];
		cube[FaceName.Down.getValue()] = cube[FaceName.Back.getValue()];
		cube[FaceName.Back.getValue()] = cube[FaceName.Up.getValue()];
		cube[FaceName.Up.getValue()] = temp;
		
		//these two faces will flip
		cube[FaceName.Back.getValue()].rotate();
		cube[FaceName.Back.getValue()].rotate();
		cube[FaceName.Front.getValue()].rotate();
		cube[FaceName.Front.getValue()].rotate();
		
		//update labels
		cube[FaceName.Front.getValue()].setLabel(FaceName.Front);
		cube[FaceName.Down.getValue()].setLabel(FaceName.Down);
		cube[FaceName.Back.getValue()].setLabel(FaceName.Back);
		cube[FaceName.Up.getValue()].setLabel(FaceName.Up);
	}
	
	//rotate the cube along the y-axis, similar to a U turn
	public void rotateY() {
		cube[FaceName.Up.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		
		//move faces around
		Face temp = cube[FaceName.Front.getValue()];
		cube[FaceName.Front.getValue()] = cube[FaceName.Right.getValue()];
		cube[FaceName.Right.getValue()] = cube[FaceName.Back.getValue()];
		cube[FaceName.Back.getValue()] = cube[FaceName.Left.getValue()];
		cube[FaceName.Left.getValue()] = temp;
		
		//update labels
		cube[FaceName.Front.getValue()].setLabel(FaceName.Front);
		cube[FaceName.Left.getValue()].setLabel(FaceName.Left);
		cube[FaceName.Back.getValue()].setLabel(FaceName.Back);
		cube[FaceName.Right.getValue()].setLabel(FaceName.Right);
	}
	
	//rotate the cube along the z-axis, similar to an F turn
	public void rotateZ() {
		cube[FaceName.Front.getValue()].rotate();
		cube[FaceName.Back.getValue()].rotate();
		cube[FaceName.Back.getValue()].rotate();
		cube[FaceName.Back.getValue()].rotate();
		
		//move faces around
		Face temp = cube[FaceName.Up.getValue()];
		cube[FaceName.Up.getValue()] = cube[FaceName.Left.getValue()];
		cube[FaceName.Left.getValue()] = cube[FaceName.Down.getValue()];
		cube[FaceName.Down.getValue()] = cube[FaceName.Right.getValue()];
		cube[FaceName.Right.getValue()] = temp;
		
		//the faces will flip
		cube[FaceName.Right.getValue()].rotate();
		cube[FaceName.Up.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		cube[FaceName.Down.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		cube[FaceName.Left.getValue()].rotate();
		
		//update labels
		cube[FaceName.Up.getValue()].setLabel(FaceName.Up);
		cube[FaceName.Left.getValue()].setLabel(FaceName.Left);
		cube[FaceName.Down.getValue()].setLabel(FaceName.Down);
		cube[FaceName.Right.getValue()].setLabel(FaceName.Right);
	}
	
	//private functions to turn faces
	
	//turns the top face clockwise
	private void turnU() {
		Color[] temp;
		cube[FaceName.Up.getValue()].rotate();
		temp = cube[FaceName.Front.getValue()].sendSide(FaceName.Up);
		cube[FaceName.Front.getValue()].receiveSide(cube[FaceName.Right.getValue()].sendSide(FaceName.Up), FaceName.Up, 0);
		cube[FaceName.Right.getValue()].receiveSide(cube[FaceName.Back.getValue()].sendSide(FaceName.Up), FaceName.Up, 0);
		cube[FaceName.Back.getValue()].receiveSide(cube[FaceName.Left.getValue()].sendSide(FaceName.Up), FaceName.Up, 0);
		cube[FaceName.Left.getValue()].receiveSide(temp, FaceName.Up, 0);
	}
	
	//turns the front face clockwise
	private void turnF() {
		Color[] temp;
		cube[FaceName.Front.getValue()].rotate();
		
		temp = cube[FaceName.Up.getValue()].sendSide(FaceName.Down);
		cube[FaceName.Up.getValue()].receiveSide(cube[FaceName.Left.getValue()].sendSide(FaceName.Right), FaceName.Down, -1);
		cube[FaceName.Left.getValue()].receiveSide(cube[FaceName.Down.getValue()].sendSide(FaceName.Down), FaceName.Right, -1);
		cube[FaceName.Down.getValue()].receiveSide(cube[FaceName.Right.getValue()].sendSide(FaceName.Left), FaceName.Down, 0);
		cube[FaceName.Right.getValue()].receiveSide(temp, FaceName.Left, 0);
	}
	
	//turns the left face clockwise
	private void turnL() {
		Color[] temp;
		cube[FaceName.Left.getValue()].rotate();
		
		temp = cube[FaceName.Up.getValue()].sendSide(FaceName.Left);
		cube[FaceName.Up.getValue()].receiveSide(cube[FaceName.Back.getValue()].sendSide(FaceName.Right), FaceName.Left, -1);
		cube[FaceName.Back.getValue()].receiveSide(cube[FaceName.Down.getValue()].sendSide(FaceName.Right), FaceName.Right, 0);
		cube[FaceName.Down.getValue()].receiveSide(cube[FaceName.Front.getValue()].sendSide(FaceName.Left), FaceName.Right, -1);
		cube[FaceName.Front.getValue()].receiveSide(temp, FaceName.Left, 0);
	}
	
	//turns the right face clockwise
	private void turnR() {
		Color[] temp;
		cube[FaceName.Right.getValue()].rotate();
		
		temp = cube[FaceName.Up.getValue()].sendSide(FaceName.Right);
		cube[FaceName.Up.getValue()].receiveSide(cube[FaceName.Front.getValue()].sendSide(FaceName.Right), FaceName.Right, 0);
		cube[FaceName.Front.getValue()].receiveSide(cube[FaceName.Down.getValue()].sendSide(FaceName.Left), FaceName.Right, -1);
		cube[FaceName.Down.getValue()].receiveSide(cube[FaceName.Back.getValue()].sendSide(FaceName.Left), FaceName.Left, 0);
		cube[FaceName.Back.getValue()].receiveSide(temp, FaceName.Left, -1);
	}
	
	//turns the back face clockwise
	private void turnB() {
		Color[] temp;
		cube[FaceName.Back.getValue()].rotate();
		
		temp = cube[FaceName.Up.getValue()].sendSide(FaceName.Up);
		cube[FaceName.Up.getValue()].receiveSide(cube[FaceName.Right.getValue()].sendSide(FaceName.Right), FaceName.Up, 0);
		cube[FaceName.Right.getValue()].receiveSide(cube[FaceName.Down.getValue()].sendSide(FaceName.Up), FaceName.Right, 0);
		cube[FaceName.Down.getValue()].receiveSide(cube[FaceName.Left.getValue()].sendSide(FaceName.Left), FaceName.Up, -1);
		cube[FaceName.Left.getValue()].receiveSide(temp, FaceName.Left, -1);
	}
	
	//turns the down face clockwise
	private void turnD() {
		Color[] temp;
		cube[FaceName.Down.getValue()].rotate();
		
		temp = cube[FaceName.Front.getValue()].sendSide(FaceName.Down);
		cube[FaceName.Front.getValue()].receiveSide(cube[FaceName.Left.getValue()].sendSide(FaceName.Down), FaceName.Down, 0);
		cube[FaceName.Left.getValue()].receiveSide(cube[FaceName.Back.getValue()].sendSide(FaceName.Down), FaceName.Down, 0);
		cube[FaceName.Back.getValue()].receiveSide(cube[FaceName.Right.getValue()].sendSide(FaceName.Down), FaceName.Down, 0);
		cube[FaceName.Right.getValue()].receiveSide(temp, FaceName.Down, 0);
	}
	
	public void printCube() {
		for(int i = 0; i < cube.length; i++) {
			cube[i].printFace();
		}
	}
}
