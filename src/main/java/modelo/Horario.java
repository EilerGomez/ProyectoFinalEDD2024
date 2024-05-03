/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Horario {
    private String origen;
    private String destino;
    private int hora_inicio;
    private int hora_finalizada;
    private int probabilidad_trafico;

    public Horario(String origen, String destino, int hora_inicio, int hora_finalizada, int probabilidad_trafico) {
        this.origen = origen;
        this.destino = destino;
        this.hora_inicio = hora_inicio;
        this.hora_finalizada = hora_finalizada;
        this.probabilidad_trafico = probabilidad_trafico;
    }

    public Horario() {
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

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_finalizada() {
        return hora_finalizada;
    }

    public void setHora_finalizada(int hora_finalizada) {
        this.hora_finalizada = hora_finalizada;
    }

    public int getProbabilidad_trafico() {
        return probabilidad_trafico;
    }

    public void setProbabilidad_trafico(int probabilidad_trafico) {
        this.probabilidad_trafico = probabilidad_trafico;
    }
    
}
