/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author eiler
 */
public class Hoja {
    private int llave;//valor con el que se va almacenar cada Hoja
    private double valor;//el id del arraylist

    public Hoja(int ll, double valor) {
        this.llave=ll;
        this.valor=valor;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
