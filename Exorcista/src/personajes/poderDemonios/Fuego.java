/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderDemonios;

import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;
import static personajes.poderDemonios.Roca.DAÑO;
import sprite.Dibujo;

/**
 *
 * @author usuario
 */
public class Fuego extends Dibujo  {
    
    public static final int ANCHO = 50;
    public static final int ALTO = 50;
    public static final int DAÑO = 10;
    
    private int velocidad = 4;
    private Notificable notificador;
    private volatile boolean seLlego;
    
    private int objetivoX;
    private int objetivoY;
    
    private Angel objetivo;
       
    public Fuego(int x, int y, Image imagen, Notificable notificador, Angel objetivo) {
        super(x, y, ANCHO, ALTO, imagen);
        seLlego = false;
        
        this.notificador = notificador;
        this.objetivo = objetivo;
        
    }

    public void setObjetivoX(int objetivoX) {
        this.objetivoX = objetivoX;
    }

    public void setObjetivoY(int objetivoY) {
        this.objetivoY = objetivoY;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y,null);
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

        if (this.intersects(objetivo)) {

            objetivo.recibirImpacto(DAÑO);
            notificador.notificarCambios();
            return true;

        }

        notificador.notificarCambios();
        return seLlego;
    }
    
}
