/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Alejandro
 */
public class DemonioFuego extends Demonio{
    public static final int ANCHO = 130;
    public static final int ALTO = 130; 
    
    private Image imagenFuego;
    
    public DemonioFuego(int posX, int posY) throws IOException {
        super(posX, posY, ANCHO, ALTO);
        
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
    
}
