package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class Moto extends Transporte {
	private double eurosPKm = 2;
		
	public Moto(String codigo, Mapa mapa) {
		super(codigo, mapa);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		return super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm;
	}
	
	public double getEurosPKm() {
		return eurosPKm;
	}

	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}
}
