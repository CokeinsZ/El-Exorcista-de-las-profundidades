/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazmorra;

import java.awt.Graphics2D;

/**
 *
 * @author Alejandro
 */
public class Mundo {
    private String tipoMundo;
    private Nivel[] niveles;

    public Mundo(String tipoMundo) {
        this.tipoMundo = tipoMundo;
        this.niveles = new Nivel[3];
    }
    
    public void dibujarNivel(Graphics2D g, int numNivel) {
        niveles[numNivel % 3].dibujarNivel(g);
    }
}
