package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2; 

@Programacion2 (
	nombreAutor1 = "Sergio Duncan",
	apellidoAutor1 = "de Propios Corbo",
	emailUPMAutor1 = "sd.depropios@alumnos.upm.es",
	nombreAutor2 = "Jorge",
	apellidoAutor2 = "del Amo Arrieta", 
	emailUPMAutor2 = "j.delamoa@alumnos.upm.es"
)

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia = 30;
	private static final double EUROS_P_HORA = 40;
		
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
