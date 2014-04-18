import java.util.ArrayList;
import java.text.*;

public abstract class PhysicsElement {
    private final int myId;

    protected DecimalFormat df = new DecimalFormat("#.##");
    
    protected Vector position;
    protected Vector externalForce;
    protected ArrayList<Vector> externalForces;
    
    {
        /*Inicialización de Variables*/
        position = new Vector();
        externalForce = new Vector();
        // externalForce es la suma de todas las externalForces
        externalForces = new ArrayList<Vector>();
    }
    
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
    
    public void addExternalForce(Vector extF) {
        externalForces.add(extF);
    }
    public void removeExternalForce(Vector extF) {
        externalForces.remove(extF);
    }
}
