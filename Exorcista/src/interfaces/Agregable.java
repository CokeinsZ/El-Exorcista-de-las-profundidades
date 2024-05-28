/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import nivel.elementos.trampa.Trampa;
import personajes.poderAngel.Rayo;
import personajes.poderDemonios.Fuego;
import personajes.poderDemonios.Roca;
import personajes.poderDemonios.Tornado;

/**
 *
 * @author Alejandro
 */
public interface Agregable {
    public void agregarTrampa(Trampa trampaNueva);
    public void agregarRayo(Rayo rayoNuevo);
    public void agregarRoca(Roca rocaNueva);
    public void agregarFuego(Fuego fuegoNuevo);

    public void agregarTornado(Tornado tornadoNuevo);
    
}
