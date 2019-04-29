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
	
	
	//PRE: el transporte no ha sido asignado a ninguna zona
	public void addTransporteLocalidad(Transporte transporte) {
		int x = mapa.getPosicion(transporte.getCodigo()).getX();
		int y = mapa.getPosicion(transporte.getCodigo()).getY();
		int maxCoordX = mapa.getMaxCoordX();
		int maxCoordY = mapa.getMaxCoordY();

		if(x <= maxCoordX/2){
			// Zona 0
			if(y <= maxCoordY/2)
				gestoresLocales[0].add(transporte);

			// Zona 1
			else
				gestoresLocales[1].add(transporte);
		}
		else {
			// Zona 2
			if(y <= maxCoordY/2)
				gestoresLocales[2].add(transporte);

			// Zona 3
			else
				gestoresLocales[3].add(transporte);
		}
	}
		
	//PRE: el pedido no tiene asignado ningun transporte
	public void asignarPedido(Pedido pedido){
		int x = mapa.getPosicion(pedido.getCliente().getCodigo()).getX();
		int y = mapa.getPosicion(pedido.getCliente().getCodigo()).getY();
		int maxCoordX = mapa.getMaxCoordX();
		int maxCoordY = mapa.getMaxCoordY();

		if(x <= maxCoordX/2){
			// Zona 0
			if(y <= maxCoordY/2)
				gestoresLocales[0].asignarPedido(pedido);

			// Zona 1
			else
				gestoresLocales[1].asignarPedido(pedido);
		}
		else {
			// Zona 2
			if(y <= maxCoordY/2)
				gestoresLocales[2].asignarPedido(pedido);

			// Zona 3
			else
				gestoresLocales[3].asignarPedido(pedido);
		}
	}
	
	//PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido){
		int x = mapa.getPosicion(pedido.getCliente().getCodigo()).getX();
		int y = mapa.getPosicion(pedido.getCliente().getCodigo()).getY();
		int maxCoordX = mapa.getMaxCoordX();
		int maxCoordY = mapa.getMaxCoordY();

		if(x <= maxCoordX/2){
			// Zona 0
			if(y <= maxCoordY/2)
				gestoresLocales[0].notificarEntregaPedido(pedido);

			// Zona 1
			else
				gestoresLocales[1].notificarEntregaPedido(pedido);
		}
		else {
			// Zona 2
			if(y <= maxCoordY/2)
				gestoresLocales[2].notificarEntregaPedido(pedido);

			// Zona 3
			else
				gestoresLocales[3].notificarEntregaPedido(pedido);
		}
	}
	
}
