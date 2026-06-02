/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurotransmisor;


/**
 * 
 * @author hsantiago
 */
public class NodoHash {
   private String clave;
   private Neurotransmisor quimico;
   private NodoHash siguiente;

    public NodoHash(String clave, Neurotransmisor quimico, NodoHash siguiente) {
        this.clave = clave;
        this.quimico = quimico;
        this.siguiente = siguiente;
    }   
   
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Neurotransmisor getQuimico() {
        return quimico;
    }

    public void setQuimico(Neurotransmisor quimico) {
        this.quimico = quimico;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }
   
   
}
