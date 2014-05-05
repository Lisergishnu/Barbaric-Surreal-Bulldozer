
public class Block extends PhysicsElement implements SpringAttachable, Collisionable{

    //***********
    // VARIABLES
    //***********
    private static int id=0;
    private final double mass;
    private final double side;
    private double delta;

    //Variables Fisicas
    private Vector internalForce;
    private Vector acceleration;
    private Vector speed;
    private Vector next_speed;
    private Vector next_position;
    
    private boolean collision;
    
    {
        /*Inicialización de Variables*/
        position = new Vector();
        internalForce = new Vector();
        acceleration = new Vector();
        speed = new Vector();
        next_speed = new Vector();
        next_position = new Vector();
    }
    
    //**************
    // CONSTRUCTORES
    //**************
    private Block() {
        this(1.0,0.2,0,0);
    }

    public Block(double mass, double side, double pos, double spd) {
        super(id++);
        this.mass = mass;
        this.side = side;
        position.x = pos;
        speed.x = spd;
    }
	
    //*************************
    // METODOS PRIVADOS
    //*************************
    
    private void 
    
    private void updateForces() {
        internalForce.x = 0;
        externalForce.zerify();
        //externalForce = attachedSpring.a_force;
        for(Vector x : externalForces) {
            externalForce.add(x);
        }
    }
    
    //**************************************
    // METODOS OBLIGADOS POR HERENCIA
    //**************************************
	
    public void computeNextState(double delta_t, MyWorld world) {
        Collisionable b;
        //Variable delta_t local, para usar en otras funciones
        delta = delta_t;
        if ((b=world.findCollidingObject(this))!= null) {
            next_speed.x=/*insertar codigo*/;
            next_position.x = position.x;
            collision = true;
        } else {
            next_speed.x = speed.x + (internalForce.x + externalForce.x)*delta_t/mass;
            next_position.x = position.x + speed.x * delta_t;
            collision = false;
        }
    }
    public void updateState(){
        position.x = next_position.x;
        acceleration.x = (next_speed.x - speed.x)/delta;
        speed.x = next_speed.x;
        updateForces();
    }

    public String getDescription(){//revisar
    	return "b" + getId() + "pos\tb" + getId() + "spd\t" + "eF";
    }
    public String getState(){//revisar
        return df.format(position.x) + "\t" + df.format(speed.x) + "\t" + df.format(externalForce.x);
    }
    
    
    //**************************************
    // METODOS OBLIGADOS POR INTERFACE Collisionable
    //***********************************
    
    
    
    //**************************************
    // METODOS OBLIGADOS POR INTERFACE SpringAttachable
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
