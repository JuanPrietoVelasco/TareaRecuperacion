package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import utiles.ES.*;
import modelo.*;
import utiles.ES;
import static utiles.ES.*;
//import static aplicacion.AlquilerVehiculos.getVehiculo;

public class Alquiler {

    private final SimpleDateFormat FECHA_FORMATO = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final double PRECIO_JORNADA = 14.25;
    private final int MILISEGUNDOS_DIA = 24 * 60 * 60 * 1000;
    private static Calendar fecha;
    private int diasTranscurridos;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Alquiler(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = Calendar.getInstance();
        this.diasTranscurridos = 0;
        vehiculo.setDisponible(false);
    }

    public void cerrar() {

        /*Crea un método cerrar que cerrará el alquiler, para lo que, partiendo de la
    fecha actual y la fecha en que se realizó el alquiler, calcule el número de
    días (si se devuelve el mismo día contará como 1 día), y ponga el turismo como disponible.*/
        this.diasTranscurridos = calculoDiasTranscurrridos(Calendar.getInstance());
        this.vehiculo.setDisponible(true);

        String diasAlq = (diasTranscurridos == 1) ? " día." : " días.";
        escribirLn("\n  El precio del alquiler es " + precioAlquiler() + "€ por " + diasTranscurridos + diasAlq);

    }

    public double precioAlquiler() {

        double precio = this.PRECIO_JORNADA * this.diasTranscurridos + vehiculo.getCilindrada() / 100;

        return precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
    public void setFecha(Calendar fecha){
        this.fecha = fecha;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDiasTranscurridos() {
        return diasTranscurridos;
    }

    private int calculoDiasTranscurrridos(Calendar fechaFin) {

        long  tiempo1, tiempo2, diferencia_dias;

        tiempo1 = fechaFin.getTimeInMillis();
        tiempo2 = this.fecha.getTimeInMillis();

        diferencia_dias = (tiempo1 - tiempo2) / this.MILISEGUNDOS_DIA;

        //Se realiza la comprobación para saber si la diferencia es inferior a un día, entonces también cuenta
        //como un día de alquier.
        if (diferencia_dias < 1) {
            diferencia_dias = 1;
        }

        return (int) diferencia_dias;

    }   

    @Override
    public String toString() {
        
        String estado = (diasTranscurridos == 0) ? "ABIERTO." : "CERRADO.";
        String diasAlq = (diasTranscurridos == 1) ? " día." : " días.";
        
        return "\nCliente: " + cliente.toString() + "\n" + "\nVehículo: \n" + vehiculo.toString() 
                + "\n\nInicio Alquiler: " + FECHA_FORMATO.format(fecha.getTime()) + "\t\tDuración alquiler: "
                + this.diasTranscurridos + diasAlq + "\t\tEstado de alquiler: " + estado;
    }

}
