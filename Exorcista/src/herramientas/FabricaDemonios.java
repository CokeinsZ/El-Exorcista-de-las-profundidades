/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import control.Mazmorra;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.io.IOException;
import java.util.Random;
import personajes.Angel;
import personajes.demonios.*;

/**
 *
 * @author Alejandro
 */
public class FabricaDemonios {
    public Demonio crearDemonio(int tipo, Delimitable bordes, Angel enemigo, Notificable notificador) throws IOException {
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
                return new DemonioFuego(x, y, bordes, enemigo, notificador);

            case Demonio.TIPO_ELECTRICO:
                x = r.nextInt(bordes.getAncho() - DemonioElectrico.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioElectrico.ALTO);
                return new DemonioElectrico(x, y, bordes, enemigo, notificador);

            case Demonio.TIPO_SELVATICO:
                x = r.nextInt(bordes.getAncho() - DemonioSelvatico.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioSelvatico.ALTO);
                return new DemonioSelvatico(x, y, bordes, enemigo, notificador);

            case Demonio.TIPO_HIELO:
                x = r.nextInt(bordes.getAncho() - DemonioHielo.ANCHO);
                y = r.nextInt(bordes.getAlto() - DemonioHielo.ALTO);
                return new DemonioHielo(x, y, bordes, enemigo, notificador);

        }
        
        return null;
    }
}
