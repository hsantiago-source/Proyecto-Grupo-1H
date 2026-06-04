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
 *
 * @author andres
 */
public class CalculadoraDijkstra {
    

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

    private GrafoSinaptico reconstruirRuta(String idOrigen, String idDestino) {
        GrafoSinaptico ruta = new GrafoSinaptico(null, null);
        Neurona actual = ControladorPrincipal.getGrafo().buscarNeurona(idDestino);
        
        while (actual != null) {
            ruta.insertFinal(actual); 
            actual = actual.getdNeuronaAnterior();
        }
        return ruta; 
    }
}