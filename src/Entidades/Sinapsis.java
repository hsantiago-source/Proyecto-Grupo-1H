/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Clase Sinapsis que representa conexion entre neuronas
 * @author hsantiag
 */
public class Sinapsis {
    
    //Campos de la clase
    private Neurona origen; 
    private Neurona destino;
    private double distancia;
    private String id;
    private double k;
    private Sinapsis siguiente;

    //Constructor
    public Sinapsis(Neurona origen, Neurona destino, double distancia, String id, double k, Sinapsis siguiente) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.id = id;
        this.k = k;
        this.siguiente = siguiente;
    }

    //Gettters y Setters
    public Neurona getOrigen() {
        return origen;
    }

    public void setOrigen(Neurona origen) {
        this.origen = origen;
    }

    public Neurona getDestino() {
        return destino;
    }

    public void setDestino(Neurona destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public Sinapsis getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Sinapsis siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
