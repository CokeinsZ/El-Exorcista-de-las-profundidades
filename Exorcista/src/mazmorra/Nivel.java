/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazmorra;

import java.awt.Graphics2D;
import java.io.File;

/**
 *
 * @author Alejandro
 */
public class Nivel {
    private LectorArchivos lector;
    private String dificultad;

    public Nivel(LectorArchivos lector, String dificultad) {
        this.lector = lector;
        this.dificultad = dificultad;
        
        lector.leerArchivoNivel();
    }
    
    

    public void dibujarNivel(Graphics2D g) {
        
    }
}
