package ar.edu.unlp.info.oo1.ejercicio9_cuentosConGanchos;

public class CuentaCorriente extends Cuenta{
	private double saldoNegativo;
	
	
	public CuentaCorriente() {
		super();
		this.saldoNegativo = 0;
	}

	public double getSaldoNegativo() {
		return saldoNegativo;
	}

	public void setSaldoNegativo(double saldoNegativo) {
		this.saldoNegativo = saldoNegativo;
	}



	@Override
	public boolean puedeExtraer(double monto) {
		if (monto <= getSaldo() + this.getSaldoNegativo()) {
			this.setSaldoNegativo(this.getSaldoNegativo() - monto);
			return true;
			
		}
		return false;
	}
	
}
