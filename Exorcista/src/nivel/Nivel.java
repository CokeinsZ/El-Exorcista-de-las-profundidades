/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import herramientas.FabricaDemonios;
import interfaces.Delimitable;
import interfaces.Notificable;
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
    
    private Notificable notificador;

    public Nivel(FabricaDemonios fabrica, int numNivel, Angel angel, Notificable notificador) throws IOException {
        //TO-DO recibir el ancho y el alto y las posiciones del nivel por el constructor
        super(0, 0, 800, 600);
        
        this.fabrica = fabrica;
        
        this.numNivel = numNivel;
        
        this.angel = angel;
        angel.setBordes(this);
        
        demonios = new ArrayList<>();
        this.fabrica = fabrica;
        
        this.notificador = notificador;
        
        crearDemonios();
        
    }
    
    public void crearDemonios() throws IOException {
        if (numNivel == 1) {
            int numDemonios = 10;
            
            /*
            for (int i = 0; i < numDemonios; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
            */
            
           agregarcantidadDemonios(Demonio.TIPO_HIELO,numDemonios);
        
        } else if (numNivel == 2) {
            int numDemoniosHielo = 5;
            int numDemoniosSelvatico = 10;
            
            
            /*
            for (int i = 0; i < numDemoniosHielo; i++) {
                agregarDemonio(Demonio.TIPO_HIELO);
            }
            
            for (int i = 0; i < numDemoniosSelvatico; i++) {
                agregarDemonio(Demonio.TIPO_SELVATICO);
            }
            
            */
            
            agregarcantidadDemonios(Demonio.TIPO_HIELO, numDemoniosHielo);
            agregarcantidadDemonios(Demonio.TIPO_SELVATICO, numDemoniosSelvatico);

        
        } else if (numNivel == 3) {
            int numDemoniosHielo = 10;
            int numDemoniosSelavatico = 7;
            int numDemoniosFuego = 6;
            int numDemoniosElectrico = 10;
            
            
            /*
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

            */
            
            agregarcantidadDemonios(Demonio.TIPO_HIELO, numDemoniosHielo);
            agregarcantidadDemonios(Demonio.TIPO_SELVATICO, numDemoniosSelavatico);
            agregarcantidadDemonios(Demonio.TIPO_FUEGO, numDemoniosFuego);
            agregarcantidadDemonios(Demonio.TIPO_ELECTRICO,numDemoniosElectrico);
        
        } else if (numNivel > 3) {
            Random r = new Random();
            
            int numDemoniosHielo = r.nextInt(15);
            int numDemoniosSelavatico = r.nextInt(15);
            int numDemoniosFuego = r.nextInt(15);
            int numDemoniosElectrico = r.nextInt(15);
            
            /*
            
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

                

            */
        }
    }
    
    public void agregarDemonio(int tipo) throws IOException {
        demonios.add(fabrica.crearDemonio(tipo, this, angel, notificador));
    }
    
    
    public void agregarcantidadDemonios(int tipodemonio,int cantidadDemonios) throws IOException{
        
        for (int i = 0; i < cantidadDemonios; i++) {
            
            verificarDemonio(tipodemonio);
            
            
        }
        
        
   
    }
    
    
    //esto verifica que no se colisionen entre si  
    public boolean validarColisionDemonioconDemonio(Demonio Demonio){
                   
        
            for (Demonio otrodemonio : demonios) {          
                // Verificar la colisión entre las dos pulgas usando el método de colisión de cuadrados
                if (Demonio.intersects(otrodemonio) || Demonio.intersects(angel)) {
                    // Hay colisión entre las pulgas, retorna falso
                    return false;
                }
            }
            // No hay colisión con ninguna de las pulgas existentes, retorna verdadero
            return true;
        
        
    }
    
    // aqui creo un demonio en una posicion valida
    
    public void verificarDemonio (int tipoDemonio) throws IOException{
        
      
        Demonio demonionuevo = null;
        boolean control = false;
        int iterador = 0;
        
       
        while(control == false){
            
          demonionuevo = fabrica.crearDemonio(tipoDemonio, this, angel, notificador);
          
          //se llama el metodo para verificar la colision de demonios con demonio y si esto 
          //nos retorna falso lo que debemos de hacer es volver a verificar que no se esten colisionando
          control = validarColisionDemonioconDemonio(demonionuevo); 
                               
          
                   
        }
        
        agregarDemonio(demonionuevo);

       
          
    }
    
 
    
    
    public void agregarDemonio(Demonio demonio) {
        demonios.add(demonio);
        
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
