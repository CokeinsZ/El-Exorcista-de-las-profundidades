/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazmorra;

import java.awt.Graphics2D;
import java.io.File;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo {
    private LectorArchivos lector;
    private String dificultad;

    public Nivel(LectorArchivos lector, String dificultad) {
        super(0, 0, 1280, 720);
        
        this.lector = lector;
        this.dificultad = dificultad;
        
        lector.leerArchivoNivel();
    }
    
    

    public void dibujarNivel(Graphics2D g) {
        
    }
}
