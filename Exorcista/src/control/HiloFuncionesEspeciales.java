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
import personajes.demonios.DemonioSelvatico;
import personajes.poderAngel.Rayo;

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
        long lastExecutionTime = 0;

        while (true) {
            long currentTime = System.currentTimeMillis() - initialTime;
            
            if (currentTime - lastExecutionTime >= 5000) {
                lastExecutionTime = currentTime;
                synchronized (demonios) {
                    for (int i = 0; i < demonios.size(); i++) {
                        Demonio demonio = demonios.get(i);

                        if(demonio instanceof DemonioHielo) {
                            ((DemonioHielo) demonio).ponerTrampa();
                           
                        }
                        
                        if(demonio instanceof DemonioSelvatico){
                            ((DemonioSelvatico) demonio).crearRocas();
                            
                        }

                    }
                }
            }

            if (currentTime % 10000 == 0)
                angel.recargarEnergia();
            
          
        
            
            
        }
    }
    
    
}
