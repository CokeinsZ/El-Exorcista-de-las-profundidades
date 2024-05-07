/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import herramientas.FabricaDemonios;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.Angel;
import personajes.demonios.Demonio;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo {
    private FabricaDemonios fabrica;
    
    private String dificultad;
    
    private ArrayList<Demonio> demonios;

    public Nivel(FabricaDemonios fabrica, String dificultad) {
        super(0, 0, 1280, 720);
        
        this.fabrica = fabrica;
        
        this.dificultad = dificultad;
        
        this.demonios = new ArrayList<>();
        try {
            agregarDemonio();
        } catch (IOException ex) {
            System.out.println("Algo fallo");
        }
        
    }
    
    public void agregarDemonio() throws IOException {
        demonios.add(fabrica.crearDemonio(Demonio.TIPO_HIELO));
    }

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
