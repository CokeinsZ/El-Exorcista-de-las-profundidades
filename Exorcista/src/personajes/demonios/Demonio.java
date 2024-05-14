/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Delimitable;
import interfaces.Notificable;
import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Demonio extends Dibujo {
    public static final int TIPO_SUPERIOR = 1;
    public static final int TIPO_FUEGO = 2;
    public static final int TIPO_ELECTRICO = 3;
    public static final int TIPO_SELVATICO = 4;
    public static final int TIPO_HIELO = 5;

    protected int vida;
    protected int daño;
    protected int velocidad;
    protected Angel enemigo;
    
    protected Notificable notificador;
    
    protected Delimitable bordes;
    
    public Demonio(int x, int y, int width, int height, Delimitable bordes, Angel enemigo, Notificable notificador) {
        super(x, y, width, height);
        this.bordes = bordes;
        this.enemigo = enemigo;
        
        this.notificador = notificador;
    }
        
    public abstract void seguirAngel();
    public abstract boolean atacar();
    public abstract void mover();
    public abstract void recibirImapcto(int daño);
    
}