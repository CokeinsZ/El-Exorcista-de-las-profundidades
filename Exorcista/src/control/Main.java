/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import gui.inicio.MenuInicio;
import gui.ventanaPrincipal.VentanaPrincipal;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        VentanaPrincipal ventana = new VentanaPrincipal(1280, 720);
        
        MenuInicio menu = new MenuInicio(ventana, true);
        menu.setSize(1080, 720);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        if (menu.getControl() != MenuInicio.EVENTO_INICIAR_JUEGO)
            System.exit(0);
        
        Mazmorra mazmorra = null;
        try {
            mazmorra = new Mazmorra(ventana.getWidth(), ventana.getHeight(), ventana);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ventana, "No se pudo cargar la imagen", "Error con la imagen", JOptionPane.ERROR_MESSAGE);
        }
        
        ventana.setMazmorra(mazmorra);
        ventana.setLocationRelativeTo(null);
        
        ventana.setVisible(true);

    }
}
