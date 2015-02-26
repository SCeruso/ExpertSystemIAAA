package sistemaexperto.practicaiaaa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.swing.JFrame;

public class LaunchSimulacion {
	public static void main(String[] args) {
		Simulacion sdc = new Simulacion(18000);
		redirectOutput(args);
		
		//sdc.simular();
		
		 List<Double> valores=sdc.simular();
		 JFrame f = new JFrame();
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 GraphingData grafica = new GraphingData();
		 double[] valoresDoble = new double[valores.size()];
		 for (int i = 0; i < valoresDoble.length; i++) {
		 valoresDoble[i] = valores.get(i);
		 }
		 grafica.setData(valoresDoble);
		 f.add(grafica);
		 f.setSize(840,400);
		 f.setLocation(200,200);
		 f.setVisible(true);
	}

	static PrintStream openStreamToFile(String filename) {
		try {
			return new PrintStream(new FileOutputStream(filename));
		} catch (IOException e) {
			System.err.println("Error abriendo el fichero");
			System.exit(-1);
		}
		return null;
	}
	static void redirectOutput(String[] args){
		if (args.length > 0) {
			PrintStream output = openStreamToFile(args[0]);
			System.setOut(output);
		}
	}
}
