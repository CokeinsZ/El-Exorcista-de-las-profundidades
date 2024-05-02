/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import ayudas.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Angel extends Dibujo {
    
    public final static int ANCHO = 100;
    public final static int ALTO = 100;
    
    private float vida;
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
                
    private void cargarImagen() throws IOException {
        this.imagen = ImageIO.read(new File("imagenes\\personajes\\angel\\angel2.png"));
           
    }

    public Angel(int x, int y) throws IOException {
        super(x, y, ANCHO, ALTO);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
                        
        cargarImagen();
    }
        
    public void dibujarAngel (Graphics2D g) {
        
        //Dibuja la imagen
        g.drawImage(this.imagen, this.x, this.y, width, height, null);

    }

    public void mover(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_UP && y > 0){
            y -= 10;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN && y < 620) {
            //La ventana va hasta Y: 720 y el angel mide 100 de ancho, por lo que debe llegar solo hasta 720-100
            y += 10;
        }
            
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT && x < 980) {
            //La ventana va hasta X:1080 y el angel mide 100 de ancho, por lo que debe llegar solo hasta 1080-100
            x += 10;
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT && x > 0) {
            x -= 10;
        }
                       
    }
    
    public void lanzarRayos(Graphics2D contextoGrafico) {
        //TO-DO
    }
        
}
