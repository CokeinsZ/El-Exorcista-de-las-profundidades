/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import control.HiloCreacionDemonios;
import control.HiloMovimientoDemonios;
import herramientas.FabricaDemonios;
import interfaces.Delimitable;
import interfaces.Notificable;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import nivel.elementos.cofre.Cofre;
import nivel.elementos.pared.Pared;
import nivel.elementos.pared.Puerta;
import nivel.elementos.trampa.Trampa;
import personajes.Alma;
import personajes.Angel;
import personajes.demonios.Demonio;
import personajes.poderAngel.Rayo;
import sprite.Dibujo;

/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo 
                   implements Delimitable {
    
    private FabricaDemonios fabrica;
    
    private int numNivel;
    private AudioClip soundTrack;
    
    private Angel angel;
    
    private ArrayList<Cofre> cofres;
    private ArrayList<Alma> almas;
    private ArrayList<Trampa> trampas;    
    private ArrayList<Pared> paredes;
    private Puerta puerta;
    private ArrayList<Demonio> demonios;
    
    private Notificable notificador;
    
    private Image[] imagenes;
    
    private HiloMovimientoDemonios hiloDemonios;
    private HiloCreacionDemonios hiloCreacionDemonios;
    
    private ArrayList<Integer> pilaDemonios;

    public Nivel(int numNivel, Angel angel, Notificable notificador, ArrayList<Cofre> cofres, ArrayList<Alma> almas, ArrayList<Trampa> trampas, ArrayList<Pared> paredes, Puerta puerta, Image[] imagenes, int ancho, int alto) throws IOException {
        //TO-DO recibir el ancho y el alto y las posiciones del nivel por el constructor
        super(0, 0, ancho, alto, null);
        
        this.imagenes = imagenes;
        this.fabrica = new FabricaDemonios(imagenes);
        
        this.numNivel = numNivel;
        
        this.angel = angel;
        angel.setBordes(this);
        this.cofres = cofres;
        this.almas = almas;
        this.trampas = trampas;
        this.paredes = paredes;
        this.puerta = puerta;
        
        demonios = new ArrayList<>();
        
        this.notificador = notificador;
        
        pilaDemonios = new ArrayList<>();
        cargarPilaDemoniosPorCrear();
        hiloCreacionDemonios = new HiloCreacionDemonios(this);
        hiloCreacionDemonios.start();
        
        
        hiloDemonios = new HiloMovimientoDemonios(demonios);
        hiloDemonios.start();
        
    }
    
    private void cargarPilaDemoniosPorCrear() {
        Random r = new Random();
        int numDemoniosHielo = 0;
        int numDemoniosFuego = 0;
        int numDemoniosSelvatico = 0;
        int numDemoniosElectrico = 0;
        
        if (numNivel == 1) {
            numDemoniosHielo = 10;
                    
        } else if (numNivel == 2) {
            numDemoniosHielo = 5;
            numDemoniosSelvatico = 10;
        
        } else if (numNivel == 3) {
            numDemoniosHielo = 10;
            numDemoniosSelvatico = 7;
            numDemoniosFuego = 6;
            numDemoniosElectrico = 8;
        
        } else if (numNivel > 3) {            
            numDemoniosHielo = r.nextInt(15);
            numDemoniosSelvatico = r.nextInt(15);
            numDemoniosFuego = r.nextInt(15);
            numDemoniosElectrico = r.nextInt(15);
            
        }
        
        while(numDemoniosElectrico > 0 || numDemoniosFuego > 0 || numDemoniosHielo > 0 || numDemoniosSelvatico > 0) {
            int tipo = r.nextInt(2, 6);
                switch (tipo) {
                    case Demonio.TIPO_HIELO:
                        pilaDemonios.add(tipo);
                        numDemoniosHielo--;
                        break;

                    case Demonio.TIPO_FUEGO:
                        pilaDemonios.add(tipo);
                        numDemoniosFuego--;
                        break;

                    case Demonio.TIPO_SELVATICO:
                        pilaDemonios.add(tipo);
                        numDemoniosSelvatico--;
                        break;

                    case Demonio.TIPO_ELECTRICO:
                        pilaDemonios.add(tipo);
                        numDemoniosElectrico--;
                        break;

                    default:
                        break;
            }
            
        }
    }
    
    public boolean crearDemonios() {
        int tipo = pilaDemonios.remove(pilaDemonios.size() -1);
        agregarDemonios(tipo);
        
        //Retorna true si aun hay demonios en la pila
        return !pilaDemonios.isEmpty();
    }
    
    public void agregarDemonios(int tipodemonio) {
        verificarPosicionDemonio(tipodemonio);
    }
    
    //esto verifica que no se colisionen entre si  
    public boolean validarColision(Demonio demonio) {
        Iterator<Pared> iteradorParedes = paredes.iterator();
        Iterator<Demonio> iteradorDemonios = demonios.iterator();
        Iterator<Trampa> iteradorTrampas = trampas.iterator();
        Iterator<Alma> iteradorAlmas = almas.iterator();
        Iterator<Cofre> iteradorCofres = cofres.iterator();
        
        while (iteradorParedes.hasNext()) {
            //El iterador nos ayuda a recorrer todo los arreglos para así verificar la colisión del demonio con cualquier otro objeto sobre el nivel
            
            if (iteradorTrampas.hasNext() && demonio.intersects(iteradorTrampas.next()))
                return false;
            
            if (demonio.intersects(iteradorParedes.next()) || demonio.getX() < getXMin((int) demonio.getY()) || demonio.getX() > getXMax((int) demonio.getY()) || demonio.getY() < getYMin((int) demonio.getX()) || demonio.getY() > getYMax((int) demonio.getX()))
                return false;
            
            if (iteradorDemonios.hasNext() && demonio.intersects(iteradorDemonios.next())) {
                return false;
            }
            
            if (iteradorAlmas.hasNext() && demonio.intersects(iteradorAlmas.next())) {
                return false;
            }
            
            if (iteradorCofres.hasNext() && demonio.intersects(iteradorCofres.next())) {
                return false;
            }
            
            if (demonio.intersects(angel))
                return false;
        }
        
        // Si no hay colisión con ninguna de los demonios existentes, retorna verdadero
        return true;      
    }
    
    // aqui creo un demonio en una posicion valida
    public void verificarPosicionDemonio (int tipoDemonio) {
        Demonio demonionuevo = null;
        boolean noColisiona = false;
        
        while(noColisiona == false){
          demonionuevo = fabrica.crearDemonio(tipoDemonio, this, angel, notificador);
          
          //se llama el metodo para verificar la colision de demonios con demonio y si esto 
          //nos retorna falso lo que debemos de hacer es volver a verificar que no se esten colisionando
          noColisiona = validarColision(demonionuevo); 
                   
        }
        
        agregarDemonio(demonionuevo);         
    }
    
    public void agregarDemonio(Demonio demonio) {
        demonios.add(demonio);
    } 

    public void moverAngel(int codigo){

        //posiciones anteriores al movimiento. es decir la posicion del angel antes de moverse 
        int xAnterior = (int) angel.getX();
        int yAnterior =  (int) angel.getY();
        
        //Tengo que guardar la posicion del angel en tal caso que tenga de deshacer un movimienot
        boolean movimientoAngel = angel.mover(codigo); // Si se mueve me retorna true de lo contrario false 
        if(movimientoAngel == true){  
         // Verificar colisión con los demonios
            for (int i = 0; i < demonios.size(); i++) {

                if (angel.intersects(demonios.get(i))) {
                    // Si hay colisión, revertir el movimiento
                    angel.revertirMovimiento(xAnterior, yAnterior);
 
                     break;
                    
                }
            }
           notificador.notificarCambios();
        }
    }
    
    @Override
    public void dibujar(Graphics2D g) {               
        for (Pared pared: paredes) {
            pared.dibujar(g);
        }
        
        puerta.dibujar(g);
        
        for (Cofre cofre: cofres) {
            cofre.dibujar(g);
        }
        
        for (Alma alma: almas) {
            alma.dibujar(g);
        }
        
        for (Trampa trampa: trampas) {
            trampa.dibujar(g);
        }
        
        for (Demonio demonio: demonios) {
            demonio.dibujar(g);
        }
        
        angel.dibujar(g);
    }

    @Override
    public int getXMin(int y) {
        int xMin = Integer.MAX_VALUE;
        
        for(Pared pared: paredes) {
            int paredY = (int) pared.getY();
            if(paredY < y + Pared.ALTO && paredY > y - Pared.ALTO && pared.getX() < xMin)
                xMin = (int) pared.getX();
                
        }
        
        return xMin + Pared.ANCHO;
    }

    @Override
    public int getXMax(int y) {
        int xMax = Integer.MIN_VALUE;
        
        for(Pared pared: paredes) {
            int paredY = (int) pared.getY();
            if(paredY < y + Pared.ALTO && paredY > y - Pared.ALTO && pared.getX() > xMax)
                xMax = (int) pared.getX();
                
        }
        
        return xMax - Pared.ANCHO;
    }

    @Override
    public int getYMin(int x) {
        int yMin = Integer.MAX_VALUE;
        
        for(Pared pared: paredes) {
            int paredX = (int) pared.getX();
            if(paredX > x - Pared.ANCHO && paredX < x + Pared.ANCHO && pared.getY() < yMin)
                yMin = (int) pared.getY();
                
        }
        
        return yMin + Pared.ALTO; 
    }

    @Override
    public int getYMax(int x) {
        int yMax = Integer.MIN_VALUE;
        
        for(Pared pared: paredes) {
            int paredX = (int) pared.getX();
            if(paredX > x - Pared.ANCHO && paredX < x + Pared.ANCHO && pared.getY() > yMax)
                yMax = (int) pared.getY();
                
        }
        
        return yMax - Pared.ALTO;
    }

    @Override
    public void setXMax(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setXMin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setYMax(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setYMin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void lanzarRayo(Graphics g, int x, int y) {
        
        angel.lanzarRayos(g, x, y);

    }

    private void eliminarDemonio(Demonio demonio) {
        demonios.remove(demonio);
    }

    

    
}
