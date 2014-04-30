import java.util.ArrayList;
import java.text.*;

public abstract class PhysicsElement {
    private final int myId;

    // Variables Fisicas
    protected Vector position;
    protected Vector externalForce;
    protected ArrayList<Vector> externalForces;

    // Objetos Asociados
    protected Spring attachedSpring;
    {
        attachedSpring = null;
	    externalForce = new Vector();
	    // externalForce es la suma de todas las externalForces
	    externalForces = new ArrayList<Vector>();
    }
    
    protected DecimalFormat df = new DecimalFormat("#.##");
    
    protected PhysicsElement( int id) {
        myId = id;
    }
    protected int getId() {
        return myId;
    }
    //Extraidos desde la clase derivada
    public abstract void computeNextState(double delta_t, MyWorld world);
    public abstract void updateState();

    public abstract String getDescription();
    public abstract String getState();



    /*
     * comentado debido a implementacion de interface
     * 
     * 
    public Vector getPos() {
        return position;
    }
    
    public void addExternalForce(Vector extF) {
        externalForces.add(extF);
    }
    
    public void removeExternalForce(Vector extF) {
        externalForces.remove(extF);
    }

    public void attachSpring(Spring spring) {
        attachedSpring = spring;
    }
    */
}
