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
