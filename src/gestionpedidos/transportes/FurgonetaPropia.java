package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia = 30;
	private final double EUROS_P_HORA = 40;
		
	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		double precio = super.getMapa().distancia(codPosOrigen, codPosDestino) * EUROS_P_HORA / velocidadMedia;
		if(super.getTara() >= 500){   
			precio *= 1.10;
		}
	    return precio;
	}
	
	public double getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(double velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}
}
