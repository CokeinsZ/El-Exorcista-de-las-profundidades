/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import control.Mazmorra;
import java.io.IOException;
import java.util.Random;
import personajes.demonios.*;

/**
 *
 * @author Alejandro
 */
public class FabricaDemonios {
    public Demonio crearDemonio(int tipo) throws IOException {
        Random r = new Random();
        
        int x = r.nextInt(Mazmorra);
        int y = r.nextInt(x);
        
        switch (tipo) {
            case Demonio.TIPO_SUPERIOR:
                return null;
                
            case Demonio.TIPO_FUEGO:
                return new DemonioFuego(x, y);

            case Demonio.TIPO_ELECTRICO:
                return null;

            case Demonio.TIPO_SELVATICO:
                return null;

            case Demonio.TIPO_HIELO:
                return null;

            default:
                throw new AssertionError();
        }
        
    }
}
