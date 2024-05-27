/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import personajes.Angel;
import personajes.poderAngel.Rayo;
import personajes.poderDemonios.Roca;

/**
 *
 * @author Alejandro
 */
public class DemonioSelvatico extends Demonio{
    public static final int ANCHO = 92;
    public static final int ALTO = 98; 
    
    private boolean seLlego;
    private Image imagenRoca;
    
    public DemonioSelvatico(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagenDemonio, Image imagenRoca, Agregable agregador, boolean tieneLlave) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador, tieneLlave);
        
        vida = 7;
        daño = 2;
        velocidad = 0;
        
        this.imagenRoca = imagenRoca;
        this.seLlego = false;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }
    
    
    public void crearRocas() {
        
        Roca nuevoRoca = new Roca(this.x, this.y, imagenRoca, notificador,enemigo);
        nuevoRoca.setObjetivoX((int) enemigo.getX());
        nuevoRoca.setObjetivoY((int) enemigo.getY());

        agregador.agregarRoca(nuevoRoca);

        //nuevoRayo.moverRayo(x, y);
    
    }


    @Override
    public boolean atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mover() {   
    }

    @Override
    public void seguirAngel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
