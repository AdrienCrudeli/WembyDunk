
public class Vector {

	public int x;
	public int y;

	public Vector(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int[] addition(int[] v1) {
		int[] v = new int[2] ;
		v[0]=x+v1[0];
		v[1]=y+v1[1];
		return v;

	}

	public String toString(int[] v1) {
		return ""+v1[0]+","+v1[1];
	}

	public int[] lambda(double y) {

		int[] v = new int[2] ;
		v[0]*=y;
		v[1]*=y;
		return v;
	}
	
	public int[] scalar(int[] v1) {

		int[] v = new int[2] ;
		v[0] = x*v1[0];
		v[1] = y*v1[1];
		return v;
	}
	public double norme() {
		
		return Math.pow(Math.pow(x, 2)+Math.pow(y, 2),0.5);
	}
	
	public double distance(int[] v1,int [] v2) {
		return Math.pow(Math.pow(v2[0]-v1[0], 2)+Math.pow(v2[1]-v1[1], 2),0.5);
	}
	
}