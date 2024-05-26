/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.Angel;
import personajes.demonios.Demonio;
import personajes.demonios.DemonioHielo;

/**
 *
 * @author Alejandro
 */
public class HiloFuncionesEspeciales extends Thread implements Runnable {
    //TO-DO
    /*
    Añadir las funciones especiales de los demonios
    */
    
    private Angel angel;
    private ArrayList<Demonio> demonios;

    public HiloFuncionesEspeciales(Angel angel, ArrayList<Demonio> demonios) {
        this.angel = angel;
        this.demonios = demonios;
    }

    @Override
    public void run() {
        long initialTime = System.currentTimeMillis();
        
        while (true) {
            if ((System.currentTimeMillis() - initialTime) % 2000 == 0) {
                synchronized (demonios) {
                    for (int i = 0; i < demonios.size(); i++) {
                        Demonio demonio = demonios.get(i);
                        
                        if(demonio instanceof DemonioHielo)
                            ((DemonioHielo) demonio).ponerTrampa();
                        
                    }
                }
            }
            
            
            
            if ((System.currentTimeMillis() - initialTime)% 10000 == 0)
                angel.recargarEnergia();
        }
    }
    
    
}
