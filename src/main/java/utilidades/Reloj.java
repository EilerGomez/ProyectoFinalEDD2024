/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author eiler
 */
public class Reloj {
    JLabel labelHora= new JLabel();
    public Reloj(JLabel labelHora) {
        this.labelHora=labelHora;


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarHora(labelHora);
            }
        });
        timer.start();

    }
    private void actualizarHora(JLabel labelHora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaActual = sdf.format(new Date());
        labelHora.setText(horaActual);
    }
}
