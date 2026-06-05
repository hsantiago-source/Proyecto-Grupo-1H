/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import EDD.NodoHash;
import EDD.TablaHashNeurotransmisores;
import Entidades.Neurona;
import Entidades.Neurotransmisor;
import Entidades.Sinapsis;

/**
 * Clase central que administra el acceso al grafo y a la tabla hash, y formatea los resultados del sistema.
 * @author andres
 */
public class ControladorPrincipal {
    
    private static GrafoSinaptico grafo = new GrafoSinaptico(); 
    
    private static TablaHashNeurotransmisores tablaHash = new TablaHashNeurotransmisores(101);

    private static boolean redCargadaEnMemoria = false;
    private static boolean diccionarioCargadoEnMemoria = false;
    
    /**
     * Obtiene el grafo global que contiene la red de neuronas.
     * @return El objeto GrafoSinaptico actual.
     */
    public static GrafoSinaptico getGrafo() {
        return grafo;
    }

    /**
     * Asigna o reemplaza el grafo de la red por uno nuevo.
     * @param Grafo El nuevo GrafoSinaptico a asignar.
     */
    public static void setGrafo(GrafoSinaptico Grafo) {
        grafo = Grafo;
    }

    /**
     * Obtiene la tabla hash global que funciona como diccionario de químicos.
     * @return El objeto TablaHashNeurotransmisores.
     */
    public static TablaHashNeurotransmisores getTablaHash() {
        return tablaHash;
    }

    /**
     * Asigna o reemplaza la tabla hash de neurotransmisores.
     * @param tablaHashNeuro La nueva tabla hash a asignar.
     */
    public static void setTablaHash(TablaHashNeurotransmisores tablaHashNeuro) {
        tablaHash = tablaHashNeuro;
    }
    
    /**
     * Indica si la red de neuronas ya está cargada en memoria.
     * @return true si la red ya está cargada, false de lo contrario.
     */
    public static boolean getRedCargadaEnMemoria(){
        return redCargadaEnMemoria;
    }
    
    /**
     * Cambia el estado de control de la red en memoria.
     * @param redCargada El nuevo estado booleano.
     */
    public static void setRedCargadaEnMemoria(boolean redCargada) {
        redCargadaEnMemoria = redCargada;
    }

    /**
     * Indica si el diccionario de neurotransmisores ya está cargado en memoria.
     * @return true si el diccionario ya está cargado, false de lo contrario.
     */
    public static boolean getDiccionarioCargadoEnMemoria(){
        return diccionarioCargadoEnMemoria;
    }
    
    /**
     * Cambia el estado de control del diccionario en memoria.
     * @param diccionarioCargado El nuevo estado booleano.
     */
    public static void setDiccionarioCargadoEnMemoria(boolean diccionarioCargado) {
        diccionarioCargadoEnMemoria = diccionarioCargado;
    }
    
    /**
     * Genera un reporte en texto con los IDs de todas las neuronas del grafo.
     * @return Un String con la lista de neuronas.
     */
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

    /**
     * Genera un reporte detallado de las conexiones sinápticas agrupadas por origen.
     * @return Un String con el mapa de conexiones.
     */
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
    
    /**
     * Convierte el grafo de un recorrido BFS o DFS en una secuencia de texto unida por flechas.
     * @param recorrido El subgrafo obtenido del análisis de conectividad.
     * @return El String del camino recorrido.
     */
    public String textoRecorridoDFSoBFS(GrafoSinaptico recorrido) {
        if (recorrido == null || recorrido.isEmpty() == true) {
            return "No se pudo realizar el recorrido o la red está vacía.";
        }

        String resultado = "";
        Neurona actual = recorrido.getNeuronaInicio();
        
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
    
    /**
     * Obtiene el resultado de Dijkstra mostrando el tiempo total y la ruta en orden correcto.
     * @param pesoTotal El valor del costo o tiempo acumulado del camino.
     * @param ruta El grafo que contiene los nodos de la ruta óptima.
     * @return Un String con el tiempo total y la secuencia exacta del viaje.
     */
    public String textoResultadoDijkstra(double pesoTotal, GrafoSinaptico ruta) {
        if (ruta == null || ruta.isEmpty() == true) {
            return "No existe un camino posible.";
        }

        String textoRuta = "";
        Neurona actual = ruta.getNeuronaInicio();

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
   

    /**
     * Recorre la tabla hash para listar todos los neurotransmisores guardados.
     * @return Un listado en texto con la información de los neurotransmisores cargados.
     */
    public String mostrarListaNeurotransmisores() {
        if (tablaHash == null) {
            return "No hay diccionario cargado.\n";
        }

        String lista = "--- DICCIONARIO DE NEUROTRANSMISORES ---\n\n";
        boolean vacio = true;

        for (int i = 0; i < tablaHash.getCapacidad(); i++) {
            NodoHash actual = tablaHash.getTabla()[i];
            
            while (actual != null) {
                Neurotransmisor n = actual.getQuimico();
                lista += "ID: " + n.getId() + ", Nombre: " + n.getNombre() + ", Efecto: " + n.getEfecto() + ", Vel: " + n.getVelocidad() + "\n";
                vacio = false;
                actual = actual.getSiguiente();
            }
        }

        if (vacio == true) {
            return "El diccionario de neurotransmisores está vacío.\n";
        }

        return lista;
    }
    
    /**
     * Borra por completo la red actual asignando un grafo vacío.
     */
    public static void vaciarGrafo() {
        grafo = new GrafoSinaptico();
    }

    /**
     * Borra todos los neurotransmisores reinicializando la tabla hash.
     */
    public static void vaciarDiccionario() {
        tablaHash = new TablaHashNeurotransmisores(101);
    }
}
