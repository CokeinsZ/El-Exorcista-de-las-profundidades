/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre.potenciadores;

import interfaces.Delimitable;
import java.awt.Image;
import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Potenciador extends Dibujo {
    public static final int TIPO_VIDA = 1;
    public static final int TIPO_ATAQUE = 2;
    
    public static final int ANCHO = 100;
    public static final int ALTO = 100;
    
    protected Angel angel;

    public Potenciador(int x, int y, Image imagen) {
        super(x, y, ANCHO, ALTO, imagen);
    }
    
    public void setAngel(Angel angel) {
        this.angel = angel;
    }
    
    public abstract void accionar(Delimitable bordes);

    
    
}
