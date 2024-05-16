/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import interfaces.Notificable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import nivel.Nivel;
import nivel.elementos.pared.Pared;
import nivel.elementos.pared.ParedEspinas;
import nivel.elementos.pared.ParedEstructural;
import personajes.Alma;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class FabricaNivel {
    private LectorArchivos lector;
    private Random random;

    public FabricaNivel() {
        lector = new LectorArchivos();
        random = new Random();
    }
    
    public Nivel crearNivel(int numNivel, Angel angel, Notificable notificador) throws IOException {
        lector.setBufferedReader("Plantilla Niveles.txt");
        ArrayList<Pared> paredes = new ArrayList<>();
        ArrayList<Pared> cofres = new ArrayList<>();
        ArrayList<Pared> almas = new ArrayList<>();
        ArrayList<Pared> trampas = new ArrayList<>();
        
        String linea;
        while ((linea = lector.leerLinea()) != null && linea.isBlank() == false) {            
            int contadorLinea = 1;
            for (int contadorCaracter = 1; contadorCaracter < linea.length(); contadorCaracter++) {
                if (linea.charAt(contadorCaracter - 1) == '#') {
                    paredes.add(crearPared(contadorCaracter * Pared.ANCHO, contadorLinea * Pared.ALTO));
                
                } else if (linea.charAt(contadorCaracter - 1) == '!') {
                    paredes.add(crearAlma(contadorCaracter * Pared.ANCHO, contadorLinea * Pared.ALTO));
                
                } else if (linea.charAt(contadorCaracter - 1) == '#') {
                    paredes.add(crearPared(contadorCaracter * Pared.ANCHO, contadorLinea * Pared.ALTO));
                
                } else if (linea.charAt(contadorCaracter - 1) == '#') {
                    paredes.add(crearPared(contadorCaracter * Pared.ANCHO, contadorLinea * Pared.ALTO));
                
                } else if (linea.charAt(contadorCaracter - 1) == '#') {
                    paredes.add(crearPared(contadorCaracter * Pared.ANCHO, contadorLinea * Pared.ALTO));
                
                }
            }
        }
        
        return new Nivel(numNivel, angel, notificador, null, null, null, paredes);
   
    }

    private Pared crearPared(int x, int y) throws IOException {
        int tipoPared = random.nextInt(2);
        
        switch (tipoPared) {
            case Pared.TIPO_ESTRUCTURAL:
                return new ParedEstructural(x, y);

            case Pared.TIPO_ESPINAS:
                return new ParedEspinas(x, y);
        }
        
        return null;
    }

    private Pared crearAlma(int i, int i0) {
        return new Alma(i0, i0, i0, i0)
    }
    
    
}
