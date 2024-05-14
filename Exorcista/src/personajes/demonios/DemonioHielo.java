/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Delimitable;
import java.awt.Graphics2D;
import java.io.IOException;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class DemonioHielo extends Demonio{
    public static final int ANCHO = 100;
    public static final int ALTO = 100; 
    
    public DemonioHielo(int posX, int posY, Delimitable bordes, Angel enemigo) throws IOException {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo);
        
        cargarImagen("imagenes\\personajes\\demonios\\demonioInferior\\DemonioHielo2.png");
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, width, height, null);
    }

    @Override
    public void seguirAngel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void recibirImapcto(int daño) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
