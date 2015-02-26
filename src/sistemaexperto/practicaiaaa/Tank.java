package sistemaexperto.practicaiaaa;
/**
 *
 * @author Sabato Ceruso
 * @author Javier Martin Hernandez
 *
 */

public class Tank {
	private double valorDeseado;
	private double valorActual;
	private double sideSize;
	
	/**
	 * 
	 * @param side Lado de la base del tanque. La base es cuadrada.
	 * @param deseado Altura deseada que tenga el agua.
	 * @param actual Altura actual del agua.
	 */
	public Tank(double side, double deseado, double actual) {
		valorDeseado = deseado;
		valorActual = actual;
		sideSize = side;
	}
	
	/**
	 * 
	 * @return Error, diferencia entre altura deseada y actual.
	 */
	public double getError() { return valorDeseado - valorActual; }
	/**
	 * 
	 * @param water Metros cubicos de agua que entra al tanque, si es negativa será cantidad de agua que sale.
	 */
	
	public void addWaterToTank(double water) { 
		valorActual += ( water / (sideSize*sideSize));
	}
	
	/**
	 * @return the valorActual
	 */
	public double getValorActual() {
		return valorActual;
	}
	

}
