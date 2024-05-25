/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.Angel;

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

    public HiloFuncionesEspeciales(Angel angel) {
        this.angel = angel;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFuncionesEspeciales.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            angel.recargarEnergia();
        }
    }
    
    
}
