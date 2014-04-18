import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class MyWorld {
    //***********
    // VARIABLES
    //***********
    private final double COLLISION_THRESHOLD = 0.05;
    private PrintStream out;
    
    protected DecimalFormat df = new DecimalFormat("#.##");
    
    // Listas de elementos del Mundo
    private ArrayList<PhysicsElement> elements;
    private ArrayList<Ball> balls;
    
    //**************
    // CONSTRUCTORES
    //**************
    public MyWorld() {
        this(System.out);// delta_t= 0.1[ms] and refreshPeriod=200 [ms]
    }
    public MyWorld(PrintStream output) {
        out = output;
        elements = new ArrayList<PhysicsElement>();
        balls = new ArrayList<Ball>();
    }

    //*************************
    // METODOS PRIVADOS
    //*************************
    
    //*************************
    // METODOS PUBLICOS
    //*************************
    public void addElement(PhysicsElement e) {
        elements.add(e);
    }

    public void addElement(Ball b) {
        elements.add(b);
        balls.add(b);
    }

    public void printStateDescription() {
        String s ="Time\t";
        for (PhysicsElement e:elements)
            s+=e.getDescription() + "\t";
        out.println(s);
    }

    public void printState(double t) {
        String s = "" + df.format(t);
        for (PhysicsElement e:elements)
            s+="\t" + e.getState();
        out.println(s);
    }

    public void simulate (double delta_t, double endTime, double samplingTime) { // simulate passing time
        double t=0;
        printStateDescription();
        printState(t);
        while (t<endTime) {
            for(double nextStop=t+samplingTime; t<nextStop; t+=delta_t) {
                for (PhysicsElement e : elements)// compute each element next state based on current global state
                    e.computeNextState(delta_t,this); // compute each element next state based on current global state
                for (PhysicsElement e : elements)// for each element update its state.
                    e.updateState();// update its state
            }
            printState(t);
        }
    }

    public Ball findCollidingBall(Ball me) {
        Ball collider_ball = null;
        // Busco la primera bola que entre en contacto con "me"
        for(Ball x : balls) {
            // No colisionar con mi mismo
            if( x != me ) {
                // Distancia entre centros menor que la suma de los radios + un threshold (estan muy cerca)
                if(Math.abs(x.getPos().x - me.getPos().x) <= COLLISION_THRESHOLD + x.getRadius() + me.getRadius()) {
                    // ... y además se acercarán aún más en el siguiente delta_t, devolver la bola colisionante
                    if(Math.abs((x.getNextPos().x - me.getNextPos().x)) < Math.abs(x.getPos().x-me.getPos().x))
                        collider_ball = x;
                    break;
                }
            }
        }
        return collider_ball;
    }
}
