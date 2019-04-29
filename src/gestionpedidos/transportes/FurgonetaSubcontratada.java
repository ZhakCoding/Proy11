package gestionpedidos.transportes;

public class FurgonetaSubcontratada extends Furgoneta {
	private double eurosPKm = 1;
		
	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		double precio=0;
		if(super.getTara()<1000){   
			precio = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm; 
			}
		else{precio = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm*1.10; }
	    return precio;
	}
	}
}
