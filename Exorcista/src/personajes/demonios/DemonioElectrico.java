/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Asesinable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alejandro
 */
public class DemonioElectrico extends Demonio {
    public static final int ANCHO = 84;
    public static final int ALTO = 124; 
        
    public DemonioElectrico(int posX, int posY, Delimitable bordes, Asesinable enemigo, Notificable notificador, Image imagen, Agregable agregador, boolean tieneLlave, double multiplicadorDaño) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen, agregador, tieneLlave);
        
        vida = 4;
        daño = 3 * multiplicadorDaño;
        velocidad = 5;
        
    }
        
    @Override
    public void seguirEnemigo() {
        
        int enemigoX = (int) enemigo.getX();
        int enemigoY = (int) enemigo.getY();

        // Comparar posiciones del demonio y el ángel para determinar dirección de movimiento
        if (x < enemigoX ) { //TO-DO Nombre para el estatico margen
            x += velocidad; // Mover hacia la derecha
        } else if (x > enemigoX && x > 0) {
            x -= velocidad; // Mover hacia la izquierda
        }

        if (y < enemigoY) {
            y += velocidad; // Mover hacia abajo
        } else if (y > enemigoY && y > 0) {
            y -= velocidad; // Mover hacia arriba
        }
        
        if(enemigo.intersects(this)){
            
            atacar();
            
        }
        
        notificador.notificarCambios(Notificable.EVENTO_MOVIMIENTO);
    }
    

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }


    @Override
    public void atacar() {
        if (tieneEnfriamiento == true) {
            return;
        }
        
        enemigo.recibirImpacto(daño);
        iniciarEnfriamiento();
    }
    
    
     private void iniciarEnfriamiento() {
        tieneEnfriamiento = true;

        Timer timer = new Timer(); //recibe un objeto timertask que es una interfaz la cual debemos de implementar y un time
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tieneEnfriamiento = false;
            }
        }, 3000);
    }

    @Override
    public void mover() {
        seguirEnemigo();
    }

    @Override
    public void accionEspecial() {
    }

    
    public void lanzarRayo(){
        
        
        
      
    }
    
   
}