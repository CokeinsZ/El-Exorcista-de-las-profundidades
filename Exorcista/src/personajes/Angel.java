/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Angel extends Dibujo {
    
    public final static int ANCHO = 90;
    public final static int ALTO = 90;
    
    public final int VELOCIDAD = 10;
    
    private float vida;
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private Delimitable bordes;
                
    public Angel(int x, int y, Delimitable bordes, Image[] imagenes) {
        super(x, y, ANCHO, ALTO, imagenes[ConstantesComunes.IMAGEN_ANGEL]);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
                                
        this.bordes = bordes;
    }
        
    @Override
    public void dibujar (Graphics2D g) {
        
        //Dibuja la imagen
        g.drawImage(this.imagen, this.x, this.y, null);

    }

    public boolean mover(int codigo) {
        
        if (codigo == KeyEvent.VK_UP && y > 0){
            y -= VELOCIDAD;
            return true;
        }
        
        if (codigo == KeyEvent.VK_DOWN && y < bordes.getAlto()- ALTO) {
            y += VELOCIDAD;
            return true;
        }
            
        if (codigo == KeyEvent.VK_RIGHT && x < bordes.getAncho()- ALTO) {
            x += VELOCIDAD;
            return true;
        }
            
        if (codigo == KeyEvent.VK_LEFT && x > 0) {
            x -= VELOCIDAD;
            return true;
        }
                       
        return false;
    }
    
    public void revertirMovimiento(int xAnterior, int yAnterior) {
            // Revertir la posición del ángel a las coordenadas anteriores
            this.x = xAnterior;
            this.y = yAnterior;
  }
    
    public void setBordes(Delimitable bordes) {
        this.bordes = bordes;
    }
    
    public void lanzarRayos(Graphics2D contextoGrafico) {
        //TO-DO
    }
        
}
