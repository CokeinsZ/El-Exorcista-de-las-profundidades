/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes.poderDemonios;

import interfaces.Asesinable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author usuario
 */
public class Tornado extends Dibujo {
    
    public static final int ANCHO = 50;
    public static final int ALTO = 50;

    private Notificable notificador;


    private Asesinable objetivo;

    public Tornado(int x, int y, Image imagen, Notificable notificador, Asesinable objetivo) {
        super(x, y, ANCHO, ALTO, imagen);

        this.notificador = notificador;
        this.objetivo = objetivo;

    }

    @Override
    public void dibujar(Graphics2D g) {
        
        g.drawImage(imagen, x, y,null);

        
    }
    
    public void atraerAngel(){
        
        objetivo.seguirPunto(this.x, this.y);
        notificador.notificarCambios(Notificable.EVENTO_MOVIMIENTO);   
        
    }
    
}
