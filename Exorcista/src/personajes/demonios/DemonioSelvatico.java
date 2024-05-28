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
import personajes.poderDemonios.Roca;
import personajes.poderDemonios.Tornado;

/**
 *
 * @author Alejandro
 */
public class DemonioSelvatico extends Demonio {
    public static final int ANCHO = 92;
    public static final int ALTO = 98; 
    
    private Image imagenRoca;
    private Image imagenTornado;
    
    public DemonioSelvatico(int posX, int posY, Delimitable bordes, Asesinable enemigo, Notificable notificador, Image imagenDemonio, Image imagenRoca, Image imagenTornado, Agregable agregador, boolean tieneLlave, double multiplicadorDaño) {
        super(posX, posY, ANCHO, ALTO, bordes, enemigo, notificador, imagenDemonio, agregador, tieneLlave);
        
        vida = 7;
        daño = 2 * multiplicadorDaño;
        velocidad = 0;
        
        this.imagenRoca = imagenRoca;
        this.imagenTornado = imagenTornado;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(this.imagen, this.x, this.y, null);
    }
    
    
    public void crearRocas() {
        
        Roca nuevoRoca = new Roca(this.x, this.y, imagenRoca, notificador,enemigo);


        agregador.agregarRoca(nuevoRoca);
        notificador.notificarCambios(Notificable.EVENTO_LANZAR_ROCA);
        

        //nuevoRayo.moverRayo(x, y);
    
        
    }
    
    public void crearTornado(){
        
        Tornado tornadoNuevo = new Tornado(x, y, imagenTornado, notificador, enemigo);
        agregador.agregarTornado(tornadoNuevo);
       
        notificador.notificarCambios(Notificable.EVENTO_TORNADO);
        
    }

    @Override
    public void atacar() {
    }

    @Override
    public void mover() { 
    }

    @Override
    public void seguirEnemigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void accionEspecial() {

        crearRocas();
    }

}
