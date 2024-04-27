/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eiler
 */
public class Grafo {
    private String origen;
    private String destino;
    private int tiempo_vehiculo;
    private int tiempo_pie;
    private int consumo_gas;
    private int desgaste_personal;
    private int distancia;

    public Grafo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempo_vehiculo() {
        return tiempo_vehiculo;
    }

    public void setTiempo_vehiculo(int tiempo_vehiculo) {
        this.tiempo_vehiculo = tiempo_vehiculo;
    }

    public int getTiempo_pie() {
        return tiempo_pie;
    }

    public void setTiempo_pie(int tiempo_pie) {
        this.tiempo_pie = tiempo_pie;
    }

    public int getConsumo_gas() {
        return consumo_gas;
    }

    public void setConsumo_gas(int consumo_gas) {
        this.consumo_gas = consumo_gas;
    }

    public int getDesgaste_personal() {
        return desgaste_personal;
    }

    public void setDesgaste_personal(int desgaste_personal) {
        this.desgaste_personal = desgaste_personal;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Grafo(String origen, String destino, int tiempo_vehiculo, int tiempo_pie, int consumo_gas, int desgaste_personal, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.tiempo_vehiculo = tiempo_vehiculo;
        this.tiempo_pie = tiempo_pie;
        this.consumo_gas = consumo_gas;
        this.desgaste_personal = desgaste_personal;
        this.distancia = distancia;
    }
}
