
public class Test {

	public static void main(String[] args) {
		
//		Face3 test = new Face3(Color.RED, FaceName.UP, 4);
//		test.face = new Color[4][4];
//		test.face[0][0] = Color.WHITE;
//		test.face[1][0] = Color.YELLOW;
//		test.face[2][0] = Color.RED;
//		test.face[3][0] = Color.ORANGE;
//		test.face[0][1] = Color.BLUE;
//		test.face[1][1] = Color.WHITE;
//		test.face[2][1] = Color.GREEN;
//		test.face[3][1] = Color.RED;
//		test.face[0][2] = Color.GREEN;
//		test.face[1][2] = Color.YELLOW;
//		test.face[2][2] = Color.ORANGE;
//		test.face[3][2] = Color.BLUE;
//		test.face[0][3] = Color.GREEN;
//		test.face[1][3] = Color.RED;
//		test.face[2][3] = Color.BLUE;
//		test.face[3][3] = Color.WHITE;
//		
//		test.printFace();
//		System.out.println();
//		test.rotate();
//		test.printFace();
		
		Cube3 cube = new Cube3(4);
		cube.runAlg("R U R\' U R U2 R\'");
		cube.printCube();
	}
	
}
