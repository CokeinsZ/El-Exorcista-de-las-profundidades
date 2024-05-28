/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.awt.Rectangle;

/**
 *
 * @author Alejandro
 */
public interface Asesinable {
    public void recibirImpacto(double daño);
    public boolean mover(int codigo);
    public void paralizar();
    
    public double getX();
    public double getY();
    
    public boolean intersects(Rectangle obj);
    public void setLocation(int x, int y);
}
