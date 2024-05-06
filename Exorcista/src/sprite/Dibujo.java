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

    public Dibujo(int posX, int posY, int ancho, int alto) {
        super(posX, posY, ancho, alto);
        
    }
    
    protected void cargarImagen(String ruta) throws IOException {
        imagen = ImageIO.read(new File(ruta));
    }
    
    public abstract void dibujar(Graphics2D g);

    public int getPosX() {
        return (int) super.getX();
    }

    public void setPosX(int posX) {
        x = posX;
    }

    public int getPosY() {
        return (int) super.getY();
    }

    public void setPosY(int posY) {
        y = posY;
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
