/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderAngel;

import interfaces.Notificable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Rayo extends Dibujo {

    public static final int ANCHO = 80;
    public static final int ALTO = 20;
    
    private int velocidad = 1;
    private Notificable notificador;
    
    private Thread hiloMovimiento;
    private volatile boolean seLlego;
    
    public Rayo(int x, int y, Image imagen, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagen);
        seLlego = false;
        
        this.notificador = notificador;
        
    }

    public boolean isSeLlego() {
        return seLlego;
    }
    
    public void moverRayo(int x, int y) {
        hiloMovimiento = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!seLlego) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Rayo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    seguirPunto(x, y);
                    
                }
            }
        });        
        
        hiloMovimiento.start();
        
    }
    
    
     public void seguirPunto(int x, int y ) {        
   
        if (this.x < x) { 
            this.x += velocidad; // Mover hacia la derecha
        } else if (this.x > x) {
            this.x -= velocidad; // Mover hacia la izquierda
        }

        if (this.y < y) {
            this.y += velocidad; // Mover hacia abajo
        } else if (this.y > y) {
            this.y -= velocidad; // Mover hacia arriba
        }
        
        if (this.x == x && this.y == y)
            seLlego = true;
     
        notificador.notificarCambios();
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
