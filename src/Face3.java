
public class Face3 {
	private Color[][] face;
	private FaceName label;
	
	
	//for now, assume faces are squares
	public Face3(Color c, FaceName f) {
		face = new Color[3][3];
		
		//initialize face to be entirely one color
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				face[i][j] = c;
			}
		}
		
		label = f;
	}
	
	public FaceName getLabel() {
		return label;
	}
	
	public Color[] sendSide(FaceName side) {
		Color[] sides = new Color[3];
		
		//populate based on which side is input
		for(int i = 0; i < 3; i++) {
			if(side == FaceName.UP) sides[i] = face[0][i];
			else if(side == FaceName.DOWN) sides[i] = face[2][i];
			else if(side == FaceName.LEFT) sides[i] = face[i][0];
			else if(side == FaceName.RIGHT) sides[i] = face[i][2];
			else {
				System.out.println("SOMETHING WENT WRONG.");
				System.exit(0);
			}
		}
		return sides;
	}
	
	//input should be an array of size 3 and the side which will be replaced by this array
	public void receiveSide(Color[] cols, FaceName side) {
		if(cols.length != 3) return; //some error checking
		for(int i = 0; i < 3; i++) {
			if(side == FaceName.UP) face[0][i] = cols[i];
			else if(side == FaceName.DOWN) face[2][i] = cols[i];
			else if(side == FaceName.LEFT) face[i][0] = cols[i];
			else if(side == FaceName.RIGHT) face[i][2] = cols[i];
			else {
				System.out.println("SOMETHING WENT WRONG.");
				System.exit(0);
			}
		}
	}
	
	//rotates the entire face clockwise
	public void rotate() {
		Color temp;
		//first rotate the corners
		temp = face[0][0];
		face[0][0] = face[2][0];
		face[2][0] = face[2][2];
		face[2][2] = face[0][2];
		face[0][2] = temp;
		
		//now rotate the edges
		temp = face[0][1];
		face[0][1] = face[1][0];
		face[1][0] = face[2][1];
		face[2][1] = face[1][2];
		face[1][2] = temp;
	}
	
	public void printFace() {
		System.out.println(label);
		for(int i = 0; i < face.length; i++) {
			for(int j = 0; j < face[i].length; j++) {
				System.out.print(face[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
