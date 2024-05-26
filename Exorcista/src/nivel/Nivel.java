/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import control.HiloCreacionDemonios;
import control.HiloFuncionesEspeciales;
import control.HiloMovimientoDemonios;
import herramientas.FabricaDemonios;
import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Verificable;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import nivel.elementos.cofre.Cofre;
import nivel.elementos.pared.Llave;
import nivel.elementos.pared.Pared;
import nivel.elementos.pared.Puerta;
import nivel.elementos.trampa.Trampa;
import personajes.Alma;
import personajes.Angel;
import personajes.demonios.Demonio;
import personajes.poderAngel.Rayo;
import sprite.Dibujo;
    
  import java.util.Iterator;


/**
 *
 * @author Alejandro
 */
public class Nivel extends Dibujo 
                   implements Delimitable,
                              Verificable,
                              Agregable {
    
    private FabricaDemonios fabrica;
    
    private int numNivel;
    
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
    private HiloFuncionesEspeciales hiloEspecial;
    
    private ArrayList<Integer> pilaDemonios;
    
    private Llave llaveFinNivel;

    public Nivel(int numNivel, Angel angel, Notificable notificador, ArrayList<Cofre> cofres, ArrayList<Alma> almas, ArrayList<Trampa> trampas, ArrayList<Pared> paredes, Puerta puerta, Image[] imagenes, int ancho, int alto) throws IOException {
        super(0, 0, ancho, alto, null);
        
        this.imagenes = imagenes;
        this.fabrica = new FabricaDemonios(imagenes);
        
        this.numNivel = numNivel;
        
        this.angel = angel;
        angel.setBordes(this);
        angel.setVerificable(this);
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
        
        hiloEspecial = new HiloFuncionesEspeciales(angel, demonios);
        hiloEspecial.start();
        
    }
    
    private void cargarPilaDemoniosPorCrear() {
        Random r = new Random();
        
        int limSupTipoDemonios = 0;
        
        int numDemoniosHielo = 0;
        int numDemoniosFuego = 0;
        int numDemoniosSelvatico = 0;
        int numDemoniosElectrico = 0;
        
        if (numNivel == 1) {
            numDemoniosHielo = 1;
            limSupTipoDemonios = 2;
                    
        } else if (numNivel == 2) {
            numDemoniosHielo = 1;
            numDemoniosSelvatico = 1;
            limSupTipoDemonios = 3;
        
        } else if (numNivel == 3) {
            numDemoniosHielo = 1;
            numDemoniosSelvatico = 1;
            numDemoniosFuego = 1;
            numDemoniosElectrico = 1;
            limSupTipoDemonios = 5;
        
        } else if (numNivel > 3) {            
            numDemoniosHielo = r.nextInt(1,2);
            numDemoniosSelvatico = r.nextInt(1,2);
            numDemoniosFuego = r.nextInt(1,2);
            numDemoniosElectrico = r.nextInt(1,2);
            limSupTipoDemonios = 5;
            
        }
        
        while(numDemoniosElectrico > 0 || numDemoniosFuego > 0 || numDemoniosHielo > 0 || numDemoniosSelvatico > 0) {
            int tipo = r.nextInt(1, limSupTipoDemonios);
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
          demonionuevo = fabrica.crearDemonio(tipoDemonio, this, angel, notificador, this);
          
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
        //Tengo que guardar la posicion del angel en tal caso que tenga de deshacer un movimiento
        //posiciones anteriores al movimiento. es decir la posicion del angel antes de moverse 
        int xAnterior = (int) angel.getX();
        int yAnterior =  (int) angel.getY();
        
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
        
        if (llaveFinNivel != null && angel.intersects(llaveFinNivel)) {
            llaveFinNivel = null;
        
            angel.agregarSeguidores(almas.size());
            
            notificador.notificarFinNivel();
        }
    }
    
    @Override
    public void dibujar(Graphics2D g) {               
        for (Pared pared: paredes) {
            pared.dibujar(g);
        }
        
        if (puerta != null)
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
        
        if (llaveFinNivel != null) {
            llaveFinNivel.dibujar(g);
        }
    }

    @Override
    public int getXMin(int y) {
        int xMin = Integer.MAX_VALUE;
        
        for(Pared pared: paredes) {
            int paredY = (int) pared.getY();
            if(y >= paredY && y < paredY + Pared.ALTO && pared.getX() < xMin) 
                xMin = (int) pared.getX();            
            else if (y >= puerta.getY() && y < puerta.getY() + Puerta.ALTO && puerta.getX() < xMin)
                xMin = (int) puerta.getX();  
        }
        
        return xMin + Pared.ANCHO;
    }

    @Override
    public int getXMax(int y) {
        int xMax = Integer.MIN_VALUE;
        boolean foundValidPared = false;

        for (Pared pared : paredes) {
            int paredY = (int) pared.getY();
            if (paredY < y && paredY >= y - Pared.ALTO) {
                int paredX = (int) pared.getX();
                xMax = Math.max(xMax, paredX);
                foundValidPared = true; // Hemos encontrado al menos una pared válida
                
            } else if (puerta.getY() < y && puerta.getY() >= y - Puerta.ALTO) {
                xMax = (int) Math.max(xMax, puerta.getX());
                foundValidPared = true; // Hemos encontrado al menos una pared válida
            }
        }

        if (!foundValidPared || xMax <= 0) {
            // No se encontró ninguna pared válida en el rango, o xMax es menor o igual a cero
            // Devolvemos un valor especial para indicar que no hay un límite válido
            return Integer.MIN_VALUE;
        }

        return xMax;
    }

    @Override
    public int getYMin(int x) {
        int yMin = Integer.MAX_VALUE;
        
        for(Pared pared: paredes) {
            int paredX = (int) pared.getX();
            if(x >= paredX && x < paredX + Pared.ANCHO && pared.getY() < yMin)
                yMin = (int) pared.getY();
                
            else if(x >= puerta.getX() && x < puerta.getX() + Puerta.ANCHO && puerta.getY() < yMin)
                yMin = (int) puerta.getY();
        }
        
        return yMin + Pared.ALTO; 
    }

    @Override
    public int getYMax(int x) {
        int yMax = Integer.MIN_VALUE;
        
        for(Pared pared: paredes) {
            int paredX = (int) pared.getX();
            if(x > paredX && x <= paredX + Pared.ANCHO && pared.getY() > yMax)
                yMax = (int) pared.getY();
            
            else if(x > puerta.getX() && x <= puerta.getX() + Puerta.ANCHO && puerta.getY() > yMax)
                yMax = (int) puerta.getY();
                
        }
        
        return yMax;
    }

    public void lanzarRayo(Graphics g, int x, int y) {
        angel.lanzarRayos(g, x, y);

    }

    private void eliminarDemonio(Demonio demonio) {
        if(demonios.size() == 1 && !hiloCreacionDemonios.isAlive())
            reproducirEventoFinDeNivel((int) puerta.getX()-50, (int) puerta.getY());
        
        demonios.remove(demonio);       
        notificador.notificarCambios();
    }

    @Override
    public boolean verificarColision(Rayo rayo) {
        synchronized (demonios) { // sincroniza el acceso a la lista de demonios
            Iterator<Demonio> demonioIterator = demonios.iterator();
            while (demonioIterator.hasNext()) {
                Demonio demonio = demonioIterator.next();
                if (demonio.intersects(rayo)) {
                    if (demonio.recibirImapcto(Angel.DAÑO)) {
                        System.out.println(demonios.size());
                        eliminarDemonio(demonio);
                    }
                    return true;
                }
            }
        }

        for (int i = 0; i < paredes.size(); i++) {
            if (paredes.get(i).intersects(rayo)) {
                return true;
            }
        }

        return false;
    }

    private void reproducirEventoFinDeNivel(int x, int y) {        
        llaveFinNivel = new Llave(x, y, imagenes[ConstantesComunes.IMAGEN_LLAVE]);        
        
    }

    public void angelAtacar() {
        synchronized (demonios) {
            for (int i = 0; i < demonios.size(); i++) {
                if(angel.atacar().intersects(demonios.get(i)))
                   if(demonios.get(i).recibirImapcto(Angel.DAÑO))
                       eliminarDemonio(demonios.get(i));
            }
        }        
    }

    public int getNumNivel() {
        return numNivel;
    }

    public int getDemoniosRestantes() {
        return pilaDemonios.size() + demonios.size();
    }

    @Override
    public void agregarTrampa(Trampa trampaNueva) {
        trampas.add(trampaNueva);
    }
}
