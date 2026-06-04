/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import EDD.TablaHashNeurotransmisores;

/**
 *
 * @author andres
 */
public class ControladorPrincipal {
    
    private static GrafoSinaptico grafo = new GrafoSinaptico(null,null); 
    
    private static TablaHashNeurotransmisores tablaHash = new TablaHashNeurotransmisores(101);

    public static GrafoSinaptico getGrafo() {
        return grafo;
    }

    public static void setGrafo(GrafoSinaptico Grafo) {
        grafo = Grafo;
    }

    public static TablaHashNeurotransmisores getTablaHash() {
        return tablaHash;
    }

    public static void setTablaHash(TablaHashNeurotransmisores tablaHashNeuro) {
        tablaHash = tablaHashNeuro;
    }


}
