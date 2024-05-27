/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import nivel.elementos.trampa.Inmovilizadora;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class DemonioHielo extends Demonio{
    public static final int ANCHO = 90;
    public static final int ALTO = 100; 
    
    private Image imagenTrampa;
    
    private int numMinas;
        
    public DemonioHielo(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagen, Image imagenTrampa, Agregable agregador, boolean tieneLlave) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen, agregador, tieneLlave);
        
        vida = 1;
        daño = 1;
        velocidad = 5;
        
        this.imagenTrampa = imagenTrampa;
        
        numMinas = 0;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }

    @Override
    public void seguirAngel() {
    }

    @Override
    public void atacar() {
        if (tieneEnfriamiento == true) {
            return;
        }
        
        enemigo.recibirImpacto(daño);
        iniciarEnfriamiento();
    }

    @Override
    public void mover() {

        if (x >= bordes.getXMax(y) - ANCHO && y <= bordes.getYMax(x) - ALTO) {
            // Mover hacia abajo si estamos en el borde derecho y no hemos llegado al borde inferior
            y += velocidad;
            
        } else if (y >= bordes.getYMax(x) - ALTO && x >= bordes.getXMin(y)) {
            // Mover hacia la izquierda si estamos en el borde inferior y no hemos llegado al borde izquierdo
            x -= velocidad;
            
        } else if (x <= bordes.getXMin(y) && y >= bordes.getYMin(x)) {
            // Mover hacia arriba si estamos en el borde izquierdo y no hemos llegado al borde superior
            y -= velocidad;
            
        } else {
            // Mover hacia la derecha si estamos en el borde superior o si no estamos en ningún borde
            x += velocidad;
        }
        
        if(enemigo.intersects(this)){
            atacar(); 
        }
        
        /*
        // Reducir los bordes después de cada vuelta
        bordes.setXMax(bordes.getXMax(y) - VELOCIDAD);
        bordes.setXMin(bordes.getXMin(y) + VELOCIDAD);
        bordes.setYMax(bordes.getYMax(x) - VELOCIDAD);
        bordes.setYMin(bordes.getYMin(x) + VELOCIDAD);
        */

        notificador.notificarCambios();
    }
    
    public void ponerTrampa() {
        if (numMinas >= 4)
            return;
        
        agregador.agregarTrampa(new Inmovilizadora(x, y, imagenTrampa, enemigo));
        numMinas += 1;
        
        notificador.notificarCambios();
    }

    private void iniciarEnfriamiento() {
        tieneEnfriamiento = true;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tieneEnfriamiento = false;
            }
        }, 3000);
    }

    
}
