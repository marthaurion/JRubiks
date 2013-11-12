
public class Test {

	public static void main(String[] args) {
		Cube3 cube = new Cube3();
		cube.printCube();
		cube.turnFace(FaceName.UP);
		System.out.println();
		cube.printCube();
	}
}
