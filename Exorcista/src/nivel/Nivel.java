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
import java.util.Random;
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
    
    private int numNivel;
    private AudioClip soundTrack;
    
    private Angel angel;
    
    private ArrayList<Demonio> demonios;

    public Nivel(FabricaDemonios fabrica, int numNivel, Angel angel) throws IOException {
        //TO-DO recibir el ancho y el alto y las posiciones del nivel por el constructor
        super(0, 0, 800, 600);
        
        this.fabrica = fabrica;
        
        this.numNivel = numNivel;
        
        this.angel = angel;
        angel.setBordes(this);
        
        demonios = new ArrayList<>();
        this.fabrica = fabrica;
        
        crearDemonios();
        
    }
    
    public void crearDemonios() throws IOException {
        if (numNivel == 1) {
            int numDemonios = 10;
            
            for (int i = 0; i < numDemonios; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
        
        } else if (numNivel == 2) {
            int numDemoniosHielo = 5;
            int numDemoniosSelvatico = 10;
            
            for (int i = 0; i < numDemoniosHielo; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
            
            for (int i = 0; i < numDemoniosSelvatico; i++) {
                agregarDemonio(Demonio.TIPO_SELVATICO);
            }
        
        } else if (numNivel == 3) {
            int numDemoniosHielo = 10;
            int numDemoniosSelavatico = 5;
            int numDemoniosFuego = 5;
            int numDemoniosElectrico = 5;
            
            for (int i = 0; i < numDemoniosHielo; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
            
            for (int i = 0; i < numDemoniosSelavatico; i++) {
                agregarDemonio(Demonio.TIPO_SELVATICO);
            }
            
            for (int i = 0; i < numDemoniosFuego; i++) {
                agregarDemonio(Demonio.TIPO_FUEGO);
            }
            
            for (int i = 0; i < numDemoniosElectrico; i++) {
                agregarDemonio(Demonio.TIPO_ELECTRICO);
            }
        
        } else if (numNivel > 3) {
            Random r = new Random();
            
            int numDemoniosHielo = r.nextInt(15);
            int numDemoniosSelavatico = r.nextInt(15);
            int numDemoniosFuego = r.nextInt(15);
            int numDemoniosElectrico = r.nextInt(15);
            
            for (int i = 0; i < numDemoniosHielo; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
            
            for (int i = 0; i < numDemoniosSelavatico; i++) {
                agregarDemonio(Demonio.TIPO_SELVATICO);
            }
            
            for (int i = 0; i < numDemoniosFuego; i++) {
                agregarDemonio(Demonio.TIPO_FUEGO);
            }
            
            for (int i = 0; i < numDemoniosElectrico; i++) {
                agregarDemonio(Demonio.TIPO_ELECTRICO);
            }
        }
    }
    
    public void agregarDemonio(int tipo) throws IOException {
        demonios.add(fabrica.crearDemonio(tipo, this, angel));
    }


    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
        
        angel.dibujar(g);
        
        for (Demonio demonio: demonios) {
            demonio.dibujar(g);
        }
    }
}
