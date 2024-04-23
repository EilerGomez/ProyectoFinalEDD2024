package utilidades;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reloj {

    private JLabel labelHora;
    private Timer timer;
    private int horaModificate;
    private int minuteModificate;
    private int secondModifcate;

    public Reloj(JLabel labelHora) {
        this.labelHora = labelHora;
        actualizarHora(false);
        iniciarActualizacionAutomatica(false);
    }

    private void iniciarActualizacionAutomatica(boolean editado) {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarHora(editado);
            }
        });
        timer.start();
    }

    private void actualizarHora(boolean editado) {
        if (editado) {
            modificarTiempos(horaModificate, minuteModificate, secondModifcate);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String horaActual = sdf.format(new Date());
            labelHora.setText(horaActual);
        }

    }

    public void modificarHora(String nuevaHora) {
        String[] splits = nuevaHora.split(":");
        this.horaModificate = Integer.parseInt(splits[0]);
        this.minuteModificate = Integer.parseInt(splits[1]);
        this.secondModifcate = Integer.parseInt(splits[2]);

        //labelHora.setText(nuevaHora);
        // Detener el temporizador actual
        timer.stop();
        // Iniciar un nuevo temporizador con la hora modificada
        iniciarActualizacionAutomaticaHoraEdit();
    }

    public void iniciarActualizacionAutomaticaHoraEdit() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarTiempos(horaModificate, minuteModificate, secondModifcate);
            }
        });
        timer.start();
    }

    private void modificarTiempos(int h, int m, int s) {
        if (secondModifcate <= 59) {
            secondModifcate++;
        } else {
            minuteModificate++;
            secondModifcate = 0;
            if (minuteModificate <= 59) {
            } else {
                horaModificate++;
                minuteModificate = 0;
                if (horaModificate > 23) {
                    horaModificate = 0;
                }
            }
        }

        labelHora.setText("" + horaModificate + ":" + minuteModificate + ":" + secondModifcate + "");
    }
}
