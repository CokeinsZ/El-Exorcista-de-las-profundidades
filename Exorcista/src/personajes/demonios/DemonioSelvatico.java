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

/**
 *
 * @author Alejandro
 */
public class DemonioSelvatico extends Demonio{
    public static final int ANCHO = 92;
    public static final int ALTO = 98; 
    
    private boolean seLlego;
    private Image imagenRoca;
    
    public DemonioSelvatico(int posX, int posY, Delimitable bordes, Angel enemigo, Notificable notificador, Image imagenDemonio, Image imagenRoca, Agregable agregador) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador);
        
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

   public boolean seguirPunto() {        
   
        if (this.x < enemigo.getX()) { 
            this.x += velocidad; // Mover hacia la derecha
        } else if (this.x > enemigo.getX()) {
            this.x -= velocidad; // Mover hacia la izquierda
        }

        if (this.y < enemigo.getY()) {
            this.y += velocidad; // Mover hacia abajo
        } else if (this.y > enemigo.getY()) {
            this.y -= velocidad; // Mover hacia arriba
        }
        
        if (this.x == enemigo.getX() && this.y == enemigo.getY()){
            seLlego = true;
            notificador.notificarCambios();
            return true;
            
        }
      
        return false;
        
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
