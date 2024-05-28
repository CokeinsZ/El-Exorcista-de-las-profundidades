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
    
    private boolean corriendo;

    public HiloFuncionesEspeciales(Angel angel, ArrayList<Demonio> demonios) {
        this.angel = angel;
        this.demonios = demonios;
        
        this.corriendo = true;
    }

  @Override
    public void run() {
        long initialTime = System.currentTimeMillis();
        long lastDemonioExecutionTime = 0;
        long lastAngelExecutionTime = 0;

        while (corriendo) {
            long currentTime = System.currentTimeMillis() - initialTime;

            // Check and perform demonio.accionEspecial() every 5000 ms
            if (currentTime - lastDemonioExecutionTime >= 5000) {
                lastDemonioExecutionTime = currentTime;
                synchronized (demonios) {
                    for (Demonio demonio : demonios) {
                        demonio.accionEspecial();
                    }
                }
            }

            // Check and perform angel.recargarEnergia() every 10000 ms
            if (currentTime - lastAngelExecutionTime >= 10000) {
                lastAngelExecutionTime = currentTime;
                angel.recargarEnergia();
            }
        }
    }

    
    public void detenerHilo() throws java.lang.InterruptedException {
        corriendo = false;
        interrupt();
    }
    
    
}
