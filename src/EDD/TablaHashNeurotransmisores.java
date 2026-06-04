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
public class TablaHashNeurotransmisores {
    
    private NodoHash[] tabla;
    private int capacidad;

    public TablaHashNeurotransmisores(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoHash[capacidad];
    }

    // Getters y Setters
    public NodoHash[] getTabla() {
        return tabla;
    }

    public void setTabla(NodoHash[] tabla) {
        this.tabla = tabla;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    private int funcionHash(String clave) {
        int hash = 0;
        for(int i = 0; i < clave.length(); i++) {
            hash = (hash * 31 + clave.charAt(i)) % capacidad;
        }
        if (hash < 0) {
            hash = hash * -1;
        }
        return hash;
    }

    public void insertar(String clave, Neurotransmisor quimico) {
        int indice = funcionHash(clave);
        NodoHash nuevoNodo = new NodoHash(clave, quimico, null);

        if (tabla[indice] == null) {
            tabla[indice] = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(tabla[indice]);
            tabla[indice] = nuevoNodo;
        }
    }

    public Neurotransmisor buscar(String clave) {
        int indice = funcionHash(clave);
        NodoHash actual = tabla[indice];

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return actual.getQuimico(); 
            }
            actual = actual.getSiguiente();
        }
        
        return null; 
    }

    public void vaciarDiccionario() {   
        this.tabla = new NodoHash[this.capacidad];
    }


}
