package modelo;

import modelo.Enumerados.TipoCombustible;

/**
 *
 * @author juans
 */
public abstract class Turismo extends Vehiculo {

    protected int numeroPuertas;
    protected TipoCombustible combustible;

    public Turismo(String matricula, String marca, String modelo, int cilindrada, int numeroPuertas, TipoCombustible combustible) {
        super(matricula, marca, modelo, cilindrada);
        this.numeroPuertas = numeroPuertas;
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tNúmero de puertas: " + this.numeroPuertas + "\t\tCombustible: " + this.combustible;
    }

    @Override
    public String escribirFichero() {
        return super.escribirFichero() + "#" + this.numeroPuertas + "#" + this.combustible;
    }
}
