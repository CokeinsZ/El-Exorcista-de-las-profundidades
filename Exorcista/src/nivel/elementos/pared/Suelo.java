/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.pared;

import java.awt.Graphics2D;
import java.awt.Image;
import sprite.Dibujo;

/**
 *
 * @author salaz
 */
public class Suelo extends Dibujo{
    public static final int ANCHO = 100;
    public static final int ALTO = 100;
    
    public Suelo (int x, int y, Image imagen) {
        super(x, y, ANCHO, ALTO, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
        

    }
    
}