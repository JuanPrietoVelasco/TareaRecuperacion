/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online7;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author juans
 */
public class ES {

    //leerEntero():int 
    public static int leerEntero() {

        boolean correcto = false;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("Introduzca un número entero.");

            try {
                num = Integer.parseInt(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return num;
    }

    //leerEntero(String):int 
    public static int leerEntero(String msg) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println(msg);

            try {
                num = Integer.parseInt(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return num;

    }

    //leerEntero(int,int,String):int 
    public static int leerEntero(int min, int max, String msg) {

        //Deberemos introducir un messaje y dos números entre los que se encuentre el introducido por teclado
        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println(msg);

            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            } catch (Exception e) {
                correcto = false;
                System.out.println("Introduce un número entre " + min + " y " + max + " .");
            }
        } while (!correcto);
        return num;
    }

    //leerEnteroLargo():long 
    public static long leerEnteroLargo() {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        long numLong = 0;
        do {
            System.out.println("Introduzca número largo.");

            try {
                numLong = Long.parseLong(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numLong);
    }

    //leerEnteroLargo(String):long 
    public static int leerEnteroLargo(String msg) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println(msg);

            try {
                num = Integer.parseInt(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (num);

    }

    public static float leerReal() {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        float numFloat = 0.0f;
        do {
            System.out.println("Introduzca un número float.");

            try {
                numFloat = Float.parseFloat(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numFloat);
    }

    //leerReal(String):float 
    public static float leerReal(String msg) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        float numFloat = 0.0f;

        do {
            System.out.println(msg);

            try {
                numFloat = Float.parseFloat(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numFloat);
    }

    //leerRealLargo():double 
    public static double leerRealLargo() {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        double numDouble = 0.0;
        do {
            System.out.println("Introduzca número real double.");

            try {
                numDouble = Double.parseDouble(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numDouble);
    }

    //leerRealLargo(String):double 
    public static double leerRealLargo(String msg) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        double numDouble = 0.0d;

        do {
            System.out.println(msg);

            try {
                numDouble = Double.parseDouble(sc.nextLine());
                correcto = true;
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numDouble);
    }

    //leerCadena():String 
    public static String leerCadena() {
        String cad;
        System.out.println("Introduzca una cadena de caracteres.");
        Scanner sc = new Scanner(System.in);
        cad = (sc.nextLine());
        return (cad);
    }

    //leerCadena(String):String 
    public static String leerCadena(String msg) {
        String cad;
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        cad = (sc.nextLine());
        return cad;
    }

    //leerCaracter():char 
    public static String leerCaracter() {
        String cara = "";
        Scanner sc = new Scanner(System.in);
        int caraLong = 0;

        while (caraLong != 1) {

            System.out.println("Introduzca un caracter.");
            cara = (sc.nextLine());
            caraLong = cara.length();
        }
        return (cara);
    }

    //leerCaracter(String):char 
    public static String leerCaracter(String msg) {
        String cara = "";
        Scanner sc = new Scanner(System.in);
        int caraLong = 0;

        while (caraLong != 1) {

            System.out.println(msg);
            cara = (sc.nextLine());
            caraLong = cara.length();
        }
        return (cara);
    }

    //leerBooleano():boolean 
    public static boolean leerBoolean() {
        String opcion = "";
        Scanner sc = new Scanner(System.in);
        //Igualamos el Si a true y el No a false
        boolean resul = true;
        //Utilizamos un boolean para determinar si se ha introducido si o no y salir del do
        boolean valido = false;

        do {
            System.out.println("Introduzca S para Si o N para No.");
            opcion = sc.next();

            if (opcion.equalsIgnoreCase("S")) {
                valido = true;
                resul = true;
            } else {
                if (opcion.equalsIgnoreCase("N")) {
                    valido = true;
                    resul = false;
                }
            }
        } while (valido == false);
        return (resul);
    }

    //leerBoolean(String):boolean 
    public static boolean leerBoolean(String msg) {
        String opcion = "";
        Scanner sc = new Scanner(System.in);
        //Igualamos el Si a true y el No a false
        boolean resul = true;
   
        do {
            System.out.println(msg);

            opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("S")) {
                
                resul = true;
            } else {
                if (opcion.equalsIgnoreCase("N")) {
                    
                    resul = false;
                }
            }
            
            if(!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N")){
                escribir("Debes introducir una S o una N!");
            }
            
        } while (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N"));
        
        return resul;
    }

    //escribir(String):void 
    public static void escribir(String msg) {
        System.out.print(msg + "\n");
    }

    //escribirLn(String):void
    public static void escribirLn(String msg) {
        System.out.println(msg + "\n");
    }

    //leerEntero( String, int): int
    public static int leerEntero(String msg, int min) {

        //Deberemos introducir un messaje y un número que sea menor que el introducido por teclado
        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println(msg);

            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (num);

    }

    //leerReal( String, int): float
    public static float leerReal(String msg, int min) {

        boolean correcto = false;
        Scanner sc = new Scanner(System.in);
        float numFloat = 0;

        do {
            System.out.println(msg);

            try {
                numFloat = Float.parseFloat(sc.nextLine());
                if (numFloat >= min) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            } catch (Exception e) {
                correcto = false;
            }
        } while (!correcto);
        return (numFloat);
    }

    public static String leerCadena(String msg, int longitud) {
        
        Scanner sc = new Scanner(System.in);
        
        String cadena;
        do{
            System.out.println(msg);
            cadena = sc.next();
            
            if(msg.length() != longitud){
                System.out.println("Longitud de cadena errónea.");
            }
            
        }while(msg.length() != longitud);
     
        return cadena;
    }

    public static boolean escribirArchivo(String ruta, String datos, boolean sobreescribir) {
        

        boolean exito = false, sobreescritura = !sobreescribir;
        
        
        //filewriter nos permite crear y escribir en ficheros
        FileWriter fichero = null;
        //PrintWriter nos permite agregarle funcionalidad de escritura a anterior
        PrintWriter fw = null;

        try {
            fichero = new FileWriter(ruta, sobreescritura);
            fw = new PrintWriter(fichero);

            fw.println(datos);
            exito = true;

        } catch (Exception e) {
            e.getMessage();
        }finally{
            try{
                //cerramos el archivo y tiene que ser en un try catch
                fichero.close();
            }catch(Exception e2){
                e2.getMessage();
            }
        }
        //true=se ha realizado la escritura correctamente
        return exito;
    }
    
    public static String leerArchivo(String ruta){
        
        String resultado ="";
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            // Abrir el fichero y creación de BufferedReader para disponer del método readLine()).
            
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            //Lectura del archivo
            
            String linea;
            while((linea = br.readLine())!=null){
                resultado+=linea+"\n";
            }
            
        }catch(Exception e){
            e.getMessage();
        }finally{
            try{
                fr.close();
            }catch(Exception e2){
                e2.getMessage();
            }
        }

        return resultado;
        
    }

}
