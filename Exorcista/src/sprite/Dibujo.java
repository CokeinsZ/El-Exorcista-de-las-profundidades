/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Alejandro
 */
public abstract class Dibujo extends Rectangle {
        
    protected Image imagen;

    public Dibujo(int x, int y, int ancho, int alto, Image imagen) {
        super(x, y, ancho, alto);      
        
        this.imagen = imagen;
    }
    
    public abstract void dibujar(Graphics2D g);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getAncho() {
        return (int) super.getWidth();
    }

    public int getAlto() {
        return (int) super.getHeight();
    }   
    
}
