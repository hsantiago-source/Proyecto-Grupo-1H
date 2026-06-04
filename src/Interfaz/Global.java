/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import EDD.GrafoSinaptico;
import EDD.TablaHashNeurotransmisores;

/**
 *
 * @author andres
 */
public class Global {
    
    private static GrafoSinaptico grafo = new GrafoSinaptico(null,null); 
    
    private static TablaHashNeurotransmisores diccionario = new TablaHashNeurotransmisores(101);

    public static GrafoSinaptico getGrafo() {
        return grafo;
    }

    public static void setGrafo(GrafoSinaptico aGrafo) {
        grafo = aGrafo;
    }

    public static TablaHashNeurotransmisores getDiccionario() {
        return diccionario;
    }

    public static void setDiccionario(TablaHashNeurotransmisores aDiccionario) {
        diccionario = aDiccionario;
    }
}
