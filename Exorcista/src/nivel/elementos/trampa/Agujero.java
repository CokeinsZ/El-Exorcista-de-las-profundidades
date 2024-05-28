/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import interfaces.Asesinable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class Agujero extends Trampa {
    
    public static final int ANCHO = 76;
    public static final int ALTO = 60; 

    public Agujero(int x, int y, Image imagen, Asesinable objetivo) {
        super(x, y, ANCHO, ALTO, imagen, objetivo);
    }


    @Override
    public void accionar() {
        objetivo.recibirImpacto(10);
        objetivo.setLocation(x-10, y-10);
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
}
