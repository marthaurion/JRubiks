
public class Test {

	public static void main(String[] args) {
		Cube3 cube = new Cube3();
		cube.printCube();
		System.out.println();
		for(int i = 0; i < 6; i++) {
			alg(cube);
		}
		cube.printCube();
	}
	
	public static void alg(Cube3 cube) {
		cube.turnFace(FaceName.RIGHT);
		cube.turnFace(FaceName.UP);
		cube.turnCounter(FaceName.RIGHT);
		cube.turnFace(FaceName.UP);
		cube.turnFace(FaceName.RIGHT);
		cube.turnFace2(FaceName.UP);
		cube.turnCounter(FaceName.RIGHT);
	}
}
