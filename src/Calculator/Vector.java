package Calculator;

public class Vector {

	public int x;
	public int y;

	

	public Vector(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public Vector addition(Vector v1) {
		Vector v = new Vector(x+v1.getX() , y+v1.getY());
		return v;

	}

	public String toString() {
		return ""+x+","+y;
	}

	public Vector lambda(double l) {
		int nX = (int) Math.round(x*l);
		int nY = (int) Math.round(y*l);
		Vector v = new Vector(nX,nY);
		return v;
	}
	
	public Vector scalar(Vector v1) {
		Vector v = new Vector((int)x*v1.getX(),(int)y*v1.getY()) ;
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

	public boolean compare_intervalle(Vector v1) {
		if (x < v1.getX() + 32 && x > v1.getX() - 32 && y < v1.getY() + 32 && y > v1.getY() - 32) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void symetryX() {
		setX(-x);
	}
	public void symetryY() {
		setY(-y);
	}
	
	public int getSigneX() {
		if (x<0) {
			return(-1);
		}
		else {
			return(1);
		}
	}
	public int getSigneY() {
		if (y<0) {
			return(-1);
		}
		else {
			return(1);
		}
	}
	//assesseurs
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}



}