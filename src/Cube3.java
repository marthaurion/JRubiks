
public class Cube3 {
	private Face3[] cube;
	
	public Cube3() {
		cube = new Face3[6];
		
		//manually code values for faces so the relationships of colors is right
		cube[0] = new Face3(Color.WHITE, FaceName.UP);
		cube[1] = new Face3(Color.YELLOW, FaceName.DOWN);
		cube[2] = new Face3(Color.BLUE, FaceName.BACK);
		cube[3] = new Face3(Color.GREEN, FaceName.FRONT);
		cube[4] = new Face3(Color.RED, FaceName.RIGHT);
		cube[5] = new Face3(Color.ORANGE, FaceName.LEFT);
	}
	
	public void printCube() {
		for(int i = 0; i < cube.length; i++) {
			cube[i].printFace();
		}
	}
}
