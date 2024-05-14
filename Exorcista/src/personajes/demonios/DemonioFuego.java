/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Delimitable;
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
    public static final int ANCHO = 130;
    public static final int ALTO = 130; 
    
    private Image imagenFuego;
    
    public DemonioFuego(int posX, int posY, Delimitable bordes, Angel enemigo) throws IOException {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo);
        
        cargarImagenes();
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, width, height, null);
    }

    private void cargarImagenes() throws IOException {
        imagen = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\DemonioFuego2.png"));
        
        imagenFuego = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\fire2.png"));
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
