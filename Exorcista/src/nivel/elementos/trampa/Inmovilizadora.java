/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import interfaces.Asesinable;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Alejandro
 */
public class Inmovilizadora extends Trampa {

    public static final int ANCHO = 50;
    public static final int ALTO = 50; 
    
    public Inmovilizadora(int x, int y, Image imagen, Asesinable objetivo) {
        super(x, y, ANCHO, ALTO, imagen, objetivo);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }

    @Override
    public void accionar() {
        //TO-DO
        /*
        Animación de congelamiento
        */
        
        objetivo.paralizar();
    }
    
}
