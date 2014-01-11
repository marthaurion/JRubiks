
public class Test {

	public static void main(String[] args) {
		Cube cube = new Cube(3);
		Scrambler scramble = new Scrambler();
		System.out.println(scramble.generateScramble());
		cube.runAlg(scramble.generateScramble());
		//cube.runAlg("R U R\' U R U2 R\'");
		//cube.runAlg("D2 F2 L\' U\' L\' B2 U L\' D U\' R\' F\' U\' F D U\' R2 B\' D2 U\' F D2 B F2 D2");
		//cube.printCube();
	}
	
}
