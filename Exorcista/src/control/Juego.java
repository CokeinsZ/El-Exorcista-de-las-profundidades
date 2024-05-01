/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import mazmorra.Nivel;

import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class Juego {
    private int puntajeTotal;
    private int numNivel;

    private Angel angel;
    private ArrayList<Nivel> niveles;
    
    public Juego() throws IOException {
        this.puntajeTotal = 0;
        this.numNivel = 1;
        this.angel = new Angel(100, 100);  
        
        niveles = new ArrayList<>();
    }
    
    public void dibujarJuego(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        
        angel.dibujarAngel(g);
        angel.lanzarRayos(g);
        //niveles.get(numNivel - 1).dibujarNivel(g);
        
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
        //TO-DO
        
    }

    
    
}
