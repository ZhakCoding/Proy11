package gestionpedidos;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import queues.NaiveQueue;
import anotacion.Programacion2; 

@Programacion2 (
	nombreAutor1 = "Sergio Duncan",
	apellidoAutor1 = "de Propios Corbo",
	emailUPMAutor1 = "sd.depropios@alumnos.upm.es",
	nombreAutor2 = "Jorge",
	apellidoAutor2 = "del Amo Arrieta", 
	emailUPMAutor2 = "j.delamoa@alumnos.upm.es"
)


public class GestionRepartoLocal {
    private ArrayList<Moto> motosDisponibles;
    private ArrayList<Furgoneta> furgonetasDisponibles;

    private NaiveQueue<Pedido> pedidosEsperandoMoto;
    private NaiveQueue<Pedido> pedidosEsperandoFurgoneta;

    private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
        ArrayList<String> salida = new ArrayList<>();
        for(int i=0; i<disponibles.size(); i++)
            salida.add(salida.size(),((Transporte) disponibles.get(i)).getCodigo());
        return salida;
    }

    private static ArrayList<String[]> getClienteRestauranteList(NaiveQueue<Pedido> pendientes){
        ArrayList<String[]> salida = new ArrayList<>();
        NaiveQueue<Pedido> aux = new NaiveQueue<>();
        while(!pendientes.isEmpty()) {
            Pedido pedido = pendientes.poll();

            salida.add(salida.size(),new String[]{pedido.getCliente().getCodigo(),
            pedido.getRestaurante().getCodigo()});
            aux.add(pedido);
        }
        while (!aux.isEmpty())
            pendientes.add(aux.poll());

        return salida;
    }

    private static String myArrayListToString (ArrayList<?> list){
        String salida = "";
        for(int i=0; i<list.size(); i++){
            salida += " " ;
            if (list.get(i) instanceof String[]){
                String[] item = (String[])list.get(i);
                for(int j=0; j<item.length; j++){
                    salida += item[j] ;
                } 
            }
            else if (list.get(i) instanceof String){
                salida += (String)list.get(i);
            }
        }

        return salida;
    }

    public String getDisponibles(){
        return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator() +
                "Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles)) + System.lineSeparator();
    }

    public String getEsperando(){
        return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto)) + System.lineSeparator() +
                "Pedidos esperando furgoneta:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
    }

    public ArrayList<String> getCodMotosDisponibles(){
        return getCodList(motosDisponibles);
    } 

    public ArrayList<String> getCodFurgoDisponibles(){
        return getCodList(furgonetasDisponibles);
    }

    public ArrayList<String[]> getCodEsperandoMoto(){
        return getClienteRestauranteList(pedidosEsperandoMoto);
    }

    public ArrayList<String[]> getCodEsperandoFurgo(){
        return getClienteRestauranteList(pedidosEsperandoFurgoneta);
    }

    private static final double PESOMAXMOTO = 20;

    public GestionRepartoLocal(){  
        this.motosDisponibles = new ArrayList<>();
        this.furgonetasDisponibles = new ArrayList<>();

        this.pedidosEsperandoFurgoneta = new NaiveQueue<>();
        this.pedidosEsperandoMoto = new NaiveQueue<>();
    }

    //PRE: el transporte no ha sido asignado a ninguna zona
    public void add(Transporte transporte){
        if(transporte instanceof Moto){
            motosDisponibles.add(motosDisponibles.size(), (Moto)transporte);
        }
        else if(transporte instanceof Furgoneta){
            furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta)transporte);
        }
    }

    //PRE: el pedido no tiene asignado ningun transporte
    public void asignarPedido(Pedido pedido){
        if(pedido.getPeso() <= PESOMAXMOTO){
            if(motosDisponibles.size() > 0){
                Moto minimo = motosDisponibles.get(0);
                for(int i = 0; i < motosDisponibles.size(); i++){
                    if(pedido.coste(motosDisponibles.get(i)) < pedido.coste(minimo)){
                        minimo = motosDisponibles.get(i);
                    }
                }
                pedido.setTransporte(minimo);
                motosDisponibles.remove(minimo);
            }
            else{
                pedidosEsperandoMoto.add(pedido);
            }
        }
        else {
            if(furgonetasDisponibles.size() > 0){
                Furgoneta minimo = furgonetasDisponibles.get(0);
                for(int i = 0; i < furgonetasDisponibles.size(); i++){
                    if(pedido.coste(furgonetasDisponibles.get(i)) < pedido.coste(minimo)){
                        minimo = furgonetasDisponibles.get(i);
                    }
                }
                pedido.setTransporte(minimo);
                furgonetasDisponibles.remove(minimo);
            }
            else{
                pedidosEsperandoFurgoneta.add(pedido);
            }
        }
    }

    //PRE: el pedido tiene asignado un transporte
    public void notificarEntregaPedido(Pedido pedido) {
        if(pedido.getTransporte() instanceof Moto){
            if(!pedidosEsperandoMoto.isEmpty()){
                pedidosEsperandoMoto.poll().setTransporte((Moto)pedido.getTransporte());
            }
            else {
                motosDisponibles.add(motosDisponibles.size(), (Moto)pedido.getTransporte());
            }
        }
        else if(pedido.getTransporte() instanceof Furgoneta){
            if(!pedidosEsperandoFurgoneta.isEmpty()){
                pedidosEsperandoFurgoneta.poll().setTransporte((Furgoneta)pedido.getTransporte());
            }
            else {
                furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta)pedido.getTransporte());
            }
        }
    }
}