/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import ayudas.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Alejandro
 */
public class Angel extends Rectangle{
    
    private float vida;
    private float energia;
    private Potenciador[] potenciadores;
    private int almasLiberadas;
    
    private Image imagenFondo;
    private void cargarImagen

    public Angel(int x, int y) {
        super(x, y, 100, 100);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
    }
    
    public Angel() {
        super(0, 0, 100, 100);
        
        this.vida = 100;
        this.energia = 100;
        this.potenciadores = new Potenciador[3];    //El jugador va a poder tener máximo 3 potenciadores
        this.almasLiberadas = 0;
    }
    
    public void dibujarAngel (Graphics2D g) {
        g.drawImage(this.imagenFondo, 0, 0, null);
        g.draw(this);
    }
    
}
