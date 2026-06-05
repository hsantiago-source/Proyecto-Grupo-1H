/*
    * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import Entidades.Neurona;
import Entidades.Sinapsis;

/**
 * Clase encargada de simular la fatiga incrementando el factor k de todas las sinapsis.
 * @author andres
 */
public class SimuladorFatiga {
    
    /**
     * Recorre todas las neuronas y sus conexiones para aumentar su factor k por 1.2.
     */
    public void aplicarFatiga() {
        GrafoSinaptico grafo = ControladorPrincipal.getGrafo();
        
        if (grafo == null || grafo.isEmpty()) {
            return; 
        }

        Neurona actual = grafo.getNeuronaInicio();
        
        while (actual != null) {
            Sinapsis sinapsisActual = actual.getConexiones().getPrimeraSinapsis();
      
            while (sinapsisActual != null) {
                double kOriginal = sinapsisActual.getK();          
                sinapsisActual.setK(kOriginal * 1.2);
                sinapsisActual = sinapsisActual.getSiguiente();
            }
            
            actual = actual.getSiguiente();
        }
    }
}
