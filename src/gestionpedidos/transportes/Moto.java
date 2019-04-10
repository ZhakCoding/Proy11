package gestionpedidos.transportes;

public class Moto extends Transporte {
	private double eurosPKm = 2;
		
	public Moto(String codigo, Mapa mapa) {
		this.codigo = codigo;
		this.mapa = mapa;
		// Falta pedir informacion
	}
	
	public double coste(String codOrigen, String codDestino) {
		//TO-DO
	}
}
