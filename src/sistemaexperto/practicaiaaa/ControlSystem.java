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
	private final int valveLimit = 100;
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

	/**
	 * Calcula el siguiente estado de apertura de la valvula siguiendo las reglas.
	 */
	public void control () {
		double num = 0;
		double div = 0;
		double aux;
		
		for (int i = -25; i < valveLimit; i+=5) {
			 aux = Math.max(Math.max(Math.min(errorNegativo(tank.getError()), valvulaCerrada(i)), Math.min(errorCero(tank.getError()), valvulaCerrada(i))), Math.min(errorPositivo(tank.getError()), valvulaAbierta(i)));
			 num += aux * i;
			 div += aux;
		}
		inValve.setApertura(num / div);
	}
	/**
	 * Simula el paso de un segundo modificando el nivel del agua.
	 */
	public void nextSecond() {
		tank.addWaterToTank(inValve.getWaterFlow());
		tank.addWaterToTank(-outValve.getWaterFlow());
	}
	
	private double errorNegativo(double error) {
		double v;
		
		if (error <= -10 && error >= -15)
			v = 1;
		else if (error <= 0 && error >= -10)
			v = -error / 10;
		else 
			v = 0;
		return v;
	}
	
	private double errorCero(double error) {
		double v;
		
		if (error <= 0 && error >= 5)
			v = (5 + error) / 5;
		else if (error <= 5 && error >= 0)
			v =  (5 - error) / 5;
		else 
			v = 0;
		return v;
	}
	
	private double errorPositivo(double error) {
		double v;
		
		if (error <= 10 && error >= 0)
			v = error / 10;
		else if (error <= 15 && error >= 10)
			v = 1;
		else 
			v = 0;
		return v;
	}	
	
	private double valvulaAbierta (double apertura) {
		double v;
		
		if (apertura <= 50 && apertura >= 0)
			v = apertura / 50;
		else if (apertura >= 50)
			v = 1;
		else 
			v = 0;
		return v;
	}
	
	private double valvulaCerrada (double apertura) {
		double v;
		
		if (apertura <= 0 && apertura >= -25)
			v = (25 + apertura) / 25;
		else if (apertura >= 0 && apertura <= 25)
			v = (25 - apertura) / 25;
		else 
			v = 0;
		return v;
	}
}
