package EDD;
import Entidades.Sinapsis;

/**
 * Clase ListaAdyacencia que representa las sinapsis de una neurona.
 * @author hsantiag
 */
public class ListaAdyacencia {
    
    // Campos de la clase: representan el primer y ultimo enlace (Sinapsis) de la lista
    private Sinapsis primeraSinapsis;
    private Sinapsis ultimaSinapsis;

    // Constructor de la clase
    public ListaAdyacencia() {
        this.ultimaSinapsis = null;
    }

    //Getters y setters 
    public Sinapsis getPrimeraSinapsis() {
        return primeraSinapsis;
    }

    public void setPrimeraSinapsis(Sinapsis primeraSinapsis) {
        this.primeraSinapsis = primeraSinapsis;
    }

    public Sinapsis getUltimaSinapsis() {
        return ultimaSinapsis;
    }

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