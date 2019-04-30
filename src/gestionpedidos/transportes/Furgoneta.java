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

public abstract class Furgoneta extends Transporte {
    private double tara;
  
    public Furgoneta(String codigo, Mapa mapa, double tara) {
        super(codigo, mapa);
        this.tara = tara;
    }

    public double getTara() {
        return tara;
    }
}
