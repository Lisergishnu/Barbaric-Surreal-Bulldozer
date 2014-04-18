public class Vector{
	double x;
	double y;
	double z;
	
	public static Vector sub(Vector a, Vector b){
		Vector temp = new Vector();
		temp.x = a.x - b.x;
		temp.y = a.y - b.y;
		temp.z = a.z - b.z;
		return temp;
	}

	public Vector sub(double b){
		Vector temp = new Vector();
		temp.x = this.x - b;
		temp.y = this.y - b;
		temp.z = this.z - b;
		return temp;
	}
	
	public static Vector add(Vector a, Vector b){
		Vector temp = new Vector();
		temp.x = a.x + b.x;
		temp.y = a.y + b.y;
		temp.z = a.z + b.z;
		return temp;
	}	
	
	public Vector add(double b){
		Vector temp = new Vector();
		temp.x = this.x + b;
		temp.y = this.y + b;
		temp.z = this.z + b;
		return temp;
	}
	
	public Vector times(double b){
		Vector temp = new Vector();
		temp.x = this.x*b;
		temp.y = this.y*b;
		temp.z = this.z*b;
		return temp;
	}

	public Vector div(double b){
		Vector temp = new Vector();
		temp.x = this.x/b;
		temp.y = this.y/b;
		temp.z = this.z/b;
		return temp;
	}
	
	public Vector dir(){
		Vector temp = new Vector();
		temp.x = (this.x)/this.module();
		temp.y = (this.y)/this.module();
		temp.z = (this.z)/this.module();
		return temp;
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
	
	public Vector(){
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector(float _x, float _y, float _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	public float module(){
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
}