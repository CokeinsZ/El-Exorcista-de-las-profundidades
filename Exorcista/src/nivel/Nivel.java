/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import herramientas.FabricaDemonios;
import interfaces.Delimitable;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import personajes.Angel;
import personajes.demonios.Demonio;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo 
                   implements Delimitable {
    
    private FabricaDemonios fabrica;
    
    private String dificultad;
    private AudioClip soundTrack;
    
    private Angel angel;
    
    private ArrayList<Demonio> demonios;

    public Nivel(FabricaDemonios fabrica, String dificultad, Angel angel) {
        //TO-DO recibir el ancho y el alto y las posiciones del nivel por el constructor
        super(0, 0, 800, 600);
        
        this.fabrica = fabrica;
        
        this.dificultad = dificultad;
        
        this.angel = angel;
        angel.setBordes(this);
        
    }
    
    public void agregarDemonio() throws IOException {
        demonios.add(fabrica.crearDemonio(Demonio.TIPO_HIELO));
    }


    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
        
        angel.dibujar(g);
    }
}
