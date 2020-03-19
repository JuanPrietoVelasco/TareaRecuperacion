/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online6;

import static online6.ES.*;

/**
 *
 * @author juans
 */
public class Prueba {

    //escribirArchivo(String ruta, String datos, boolean sobreescribir) 
    public static void main(String[] args) {

//        String ruta = "c:/prueba/fichero.txt";
//        String datos = "Esto es la segunda línea de texto";
//        boolean sobreescritura = true;
//        
//        //escribirArchivo(ruta, datos, sobreescritura);
//        //System.out.println("Archivo creado");
//        
//        System.out.println(leerArchivo(ruta));
        escribir(leerArchivo("clientes.txt"));
        int separadorIni = 0;
        int separadorFin;
        String datos = leerArchivo("clientes.txt");

        for (int i = 0; i <= 5; i++) {

            System.out.println(separadorIni + " ini");

            separadorFin = datos.indexOf('#', separadorIni);

            System.out.println(separadorFin + " Fin");

            escribir(datos.substring(separadorIni, separadorFin));
            System.out.println(i);
            separadorIni = separadorFin;

            
            
            
        }

    }
}
