/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import nivel.elementos.trampa.Trampa;
import personajes.poderAngel.Rayo;

/**
 *
 * @author Alejandro
 */
public interface Agregable {
    public void agregarTrampa(Trampa trampaNueva);
    public void agregarRayo(Rayo rayoNuevo);
}
