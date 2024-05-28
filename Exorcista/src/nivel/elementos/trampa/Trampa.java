/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import interfaces.Asesinable;
import java.awt.Image;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Trampa extends Dibujo {
    
    public static final int TIPO_MINA = 1;
    public static final int TIPO_AGUJERO = 2;
    public static final int TIPO_EMPUJE = 3;
    
    protected Asesinable objetivo;
    
    public Trampa(int x, int y, int ancho, int alto, Image imagen, Asesinable objetivo) {
        super(x, y, ancho, alto, imagen);
        
        this.objetivo = objetivo;
    }
    
    public abstract void accionar();
    
}
