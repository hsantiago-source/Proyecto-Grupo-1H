/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * 
 * @author hsantiago
 */
public class TablaHashNeurotransmisores {
    private NodoHash[] tabla;
    private int capacidad;

    public TablaHashNeurotransmisores(int capacidad) {
        this.tabla = new NodoHash[capacidad];
        this.capacidad = capacidad;
    }

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
    
    
}
