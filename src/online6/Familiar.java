/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online6;

/**
 *
 * @author juans
 */
public class Familiar extends Turismo{
    private int numPlazas;
    private boolean sillaBebe;
    
    public Familiar(String matricula, String marca, String modelo, int cilindrada,
            int numPuertas, Enumerados.Combustible combustible, int numPlazas, boolean sillaBebe) {
        super(matricula, marca, modelo, cilindrada, numPuertas, combustible);
        this.numPlazas=numPlazas;
        this.sillaBebe=sillaBebe;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public boolean isSillaBebe() {
        return sillaBebe;
    }

    @Override
    public String toString() {
        return super.toString() + " Número de plazas: " + numPlazas + " Silla de bebe: " + sillaBebe; 
    }
    
    
    
    
    
}
