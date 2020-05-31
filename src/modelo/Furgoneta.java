
package modelo;

import modelo.Enumerados.Tamanio;

/**
 *
 * @author juans
 */
public class Furgoneta extends Mercancias {
    private boolean refrigerado;
    private Tamanio tamanio;
    
    public Furgoneta(String matricula, String marca, String modelo, int cilindrada, int pma, int volumen, boolean refrigerado, Tamanio tamanio) {
        super(matricula, marca, modelo, cilindrada, pma, volumen);
        this.refrigerado = refrigerado;
        this.tamanio = tamanio;
    }

    public boolean getRefrigerado() {
        return refrigerado;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return "Tipo: FURGONETA" + super.toString() + "\t\tRefrigerado: " + refrigerado + "\t\tTamaño: " + tamanio;
    }
    
    @Override
    public String escribirFichero() {
        return super.escribirFichero() + "#" +this.refrigerado + "#" + this.tamanio + "\n";
    }
    
}
