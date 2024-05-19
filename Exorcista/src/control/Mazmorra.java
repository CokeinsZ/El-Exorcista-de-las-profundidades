/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import herramientas.FabricaDemonios;
import herramientas.FabricaNivel;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Refrescable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import nivel.Nivel;

import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Mazmorra extends Dibujo
                      implements Notificable{

    private int puntajeTotal;
    private int numNivel;
    
    private FabricaNivel fabricaNivel;

    private Angel angel;
    private ArrayList<Nivel> niveles;
    
    private Color color;
    
    private Refrescable refrescador;
    
    public Mazmorra(int width, int height, Refrescable refrescador) throws IOException {
        super(0,0,width,height);
        
        this.puntajeTotal = 0;
        this.numNivel = 0;
        
        this.color = Color.BLACK;
        
        setAngel();
        
        niveles = new ArrayList<>();
        fabricaNivel = new FabricaNivel();
 
        this.refrescador = refrescador;
        agregarNivel();     //Crea el primer nivel
    }
    
    private void setAngel()  throws IOException {
        //int xCentro = (width /2) - (Angel.ANCHO/2); esto luego se factoriza y queda
        int xCentro = (width - Angel.ANCHO) / 2;
        int yCentro = (height - Angel.ALTO) / 2;
        
        this.angel = new Angel(xCentro, yCentro, null);
    }

    public void manejarTecla(int codigo) {
        if (codigo == KeyEvent.VK_UP
                || codigo == KeyEvent.VK_DOWN
                || codigo == KeyEvent.VK_RIGHT
                || codigo == KeyEvent.VK_LEFT) {

            if (angel.mover(codigo))
                refrescador.refrescar();
        }
    }

    public void manejarClick(MouseEvent evt) {
        //TO-DO
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width , height);
        
        niveles.get(numNivel-1).dibujar(g);

    }
    
    public final void agregarNivel() throws IOException {
        numNivel++;
        niveles.add(fabricaNivel.crearNivel(numNivel, angel, this));
        
    }

    @Override
    public void notificarCambios() {
        refrescador.refrescar();
    }

    
    
}
