/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Grafo;
import modelo.Horario;
import utilidades.ArbolB;
import utilidades.Graficar;
import utilidades.Hoja;

/**
 *
 * @author eiler
 */
public class ControladorVista2 {

    ControladorRutas controllerR = new ControladorRutas();
    ArbolB arbolB = new ArbolB();
    Graficar graficar = new Graficar();

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

    public void llenarComboFuncionalidades(JComboBox combo) {
        combo.addItem("La mejor ruta en base a la gasolina (si es en vehiculo)");
        combo.addItem("La mejor ruta en base al desgaste físico (si es caminando)");
        combo.addItem("La mejor ruta en base a la distancia");
        combo.addItem("La mejor ruta en base a la gasolina y la distancia (si es en vehículo)");
        combo.addItem("La mejor ruta en base al desgaste físico y la distancia (si es caminando)");
        combo.addItem("La ruta más rápida en base a la distancia, tiempo y probabilidad de tráfico (TSV)");
    }

    public void generarArbolesBEImagenes(int funcionalidad, ArrayList<ArrayList<Grafo>> lista, int contador, boolean isVehiculo, JLabel labelReloj) {
        arbolB = new ArbolB();
        switch (funcionalidad) {
            case 0://en base a la gasolina si es vehiculo
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo += grafo.getConsumo_gas();
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                System.out.println("Menor: " + devolverValorMenor(arbolB.valorTabla));
                System.out.println("Mayor: " + devolverValorMayor(arbolB.valorTabla));
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 0, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 0, contador, "ImagesArbolesB", "RutaMax");
                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
            case 1:
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo += grafo.getDesgaste_personal();
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 1, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 1, contador, "ImagesArbolesB", "RutaMax");

                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
            case 2:
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo += grafo.getDistancia();
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 2, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 2, contador, "ImagesArbolesB", "RutaMax");

                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
            case 3:
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo += (grafo.getDistancia() + grafo.getConsumo_gas());
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 3, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 3, contador, "ImagesArbolesB", "RutaMax");
                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
            case 4:
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo += (grafo.getDistancia() + grafo.getDesgaste_personal());
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 4, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 4, contador, "ImagesArbolesB", "RutaMax");
                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
            case 5:
                for (int i = 0; i < lista.size(); i++) {
                    double consumo = 0;
                    for (Grafo grafo : lista.get(i)) {
                        consumo+=traerVelocidad(isVehiculo, grafo, labelReloj.getText());
                    }
                    arbolB.insertar(consumo, i, consumo);
                }
                graficar.graficarRutaPorRuta(lista.get(devolverValorMenor(arbolB.valorTabla)), 5, contador, "ImagesArbolesB", "RutaMin");
                graficar.graficarRutaPorRuta(lista.get(devolverValorMayor(arbolB.valorTabla)), 5, contador, "ImagesArbolesB", "RutaMax");
                arbolB.graficar("ImagesArbolesB/Arbolb.dot", "ImagesArbolesB/arolbB" + funcionalidad + "" + contador + ".png", lista);
                break;
        }
    }

    public int propabilidadTrafico(Grafo grafo, JLabel labelReloj) {
        int probabilidad = 0;
        String[] splits = labelReloj.getText().split(":");
        Horario h = controllerR.traerHorario(grafo);
        if (Integer.parseInt(splits[0]) >= h.getHora_inicio() && Integer.parseInt(splits[0]) <= h.getHora_finalizada()) {
            probabilidad = h.getProbabilidad_trafico();
        }

        return probabilidad;
    }

    public int devolverValorMenor(ArrayList<Hoja> valor) {
        int indexTabla = 0;
        double menor = 0;
        for (Hoja hoja : valor) {
            if (menor == 0) {
                menor = hoja.getValor();
                indexTabla = hoja.getLlave();
            } else {
                if (hoja.getValor() < menor) {
                    menor = hoja.getValor();
                    indexTabla = hoja.getLlave();
                }
            }

        }
        return indexTabla;
    }

    public int devolverValorMayor(ArrayList<Hoja> valor) {
        int indexTabla = 0;
        double menor = 0;
        for (Hoja hoja : valor) {
            if (menor == 0) {
                menor = hoja.getValor();
                indexTabla = hoja.getLlave();
            } else {
                if (hoja.getValor() > menor) {
                    menor = hoja.getValor();
                    indexTabla = hoja.getLlave();
                }
            }

        }
        return indexTabla;
    }
    
    public double traerVelocidad(boolean esVehiculo, Grafo grafo,String reloj){
        double velocidad=0;
        if(esVehiculo){
             velocidad += (double) grafo.getDistancia() / ((double) grafo.getTiempo_vehiculo() * (1 + controllerR.porbabilidadTrafico(reloj,grafo)));
        }else{
            velocidad=(double)grafo.getDistancia()/(double)grafo.getTiempo_pie();
        }
        
        return velocidad;
    }
}
