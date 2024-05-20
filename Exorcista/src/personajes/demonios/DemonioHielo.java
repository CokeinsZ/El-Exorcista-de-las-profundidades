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
    public static final int ANCHO = 80;
    public static final int ALTO = 80; 
    
    private final int VELOCIDAD = 30;
    
    public DemonioHielo(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagen) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen);
        
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

    @Override
    public void recibirImapcto(int daño) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
