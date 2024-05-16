/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.inicio;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class MenuInicio extends javax.swing.JDialog {

    public static final int EVENTO_INICIAR_JUEGO = 1;
    
    private int control;
    
    private Image imagenFondo;
    private Image imagenLogo;
    
    public int getControl() {
        return this.control;
    }
    
    /**
     * Creates new form MenuInicio
     */
    public MenuInicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setImagenes();
        
    }

   public void setImagenes() {
        try {
            this.imagenFondo = ImageIO.read(new File("imagenes\\menuInicio\\inicio.jpg"));
            this.imagenLogo = ImageIO.read(new File("imagenes\\icono\\logo.png"));
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error con la imagen", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, null);
    }
   
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bInicar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bInicar.setFont(new java.awt.Font("Wide Latin", 3, 18)); // NOI18N
        bInicar.setText("Iniciar Juego");
        bInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(bInicar)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(bInicar)
                .addContainerGap(517, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicarActionPerformed
        this.control = EVENTO_INICIAR_JUEGO;
        dispose();
    }//GEN-LAST:event_bInicarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bInicar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
