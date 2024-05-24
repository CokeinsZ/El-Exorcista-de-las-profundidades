/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.pared;

import java.awt.Graphics2D;
import java.awt.Image;
import sprite.Dibujo;


public class Puerta extends Dibujo {
    public static final int ANCHO = 100;
    public static final int ALTO = 100;

    private Image imagenAbierta;
    
    public Puerta(int x, int y, Image imagenCerrada, Image imagenAbierta) {
        super(x, y, ANCHO, ALTO, imagenCerrada);
        
        this.imagenAbierta = imagenAbierta;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, ANCHO, ALTO, null);
    }

    public void abrir() {
        imagen = imagenAbierta;
    }
    
}
