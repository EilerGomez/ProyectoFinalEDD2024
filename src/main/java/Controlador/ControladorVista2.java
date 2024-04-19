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

/**
 *
 * @author eiler
 */
public class ControladorVista2 {

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
}
