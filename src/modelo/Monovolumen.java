package modelo;

import modelo.Enumerados.TipoCombustible;

/**
 *
 * @author juans
 */
public final class Monovolumen extends Turismo {

    private int numeroPlazas;
    private boolean sillaBebe;

    public Monovolumen(String matricula, String marca, String modelo, int cilindrada,
            int numPuertas, TipoCombustible combustible, int numeroPlazas, boolean sillaBebe) {
        super(matricula, marca, modelo, cilindrada, numPuertas, combustible);
        this.numeroPlazas = numeroPlazas;
        this.sillaBebe = sillaBebe;
    }

    public int getNumPuertas() {
        return numeroPuertas;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setSillaBebe(boolean sillaBebe) {
        this.sillaBebe = sillaBebe;
    }

    public boolean getSillaBebe() {

        return sillaBebe;
    }

    public int getNumPlazas() {
        return numeroPlazas;
    }

    @Override
    public String toString() {

        //String sillaBebe = (this.sillaBebe) ? "SI" : "NO";
        String sillaBebe;
        if (this.sillaBebe) {
            sillaBebe = "SI";
        } else {
            sillaBebe = "NO";
        }

        return "Tipo: MONOVOLUMEN" + super.toString() + "\t\tNúmero de plazas: " + numeroPlazas + "\t\tSilla de bebe: " + sillaBebe;
    }

    @Override
    public String escribirFichero() {
        return super.escribirFichero() + "#" + this.numeroPlazas + "#" + this.sillaBebe + "\n"; //To change body of generated methods, choose Tools | Templates.
    }

}
