
package personajes;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import interfaces.Delimitable;
import potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import poder.angel.Rayo;
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

public Rayo crearRayo() {
    // Crear un nuevo objeto Rayo
    Rayo rayo = new Rayo(this.x + ANCHO / 2, this.y);

    // Cargar la imagen del rayo
    try {
        cargarImagen("imagenes\\Rayo\\RayoAngel.jpg");
    } catch (IOException e) {
        e.printStackTrace();
    }

    return rayo;
}



    
    public void setBordes(Delimitable bordes) {
        this.bordes = bordes;
    }
    
    public void lanzarRayos(Graphics2D contextoGrafico) {
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (e.getButton() == MouseEvent.BUTTON1) { // Verifica si se ha hecho clic con el botón izquierdo del ratón
                Rayo rayo = crearRayo();
                rayo.setDireccionY((e.getY() < y) ? -1 : 1); // Establecer la dirección del rayo según la posición del clic
                // Crear un nuevo hilo para el rayo y comenzar su movimiento
                Thread rayoThread = new Thread(rayo);
                rayoThread.start();
            }
        }
    });
  }
}