package sistemaexperto.practicaiaaa;
/**
*
* @author Sabato Ceruso
* @author Javier Martin Hernandez
*
*/
public class ControlSystem {
	private Tank tank;
	private Valve inValve;
	private Valve outValve;
	
	/**
	 * @param t Tanque a controlar.
	 * @param inV Valvula de entrada
	 * @param oV Valvula de salida
	 */
	public ControlSystem(Tank t, Valve inV, Valve oV) {
		tank = t;
		inValve = inV;
		outValve = oV;
	}

}
