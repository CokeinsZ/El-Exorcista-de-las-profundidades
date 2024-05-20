/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poder.angel;

import java.awt.Graphics2D;
import sprite.Dibujo;

/**
 *
 * @author salaz
 */
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Rayo extends Dibujo implements Runnable {

    private int velocidadRayo; // Velocidad del rayo
    private int direccionY; // Dirección del movimiento del rayo

    public Rayo(int x, int y) {
        super(x, y, 50, 200); // Tamaño del rayo
        this.velocidadRayo = 10; // Velocidad inicial del rayo
        this.direccionY = -1; // El rayo se moverá hacia arriba inicialmente
        try {
        cargarImagen("imagenes\\Rayo\\RayoAngel.jpg");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void dibujar(Graphics2D g) {
        // Dibujar la imagen del rayo
        g.drawImage(this.imagen, this.x, this.y, null);
        
 

    }

    public void setVelocidadRayo(int velocidadRayo) {
        this.velocidadRayo = velocidadRayo;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }

    @Override
    public void run() {
        while (this.y > 0 && this.y + this.height < bordes()) {
            try {
                Thread.sleep(30); // Pequeño retraso para suavizar el movimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.y += this.velocidadRayo * this.direccionY; // Mover el rayo en la dirección establecida
        }
        // Eliminar el rayo cuando salga del área visible
        this.y = -this.height;
    }

    private int bordes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
