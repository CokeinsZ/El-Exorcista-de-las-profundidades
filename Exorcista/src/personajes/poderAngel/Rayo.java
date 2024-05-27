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
    
    private int velocidad = 7;
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
    
    
    /*
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
    
    */

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    

    public boolean seguirPunto() {
        
        boolean seLlego = false;

        // Calcular la distancia en cada eje
        double deltaX = objetivoX - this.x;
        double deltaY = objetivoY - this.y;

        // Calcular la distancia total
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Calcular las proporciones de movimiento
        double proporcionX = deltaX / distancia;
        double proporcionY = deltaY / distancia;

        // Calcular los nuevos valores de x e y basados en la velocidad y las proporciones
        if (distancia > velocidad) {
            this.x += proporcionX * velocidad;
            this.y += proporcionY * velocidad;
        } else {
            // Si estamos cerca del objetivo, mover directamente al objetivo
            this.x = objetivoX;
            this.y = objetivoY;
            seLlego = true;
        }

        notificador.notificarCambios();
        return verificador.verificarColision(this) || seLlego;
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