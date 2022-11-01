package ar.edu.unlp.info.oo1.ejercicio19_mercadoDeObjetos;

public class Pedido {
	private Usuario cliente;
	private Producto producto;
	private int cantidad;
	private String formaDePago;
	private String formaDeEnvio;

	public Pedido(Usuario cliente, Producto producto, int cantidad, String formaDePago, String formaDeEnvio) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.formaDePago = formaDePago;
		this.formaDeEnvio = formaDeEnvio;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public String getFormaDeEnvio() {
		return formaDeEnvio;
	}

	private double costoProducto() {
		if (this.formaDePago == "contado")
			return this.cantidad * this.producto.getPrecio();
		else
			return (this.cantidad * this.producto.getPrecio()) * 1.2;
	}

	private double costoEnvio() {
		switch (this.formaDeEnvio) {
		case "retirar en el correo":
			return 50;

		case "express a domicilio":
			return 0.5 * 100;

		default:
			return 0;
		}

	}

	public double calcularCostoTotal() {
		return this.costoProducto() + this.costoEnvio();
	}

}
