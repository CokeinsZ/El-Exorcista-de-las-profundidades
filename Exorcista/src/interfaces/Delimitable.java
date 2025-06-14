/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public interface Delimitable {
    public int getAncho();
    public int getAlto();
    
    public int getXMin(int y);
    public int getXMax(int y);
    
    public int getYMin(int x);
    public int getYMax(int x);
    
    public boolean tocaBorde(Dibujo objeto);

}
