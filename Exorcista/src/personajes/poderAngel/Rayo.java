/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderAngel;

import interfaces.Notificable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Rayo extends Dibujo {

    public static final int ANCHO = 80;
    public static final int ALTO = 20;
    
    private int velocidad = 50;
    private Notificable notificador;
    
    private Thread hiloMovimiento;
    private volatile boolean seLlego;
    
    public Rayo(int x, int y, Image imagen, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagen);
        seLlego = false;
        
        this.notificador = notificador;
        
    }
    
    public void seguirPunto(int x, int y) {
        hiloMovimiento = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!seLlego) {
                    //Logica movimiento
                }
            }
        });        
        
        hiloMovimiento.start();
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawOval(x, y, width, height);
        
        //g.drawImage(imagen, x, y, null);
    }
    
}
