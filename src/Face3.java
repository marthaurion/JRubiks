
public class Face3 {
	private Color[][] face;
	private int N;
	private FaceName label;
	
	
	//for now, assume faces are squares
	public Face3(Color c, FaceName f) {
		N = 3;
		face = new Color[N][N];
		
		//initialize face to be entirely one color
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				face[i][j] = c;
			}
		}
		
		label = f;
	}
	
	public FaceName getLabel() {
		return label;
	}
	
	public Color[] sendSide(FaceName side) {
		Color[] sides = new Color[N];
		
		//populate based on which side is input
		for(int i = 0; i < N; i++) {
			if(side == FaceName.UP) sides[i] = face[0][i];
			else if(side == FaceName.DOWN) sides[i] = face[N-1][i];
			else if(side == FaceName.LEFT) sides[i] = face[i][0];
			else if(side == FaceName.RIGHT) sides[i] = face[i][N-1];
			else {
				System.out.println("SOMETHING WENT WRONG.");
				System.exit(0);
			}
		}
		return sides;
	}
	
	//input should be an array of size 3 and the side which will be replaced by this array
	public void receiveSide(Color[] cols, FaceName side, int x) {
		if(cols.length != N) return; //some error checking
		
		Color[] colors = new Color[N];
		if(x == -1) {
			for(int i = 0; i <= N/2; i++) {
				colors[i] = cols[N-i-1];
				colors[N-i-1] = cols[i];
			}
		}
		else colors = cols;
		
		for(int i = 0; i < N; i++) {
			if(side == FaceName.UP) face[0][i] = colors[i];
			else if(side == FaceName.DOWN) face[N-1][i] = colors[i];
			else if(side == FaceName.LEFT) face[i][0] = colors[i];
			else if(side == FaceName.RIGHT) face[i][N-1] = colors[i];
			else {
				System.out.println("SOMETHING WENT WRONG.");
				System.exit(0);
			}
		}
	}
	
	//rotates the entire face clockwise
	public void rotate() {
		rotate(N, 0);
	}
	
	//haven't tested this on higher size cubes
	//should work on 3x3, though
	public void rotate(int n, int x) {
		if(n <= 1) return; //stopping case
		Color temp;
		int hi = n-x-1;
		
		//first rotate the corners
		temp = face[x][x];
		face[x][x] = face[hi][x];
		face[hi][x] = face[hi][hi];
		face[hi][hi] = face[x][hi];
		face[x][hi] = temp;
		
		if(n == 2) return; //no edges on 2x2
		
		//now rotate the edges
		for(int i = x+1; i < hi; i++) {
			temp = face[x][i];
			face[x][i] = face[hi-i][x];
			face[hi-i][x] = face[hi][hi-i];
			face[hi][hi-i] = face[i][hi];
			face[i][hi] = temp;
		}
		
		//recurse down for inner squares
		rotate(n-2, x+1);
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
