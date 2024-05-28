/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import nivel.Nivel;
import nivel.elementos.pared.Pared;

/**
 *
 * @author Alejandro
 */
public class LectorArchivos {

    private BufferedReader reader;
    private Charset charset;
    private Path path;
    
    public LectorArchivos() {
        charset = Charset.forName("UTF-8");
    }
    
    public void setBufferedReader(String nombreArchivo) throws IOException {
        path = Paths.get(nombreArchivo);
        
        reader = Files.newBufferedReader(path, charset); 
    }
    
    public String leerLinea() throws IOException {
        return reader.readLine();
    }    
}
