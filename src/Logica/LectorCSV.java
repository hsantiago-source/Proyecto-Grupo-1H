    package Logica;

    import EDD.GrafoSinaptico;
    import EDD.TablaHashNeurotransmisores;
    import Entidades.Neurotransmisor;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import javax.swing.JOptionPane;

    /**
     *
     * @author Gonzalo
     */
    public class LectorCSV {


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
                    } else {
                        System.out.println("Línea ignorada por formato incorrecto"); 
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