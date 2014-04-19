public class FixedHook extends PhysicsElement{
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
    
	public Vector getPos() {
	    return position;
	}
}
