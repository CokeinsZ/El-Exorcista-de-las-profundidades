/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.pared;

import nivel.elementos.pared.Pared;
import java.awt.Graphics2D;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class ParedEstructural extends Pared {

    public ParedEstructural(int x, int y) throws IOException {
        super(x, y);
        
        cargarImagen("imagenes\\paredes\\ParedEstructural2.png");
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
