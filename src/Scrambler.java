import java.util.ArrayList;
import java.util.Random;

public class Scrambler {
	private int numMoves;
	private String scramble;
	
	public Scrambler() {
		numMoves = 20;
		scramble = null;
	}
	
	public String getScramble() {
		if(scramble != null) return scramble;
		else return "No scramble generated.";
	}
	
	public void generateScramble() {
		
		//generate a list of moves
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int i = 0; i < numMoves; ++i) {
			moves.add(generateMove(moves));
		}
		
		//translate list of moves into a string
		
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < moves.size()-1; i++) {
			st.append(moves.get(i).getNotation()+" ");
		}
		st.append(moves.get(moves.size()-1).getNotation());
		
		scramble = st.toString();
	}
	
	//need to make it so moves don't undo themselves
	private Move generateMove(ArrayList<Move> moves) {
		FaceName face;
		Direction dir;
		Random r = new Random();
		
		//first generate the face moved
		int x = r.nextInt(9);
		
		if(x < 2) face = FaceName.Up;
		else if(x < 4) face = FaceName.Right;
		else if(x < 6) face = FaceName.Front;
		else if(x == 6) face = FaceName.Back;
		else if(x == 7) face = FaceName.Left;
		else face = FaceName.Down;
		
		//now generate the direction of movement
		x = r.nextInt(10);
		
		if(x < 4) dir = Direction.Clock;
		else if(x < 8) dir = Direction.Counterclock;
		else dir = Direction.Twice;
		
		return new Move(face, dir);
	}
}
