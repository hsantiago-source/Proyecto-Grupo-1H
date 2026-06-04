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
    private double dPesoAcumulado;
    private Neurona dNeuronaAnterior;
    private double dPesoFijo;
    private Boolean dVisitado;

    public Neurona(String id, Boolean activo, Neurona siguiente, ListaAdyacencia conexiones) {
        this.id = id;
        this.activo = activo;
        this.siguiente = null;
        this.conexiones = conexiones;
        this.dPesoAcumulado = 0;
        this.dNeuronaAnterior = null;
        this.dPesoFijo = 0;
        this.dVisitado = null; 
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
        return dPesoAcumulado;
    }

    public void setdPesoAcumulado(double dPesoAcumulado) {
        this.dPesoAcumulado = dPesoAcumulado;
    }

    public Neurona getdNeuronaAnterior() {
        return dNeuronaAnterior;
    }

    public void setdNeuronaAnterior(Neurona dNeuronaAnterior) {
        this.dNeuronaAnterior = dNeuronaAnterior;
    }

    public double getdPesoFijo() {
        return dPesoFijo;
    }

    public void setdPesoFijo(double dPesoFijo) {
        this.dPesoFijo = dPesoFijo;
    }

    public Boolean getdVisitado() {
        return dVisitado;
    }

    public void setdVisitado(Boolean dVisitado) {
        this.dVisitado = dVisitado;
    }


 
}
