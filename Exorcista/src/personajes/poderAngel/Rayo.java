/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderAngel;

import interfaces.Notificable;
import interfaces.Verificable;
import java.awt.Graphics2D;
import java.awt.Image;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Rayo extends Dibujo{

    public static final int ANCHO = 80;
    public static final int ALTO = 20;
    
    private int velocidad = 1;
    private Notificable notificador;
    
    private Thread hiloMovimiento;
    private volatile boolean seLlego;
    
    private int objetivoX;
    private int objetivoY;
    
    private  Verificable verificador;
    
    public Rayo(int x, int y, Image imagen, Notificable notificador,Verificable verificador) {
        super(x, y, ANCHO, ALTO, imagen);
        seLlego = false;
        
        this.notificador = notificador;
        this.verificador = verificador;
        
    }

    public boolean isSeLlego() {
        return seLlego;
    }
    
    public void moverRayo(int x, int y) {
        this.objetivoX = x;
        this.objetivoY = y;
        
       // hiloMovimiento = new Thread(this);       
       // hiloMovimiento.start();
        
    }

    public void setObjetivoX(int objetivoX) {
        this.objetivoX = objetivoX;
    }

    public void setObjetivoY(int objetivoY) {
        this.objetivoY = objetivoY;
    }
    
    
  
    public boolean seguirPunto() {        
   
        if (this.x < objetivoX) { 
            this.x += velocidad; // Mover hacia la derecha
        } else if (this.x > objetivoX) {
            this.x -= velocidad; // Mover hacia la izquierda
        }

        if (this.y < objetivoY) {
            this.y += velocidad; // Mover hacia abajo
        } else if (this.y > objetivoY) {
            this.y -= velocidad; // Mover hacia arriba
        }
        
        if (this.x >= objetivoX-velocidad && this.x <= objetivoX+velocidad  && this.y >= objetivoY-velocidad && this.y <= objetivoY+velocidad )
            seLlego = true;
     
        notificador.notificarCambios();
        return verificador.verificarColision(this) || seLlego;
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }

    
    
    /*
    @Override
    public void run() {
        while (!seLlego) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rayo.class.getName()).log(Level.SEVERE, null, ex);
            }

            seguirPunto(objetivoX, objetivoY);
            boolean control = verificador.verificarColision(this);
            if(control){
                seLlego = true;
                
            }

        }
    }
    

    */

    public int getObjetivoX() {
        return objetivoX;
    }

    public int getObjetivoY() {
        return objetivoY;
    }
}