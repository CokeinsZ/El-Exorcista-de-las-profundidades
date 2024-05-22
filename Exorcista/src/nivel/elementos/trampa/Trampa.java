/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import java.awt.Image;
import java.awt.image.BufferedImage;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Trampa extends Dibujo {
    public static final int ANCHO = 50;
    public static final int ALTO = 50;
    
    public static final int TIPO_MINA = 1;
    
    public Trampa(int x, int y, BufferedImage imagen) {
        super(x, y, ANCHO, ALTO, imagen);
    }
    
}
