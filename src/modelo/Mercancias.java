package modelo;

/**
 *
 * @author juans
 */
public abstract class Mercancias extends Vehiculo {

    //positivos
    private int pma;
    private int volumen;

    public Mercancias(String matricula, String marca, String modelo, int cilindrada, int pma, int volumen) {
        super(matricula, marca, modelo, cilindrada);
        this.pma = pma;
        this.volumen = volumen;
    }

    public Mercancias(Vehiculo vehiculo, int pma, int volumen) {
        super(vehiculo.getMatricula(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getCilindrada()); //Corregido
        this.pma = pma;
        this.volumen = volumen;
    }

    public int getPma() {
        return pma;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tPMA: " + pma + "\t\tVolumen: " + volumen;
    }

    @Override
    public String escribirFichero() {
        return super.escribirFichero() + "#" + this.pma + "#" + this.volumen;
    }
}
