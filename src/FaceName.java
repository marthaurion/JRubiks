
public enum FaceName {
	Up(0), Down(1), Front(2), Back(3), Left(4), Right(5);
	
	//might not use this, but could come in handy
	private final int id;
	
	FaceName(int id) { this.id = id; }
	public int getValue() { return id; }
}
