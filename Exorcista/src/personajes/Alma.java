/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import java.awt.Graphics2D;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Alma extends Dibujo {
    
    public Alma(int posX, int posY, int ancho, int alto) {
        super(posX, posY, ancho, alto);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
