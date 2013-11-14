
public class Cube3 {
	private Face3[] cube;
	
	public Cube3() {
		cube = new Face3[6];
		
		//manually code values for faces so the relationships of colors is right
		cube[0] = new Face3(Color.WHITE, FaceName.UP);
		cube[1] = new Face3(Color.YELLOW, FaceName.DOWN);
		cube[2] = new Face3(Color.GREEN, FaceName.FRONT);
		cube[3] = new Face3(Color.BLUE, FaceName.BACK);
		cube[4] = new Face3(Color.ORANGE, FaceName.LEFT);
		cube[5] = new Face3(Color.RED, FaceName.RIGHT);
	}
	
	public Face3 getFace(FaceName fn) {
		return cube[fn.getValue()];
	}
	
	//generic face turn for public use
	public void turnFace(FaceName fn) {
		if(fn == FaceName.UP) turnU();
		else if(fn == FaceName.DOWN) turnD();
		else if(fn == FaceName.FRONT) turnF();
		else if(fn == FaceName.BACK) turnB();
		else if(fn == FaceName.LEFT) turnL();
		else if(fn == FaceName.RIGHT) turnR();
		else {
			System.out.println("SOMETHING WENT WRONG.");
			System.exit(0);
		}
	}
	
	//turn a face twice
	public void turnFace2(FaceName fn) {
		turnFace(fn);
		turnFace(fn);
	}
	
	//turn a face counter-clockwise
	public void turnCounter(FaceName fn) {
		turnFace(fn);
		turnFace(fn);
		turnFace(fn);
	}
	
	//private functions to turn faces
	
	//turns the top face clockwise
	private void turnU() {
		Color[] temp;
		cube[0].rotate();
		temp = cube[2].sendSide(FaceName.UP);
		cube[2].receiveSide(cube[5].sendSide(FaceName.UP), FaceName.UP, 0);
		cube[5].receiveSide(cube[3].sendSide(FaceName.UP), FaceName.UP, 0);
		cube[3].receiveSide(cube[4].sendSide(FaceName.UP), FaceName.UP, 0);
		cube[4].receiveSide(temp, FaceName.UP, 0);
	}
	
	//turns the front face clockwise
	private void turnF() {
		Color[] temp;
		cube[2].rotate();
		
		temp = cube[0].sendSide(FaceName.DOWN);
		cube[0].receiveSide(cube[4].sendSide(FaceName.RIGHT), FaceName.DOWN, -1);
		cube[4].receiveSide(cube[1].sendSide(FaceName.DOWN), FaceName.RIGHT, -1);
		cube[1].receiveSide(cube[5].sendSide(FaceName.LEFT), FaceName.DOWN, 0);
		cube[5].receiveSide(temp, FaceName.LEFT, 0);
	}
	
	//turns the left face clockwise
	private void turnL() {
		Color[] temp;
		cube[4].rotate();
		
		temp = cube[0].sendSide(FaceName.LEFT);
		cube[0].receiveSide(cube[3].sendSide(FaceName.RIGHT), FaceName.LEFT, -1);
		cube[3].receiveSide(cube[1].sendSide(FaceName.RIGHT), FaceName.RIGHT, 0);
		cube[1].receiveSide(cube[2].sendSide(FaceName.LEFT), FaceName.RIGHT, -1);
		cube[2].receiveSide(temp, FaceName.LEFT, 0);
	}
	
	//turns the right face clockwise
	private void turnR() {
		Color[] temp;
		cube[5].rotate();
		
		temp = cube[0].sendSide(FaceName.RIGHT);
		cube[0].receiveSide(cube[2].sendSide(FaceName.RIGHT), FaceName.RIGHT, 0);
		cube[2].receiveSide(cube[1].sendSide(FaceName.LEFT), FaceName.RIGHT, -1);
		cube[1].receiveSide(cube[3].sendSide(FaceName.LEFT), FaceName.LEFT, 0);
		cube[3].receiveSide(temp, FaceName.LEFT, -1);
	}
	
	//turns the back face clockwise
	private void turnB() {
		Color[] temp;
		cube[3].rotate();
		
		temp = cube[0].sendSide(FaceName.UP);
		cube[0].receiveSide(cube[5].sendSide(FaceName.RIGHT), FaceName.UP, 0);
		cube[5].receiveSide(cube[1].sendSide(FaceName.UP), FaceName.RIGHT, 0);
		cube[1].receiveSide(cube[4].sendSide(FaceName.LEFT), FaceName.UP, -1);
		cube[4].receiveSide(temp, FaceName.LEFT, -1);
	}
	
	//turns the down face clockwise
	private void turnD() {
		Color[] temp;
		cube[1].rotate();
		
		temp = cube[2].sendSide(FaceName.DOWN);
		cube[2].receiveSide(cube[4].sendSide(FaceName.DOWN), FaceName.DOWN, 0);
		cube[4].receiveSide(cube[3].sendSide(FaceName.DOWN), FaceName.DOWN, 0);
		cube[3].receiveSide(cube[5].sendSide(FaceName.DOWN), FaceName.DOWN, 0);
		cube[5].receiveSide(temp, FaceName.DOWN, 0);
	}
	
	public void printCube() {
		for(int i = 0; i < cube.length; i++) {
			cube[i].printFace();
		}
	}
}
