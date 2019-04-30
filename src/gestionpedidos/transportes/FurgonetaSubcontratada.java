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

public class FurgonetaSubcontratada extends Furgoneta {
	private double eurosPKm = 1;
		
	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		double precio = super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm;
		if(super.getTara() >= 1000){   
			precio *= 1.10; 
		}
	    return precio;
	}
	
	public double getEurosPKm() {
		return eurosPKm;
	}

	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}
}
