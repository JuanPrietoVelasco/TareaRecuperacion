/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online5;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**Crea un método main. El método main deberá mostrarnos un menú con las diferentes
 * opciones (añadir cliente, borrar cliente, listar clientes, añadir vehículo, borrar
 * vehículo, listar vehículo, abrir un alquiler, cerrar un alquiler, listar alquileres
 * y salir) y actuar en consecuencia. El menú se repetirá mientras no elijamos la
 * opción salir. En todo caso se debe validar que todas las entradas al programa son
 * correctas. Este método realizará llamadas a los distintos métodos de la clase ES
 * para mostrar la información por pantalla o solicitar datos desde teclado. De igual
 * manera realizará llamadas a los distintos métodos de la clase Utilidades para
 * comprobar que los dnis, matrículas y códigos postales tengan un formato adecuado.
 *
 * @author juans
 */
public class Online5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner (System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Bienvenido al programa de gestión de Alquileres Xuanin.");
        System.out.println("-------------------------------------------------------\n");
        System.out.println("Opciones: ");
        System.out.println("1. Añadir cliente.\n2. Borrar cliente.\n3. Listar clientes.\n"
                + "4. Añadir vehiculo.\n5. Borrar vehiculo.\n6. Listar vehiculos.\n"
                + "7. Abrir un alquiler.\n8. Cerrar un alquiler.\n9. Listar alquileres.\n"
                + "10. Salir.");
        
        opcion = ES.leerEntero(1, 10, "Elija una opción.");
        
        switch (opcion){
            case 1:
                AlquilerVehiculos.anadirCliente(c);
            case 2:    
                AlquilerVehiculos.borrarClientes(dni);
            case 3:
                Cliente.
        }

        //switch (opcion){
        
        
        
        
        }
        
        
        
        
        
        
        
//        Scanner sc =new Scanner(System.in);
//        
//        Cliente miCliente = new Cliente("5234218V", "Jose", "CL PRINCIPAL, 32", "ALICANTE", "03700");
//        
//        Cliente segundoCliente = new Cliente(miCliente);
//        
//        Vehiculo miVehiculo=new Vehiculo("4567HJH","OPEL","ASTRA",1500);
        
        //Alquiler alquiler = new Alquiler (miCliente,miVehiculo);
        
        //Utilidades.pasarNieADni("Z7188927");
        //Utilidades.calcularLetraDni("71889272");
        
       
                
       


        


//        System.out.println("Matrícula: ");
//        String matricula=sc.nextLine();
//        Utilidades.comprobarMatricula(matricula);
//        System.out.println(Utilidades.mMatricula);
    }
    
}
