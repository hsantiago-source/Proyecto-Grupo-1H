/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurona;
import Entidades.Sinapsis;

/**
 * 
 * @author hsantiago
 */
public class GrafoSinaptico {
    private Neurona neuronaInicio;
    private Neurona neuronaFinal;

    public GrafoSinaptico() {
        this.neuronaInicio = null;
        this.neuronaFinal = null;
    }

    public Neurona getNeuronaInicio() {
        return neuronaInicio;
    }

    public void setNeuronaInicio(Neurona neuronaInicio) {
        this.neuronaInicio = neuronaInicio;
    }

    public Neurona getNeuronaFinal() {
        return neuronaFinal;
    }

    public void setNeuronaFinal(Neurona neuronaFinal) {
        this.neuronaFinal = neuronaFinal;
    }
    


    public boolean isEmpty(){
        if(neuronaInicio == null){
            return true;
        }
        return false;
    }
    
    public boolean existeNeurona(String id){
        if (buscarNeurona(id) != null){
            return true;
        }
        return false;
    }
    
    public Neurona buscarNeurona(String id){
        if(isEmpty() == true){
            return null;
        } else{
            Neurona actual = neuronaInicio;
            while (actual != null){ 
                if (actual.getId().equals(id)){
                    return actual;
                }
                actual = actual.getSiguiente();
            }
        } return null;
    }
    
    public void agregarNeurona(String id){
        if (existeNeurona(id) == false){
            Neurona nuevaNeurona = new Neurona(id);
            
            if (isEmpty() == true){
                neuronaInicio = nuevaNeurona;
                neuronaFinal = nuevaNeurona;
            } else{
                neuronaFinal.setSiguiente(nuevaNeurona);
                neuronaFinal = nuevaNeurona;
            }
        }
    }
    
    public String agregarSinapsis(String idOrigen, String idDestino, double distancia, String idNeurotransmisor, double k) {
        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);

        if (origen != null && destino != null) {
                ListaAdyacencia listaOrigen = origen.getConexiones();

                if (listaOrigen.existeAdyacencia(idDestino) == false) {
                    Sinapsis nuevaSinapsis = new Sinapsis(destino, distancia, idNeurotransmisor, k);

                    if (listaOrigen.isEmpty() == true) {
                        listaOrigen.setPrimeraSinapsis(nuevaSinapsis);
                        listaOrigen.setUltimaSinapsis(nuevaSinapsis);
                    } else {
                        listaOrigen.getUltimaSinapsis().setSiguiente(nuevaSinapsis);
                        listaOrigen.setUltimaSinapsis(nuevaSinapsis);
                    }
                }
            } else {
                return "No se pudo crear la sinapsis porque la neurona no existe";
            }
        return "Sinapsis creada exitosamente";
    }   
    
    public void eliminarNeurona(String id) {
        if (isEmpty() == true || existeNeurona(id) == false) {
            return;
        }

        if (neuronaInicio.getId().equals(id)) {
            neuronaInicio = neuronaInicio.getSiguiente();
            if (neuronaInicio == null){
                neuronaFinal = null;}
        } else {
            Neurona actual = neuronaInicio;
            while (actual.getSiguiente() != null && !actual.getSiguiente().getId().equals(id)) {
                actual = actual.getSiguiente();
            }
            if (actual.getSiguiente() != null) {
                if (actual.getSiguiente() == neuronaFinal) {
                    neuronaFinal = actual;
                }
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            }
        }

        Neurona actual = neuronaInicio;
        while (actual != null) {
            eliminarSinapsis(actual.getId(), id);
            actual = actual.getSiguiente();
        }
    }
    
    public void eliminarSinapsis(String idOrigen, String idDestino) {
        Neurona origen = buscarNeurona(idOrigen);
        if (origen == null || origen.getConexiones().isEmpty()){
           return;
        }

        ListaAdyacencia lista = origen.getConexiones();
        Sinapsis actual = lista.getPrimeraSinapsis();

        if (actual.getDestino().getId().equals(idDestino)) {
            lista.setPrimeraSinapsis(actual.getSiguiente());
            if (lista.getPrimeraSinapsis() == null) {
                lista.setUltimaSinapsis(null);
            }
        } else {
            while (actual.getSiguiente() != null && !actual.getSiguiente().getDestino().getId().equals(idDestino)) {
                actual = actual.getSiguiente();
            }
            if (actual.getSiguiente() != null) {
                if (actual.getSiguiente() == lista.getUltimaSinapsis()) {
                    lista.setUltimaSinapsis(actual);
                }
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            }
        }
    }
    

    //ENCOLAR o APILAR
    public void insertFinal(Neurona dato) {
        Neurona clon = new Neurona(dato.getId());
        
        if (isEmpty() == true) {
            neuronaInicio = clon;
            neuronaFinal = clon;
        } else {
            neuronaFinal.setSiguiente(clon);
            neuronaFinal = clon;
        }
    }

    // DESENCOLAR 
    public void deleteBegin() {
        if (!isEmpty() == true) {
            Neurona extraida = neuronaInicio;
            neuronaInicio = neuronaInicio.getSiguiente();
            
            if (neuronaInicio == null) {
                neuronaFinal = null;
            }
            extraida.setSiguiente(null); 
        }
    }

    // DESAPILAR
    public void deleteFinal() {
        if (isEmpty() == true){
            return;
        }

        if (neuronaInicio == neuronaFinal) {
            neuronaInicio = null;
            neuronaFinal = null;
        } else {
            Neurona actual = neuronaInicio;
            while (actual.getSiguiente() != neuronaFinal) {
                actual = actual.getSiguiente();
            }
            
            actual.setSiguiente(null); 
            neuronaFinal = actual;     
        }
    }
    
    public String mostrarListaNeuronas() {
        if (isEmpty() == true) {
            return "No hay neuronas registradas en la red en este momento.\n";
        }

        String lista = "";
        lista += "--- NEURONAS EN LA RED ---\n\n";
        
        Neurona actual = neuronaInicio;
        int contador = 0;

        while (actual != null) {
            lista += "Neurona ID: " + actual.getId() + "\n";
            contador++;
            actual = actual.getSiguiente();
        }

        if (contador == 0) {
            return "Todas las neuronas han sido eliminadas de la red.\n";
        }

        return lista;
    }

    public String mostrarListaSinapsis() {
        if (isEmpty() == true) {
            return "No hay sinapsis porque la red está vacía.\n";
        }

        String lista = "";
        lista += "--- CONEXIONES SINÁPTICAS ---\n\n";
        
        Neurona actual = neuronaInicio;
        boolean haySinapsis = false;

        while (actual != null) {
            
            Sinapsis sinapsisActual = actual.getConexiones().getPrimeraSinapsis();
                
            while (sinapsisActual != null) {
                    
                Neurona destino = sinapsisActual.getDestino();
                    
                lista += "Origen: "  + actual.getId() +  " ->  " + "Destino: " + destino.getId()  + " / Químico: " + sinapsisActual.getIdNeurotransmisor() +" / d: " + sinapsisActual.getDistancia() + "\n";
                        
                haySinapsis = true;
                sinapsisActual = sinapsisActual.getSiguiente();
            }
            
            actual = actual.getSiguiente();
        }

        if (haySinapsis == false) {
            return "No existen conexiones activas entre las neuronas.\n";
        }

        return lista;
    }
}
