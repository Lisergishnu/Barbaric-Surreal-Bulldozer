import java.util.*;

public class Ball extends PhysicsElement implements SpringAttachable{
    //***********
    // VARIABLES
    //***********
    private static int id=0;
    private final double mass;
    private final double radius;
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
    private Ball() {
        this(1.0,0.1,0,0);
    }

    public Ball(double mass, double radius, double pos, double spd) {
        super(id++);
        this.mass = mass;
        this.radius = radius;
        position.x = pos;
        speed.x = spd;
    }

    //*************************
    // METODOS PRIVADOS
    //*************************
    private void updateForces() {
        internalForce.x = 0;
        externalForce.zerify();
        //externalForce = attachedSpring.a_force;
        for(Vector x : externalForces) {
            externalForce.add(x);
        }
    }

    //*************************
    // METODOS PUBLICOS
    //*************************
    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public Vector getSpeed() {
        return speed;
    }

    public Vector getNextPos() {
        return Vector.add(position, speed.times(delta));
    }

    public String getState() {
        return df.format(position.x) + "\t" + df.format(speed.x) + "\t" + df.format(externalForce.x);
    }

    public String getDescription() {
        return "b" + getId() + "pos\tb" + getId() + "spd\t" + "eF";
    }
    
    public void computeNextState(double delta_t, MyWorld world) {
        Ball b;
        //Variable delta_t local, para usar en otras funciones
        delta = delta_t;
        if ((b=world.findCollidingBall(this))!= null) {
            next_speed.x=(speed.x*(mass-b.getMass())+2*b.getMass()*b.getSpeed().x)/(mass+b.getMass());
            next_position.x = position.x;
            collision = true;
        } else {
            next_speed.x = speed.x + (internalForce.x + externalForce.x)*delta_t/mass;
            next_position.x = position.x + speed.x * delta_t;
            collision = false;
        }
    }

    public void updateState() {
        position.x = next_position.x;
        acceleration.x = (next_speed.x - speed.x)/delta;
        speed.x = next_speed.x;
        updateForces();
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
