/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import herramientas.FabricaNivel;
import interfaces.ConstantesComunes;
import interfaces.Notificable;
import interfaces.Refrescable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import nivel.Nivel;

import personajes.Angel;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Mazmorra extends Dibujo
                      implements Notificable {

    private Image[] imagenes;
    
    private int puntajeTotal;
    private int numNivel;
    
    private FabricaNivel fabricaNivel;

    private Angel angel;
    private ArrayList<Nivel> niveles;
        
    private Refrescable refrescador;
    
    public Mazmorra(int width, int height, Refrescable refrescador) throws IOException {
        super(0,0,width,height, null);
        
        cargarTodasImagenes();
        
        this.puntajeTotal = 0;
        this.numNivel = 0;
                
        setAngel();
        
        niveles = new ArrayList<>();
        fabricaNivel = new FabricaNivel(imagenes);
 
        this.refrescador = refrescador;
        agregarNivel();     //Crea el primer nivel
    }
    
    private void setAngel() {
        //int xCentro = (width /2) - (Angel.ANCHO/2); esto luego se factoriza y queda
        int xCentro = (width - Angel.ANCHO) / 2;
        int yCentro = (height - Angel.ALTO) / 2;
        
        this.angel = new Angel(xCentro, yCentro, imagenes[ConstantesComunes.IMAGEN_ANGEL], imagenes[ConstantesComunes.IMAGEN_RAYO], this);
    }

    public void manejarTecla(int codigo) {
        if (codigo == KeyEvent.VK_W
                || codigo == KeyEvent.VK_S
                || codigo == KeyEvent.VK_D
                || codigo == KeyEvent.VK_A ) {
            
            niveles.get(numNivel-1).moverAngel(codigo);
        
        } else if (codigo == KeyEvent.VK_F) {
            niveles.get(numNivel-1).angelAtacar();
            
        } else if (codigo == KeyEvent.VK_SPACE) {
            angel.accionarPotenciador();
        }
    }

    public void manejarClick(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1)
            niveles.get(numNivel-1).lanzarRayo(evt.getX(), evt.getY());
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width , height);
        
        niveles.get(numNivel-1).dibujar(g);

    }
    
    public final void agregarNivel() throws IOException {
        numNivel++;
        Nivel nuevoNivel = fabricaNivel.crearNivel(numNivel, angel, this);
        niveles.add(nuevoNivel);
        
        
    }

    @Override
    public void notificarCambios(int cambio) {
        refrescador.refrescar(cambio);
    }

    public void cargarTodasImagenes() throws IOException {
        imagenes = new Image[30];
        
        imagenes[0] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\DemonioElectrico2.png"));
        imagenes[1] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\DemonioFuego2.png"));
        
        imagenes[2] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\fire2.png"));
        
        imagenes[3] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\DemonioHielo2.png"));
        imagenes[4] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\DemonioSelvatico2.png"));
        
        imagenes[5] = ImageIO.read(new File("imagenes\\personajes\\demonios\\demonioInferior\\roca2.png"));
        
        imagenes[6] = ImageIO.read(new File("imagenes\\personajes\\angel\\angel2.png"));
        imagenes[7] = ImageIO.read(new File("imagenes\\personajes\\almas\\alma2.png"));
        
        imagenes[8] = ImageIO.read(new File("imagenes\\trampas\\mina2.png"));
        
        imagenes[9] = ImageIO.read(new File("imagenes\\paredes\\ParedEspinas2.png"));
        imagenes[10] = ImageIO.read(new File("imagenes\\paredes\\ParedEstructural2.png"));
        imagenes[11] = ImageIO.read(new File("imagenes\\paredes\\Puertas\\puerta2.png"));
        
        imagenes[12] = ImageIO.read(new File("imagenes\\cofres\\cofre2.png"));
        
        imagenes[13] = ImageIO.read(new File("imagenes\\personajes\\angel\\rayo2.png"));
        
        imagenes[14] = ImageIO.read(new File("imagenes\\paredes\\Puertas\\llave2.png"));
        
        imagenes[15] = ImageIO.read(new File("imagenes\\trampas\\inmovilizadora2.png"));
        imagenes[16] = ImageIO.read(new File("imagenes\\trampas\\agujero2.png"));
        imagenes[17] = ImageIO.read(new File("imagenes\\trampas\\empuje3.png"));
        
        imagenes[18] = ImageIO.read(new File("imagenes\\potenciadores\\rayos2.png"));
        imagenes[19] = ImageIO.read(new File("imagenes\\potenciadores\\vida2.png"));
        
        imagenes[20] = ImageIO.read(new File("imagenes\\cofres\\llaveCofre2.png"));
        
        imagenes[21] = ImageIO.read(new File("imagenes\\suelo\\suelof.jpeg"));
        imagenes[22] = ImageIO.read(new File("imagenes\\suelo\\suelo2.png"));
        
    }

    @Override
    public void notificarFinNivel() {
        synchronized (niveles) {
            try {
                niveles.get(numNivel-1).detener();
            } catch (java.lang.InterruptedException e) {
                e.getStackTrace();
            }

            try {
                agregarNivel();
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }

    public Angel getAngel() {
        return angel;
    }

    public Nivel getNivelActual() {
        try {
            return niveles.get(numNivel-1);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void notificarFinJuego() {
        refrescador.finalizarJuego();
    }

    public void reiniciarJuego() throws IOException, InterruptedException {
        // Detener todos los hilos de los niveles anteriores
        for (Nivel nivel : niveles) {
            nivel.detener();
        }

        setAngel();
        numNivel = 0;

        niveles = new ArrayList<>();
        agregarNivel(); //Agrega el primer nivel
    }

    
    
}
