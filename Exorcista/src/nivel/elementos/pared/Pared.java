/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.pared;

import java.awt.Graphics2D;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Pared extends Dibujo{
    public static final int TIPO_ESTRUCTURAL = 1;
    public static final int TIPO_EFIMERA = 3;
    public static final int TIPO_ESPINAS = 2;
    
    public static final int ANCHO = 20;
    public static final int ALTO = 20;

    public Pared(int x, int y) {
        super(x, y, ANCHO, ALTO);
    }

    
}
