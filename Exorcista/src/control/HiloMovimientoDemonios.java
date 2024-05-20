/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.demonios.Demonio;

/**
 *
 * @author Alejandro
 */
public class HiloMovimientoDemonios extends Thread implements Runnable {   
    private ArrayList<Demonio> demonios;

    public HiloMovimientoDemonios(ArrayList<Demonio> demonios) {
        this.demonios = demonios;        
    }
        
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMovimientoDemonios.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Demonio demonio: demonios) {
                demonio.mover();
            }
        }
    }
}
