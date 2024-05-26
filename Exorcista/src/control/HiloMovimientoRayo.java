/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.Verificable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.poderAngel.Rayo;

/**
 *
 * @author usuario
 */
public class HiloMovimientoRayo extends Thread implements Runnable {
    
    private ArrayList<Rayo> rayos;
    boolean seLlego = false;

    public HiloMovimientoRayo(ArrayList<Rayo> rayos) {
        this.rayos = rayos;
        this.seLlego = false;
    }


     
     @Override
    public void run() {
        
        synchronized (rayos) {
        
            while (true) {
                   
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rayo.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
              for (int i = 0 ; i<rayos.size(); i++) {
                Rayo nuevoRayo = null;
                nuevoRayo = rayos.get(i);
                boolean control = nuevoRayo.seguirPunto();
                if(control)
                    rayos.remove(nuevoRayo);
                
               }
   
            }
        }
        
    }
    
 }
    
        
    
    
    
    

