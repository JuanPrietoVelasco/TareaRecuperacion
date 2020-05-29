package aplicacion;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import modelo.*;
import static utiles.ES.*;
import static utiles.Utilidades.*;
import static modelo.Enumerados.*;

/**
 * @author juan
 */
public class AlquilerVehiculos {

    private static final int VEHICULOS_MAX = 40;
    private static final int CLIENTES_MAX = 5;
    private static final int ALQUILERES_MAX = 40;
    private static Vehiculo[] vehiculos = new Vehiculo[VEHICULOS_MAX];
    private static Cliente[] clientes = new Cliente[CLIENTES_MAX];
    private static Alquiler[] alquileres = new Alquiler[ALQUILERES_MAX];
    private static boolean esValido;

    public static void main(String[] args) {

        //Cargamos los datos desde los archivos.
        leerDatos();

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        boolean guardar = false;

        escribirLn("-------------------------------------------------------");
        escribirLn("Bienvenido al programa de gestión de Alquileres Xuanin.");
        escribirLn("-------------------------------------------------------");

        do {

            escribirLn("Opciones: ");
            escribirLn("1. Añadir cliente.\n2. Modificar estado de alta de cliente.\n3. Listar clientes.\n"
                    + "4. Añadir vehiculo.\n5. Modificar estado de alta de vehiculo.\n6. Listar vehiculos.\n"
                    + "7. Nuevo alquiler.\n8. Cerrar alquiler.\n9. Listar alquileres.\n"
                    + "10. Guardar datos.\n11. Salir.");

            opcion = leerEntero("\nIntroduce opción: ");

            switch (opcion) {
                case 1:
                    anadirCliente();
                    guardar = true;
                    break;
                case 2:
                    llamarBorrarCliente();
                    guardar = true;
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    anadirVehiculo();
                    guardar = true;
                    break;
                case 5:
                    llamarBorrarVehiculo();
                    guardar = true;
                    break;
                case 6:
                    listarVehiculos();
                    break;
                case 7:
                    nuevoAlquiler();
                    guardar = true;
                    break;
                case 8:
                    llamarCerrarAlquiler();
                    guardar = true;
                    break;
                case 9:
                    listarAlquileres();
                    break;
                case 10:
                    guardarDatos();
                    guardar = false;
                    break;
                case 11:
                    if (guardar) {
                        confirmarGuardarDatos();
                        escribirLn("\n               Fin de programa");
                        escribirLn("------------------------------------------------\n");
                        escribirLn("------------------------------------------------\n");
                    } else {
                        escribirLn("\n               Fin de programa");
                        escribirLn("------------------------------------------------\n");
                        escribirLn("------------------------------------------------\n");
                    }
                    Arrays.fill(clientes, null);
                    Arrays.fill(vehiculos, null);
                    Arrays.fill(alquileres, null);

                    break;
                default:
                    escribirLn("********************ATENCION********************");
                    escribirLn("              Opción incorrecta.");
                    escribirLn("          Elija una opción del menu.");
                    escribirLn("------------------------------------------------");
                    break;
            }
        } while (opcion != 11);
    }

    public AlquilerVehiculos() {
        //lo pide el ejercicio¿se usa?
    }

    public static Cliente getCliente(String dni) {

        Cliente c = null;

        for (int i = 0; i < clientes.length && c == null; i++) {
            //si la posicion array no es nula y coincide el dni existente lo devuelve
            if (clientes[i] != null && clientes[i].getDni().equalsIgnoreCase(dni)) {
                c = clientes[i];

            }
        }

        return c;

    }

    public static Vehiculo getVehiculo(String matricula) {
        /*Crea un método getVehiculo que se le pase la matrícula de un turismo y nos
        lo devuelva si este existe o null en caso contrario.*/

        Vehiculo v = null;

        for (int i = 0; i < vehiculos.length; i++) {
            //si la posicion array no es nula y coincide el dni existente lo devuelve
            if (vehiculos[i] != null && vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                v = vehiculos[i];
                break;
            }
        }
        return v;
    }

    public static void anadirCliente() {

        String dni;

        // Buscamos posición libre en el array.
        int pos = -1;
        for (int i = 0; i < clientes.length && pos == -1; i++) {
            if (clientes[i] == null) {
                pos = i;
            }
        }

        if (pos != -1) {

            boolean value = false;

            int edad = leerEntero("\nIntroduce edad de cliente: ");
            if (edad < 21) {
                escribirLn("\n  ********************ATENCION********************");
                escribirLn("La edad mínima para realizar un alquiler son 21 años.");
                escribirLn("  ------------------------------------------------");
            } else {

                do {
                    dni = leerCadena("\nIntroduce Dni/Nie sin la letra final: ").toUpperCase();
                    if (comprobarDni(dni)) {
                        value = true;
                        dni = procesarDni(dni);

                    } else {
                        escribirLn("\n********************ATENCION********************");
                        escribirLn("         Formato de dni/nie incorrecto.");
                        escribirLn("          Formato tipo dni: 12345678");
                        escribirLn("          Formato tipo nie: X1234567");
                        escribirLn("------------------------------------------------\n");
                    }

                } while (!value);

                if (getCliente(dni) != null) {
                    //buscamos el cliente en el array
                    Cliente cliente = getCliente(dni);

                    if (!cliente.getAlta()) {
                        //Cliente de baja
                        boolean opcion = leerBoolean("Cliente existente y dado de baja.¿Volver a dar de alta? S/N.");

                        if (opcion) {
                            cliente.setAlta(true);
                            escribirLn("\n        Cliente dado de alta nuevamente.");
                            escribirLn("------------------------------------------------\n");
                        } else {
                            escribirLn("\n********************ATENCION********************");
                            escribirLn("        No se ha registrado ningún cliente.");
                            escribirLn("------------------------------------------------\n");
                        }
                    } else {

                        escribirLn("\n********************ATENCION********************");
                        escribirLn("            Cliente ya registrado.");
                        escribirLn("------------------------------------------------\n");
                    }
                } else {

                    String nombreEmpresa;
                    boolean opcion = leerBoolean("\n¿Alquila para una empresa? S/N.");
                    if (opcion) {
                        nombreEmpresa = leerCadena("\nIntroduce nombre empresa: ").toUpperCase();
                    } else {
                        nombreEmpresa = "PARTICULAR";
                    }

                    String nombre = leerCadena("\nIntroduce nombre de cliente: ").toUpperCase();
                    String direccion = leerCadena("\nIntroduce dirección de cliente: ").toUpperCase();
                    String localidad = leerCadena("\nIntroduce localidad de cliente: ").toUpperCase();

                    value = false;
                    //utilizar un while para volver a pedir el cp si fuera erroneo
                    while (!value) {
                        String cod_postal = leerCadena("\nIntroduce el código postal de cliente: ");
                        if (comprobarCodigoPostal(cod_postal)) {
                            value = true;
                            Cliente c = new Cliente(edad, dni, nombreEmpresa, nombre, direccion, localidad, cod_postal);

                            clientes[pos] = c;
                            escribirLn(c.toString());

                            escribir("\n       Cliente añadido correctamente.");
                            escribirLn("------------------------------------------------\n");

                        } else {
                            escribirLn("\n********************ATENCION********************");
                            escribirLn("          Código postal incorrecto.");
                            escribirLn("------------------------------------------------");
                        }
                    }
                }
            }
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("       Espacio insuficiente en memoria.");
            escribirLn("------------------------------------------------");
        }
    }

    public static void llamarBorrarCliente() {
        /*Metodo creado para declarar e inicializar dni y así poder pasarlo por parámetro
        a borrarCliente(String dni)*/

        esValido = false;
        if (arrayVacio(clientes)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("          No existen clientes registrados.");
            escribirLn("------------------------------------------------\n");

        } else {
            while (!esValido) {
                String dni = leerCadena("\nIntroduce Dni/Nie de cliente sin la letra final.").toUpperCase();

                if (comprobarDni(dni)) {
                    dni = procesarDni(dni);

                    borrarCliente(dni);

                    esValido = true;
                } else {
                    escribirLn("\n********************ATENCION********************");
                    escribirLn("         Formato de dni/nie incorrecto.");
                    escribirLn("          Formato tipo dni: 12345678");
                    escribirLn("          Formato tipo nie: X1234567");
                    escribirLn("------------------------------------------------\n");
                }
            }
        }

    }

    public static void borrarCliente(String dni) {
        int posCli = -1;
        boolean stop = false;
        boolean tieneAlq = false;
        boolean encontrado = false;
        Cliente c;

        c = getCliente(dni);

        if (c != null) {
            //Comprobamos que el dni se corresponda con un cliente del array  clientes
            for (int i = 0; i < clientes.length && posCli == -1; i++) {
                //localizamos cliente en el array
                if (clientes[i] == c) {
                    posCli = i;
                }
            }
            for (int i = 0; i < alquileres.length && !tieneAlq; i++) {
                //vemos si esta en algun alquiler
                if (alquileres[i] != null && (alquileres[i].getCliente().getDni()).equalsIgnoreCase(dni)) {
                    tieneAlq = true;
                }
            }

            if (!c.getAlta()) {
                //está de baja
                boolean opcion = leerBoolean("\nCliente dado de baja.¿Volver a dar de alta? S/N.");

                if (opcion) {

                    c.setAlta(true);

                    escribirLn("\n        Cliente dado de alta nuevamente.");
                    escribirLn("------------------------------------------------\n");

                    if (tieneAlq) {
                        for (int i = 0; i < alquileres.length; i++) {
                            //seteamos todos los alquileres que tiene registrados 
                            if (alquileres[i] != null && (alquileres[i].getCliente().getDni()).equalsIgnoreCase(dni)) {
                                alquileres[i].getCliente().setAlta(true);

                            }
                        }
                    }
                }

            } else {
                if (tieneAlq == true) {
                    //el cliente tiene algún alquiler abierto y/o cerrado
                    for (int i = 0; i < alquileres.length; i++) {

                        if (alquileres[i] != null && !stop && ((alquileres[i].getCliente().getDni()).equalsIgnoreCase(dni)) && (alquileres[i].getDiasTranscurridos() == 0)) {
                            //tiene alguno abierto
                            stop = true;
                            escribirLn("\n********************ATENCION********************");
                            escribirLn("  El cliente tiene un alquiler activo. Debe cerrar\n"
                                    + "         primero el alquiler asociado.");
                            escribirLn("------------------------------------------------\n");
                        }
                    }
                    for (int i = 0; i < alquileres.length && !stop; i++) {
                        //Si no tiene alquileres abiertos(stop) seteamos los cerrados
                        if (alquileres[i] != null && ((alquileres[i].getCliente().getDni()).equalsIgnoreCase(dni)) && (alquileres[i].getDiasTranscurridos() > 0)) {
                            alquileres[i].getCliente().setAlta(false);

                            if (!encontrado) {
                                //boolean para solo imprimirlo una vez aunque tenga varios alquileres cerrados
                                escribirLn("\n        Cliente dado de baja.");
                                escribirLn("------------------------------------------------\n");
                            }
                            encontrado = true;
                        }
                    }
                } else {
                    c.setAlta(false);
                    escribirLn("\n        Cliente dado de baja.");
                    escribirLn("------------------------------------------------\n");
                }

            }
            clientes[posCli] = c;
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("             Dni/nie no registrado.");
            escribirLn("------------------------------------------------\n");
        }
    }

    public static void listarClientes() {

        int pos = -1;
        boolean vacio = true;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                vacio = false;
                if (clientes[i].getAlta()) {
                    escribirLn(clientes[i].toString());
                } else {
                    //Si existe algún cliente de baja modificamos pos
                    pos = i;
                }

            }
        }

        if (vacio) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("          No existen clientes registrados.");
            escribirLn("------------------------------------------------\n");

        }

        if (pos != -1) {
            boolean opcion = leerBoolean("Existen clientes dados de baja. ¿Quieres listarlos? S/N.");

            if (opcion) {
                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i] != null) {
                        if (!clientes[i].getAlta()) {
                            escribirLn(clientes[i].toString());
                        }
                    }
                }
            }
        }
    }

    public static void anadirVehiculo() {

        // Buscamos posición libre en el array.
        String matricula = "";
        int pos = -1;
        boolean value = false;
        for (int i = 0; i < vehiculos.length && pos == -1; i++) {
            if (vehiculos[i] == null) {
                pos = i;
            }
        }

        boolean encontrado = false;

        if (pos != -1) {

            //Existe espacio vacío. Comenzamos a pedir información al usuario.
            do {
                matricula = (leerCadena("\nIntroduce matrícula del vehículo: ")).toUpperCase();

                if (comprobarMatricula(matricula)) {

                    value = true;
                    for (int i = 0; i < vehiculos.length; i++) {

                        if (vehiculos[i] != null && vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                            // escribirLn(vehiculos[i].getMatricula());
                            encontrado = true;
                            break;
                        }
                    }

                    if (encontrado) {
                        escribirLn("\n********************ATENCION********************");
                        escribirLn("  Matrícula ya registrada. Vehiculo no añadido.");
                        escribirLn("------------------------------------------------\n");
                    } else {

                        //Si la matricula no está registrada, comenzamos a pedir los datos del vehiculo.
                        String marca = (leerCadena("\nIntroduce marca del vehículo: ")).toUpperCase();
                        String modelo = (leerCadena("\nIntroduce modelo del vehículo: ")).toUpperCase();
                        int cilindrada = leerEntero("\nIntroduce cilindrada del vehículo: ");
                        int seleccion = leerEntero(1, 3, "\nSelecciona tipo de vehículo.\n1.Monovolumen.\n2.Furgoneta.\n3.Camión.");

                        switch (seleccion) {

                            case 1:
                                int numPuertas = leerEntero(3, 5, "\nVas a añadir un monovolumen.\n\nIntroduce número de puertas entre 3 y 5:");
                                int enumerado = leerEntero(1, 4, "\nSelecciona tipo de combustible:\n1.Gasolina.\n2.Diesel.\n3.Híbrido.\n4.Eléctrico.");
                                TipoCombustible combustible = TipoCombustible.values()[enumerado - 1];
                                int numPlazas = leerEntero(4, 7, "\nElija el número de plazas entre 4 y 7.");
                                boolean sillaBebe = leerBoolean("\n¿Tiene silla de bebe? S/N");

                                Monovolumen monovolumen = new Monovolumen(matricula, marca, modelo, cilindrada, numPuertas, combustible, numPlazas, sillaBebe);

                                vehiculos[pos] = monovolumen;

                                escribirLn("\n" + monovolumen.toString());
                                escribirLn("\n       Monovolumen añadido correctamente.");
                                escribirLn("------------------------------------------------\n");
                                break;

                            case 2:
                                int pma = leerEntero("\nVas a registrar una furgoneta.\nIntroduce pma: ", 0);
                                int volumen = leerEntero("\nIntroduce volumen: ", 0);
                                boolean refrigerado = leerBoolean("\nVehículo refrigerado S/N");
                                enumerado = leerEntero(1, 3, "\nSelecciona un tamaño:\n1.Grande\n2.Mediano\n3.Pequeño");
                                Tamanio tamanio = Tamanio.values()[enumerado - 1];

                                Furgoneta furgoneta = new Furgoneta(matricula, marca, modelo, cilindrada, pma, volumen, refrigerado, tamanio);

                                vehiculos[pos] = furgoneta;

                                escribirLn("\n" + furgoneta.toString());
                                escribirLn("\n       Furgoneta añadido correctamente.");
                                escribirLn("------------------------------------------------\n");
                                break;

                            case 3:
                                pma = leerEntero("\nVas a registrar un camión.\nIntroduce pma: ", 0);
                                volumen = leerEntero("\nIntroduce volumen: ", 0);
                                int longitud = leerEntero("\nIntroduce longitud: ", 0);
                                int altura = leerEntero("\nIntroduce altura: ", 0);

                                Camion camion = new Camion(matricula, marca, modelo, cilindrada, pma, volumen, longitud, altura);

                                vehiculos[pos] = camion;

                                escribirLn("\n" + camion.toString());
                                escribirLn("\n        Camión añadido correctamente.");
                                escribirLn("------------------------------------------------\n");
                                break;
                        }
                    }
                } else {
                    escribirLn("\n********************ATENCION********************");
                    escribirLn("         Formato de matrícula incorrecto.");
                    escribirLn("          Formato correcto tipo 1234BCD.");
                    escribirLn("------------------------------------------------\n");
                }

            } while (!value);

        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("       Espacio insuficiente en memoria.");
            escribirLn("------------------------------------------------\n");
        }
    }

    public static void llamarBorrarVehiculo() {
        /*Metodo creado para declarar e inicializar matrícula y así poder pasarlo por parámetro
        a borrarVehiculo(String matricula)*/

        esValido = false;
        if (arrayVacio(vehiculos)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("          No existen vehiculos registrados.");
            escribirLn("------------------------------------------------\n");

        } else {
            while (!esValido) {
                String matricula = leerCadena("\nIntroduce matrícula de vehículo.").toUpperCase();

                if (comprobarMatricula(matricula)) {

                    borrarVehiculo(matricula);

                    esValido = true;
                } else {
                    escribirLn("\n********************ATENCION********************");
                    escribirLn("         Formato de matrícula incorrecto.");
                    escribirLn("             Formato tipo: 1234BCD");
                    escribirLn("------------------------------------------------\n");
                }
            }
        }

    }

    public static void borrarVehiculo(String matricula) {

        boolean value = false;
        boolean tieneAlq = false;
        int posVehi = -1;
        Vehiculo v;

        v = getVehiculo(matricula);

        if (v != null) {

            for (int i = 0; i < vehiculos.length && posVehi == -1; i++) {
                //localizamos vehiculo en el array
                if (vehiculos[i] == v) {
                    posVehi = i;
                }
            }
            for (int i = 0; i < alquileres.length && !tieneAlq; i++) {
                //vemos si esta en algun alquiler
                if (alquileres[i] != null && (alquileres[i].getVehiculo().getMatricula()).equalsIgnoreCase(matricula)) {
                    tieneAlq = true;
                }
            }

            if (!v.getAlta()) {

                boolean opcion = leerBoolean("Vehículo dado de baja.¿Volver a dar de alta? S/N.");

                if (opcion) {

                    v.setAlta(true);

                    escribirLn("\n        Vehículo dado de alta nuevamente.");
                    escribirLn("------------------------------------------------\n");

                    if (tieneAlq) {
                        for (int i = 0; i < alquileres.length; i++) {
                            //seteamos todos los alquileres que tiene
                            if (alquileres[i] != null && (alquileres[i].getVehiculo().getMatricula()).equalsIgnoreCase(matricula)) {
                                alquileres[i].getVehiculo().setAlta(true);
                                //el cliente tiene o tuvo algún alquiler
                            }
                        }
                    }
                }
            } else {
                if (tieneAlq == true) {
                    //el cliente tiene algún alquiler abierto y/o cerrado
                    for (int i = 0; i < alquileres.length && !value; i++) {

                        if (alquileres[i] != null && !value && ((alquileres[i].getVehiculo().getMatricula()).equalsIgnoreCase(matricula)) && (alquileres[i].getDiasTranscurridos() == 0)) {
                            value = true;
                            escribirLn("\n********************ATENCION********************");
                            escribirLn("  El vehículo tiene un alquiler activo. Debe cerrar\n"
                                    + "         primero el alquiler asociado.");
                            escribirLn("------------------------------------------------\n");
                        }
                    }
                    for (int i = 0; i < alquileres.length && !value; i++) {
                        //Si no tiene alquileres abiertos seteamos los cerrados
                        if (alquileres[i] != null && ((alquileres[i].getVehiculo().getMatricula()).equalsIgnoreCase(matricula)) && (alquileres[i].getDiasTranscurridos() > 0)) {
                            alquileres[i].getVehiculo().setAlta(false);
                            escribirLn("\n        Vehículo dado de baja.");
                            escribirLn("------------------------------------------------\n");
                        }
                    }
                } else {
                    v.setAlta(false);
                    escribirLn("\n        Vehículo dado de baja.");
                    escribirLn("------------------------------------------------\n");
                }

            }
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("             Matrícula no registrada.");
            escribirLn("------------------------------------------------\n");
        }
        vehiculos[posVehi] = v;

    }

    public static void listarVehiculos() {

        int pos = -1;
        boolean vacio = true;

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {

                vacio = false;
                if (vehiculos[i].getAlta()) {

                    escribirLn(vehiculos[i].toString());
                } else {
                    //Si existe algún vehiculo de baja modificamos pos
                    pos = i;
                }
            }
        }

        if (vacio) {

            escribirLn("\n********************ATENCION********************");
            escribirLn("        No existen vehículos registrados.");
            escribirLn("------------------------------------------------\n");

        }

        if (pos != -1) {
            boolean opcion = leerBoolean("Existen vehiculos dados de baja. ¿Quieres listarlos? S/N.");

            if (opcion) {
                for (int i = 0; i < vehiculos.length; i++) {
                    if (vehiculos[i] != null) {
                        if (!vehiculos[i].getAlta()) {
                            escribirLn(vehiculos[i].toString());
                        }
                    }
                }
            }
        }
    }

    public static void nuevoAlquiler() {

        String dni;
        String matricula;
        boolean mat_ok = false;
        boolean dni_ok = false;

        if (arrayVacio(clientes) && arrayVacio(vehiculos)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("  No existen clientes ni vehículos registrados.");
            escribirLn("------------------------------------------------\n");
        } else if (arrayVacio(clientes)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("          No existen clientes registrados.");
            escribirLn("------------------------------------------------\n");
        } else if (arrayVacio(vehiculos)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("         No existen vehículos registrados.");
            escribirLn("------------------------------------------------\n");
        } else {
            do {
                dni = (leerCadena("\nIntroduce Dni/Nie del cliente sin la letra: ").toUpperCase());

                if (comprobarDni(dni)) {
                    dni_ok = true;
                    dni = procesarDni(dni);

                } else {
                    escribirLn("\n********************ATENCION********************");
                    escribirLn("         Formato de dni/nie incorrecto.");
                    escribirLn("          Formato tipo dni: 12345678");
                    escribirLn("          Formato tipo nie: X1234567");
                    escribirLn("------------------------------------------------\n");
                }

            } while (!dni_ok);

            if (getCliente(dni) != null) {

                Cliente cliente = getCliente(dni);

                if (!cliente.getAlta()) {
                    escribirLn("\n********************ATENCION********************");
                    escribirLn(" Cliente de baja temporal. Modifique su estado.");
                    escribirLn("------------------------------------------------\n");
                } else {
                    while (!mat_ok) {

                        matricula = leerCadena("\nIntroduce matricula del vehículo: ").toUpperCase();

                        if (comprobarMatricula(matricula)) {

                            mat_ok = true;

                            if (getVehiculo(matricula) != null) {

                                Vehiculo vehiculo = getVehiculo(matricula);

                                if (!vehiculo.getAlta()) {
                                    escribirLn("\n********************ATENCION********************");
                                    escribirLn(" Vehículo de baja temporal. Modifique su estado");
                                    escribirLn("                   si procede.");
                                    escribirLn("------------------------------------------------\n");
                                } else {
                                    if (!vehiculo.getDisponible()) {
                                        escribirLn("\n********************ATENCION********************");
                                        escribirLn("         El vehiculo está alquilado.");
                                        escribirLn("------------------------------------------------\n");

                                    } else {
                                        for (int i = 0; i < vehiculos.length; i++) {
                                            if (vehiculos[i] == vehiculo) {
                                                vehiculo.setDisponible(false);
                                                vehiculos[i].setDisponible(false);
                                            }
                                        }
                                        Alquiler alquiler = new Alquiler(cliente, vehiculo);
                                        // Devuelve posición libre en el array.
                                        int pos = -1;
                                        for (int i = 0; i < alquileres.length && pos == -1; i++) {
                                            if (alquileres[i] == null) {
                                                pos = i;
                                            }
                                        }
                                        if (pos != -1) {
                                            alquileres[pos] = alquiler;
                                            System.out.println(alquiler);
                                            escribirLn("Alquiler registrado correctamente");
                                            escribirLn("------------------------------------------------\n");

                                        } else {
                                            escribirLn("\n********************ATENCION********************");
                                            escribirLn(" No existe espacio suficiente para almacenar el alquiler.");
                                            escribirLn("------------------------------------------------\n");
                                        }
                                    }
                                }
                            } else {
                                escribirLn("\n********************ATENCION********************");
                                escribirLn("       El vehículo no está registrado.");
                                escribirLn("------------------------------------------------\n");
                            }
                        } else {
                            escribirLn("\n********************ATENCION********************");
                            escribirLn("       Formato de matrícula incorrecto.");
                            escribirLn("------------------------------------------------\n");
                        }
                    }
                }
            } else {
                escribirLn("\n********************ATENCION********************");
                escribirLn("No hay ningún cliente registrado con ese Dni/Nie.");
                escribirLn("------------------------------------------------\n");
            }
        }
    }

    public static void llamarCerrarAlquiler() {
        /*Metodo creado para buscar cliente y vehículo  a partir de dni y matrícula y así poder pasarlos por parámetro
        a cerrarAlquiler(Cliente c, Vehiculo v)*/

        String dni_ = (leerCadena("Introduce dni/nie del cliente sin letra final.")).toUpperCase();
        if (comprobarDni(dni_)) {
            dni_ = procesarDni(dni_);
            Cliente c = getCliente(dni_);
            if (c != null) {
                if (!c.getAlta()) {
                    escribirLn(" ********************ATENCION********************");
                    escribirLn("Cliente dado de baja. No puede realizar el alquiler.");
                    escribirLn(" ------------------------------------------------\n");

                } else {
                    Vehiculo v = getVehiculo(leerCadena("Introduzca matrícula del vehiculo."));
                    if (v != null) {

                        cerrarAlquiler(c, v);

                    } else {
                        escribirLn("********************ATENCION********************");
                        escribirLn("    No existe  vehículo con esa matrícula.");
                        escribirLn("------------------------------------------------\n");
                    }
                }
            } else {
                escribirLn("********************ATENCION********************");
                escribirLn("      No exite cliente con ese dni/nie.");
                escribirLn("------------------------------------------------\n");
            }

        }

    }

    public static void cerrarAlquiler(Cliente c, Vehiculo v) {

        boolean encontrado = false;

        for (int i = 0; i < alquileres.length; i++) {

            if (alquileres[i] != null) {
                if ((alquileres[i].getCliente() == c) && (alquileres[i].getVehiculo() == v)) {
                    alquileres[i].cerrar();
                    //v.setDisponible(true);

                    encontrado = true;
                    escribirLn("\n         Alquiler cerrado correctamente.");
                    escribirLn("------------------------------------------------\n");
                }
            }
        }
        if (!encontrado) {
            escribirLn("********************ATENCION********************");
            escribirLn("        No existe alquiler con esos datos.");
            escribirLn("------------------------------------------------\n");
        }
    }

    public static void listarAlquileres() {

        int pos = -1;

        if (arrayVacio(alquileres)) {
            escribirLn("\n********************ATENCION********************");
            escribirLn("            No existen alquileres.");
            escribirLn("------------------------------------------------\n");
        }

        for (int i = 0; i < alquileres.length; i++) {
            //recorro alquileres imprimiendo los alquileres abiertos
            if (alquileres[i] != null) {
                if (alquileres[i].getDiasTranscurridos() == 0) {
                    escribirLn(alquileres[i].toString());
                    escribirLn("   --------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if (alquileres[i].getDiasTranscurridos() > 0) {
                    //Miro si hay alquileres cerrados
                    pos = i;
                }
            }
        }

        if (pos != -1) {
            boolean opcion = leerBoolean("Existen alquileres cerrados. ¿Quieres listarlos? S/N.");

            if (opcion) {
                for (int i = 0; i < alquileres.length; i++) {
                    if (alquileres[i] != null && alquileres[i].getDiasTranscurridos() > 0) {
                        //imprimo alquileres cerrados

                        escribirLn(alquileres[i].toString());
                        escribirLn("   --------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }

    public static void guardarDatos() {

        //Archivo para array clientes.
        String ruta = "clientes.txt";

        String datosCliente = "";

        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i] != null) {
                datosCliente += clientes[i].getAlta() + "#" + clientes[i].getEdad() + "#" + clientes[i].getDni() + "#" + clientes[i].getNombreEmpresa() + "#" + clientes[i].getNombre()
                        + "#" + clientes[i].getDireccion() + "#" + clientes[i].getLocalidad()
                        + "#" + clientes[i].getCodigoPostal() + "\n";
            }
        }

        if (escribirArchivo(ruta, datosCliente, true)) {
            escribirLn("\nDatos de clientes guardados correctamente.");
            escribirLn("------------------------------------------------\n");
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("         Error en escritura de datos.");
            escribirLn("------------------------------------------------\n");
        }

        //Archivo para array vehículos
        ruta = "vehiculos.txt";

        String datosVehiculos = "";

        for (int i = 0; i < vehiculos.length; i++) {

            if (vehiculos[i] != null) {

                if (vehiculos[i] instanceof Monovolumen) {

                    Monovolumen aux = (Monovolumen) vehiculos[i];

                    datosVehiculos += "Monovolumen#" + aux.getFechaEntrada() + "#" + aux.getAlta() + "#" + aux.getDisponible() + "#" + aux.getMatricula() + "#" + aux.getMarca() + "#"
                            + aux.getModelo() + "#" + aux.getCilindrada() + "#"
                            + aux.getNumPuertas() + "#" + aux.getCombustible() + "#" + aux.getNumPlazas()
                            + "#" + aux.getSillaBebe() + "\n";
                }

                if (vehiculos[i] instanceof Furgoneta) {

                    Furgoneta aux = (Furgoneta) vehiculos[i];

                    datosVehiculos += "Furgoneta#" + aux.getFechaEntrada() + "#" + aux.getAlta() + "#" + aux.getDisponible() + "#" + aux.getMatricula() + "#" + aux.getMarca() + "#"
                            + aux.getModelo() + "#" + aux.getCilindrada() + "#"
                            + aux.getPma() + "#" + aux.getVolumen() + "#" + aux.getRefrigerado() + "#"
                            + aux.getTamanio() + "\n";
                }
                if (vehiculos[i] instanceof Camion) {

                    Camion aux = (Camion) vehiculos[i];

                    datosVehiculos += "Camion#" + aux.getFechaEntrada() + "#" + aux.getAlta() + "#" + aux.getDisponible() + "#" + aux.getMatricula() + "#" + aux.getMarca() + "#"
                            + aux.getModelo() + "#" + aux.getCilindrada() + "#"
                            + aux.getPma() + "#" + aux.getVolumen() + "#" + aux.getLongitud() + "#"
                            + aux.getAltura() + "\n";
                }
            }

        }

        if (escribirArchivo(ruta, datosVehiculos, true)) {
            escribirLn("\nDatos de vehículos guardados correctamente.");
            escribirLn("------------------------------------------------\n");
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("         Error en escritura de datos.");
            escribirLn("------------------------------------------------\n");
        }

        //Archivo para array alquileres
        ruta = "alquileres.txt";
        String datosAlquileres = "";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (int i = 0; i < alquileres.length; i++) {

            if (alquileres[i] != null) {

                datosAlquileres += alquileres[i].getCliente().getDni() + "#"
                        + alquileres[i].getVehiculo().getMatricula() + "#"
                        + sdf.format(alquileres[i].getFecha().getTime())
                        + "#" + alquileres[i].getDiasTranscurridos() + "\n";

            }

        }
        if (escribirArchivo(ruta, datosAlquileres, true)) {
            escribirLn("\nDatos de alquileres guardados correctamente.");
            escribirLn("------------------------------------------------\n");
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("        Error en escritura de datos.");
            escribirLn("------------------------------------------------\n");
        }

    }

    public static void confirmarGuardarDatos() {
        //Tan solo da la opción de guardar datos si ha habido algún cambio

        if (leerBoolean("¿Desea guardar cambios? S/N.")) {
            guardarDatos();
        } else {
            escribirLn("\n********************ATENCION********************");
            escribirLn("         No se han guardado los datos.");
            escribirLn("------------------------------------------------");
        }

    }

    public static void leerDatos() {

        int tipoVehiculo = 0; //Esta variable la utilizaremos para posteriormente saber qué tipo de vehiculo almacenamos en el array de alquileres

        //CLIENTES
        String clientesTxt = leerArchivo("clientes.txt");

        if (!clientesTxt.isEmpty()) {

            String[] datosClientes = clientesTxt.split("\n");

            for (int i = 0; i < datosClientes.length; i++) {

                String[] datos = datosClientes[i].split("#");

                boolean alta = (datos[0].equalsIgnoreCase("true")) ? true : false;
                int edad = Integer.parseInt(datos[1]);
                clientes[i] = new Cliente(edad, datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                clientes[i].setAlta(alta);
            }
        }

        //VEHICULOS
        String vehiculosTxt = leerArchivo("vehiculos.txt");

        if (!vehiculosTxt.isEmpty()) {

            String[] datosVehiculos = vehiculosTxt.split("\n");

            for (int i = 0; i < datosVehiculos.length; i++) {

                String[] datos = datosVehiculos[i].split("#");

                String fechaEntradaFormato = datos[1];
                String alta = datos[2];
                boolean disponible = (datos[3].equalsIgnoreCase("true")) ? true : false;
                String matricula = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                int cilindrada = Integer.parseInt(datos[7]);

                switch (datos[0]) {

                    case "Furgoneta":
                        tipoVehiculo = 1;

                        int pma = Integer.parseInt(datos[8]);
                        int volumen = Integer.parseInt(datos[9]);

                        boolean refrigerado = (datos[10].equalsIgnoreCase("true")) ? true : false;
                        Tamanio tamanio = null;

                        if (datos[11].equalsIgnoreCase("GRANDE")) {
                            tamanio = Enumerados.Tamanio.GRANDE;
                        } else if (datos[11].equalsIgnoreCase("MEDIANO")) {
                            tamanio = Enumerados.Tamanio.MEDIANO;
                        } else {
                            tamanio = Enumerados.Tamanio.PEQUENIO;
                        }

                        vehiculos[i] = new Furgoneta(matricula, marca, modelo, cilindrada,
                                pma, volumen, refrigerado, tamanio);
                        vehiculos[i].setDisponible(true);
                        break;

                    case "Camion":
                        tipoVehiculo = 2;

                        pma = Integer.parseInt(datos[8]);
                        volumen = Integer.parseInt(datos[9]);

                        int longitud = Integer.parseInt(datos[10]);
                        int altura = Integer.parseInt(datos[11]);

                        vehiculos[i] = new Camion(matricula, marca, modelo, cilindrada,
                                pma, volumen, longitud, altura);
                        vehiculos[i].setDisponible(true);
                        break;

                    case "Monovolumen":

                        tipoVehiculo = 3;

                        int numeroPuertasFami = Integer.parseInt(datos[8]);
                        TipoCombustible combustible = null;

                        if (datos[9].equalsIgnoreCase("GASOLINA")) {
                            combustible = Enumerados.TipoCombustible.GASOLINA;
                        } else if (datos[9].equalsIgnoreCase("DIESEL")) {
                            combustible = Enumerados.TipoCombustible.DIESEL;
                        } else if (datos[9].equalsIgnoreCase("HIBRIDO")) {
                            combustible = Enumerados.TipoCombustible.HIBRIDO;
                        } else {
                            combustible = Enumerados.TipoCombustible.ELECTRICO;
                        }

                        int numPlazas = Integer.parseInt(datos[10]);
                        boolean sillaBebe = (datos[11].equalsIgnoreCase("true")) ? true : false;

                        vehiculos[i] = new Monovolumen(matricula, marca, modelo, cilindrada, numeroPuertasFami,
                                combustible, numPlazas, sillaBebe);
                        vehiculos[i].setDisponible(true);
                        break;
                }

            }

        }
        //ALQUILERES

        String alquileresTxt = leerArchivo("alquileres.txt");

        if (!alquileresTxt.isEmpty()) {

            String[] datosAlquileres = alquileresTxt.split("\n");

            for (int i = 0; i < datosAlquileres.length; i++) {

                String[] datos = datosAlquileres[i].split("#");

                String dni = datos[0];
                String matricula = datos[1];
                String fecha = datos[2];
                int dias = Integer.parseInt(datos[3]);

                Cliente nuevoCliente = getCliente(dni);

                Vehiculo nuevoVehiculo = getVehiculo(matricula);

                String[] datosFecha = fecha.split("[/ :]+");

                int day = Integer.parseInt(datosFecha[0]);
                int month = Integer.parseInt(datosFecha[1]);
                int year = Integer.parseInt(datosFecha[2]);
                int hour = Integer.parseInt(datosFecha[3]);
                int minute = Integer.parseInt(datosFecha[4]);

                Calendar fechaAlquiler = new GregorianCalendar(year, month - 1, day, hour, minute);

                Alquiler nuevoAlquiler = new Alquiler(nuevoCliente, nuevoVehiculo);
                nuevoAlquiler.setFecha(fechaAlquiler);

                alquileres[i] = nuevoAlquiler;

            }

        }
        System.out.println("\nDatos cargados desde los archivos correctamente.");
    }

}
