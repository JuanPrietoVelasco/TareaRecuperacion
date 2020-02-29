/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online6;

import java.util.Scanner;
import static online6.ES.*;
import static online6.Utilidades.*;
import static online6.Cliente.*;

/**
 *
 * @author juans
 */
public class AlquilerVehiculos {

    private static final int MAX_VEHICULOS = 50;
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_ALQUILERES = 50;
    private static Vehiculo[] vehiculos = new Vehiculo[MAX_VEHICULOS];
    private static Cliente[] clientes = new Cliente[MAX_CLIENTES];
    private static Alquiler[] alquileres = new Alquiler[MAX_ALQUILERES];
    private static boolean esCorrecto;

    public AlquilerVehiculos() {
    }

    public static Cliente getCliente(String dni) {

        Cliente c = null;

        if ((Utilidades.comprobarDni(dni))) {
            for (int i = 0; i < MAX_CLIENTES; i++) {
                //si la posicion array no es nula y coincide el dni existente lo devuelve
                if (clientes[i] != null && clientes[i].getDni().equalsIgnoreCase(dni)) {
                    c = clientes[i];
                    break;
                }
            }
        }

        return c;

    }

    /*Crea un método anadirCliente que añada un cliente al array de clientes si cabe
y si no existe ningún otro con el mismo DNI o muestre un mensaje con el error que se ha producido.*/
    public static void anadirCliente(Cliente c) {

        int pos = -1;
        boolean encontrado = false;

        //Primero comprobamos si existen espacios libres
        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i] == null) {
                pos = i;
                break;
            }
        }
        //Encontrado un espacio comparamos los dni        
        if (pos != -1) {
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null && clientes[i].getDni().equalsIgnoreCase(c.getDni())) {
                    encontrado = true;
                    break;
                }
            }
        } else {
            escribirLn("********************ATENCION********************");
            escribirLn("No hay espacio para nuevos clientes");
        }

        if (encontrado) {
            escribirLn("********************ATENCION********************");
            escribirLn("Dni ya registrado. Cliente no añadido.");
        } else {
            clientes[pos] = c;
            escribirLn(clientes[pos].toString());
            escribirLn("Cliente añadido correctamente.");
            escribirLn("------------------------------------------------\n");
        }
    }

    /*Crea un método borrarCliente que elimine un cliente, dado su DNI.*/
    public static void borrarClientes(String dni) {
        boolean eliminado = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDni().equalsIgnoreCase(dni)) {
                clientes[i] = null;
                eliminado = true;
                escribirLn("Cliente borrado.");
                escribirLn("------------------------------------------------\n");
                break;
            }
        }
        if (!eliminado) {
            escribirLn("********************ATENCION********************");
            escribirLn("Dni no registrado.");
            escribirLn("------------------------------------------------\n");
        }
    }

    //Devuelve la posición del array de un DNI determinado.
    public static int buscarCliente(String dni) {
        int pos = -1;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && dni.equalsIgnoreCase(clientes[i].getDni())) {
                pos = i;
            }
        }
        return pos;
    }

    /*Crea un método getVehiculo que se le pase la matrícula de un turismo y nos
lo devuelva si este existe o null en caso contrario.*/
    public static Vehiculo getVehiculo(String matricula) {
        Vehiculo v = null;

        if ((Utilidades.comprobarMatricula(matricula))) {
            for (int i = 0; i < MAX_VEHICULOS; i++) {
                //si la posicion array no es nula y coincide el dni existente lo devuelve
                if (vehiculos[i] != null && vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                    v = vehiculos[i];
                    break;
                }
            }
        }
        return v;
    }

    /*Crea un método anadirVehiculo que añada un coche al array de vehiculos si
cabe y no existe ningún otro con la misma matrícula o muestre un mensaje con el
error que se ha producido.*/
    public static void anadirVehiculo(Vehiculo v) {
        //pos para guardar primera posición nula(vacia)
        int pos = -1;
        boolean encontrado = false;

        //Comprobamos si existen espacios libres
        for (int i = 0; i < vehiculos.length; i++) {

            if (vehiculos[i] == null) {
                pos = i;
                break;
            }
        }
        //existe espacio en el array, ha dado toda la vuelta y pos no ha cambiado. Ahora comprobamos que no este ya guarda la matrícula
        //Si 0 esta vacia, pos = 0 por ser null, pero 0 aún no tine vehículo para poder comparar matrícula.(pos!=0)
        if (pos != -1) {
            for (int i = 0; i < vehiculos.length; i++) {

                if (vehiculos[i] != null && vehiculos[i].getMatricula().equalsIgnoreCase(v.getMatricula())) {
                    /**/ escribirLn(vehiculos[i].getMatricula());
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                escribirLn("********************ATENCION********************");
                escribirLn("Matrícula ya registrada. Vehiculo no añadido.");
                escribirLn("------------------------------------------------\n");
            } else {
                vehiculos[pos] = v;
                escribirLn(vehiculos[pos].toString());
                escribirLn("Vehiculo añadido correctamente.");
                escribirLn("------------------------------------------------\n");
            }

        } else {
            escribirLn("********************ATENCION********************");
            escribirLn("No hay espacio para nuevos vehiculos.");
            escribirLn("------------------------------------------------\n");
        }

    }

    /* Crea un método borrarVehiculo que borre un vehiculo, dada su matrícula, del
    array de vehiculos. */
    public static void borrarVehiculo(String m) {
        int pos = -1;
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].getMatricula().equalsIgnoreCase(m)) {
                vehiculos[i] = null;
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            escribirLn("********************ATENCION********************");
            escribirLn("Matricula no registrada.");
        } else {
            escribirLn("Vehiculo borrado correctamente.");
            escribirLn("------------------------------------------------\n");
        }
    }

    //Devuelve la posición del array de una matrícula determinada.
    public static int buscarVehiculo(String matricula) {
        int pos = -1;

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && matricula.equalsIgnoreCase(vehiculos[i].getMatricula())) {
                pos = i;
            }
        }
        return pos;
    }

    /*Crea un método nuevoAlquiler que dado un cliente y un vehiculo cree un nuevo
alquiler y lo añada al array de alquileres. Para ello se debe comprobar que el vehiculo esté disponible.*/
    public static void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int pos = -1;
        if (vehiculo.isDisponible()) {

            for (int i = 0; i < MAX_ALQUILERES; i++) {
                if (alquileres[i] == null) {
                    pos = i;
                    alquileres[i] = new Alquiler(cliente, vehiculo);
                    break;
                }
            }
            if (pos == -1) {
                escribirLn("********************ATENCION********************");
                escribirLn("No existe espacio para nuevos alquileres.");
            }

        } else {
            escribirLn("Vehiculo no disponible.");
        }

    }

    /*Crea un método cerrarAlquiler que cierre el alquiler dado un cliente y un vehiculo.*/
    public static void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int pos = -1;

        for (int i = 0; i < MAX_ALQUILERES; i++) {
            if (alquileres[i].getCliente().equals(cliente) && alquileres[i].getVehiculo().equals(vehiculo)) {
                alquileres[i].cerrar(vehiculos);
                escribirLn("Alquiler finalizado con exito.");
            }
        }
        if (pos == -1) {
            escribirLn("********************ATENCION********************");
            escribirLn("No existe alquiler con ese cliente y vehículo");
        }

    }

    //---------------------------------------MAIN------------------------------------------------------//  
    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        escribirLn("-------------------------------------------------------");
        escribirLn("Bienvenido al programa de gestión de Alquileres Xuanin.");
        escribirLn("-------------------------------------------------------");

        do {
            esCorrecto = false;

            escribirLn("\nOpciones: ");
            escribirLn("1. Añadir cliente.\n2. Borrar cliente.\n3. Listar clientes.\n"
                    + "4. Añadir vehiculo.\n5. Borrar vehiculo.\n6. Listar vehiculos.\n"
                    + "7. Nuevo alquiler.\n8. Cerrar alquiler.\n9. Listar alquileres.\n"
                    + "10. Salir.");

            opcion = leerEntero("Introduzca opción: ");

            switch (opcion) {
                case 1:
                    caseAnadirCliente();
                    break;
                case 2:
                    caseBorrarCliente();
                    break;
                case 3:
                    caseListarClientes();
                    break;
                case 4:
                    caseAnadirVehiculo();
                    break;
                case 5:
                    caseBorrarVehiculo();
                    break;
                case 6:
                    caseListarVehiculos();
                    break;
                case 7:
                    caseNuevoAlquiler();
                    break;
                case 8:
                    caseCerrarAlquiler();
                    break;
                case 9:
                    caseListarAlquileres();
                    break;
                case 10:
                    escribir("Fin de programa");
                    break;

            }
        } while (opcion != 10);
    }
//---------------------------------------METODOS OPCIONES MENU-------------------------------------//

    public static void caseAnadirCliente() {

        String nie;
        String dni = leerCadena("Introduce DNI de cliente: ").toUpperCase();
        if (comprobarDni(dni)) {
            nie = dni;
            if (nie.substring(0, 1).equalsIgnoreCase("X")
                    || nie.substring(0, 1).equalsIgnoreCase("Y")
                    || nie.substring(0, 1).equalsIgnoreCase("Z")) {
                nie = pasarNieADni(nie);
            }
            //Comparamos la letra del dni/nie con la letra calculada con el método calcular letra
            if (nie.substring(8, 9).equalsIgnoreCase(calcularLetraDni(nie.substring(0, 8)))) {
                //escribirLn("DNI correcto");
                String nombre = leerCadena("Introduce nombre de cliente: ").toUpperCase();
                String direccion = leerCadena("Introduce dirección de cliente: ").toUpperCase();
                String localidad = leerCadena("Introduce localidad de cliente: ").toUpperCase();

                //utilizar otro while para volver a pedir el cp si fuera erroneo
                String cod_postal = leerCadena("Introduce el código postal de cliente: ");

                if (comprobarCodigoPostal(cod_postal)) {

                    anadirCliente(new Cliente(dni, nombre, direccion, localidad, cod_postal));

                } else {
                    escribir("Código postal incorrecto.");
                }

            } else {
                escribirLn("********************ATENCION********************");
                escribirLn("Letra de DNI incorrecta.");
            }

        } else {
            escribirLn("********************ATENCION********************");
            escribir("Formato de DNI incorrecto.");
        }

    }

    public static void caseBorrarCliente() {

        String dni = leerCadena("Introduce DNI de cliente a borrar: ").toUpperCase();
        if (comprobarDni(dni)) {
            if (dni.substring(0, 1).equalsIgnoreCase("X")
                    || dni.substring(0, 1).equalsIgnoreCase("Y")
                    || dni.substring(0, 1).equalsIgnoreCase("Z")) {
                dni = pasarNieADni(dni);
            }
            //Comparamos la letra del dni con la letra calculada con el método calcular letra
            if (dni.substring(8, 9).equalsIgnoreCase(calcularLetraDni(dni.substring(0, 8)))) {
                borrarClientes(dni);
                esCorrecto = true;
            } else {
                escribirLn("********************ATENCION********************");
                escribirLn("Letra de DNI incorrecta.");
            }
        } else {
            escribirLn("********************ATENCION********************");
            escribirLn("Formato de DNI incorrecto");
        }
    }

    public static void caseListarClientes() {
        //while (!esCorrecto) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                escribirLn(clientes[i].toString());
                //}
                //esCorrecto = true;
            }
        }
        escribirLn("------------------------------------------------\n");
    }

    public static void caseAnadirVehiculo() {

        String matricula = (leerCadena("Introduce matrícula del vehículo: ")).toUpperCase();
        //escribirLn(matricula);
        if (comprobarMatricula(matricula)) {
            
            
            
            
            String marca = (leerCadena("Introduzca marca del vehículo: ")).toUpperCase();
            String modelo = (leerCadena("Introduce modelo del vehículo: ")).toUpperCase();
            int cilindrada = leerEntero("Introduce cilindrada del vehículo: ");
            
            //Seleccione Tipo de vehiculo
            //1.Mercancias
            //2.Turismo
            
            //switch(opcion)
            
            //case->1
            
            //crearFurgoneta()
            
            
            
            
            //------Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, cilindrada);
            //anadirVehiculo(vehiculo);
        } else {
            escribirLn("********************ATENCION********************");
            escribirLn("Formato de matrícula incorrecto.");
        }
    }

    public static void caseBorrarVehiculo() {

        String matricula = (leerCadena("Introduce matrícula del vehiculo a borrar: ")).toUpperCase();
        comprobarMatricula(matricula);
        if (comprobarMatricula(matricula)) {
            borrarVehiculo(matricula);

        } else {
            escribirLn("********************ATENCION********************");
            escribirLn("Formato de matrícula incorrecto.");
        }
    }

    public static void caseListarVehiculos() {
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                escribirLn(vehiculos[i].toString());
            }

        }

    }

    public static void caseNuevoAlquiler() {
        String dni;
        String dniAux;
        String matricula;
        int posCliente;
        int posVehiculo;
        boolean value = false;

        dni = (leerCadena("Introduzca Dni del cliente: ")).toUpperCase();
        dniAux = dni;

        if (comprobarDni(dniAux)) {

            //Comprobamos si es un NIE, y en caso de serlo lo convertimos a DNI para posteriormente
            //comprobar la letra final.
            if (dniAux.substring(0, 1).equalsIgnoreCase("X")
                    || dniAux.substring(0, 1).equalsIgnoreCase("Y")
                    || dniAux.substring(0, 1).equalsIgnoreCase("Z")) {
                dniAux = pasarNieADni(dniAux);
            }

            //Comprobamos la letra final del dni para validarlo
            if (dniAux.substring(8, 9).equalsIgnoreCase(calcularLetraDni(dniAux.substring(0, 8)))) {

                posCliente = buscarCliente(dni);

                if (posCliente != -1) {

                    matricula = leerCadena("Introduzca matricula del vehículo: ").toUpperCase();

                    if (comprobarMatricula(matricula)) {

                        posVehiculo = buscarVehiculo(matricula);

                        if (posVehiculo != -1) {

                            if (vehiculos[posVehiculo].isDisponible() == true) {

                                for (int i = 0; i < alquileres.length && !value; i++) {
                                    if (alquileres[i] == null) {
                                        vehiculos[posVehiculo].setDisponible(false);
                                        alquileres[i] = new Alquiler(clientes[posCliente], vehiculos[posVehiculo]);
                                        System.out.println(alquileres[i]);
                                        value = true;
                                    }
                                }

                                if (!value) {
                                    escribir("no hay espacio en la memoria para nuevos alquileres.");
                                } else {
                                    escribir("Alquiler registrado correctamente");
                                }//FIN

                            } else {
                                escribir("El vehiculo no está disponible en este momento.");
                            }

                        } else {
                            System.out.println("El vehículo no está registrado.");
                        }

                    } else {
                        System.out.println("Formato de matrícula incorrecto.");
                    }

                } else {
                    escribir("No hay ningún cliente registro con el Dni/Nie proporciado");
                }

            } else {
                escribir("Letra del Dni/Nie incorrecto.");
            }

        } else {
            escribir("Formato de DNI incorrecto");
        }

    }

    public static void caseCerrarAlquiler() {
        String dni;
        String dniAux;
        String matricula;
        int posCliente;
        int posVehiculo;
        boolean value = false;
        Cliente cliente;
        Vehiculo vehiculo;

        dni = (leerCadena("Introduzca Dni del cliente: ")).toUpperCase();
        dniAux = dni;

        if (comprobarDni(dniAux)) {

            //Comprobamos si es un NIE, y en caso de serlo lo convertimos a DNI para posteriormente
            //comprobar la letra final.
            if (dniAux.substring(0, 1).equalsIgnoreCase("X")
                    || dniAux.substring(0, 1).equalsIgnoreCase("Y")
                    || dniAux.substring(0, 1).equalsIgnoreCase("Z")) {
                dniAux = pasarNieADni(dniAux);
            }

            //Comprobamos la letra final del dni para validarlo
            if (dniAux.substring(8, 9).equalsIgnoreCase(calcularLetraDni(dniAux.substring(0, 8)))) {

                posCliente = buscarCliente(dni);

                if (posCliente != -1) {

                    cliente = clientes[posCliente];

                    matricula = leerCadena("Introduzca matricula del vehículo: ").toUpperCase();

                    if (comprobarMatricula(matricula)) {

                        posVehiculo = buscarVehiculo(matricula);

                        if (posVehiculo != -1) {

                            vehiculo = vehiculos[posVehiculo];

                            if (!vehiculo.isDisponible()) {

                                for (int i = 0; i < alquileres.length && !value; i++) {
                                    if (alquileres[i] != null) {

                                        if (alquileres[i].getCliente().equals(cliente) && alquileres[i].getVehiculo().equals(vehiculo)) {

                                            alquileres[i].cerrar(vehiculos);
                                            value = true;

                                        }
                                    }
                                }

                                if (!value) {
                                    escribir("No hay alquileres que contengan el cliente y el vehiculo indicado.");
                                } else {
                                    escribir("Alquiler cerrado correctamente");
                                }//FIN

                            } else {
                                escribir("El vehiculo no está en alquiler.");
                            }

                        } else {
                            System.out.println("El vehículo no está registrado.");
                        }

                    } else {
                        System.out.println("Formato de matrícula incorrecto.");
                    }

                } else {
                    escribir("No hay ningún cliente registro con el Dni/Nie proporciado");
                }

            } else {
                escribir("Letra del Dni/Nie incorrecto.");
            }

        } else {
            escribir("Formato de DNI incorrecto");
        }

    }

    public static void caseListarAlquileres() {
        boolean vacio=true;
        
        for (int i = 0; i < alquileres.length; i++) {
            if (alquileres[i] != null) {
                escribirLn(alquileres[i].toString());
                vacio=false;
            }

        }
        if (vacio){
            escribir("No existen alquileres");
        }
    }
}
