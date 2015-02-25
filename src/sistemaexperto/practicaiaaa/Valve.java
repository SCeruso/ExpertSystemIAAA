package sistemaexperto.practicaiaaa;
/**
*
* @author Sabato Ceruso
* @author Javier Martin Hernandez
*
*/
public class Valve {

	private double vMax;
	private double apertura;
	
	/**
	 * 
	 * @param v Velocidad maxima de entrada o salida, depende del signo.
	 * @param ap Apertura de la valvula.
	 */
	public Valve(double v, double ap) {
		vMax = v;
		apertura = ap;
	}
	
	/**
	 * 
	 * @param ap Nueva apertura de la valvula.
	 */
	public void setApertura(double ap) { apertura = ap; }
	/**
	 * 
	 * @return Cantidad de agua que pasa por la valvula.
	 */
	public double getWaterFlow() { return apertura * vMax; }

}
