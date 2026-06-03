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

    public GrafoSinaptico(Neurona neuronaInicio, Neurona neuronaFinal) {
        this.neuronaInicio = neuronaInicio;
        this.neuronaFinal = neuronaFinal;
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
        return neuronaInicio == null;
    }
    
    public boolean existeNeurona(String id){
        return buscarNeurona(id) != null;
    }
    
    public Neurona buscarNeurona(String id){
        if(isEmpty()){
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
        if (!existeNeurona(id)){
            ListaAdyacencia nuevasConexiones = new ListaAdyacencia();
            Neurona nuevaNeurona = new Neurona(id, true, null, nuevasConexiones);
            
            if (isEmpty()){
                neuronaInicio = nuevaNeurona;
                neuronaFinal = nuevaNeurona;
            } else{
                neuronaFinal.setSiguiente(nuevaNeurona);
                neuronaFinal = nuevaNeurona;
            }
        }
    }
    
    public void agregarSinapsis(String idOrigen, String idDestino, double distancia, String idNeurotransmisor, double k) {
        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);

        if (origen != null && destino != null) {
                ListaAdyacencia listaOrigen = origen.getConexiones();

                if (!listaOrigen.existeAdyacencia(idDestino)) {
                    Sinapsis nuevaSinapsis = new Sinapsis(destino, distancia, idNeurotransmisor, k, null);

                    if (listaOrigen.isEmpty()) {
                        listaOrigen.setPrimeraSinapsis(nuevaSinapsis);
                        listaOrigen.setUltimaSinapsis(nuevaSinapsis);
                    } else {
                        listaOrigen.getUltimaSinapsis().setSiguiente(nuevaSinapsis);
                        listaOrigen.setUltimaSinapsis(nuevaSinapsis);
                    }
                }
            } else {
                System.out.println("No se pudo crear la sinapsis porque la neurona no existe");
            }
    }   
    
    public void eliminarNeurona(String id) {
        if (isEmpty() || existeNeurona(id) == false) return;

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
        if (origen == null || origen.getConexiones().isEmpty())
            return;

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
}
