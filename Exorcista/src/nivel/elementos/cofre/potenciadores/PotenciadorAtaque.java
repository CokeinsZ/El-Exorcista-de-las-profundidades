/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre.potenciadores;

import interfaces.Delimitable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class PotenciadorAtaque extends Potenciador {

    public PotenciadorAtaque(int x, int y, Image imagen) {
        super(x, y, imagen);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }

    @Override
    public String toString() {
        return "Ataque";
    }

    @Override
    public void accionar(Delimitable bordes) {
        double r = bordes.getAncho() / 2.0;
        int rInt = (int) r; // Convertir a int para iterar  
        int centerX = (int) angel.getX();
        int centerY = (int) angel.getY();

        for (int x = -rInt; x <= rInt; x++) {
            int y = (int) Math.sqrt(r * r - x * x);
            angel.lanzarRayos(centerX + x, centerY + y);
            angel.lanzarRayos(centerX + x, centerY - y);
        }

        for (int y = -rInt; y <= rInt; y++) {
            int x = (int) Math.sqrt(r * r - y * y);
            angel.lanzarRayos(centerX + x, centerY + y);
            angel.lanzarRayos(centerX - x, centerY + y);
        }
        
    }

    
    
}
