/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel.elementos.cofre;

import nivel.elementos.cofre.potenciadores.Potenciador;
import java.awt.Graphics2D;
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
    
    private Potenciador potenciador;
    
    public Cofre(int x, int y) throws IOException {
        super(x, y, ANCHO, ALTO);
        
        cargarImagen("imagenes\\cofres\\cofre2.png");
        crearPotenciador();
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.drawImage(imagen, x, y, null);
    }
    
    public void crearPotenciador() {
        int tipo;
        {
            Random r = new Random();
            
            tipo = r.nextInt(2);
        }
        
        if (tipo == Potenciador.TIPO_VIDA) {
            potenciador = new PotenciadorVida(x, y);
            
        } else if (tipo == Potenciador.TIPO_ATAQUE) {
            potenciador = new PotenciadorAtaque(x, y);
        }
    }
    
}
