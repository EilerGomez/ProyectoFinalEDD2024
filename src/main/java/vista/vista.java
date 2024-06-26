/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Controlador.ControladorRutas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import modelo.Grafo;
import utilidades.Graficar;
import utilidades.Reloj;

public class vista extends javax.swing.JFrame {
    String destino="";
    Controlador.ControladorRutas rutasController = new ControladorRutas();
    public int contadorImagenes = 1;
    public ArrayList<String> listaContadorImages = new ArrayList<>();
    ArrayList<ArrayList<Grafo>> rutas = new ArrayList<>();
    Reloj reloj;

    /**
     * Creates new form vista
     */
    public vista() {
        rutasController.eliminarContenidoCarpeta("ImagesTemp");
        initComponents();
        //llamarImagenGrafoCompleto();
        reloj = new Reloj(labelReloj);
        initOthersComponents(labelGrafo, jPanel1);
        initOthersComponents(labelRutaUnidad, jPanel2);
        this.btnVerRutas.setEnabled(false);
        this.vehiculoBTN.setSelected(true);

    }

    private void initOthersComponents(JLabel label, JPanel panel) {
        // Crear un JPanel que contendrá al JLabel con la imagen
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(label, BorderLayout.CENTER);

        // Crear un JScrollPane y agregar el JPanel a él
        JScrollPane scrollPane = new JScrollPane(imagePanel);

        // Establecer las propiedades del JScrollPane
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Establecer el tamaño preferido del JScrollPane para que no cambie
        scrollPane.setPreferredSize(new Dimension(500, 250)); // Establece el tamaño deseado aquí

        // Agregar el JScrollPane al JPanel pasado como argumento
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    private void llamarImagenGrafoCompleto(String direccion) {

        String imagePath = direccion + ".png";

        // Crear un ImageIcon con la imagen cargada desde el archivo
        ImageIcon icono = new ImageIcon(imagePath);

        // Asignar el ImageIcon al JLabel
        labelGrafo.setIcon(icono);
    }

    private void llamarImagenDeCadaRuta(String nameImg) {
        String imagePath;
        if (comboRutas.getSelectedIndex() < 0) {
            imagePath = "ImagesTemp/" + nameImg + "_" + listaContadorImages.get(0) + ".png";
        } else {
            imagePath = "ImagesTemp/" + nameImg + "_" + listaContadorImages.get(comboRutas.getSelectedIndex()) + ".png";

        }

        File imageFile = new File(imagePath);

        // Verificar si el archivo de imagen existe
        if (imageFile.exists()) {
            // Si el archivo existe, cargar la imagen
            ImageIcon icono = new ImageIcon(imagePath);
            labelRutaUnidad.setIcon(icono);
            System.out.println("Imagen " + nameImg + " cargada correctamente.");
        } else {
            // Si el archivo no existe, mostrar un mensaje de error o tomar otra acción según sea necesario
            System.out.println("La imagen " + nameImg + " no existe en el sistema de archivos.");
            // Aquí puedes mostrar un mensaje de error o tomar otra acción según tus necesidades
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrigen = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestino = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vehiculoBTN = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnVerRutas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelGrafo = new javax.swing.JLabel();
        comboRutas = new javax.swing.JComboBox<>();
        rutaUnitLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        labelReloj = new javax.swing.JLabel();
        labelMejorRuta = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelRutaUnidad = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaOrigen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaOrigen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrigenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrigen);

        tablaDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDestinoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDestino);

        jLabel1.setText("Origen");

        jLabel2.setText("Destino");

        vehiculoBTN.setText("Vehiculo");
        vehiculoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculoBTNActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Caminando");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        btnVerRutas.setText("Ver Rutas");
        btnVerRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRutasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGrafo)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        comboRutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione" }));
        comboRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRutasMouseClicked(evt);
            }
        });
        comboRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRutasActionPerformed(evt);
            }
        });

        rutaUnitLabel.setText("Ruta: ");

        jButton1.setText("Seleccionar ruta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        labelReloj.setText("jLabel3");

        labelMejorRuta.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRutaUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRutaUnidad)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Iniciar Viaje");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(vehiculoBTN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jRadioButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnVerRutas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboRutas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(rutaUnitLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(labelReloj, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(labelMejorRuta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rutaUnitLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelMejorRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerRutas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(labelReloj)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(vehiculoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(133, 133, 133))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelReloj)
                            .addComponent(jButton2))
                        .addGap(8, 8, 8)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vehiculoBTN)
                            .addComponent(jRadioButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerRutas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutaUnitLabel)
                            .addComponent(comboRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelMejorRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(5, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Principal", jDesktopPane1);

        jMenu2.setText("Archivo");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Cargar datos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaOrigenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrigenMouseClicked
        // TODO add your handling code here:
        if (tablaDestino.getSelectedRow() != -1) {
            this.btnVerRutas.setEnabled(true);
        }
    }//GEN-LAST:event_tablaOrigenMouseClicked

    private void tablaDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDestinoMouseClicked
        // TODO add your handling code here:
        if (tablaOrigen.getSelectedRow() != -1) {
            this.btnVerRutas.setEnabled(true);
        }
    }//GEN-LAST:event_tablaDestinoMouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        vehiculoBTN.setSelected(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void vehiculoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculoBTNActionPerformed
        // TODO add your handling code here:
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_vehiculoBTNActionPerformed

    private void btnVerRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRutasActionPerformed
       destino=tablaDestino.getValueAt(tablaDestino.getSelectedRow(), tablaDestino.getSelectedColumn()).toString();
        if (!rutasController.esDiferenteRuta(tablaDestino, tablaOrigen)) {
            rutas.clear();
            rutas = rutasController.encontrarRutas(
                    rutasController.nombreRuta(tablaOrigen),
                    rutasController.nombreRuta(tablaDestino), Datos.Datos.listaGrafos);
            if (!vehiculoBTN.isSelected()) {
                if (rutas.size() == 0) {
                    rutas = rutasController.encontrarRutas(
                            rutasController.nombreRuta(tablaOrigen),
                            rutasController.nombreRuta(tablaDestino), Datos.Datos.listaGrafosSiEsCaminando);
                }
            }
            System.out.println(rutas.size());
            int index = 1;
            for (ArrayList<Grafo> listaRuta : rutas) {
                System.out.println("Ruta: " + index++);
                for (Grafo grafo : listaRuta) {
                    System.out.println("Origen: " + grafo.getOrigen() + "    Desrino: " + grafo.getDestino());
                }
            }
            listaContadorImages.clear();
            Graficar graficar = new Graficar();
            int indice = 1;
            for (ArrayList<Grafo> ruta : rutas) {
                graficar.graficarRutaPorRuta(ruta, indice, contadorImagenes, "ImagesTemp", "Ruta");
                listaContadorImages.add("" + contadorImagenes);
                contadorImagenes++;
                indice++;
            }
            rutasController.llenarComboRutas(rutas, comboRutas);
            rutasController.mejorRuta(labelMejorRuta, rutas, vehiculoBTN.isSelected());

        }
         if (!vehiculoBTN.isSelected()) {
            //crear o graficar grafo dirigido
            rutasController.llenarTablaSiesCaminando(tablaDestino, Datos.Datos.listaGrafos, "Destinos");
            rutasController.llenarTablaSiesCaminando(tablaOrigen, Datos.Datos.listaGrafos, "Origenes");
        } else {
            rutasController.llenarTablasDestino(tablaDestino, Datos.Datos.listaGrafos);
            rutasController.llenarTablasOrigen(tablaOrigen, Datos.Datos.listaGrafos);
        }

    }//GEN-LAST:event_btnVerRutasActionPerformed

    private void comboRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRutasActionPerformed
        // TODO add your handling code here:
        this.rutaUnitLabel.setText("" + comboRutas.getSelectedItem());
        if (comboRutas.getSelectedIndex() >= 0) {
            rutasController.informacionDeRuta(jTextArea1, rutas.get(comboRutas.getSelectedIndex()), this.vehiculoBTN.isSelected(), labelReloj.getText());
        }
        llamarImagenDeCadaRuta("" + comboRutas.getSelectedItem());
    }//GEN-LAST:event_comboRutasActionPerformed

    private void comboRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRutasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_comboRutasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String imagePath = "ImagesTemp/" + comboRutas.getSelectedItem() + "_" + listaContadorImages.get(comboRutas.getSelectedIndex()) + ".png";

        vista2 vista2 = new vista2(this, vehiculoBTN.isSelected(), destino, "",
                imagePath, rutas.get(comboRutas.getSelectedIndex()));
        vista2.setVisible(true);
        vista2.setEnabled(true);
        vista2.setResizable(true);
        vista2.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.out.println("posible carga de datos");
        cargaDatos2 datos = new cargaDatos2();
        datos.setVisible(true);
        datos.setEnabled(true);
        datos.setResizable(false);
        datos.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nuevaHora = JOptionPane.showInputDialog(null, "Introduce la nueva hora (formato: HH:mm:ss):", "Modificar Hora", JOptionPane.PLAIN_MESSAGE);
        reloj.modificarHora(nuevaHora);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!vehiculoBTN.isSelected()) {
            //crear o graficar grafo dirigido
            rutasController.graficarGrafoDirigido();
            llamarImagenGrafoCompleto("Images/mapaDirigido");
            rutasController.llenarTablaSiesCaminando(tablaDestino, Datos.Datos.listaGrafos, "Destinos");
            rutasController.llenarTablaSiesCaminando(tablaOrigen, Datos.Datos.listaGrafos, "Origenes");
        } else {
            rutasController.graficarGrafoCompleto();///solo cuando es de vehiculo
            llamarImagenGrafoCompleto("Images/mapaCompleto");
            rutasController.llenarTablasDestino(tablaDestino, Datos.Datos.listaGrafos);
            rutasController.llenarTablasOrigen(tablaOrigen, Datos.Datos.listaGrafos);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    public void crearGrafoDirigido(ArrayList<Grafo> lista) {

        ArrayList<Grafo> listaTmp = new ArrayList<>();
        listaTmp = lista;
        System.out.println(listaTmp.size());
        for (int i = 0; i < lista.size(); i++) {

            Grafo tmp = new Grafo(lista.get(i).getDestino(), lista.get(i).getOrigen(), lista.get(i).getTiempo_vehiculo(), lista.get(i).getTiempo_pie(), lista.get(i).getConsumo_gas(), lista.get(i).getDesgaste_personal(), lista.get(i).getDistancia());
            listaTmp.add(tmp);
        }

        System.out.println(listaTmp.size());
        lista = listaTmp;

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerRutas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboRutas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelGrafo;
    private javax.swing.JLabel labelMejorRuta;
    private javax.swing.JLabel labelReloj;
    private javax.swing.JLabel labelRutaUnidad;
    private javax.swing.JLabel rutaUnitLabel;
    private javax.swing.JTable tablaDestino;
    private javax.swing.JTable tablaOrigen;
    private javax.swing.JRadioButton vehiculoBTN;
    // End of variables declaration//GEN-END:variables
}
