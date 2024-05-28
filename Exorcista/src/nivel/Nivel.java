/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nivel;

import control.HiloCreacionDemonios;
import control.HiloFuncionesEspeciales;
import control.HiloMovimiento;
import herramientas.FabricaDemonios;
import interfaces.Agregable;
import interfaces.ConstantesComunes;
import interfaces.Delimitable;
import interfaces.Notificable;
import interfaces.Verificable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
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
import nivel.elementos.cofre.potenciadores.Potenciador;
import nivel.elementos.pared.Suelo;
import personajes.poderDemonios.Fuego;
import personajes.poderDemonios.Roca;
import personajes.poderDemonios.Tornado;


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
    private ArrayList<Potenciador> potenciadores;
    private ArrayList<Alma> almas;
    private ArrayList<Trampa> trampas;    
    private ArrayList<Pared> paredes;
    private Puerta puerta;
    private ArrayList<Demonio> demonios;
    private ArrayList<Rayo> rayos;
    private ArrayList<Roca> rocas;
    private ArrayList<Fuego> fuegos;
    private ArrayList<Suelo> suelos;
    private ArrayList<Tornado> tornados;
    
    private Notificable notificador;
    
    private Image[] imagenes;
    
    private HiloCreacionDemonios hiloCreacionDemonios;
    private HiloFuncionesEspeciales hiloEspecial;
    
    private ArrayList<Integer> pilaDemonios;
    private ArrayList<Integer> arregloTieneLlave;
    
    private Llave llaveFinNivel;
    private ArrayList<Llave> llavesCofres;
    
    private HiloMovimiento hiloMovimiento;

    public Nivel(int numNivel, Angel angel, Notificable notificador, ArrayList<Cofre> cofres, ArrayList<Alma> almas, ArrayList<Trampa> trampas, ArrayList<Pared> paredes, Puerta puerta, ArrayList<Suelo> suelos, Image[] imagenes, int ancho, int alto) {
        super(0, 0, ancho, alto, null);
        
        this.imagenes = imagenes;
        this.fabrica = new FabricaDemonios(imagenes);
                
        this.numNivel = numNivel;
        
        this.cofres = cofres;
        this.llavesCofres = new ArrayList<>();
        this.potenciadores = new ArrayList<>();
        this.almas = almas;
        this.trampas = trampas;
        this.paredes = paredes;
        this.puerta = puerta;
        this.suelos = suelos;
     
                
        this.rayos = new ArrayList<>();
        this.rocas = new ArrayList<>();
        this.fuegos = new ArrayList<>();
        this.tornados = new ArrayList<>();
        
        demonios = new ArrayList<>();
        
        this.notificador = notificador;
        
        this.angel = angel;
        angel.setInterfacesNivel(this, this, this);
                
        pilaDemonios = new ArrayList<>();
        arregloTieneLlave = new ArrayList<>();
        cargarPilaDemoniosPorCrear();
                
        hiloCreacionDemonios = new HiloCreacionDemonios(this);
        hiloCreacionDemonios.start();
                
        hiloMovimiento = new HiloMovimiento(demonios, rayos, rocas,fuegos, tornados);
        hiloMovimiento.start();
                 
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
                
        cargarArregloTieneLlave();        
    }
    
    private void cargarArregloTieneLlave() {
        Random r = new Random();
        int cantidadDemonios = pilaDemonios.size();
        int cantidadLlaves = cofres.size();
        while (cantidadLlaves > 0) {
            int pos = r .nextInt(0, cantidadDemonios);
            
            if (arregloTieneLlave.contains(pos))
                continue;
            
            arregloTieneLlave.add(pos);
            cantidadLlaves--;
            
        }
        
    }
    
    public boolean crearDemonios() {
        int demonioCrear = pilaDemonios.size() -1;
        boolean tieneLlave = false;
        
        if (arregloTieneLlave.contains(demonioCrear))
            tieneLlave = true;
        
        int tipo = pilaDemonios.remove(demonioCrear);
        agregarDemonios(tipo, tieneLlave);
        
        //Retorna true si aun hay demonios en la pila
        return !pilaDemonios.isEmpty();
    }
    
    public void agregarDemonios(int tipodemonio, boolean tieneLlave) {
        verificarPosicionDemonio(tipodemonio, tieneLlave);
    }
    
    //esto verifica que no se colisionen entre si  
    public boolean validarColision(Demonio demonio) {
        Iterator<Pared> iteradorParedes = paredes.iterator();
        Iterator<Demonio> iteradorDemonios = demonios.iterator();
        Iterator<Trampa> iteradorTrampas = trampas.iterator();
        Iterator<Alma> iteradorAlmas = almas.iterator();
        Iterator<Cofre> iteradorCofres = cofres.iterator();
        //Iterator<Suelo> iteradorSuelos = suelos.iterator();
        
        while (iteradorParedes.hasNext()) {
            //El iterador nos ayuda a recorrer todo los arreglos para así verificar la colisión del demonio con cualquier otro objeto sobre el nivel
            
            if (iteradorTrampas.hasNext() && demonio.intersects(iteradorTrampas.next()))
                return false;
            
            if (demonio.intersects(iteradorParedes.next()))
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
    public void verificarPosicionDemonio (int tipoDemonio, boolean tieneLlave) {
        Demonio demonionuevo = null;
        boolean noColisiona = false;
        
        while(noColisiona == false){
          demonionuevo = fabrica.crearDemonio(tipoDemonio, this, angel, notificador, this, tieneLlave);
          
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
        if(movimientoAngel){  
            verificarColisionAngel(xAnterior, yAnterior);
            
            notificador.notificarCambios(Notificable.EVENTO_MOVIMIENTO);
        }
        
    }
    
    private void verificarColisionAngel(int xAnterior, int yAnterior) {        
        // Verificar colisión con los demonios
        for (int i = 0; i < demonios.size(); i++) {
            if (angel.intersects(demonios.get(i))) {
                // Si hay colisión, revertir el movimiento
                angel.revertirMovimiento(xAnterior, yAnterior);

                break;
            }
        }
        
        //Verificar colisión con las trampas
        for (int i = 0; i < trampas.size(); i++) {
            Trampa trampa = trampas.get(i);
            if (angel.intersects(trampa)) {
                trampa.accionar();
                trampas.remove(trampa);
            }
        }
        
        //Verificar colision con los cofres
        for (int i = 0; i < cofres.size(); i++) {
            Cofre cofre = cofres.get(i);
            
            if (angel.intersects(cofre) && angel.tieneLlaves()) {
                angel.abrirCofre();
                cofres.remove(cofre);
                potenciadores.add(cofre.crearPotenciador());
            }
        }
        
        //Verificar colisión con las llaves de los cofres
        for (int i = 0; i < llavesCofres.size(); i++) {
            Llave llave = llavesCofres.get(i);
            if (angel.intersects(llave)) {
                angel.tomarLlaveCofre();
                llavesCofres.remove(llave);
            }
        }
        
        for (int i = 0; i < potenciadores.size(); i++) {
            Potenciador potenciador = potenciadores.get(i);
            
            if(angel.intersects(potenciador)) {
                angel.tomarPotenciador(potenciador);
                potenciadores.remove(potenciador);
            }
        }
        
        //Verifica colisión con la llave de fin de nivel
        if (llaveFinNivel != null && angel.intersects(llaveFinNivel)) {
            llaveFinNivel = null;
        
            angel.agregarSeguidores(almas.size());
            notificador.notificarFinNivel();
            
        }
    }
    
    @Override
    public void dibujar(Graphics2D g) {           
        for (int i = 0; i < suelos.size(); i++) {
            Suelo suelo = suelos.get(i);
            suelo.dibujar(g);
        }
        
        for (int i = 0; i < paredes.size(); i++) {
            Pared pared = paredes.get(i);
            pared.dibujar(g);
        }

        if (puerta != null) {
            puerta.dibujar(g);
        }
        
        for (int i = 0; i < rayos.size(); i++) {
            Rayo rayo = rayos.get(i);
            rayo.dibujar(g);
            
        }

        for (int i = 0; i < cofres.size(); i++) {
            Cofre cofre = cofres.get(i);
            cofre.dibujar(g);
        }
        
        for (int i = 0; i < potenciadores.size(); i++) {
            Potenciador potenciador = potenciadores.get(i);
            potenciador.dibujar(g);
        }
        
        for (int i = 0; i < llavesCofres.size(); i++) {
            Llave llave = llavesCofres.get(i);
            llave.dibujar(g);
            
        }

        for (int i = 0; i < almas.size(); i++) {
            Alma alma = almas.get(i);
            alma.dibujar(g);
        }

        for (int i = 0; i < trampas.size(); i++) {
            Trampa trampa = trampas.get(i);
            trampa.dibujar(g);
        }

        for (int i = 0; i < demonios.size(); i++) {
            Demonio demonio = demonios.get(i);
            demonio.dibujar(g);
        }
        
        for (int i = 0; i < rocas.size(); i++) {
            Roca roca = rocas.get(i);
            roca.dibujar(g);
        }
        
        for (int i = 0; i < fuegos.size(); i++) {
            Fuego fuego = fuegos.get(i);
            fuego.dibujar(g);
        }
        
        for (int i = 0; i < tornados.size(); i++) {
            Tornado tornado = tornados.get(i);
            tornado.dibujar(g);
            
        }
        
   

        angel.dibujar(g);

        if (llaveFinNivel != null) {
            llaveFinNivel.dibujar(g);
        }
    }

    public void lanzarRayo(int x, int y) {
        if (!angel.tineEnergia())
            return;
        
        angel.lanzarRayos(x, y);

    }

    private void eliminarDemonio(Demonio demonio) {
        if(demonio.tieneLlave())
            crearLlaveCofre((int)demonio.getX(), (int)demonio.getY());
        
        if(getDemoniosRestantes() == 1)
            crearLlaveFinNivel((int) puerta.getX(), (int) puerta.getY()-100);
        
        demonios.remove(demonio);       
        notificador.notificarCambios(Notificable.EVENTO_MUERTE_DEMONIO);
    }

    @Override
    public boolean verificarColision(Rayo rayo) {
        synchronized (demonios) { // sincroniza el acceso a la lista de demonios
            Iterator<Demonio> demonioIterator = demonios.iterator();
            while (demonioIterator.hasNext()) {
                Demonio demonio = demonioIterator.next();
                if (demonio.intersects(rayo)) {
                    if (demonio.recibirImapcto(Angel.DAÑO)) {
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

    private void crearLlaveFinNivel(int x, int y) {        
        llaveFinNivel = new Llave(x, y, imagenes[ConstantesComunes.IMAGEN_LLAVE_PUERTA]);        
        
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
        synchronized (trampas) {
            this.trampas.add(trampaNueva);
        }
        
    }

    @Override
    public void agregarRayo(Rayo rayoNuevo) {
        rayos.add(rayoNuevo);
    }

    private void crearLlaveCofre(int x, int y) {
        llavesCofres.add(new Llave(x, y, imagenes[ConstantesComunes.IMAGEN_LLAVE_COFRE]));
    }

    @Override
    public void agregarRoca(Roca rocaNueva) {
        rocas.add(rocaNueva);
    }
    
    @Override
    public void agregarFuego(Fuego fuegonuevo){
        
        fuegos.add(fuegonuevo);
        
    }
    
    public void agregarTornado(Tornado tornadonuevo){
        
        tornados.add(tornadonuevo);
        
    }
    

    public void detener() throws java.lang.InterruptedException {
        hiloMovimiento.detenerHilo();
        hiloEspecial.detenerHilo();
    }

    @Override
    public boolean tocaBorde(Dibujo objeto) {
        for (Pared pared : paredes) {
            if (pared.intersects(objeto))
                return true;
        }
        
        if(puerta.intersects(objeto))
            return true;
        
        return false;
    }
}
