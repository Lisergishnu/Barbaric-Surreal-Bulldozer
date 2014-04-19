public class Vector{
	double x;
	double y;
	double z;

	// CONSTRUCTS
	
	public Vector(){
		this(0, 0, 0);
	}
	
	public Vector(double _x, double _y, double _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	// RESTAS
	public static Vector sub(Vector a, Vector b){
		Vector temp = new Vector();
		temp.x = a.x - b.x;
		temp.y = a.y - b.y;
		temp.z = a.z - b.z;
		return temp;
	}
	
	public void sub(Vector b){
		this.x -= b.x;
		this.y -= b.y;
		this.z -= b.z;
	}
	
	// SUMAS
	public static Vector add(Vector a, Vector b){
		Vector temp = new Vector();
		temp.x = a.x + b.x;
		temp.y = a.y + b.y;
		temp.z = a.z + b.z;
		return temp;
	}	
	
	public void add(Vector b){
		this.x += b.x;
		this.y += b.y;
		this.z += b.z;
	}
	
	// MULT
	public Vector times(double b){
		Vector temp = new Vector();
		temp.x = this.x*b;
		temp.y = this.y*b;
		temp.z = this.z*b;
		return temp;
	}

	public double point(Vector b){
		return this.x*b.x + this.y*b.y + this.z*b.z;
	}
	
	public Vector cross(Vector b){
		Vector temp = new Vector();
		temp.x = this.y*b.z - this.z*b.y;
		temp.y = this.z*b.x - this.x*b.z;
		temp.z = this.x*b.y - this.y*b.x;
		return temp;
	}

	// DIV
	public Vector div(double b){
		Vector temp = new Vector();
		temp.x = this.x/b;
		temp.y = this.y/b;
		temp.z = this.z/b;
		return temp;
	}
	
	// MISC
	public Vector dir(){
		Vector temp = new Vector();
		temp.x = (this.x)/this.module();
		temp.y = (this.y)/this.module();
		temp.z = (this.z)/this.module();
		return temp;
	}

	public double module(){
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	// UTILS
	public void update(Vector b){
		this.x = b.x;
		this.y = b.y;
		this.z = b.z;
	}
	
	public void zerify(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public static Vector zero(){
		Vector temp = new Vector();
		return temp;
	}
	
	public static Vector vector(double _x, double _y, double _z){
		Vector temp = new Vector(_x, _y, _z);
		return temp;
	}
}