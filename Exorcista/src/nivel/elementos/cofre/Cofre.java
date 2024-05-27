/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre;

import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import nivel.elementos.cofre.potenciadores.PotenciadorAtaque;
import nivel.elementos.cofre.potenciadores.PotenciadorVida;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Cofre extends Dibujo {
    public static final int ANCHO = 80;
    public static final int ALTO = 80;
    
    private Image imagenPotenciadorVida;
    private Image imagenPotenciadorAtaque;
    
    public Cofre(int x, int y, Image imagen, Image imagenPotenciadorVida, Image imagenPotenciadorAtaque) {
        super(x, y, ANCHO, ALTO, imagen);
        
        this.imagenPotenciadorAtaque = imagenPotenciadorAtaque;
        this.imagenPotenciadorVida = imagenPotenciadorVida;
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
    public Potenciador crearPotenciador() {
        int tipo;
        {
            Random r = new Random();
            
            tipo = r.nextInt(1, 3);
        }
        
        if (tipo == Potenciador.TIPO_VIDA) {
            return new PotenciadorVida(x, y, imagenPotenciadorVida);
            
        } else if (tipo == Potenciador.TIPO_ATAQUE) {
            return new PotenciadorAtaque(x, y, imagenPotenciadorAtaque);
            
        }
        
        return null;
    }
    
}
