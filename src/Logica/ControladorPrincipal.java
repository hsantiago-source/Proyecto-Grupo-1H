/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import EDD.TablaHashNeurotransmisores;
import Entidades.Neurona;
import Entidades.Sinapsis;

/**
 *
 * @author andres
 */
public class ControladorPrincipal {
    
    private static GrafoSinaptico grafo = new GrafoSinaptico(); 
    
    private static TablaHashNeurotransmisores tablaHash = new TablaHashNeurotransmisores(101);

    private static boolean redCargadaEnMemoria = false;
    private static boolean diccionarioCargadoEnMemoria = false;
    
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
    
    public static boolean getRedCargadaEnMemoria(){
        return redCargadaEnMemoria;
    }
    
    public static void setRedCargadaEnMemoria(boolean redCargada) {
        redCargadaEnMemoria = redCargada;
    }

    public static boolean getDiccionarioCargadoEnMemoria(){
        return diccionarioCargadoEnMemoria;
    }
    
    public static void setDiccionarioCargadoEnMemoria(boolean diccionarioCargado) {
        diccionarioCargadoEnMemoria = diccionarioCargado;
    }
    

    public String mostrarListaNeuronas() {
        
        if (grafo.isEmpty() == true) {
            return "No hay neuronas registradas en la red en este momento.\n";
        }

        String lista = "";
        lista += "--- NEURONAS EN LA RED ---\n\n";
        
        Neurona actual = grafo.getNeuronaInicio();
        int contador = 0;

        while (actual != null) {
            lista += "Neurona ID: " + actual.getId() + "\n";
            contador++;
            actual = actual.getSiguiente();
        }

        if (contador == 0) {
            return "Todas las neuronas han sido eliminadas de la red.\n";
        }

        return lista;
    }

    public String mostrarListaSinapsis() {
        if (grafo.isEmpty() == true) {
            return "No hay sinapsis porque la red está vacía.\n";
        }

        String lista = "";
        lista += "--- CONEXIONES SINÁPTICAS ---\n\n";
        
        Neurona actual = grafo.getNeuronaInicio();
        boolean haySinapsis = false;

        while (actual != null) {
            
            Sinapsis sinapsisActual = actual.getConexiones().getPrimeraSinapsis();
            
            if (sinapsisActual != null) {
                lista += "Origen: " + actual.getId() + "\n";
            }
                
            while (sinapsisActual != null) {
                    
                Neurona destino = sinapsisActual.getDestino();
                    
                lista += "  ->  Destino: " + destino.getId()  + ", Químico: " + sinapsisActual.getIdNeurotransmisor() + ", d: " + sinapsisActual.getDistancia() + ", k: " + sinapsisActual.getK() + "\n";
                        
                haySinapsis = true;
                sinapsisActual = sinapsisActual.getSiguiente();
            }
            
            if (actual.getConexiones().getPrimeraSinapsis() != null) {
                lista += "\n";
            }
            
            actual = actual.getSiguiente();
        }

        if (haySinapsis == false) {
            return "No existen conexiones activas entre las neuronas.\n";
        }

        return lista;
    }
    
    public String textoRecorridoDFSoBFS(GrafoSinaptico recorrido) {
        if (recorrido == null || recorrido.isEmpty() == true) {
            return "No se pudo realizar el recorrido o la red está vacía.";
        }

        String resultado = "";
        Entidades.Neurona actual = recorrido.getNeuronaInicio();
        
        while (actual != null) {
            if (resultado.isEmpty() == true) {
                resultado = actual.getId();
            } else {
                resultado = resultado + " -> " + actual.getId();
            }
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }
    
    public String textoResultadoDijkstra(double pesoTotal, GrafoSinaptico ruta) {
        if (ruta == null || ruta.isEmpty() == true) {
            return "No existe un camino posible.";
        }

        String textoRuta = "";
        Entidades.Neurona actual = ruta.getNeuronaInicio();

        while (actual != null) {
            if (textoRuta.isEmpty() == true) {
                textoRuta = actual.getId();
            } else {
                textoRuta = actual.getId() + " -> " + textoRuta;
            }
            actual = actual.getSiguiente();
        }

        return "Tiempo Total: " + String.valueOf(pesoTotal) + "\n\nRuta: " + textoRuta;
    }
}
