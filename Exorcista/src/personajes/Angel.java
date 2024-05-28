/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import interfaces.Agregable;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Verificable;
import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    private int contadorPotenciadores;
    private int almasLiberadas;
    
    private Image imagenRayo;
    
    private Delimitable bordes;
    private Notificable notificador;
    private Verificable verificador;
    private Agregable agregador;
    
    private ArrayList<Boolean> llavesCofres;
    
    private Rectangle areaAtaque;
        
    private boolean estaParalizado;
                
    public Angel(int x, int y, Image imagenAngel, Image imagenRayo, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagenAngel);
                
        this.vida = 100;
        
        this.energia = 10;
        this.energiaMaxima = 10;
        this.almasLiberadas = 0;
        
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.contadorPotenciadores = 0;
                                
        this.notificador = notificador;
        
        this.imagenRayo = imagenRayo;
        
        this.areaAtaque = new Rectangle(x-10, y-10, width+10, height+10);
        
        this.estaParalizado  = false;
        this.llavesCofres = new ArrayList<>();
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
                
        int xAnterior = x;
        int yAnterior = y;
        
        switch (codigo) {
            case KeyEvent.VK_W -> {
                y -= VELOCIDAD;
            }
            
            case KeyEvent.VK_S -> {
                y += VELOCIDAD;
            }
            
            case KeyEvent.VK_D -> {
                x += VELOCIDAD;
            }
            
            case KeyEvent.VK_A -> {
                x -= VELOCIDAD;
            }
            
        }

        
        if (bordes.tocaBorde(this)) {
            revertirMovimiento(xAnterior, yAnterior);
            return false;
        }
        
        areaAtaque.setLocation(x-10, y-10);
        notificador.notificarCambios(Notificable.EVENTO_MOVIMIENTO);
        return true;
    }
    
    public void recibirImpacto(int daño) {
        this.vida -= daño;
        
        if (vida <= 0)
            notificador.notificarFinJuego();
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
    
    public void lanzarRayos(int x, int y) {        
        Rayo nuevoRayo = new Rayo(this.x, this.y, imagenRayo, notificador,verificador); 
        nuevoRayo.setObjetivoX(x);
        nuevoRayo.setObjetivoY(y);
            
        agregador.agregarRayo(nuevoRayo);
        
       //nuevoRayo.moverRayo(x, y);
        energia = energia==0 ?0 :energia-1;
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
    
    public void tomarLlaveCofre() {
        llavesCofres.add(true);
    }
    
    public void abrirCofre() {
        llavesCofres.remove(llavesCofres.size() - 1);
    }
    
    public void tomarPotenciador(Potenciador potenciador) {
        if (contadorPotenciadores >= 3)
            return;
        
        potenciador.setAngel(this);
        
        potenciadores[contadorPotenciadores] = potenciador;
        contadorPotenciadores++;
    }

    public boolean tieneLlaves() {
        return llavesCofres.contains(true);
    }

    public void recuperarVida() {
        if (vida >= 80)
            recargarEnergia();
        
        this.vida += 20;
    }

    public void accionarPotenciador() {
        if (contadorPotenciadores <= 0)
            return;
        
        potenciadores[contadorPotenciadores-1].accionar(bordes);
        potenciadores[contadorPotenciadores-1] = null;
        contadorPotenciadores--;
    }

    public boolean tineEnergia() {
        return energia > 0;
    }

    
    
}