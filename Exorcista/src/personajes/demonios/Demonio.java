/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Demonio extends Dibujo{
    public static final int TIPO_SUPERIOR = 1;
    public static final int TIPO_FUEGO = 2;
    public static final int TIPO_ELECTRICO = 3;
    public static final int TIPO_SELVATICO = 4;
    public static final int TIPO_HIELO = 5;

    
    
    public Demonio(int posX, int posY, int ancho, int alto) {
        super(posX, posY, ancho, alto);
    }
        
}