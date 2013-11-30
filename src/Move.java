
public class Move {
	private FaceName face;
	private Direction dir;
	
	public Move(FaceName f, Direction d) {
		face = f;
		dir = d;
	}
	
	public FaceName getFace() {
		return face;
	}
	
	public String getNotation() {
		return face.getNotation()+dir.getNotation();
	}
}
