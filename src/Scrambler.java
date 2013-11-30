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
		Move m = null;
		
		boolean valid = false;
		
		if(moves.size() == 0) return getRandomMove(); //the first move can be anything
		while(!valid) {
			m = getRandomMove();
			
			//check whether the previous move is the same face
			if(moves.get(moves.size() - 1).getFace() == m.getFace()) continue;
			
			//now check whether a move since the last time this move was made has "moved" this move's face
			else {
				valid = true; //this will become false if the loop finds something
				
				//loop through and find the last move that involved
				for(int i = moves.size()-1; i >= 0; i--) {
					//if you find a face that's the same, the move isn't valid
					if(moves.get(i).getFace() == m.getFace()) {
						valid = false;
						break;
					}
					
					//if the face opposite of the current face is moved,
					//the current face isn't changed, so keep searching back
					else if(moves.get(i).getFace() == m.getFace().opposite()) continue;
					
					//otherwise, a move is found that mutates
					else {
						valid = true;
						break;
					}
				}
				
				//if the loop reaches the first element of the input,
				//then it will return valid as true, which is fine
			}
		}
		
		return m;
	}
	
	//generates a random move
	private Move getRandomMove() {
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
