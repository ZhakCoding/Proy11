package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;

public class Pedido {
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;	
	private Transporte transporte;
	private double peso;
	
	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {		
		this.cliente = cliente;
		this.comidas = comidas;
		this.restaurante = restaurante;

		// Calculo del importe y peso
		this.importe = 0;
		this.peso = 0;
		for(int i = 0; i < comidas.length; i++) {
			this.importe += comidas[i].getPrecio();
			this.peso += comidas[i].getPeso();
		}
	}
	
	public double coste(Transporte transporte) {
		return importe + transporte.coste(Restaurante.getCodigo()) + transporte.coste(Restaurante.getCodigo(), Cliente.getCodigo());
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getImporte() {
		return importe;
	}	

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}
}
