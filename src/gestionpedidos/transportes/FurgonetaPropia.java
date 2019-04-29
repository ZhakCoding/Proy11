package gestionpedidos.transportes;

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia = 30;
	private final double EUROS_P_HORA = 40;
		
	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		double precio=0;
		if(super.getTara()<500){   
			precio = super.getMapa().distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA / velocidadMedia;
			}
		else{precio = super.getMapa().distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA / velocidadMedia *1.10; }
	    return precio;
	}
}
