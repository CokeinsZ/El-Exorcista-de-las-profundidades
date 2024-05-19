/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre.potenciadores;

import java.awt.Graphics2D;

/**
 *
 * @author Alejandro
 */
public class PotenciadorAtaque extends Potenciador {

    public PotenciadorAtaque(int x, int y) {
        super(x, y);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
