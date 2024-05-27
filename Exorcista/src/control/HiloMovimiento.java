/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.demonios.Demonio;
import personajes.poderAngel.Rayo;
import personajes.poderDemonios.Roca;

/**
 *
 * @author usuario
 */
public class HiloMovimiento extends Thread implements Runnable {
    
    private ArrayList<Demonio> demonios;
    private ArrayList<Rayo> rayos;
    private ArrayList<Roca> rocas;

    public HiloMovimiento(ArrayList<Demonio> demonios, ArrayList<Rayo> rayos, ArrayList<Roca> rocas) {
        this.demonios = demonios;
        this.rayos = rayos;
        this.rocas = rocas;
        
    }
    
    

public void run() {
    
    while (true) {
        
        
        try {
            Thread.sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Mover demonios
        synchronized (demonios) {
            for (int i = 0; i < demonios.size(); i++) {
                demonios.get(i).mover();
            }
        }
        
       synchronized(rayos){
        
            for (int i = 0; i < rayos.size(); i++) {
                Rayo nuevoRayo = rayos.get(i);
                boolean control = nuevoRayo.seguirPunto();
                if (control) {
                    rayos.remove(nuevoRayo);
                }
            }
        }
       
        synchronized(rocas){
        
            for (int i = 0; i < rocas.size(); i++) {
                Roca nuevoRoca = rocas.get(i);
                boolean control = nuevoRoca.seguirPunto();
                if (control) {
                    rocas.remove(nuevoRoca);
                }
            }
        } 
       
       
    }
    
    
    
}
           
    
    
    
}
