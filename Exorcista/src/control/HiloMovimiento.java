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
import personajes.poderDemonios.Fuego;
import personajes.poderDemonios.Roca;
import personajes.poderDemonios.Tornado;

/**
 *
 * @author usuario
 */
public class HiloMovimiento extends Thread implements Runnable {
    
    private boolean corriendo;
    
    private ArrayList<Demonio> demonios;
    private ArrayList<Rayo> rayos;
    private ArrayList<Roca> rocas;
    private ArrayList<Fuego> fuegos;
    private ArrayList<Tornado> tornados;

    public HiloMovimiento(ArrayList<Demonio> demonios, ArrayList<Rayo> rayos, ArrayList<Roca> rocas, ArrayList<Fuego> fuegos, ArrayList<Tornado> tornados) {
        this.demonios = demonios;
        this.rayos = rayos;
        this.rocas = rocas;
        this.fuegos = fuegos;
        this.tornados = tornados;
        this.corriendo = true;
    }
    
    public void run() {

        while (corriendo) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.getStackTrace();
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
                    if(nuevoRayo == null)
                        continue;
                    
                    boolean control = nuevoRayo.seguirPunto();
                    if (control) {
                        rayos.remove(nuevoRayo);
                    }
                }
            }

            synchronized(rocas){
                for (int i = 0; i < rocas.size(); i++) {
                    Roca nuevoRoca = rocas.get(i);
                    if(nuevoRoca == null)
                        continue;
                    boolean control = nuevoRoca.seguirPunto();
                    if (control) {
                        rocas.remove(nuevoRoca);
                    }
                }
            }
            
            synchronized(fuegos){ 
                for (int i = 0; i < fuegos.size(); i++) {
                    Fuego fuegoNuevo = fuegos.get(i);
                    if(fuegoNuevo == null)
                        continue;
                    boolean control = fuegoNuevo.seguirPunto();
                    if(control){
                        fuegos.remove(fuegoNuevo);
                    }
                }
                
            }
            
            synchronized(tornados){ 
                for (int i = 0; i < tornados.size(); i++) {
                    Tornado tornadoNuevo = tornados.get(i);
                    if(tornadoNuevo == null)
                        continue;
                    if(tornadoNuevo== null){
                        continue;
                    }
                    
                    tornadoNuevo.atraerAngel();
                    
                }
                
            }

        }
    }
         
    public void detenerHilo() throws java.lang.InterruptedException{
        corriendo = false;
        interrupt();
    }
    
    
    
}
