/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre.potenciadores;

import interfaces.Delimitable;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Alejandro
 */
public class PotenciadorVida extends Potenciador {

    public PotenciadorVida(int x, int y, Image imagen) {
        super(x, y, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }

    @Override
    public String toString() {
        return "Vida";
    }

    @Override
    public void accionar(Delimitable bordes) {
        angel.recuperarVida();
    }
    
    
    
}
