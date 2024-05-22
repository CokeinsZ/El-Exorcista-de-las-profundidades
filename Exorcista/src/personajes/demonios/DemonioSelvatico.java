/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class DemonioSelvatico extends Demonio{
    public static final int ANCHO = 80;
    public static final int ALTO = 80; 
    
    private Image imagenRoca;
    
    public DemonioSelvatico(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, BufferedImage imagenDemonio, BufferedImage imagenRoca) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio);
        
        vida = 7;
        daño = 2;
        velocidad = 0;
        
        this.imagenRoca = imagenRoca;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }

    @Override
    public void seguirAngel() {
    }

    @Override
    public boolean atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mover() {   
    }

}
