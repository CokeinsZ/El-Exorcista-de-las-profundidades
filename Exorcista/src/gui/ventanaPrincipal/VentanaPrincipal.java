/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.ventanaPrincipal;

import control.Mazmorra;
import interfaces.Refrescable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import nivel.elementos.cofre.potenciadores.Potenciador;

/**
 *
 * @author Alejandro
 */
public class VentanaPrincipal extends javax.swing.JFrame 
                              implements Refrescable {

    private Mazmorra mazmorra;
    
    private BufferedImage buffer;

    public void setMazmorra(Mazmorra mazmorra) {
        this.mazmorra = mazmorra;
    }
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal(int ancho, int alto) {
        mazmorra = null;
        setSize(ancho, alto);
        
        buffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        
        initComponents();
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D contextoGrafico = (Graphics2D) g;

                Graphics2D graficosBuffer = buffer.createGraphics();
                graficosBuffer.clearRect(0, 0, getWidth(), getHeight());

                mazmorra.dibujar(graficosBuffer);

                contextoGrafico.drawImage(buffer, 0, 0, null);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lVida = new javax.swing.JLabel();
        lEnergia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lAlmas = new javax.swing.JLabel();
        lPotenciadores = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lNumNivel = new javax.swing.JLabel();
        lDemoniosRestantes = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vida");

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Energia");

        lVida.setBackground(new java.awt.Color(255, 0, 0));
        lVida.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lVida.setForeground(new java.awt.Color(255, 255, 255));
        lVida.setText("100");

        lEnergia.setBackground(new java.awt.Color(255, 0, 0));
        lEnergia.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lEnergia.setForeground(new java.awt.Color(255, 255, 255));
        lEnergia.setText("10");

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Almas Liberadas");

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Potenciadores");

        lAlmas.setBackground(new java.awt.Color(255, 0, 0));
        lAlmas.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lAlmas.setForeground(new java.awt.Color(255, 255, 255));
        lAlmas.setText("0");

        lPotenciadores.setBackground(new java.awt.Color(255, 0, 0));
        lPotenciadores.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lPotenciadores.setForeground(new java.awt.Color(255, 255, 255));
        lPotenciadores.setText("0");

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NumNivel");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DemoniosRestantes");

        lNumNivel.setBackground(new java.awt.Color(255, 0, 0));
        lNumNivel.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lNumNivel.setForeground(new java.awt.Color(255, 255, 255));
        lNumNivel.setText("1");

        lDemoniosRestantes.setBackground(new java.awt.Color(255, 0, 0));
        lDemoniosRestantes.setFont(new java.awt.Font("Dutch801 Rm BT", 2, 18)); // NOI18N
        lDemoniosRestantes.setForeground(new java.awt.Color(255, 255, 255));
        lDemoniosRestantes.setText("10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lVida)
                    .addComponent(lEnergia))
                .addGap(281, 281, 281)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lPotenciadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lAlmas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNumNivel)
                    .addComponent(lDemoniosRestantes))
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lVida)
                        .addComponent(jLabel6)
                        .addComponent(lAlmas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lNumNivel))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lEnergia)
                    .addComponent(jLabel7)
                    .addComponent(lPotenciadores)
                    .addComponent(jLabel11)
                    .addComponent(lDemoniosRestantes))
                .addContainerGap(611, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        mazmorra.manejarTecla(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         mazmorra.manejarClick(evt, getGraphics());
    }//GEN-LAST:event_formMousePressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        mazmorra.manejarTecla(evt.getKeyCode());
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
         mazmorra.manejarClick(evt, getGraphics());
    }//GEN-LAST:event_jPanel1MousePressed

    @Override
    public void refrescar() {
        cargarInformacion();
        
        repaint();
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lAlmas;
    private javax.swing.JLabel lDemoniosRestantes;
    private javax.swing.JLabel lEnergia;
    private javax.swing.JLabel lNumNivel;
    private javax.swing.JLabel lPotenciadores;
    private javax.swing.JLabel lVida;
    // End of variables declaration//GEN-END:variables

    private void cargarInformacion() {
        lVida.setText("" + mazmorra.getAngel().getVida());
        lEnergia.setText("" + mazmorra.getAngel().getEnergia());
        lAlmas.setText("" + mazmorra.getAngel().getAlmas());
        
        lPotenciadores.setText("");
        for(Potenciador p: mazmorra.getAngel().getPotenciadores()){
            if(p == null)
                continue;
            
            lPotenciadores.setText(lPotenciadores.getText() + p.toString());
        }
        
        lNumNivel.setText("" + mazmorra.getNivelActual().getNumNivel());
        lDemoniosRestantes.setText("" + mazmorra.getNivelActual().getDemoniosRestantes());
    }
}
