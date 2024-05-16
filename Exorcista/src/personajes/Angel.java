
package personajes;

import interfaces.Delimitable;
import potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import sprite.Dibujo;


public class Angel extends Dibujo {
    
    public final static int ANCHO = 100;
    public final static int ALTO = 100;
    
    public final int VELOCIDAD = 10;
    
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
    
    public void setBordes(Delimitable bordes) {
        this.bordes = bordes;
    }
    
    public void lanzarRayos(Graphics2D contextoGrafico) {
    // Implementar la lógica para lanzar rayos al presionar la tecla de espacio (KeyEvent.VK_SPACE)
    // Por ejemplo, aquí suponemos que al presionar la tecla de espacio, se crea y dibuja un rayo en la posición del Angel
    
    // Verificar si se ha presionado la tecla de espacio
    
    }
        
}
