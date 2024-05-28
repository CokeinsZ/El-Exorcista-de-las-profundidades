/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.demonios;

import interfaces.Agregable;
import interfaces.Asesinable;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import nivel.elementos.trampa.Inmovilizadora;

/**
 *
 * @author Alejandro
 */
public class DemonioHielo extends Demonio{
    public static final int ANCHO = 90;
    public static final int ALTO = 100; 
    
    private Image imagenTrampa;
    private int direccion;
    private int numMinas;
        
    public DemonioHielo(int posX, int posY, Delimitable bordes, Asesinable enemigo, Notificable notificador, Image imagen, Image imagenTrampa, Agregable agregador, boolean tieneLlave, double multiplicadorDaño) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagen, agregador, tieneLlave);
        
        vida = 1;
        daño = 1 * multiplicadorDaño;
        velocidad = 5;
        
        direccion = 39;
        
        this.imagenTrampa = imagenTrampa;
        
        numMinas = 0;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }

    @Override
    public void atacar() {
        if (tieneEnfriamiento == true) {
            return;
        }
        
        enemigo.recibirImpacto(daño);
        iniciarEnfriamiento();
    }
    
    private void cambiarDireccion() {
        Random r = new Random();
        direccion = r.nextInt(37, 41);
    }
    
    public void mover() {        
        int xAnterior = x;
        int yAnterior = y;
        
        switch (direccion) {
            case KeyEvent.VK_UP -> {
                y -= velocidad;
            }
            
            case KeyEvent.VK_DOWN -> {
                y += velocidad;
            }
            
            case KeyEvent.VK_RIGHT -> {
                x += velocidad;
            }
            
            case KeyEvent.VK_LEFT -> {
                x -= velocidad;
            }
            
        }
        
        if (bordes.tocaBorde(this)) {
            revertirMovimiento(xAnterior, yAnterior);
            cambiarDireccion();
        }
        
        notificador.notificarCambios(Notificable.EVENTO_MOVIMIENTO);
    }
    
    public void revertirMovimiento(int xAnterior, int yAnterior) {
        this.x = xAnterior;
        this.y = yAnterior;
    }
    
    public void ponerTrampa() {
        if (numMinas >= 4)
            return;
        
        agregador.agregarTrampa(new Inmovilizadora(x, y, imagenTrampa, enemigo));
        numMinas += 1;
        
        notificador.notificarCambios(Notificable.EVENTO_NUEVA_MINA);
    }

    private void iniciarEnfriamiento() {
        tieneEnfriamiento = true;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tieneEnfriamiento = false;
            }
        }, 3000);
    }

    @Override
    public void accionEspecial() {
        ponerTrampa();
    }

    @Override
    public void seguirEnemigo() {
    }

    
}
