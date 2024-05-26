/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import personajes.Angel;
import static personajes.demonios.DemonioElectrico.ALTO;
import static personajes.demonios.DemonioElectrico.ANCHO;

/**
 *
 * @author Alejandro
 */
public class DemonioFuego extends Demonio{
    public static final int ANCHO = 85;
    public static final int ALTO = 125; 
    
    private Image imagenFuego;
    
    public DemonioFuego(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagenDemonio, Image imagenFuego, Agregable agregador) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador);
        
        vida = 5;
        daño = 2;
        velocidad = 0;
        
        this.imagenFuego = imagenFuego;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y,null);
    }

    @Override
    public void seguirAngel() {
        return;
    }

    @Override
    public boolean atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mover() {
        return;
    }

    
}
