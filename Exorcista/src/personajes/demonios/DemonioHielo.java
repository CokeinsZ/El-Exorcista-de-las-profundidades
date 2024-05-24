/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class DemonioHielo extends Demonio{
    public static final int ANCHO = 90;
    public static final int ALTO = 100; 
        
    public DemonioHielo(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagen) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen);
        
        vida = 1;
        daño = 1;
        velocidad = 5;
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }

    @Override
    public void seguirAngel() {
    }

    @Override
    public boolean atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    @Override
    public void mover() {
        Random random = new Random();
        int direccion = random.nextInt(1, 5);
        
        switch (direccion) {
            case 1:
                if (y > bordes.getYMin(x)) {
                    y -= VELOCIDAD;
                }
                break;

            case 2:
                if (y < bordes.getYMax(x)) {
                    y += VELOCIDAD;
                }
                break;

            case 3:
                if (x < bordes.getXMax(y)) {
                    x += VELOCIDAD;
                }
                break;

            case 4:
                if (x > bordes.getXMin(y)) {
                    x -= VELOCIDAD;
                }
                break;

            default:
                break;
        }
        
        notificador.notificarCambios();
    }
    */
    
    @Override
    public void mover() {
        System.out.println("XMax  " + bordes.getXMax(y));
        System.out.println("xMin  " + bordes.getXMin(y));
        System.out.println("YMax  " + bordes.getYMax(x));
        System.out.println("YMIn  " + bordes.getXMin(y));
 
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
        
        

        /*
        // Reducir los bordes después de cada vuelta
        bordes.setXMax(bordes.getXMax(y) - VELOCIDAD);
        bordes.setXMin(bordes.getXMin(y) + VELOCIDAD);
        bordes.setYMax(bordes.getYMax(x) - VELOCIDAD);
        bordes.setYMin(bordes.getYMin(x) + VELOCIDAD);
        */

        notificador.notificarCambios();
    }

    
}
