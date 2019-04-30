package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2; 

@Programacion2 (
	nombreAutor1 = "Sergio Duncan",
	apellidoAutor1 = "de Propios Corbo",
	emailUPMAutor1 = "sd.depropios@alumnos.upm.es",
	nombreAutor2 = "Jorge",
	apellidoAutor2 = "del Amo Arrieta", 
	emailUPMAutor2 = "j.delamoa@alumnos.upm.es"
)

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
        return importe + transporte.coste(restaurante.getCodigo()) + transporte.coste(restaurante.getCodigo(), cliente.getCodigo());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getImporte() {
        return importe;
    } 

    public double getPeso() {
        return peso;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
}
