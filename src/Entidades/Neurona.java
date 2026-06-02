/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Clase Neurona que es el nodo del grafo
 * @author hsantiago
 */
public class Neurona {
    
    //Campos de la clase
    private String id;
    private Boolean activo;
    private Neurona siguiente;

    //Constructor
    public Neurona(String id, Boolean activo, Neurona siguiente) {
        this.id = id;
        this.activo = activo;
        this.siguiente = null;
    }

    //Getters y setters 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Neurona getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Neurona siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
