/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArbolB<T extends Comparable<T>> {

    private static final int M = 5; // Grado máximo del árbol B

    private Nodo<T> raiz;

    // Constructor
    public ArbolB() {
        raiz = new Nodo<>(M, true); // Inicialmente la raíz es una hoja
    }

    // Método para insertar un elemento en el árbol
    public void insertar(T valor, int indiceTabla) {
        // Si la raíz está llena, se debe dividir
        if (raiz.getNumElementos() == M - 1) {
            Nodo<T> nuevaRaiz = new Nodo<>(M, false);
            nuevaRaiz.getHijos().add(raiz);
            raiz.dividir(0, raiz, nuevaRaiz);
            // Actualizar la raíz
            raiz = nuevaRaiz;
        }
        raiz.insertarNoLleno(valor, indiceTabla);
    }

    // Método para imprimir el árbol (recorrido inorden)
    public void imprimir() {
        raiz.imprimir();
    }

    // Clase interna estática para representar los nodos del árbol
    public class Nodo<T extends Comparable<T>> {

        private int numElementos; // Número de elementos en el nodo
        private List<T> valores;
        private ArrayList<String> valorTabla;
        private List<Nodo<T>> hijos;
        private boolean esHoja;

        // Constructor
        public Nodo(int grado, boolean hoja) {
            this.numElementos = 0;
            this.esHoja = hoja;
            this.valores = new ArrayList<>(grado - 1);
            this.hijos = new ArrayList<>(grado);
            this.valorTabla=new ArrayList<>();
        }

        // Métodos para obtener el número de elementos y si es hoja
        public int getNumElementos() {
            return numElementos;
        }

        public boolean esHoja() {
            return esHoja;
        }

        // Método para obtener la lista de hijos
        public List<Nodo<T>> getHijos() {
            return hijos;
        }

        // Método para insertar un valor en un nodo que no está lleno
        public void insertarNoLleno(T valor, int indiceTabla) {
            int i = numElementos - 1;
            if (esHoja) {
                while (i >= 0 && valor.compareTo(valores.get(i)) < 0) {
                    i--;
                }
                valores.add(i + 1, valor);
                valorTabla.add(""+indiceTabla);
                numElementos++;
            } else {
                // Encontrar el hijo en el que se debe insertar el valor
                while (i >= 0 && valor.compareTo(valores.get(i)) < 0) {
                    i--;
                }
                int indiceHijo = i + 1;
                // Si el hijo está lleno, dividirlo antes de insertar
                if (hijos.get(indiceHijo).getNumElementos() == M - 1) {
                    dividir(indiceHijo, hijos.get(indiceHijo), this);
                    if (valor.compareTo(valores.get(indiceHijo)) > 0) {
                        indiceHijo++;
                    }
                }
                hijos.get(indiceHijo).insertarNoLleno(valor, indiceTabla);
            }
        }

        // Método para dividir un hijo lleno del nodo
        public void dividir(int indice, Nodo<T> nodoLleno, Nodo<T> nodoPadre) {
            Nodo<T> nuevoNodo = new Nodo<>(M, nodoLleno.esHoja());
            nuevoNodo.numElementos = M / 2;

            // Mover los valores y los hijos al nuevo nodo
            for (int j = 0; j < M / 2; j++) {
                nuevoNodo.valores.add(nodoLleno.valores.remove(M / 2));
            }

            if (!nodoLleno.esHoja()) {
                for (int j = 0; j <= M / 2; j++) {
                    nuevoNodo.hijos.add(nodoLleno.hijos.remove(M / 2));
                }
            }

            // Insertar el valor medio en el nodo padre
            nodoPadre.valores.add(indice, nodoLleno.valores.remove(M / 2 - 1));
            nodoPadre.hijos.add(indice + 1, nuevoNodo);
            nodoLleno.numElementos = M / 2 - 1;
            nodoPadre.numElementos++;
        }

        // Método para imprimir el nodo y sus hijos recursivamente
        public void imprimir() {
            for (int i = 0; i < numElementos; i++) {
                if (!esHoja) {
                    hijos.get(i).imprimir();
                }
                System.out.print(valores.get(i) + " ");
            }
            if (!esHoja) {
                hijos.get(numElementos).imprimir();
            }
        }

    }

    // Método para graficar el árbol B utilizando Graphviz
    public void graficar(String archivoDot, String archivoImagen) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(archivoDot)))) {
            out.println("digraph ArbolB {");
            out.println("node [shape=record];");

            // Llamada a un método recursivo para generar las definiciones de nodos y enlaces
            graficarNodo((Nodo<T>) raiz, out);

            out.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generar la imagen utilizando Graphviz
        try {
            ProcessBuilder builder = new ProcessBuilder("dot", "-Tpng", archivoDot, "-o", archivoImagen);
            Process proceso = builder.start();
            int estado = proceso.waitFor();
            if (estado == 0) {
                System.out.println("Imagen del árbol generada correctamente: " + archivoImagen);
            } else {
                System.out.println("Error al generar la imagen del árbol.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar recursivo para generar la definición de nodos y enlaces
    private void graficarNodo(Nodo<T> nodo, PrintWriter out) {
        out.print("\"" + nodo.hashCode() + "\" [label=\"");

        // Agregar valores del nodo al label
        for (int i = 0; i < M - 1; i++) {
            if (i < nodo.getNumElementos()) {
                out.print("<f" + i + ">" + nodo.valores.get(i));
            } else {
                out.print("|<f" + i + ">" + " ");
            }
            if (i < nodo.getNumElementos() - 1) {
                out.print("|");
            }
        }
        out.println("\"];");

        // Generar enlaces a los hijos
        for (int i = 0; i <= nodo.getNumElementos(); i++) {
            if (!nodo.esHoja() && i < nodo.hijos.size()) {
                graficarNodo(nodo.hijos.get(i), out); // Llamada recursiva
                out.println("\"" + nodo.hashCode() + "\":f" + i + " -> \"" + nodo.hijos.get(i).hashCode() + "\";");
            }
        }
    }

    // Método main para probar la implementación
    public static void main(String[] args) {
        ArbolB<Integer> arbol = new ArbolB<>();
        arbol.insertar(5,0);
        arbol.insertar(6,0);
        arbol.insertar(10,0);
        arbol.insertar(12,0);
        arbol.insertar(20,0);
        arbol.insertar(30,0);
        arbol.insertar(40,0);
        arbol.insertar(55,0);
        arbol.insertar(33,0);
        arbol.insertar(1,0);
        arbol.insertar(28,0);
        arbol.insertar(14,0);
        arbol.imprimir();
        arbol.graficar("arbolb.dot", "arbolb.png");
    }
}
