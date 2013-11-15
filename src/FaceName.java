
public enum FaceName {
	UP(0), DOWN(1), FRONT(2), BACK(3), LEFT(4), RIGHT(5);
	
	//might not use this, but could come in handy
	private final int id;
	
	FaceName(int id) { this.id = id; }
	public int getValue() { return id; }
}
