/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class DemonioElectrico extends Demonio {
    public static final int ANCHO = 84;
    public static final int ALTO = 124; 
        
    public DemonioElectrico(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagen, Agregable agregador, boolean tieneLlave) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen, agregador, tieneLlave);
        
        vida = 4;
        daño = 3;
        velocidad = 5;
        
    }
        
    @Override
    public void seguirAngel() {
        
        int angelX = (int) enemigo.getX();
        int angelY = (int) enemigo.getY();

        // Comparar posiciones del demonio y el ángel para determinar dirección de movimiento
        if (x < angelX ) { //TO-DO Nombre para el estatico margen
            x += velocidad; // Mover hacia la derecha
        } else if (x > angelX && x > 0) {
            x -= velocidad; // Mover hacia la izquierda
        }

        if (y < angelY) {
            y += velocidad; // Mover hacia abajo
        } else if (y > angelY && y > 0) {
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
        seguirAngel();
    }

    @Override
    public void accionEspecial() {
    }

    
}
