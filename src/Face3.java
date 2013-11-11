
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
