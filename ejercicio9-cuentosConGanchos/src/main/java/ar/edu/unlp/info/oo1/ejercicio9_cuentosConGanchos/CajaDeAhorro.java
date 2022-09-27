package ar.edu.unlp.info.oo1.ejercicio9_cuentosConGanchos;

public class CajaDeAhorro extends Cuenta{

	@Override
	public boolean puedeExtraer(double monto) {
		return this.getSaldo() >= monto*1.2;
	}
	
	public void extraerSinControlar(double monto) {
		super.extraerSinControlar(monto*1.2); 
	}
	
}
