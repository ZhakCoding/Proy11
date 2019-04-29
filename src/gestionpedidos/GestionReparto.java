package gestionpedidos;

import gestionpedidos.mapa.Mapa;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;

public class GestionReparto {
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;
	
	public GestionReparto(Mapa mapa){
		this.mapa = mapa;
		this.gestoresLocales = new GestionRepartoLocal[4];

		// Creamos los gestores locales
		for(int i = 0; i < this.gestoresLocales.length; i++) {
			this.gestoresLocales[i] = new GestionRepartoLocal();
		}
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}
	
	public String getEstadoGestorLocalNum(int i){
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}

	// Zona 0: X  [0, maxCoordX/2] Y  [0, maxCoordY/2]
	// Zona 1: X  [0, maxCoordX/2] Y  [maxCoordY/2 + 1, maxCoordY]
	// Zona 2: X  [maxCoordX/2 + 1, maxCoordX] Y  [0, maxCoordY/2]
	// Zona 3: X  [maxCoordX/2 + 1, maxCoordX] Y  [maxCoordY/2 + 1, maxCoordY]
	
	
	//PRE: el transporte no ha sido asignado a ninguna zona
	public void addTransporteLocalidad(Transporte transporte) {
		//TO-DO
	}
		
	//PRE: el pedido no tiene asignado ning�n transporte
	public void asignarPedido(Pedido pedido){
		//TO-DO
	}
	
	//PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido){
		//TO-DO
	}
	
}
