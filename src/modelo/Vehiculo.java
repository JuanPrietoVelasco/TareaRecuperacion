package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author juans
 */
public abstract class Vehiculo {

    private boolean alta;
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;
    private Calendar fechaAdquisicion;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {

        this.fechaAdquisicion = Calendar.getInstance();
        this.alta = true;
        this.disponible = true;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public Vehiculo(Vehiculo vehiculo) {

        this.fechaAdquisicion = vehiculo.fechaAdquisicion;
        this.alta = vehiculo.alta;
        this.disponible = vehiculo.disponible;
        this.matricula = vehiculo.matricula;
        this.marca = vehiculo.marca;
        this.modelo = vehiculo.modelo;
        this.cilindrada = vehiculo.cilindrada;
    }

    public Calendar getFechaEntrada() {
        return fechaAdquisicion;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;

        if (!this.alta) {
            setDisponible(false);
        } else {
            setDisponible(true);
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    @Override
    public String toString() {

        String alta_ = (this.alta) ? "SI" : "NO";
        String disponible_ = (this.disponible) ? "SI" : "NO";

        return "\nFecha adquisición: " + formato.format(fechaAdquisicion.getTime()) + "\t\tAlta: " + alta_ + "\t\tDisponible: " + disponible_ + "\t\tMatrícula: " + this.matricula
                + "\t\tMarca: " + this.marca + "\t\tModelo: " + this.modelo + "\nCilindrada: " + this.cilindrada;
    }

    public String escribirFichero() {
        return this.fechaAdquisicion + "#" + this.alta + "#" + this.disponible
                + "#" + this.matricula + "#" + this.marca + "#" + this.modelo + "#" + this.cilindrada;
    }
}
