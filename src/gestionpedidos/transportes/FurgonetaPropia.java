package gestionpedidos.transportes;

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia = 30;
	private final double EUROS_P_HORA = 40;
		
	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		//TO-DO
	}
}
