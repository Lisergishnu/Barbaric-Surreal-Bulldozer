public class FixedHook extends PhysicsElement implements SpringAttachable{
    //***********
    // VARIABLES
    //***********
    private static int id=0;
    private final Vector position;

    //**************
    // CONSTRUCTORES
    //**************
    private FixedHook() {  // nobody can create a block without state
        this(0, 0, 0);
    }
    
    public FixedHook(double _x, double _y, double _z) {
        super(id++);
        this.position = new Vector(_x, _y, _z);
    }
    
    //*************************
    // METODOS PRIVADOS
    //*************************
    

    //*************************
    // METODOS PUBLICOS
    //*************************

    public void computeNextState(double delta_t, MyWorld world){
    	
    }
    public void updateState(){
    	
    }

    public String getDescription(){
    	return "f" + getId();
    }
    public String getState(){
    	return df.format(position.x);
    }
    
    //**************************************
    // METODOS OBLIGADOS POR INTERFACE
    //**************************************
    public void addExternalForce(Vector extF) {
        externalForces.add(extF);
    }
    
    public void removeExternalForce(Vector extF) {
        externalForces.remove(extF);
    }

    public void attachSpring(Spring spring) {
        attachedSpring = spring;
    }
    
    public Vector getPos() {
        return position;
    }
    
	
}
