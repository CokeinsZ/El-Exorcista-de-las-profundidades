/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return (int) super.getWidth();
    }

    public void setAncho(int ancho) {
        width = ancho;
    }

    public int getAlto() {
        return (int) super.getHeight();
    }

    public void setAlto(int alto) {
        height = alto;
    }

    public Image getImagen() {
        return imagen;
    }
   
    
}
