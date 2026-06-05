/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Entidades.Neurotransmisor;


/**
 * Esta clase representa una tabla hash encargada de almacenar los neurotransmisores
 * utilizando sus IDs como claves para las búsquedas
 * @author hsantiago
 */
public class TablaHashNeurotransmisores {
    
    private NodoHash[] tabla;
    private int capacidad;

    /**
     * Constructor de la clase.
     * @param capacidad El tamaño máximo inicial del arreglo de la tabla hash.
     */
    public TablaHashNeurotransmisores(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoHash[capacidad];
    }

    /**
     * Para obtener el arreglo de nodos que conforman la tabla hash.
     * @return El arreglo de NodoHash.
     */
    public NodoHash[] getTabla() {
        return tabla;
    }

    /**
     * Para setear el arreglo de la tabla hash.
     * @param tabla El nuevo arreglo de nodos.
     */
    public void setTabla(NodoHash[] tabla) {
        this.tabla = tabla;
    }

    /**
     * Para ver el tamaño total de la tabla.
     * @return La capacidad de la tabla.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Para setear la capacidad de la tabla.
     * @param capacidad La nueva capacidad.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * Método que calcula la posición en el arreglo para una clave dada.
     * @param clave La clave o ID a procesar.
     * @return El índice asignado dentro del arreglo.
     */
    private int funcionHash(String clave) {
        int hash = 0;
        for(int i = 0; i < clave.length(); i++) {
            hash = (hash * 31 + clave.charAt(i)) % capacidad;
        }
        if (hash < 0) {
            hash = hash * -1;
        }
        return hash;
    }

    /**
     * Mete un nuevo neurotransmisor en la tabla hash. Si ocurre una colisión en el índice,
     * lo enlaza al inicio de la lista en esa posición.
     * @param n El objeto neurotransmisor que se va a guardar.
     */
    public void insertar(Neurotransmisor n) {
        int indice = funcionHash(n.getId());
        
        if (tabla[indice] == null) {
            tabla[indice] = new NodoHash(n.getId(), n, null);
        } else {
            NodoHash nuevoNodo = new NodoHash(n.getId(), n, tabla[indice]);
            tabla[indice] = nuevoNodo;
        }
    }

    /**
     * Busca un neurotransmisor específico usando su ID.
     * @param clave El ID del neurotransmisor que se busca.
     * @return El objeto Neurotransmisor si lo consigue, o null si no existe.
     */
    public Neurotransmisor buscar(String clave) {
        int indice = funcionHash(clave);
        NodoHash actual = tabla[indice];

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return actual.getQuimico(); 
            }
            actual = actual.getSiguiente();
        }
        
        return null; 
    }

    /**
     * Limpia por completo la tabla hash.
     */
    public void vaciarDiccionario() {   
        this.tabla = new NodoHash[this.capacidad];
    }

    /**
     * Elimina un neurotransmisor de la tabla hash mediante su ID.
     * @param id El ID del neurotransmisor que se quiere borrar.
     */
    public void eliminar(String id) {
        int indice = funcionHash(id);
        NodoHash actual = tabla[indice];
        NodoHash anterior = null;

        while (actual != null) {
            if (actual.getClave().equals(id)) {
                if (anterior == null) {
                    tabla[indice] = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return; 
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

}
