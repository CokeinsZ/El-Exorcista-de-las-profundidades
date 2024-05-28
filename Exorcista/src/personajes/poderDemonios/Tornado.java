/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderDemonios;

import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author usuario
 */
public class Tornado extends Dibujo {
    
    public static final int ANCHO = 50;
    public static final int ALTO = 50;
    public static final int DAÑO = 10;

    private int velocidad = 4;
    private Notificable notificador;
    private volatile boolean seLlego;

    private int objetivoX;
    private int objetivoY;

    private Angel objetivo;

    public Tornado(int x, int y, Image imagen, Notificable notificador, Angel objetivo) {
        super(x, y, ANCHO, ALTO, imagen);
        seLlego = false;

        this.notificador = notificador;
        this.objetivo = objetivo;

    }

    @Override
    public void dibujar(Graphics2D g) {
        
        g.drawImage(imagen, x, y,null);

        
    }
    
    public void atraerAngel(){
        
        objetivo.seguirPunto(this.x, this.y);
        
    }
    
}
