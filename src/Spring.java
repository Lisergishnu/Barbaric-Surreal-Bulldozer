public class Spring extends PhysicsElement {
    //***********
    // VARIABLES
    //***********
    private static int id=0;
    private final double stiffness;
    
    protected final double restLength;
    protected Ball a_end, b_end;

    public Vector a_force;
    public Vector b_force;

    {
        a_end = b_end = null;
        a_force = new Vector(6,6,6);
        b_force = new Vector(6,6,6);
    }
    //**************
    // CONSTRUCTORES
    //**************
    private Spring() {  // nobody can create a block without state
        this(0,0);
    }
    
    public Spring(double restLength, double stiffness) {
        super(id++);
        this.restLength = restLength;
        this.stiffness = stiffness;
    }
    
    //*************************
    // METODOS PRIVADOS
    //*************************
    

    //*************************
    // METODOS PUBLICOS
    //*************************
    public void attachEnd (Ball sa) {
    	/*TODO: addExternalForce() esta pasando el valor, no el puntero*/
        if(a_end == null){
            a_end = sa;
            a_end.addExternalForce(a_force);
        }
        else if (b_end == null){
        	b_end = sa;
        	b_end.addExternalForce(b_force);
        }
        else
        	System.out.println("Resorte lleno");
        
        sa.attachSpring(this);
    }
    
    private Vector getAendPosition() {
    	if (a_end != null)
            return a_end.getPos();
    	else if (b_end != null)
            return b_end.getPos().add(restLength);
    	else
    		return Vector.zero();
    }
    
    public Vector getBendPosition() {
    	if (b_end != null)
            return b_end.getPos();
    	else if (a_end != null)
            return a_end.getPos().add(restLength);
    	else
    		return Vector.zero();
    }
    
    public Vector getForce() {
        Vector force = new Vector();
        if ((a_end == null) && (b_end == null))
            return force;
        else
        	return force;
    }    
    
    public void computeNextState(double delta_t, MyWorld w) {
    }
    public void updateState() {
    	position = Vector.add(getAendPosition() , getBendPosition()).times(0.5);
    	a_force = Vector.sub(getAendPosition(), getBendPosition()).dir().times((restLength - Vector.sub(getAendPosition(), getBendPosition()).module())*stiffness);
    	b_force = Vector.sub(getBendPosition(), getAendPosition()).dir().times((restLength - Vector.sub(getAendPosition(), getBendPosition()).module())*stiffness);
    }

    public String getDescription() {
        return "S"+ getId()+"a\tS" + getId() + "b\tS"+ getId() + "aF\tS"+ getId() + "bF";
    }
    public String getState() {
    	return df.format(getAendPosition().x) + "\t" + df.format(getBendPosition().x) + "\t" + df.format(a_force.x) + "\t" + df.format(b_force.x);
    }
}
