package gestionpedidos.transportes;

public class FurgonetaSubcontratada extends Furgoneta {
	private double eurosPKm = 1;
		
	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		//TO-DO
	}
}
