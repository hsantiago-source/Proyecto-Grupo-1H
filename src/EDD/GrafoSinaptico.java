/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurona;
import Entidades.Sinapsis;

/**
 * Esta clase representa el grafo teniendo la red neuronal inicial y final tratandolo como una lista
 * @author hsantiago
 */
public class GrafoSinaptico {
    private Neurona neuronaInicio;
    private Neurona neuronaFinal;

    /**
     * Constructor de la clase 
     */
    public GrafoSinaptico() {
        this.neuronaInicio = null;
        this.neuronaFinal = null;
    }

    /**
     * Para sacar la primera neurona de la lista.
     * @return La neurona del inicio.
     */
    public Neurona getNeuronaInicio() {
        return neuronaInicio;
    }

    /**
     * Para setear la primera neurona.
     * @param neuronaInicio La neurona inicial
     */
    public void setNeuronaInicio(Neurona neuronaInicio) {
        this.neuronaInicio = neuronaInicio;
    }

    /**
     * Para ver cuál es la última neurona.
     * @return La neurona del final.
     */
    public Neurona getNeuronaFinal() {
        return neuronaFinal;
    }

    /**
     * Para setear la neurona final
     * @param neuronaFinal La neurona que va para el final.
     */
    public void setNeuronaFinal(Neurona neuronaFinal) {
        this.neuronaFinal = neuronaFinal;
    }
    

    /**
     * Revisa si el grafo esta vacío.
     * @return true si no hay nada, false si ya le metiste algo.
     */
    public boolean isEmpty(){
        if(neuronaInicio == null){
            return true;
        }
        return false;
    }
    
    /**
     * Revisa si una neurona existe en el grafo.
     * @param id El ID de la neurona que quieres ver si está.
     * @return true si la encuentra, false si no la encuentra.
     */
    public boolean existeNeurona(String id){
        if (buscarNeurona(id) != null){
            return true;
        }
        return false;
    }
    
    /**
     * Busca una neurona por su ID y te la trae.
     * @param id El ID de la neurona que andas buscando.
     * @return La neurona si la consigue, o null si no existe.
     */
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
    
    /**
     * Mete una neurona nuevecita al final del grafo, pero solo si no estaba ya ahí.
     * @param id El nombre o ID para la nueva neurona.
     */
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
    
    /**
     * Enlaza una conexión (sinapsis) desde una neurona a otra.
     * @param idOrigen De dónde sale la conexión.
     * @param idDestino A dónde llega.
     * @param distancia Qué tan lejos están.
     * @param idNeurotransmisor El id del neurotransmisor
     * @param k El coeficiente ese de eficiencia.
     * @return Un String diciendo si se armó la sinapsis fino o si falló algo.
     */
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
    
    /**
     * Borra una neurona del grafo y de paso tumba todas las conexiones que le llegaban.
     * @param id El ID de la neurona que vas a eliminar.
     */
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
    
    /**
     * Borra la conexión directa entre dos neuronas. 
     * @param idOrigen La neurona de donde salía el puente.
     * @param idDestino La neurona a donde llegaba.
     */
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
    

    /**
     * Mete una copia de la neurona al final.
     * Esto es más que todo para hacer la cola en los algoritmos de bfs
     * @param dato La neurona que vas a encolar.
     */
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

    /**
     * Saca a la primera neurona de la fila. 
     * Lo vas a usar seguro para desencolar en el BFS.
     */
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

    /**
     * Vuela la última neurona de la lista (desapila).
     * Útil para cuando estés haciendo el DFS.
     */
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
    
    /**
     * Revisa a ver si consigue la conexión entre estas dos neuronas y te la devuelve.
     * @param idOrigen La que manda.
     * @param idDestino La que recibe.
     * @return La sinapsis si está, o null si no hay nada.
     */    
    public Sinapsis buscarSinapsis(String idOrigen, String idDestino) {
        Neurona origen = buscarNeurona(idOrigen);
        
        if (origen == null || origen.getConexiones().isEmpty() == true) {
            return null;
        }

        Sinapsis actual = origen.getConexiones().getPrimeraSinapsis();
        
        
        while (actual != null) {
            if (actual.getDestino().getId().equals(idDestino)) {
                return actual; 
            }
            actual = actual.getSiguiente();
        }
        
        return null;
    }

    /**
     * Responde con un true o un false si las dos neuronas andan conectadas.
     * @param idOrigen De dónde sale.
     * @param idDestino A dónde llega.
     * @return true si están conectadas, false si nada.
     */
    public boolean existeSinapsis(String idOrigen, String idDestino) {
        if (buscarSinapsis(idOrigen, idDestino) != null) {
            return true;
        }
        return false;
    }

}
