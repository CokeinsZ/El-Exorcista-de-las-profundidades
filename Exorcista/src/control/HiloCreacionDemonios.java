/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import nivel.Nivel;

/**
 *
 * @author Alejandro
 */
public class HiloCreacionDemonios extends Thread implements Runnable {
    
    private Nivel nivel;

    public HiloCreacionDemonios(Nivel nivel) {
        this.nivel = nivel;
    }
    

    @Override
    public void run() {
        boolean quedanDemonios = true;
        while(quedanDemonios) {
            quedanDemonios = nivel.crearDemonios();
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCreacionDemonios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
