/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import interfaces.ConstantesComunes;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Alma extends Dibujo {
    public static final int ANCHO = 80;
    public static final int ALTO = 80;
    
    public Alma(int posX, int posY, Image imagen) {
        super(posX, posY, ANCHO, ALTO, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
