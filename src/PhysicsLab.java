import java.util.*;
import java.io.*;

public class PhysicsLab {
    public static void main(String[] args) throws FileNotFoundException {
        double deltaTime = 0;    // [s]
        double endTime = 0;      // [s]
        double samplingTime = 0; // [s]
        if (args.length != 3 && args.length != 0)  {
            System.out.println("usage: java PhysicsLab <delta_time[s]> <end_time[s]> <sampling_time[s]>");
            System.out.println("       java PhysicsLab [for interactive mode]");
            System.exit(-1);
        } else if (args.length == 0) {
            //Si no hay argumentos, generamos una instancia de Scanner
            //que va a parsear el input para obtener los tres
            //datos que se necesitan
            Scanner s = new Scanner(System.in);
            System.out.println("Enter delta time (in seconds): ");
            deltaTime = s.nextDouble();
            System.out.println("Enter end time (in seconds): ");
            endTime = s.nextDouble();
            System.out.println("Enter sampling time (in seconds): ");
            samplingTime = s.nextDouble();
            s.close();
        } else {
            //En caso contrario simplemente tomamos los argumentos de
            //la linea de comandos
            deltaTime = Double.parseDouble(args[0]);    // [s]
            endTime = Double.parseDouble(args[1]);      // [s]
            samplingTime = Double.parseDouble(args[2]); // [s]
        }

        if (deltaTime == 0 || endTime == 0 || samplingTime == 0) {
        //Ningun argumento puede ser cero
            System.out.println("Neither argument can be zero");
            System.exit(-1);
        }

        File outputFile = new File("res/output.csv");
        if (!outputFile.exists()) {
            try {
	          outputFile.getParentFile().mkdirs(); //Crear Directorio
	          outputFile.createNewFile();
	      } catch (IOException e) {
	          System.err.println("Couldn't make file: " + e.getMessage());
	          return; //Terminar programa
	      }
	    }

		PrintStream writer = new PrintStream(outputFile);
		MyWorld world = new MyWorld(System.out,writer);

		double mass = 1.0;      // 1 [kg]
		double radius = 0.1;    // 10 [cm]
		double position = 1.0;  // 1 [m]
		double speed = 0.2;     // 0.5 [m/s]
		//Ball b0 = new Ball(mass, radius, 0, 0);
		Ball b1 = new Ball(mass, radius, 1.5, 1);
		Spring s0 = new Spring(1, 1);
		FixedHook f0 = new FixedHook(0, 0, 0);
		//world.addElement(b0);
		world.addElement(b1);
		world.addElement(s0);
		world.addElement(f0);
		s0.attachEnd(f0);
		s0.attachEnd(b1);

		//Medimos el tiempo de ejecucion de la simulación.
		long startTime = System.nanoTime();
		world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
		float elapsedTime = (System.nanoTime() - startTime) / (float)Math.pow(10,9);
		System.out.println("Simulation ended in "+ elapsedTime + " [s] and was written to res/output.csv.");
		writer.close();
    }
}