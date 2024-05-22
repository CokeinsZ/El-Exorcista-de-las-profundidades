/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.llave;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Llave extends Dibujo {

    public static final int ANCHO = 105;
    public static final int ALTO = 159;
    
    public Llave(int x, int y, BufferedImage imagen) {
        super(x, y, ANCHO, ALTO, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
