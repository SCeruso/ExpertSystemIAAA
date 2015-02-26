package sistemaexperto.practicaiaaa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class LaunchSimulacion {
	public static void main (String[] args){
		Simulacion sdc = new Simulacion(1000);
		if(args.length>0){
			System.out.println("el nombre del fichero es:" + args[0]);
			PrintStream output = openStreamToFile(args[0]);
			System.setOut(output);
		}
		sdc.simular();
	}
	static PrintStream openStreamToFile(String  filename){
		try{
		return new PrintStream(new FileOutputStream(filename));
		}catch(IOException e){
			System.err.println("Error abriendo el fichero");
			System.exit(-1);
		}
		return null;
	}
}
