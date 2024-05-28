/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.trampa;

import interfaces.Asesinable;
import interfaces.Notificable;
import java.awt.Graphics2D;
import java.awt.Image;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class Mina extends Trampa{
    
    public static final int ANCHO = 25;
    public static final int ALTO = 34;    

    public Mina(int x, int y, Image imagen, Asesinable objetivo, Notificable notificador) {
        super(x, y, ANCHO, ALTO, imagen, objetivo, notificador);
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, this.x, this.y, null);
    }

    @Override
    public void accionar() {
        //TO-DO
        /*
        Animación de exploción
        */
        
        objetivo.recibirImpacto(20);
        
        notificador.notificarCambios(Notificable.EVENTO_ACTIVACION_MINA);
    }
    

}
