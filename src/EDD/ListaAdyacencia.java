package EDD;
import Entidades.Sinapsis;

/**
 * Clase ListaAdyacencia que representa las sinapsis de una neurona.
 * @author hsantiag
 */
public class ListaAdyacencia {
    
    private Sinapsis primeraSinapsis;
    private Sinapsis ultimaSinapsis;

    /**
     * Constructor de la clase. Arranca la lista limpia y sin conexiones.
     */    
    public ListaAdyacencia() {
        this.ultimaSinapsis = null;
    }

    /**
     * Para sacar la primera sinapsis de la lista.
     * @return La sinapsis del inicio.
     */
    public Sinapsis getPrimeraSinapsis() {
        return primeraSinapsis;
    }

    /**
     * Para setear la primera sinapsis.
     * @param primeraSinapsis La sinapsis inicial.
     */
    public void setPrimeraSinapsis(Sinapsis primeraSinapsis) {
        this.primeraSinapsis = primeraSinapsis;
    }

    /**
     * Para ver cuál es la última sinapsis de la lista.
     * @return La sinapsis del final.
     */
    public Sinapsis getUltimaSinapsis() {
        return ultimaSinapsis;
    }

    /**
     * Para setear la sinapsis final.
     * @param ultimaSinapsis La sinapsis que va para el final.
     */
    public void setUltimaSinapsis(Sinapsis ultimaSinapsis) {
        this.ultimaSinapsis = ultimaSinapsis;
    }
    
    /**
     * Método que determina si la lista adyacencia está vacía o no
     * @return Retorna un booleano indicando si la lista está vacía
     */
    public boolean isEmpty() {
        return getPrimeraSinapsis() == null;
    }
    
    /**
     * Funcion que indica si hay una sinapsis existente a una neurona destino
     * @param idDestino ID de la neurona de destino
     * @return booleano para ver si la conexion existe o no 
     */
    public boolean existeAdyacencia(String idDestino) {
        Sinapsis actual = getPrimeraSinapsis();
        boolean encontrado = false;
        while(actual != null && !idDestino.equals(actual.getDestino().getId())){
            actual = actual.getSiguiente();
        }
        if (actual != null){
            encontrado = true;
        }
        return encontrado;
    }
    

}