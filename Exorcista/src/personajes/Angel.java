/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import interfaces.Delimitable;
import potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Angel extends Dibujo {
    
    public final static int ANCHO = 100;
    public final static int ALTO = 100;
    
    public final int PASO = 10;
    
    private float vida;
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private Delimitable bordes;
                
    public Angel(int x, int y, Delimitable bordes) throws IOException {
        super(x, y, ANCHO, ALTO);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
                        
        cargarImagen("imagenes\\personajes\\angel\\angel2.png");
        
        this.bordes = bordes;
    }
        
    @Override
    public void dibujar (Graphics2D g) {
        
        //Dibuja la imagen
        g.drawImage(this.imagen, this.x, this.y, null);

    }

    public boolean mover(int codigo) {
        
        if (codigo == KeyEvent.VK_UP && y > 0){
            y -= PASO;
            return true;
        }
        
        if (codigo == KeyEvent.VK_DOWN && y < bordes.getAlto()- ALTO) {
            y += PASO;
            return true;
        }
            
        if (codigo == KeyEvent.VK_RIGHT && x < bordes.getAncho()- ALTO) {
            x += PASO;
            return true;
        }
            
        if (codigo == KeyEvent.VK_LEFT && x > 0) {
            x -= PASO;
            return true;
        }
                       
        return false;
    }
    
    public void setBordes(Delimitable bordes) {
        this.bordes = bordes;
    }
    
    public void lanzarRayos(Graphics2D contextoGrafico) {
        //TO-DO
    }
        
}
