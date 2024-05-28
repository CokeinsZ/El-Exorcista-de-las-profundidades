/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.awt.Image;
import java.util.Random;
import personajes.Angel;
import personajes.demonios.*;

/**
 *
 * @author Alejandro
 */
public class FabricaDemonios {
    
    private Image[] imagenes;
    private int numNivel;

    public FabricaDemonios(Image[] imagenes, int numNivel) {
        this.numNivel = numNivel;
        this.imagenes = imagenes;
    }
    
    
    public Demonio crearDemonio(int tipo, Delimitable bordes, Angel enemigo, Notificable notificador, Agregable agregador, boolean tieneLlave) {
        Random r = new Random();
        
        int x;
        int y;
        
        switch (tipo) {
            case Demonio.TIPO_SUPERIOR:
                x = r.nextInt(bordes.getAncho());
                y = r.nextInt(bordes.getAlto());
                return null;
                
            case Demonio.TIPO_FUEGO:
                x = r.nextInt(bordes.getAncho() - DemonioFuego.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioFuego.ALTO);
                return new DemonioFuego(x, y, bordes, enemigo, notificador, imagenes[ConstantesComunes.IMAGEN_DEMONIO_FUEGO], imagenes[ConstantesComunes.IMAGEN_FUEGO], agregador, tieneLlave, ((numNivel-1)/100) + 1);

            case Demonio.TIPO_ELECTRICO:
                x = r.nextInt(bordes.getAncho() - DemonioElectrico.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioElectrico.ALTO);
                return new DemonioElectrico(x, y, bordes, enemigo, notificador, imagenes[ConstantesComunes.IMAGEN_DEMONIO_ELECTRICO], agregador, tieneLlave, ((numNivel-1)/100) + 1);

            case Demonio.TIPO_SELVATICO:
                x = r.nextInt(bordes.getAncho() - DemonioSelvatico.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioSelvatico.ALTO);
                return new DemonioSelvatico(x, y, bordes, enemigo, notificador, imagenes[ConstantesComunes.IMAGEN_DEMONIO_SELVATICO], imagenes[ConstantesComunes.IMAGEN_ROCA], agregador, tieneLlave, ((numNivel-1)/100) + 1);

            case Demonio.TIPO_HIELO:
                x = r.nextInt(bordes.getAncho() - DemonioHielo.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioHielo.ALTO);
                return new DemonioHielo(x, y, bordes, enemigo, notificador, imagenes[ConstantesComunes.IMAGEN_DEMONIO_HIELO], imagenes[ConstantesComunes.IMAGEN_TRAMPA_INMOVILIZADORA], agregador, tieneLlave, ((numNivel-1)/100) + 1);

        }
        
        return null;
    }
}
