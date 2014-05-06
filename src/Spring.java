public class Spring extends PhysicsElement {
    //***********
    // VARIABLES
    //***********
    private static int id=0;
    private final double stiffness;
    
    protected final double restLength;
    private PhysicsElement a_end, b_end;

    private Vector a_force;
    private Vector b_force;

    {
        position = new Vector();
        a_end = null;
        b_end = null;
        a_force = new Vector();
        b_force = new Vector();
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

    private void updateForces(){
    	/*Se usa la función update para evitar que el puntero a_force y b_force cambien de objetivo, 
    	 * ya que en la ArrayList de externalForces de a_end y b_end dejarían de apuntar al mismo objeto
    	 * que a_force y b_force*/
    	a_force.update( Vector.sub(getAendPosition(), getBendPosition()).dir().times((restLength - Vector.sub(getAendPosition(), getBendPosition()).module())*stiffness));
    	b_force.update( a_force.times(-1));
    }

    //*************************
    // METODOS PUBLICOS
    //*************************
    public void attachEnd (PhysicsElement sa) {
    	/*Se agregan las bolas en los extremos y se les agrega la externalForce correspondiente a la 
    	 * fuerza ejercida por el resorte*/
        if(a_end == null){
            a_end = sa;
            a_end.addExternalForce(a_force);
        }
        else if (b_end == null){
        	b_end = sa;
        	b_end.addExternalForce(b_force);
        }
        else{
        	System.out.println("Resorte lleno");
        	return;
        }
        
        sa.attachSpring(this);
    }
    
    private Vector getAendPosition() {
    	if (a_end != null)
            return a_end.getPos();
    	else if (b_end != null)
            return Vector.add(b_end.getPos(), Vector.vector(-restLength, 0, 0));
    	else
    		return Vector.zero();
    }
    
    public Vector getBendPosition() {
    	if (b_end != null)
            return b_end.getPos();
    	else if (a_end != null)
            return Vector.add(a_end.getPos(), Vector.vector(restLength, 0, 0));
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
    	updateForces();
    }

    public String getDescription() {
        return "S"+ getId()+"a\tS" + getId() + "b\tS"+ getId() + "aF\tS"+ getId() + "bF";
    }
    public String getState() {
    	return df.format(getAendPosition().x) + "\t" + df.format(getBendPosition().x) + "\t" + df.format(a_force.x) + "\t" + df.format(b_force.x);
    }
}
