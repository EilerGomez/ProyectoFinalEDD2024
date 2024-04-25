package utilidades;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import static guru.nidi.graphviz.model.Factory.*;
import guru.nidi.graphviz.model.LinkSource;
import guru.nidi.graphviz.model.Node;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Grafo;

public class Graficar {

    public void graficarNuevoGrafoCompleto(ArrayList<ArrayList<Grafo>> lista, String ruta) {
        MutableGraph g = mutGraph("example2").setDirected(true);
        for (ArrayList<Grafo> arrayList : lista) {
            for (Grafo grafo : arrayList) {
                String origen = grafo.getOrigen();
                String destino = grafo.getDestino();

                // Agregar nodos al grafo
                Node nodoOrigen = node(origen).with(Label.of(origen));
                Node nodoDestino = node(destino).with(Label.of(destino));

                // Agregar una conexión entre los nodos con una flecha
                g.add(nodoOrigen.link(to(nodoDestino)).with(Label.of(origen)));
            }
        }
        try {
            // Generar el gráfico
            Graphviz.fromGraph(g).render(Format.PNG).toFile(new File(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Graficar.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("El gráfico se ha generado correctamente como mapa.png");

    }

    public void graficarGrafoCompleto(ArrayList<Grafo> lista, String carpeta, String nombre) {

        // Crear el gráfico
        MutableGraph g = mutGraph("example2").setDirected(true);

        // Agregar nodos y conexiones al grafo
        for (Grafo grafo : lista) {
            //String[] elementos = par.split("\\|"); // Dividir el par en sus elementos

            String origen = grafo.getOrigen();
            String destino = grafo.getDestino();

            // Agregar nodos al grafo
            Node nodoOrigen = node(origen).with(Label.of(origen));
            Node nodoDestino = node(destino).with(Label.of(destino));

            // Agregar una conexión entre los nodos con una flecha
            g.add(nodoOrigen.link(to(nodoDestino)).with(Label.of(origen)));

        }

        try {
            // Generar el gráfico
            Graphviz.fromGraph(g).render(Format.PNG).toFile(new File(carpeta + "/" + nombre + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Graficar.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("El gráfico se ha generado correctamente como arreglo.png");
    }

    public void graficarRutaPorRuta(ArrayList<Grafo> listaRutas, int index, int contadorImagenes, String carpeta, String nombre) {
        MutableGraph g = mutGraph("RutaporRuta").setDirected(true);
        for (Grafo grafo : listaRutas) {
            //String[] elementos = par.split("\\|"); // Dividir el par en sus elementos

            String origen = grafo.getOrigen();
            String destino = grafo.getDestino();

            // Agregar nodos al grafo
            Node nodoOrigen = node(origen).with(Label.of(origen));
            Node nodoDestino = node(destino).with(Label.of(destino));

            // Agregar una conexión entre los nodos con una flecha
            g.add(nodoOrigen.link(to(nodoDestino)).with(Label.of(origen)));

        }
        try {
            // Generar el gráfico
            Graphviz.fromGraph(g).render(Format.PNG).toFile(new File(
                    carpeta + "/"+nombre+"" + index + "_" + contadorImagenes + ".png"));
            System.out.println("Se ha guardado la imagen Ruta" + index + "_" + contadorImagenes + ".png");
        } catch (IOException ex) {
            Logger.getLogger(Graficar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Leer el arreglo de pares ingresado por el usuario
        System.out.println("Ingrese los pares separados por comas:");
        String input = scanner.nextLine();

        // Dividir la entrada en un arreglo de pares
        String[] pares = input.split(",");

        // Crear el gráfico
        MutableGraph g = mutGraph("example2").setDirected(true);

        // Agregar nodos y conexiones al grafo
        for (String par : pares) {
            String[] elementos = par.split("\\|"); // Dividir el par en sus elementos

            if (elementos.length == 2) { // Asegurarse de que haya exactamente dos elementos en el par
                String origen = elementos[0];
                String destino = elementos[1];

                // Agregar nodos al grafo
                Node nodoOrigen = node(origen).with(Label.of(origen));
                Node nodoDestino = node(destino).with(Label.of(destino));

                // Agregar una conexión entre los nodos con una flecha
                g.add(nodoOrigen.link(to(nodoDestino)).with(Label.of(origen)));
            } else {
                System.out.println("El par '" + par + "' no tiene el formato correcto y será omitido.");
            }
        }

        // Generar el gráfico
        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("Images/arreglo.png"));

        System.out.println("El gráfico se ha generado correctamente como arreglo.png");
        scanner.close();
    }
}
