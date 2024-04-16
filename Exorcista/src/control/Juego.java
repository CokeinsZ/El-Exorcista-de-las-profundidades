/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import mazmorra.Mundo;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class Juego {
    private int puntajeTotal;
    private Angel angel;
    private ArrayList<Mundo> mundos;

    public Juego() throws IOException {
        this.puntajeTotal = 0;
        this.angel = new Angel(100, 100);
    }
    
    public void dibujarNivel(Graphics2D g) {
        angel.dibujarAngel(g);
    }

    public void manejarTecla(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_LEFT){
            
            angel.mover(e);
        }
    }

    public void manejarClick(MouseEvent evt) {
        int x = evt.getX();
        int y = evt.getY();
        
        angel.lanzarRayo(x, y);
    }

    
    
}
