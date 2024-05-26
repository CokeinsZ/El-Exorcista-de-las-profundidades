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
    long lastTrapPlacementTime = System.currentTimeMillis();
    long lastEnergyReloadTime = System.currentTimeMillis();

    while (true) {
        long currentTime = System.currentTimeMillis();

        // Colocar trampas cada 5 segundos
        if (currentTime - lastTrapPlacementTime >= 5000) {
            synchronized (demonios) {
                for (Demonio demonio : demonios) {
                    if (demonio instanceof DemonioHielo) {
                        ((DemonioHielo) demonio).ponerTrampa();
                    }
                }
            }
            lastTrapPlacementTime = currentTime; // Actualizar el último tiempo de colocación de trampas
        }

        // Recargar energía del ángel cada 10 segundos
        if (currentTime - lastEnergyReloadTime >= 10000) {
            angel.recargarEnergia();
            lastEnergyReloadTime = currentTime; // Actualizar el último tiempo de recarga de energía
        }

        // Esperar un breve período de tiempo para evitar una verificación constante del tiempo
        try {
            Thread.sleep(100); // Esperar 100 milisegundos antes de volver a verificar el tiempo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
}
    
    
}
