package personajes.demonios.poder;

import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import personajes.Angel;
import sprite.Dibujo;

public class Roca extends Dibujo {

    private int velocidad;
    private boolean destinoAlcanzado = false;
    private Thread hiloMovimiento;
    private final Notificable notificador;
    private final Angel angel; // Referencia al ángel

    // Constructor
    public Roca(int x, int y, int ancho, int alto, Image imagen, int velocidad, Notificable notificador, Angel angel) {
        super(x, y, ancho, alto, imagen); // Llamada al constructor de Dibujo
        this.velocidad = velocidad;
        this.notificador = notificador;
        this.angel = angel;
    }

    public void moverRoca(int x, int y) {
        destinoAlcanzado = false;
        hiloMovimiento = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!destinoAlcanzado) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.getStackTrace();
                    }
                    
                    seguirPosicionAngel(x, y);
                    
                }
            }
        });        
        
        hiloMovimiento.start();
        
    }

    public void seguirPosicionAngel(int x, int y) {
        if (this.x < x) {
            this.x += velocidad; // Mover hacia la derecha
        } else if (this.x > x) {
            this.x -= velocidad; // Mover hacia la izquierda
        }

        if (this.y < y) {
            this.y += velocidad; // Mover hacia abajo
        } else if (this.y > y) {
            this.y -= velocidad; // Mover hacia arriba
        }

        if (this.x == x && this.y == y) {
            destinoAlcanzado = true;
            notificador.notificarCambios();
        }
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
}