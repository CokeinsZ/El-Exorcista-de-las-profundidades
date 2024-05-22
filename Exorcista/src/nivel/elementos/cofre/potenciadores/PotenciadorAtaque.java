/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre.potenciadores;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alejandro
 */
public class PotenciadorAtaque extends Potenciador {

    public PotenciadorAtaque(int x, int y, BufferedImage imagen) {
        super(x, y, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
