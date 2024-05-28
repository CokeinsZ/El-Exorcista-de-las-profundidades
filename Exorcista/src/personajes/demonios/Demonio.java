/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Asesinable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Image;
import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public abstract class Demonio extends Dibujo {
    public static final int TIPO_SUPERIOR = 0;
    public static final int TIPO_HIELO = 1;
    public static final int TIPO_SELVATICO = 2;
    public static final int TIPO_FUEGO = 3;
    public static final int TIPO_ELECTRICO = 4;

    protected int vida;
    protected double daño;
    protected int velocidad;
    protected Asesinable enemigo;
    
    protected boolean tieneLlave;
    protected boolean tieneEnfriamiento;
    
    protected Notificable notificador;
    protected Agregable agregador;    
    protected Delimitable bordes;
    
    public Demonio(int x, int y, int width, int height, Delimitable bordes, Asesinable enemigo, Notificable notificador, Image imagen, Agregable agregador, boolean tieneLlave) {
        super(x, y, width, height, imagen);
        this.bordes = bordes;
        this.enemigo = enemigo;
        
        this.tieneLlave = tieneLlave;
        
        this.notificador = notificador;
        this.agregador = agregador;
        tieneEnfriamiento = false;
    }
        
    public abstract void seguirEnemigo();
    public abstract void atacar();
    public abstract void mover();
    
    public boolean recibirImapcto(int daño) {
        vida -= daño;
        
        return vida <= 0;
    }
    
    public boolean tieneLlave() {
        return tieneLlave;
    }
    
    public abstract void accionEspecial();
    
}