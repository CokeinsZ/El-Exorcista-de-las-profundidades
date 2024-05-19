/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import java.awt.Graphics2D;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class Mina extends Trampa{

    public Mina(int x, int y) throws IOException {
        super(x, y);
        
        cargarImagen("imagenes\\trampas\\mina2.png");
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, this.x, this.y, null);
    }
    
}
