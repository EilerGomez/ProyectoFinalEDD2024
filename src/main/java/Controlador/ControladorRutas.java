/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import modelo.Grafo;
import modelo.Horario;
import utilidades.Graficar;

/**
 *
 * @author eiler
 */
public class ControladorRutas {

    public ArrayList<ArrayList<Grafo>> encontrarRutas(String origen, String destino, ArrayList<Grafo> grafos) {
        ArrayList<ArrayList<Grafo>> rutas = new ArrayList<>();
        ArrayList<Grafo> rutaActual = new ArrayList<>();
        encontrarRutasDFS(origen, destino, grafos, rutaActual, rutas);
        return rutas;
    }

    private void encontrarRutasDFS(String origen, String destino, ArrayList<Grafo> grafos,
            ArrayList<Grafo> rutaActual, ArrayList<ArrayList<Grafo>> rutas) {
        for (Grafo grafo : grafos) {
            if (grafo.getOrigen().equals(origen)) {
                // Verificar si el destino es igual al nodo actual
                if (grafo.getDestino().equals(destino)) {
                    rutaActual.add(grafo); // Agregar el grafo actual a la ruta
                    rutas.add(new ArrayList<>(rutaActual)); // Agregar la ruta a la lista de rutas
                    rutaActual.remove(rutaActual.size() - 1); // Eliminar el último grafo de la ruta
                } else {
                    // Evitar ciclos en el grafo
                    if (!rutaActual.contains(grafo)) {
                        rutaActual.add(grafo); // Agregar el grafo actual a la ruta
                        encontrarRutasDFS(grafo.getDestino(), destino, grafos, rutaActual, rutas);
                        rutaActual.remove(rutaActual.size() - 1); // Eliminar el último grafo de la ruta
                    }
                }
            }
        }
    }

    public void llenarTablasDestino(JTable tablaDestino, ArrayList<Grafo> lista) {
        ArrayList<String> destinos = new ArrayList<>();

        for (Grafo grafo : lista) {
            boolean exist = false;
            for (String destino : destinos) {
                if (destino.equals(grafo.getDestino())) {
                    exist = true;
                    break;
                }
            }

            if (exist == false) {
                destinos.add(grafo.getDestino());
            }
        }
        //llenar tabla de destino
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Destino");
        String[] fila = new String[1];
        for (String destino : destinos) {
            fila[0] = destino;
            modelo.addRow(fila);
        }
        tablaDestino.setModel(modelo);
    }

    public void llenarTablasOrigen(JTable tablaOrigen, ArrayList<Grafo> lista) {
        //llenar tabla origen  
        ArrayList<String> origenes = new ArrayList<>();

        for (Grafo grafo : lista) {
            boolean exist = false;
            for (String origen : origenes) {
                if (origen.equals(grafo.getOrigen())) {
                    exist = true;
                    break;
                }
            }

            if (exist == false) {
                origenes.add(grafo.getOrigen());
            }
        }
        //llenar tabla de destino
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Origen");
        String[] fila = new String[1];
        for (String origen : origenes) {
            fila[0] = origen;
            modelo.addRow(fila);
        }
        tablaOrigen.setModel(modelo);
    }

    public boolean esDiferenteRuta(JTable tablaDestino, JTable tablaOrigen) {
        return nombreRuta(tablaOrigen).equals(nombreRuta(tablaDestino));

    }

    public String nombreRuta(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        int columnaSeleccionada = tabla.getSelectedColumn();

        Object valorSeleccionado = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
        String valorString = String.valueOf(valorSeleccionado);

        System.out.println("Valor seleccionado: " + valorString);
        return valorString;

    }

    public void llenarComboRutas(ArrayList<ArrayList<Grafo>> lista, JComboBox combo) {
        System.out.println("LLenando combo");
        combo.removeAllItems();
        int index = 1;
        for (ArrayList<Grafo> grafo : lista) {
            combo.addItem("Ruta" + index);
            index++;
        }
    }

    public void eliminarContenidoCarpeta(String nombreCarpeta) {
        File carpeta = new File(nombreCarpeta);

        if (!carpeta.isDirectory()) {
            System.out.println("La ruta especificada no es una carpeta.");
            return;
        }

        // Obtener la lista de archivos dentro de la carpeta
        File[] archivos = carpeta.listFiles();

        // Verificar si la carpeta no está vacía
        if (archivos != null) {
            // Eliminar cada archivo dentro de la carpeta
            for (File archivo : archivos) {
                if (archivo.isFile()) { // Verificar si es un archivo
                    if (archivo.delete()) { // Intentar eliminar el archivo
                        System.out.println("Se ha eliminado el archivo: " + archivo.getName());
                    } else {
                        System.out.println("No se pudo eliminar el archivo: " + archivo.getName());
                    }
                }
            }
        } else {
            System.out.println("La carpeta está vacía.");
        }
    }

    public void informacionDeRuta(JTextArea area, ArrayList<Grafo> lista, boolean esVehiculo, String reloj) {
        int distancia = 0;
        double rapidezVehiculo = 0;
        double rapidezAPie = 0;
        int consumoGas = 0;
        int esfuerzoFisico = 0;
        double probabilidadTrafico = 0;

        for (Grafo grafo : lista) {
            distancia += grafo.getDistancia();
            rapidezVehiculo += (double) grafo.getDistancia() / ((double) grafo.getTiempo_vehiculo() * (1 + porbabilidadTrafico(reloj,grafo)));
            System.out.println("Distancia " + grafo.getDistancia() + "/" + grafo.getTiempo_vehiculo() + "*1+" + traerHorario(grafo).getProbabilidad_trafico());
            rapidezAPie += (double) grafo.getDistancia() / (double) grafo.getTiempo_pie();
            consumoGas += grafo.getConsumo_gas();
            esfuerzoFisico += grafo.getDesgaste_personal();
            probabilidadTrafico += porbabilidadTrafico(reloj, grafo);
        }
        String informacion = "Distancia:" + distancia + " km";
        DecimalFormat formato = new DecimalFormat("#.###");
        if (esVehiculo) {
            informacion += "\nCosumo de gas: " + consumoGas + " litros";
            informacion += "\nVelocidad Vehiculo: " + formato.format(rapidezVehiculo) + " km/h";
            informacion += "\nProbabilidad total de trafico: " + formato.format(probabilidadTrafico);
            informacion += "\nPromedio de trafico: " + formato.format(probabilidadTrafico / lista.size());
            if (hayDobleVia(lista)) {
                informacion += "\nHay doble via";
            } else {
                informacion += "\nNo hay doble via";
            }
        } else {
            informacion += "\nDesgaste fisico: " + esfuerzoFisico;
            informacion += "\nVelocidad a pie: " + formato.format(rapidezAPie) + " km/h";
        }
        area.setText(informacion);
    }

    public double porbabilidadTrafico(String hora, Grafo grafo) {

        double probabilidad = 0.00;
        Horario horar = traerHorario(grafo);
        System.out.println("Horario: " + horar.getProbabilidad_trafico() / 100 + " Probabilidad trafico");
        String[] split = hora.split(":");
        System.out.println("Hora: " + split[0]);
        if (Integer.parseInt(split[0]) >= horar.getHora_inicio() && Integer.parseInt(split[0]) <= horar.getHora_finalizada()) {
            probabilidad = ((double) horar.getProbabilidad_trafico()) / 100;
        }

        return probabilidad;
    }

    public Horario traerHorario(Grafo grafo) {
        Horario h = new Horario("", "", 0, 0, 0);
        for (Horario horario : Datos.Datos.listaHorarios) {
            if (horario.getDestino().equals(grafo.getDestino()) && horario.getOrigen().equals(grafo.getOrigen())) {
                h = horario;
                break;
            }
        }
        return h;
    }

    public boolean hayDobleVia(ArrayList<Grafo> listado) {
        boolean hay = false;
        if (encontrarRutas(listado.get(listado.size() - 1).getDestino(),
                listado.get(0).getOrigen(), listado).size() != 0) {
            hay = true;
        }

        return hay;
    }

    public void mejorRuta(JLabel labelMejorRuta, ArrayList<ArrayList<Grafo>> lista, boolean esVehiculo) {
        int contador = 1;
        int eficiencia = 0;
        for (ArrayList<Grafo> listaU : lista) {
            int eficienciaUnidad = 0;
            for (Grafo grafo : listaU) {
                eficienciaUnidad += grafo.getDistancia();
                /*if (esVehiculo) {
                    eficienciaUnidad += grafo.getConsumo_gas();
                    eficienciaUnidad += grafo.getTiempo_vehiculo();
                    eficiencia += traerHorario(grafo).getProbabilidad_trafico();
                } else {
                    eficienciaUnidad += grafo.getDesgaste_personal();
                    eficienciaUnidad += grafo.getTiempo_pie();
                }*/

            }
            if (eficiencia == 0) {
                eficiencia = eficienciaUnidad;
                labelMejorRuta.setText("Ruta mas corta: Ruta" + contador + " ditancia de: " + eficiencia + " Kms");
            } else {
                if (eficienciaUnidad < eficiencia) {
                    eficiencia = eficienciaUnidad;
                    labelMejorRuta.setText("Ruta mas corta: Ruta" + contador + " ditancia de: " + eficiencia + " Kms");
                }
            }

            contador++;
        }
    }

    public void graficarGrafoCompleto() {
        Graficar graficar = new Graficar();
        graficar.graficarGrafoCompleto(Datos.Datos.listaGrafos, "Images", "mapaCompleto");
    }
    /*public void mejorRuta(JLabel labelMejorRuta, ArrayList<ArrayList<Grafo>> lista, boolean esVehiculo) {
        int contador = 1;
        int eficiencia = 0;
        for (ArrayList<Grafo> listaU : lista) {
            int eficienciaUnidad = 0;
            for (Grafo grafo : listaU) {
                eficienciaUnidad += grafo.getDistancia();
                if (esVehiculo) {
                    eficienciaUnidad += grafo.getConsumo_gas();
                    eficienciaUnidad += grafo.getTiempo_vehiculo();
                    eficiencia += traerHorario(grafo).getProbabilidad_trafico();
                } else {
                    eficienciaUnidad += grafo.getDesgaste_personal();
                    eficienciaUnidad += grafo.getTiempo_pie();
                }

            }
            if (eficiencia == 0) {
                eficiencia = eficienciaUnidad;
                labelMejorRuta.setText("Ruta mas eficiente: Ruta" + contador + " eficiencia de: " + eficiencia);
            } else {
                if (eficienciaUnidad < eficiencia) {
                    eficiencia = eficienciaUnidad;
                    labelMejorRuta.setText("Ruta mas eficiente: Ruta" + contador + " eficiencia de: " + eficiencia);
                }
            }

            contador++;
        }
    }*/

}
