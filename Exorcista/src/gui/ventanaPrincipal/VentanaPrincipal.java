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
        initComponents();
        setSize(ancho, alto);
        
        buffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paint(Graphics g){         
        Graphics2D contextoGrafico = (Graphics2D) g;
                
        Graphics2D graficosBuffer = buffer.createGraphics();
        graficosBuffer.clearRect(0, 0, getWidth(), getHeight());
        
        mazmorra.dibujar(graficosBuffer);
        
        contextoGrafico.drawImage(buffer, 0, 0, null);
                       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        mazmorra.manejarTecla(evt.getKeyCode());

    }//GEN-LAST:event_formKeyPressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        mazmorra.manejarClick(evt);
        
    }//GEN-LAST:event_formMousePressed

    @Override
    public void refrescar() {
        repaint();
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
