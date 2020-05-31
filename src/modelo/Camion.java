package modelo;

/**
 *
 * @author juans
 */
public final class Camion extends Mercancias {

    private int longitud;
    private int altura;

    public Camion(String matricula, String marca, String modelo, int cilindrada, int pma, int volumen, int longitud, int altura) {
        super(matricula, marca, modelo, cilindrada, pma, volumen);
        this.longitud = longitud;
        this.altura = altura;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Tipo: CAMIÓN" + super.toString() + "\t\tLongitud: " + this.longitud + "\t\tAltura: " + this.altura; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String escribirFichero() {
        return super.escribirFichero() + "#" + this.longitud + "#" + this.altura + "\n";
    }

}
