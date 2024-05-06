/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import java.awt.Graphics2D;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class DemonioElectrico extends Demonio{
    public static final int ANCHO = 130;
    public static final int ALTO = 130; 
    
    public DemonioElectrico(int posX, int posY) throws IOException {
        super(posX, posY, ANCHO, ALTO);
        
        cargarImagen("imagenes\\personajes\\demonios\\demonioInferior\\DemonioElectrico2.png");
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, width, height, null);
    }
    
}
