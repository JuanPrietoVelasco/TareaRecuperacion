/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author juans
 */
public class Utilidades {


    public static boolean comprobarMatricula(String matricula) {
        //cpmprueba el formato de la matrícula. excluidas las vocales.
        
        Pattern p = Pattern.compile("[0-9]{4}[BCDFGHIJKLMNPQRSTUVWXYZ]{3}");
        Matcher m = p.matcher(matricula);
        return m.matches();
    }

    public static boolean comprobarCodigoPostal(String codigoPostal) {
        //comprueba que el cp esta entre 1000 y 52999
        
        Pattern p = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
        Matcher m = p.matcher(codigoPostal);
        return m.matches();
    }

    public static boolean comprobarDni(String dni) {
        //Nie x,z o y y 7 números/ Dni 8 números 
        Pattern p = Pattern.compile("([XYZ]{1}[0-9]{7})|([0-9]{8})");
        Matcher m = p.matcher(dni);

        return m.matches();
    }

    public static String calcularLetraDni(String dni) {
        //devuelve  la letra del dni/nie    

        String letras[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int resto;
        String letra = "";
        String dniNumeros = dni.substring(0, 8);

        resto = Integer.parseInt(dniNumeros) % 23;
        letra = letras[resto];
        return letra;
    }

    public static String pasarNieADni(String nie) {
        //crea una v aux para tratar el nie como dni. Sustituye letra inicial por convalidación numérica
        char letra = nie.charAt(0);
        switch (letra) {
            case 'X':
                nie = nie.replace("X", "0");
            case 'Y':
                nie = nie.replace("Y", "1");
            case 'Z':
                nie = nie.replace("Z", "2");
        }
        return nie;
    }

    public static String procesarDni(String dni) {
        //Métodos pasar nie a dni y calcular letra juntos.   

        String dniAux = dni;
        //Comprobamos si es un NIE, y en caso de serlo lo convertimos a DNI
        if (dniAux.substring(0, 1).equalsIgnoreCase("X")
                || dniAux.substring(0, 1).equalsIgnoreCase("Y")
                || dniAux.substring(0, 1).equalsIgnoreCase("Z")) {
            dniAux = pasarNieADni(dniAux);
        }
        dni += calcularLetraDni(dniAux);
        //el dni/nie ya está comprobado y con su letra
        return dni;
    }
    
    public static boolean arrayVacio(Object[] array) {
        //Saber si un array está vacio.
        boolean vacio = true;

        for (int i = 0; i < array.length && vacio == true; i++) {
            if (array[i] != null) {
                vacio = false;
            }
        }
        return vacio;
    }

    
}
