/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa una sinapsis, que es básicamente la conexión o enlace entre dos neuronas dentro del grafo.
 * @author hsantiag
 */
public class Sinapsis {
    
    //Campos de la clase
    private Neurona destino;
    private double distancia;
    private String idNeurotransmisor;
    private double k;
    private Sinapsis siguiente;

    /**
     * Constructor de la clase. Sirve para inicializar la conexión con su neurona de destino, 
     * su distancia, el neurotransmisor que usa y el factor k.
     * @param destino La neurona hacia donde va la conexión.
     * @param distancia La distancia física entre las neuronas.
     * @param idNeurotransmisor El ID del neurotransmisor.
     * @param k Un factor k para los cálculos del peso.
     */
    public Sinapsis(Neurona destino, double distancia, String idNeurotransmisor, double k) {
        this.destino = destino;
        this.distancia = distancia;
        this.idNeurotransmisor = idNeurotransmisor;
        this.k = k;
        this.siguiente = null;
    }

    /**
     * Para obtener la neurona de destino a la que apunta esta conexión.
     * @return La neurona destino.
     */
    public Neurona getDestino() {
        return destino;
    }

    /**
     * Para setear la neurona destino de la sinapsis.
     * @param destino La nueva neurona destino.
     */
    public void setDestino(Neurona destino) {
        this.destino = destino;
    }

    /**
     * Para ver la distancia que hay en esta sinapsis.
     * @return El valor numérico de la distancia.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Para setear la distancia de la conexión.
     * @param distancia El nuevo valor de la distancia.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Para obtener el ID del neurotransmisor asignado a esta sinapsis.
     * @return El ID del neurotransmisor en formato String.
     */
    public String getIdNeurotransmisor() {
        return idNeurotransmisor;
    }

    /**
     * Para setear el ID del neurotransmisor que se usará en este enlace.
     * @param idNeurotransmisor El nuevo ID del neurotransmisor.
     */
    public void setIdNeurotransmisor(String idNeurotransmisor) {
        this.idNeurotransmisor = idNeurotransmisor;
    }
    
    /**
     * Para obtener el valor de la constante k de la sinapsis.
     * @return El valor de k.
     */
    public double getK() {
        return k;
    }

    /**
     * Para setear el valor de la constante k.
     * @param k El nuevo valor para k.
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * Para sacar la siguiente sinapsis en la lista de conexiones de la neurona.
     * @return La próxima sinapsis enlazada.
     */
    public Sinapsis getSiguiente() {
        return siguiente;
    }

    /**
     * Para setear la siguiente sinapsis en la lista enlazada.
     * @param siguiente La sinapsis que irá después de esta.
     */
    public void setSiguiente(Sinapsis siguiente) {
        this.siguiente = siguiente;
    }

}
