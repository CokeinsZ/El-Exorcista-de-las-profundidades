/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import interfaces.ConstantesComunes;
import interfaces.Notificable;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import nivel.Nivel;
import nivel.elementos.cofre.Cofre;
import nivel.elementos.pared.Pared;
import nivel.elementos.pared.ParedEspinas;
import nivel.elementos.pared.ParedEstructural;
import nivel.elementos.pared.Puerta;
import nivel.elementos.trampa.Mina;
import nivel.elementos.trampa.Trampa;
import personajes.Alma;
import personajes.Angel;

/**
 *
 * @author Alejandro
 */
public class FabricaNivel {
    private LectorArchivos lector;
    private Random random;
    
    private Image[] imagenes;

    public FabricaNivel(Image[] imagenes) {
        lector = new LectorArchivos();
        random = new Random();
        
        this.imagenes = imagenes;
    }
    
    public Nivel crearNivel(int numNivel, Angel angel, Notificable notificador) throws IOException {
        lector.setBufferedReader("archivos\\niveles\\nivel" + 1 + ".txt");
        
        ArrayList<Cofre> cofres = new ArrayList<>();
        ArrayList<Alma> almas = new ArrayList<>();
        ArrayList<Trampa> trampas = new ArrayList<>();
        ArrayList<Pared> paredes = new ArrayList<>();
        Puerta puerta = null;
        
        String linea;
        int x = 0;
        int y = 0;
        while ((linea = lector.leerLinea()) != null && linea.isBlank() == false) {                        
            for (int posCaracter = 0; posCaracter < linea.length(); posCaracter++) {
                switch (linea.charAt(posCaracter)) {
                    case '$':
                        cofres.add(crearCofre(x, y));
                        break;
                    
                    case '!':
                        almas.add(crearAlma(x , y));
                        break;
                        
                    case '*':
                        trampas.add(crearTrampa(x, y));
                        break;
                    
                    case '#':
                        paredes.add(crearPared(x, y));
                        break;         
                        
                    case 'P':
                        puerta = crearPuerta(x, y);
                        break;
                        
                    default:
                        break;
                }
                x += Pared.ANCHO;
            }
            
            y += Pared.ALTO;
            x = 0;
        }
        
        int ancho = calcularAnchoNivel(paredes);
        int alto = calcularAltoNivel(paredes);
        return new Nivel(numNivel, angel, notificador, cofres, almas, trampas, paredes, puerta, imagenes, ancho, alto);
   
    }
    
    public int calcularAnchoNivel(ArrayList<Pared> paredes) {
        int xMin = 1280;
        int xMax = 0;
        
        for (Pared pared: paredes) {
            if (pared.getX() < xMin)
                xMin = (int) pared.getX();
            
            if (pared.getX() > xMax)
                xMax = (int) pared.getX();
        }
        
        return xMax - xMin;
    }
    
    public int calcularAltoNivel(ArrayList<Pared> paredes) {
        int yMin = 720;
        int yMax = 0;
        
        for (Pared pared: paredes) {
            if (pared.getY() < yMin)
                yMin = (int) pared.getY();
            
            if (pared.getY() > yMax)
                yMax = (int) pared.getY();
        }
        
        return yMax - yMin;
    }

    private Pared crearPared(int x, int y) throws IOException {
        int tipoPared = random.nextInt(1,3);
        
        switch (tipoPared) {
            case Pared.TIPO_ESTRUCTURAL:
                return new ParedEstructural(x, y, imagenes[ConstantesComunes.IMAGEN_PARED_ESTRUCTURAL]);

            case Pared.TIPO_ESPINAS:
                return new ParedEspinas(x, y, imagenes[ConstantesComunes.IMAGEN_PARED_ESPINA]);
        }
        
        return null;
    }

    private Alma crearAlma(int x, int y) throws IOException {
        return new Alma(x, y, imagenes[ConstantesComunes.IMAGEN_ALMA]);
    }

    private Cofre crearCofre(int x, int y) throws IOException {
        return new Cofre(x, y, imagenes[ConstantesComunes.IMAGEN_COFRE], null, null);                
    }

    private Trampa crearTrampa(int x, int y) throws IOException {
        int tipo = 1;
        
        //Random r = new Random();
        //tipo = r.nextInt(1, 4);
        
        switch (tipo) {
            case Trampa.TIPO_MINA:
                return new Mina(x, y, imagenes[ConstantesComunes.IMAGEN_MINA]);
        }
        
        return null;
    }

    private Puerta crearPuerta(int x, int y) throws IOException {
        return new Puerta(x, y, imagenes[ConstantesComunes.IMAGEN_PUERTA], imagenes[ConstantesComunes.IMAGEN_PUERTA]);
    }
    
    
}
