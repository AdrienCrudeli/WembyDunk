
public class Vector {

	public double x;
	public double y;

	

	public Vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public Vector addition(Vector v1) {
		Vector v = new Vector(x+v1.getX() , y+v1.getY());
		return v;

	}

	public String toString(Vector v1) {
		return ""+v1.getX()+","+v1.getY();
	}

	public Vector lambda(double l) {
		Vector v = new Vector(x*y,y*l);
		return v;
	}
	
	public Vector scalar(Vector v1) {
		Vector v = new Vector(x*v1.getX(),y*v1.getY()) ;
		return v;
	}
	public double norme() {
		
		return Math.pow(Math.pow(x, 2)+Math.pow(y, 2),0.5);
	}
	
	public double distance(int[] v1,int [] v2) {
		return Math.pow(Math.pow(v2[0]-v1[0], 2)+Math.pow(v2[1]-v1[1], 2),0.5);
	}
	public double[] toTab() {
		double[] v = new double[2] ;
		v[0] = x;
		v[1] = y;
		return v;
		
	}
	
	public boolean compare(Vector v1) {
		if (x == v1.getX() && y== v1.getY()) {
			return true;
		}
		else {
			return false;
		}
		
	}

	//assesseurs
	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	

	
	
}