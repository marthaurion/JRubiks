
public enum FaceName {
	UP(0), DOWN(1), FRONT(2), BACK(3), LEFT(4), RIGHT(5);
	
	//might not use this, but could come in handy
	private FaceName opposite;
	private final int id;
	
	//I could hard-code every relationship between sides
	//Do I want to make 36 associations???
	static {
		UP.opposite = DOWN;
		DOWN.opposite = UP;
		FRONT.opposite = BACK;
		BACK.opposite = FRONT;
		LEFT.opposite = RIGHT;
		RIGHT.opposite = LEFT;
	}
	
	FaceName(int id) { this.id = id; }
	public int getValue() { return id; }
	
	public FaceName getOpposite() {
		return opposite;
	}
}
