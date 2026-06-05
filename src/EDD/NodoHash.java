/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurotransmisor;


/**
 * Esta clase representa un nodo para la tabla hash. Sirve para guardar la clave, 
 * el objeto neurotransmisor (químico) y el enlace al siguiente nodo por si ocurren colisiones.
 * @author hsantiago
 */
public class NodoHash {
   private String clave;
   private Neurotransmisor quimico;
   private NodoHash siguiente;

    /**
     * Constructor de la clase. Sirve para inicializar el nodo con su clave, su neurotransmisor y el siguiente enlace.
     * @param clave La clave única del nodo.
     * @param quimico El objeto neurotransmisor que se va a guardar.
     * @param siguiente El próximo nodo enlazado en la lista.
     */
    public NodoHash(String clave, Neurotransmisor quimico, NodoHash siguiente) {
        this.clave = clave;
        this.quimico = quimico;
        this.siguiente = siguiente;
    }   
   
    /**
     * Para sacar la clave de este nodo.
     * @return La clave en formato String.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Para setear la clave del nodo.
     * @param clave La nueva clave.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Para ver el neurotransmisor químico guardado en este nodo.
     * @return El objeto Neurotransmisor.
     */
    public Neurotransmisor getQuimico() {
        return quimico;
    }

    /**
     * Para setear el objeto neurotransmisor.
     * @param quimico El nuevo neurotransmisor a guardar.
     */
    public void setQuimico(Neurotransmisor quimico) {
        this.quimico = quimico;
    }

    /**
     * Para sacar el siguiente nodo enlazado.
     * @return El próximo NodoHash en la lista.
     */
    public NodoHash getSiguiente() {
        return siguiente;
    }

    /**
     * Para setear el siguiente nodo en la lista.
     * @param siguiente El nodo que irá después de este.
     */
    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }
   
   
}
