/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online6;

import online6.Enumerados.Combustible;

/**
 *
 * @author juans
 */
public final class Familiar extends Turismo{
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

    public boolean getSillaBebe() {
   
        return sillaBebe;
    }
    
    @Override
    public Combustible getCombustible(){
        return super.getCombustible();
    }
    
    public int getNumeroPuertas(){
        return super.getNumPuertas();
    }
    
    public void setSillaBebe(boolean sillaBebe){
        this.sillaBebe = sillaBebe;
    }

    @Override
    public String toString() {
        
        //String sillaBebe = (this.sillaBebe) ? "SI" : "NO";
        String sillaBebe;
        if (this.sillaBebe){
            sillaBebe="SI";
        }else
            sillaBebe="NO";
        
        return super.toString() + "\t\tNúmero de plazas: " + numPlazas + "\t\tSilla de bebe: " + sillaBebe; 
    }
    
    
    
    
    
}
