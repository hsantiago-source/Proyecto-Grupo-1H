/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import EDD.ListaAdyacencia;

/**
 * Clase Neurona que es el nodo del grafo
 * @author hsantiago
 */
public class Neurona {
    
    //Campos de la clase
    private String id;
    private Boolean activo;
    private Neurona siguiente;
    private ListaAdyacencia conexiones;
    private double dpesoAcumulado;
    private Neurona dneuronaAnterior;
    private double dpesoFijo;

    public Neurona(String id, Boolean activo, Neurona siguiente, ListaAdyacencia conexiones) {
        this.id = id;
        this.activo = activo;
        this.siguiente = null;
        this.conexiones = conexiones;
        this.dpesoAcumulado = 0;
        this.dneuronaAnterior = null;
        this.dpesoFijo = 0;
    }

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

    public ListaAdyacencia getConexiones() {
        return conexiones;
    }

    public void setConexiones(ListaAdyacencia conexiones) {
        this.conexiones = conexiones;
    }

    public double getdPesoAcumulado() {
        return dpesoAcumulado;
    }

    public void setdPesoAcumulado(double dpesoAcumulado) {
        this.dpesoAcumulado = dpesoAcumulado;
    }

    public Neurona getdNeuronaAnterior() {
        return dneuronaAnterior;
    }

    public void setdNeuronaAnterior(Neurona dneuronaAnterior) {
        this.dneuronaAnterior = dneuronaAnterior;
    }

    public double getdPesoFijo() {
        return dpesoFijo;
    }

    public void setdPesoFijo(double dpesoFijo) {
        this.dpesoFijo = dpesoFijo;
    }
 
}
