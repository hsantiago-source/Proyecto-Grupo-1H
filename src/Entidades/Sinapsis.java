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
    private Neurona destino;
    private double distancia;
    private String idNeurotransmisor;
    private double k;
    private Sinapsis siguiente;

    public Sinapsis(Neurona destino, double distancia, String idNeurotransmisor, double k) {
        this.destino = destino;
        this.distancia = distancia;
        this.idNeurotransmisor = idNeurotransmisor;
        this.k = k;
        this.siguiente = null;
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

    public String getIdNeurotransmisor() {
        return idNeurotransmisor;
    }

    public void setIdNeurotransmisor(String idNeurotransmisor) {
        this.idNeurotransmisor = idNeurotransmisor;
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
