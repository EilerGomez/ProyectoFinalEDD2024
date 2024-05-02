/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Grafo;
import modelo.Horario;

/**
 *
 * @author eiler
 */
public class Lector {

    private String texto;
    private String linea;
    private BufferedReader bufer;

    public void leer(String nombreArchivo, boolean esGrafo) {
        try {
            this.bufer = new BufferedReader(new FileReader(new File(nombreArchivo)));
            while ((linea = bufer.readLine()) != null) {
                System.out.println(linea);
                if (esGrafo) {
                    agregarGrafoADatos(linea);
                } else {
                    agregarHorariosADatos(linea);
                }

            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("HA ocurrido un error al intentar cargar el archivo" + ex);
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarGrafoADatos(String linea) {
        String[] splits = linea.split("\\|");
        if (splits.length == 7) {
            Grafo nuevo = new Grafo(splits[0], splits[1], Integer.parseInt(splits[2]),
                    Integer.parseInt(splits[3]), Integer.parseInt(splits[4]), Integer.parseInt(splits[5]),
                    Integer.parseInt(splits[6]));
            Grafo nuevoSEV = new Grafo(splits[1], splits[0], Integer.parseInt(splits[2]),
                    Integer.parseInt(splits[3]), Integer.parseInt(splits[4]), Integer.parseInt(splits[5]),
                    Integer.parseInt(splits[6]));
            Datos.Datos.listaGrafosSiEsCaminando.add(nuevoSEV);
            Datos.Datos.listaGrafos.add(nuevo);
        }
    }

    private void agregarHorariosADatos(String linea) {
        String[] splits = linea.split("\\|");
        if (splits.length == 5) {
            Horario nuevo = new Horario(splits[0], splits[1], Integer.parseInt(splits[2]),
                    Integer.parseInt(splits[3]), Integer.parseInt(splits[4]));
            Datos.Datos.listaHorarios.add(nuevo);
        }

    }
}
