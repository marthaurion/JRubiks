
public enum Direction {
	Clock(0), Counterclock(1), Twice(2);
	
	private final int id;
	
	Direction(int id) { this.id = id; }
	
	public int getValue() {
		return id;
	}
	
	public String getNotation() {
		if(id == 0) return "";
		else if(id == 1) return "\'";
		else return "2";
	}
}
