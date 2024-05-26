/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import control.HiloMovimientoRayo;
import interfaces.Agregable;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Verificable;
import java.awt.Graphics;
import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import nivel.elementos.pared.Pared;
import personajes.poderAngel.Rayo;
import sprite.Dibujo;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alejandro
 */
public class Angel extends Dibujo {
    
    public final static int ANCHO = 78;
    public final static int ALTO = 95;
    
    public final int VELOCIDAD = 10;
    public static final int DAÑO = 1;
    
    private float vida;
    private int energia;
    private int energiaMaxima;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private Image imagenRayo;
    
    private Delimitable bordes;
    private Notificable notificador;
    private Verificable verificador;
    private Agregable agregador;
    
    private boolean tieneLlveFinNivel;
    private boolean tieneLlaveCofre;
    
    private Rectangle areaAtaque;
    
    private HiloMovimientoRayo hilorayo;
    
    private boolean estaParalizado;
                
    public Angel(int x, int y, Image imagenAngel, Image imagenRayo, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagenAngel);
                
        this.vida = 100;
        
        this.energia = 10;
        this.energiaMaxima = 10;
        this.almasLiberadas = 0;
        
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
                                
        this.notificador = notificador;
        
        this.imagenRayo = imagenRayo;
        
        this.areaAtaque = new Rectangle(x-10, y-10, width+10, height+10);
        
        this.estaParalizado  = false;
    }
    
    public void setHiloMovimientoRayos(ArrayList<Rayo> rayos) {
        hilorayo = new HiloMovimientoRayo(rayos);
        hilorayo.start(); 
    }
        
    @Override
    public void dibujar (Graphics2D g) {
        //Dibuja la imagen
        g.drawImage(this.imagen, this.x, this.y, null);
        
    }

    // Este es el método que se llama cuando el ángel intersecta la trampa
    public void paralizar() {
        estaParalizado = true;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                estaParalizado = false;
            }
        }, 3000);
    }
    
    public boolean mover(int codigo) {
        if (estaParalizado)
            return false;
        
        boolean seMovio = false;
        
        if (codigo == KeyEvent.VK_UP && y >= bordes.getYMin(x)){
            y -= VELOCIDAD;
            seMovio = true;
        }
        
        if (codigo == KeyEvent.VK_DOWN && y <= bordes.getYMax(x) - Pared.ALTO) {
            y += VELOCIDAD;
            seMovio = true;
        }
            
        if (codigo == KeyEvent.VK_RIGHT && x <= bordes.getXMax(y) - Pared.ANCHO) {
            x += VELOCIDAD;
            seMovio = true;
        }
            
        if (codigo == KeyEvent.VK_LEFT && x >= bordes.getXMin(y)) {
            x -= VELOCIDAD;
            seMovio = true;
        }
        
        areaAtaque.setLocation(x-10, y-10);
       
        return seMovio;
    }
    
    public boolean recibirImpacto(int daño) {
        this.vida -= daño;
        
        return vida <= 0;
    }
    
    public void revertirMovimiento(int xAnterior, int yAnterior) {
        // Revertir la posición del ángel a las coordenadas anteriores
        this.x = xAnterior;
        this.y = yAnterior;
    }
    
    public void setInterfacesNivel(Delimitable bordes, Verificable verificador, Agregable agregador) {
        this.bordes = bordes;
        this.verificador = verificador;
        this.agregador = agregador;
    }
    
    public void lanzarRayos(Graphics contextoGrafico, int x, int y) {
        if(energia <= 0){
                return;
        }
        
        Rayo nuevoRayo = new Rayo(this.x, this.y, imagenRayo, notificador,verificador); 
        nuevoRayo.setObjetivoX(x);
        nuevoRayo.setObjetivoY(y);
            
        agregador.agregarRayo(nuevoRayo);
        
       //nuevoRayo.moverRayo(x, y);
        energia--;
    }
    
    public void setVerificable(Verificable verificador){
        this.verificador = verificador;
    }

    public Rectangle atacar() {
        //TO-DO
        /*
        Posible animación de ataque con el bastón
        */
        
        return areaAtaque;
    }
    
    public void agregarSeguidores(int numAlmas) {
        almasLiberadas += numAlmas;
        
        energiaMaxima += almasLiberadas % 3;
    }

    public float getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getAlmas() {
        return almasLiberadas;
    }

    public Potenciador[] getPotenciadores() {
        return potenciadores;
    }
    
    public void recargarEnergia() {
        energia = energiaMaxima;
    }
}