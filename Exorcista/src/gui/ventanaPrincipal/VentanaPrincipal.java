/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.ventanaPrincipal;

import control.Mazmorra;
import interfaces.ConstantesComunes;
import interfaces.Notificable;
import interfaces.Refrescable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
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
    
    private Clip[] sonidos;
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal(int ancho, int alto) throws UnsupportedAudioFileException, IOException {
        mazmorra = null;
        setSize(ancho, alto);
        
        buffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        
        sonidos = new Clip[20];
        
        cargarSonidos();
        initComponents();
        ponerIconos();
    
    }
    
    private void cargarSonidos() throws UnsupportedAudioFileException, IOException {
        String[] rutasSonidos = {
            "Sonidos/MuerteDemonio_1.wav",
            "Sonidos/LanzarRayoAngel.wav",
            "Sonidos/LanzarBolaFuego.wav",


            // ... (Rutas de los demás sonidos)
        };

        for (int i = 0; i < rutasSonidos.length; i++) {
            cargarSonido(rutasSonidos[i], i);
        }
    }

    private void cargarSonido(String rutaSonido, int indice) throws UnsupportedAudioFileException, IOException {
        try (AudioInputStream stream = AudioSystem.getAudioInputStream(new File(rutaSonido))) {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            sonidos[indice] = clip;
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            // Implementar mecanismo para notificar al usuario
        }
    }
    
    private void ponerIconos() {
        jLabel2.setIcon(new ImageIcon("imagenes/Iconos/Vidas.png"));
        jLabel3.setIcon(new ImageIcon("imagenes/Iconos/Energía.png"));
        jLabel6.setIcon(new ImageIcon("imagenes/Iconos/Almas Liberadas.png"));
        jLabel7.setIcon(new ImageIcon("imagenes/Iconos/Potenciadores.png"));
        jLabel10.setIcon(new ImageIcon("imagenes/Iconos/Número de niveles.png"));
        jLabel11.setIcon(new ImageIcon("imagenes/Iconos/Demonios Restantes.png"));
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
        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vida");

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Energia");

        lVida.setBackground(new java.awt.Color(255, 0, 0));
        lVida.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lVida.setForeground(new java.awt.Color(255, 255, 255));
        lVida.setText("100");

        lEnergia.setBackground(new java.awt.Color(255, 0, 0));
        lEnergia.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lEnergia.setForeground(new java.awt.Color(255, 255, 255));
        lEnergia.setText("10");

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Almas Liberadas");

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Potenciadores");

        lAlmas.setBackground(new java.awt.Color(255, 0, 0));
        lAlmas.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lAlmas.setForeground(new java.awt.Color(255, 255, 255));
        lAlmas.setText("0");

        lPotenciadores.setBackground(new java.awt.Color(255, 0, 0));
        lPotenciadores.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lPotenciadores.setForeground(new java.awt.Color(255, 255, 255));
        lPotenciadores.setText("0");

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NumNivel");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DemoniosRestantes");

        lNumNivel.setBackground(new java.awt.Color(255, 0, 0));
        lNumNivel.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lNumNivel.setForeground(new java.awt.Color(255, 255, 255));
        lNumNivel.setText("1");

        lDemoniosRestantes.setBackground(new java.awt.Color(255, 0, 0));
        lDemoniosRestantes.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
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
                .addGap(256, 256, 256)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lAlmas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(58, 58, 58)
                        .addComponent(lPotenciadores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNumNivel)
                    .addComponent(lDemoniosRestantes))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lAlmas))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lPotenciadores)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lVida))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lNumNivel))))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lEnergia)
                            .addComponent(jLabel11)
                            .addComponent(lDemoniosRestantes))))
                .addContainerGap(613, Short.MAX_VALUE))
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
         mazmorra.manejarClick(evt);
    }//GEN-LAST:event_formMousePressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        mazmorra.manejarTecla(evt.getKeyCode());
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
         mazmorra.manejarClick(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    @Override
    public void refrescar(int cambio) {
        cargarInformacion();

        switch (cambio) {
            case Notificable.EVENTO_MUERTE_DEMONIO:
                reproducirSonido(ConstantesComunes.SONIDO_MUERTE_DEMONIO);
                break;
            case Notificable.EVENTO_MUERTE_ANGEL:
                // Código para manejar el evento de muerte de ángel
                break;
            case Notificable.EVENTO_LANZAR_RAYO:
                reproducirSonido(ConstantesComunes.SONIDO_LANZAR_RAYO);
                break;
            case Notificable.EVENTO_LANZAR_FUEGO:
                reproducirSonido(ConstantesComunes.SONIDO_LANZAR_FUEGO);
                break;
            case Notificable.EVENTO_LANZAR_ROCA:
                // Código para manejar el evento de lanzar roca
                break;
            case Notificable.EVENTO_FIN_NIVEL:
                // Código para manejar el evento de fin de nivel
                break;
            case Notificable.EVENTO_COFRE_ABIERTO:
                // Código para manejar el evento de cofre abierto
                break;
            case Notificable.EVENTO_TORNADO:
                // Código para manejar el evento de tornado
                break;
            case Notificable.EVENTO_NUEVA_MINA:
                // Código para manejar el evento de nueva mina
                break;
            case Notificable.EVENTO_ACTIVACION_MINA:
                // Código para manejar el evento de activación de mina
                break;
            case Notificable.EVENTO_ACTIVACION_INMOVILIZADOR:
                // Código para manejar el evento de activación de inmovilizador
                break;
            case Notificable.EVENTO_ACTIVACION_AGUJERO:
                // Código para manejar el evento de activación de agujero
                break;
            case Notificable.EVENTO_POTENCIADOR_VIDA:
                // Código para manejar el evento de potenciador de vida
                break;
            case Notificable.EVENTO_POTENCIADOR_ATAQUE:
                // Código para manejar el evento de potenciador de ataque
                break;
            default:
                // Código para manejar cualquier otro caso
                break;
        }

        repaint();
    }

    private void reproducirSonido(int indice) {
        try {
            if (sonidos[indice] != null) {
                sonidos[indice].stop();
                sonidos[indice].setFramePosition(0);
                sonidos[indice].start();
            }
        } catch (Exception e) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
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
            
            lPotenciadores.setText(lPotenciadores.getText() + ", " + p.toString());
        }
        
        if (mazmorra.getNivelActual() == null) {
            cargarInformacion();
            return;
        }
        lNumNivel.setText("" + mazmorra.getNivelActual().getNumNivel());
        lDemoniosRestantes.setText("" + mazmorra.getNivelActual().getDemoniosRestantes());
    }

    @Override
    public void finalizarJuego() {
        GameOver dialogo = new GameOver(this, true);
        dialogo.setVisible(true);
        
        if(dialogo.getControl() == false) {
            System.exit(0);
        }
        
        try {
            mazmorra.reiniciarJuego( );
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            
        }
        
    }
}
