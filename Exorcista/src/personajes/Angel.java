/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Verificable;
import java.awt.Graphics;
import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import personajes.poderAngel.Rayo;
import sprite.Dibujo;

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
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private ArrayList<Rayo> rayos;
    private Image imagenRayo;
    
    private Delimitable bordes;
    private Notificable notificador;
    private Verificable verificador;
    
    private boolean tieneLlveFinNivel;
    private boolean tieneLlaveCofre;
                
    public Angel(int x, int y, Delimitable bordes, Image imagenAngel, Image imagenRayo, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagenAngel);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
                                
        this.bordes = bordes;
        this.notificador = notificador;
        
        this.imagenRayo = imagenRayo;
        rayos = new ArrayList<>();
        
    }
        
    @Override
    public void dibujar (Graphics2D g) {
        
        //Dibuja la imagen
        g.drawImage(this.imagen, this.x, this.y, null);
        
        for (int i = 0; i < rayos.size(); i++) {
            rayos.get(i).dibujar(g);
            if (rayos.get(i).isSeLlego()) {
                    rayos.remove(rayos.get(i));
                    notificador.notificarCambios();
            }
        }
    }

    public boolean mover(int codigo) {
        
        if (codigo == KeyEvent.VK_UP && y >= bordes.getYMin(x)){
            y -= VELOCIDAD;
            return true;
        }
        
        if (codigo == KeyEvent.VK_DOWN && y <= bordes.getYMax(x)) {
            y += VELOCIDAD;
            return true;
        }
            
        if (codigo == KeyEvent.VK_RIGHT && x <= bordes.getXMax(y)) {
            x += VELOCIDAD;
            return true;
        }
            
        if (codigo == KeyEvent.VK_LEFT && x >= bordes.getXMin(y)) {
            x -= VELOCIDAD;
            return true;
        }
                       
        return false;
    }
    
    public void revertirMovimiento(int xAnterior, int yAnterior) {
        // Revertir la posición del ángel a las coordenadas anteriores
        this.x = xAnterior;
        this.y = yAnterior;
    }
    
    public void setBordes(Delimitable bordes) {
        this.bordes = bordes;
    }
    
    public void lanzarRayos(Graphics contextoGrafico, int x, int y) {
        Rayo nuevoRayo = new Rayo(this.x, this.y, imagenRayo, notificador,verificador);
        rayos.add(nuevoRayo);
        nuevoRayo.moverRayo(x, y);
    }
    
    public void setVerificable(Verificable verificador){
        this.verificador = verificador;
        
    }

       
}