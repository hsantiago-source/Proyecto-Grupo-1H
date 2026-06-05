/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EDD.GrafoSinaptico;
import EDD.TablaHashNeurotransmisores;
import Entidades.Neurona;
import Entidades.Neurotransmisor;
import Entidades.Sinapsis;

/**
 * Esta clase se encarga de ejecutar el algoritmo de Dijkstra.
 * @author andres
 */
public class CalculadoraDijkstra {
    

    /**
     * Calcula el peso de una sinapsis específica. Busca el neurotransmisor en la tabla hash 
     * para obtener su velocidad; si no existe, toma una velocidad base de 1.0.
     * @param sinapsis La conexión que se va a evaluar.
     * @return El peso final calculado para esa sinapsis.
     */
    public double calcularPesoSinapsis(Sinapsis sinapsis) {
        TablaHashNeurotransmisores diccionario = ControladorPrincipal.getTablaHash();
        Neurotransmisor quimico = diccionario.buscar(sinapsis.getIdNeurotransmisor());
        
        double velocidad;

        if (quimico != null) {
            velocidad = quimico.getVelocidad();
        } else {
            velocidad = 1.0; 
        }
        double peso = sinapsis.getDistancia() / (velocidad * sinapsis.getK());

        return peso; 
    }


    /**
     * Aplica el algoritmo de Dijkstra para determinar el camino más eficiente entre el origen y el destino.
     * @param idOrigen El ID de la neurona de partida.
     * @param idDestino El ID de la neurona de llegada.
     * @return Un GrafoSinaptico con la ruta óptima ya armada, o null si el origen no se encuentra.
     */
    public GrafoSinaptico calcularRutaMasRapida(String idOrigen, String idDestino) {
        GrafoSinaptico grafo = ControladorPrincipal.getGrafo();
        
        Neurona actual = grafo.getNeuronaInicio();
        while (actual != null) {
            actual.setdPesoAcumulado(Double.MAX_VALUE); 
            actual.setdNeuronaAnterior(null);           
            actual.setdVisitado(false);                 
            actual = actual.getSiguiente();
        }

        Neurona origen = grafo.buscarNeurona(idOrigen);
        if (origen == null) {
            return null;
        }
        
        origen.setdPesoAcumulado(0.0);
        
        while (true) {
            Neurona neuronaActual = encontrarNeuronaMenorPeso();
            
            if (neuronaActual == null || neuronaActual.getId().equals(idDestino)) {
                break;
            }
            
            neuronaActual.setdVisitado(true); 

            Sinapsis sinapsis = neuronaActual.getConexiones().getPrimeraSinapsis();
            while (sinapsis != null) {
                Neurona destino = sinapsis.getDestino();
                double pesoArista = calcularPesoSinapsis(sinapsis);
                double nuevoPesoAcumulado = neuronaActual.getdPesoAcumulado() + pesoArista;
                
                if (nuevoPesoAcumulado < destino.getdPesoAcumulado()) {
                    destino.setdPesoAcumulado(nuevoPesoAcumulado);
                    destino.setdNeuronaAnterior(neuronaActual);
                }
                sinapsis = sinapsis.getSiguiente();
            }
        }
        
        return reconstruirRuta(idOrigen, idDestino);
    }

    /**
     * Busca entre todas las neuronas del grafo cuál es la que tiene el menor peso acumulado 
     * y que todavía no ha sido marcada como visitada.
     * @return La neurona con el peso mínimo actual, o null si ya se procesaron todas.
     */
    private Neurona encontrarNeuronaMenorPeso() {
        Neurona neuronaConMenorPeso = null;
        double pesoMinimo = Double.MAX_VALUE;
        Neurona actual = ControladorPrincipal.getGrafo().getNeuronaInicio();
        
        while (actual != null) {
            if (actual.getdVisitado() == false && actual.getdPesoAcumulado() < pesoMinimo) {
                pesoMinimo = actual.getdPesoAcumulado();
                neuronaConMenorPeso = actual;
            }
            actual = actual.getSiguiente();
        }
        return neuronaConMenorPeso;
    }

    /**
     * Reconstruye la ruta de Dijkstra
     * @param idOrigen El ID de la neurona inicial.
     * @param idDestino El ID de la neurona final.
     * @return El GrafoSinaptico con las neuronas ordenadas que forman el camino más rápido.
     */
    private GrafoSinaptico reconstruirRuta(String idOrigen, String idDestino) {
        GrafoSinaptico ruta = new GrafoSinaptico();
        Neurona actual = ControladorPrincipal.getGrafo().buscarNeurona(idDestino);
        
        while (actual != null) {
            ruta.insertFinal(actual); 
            actual = actual.getdNeuronaAnterior();
        }
        return ruta; 
    }
}