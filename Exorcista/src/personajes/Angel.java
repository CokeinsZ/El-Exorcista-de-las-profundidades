/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import ayudas.Potenciador;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Alejandro
 */
public class Angel extends Rectangle{
    
    private float vida;
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private int[] posicionesAnteriores;
    
    private boolean seHizoClick;
    private int cX;
    private int cY;
    
    private Image imagenFondo;
    private void cargarImagen() throws IOException {
        try {
            this.imagenFondo = ImageIO.read(new File("src\\imagenes\\personajes\\angel\\angel.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Angel(int x, int y) throws IOException {
        super(x, y, 100, 100);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
        
        this.posicionesAnteriores = new int[] {x, y};
        
        this.seHizoClick = false;
        
        cargarImagen();
    }
    
    public Angel() throws IOException {
        super(0, 0, 100, 100);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
        
        this.posicionesAnteriores = new int[] {0, 0};
        
        this.seHizoClick = false;
        
        cargarImagen();
    }
    
    public void dibujarAngel (Graphics2D g) {
        //Limpia la posición donde anteriormente se encontraba el angel
        g.clearRect(posicionesAnteriores[0], posicionesAnteriores[1], width, height);
        
        //Dibuja la imagen y el rectangulo que contiene a la imagen
        g.drawImage(this.imagenFondo, this.x, this.y, null);
        g.draw(this);
    }

    public void mover(KeyEvent e) {
        
        this.posicionesAnteriores = new int[] {x, y};

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
    
    public void setPosicionRayos(boolean click, int x, int y) {
        this.seHizoClick = click;
        this.cX = x;
        this.cY = y;
                
    }

    public void lanzarRayo(Graphics2D g) {
        if (!seHizoClick)
            return;
        
        int posXrayo = this.x;
        int posYrayo = this.y;
        g.drawLine(posXrayo, posXrayo, posXrayo++, posXrayo++);
    }
    
}
