/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.awt.Rectangle;
import personajes.Angel;
import personajes.poderAngel.Rayo;

/**
 *
 * @author Alejandro
 */
public interface Verificable {
    public boolean verificarColision(Rayo rayo);
    public boolean verificarColisionDemonio(Angel angel);

}
