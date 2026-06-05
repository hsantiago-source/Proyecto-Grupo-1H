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
        
        Sinapsis destino = origen.getConexiones().getPrimeraSinapsis();
        
        bfs.insertFinal(origen);
        origen.setActivo(true); 

        while (origen != null && destino != null) {
            Neurona vecino = grafoGlobal.buscarNeurona(destino.getDestino().getId());
            
            if (vecino.getActivo()==false) {
                cola.insertFinal(vecino);
                vecino.setActivo(true); 
            }
            destino = destino.getSiguiente();
            
            if (destino == null && !cola.isEmpty()) {
                origen = grafoGlobal.buscarNeurona(cola.getNeuronaInicio().getId());
                destino = origen.getConexiones().getPrimeraSinapsis();
                
                bfs.insertFinal(origen);
                cola.deleteBegin();
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
        
        Sinapsis destino = origen.getConexiones().getPrimeraSinapsis();
        dfs.insertFinal(origen);
        origen.setActivo(true); 

        while (origen != null && destino != null) {
            Neurona vecino = grafoGlobal.buscarNeurona(destino.getDestino().getId());
            
            if (vecino.getActivo() == false) {
                pila.insertFinal(vecino);
            }
            destino = destino.getSiguiente();
            
            if (destino == null && pila.getNeuronaFinal() != null) {
                origen = grafoGlobal.buscarNeurona(pila.getNeuronaFinal().getId());
                destino = origen.getConexiones().getPrimeraSinapsis();
                
                if (origen.getActivo() == false) {
                    dfs.insertFinal(origen);
                    origen.setActivo(true);
                }
                
                pila.deleteFinal();
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
