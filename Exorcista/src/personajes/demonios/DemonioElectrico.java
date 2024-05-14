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
public class DemonioElectrico extends Demonio {
    public static final int ANCHO = 130;
    public static final int ALTO = 130; 
    
    private Thread hiloSeguirAngel;
    
    public DemonioElectrico(int posX, int posY, Delimitable bordes, Angel enemigo) throws IOException {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo);
        
        cargarImagen("imagenes\\personajes\\demonios\\demonioInferior\\DemonioElectrico.png");
        setHiloSeguirAngel();
    }
    
    public void setHiloSeguirAngel() {
        hiloSeguirAngel = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    seguirAngel();
                    try {
                        Thread.sleep(100); // Sleep for 100 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        hiloSeguirAngel.start();
    }

        
    @Override
    public void seguirAngel() {        
        int angelX = (int) enemigo.getX();
        int angelY = (int) enemigo.getY();

        // Comparar posiciones del demonio y el ángel para determinar dirección de movimiento
        if (x < angelX) {
            x += velocidad; // Mover hacia la derecha
        } else if (x > angelX) {
            x -= velocidad; // Mover hacia la izquierda
        }

        if (y < angelY) {
            y += velocidad; // Mover hacia abajo
        } else if (y > angelY) {
            y -= velocidad; // Mover hacia arriba
        }

    }
    

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, width, height, null);
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
