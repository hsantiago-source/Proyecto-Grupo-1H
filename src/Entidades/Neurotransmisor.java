/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
/**
 * Esta clase representa un neurotransmisor, el cual contiene los datos para el hashnode.
 * @author hsantiago
 */
public class Neurotransmisor {
    private String id;
    private String nombre;
    private String efecto;
    private double velocidad;
    private String descripcion;

    public Neurotransmisor(String id, String nombre, String efecto, double velocidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }
    
    /**
     * Para obtener el ID del neurotransmisor.
     * @return El ID en formato String.
     */
    public String getId() {
        return id;
    }

    /**
     * Para setear el ID del neurotransmisor.
     * @param id El nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Para obtener el nombre del neurotransmisor.
     * @return El nombre químico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Para setear el nombre del neurotransmisor.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Para ver qué efecto produce este neurotransmisor.
     * @return El efecto en formato String.
     */
    public String getEfecto() {
        return efecto;
    }

    /**
     * Para setear el efecto del neurotransmisor.
     * @param efecto El nuevo efecto.
     */
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    /**
     * Para obtener la velocidad de transmisión del neurotransmisor.
     * @return El valor numérico de la velocidad.
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * Para setear la velocidad de transmisión.
     * @param velocidad La nueva velocidad.
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Para leer la descripción detallada del neurotransmisor.
     * @return El texto de la descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Para setear la descripción del neurotransmisor.
     * @param descripcion El nuevo texto descriptivo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
