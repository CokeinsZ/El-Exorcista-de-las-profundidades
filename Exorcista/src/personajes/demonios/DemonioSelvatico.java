/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Asesinable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.poderDemonios.Roca;

/**
 *
 * @author Alejandro
 */
public class DemonioSelvatico extends Demonio{
    public static final int ANCHO = 92;
    public static final int ALTO = 98; 
    
    private Image imagenRoca;
    
    public DemonioSelvatico(int posX, int posY, Delimitable bordes, Asesinable enemigo, Notificable notificador, Image imagenDemonio, Image imagenRoca, Agregable agregador, boolean tieneLlave, double multiplicadorDaño) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador, tieneLlave);
        
        vida = 7;
        daño = 2 * multiplicadorDaño;
        velocidad = 0;
        
        this.imagenRoca = imagenRoca;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }
    
    
    public void crearRocas() {
        
        Roca nuevoRoca = new Roca(this.x, this.y, imagenRoca, notificador,enemigo);

        agregador.agregarRoca(nuevoRoca);
    
    }


    @Override
    public void atacar() {
    }

    @Override
    public void mover() { 
    }

    @Override
    public void accionEspecial() {

        crearRocas();
    }

    @Override
    public void seguirEnemigo() {
    }

}
