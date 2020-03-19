package online6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * * @author juans
 */
public class Alquiler {

    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final double PRECIO_DIA = 12.5;
    private final int MILISEGUNDOS_DIA = 24 * 60 * 60 * 1000;
    private Calendar fecha;//Calendar.getInstance();
    private int dias;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Alquiler(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = Calendar.getInstance();
        this.dias = 0;
        vehiculo.setDisponible(false);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setFecha(Calendar fecha){
        this.fecha = fecha;
    }
    
    public void setDias(int dias){
        this.dias = dias;
    }
    

    /*Crea un método cerrar que cerrará el alquiler, para lo que, partiendo de la
    fecha actual y la fecha en que se realizó el alquiler, calcule el número de
    días (si se devuelve el mismo día contará como 1 día), y ponga el turismo como disponible.*/
    public void cerrar(Vehiculo[] vehiculos) {
        this.dias = diferenciaDias(Calendar.getInstance());

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                if (vehiculos[i].equals(vehiculo)) {
                    vehiculos[i].setDisponible(true);
                }
            }

        }
        this.vehiculo.setDisponible(true);

    }

    public double precioAlquiler() {
        return dias * PRECIO_DIA;
    }

    /*private long diferenciaDias(Date fecha){
        return ((fecha.getTime()-this.fecha.getTime())/1000/60/60/24);
    }*/
    public int diferenciaDias(Calendar fechaFin) {

        long tiempo1, tiempo2, diferencia_dias;

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
        return "\nCliente: " + cliente.toString() + "\n" + "Vehículo: \n" + vehiculo.toString();
    }

}
