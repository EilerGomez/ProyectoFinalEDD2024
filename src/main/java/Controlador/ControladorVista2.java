/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Grafo;
import utilidades.ArbolB;

/**
 *
 * @author eiler
 */
public class ControladorVista2 {
    
    ArbolB arbolB = new ArbolB();

    public void llenarTablaDePosicionesOLugares(JTable tabla, ArrayList<Grafo> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Lugar");
        String[] fila = new String[1];
        if (lista.size() == 1) {
            fila[0] = lista.get(0).getDestino();
            modelo.addRow(fila);
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (i == lista.size() - 1) {
                    fila[0] = lista.get(i).getOrigen();
                    modelo.addRow(fila);
                    fila[0] = lista.get(i).getDestino();
                    modelo.addRow(fila);
                } else if (i > 0) {
                    fila[0] = lista.get(i).getOrigen();
                    modelo.addRow(fila);
                }
            }
        }

        tabla.setModel(modelo);

    }

    public void llenarComboConRutas(JComboBox combo, ArrayList<ArrayList<Grafo>> lista) {
        System.out.println("Llenando combo de segunda vista");
        int indice = 1;
        combo.removeAllItems();
        for (ArrayList<Grafo> arrayList : lista) {
            combo.addItem("Ruta" + indice);
            indice++;
        }
    }
    
    public void llenarComboFuncionalidades(JComboBox combo){
        combo.addItem("La mejor ruta en base a la gasolina (si es en vehiculo)");
        combo.addItem("La mejor ruta en base al desgaste físico (si es caminando)");
        combo.addItem("La mejor ruta en base a la distancia");
        combo.addItem("La mejor ruta en base a la gasolina y la distancia (si es en vehículo)");
        combo.addItem("La mejor ruta en base al desgaste físico y la distancia (si es caminando)");
        combo.addItem("La ruta más rápida en base a la distancia, tiempo y probabilidad de tráfico (TSV)");
    }
    
    public void generarArbolesBEImagenes(int funcionalidad, ArrayList<ArrayList<Grafo>> lista){
        arbolB= new ArbolB();
        switch(funcionalidad){
            case 0://en base a la gasolina si es vehiculo
                for (int i = 0; i < lista.size(); i++) {
                    int consumo=0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo+=grafo.getConsumo_gas();
                    }
                    arbolB.insertar(consumo, i);
                }
                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB.png");
                break;
        }
    }
}
