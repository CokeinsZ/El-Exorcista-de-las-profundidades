/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import herramientas.FabricaDemonios;
import herramientas.LectorArchivos;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import personajes.Angel;
import personajes.demonios.Demonio;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo {
    private LectorArchivos lector;
    private FabricaDemonios fabrica;
    
    private String dificultad;
    
    private ArrayList<Demonio> demonios;

    public Nivel(LectorArchivos lector, FabricaDemonios fabrica, String dificultad) {
        super(0, 0, 1280, 720);
        
        this.lector = lector;
        this.fabrica = fabrica;
        
        this.dificultad = dificultad;
        
        lector.leerArchivoNivel();
    }
    
    public void agregarDemonio()

    public void dibujar(Graphics2D g, Angel angel) {
        angel.dibujar(g);
        
        for (Demonio demonio: demonios) {
            demonio.dibujar(g);
        }
    }

    @Override
    public void dibujar(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
