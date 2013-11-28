import java.util.Random;

public class Scrambler {
	private int numMoves;
	private String scramble;
	
	public Scrambler() {
		numMoves = 20;
		scramble = null;
	}
	
	public void generateScramble() {
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < numMoves-1; ++i) {
			st.append(generateMove()+" ");
		}
		st.append(generateMove());
		scramble = st.toString();
	}
	
	public String getScramble() {
		if(scramble != null) return scramble;
		else return "No scramble generated.";
	}
	
	private String generateMove() {
		String st = "";
		Random r = new Random();
		
		//first generate the face moved
		int x = r.nextInt(6);
		
		if(x == 0) st += "U";
		else if(x == 1) st += "D";
		else if(x == 2) st += "F";
		else if(x == 3) st += "B";
		else if(x == 4) st += "L";
		else if(x == 5) st += "R";
		
		//now generate the direction of movement
		x = r.nextInt(10);
		
		if(x < 4) return st;
		else if(x < 8) return st+"\'";
		else return st+"2";
	}
}
