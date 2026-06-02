/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurona;

/**
 * 
 * @author hsantiago
 */
public class GrafoSinaptico {
    private Neurona neuronaInicio;

    public GrafoSinaptico(Neurona neuronaInicio) {
        this.neuronaInicio = neuronaInicio;
    }

    public Neurona getNeuronaInicio() {
        return neuronaInicio;
    }

    public void setNeuronaInicio(Neurona neuronaInicio) {
        this.neuronaInicio = neuronaInicio;
    }
    
}
