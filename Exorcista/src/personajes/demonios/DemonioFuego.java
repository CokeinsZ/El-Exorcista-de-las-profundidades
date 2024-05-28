/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;
import personajes.poderDemonios.Fuego;

/**
 *
 * @author Alejandro
 */
public class DemonioFuego extends Demonio{
    public static final int ANCHO = 85;
    public static final int ALTO = 125; 
    
    private Image imagenFuego;
    
    public DemonioFuego(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagenDemonio, Image imagenFuego, Agregable agregador, boolean tieneLlave) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador, tieneLlave);
        
        vida = 5;
        daño = 2;
        velocidad = 0;
        
        this.imagenFuego = imagenFuego;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y,null);
    }
    
    public void crearFuego(){
        
        Fuego nuevoFuego= new Fuego(this.x, this.y, imagenFuego, notificador, enemigo);
        nuevoFuego.setObjetivoX((int) enemigo.getX());
        nuevoFuego.setObjetivoY((int) enemigo.getY());

        agregador.agregarFuego(nuevoFuego);
        notificador.notificarCambios(Notificable.EVENTO_LANZAR_FUEGO);
    
    }

    @Override
    public void seguirAngel() {
        return;
    }

    @Override
    public void atacar() {
    }

    @Override
    public void mover() {
    }

    @Override
    public void accionEspecial() {
        
        crearFuego();
        
    }

    
}
