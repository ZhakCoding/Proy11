package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class Transporte {
	private String codigo;
	private Mapa mapa;
		
	public Transporte(String codigo, Mapa mapa) {
		this.codigo = codigo;
		this.mapa = mapa;
	}
	
	public double coste(String posDestino) {
		//TO-DO
	}
	
	public double coste(String cod1, String cod2) {
		//TO-DO
	}
	
	public Mapa getMapa() {
		return mapa;
	}
}
