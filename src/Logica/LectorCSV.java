    package Logica;

    import EDD.GrafoSinaptico;
    import EDD.TablaHashNeurotransmisores;
    import Entidades.Neurotransmisor;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import javax.swing.JOptionPane;

    /**
    * Clase encargada de leer y procesar archivos CSV para cargar los neurotransmisores.
    * @author Gonzalo
    */
    public class LectorCSV {

    /**
     * Lee un archivo CSV con la información de los neurotransmisores y los inserta en la tabla hash.
     * @param rutaArchivo La ruta del archivo CSV con los datos de los químicos.
     * @return true si el diccionario se cargó con éxito, false si ocurrió un error.
     */
        public Boolean leerDiccionarioHash (String rutaArchivo) {
            TablaHashNeurotransmisores diccionario = ControladorPrincipal.getTablaHash(); 

            try {
                BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
                String linea;

                while ((linea = br.readLine()) != null) {
                    if (linea.isBlank() || linea.toLowerCase().contains("id,nombre")) {
                        continue;
                    }                
                    String[] datos = linea.split(",");

                    if (datos.length == 5) {
                        String id = datos[0].trim();
                        String nombre = datos[1].trim();
                        String efecto = datos[2].trim();
                        double velocidad = Double.parseDouble(datos[3].trim());
                        String descripcion = datos[4].trim();

                        Neurotransmisor quimico = new Neurotransmisor(id, nombre, efecto, velocidad, descripcion);
                        diccionario.insertar(quimico);
                    } 
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Diccionario cargado exitosamente.");
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al leer el diccionario: " + e.getMessage());
                return false;
            }
        }


     /**
     * Lee un archivo CSV con las conexiones de la red sináptica, validando el factor k y creando los nodos.
     * @param rutaArchivo La ruta del archivo CSV con las uniones entre neuronas.
     * @return true si la red se estructuró correctamente, false si hubo fallas en la lectura o datos inválidos.
     */
        public Boolean leerRedNeuronal(String rutaArchivo) {
            GrafoSinaptico grafo = ControladorPrincipal.getGrafo(); 

            try {
                BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
                String linea;

                while ((linea = br.readLine()) != null) {
                    if (linea.isBlank() || linea.toLowerCase().contains("origen")){
                        continue;
                    }

                    String[] datos = linea.split(",");

                    if (datos.length == 5) {
                        String idOrigen = datos[0].trim();
                        String idDestino = datos[1].trim();
                        double distancia = Double.parseDouble(datos[2].trim());
                        String idQuimico = datos[3].trim();
                        double k = Double.parseDouble(datos[4].trim());
                        
                        if (k <= 0 || k > 1) {
                            throw new Exception("El factor k (Coeficiente de Eficiencia Sináptica) debe ser mayor a 0 y menor o igual a 1. Valor incorrecto (" + k + ") en la conexión " + idOrigen + " -> " + idDestino);
                        }

                        if (!grafo.existeNeurona(idOrigen)) {
                            grafo.agregarNeurona(idOrigen);
                        }
                        if (!grafo.existeNeurona(idDestino)) {
                            grafo.agregarNeurona(idDestino);
                        }

                        grafo.agregarSinapsis(idOrigen, idDestino, distancia, idQuimico, k);
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Red Neuronal cargada exitosamente.");
                return true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al leer la red neuronal: " + e.getMessage());
                return false;
            }
        }
    }