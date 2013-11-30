
public enum FaceName {
	Up(0), Down(1), Front(2), Back(3), Left(4), Right(5);
	
	//might not use this, but could come in handy
	private final int id;
	
	FaceName(int id) { this.id = id; }
	
	public int getValue() {
		return id;
	}
	
	public String getNotation() {
		return toString().substring(0,1);
	}
	
	public FaceName opposite() {
		if(id == 0) return FaceName.Down;
		else if(id == 1) return FaceName.Up;
		else if(id == 2) return FaceName.Back;
		else if(id == 3) return FaceName.Front;
		else if(id == 4) return FaceName.Right;
		else return FaceName.Left;
	}
}
