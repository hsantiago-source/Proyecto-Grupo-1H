/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import EDD.ListaAdyacencia;

/**
 * Clase Neurona que es el nodo del grafo.
 * @author hsantiago
 */
public class Neurona {
    
    private String id;
    private Boolean activo;
    private Neurona siguiente;
    private ListaAdyacencia conexiones;
    
    // Variables auxiliares para el algoritmo de Dijkstra
    private double dPesoAcumulado;
    private Neurona dNeuronaAnterior;
    private double dPesoFijo;
    private Boolean dVisitado;

    /**
     * Constructor de la clase. 
     * @param id El identificador único de la neurona.
     */
    public Neurona(String id) {
        this.id = id;
        this.activo = true;
        this.siguiente = null;
        this.conexiones = new ListaAdyacencia();
        this.dPesoAcumulado = Double.MAX_VALUE;
        this.dNeuronaAnterior = null;
        this.dPesoFijo = 0;
        this.dVisitado = null; 
    }

    /**
     * Para obtener el ID de la neurona.
     * @return El ID en formato String.
     */
    public String getId() {
        return id;
    }

/**
     * Para setear el ID de la neurona.
     * @param id El nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Revisa si la neurona está activa en la red.
     * @return true si está activa, false si no.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Para activar o desactivar la neurona.
     * @param activo true si está activa, false si no.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

/**
     * Para obtener la siguiente neurona en la lista enlazada del grafo.
     * @return La neurona que viene después.
     */
    public Neurona getSiguiente() {
        return siguiente;
    }

    /**
     * Para setear cuál será la siguiente neurona en la lista.
     * @param siguiente La próxima neurona.
     */   
    public void setSiguiente(Neurona siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Para obtener la lista de adyacencia que salen de esta neurona.
     * @return El objeto ListaAdyacencia con sus sinapsis.
     */
    public ListaAdyacencia getConexiones() {
        return conexiones;
    }

    /**
     * Para setear la lista de conexiones de la neurona.
     * @param conexiones La nueva lista de adyacencia.
     */
    public void setConexiones(ListaAdyacencia conexiones) {
        this.conexiones = conexiones;
    }

    /**
     * Para obtener el peso acumulado usado en el algoritmo de Dijkstra.
     * @return El valor del peso acumulado.
     */
    public double getdPesoAcumulado() {
        return dPesoAcumulado;
    }

    /**
     * Para setear el peso acumulado en el algoritmo de caminos cortos.
     * @param dPesoAcumulado El nuevo peso acumulado.
     */
    public void setdPesoAcumulado(double dPesoAcumulado) {
        this.dPesoAcumulado = dPesoAcumulado;
    }

    /**
     * Para ver cuál es la neurona previa en el camino calculado por Dijkstra.
     * @return La neurona anterior en la ruta.
     */
    public Neurona getdNeuronaAnterior() {
        return dNeuronaAnterior;
    }

    /**
     * Para setear la neurona previa en el cálculo del camino óptimo.
     * @param dNeuronaAnterior La neurona anterior.
     */
    public void setdNeuronaAnterior(Neurona dNeuronaAnterior) {
        this.dNeuronaAnterior = dNeuronaAnterior;
    }

    /**
     * Para obtener el peso fijo asignado en los cálculos de ruta.
     * @return El valor del peso fijo.
     */
    public double getdPesoFijo() {
        return dPesoFijo;
    }

    /**
     * Para setear el peso fijo en los cálculos de ruta.
     * @param dPesoFijo El nuevo peso fijo.
     */
    public void setdPesoFijo(double dPesoFijo) {
        this.dPesoFijo = dPesoFijo;
    }

    /**
     * Revisa si la neurona ya fue visitada durante la ejecución del algoritmo.
     * @return true si ya se visitó, false o null si no.
     */
    public Boolean getdVisitado() {
        return dVisitado;
    }

    /**
     * Para marcar si la neurona ya fue visitada o no.
     * @param dVisitado true si la visitó, false si no.
     */
    public void setdVisitado(Boolean dVisitado) {
        this.dVisitado = dVisitado;
    }


 
}
