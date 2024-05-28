/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Alejandro
 */
public interface Notificable {
    public static final int EVENTO_MOVIMIENTO = 0;
    public static final int EVENTO_MUERTE_DEMONIO = 1;
    public static final int EVENTO_MUERTE_ANGEL = 5;
    public static final int EVENTO_LANZAR_RAYO = 6;
    public static final int EVENTO_LANZAR_FUEGO = 7;
    public static final int EVENTO_LANZAR_ROCA = 8;
    public static final int EVENTO_FIN_NIVEL = 9;
    public static final int EVENTO_COFRE_ABIERTO = 10;
    public static final int EVENTO_TORNADO = 11;
    public static final int EVENTO_NUEVA_MINA = 3;
    public static final int EVENTO_ACTIVACION_MINA = 12;
    public static final int EVENTO_ACTIVACION_INMOVILIZADOR = 13;
    public static final int EVENTO_ACTIVACION_AGUJERO = 14;
    public static final int EVENTO_POTENCIADOR_VIDA = 15;
    public static final int EVENTO_POTENCIADOR_ATAQUE = 16;
    
    public void notificarCambios(int cambio);
    public void notificarFinNivel();

    public void notificarFinJuego();
}
