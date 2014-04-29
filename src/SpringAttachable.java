interface SpringAttachable {
  
	void attachSpring(Spring s);
  
	Vector getPos();
  
	public void addExternalForce(Vector extF);  
  
	public void removeExternalForce(Vector extF);
	
}