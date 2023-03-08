/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioasincrono020320;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Alejandro Bautista
 */
public class EjercicioAsincrono020320 {

    public String[] LeerArchivo() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] productos = null;
        FileWriter fichero = null;
        PrintWriter pw = null; 
        

        try {
            productos = new String[10];
            String path = System.getProperty("user.dir"); 
            String pathrd = System.getProperty("user.dir");
            path = path + "\\Archivo\\LeerArchivos\\Catalogo.txt";
            
            /*System.out.println("path :" + path); */
            pathrd = pathrd + "\\Archivo\\EscribirArchivos\\FacturaII.txt";
                        
            
            archivo = new File(path);
            
            fr = new FileReader(archivo);
            if(fr.ready()){
                br = new BufferedReader(fr);
                

                
            }
            else {
                System.out.println("El archivo no esta listo");
            }
            
            ///Lectura del archivo
            String linea;
            String lineatmp = "";
            String saltoli = "\n";
            ///String lineatmp = "";

            while ((linea = br.readLine())!= null){
                
                lineatmp = lineatmp + linea + saltoli ;
                System.out.println(linea);
                
                productos = lineatmp.split(" ");
            ///System.out.print(Arrays.asList(productos)+" \n");
                try{
                    fichero = new FileWriter(pathrd);
            pw = new PrintWriter(fichero);
            
            pw.println(lineatmp+"\n");
                    
                }catch(Exception e){
            e.printStackTrace();
            
        } finally{
            try{
                if(null != fichero)
                    fichero.close();
            } catch(Exception e2){
                e2.printStackTrace();
            }
        }
                
                ///System.out.println(Arrays.asList(productos));
            }                                             
                

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        return productos;
    }
    
    
    public static void main(String[] args) {

        EjercicioAsincrono020320 archivos = new EjercicioAsincrono020320();
        
        archivos.LeerArchivo();
        ///archivos.Escribir();

    }

}