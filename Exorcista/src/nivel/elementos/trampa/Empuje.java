/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import interfaces.Asesinable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class Empuje extends Trampa {

    public static final int ANCHO = 50;
    public static final int ALTO = 75; 
    
    public Empuje(int x, int y, Image imagen, Asesinable objetivo) {
        super(x, y, ANCHO, ALTO, imagen, objetivo);
    }

    @Override
    public void accionar() {
        Random r = new Random();
        int direccion = r.nextInt(37, 41);
        
        for (int i = 0; i < 15; i++) {
            objetivo.mover(direccion);
        }
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
