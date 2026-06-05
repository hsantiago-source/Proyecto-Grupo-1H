/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import Entidades.Neurona;
import Entidades.Sinapsis;

/**
 *
 * @author andres
 */
public class AnalizadorConectividad {
    
    private void reiniciarEstados() {
        GrafoSinaptico grafoGlobal = ControladorPrincipal.getGrafo();
        Neurona actual = grafoGlobal.getNeuronaInicio();
        while (actual != null) {
            actual.setActivo(false);
            actual = actual.getSiguiente();
        }
    }
    
public GrafoSinaptico BFS(String entrada) {
        GrafoSinaptico grafoGlobal = ControladorPrincipal.getGrafo();
        GrafoSinaptico cola = new GrafoSinaptico();
        GrafoSinaptico bfs = new GrafoSinaptico();
        
        reiniciarEstados();

        Neurona origen = grafoGlobal.buscarNeurona(entrada);
        if (origen == null) {
            return bfs; 
        } 
        
        cola.insertFinal(origen);
        origen.setActivo(true); 

        while (cola.isEmpty() == false) {
            
            Neurona nodoEnCola = cola.getNeuronaInicio();
            Neurona actual = grafoGlobal.buscarNeurona(nodoEnCola.getId());
            cola.deleteBegin(); 
            
            bfs.insertFinal(actual);
            
            Sinapsis sinapsis = actual.getConexiones().getPrimeraSinapsis();
            while (sinapsis != null) {
                Neurona vecino = grafoGlobal.buscarNeurona(sinapsis.getDestino().getId());
                
                if (vecino.getActivo() == false) {
                    vecino.setActivo(true); 
                    cola.insertFinal(vecino);
                }
                sinapsis = sinapsis.getSiguiente();
            }
        }
        
        return bfs;  
    } 

    public GrafoSinaptico DFS(String entrada) {
        GrafoSinaptico grafoGlobal = ControladorPrincipal.getGrafo();
        GrafoSinaptico pila = new GrafoSinaptico();
        GrafoSinaptico dfs = new GrafoSinaptico();
        
        reiniciarEstados();
        
        Neurona origen = grafoGlobal.buscarNeurona(entrada);
        if (origen == null) {
            return dfs;
        }
        
        pila.insertFinal(origen);

        while (pila.isEmpty() == false) {
            
            Neurona nodoEnPila = pila.getNeuronaFinal();
            Neurona actual = grafoGlobal.buscarNeurona(nodoEnPila.getId());
            pila.deleteFinal();
            
            if (actual.getActivo() == false) {
                actual.setActivo(true);
                dfs.insertFinal(actual);
                
                Sinapsis sinapsis = actual.getConexiones().getPrimeraSinapsis();
                while (sinapsis != null) {
                    Neurona vecino = grafoGlobal.buscarNeurona(sinapsis.getDestino().getId());
                    if (vecino.getActivo() == false) {
                        pila.insertFinal(vecino);
                    }
                    sinapsis = sinapsis.getSiguiente();
                }
            }
        }
        
        return dfs;  
    }

    public String obtenerZonasAisladas() {
        GrafoSinaptico grafoGlobal = ControladorPrincipal.getGrafo();
        String aisladas = "";
        
        if (grafoGlobal == null || grafoGlobal.isEmpty()){
            return "El grafo está vacío.";
        }

        Neurona actual = grafoGlobal.getNeuronaInicio();
        
        while (actual != null) {
            if (actual.getActivo() == false) {
                aisladas += "- Neurona " + actual.getId() + " ";
            }
            actual = actual.getSiguiente();
        }
        
        if (aisladas.isEmpty()) {
            return "No hay ninguna neurona aislada";
        } else {
            return "ZONAS AISLADAS DETECTADAS:\n" + aisladas;
        }
    }

    public boolean estaFragmentada() {
        GrafoSinaptico grafoGlobal = ControladorPrincipal.getGrafo();
        if (grafoGlobal == null || grafoGlobal.isEmpty() == true) {
            return false;
        }

        Neurona actual = grafoGlobal.getNeuronaInicio();
        while (actual != null) {
            if (actual.getActivo()== false) {
                return true;
            } 
            actual = actual.getSiguiente();
        }
        return false; 
    }
}
