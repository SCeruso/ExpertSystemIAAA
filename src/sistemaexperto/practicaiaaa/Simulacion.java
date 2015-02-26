package sistemaexperto.practicaiaaa;

import java.util.ArrayList;
import java.util.List;


/**
 * @param t
 *            Tanque a controlar.
 * @param inV
 *            Valvula de entrada
 * @param oV
 *            Valvula de salida
 */
public class Simulacion {
	private int time;
	
	public Simulacion(int t) {
		time = t;
	}
	public List<Double> simular() {
		List<Double> list = new ArrayList<Double>();
		ControlSystem sistema = new ControlSystem(new Tank(10.0, 20.0, 19.0),
				new Valve(0.4, 0.5), new Valve(0.1, 1.0));
			System.out.println("Tiempo(S), Altura(m)");
		for (int i = 0; i < time; i++) {
			sistema.control();
			list.add(sistema.getValorActual());
			System.out.println(i+ "," + sistema.getValorActual());
			sistema.nextSecond();
		}
		return list;
	}
}
