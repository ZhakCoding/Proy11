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

public abstract class Transporte {
    private String codigo;
    private Mapa mapa;

    public Transporte(String codigo, Mapa mapa) {
        this.codigo = codigo;
        this.mapa = mapa;
    }

    public double coste(String codPosDestino) {
        return coste(this.codigo, codPosDestino);
    }

    public abstract double coste(String codPosOrigen, String codPosDestino);

    public Mapa getMapa() {
        return mapa;
    }

    public String getCodigo() {
        return codigo;
    }

}
