/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.pared;

import java.awt.Graphics2D;
import java.io.IOException;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Puerta extends Dibujo {
    public static final int ANCHO = 100;
    public static final int ALTO = 100;

    public Puerta(int x, int y) throws IOException {
        super(x, y, ANCHO, ALTO);
        
        cargarImagen("imagenes\\paredes\\Puertas\\puerta2.png");
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, ANCHO, ALTO, null);
    }
    
}
