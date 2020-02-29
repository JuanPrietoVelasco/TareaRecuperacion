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
public abstract class Turismo extends Vehiculo{
    
    private int numPuertas;
    private Combustible combustible;
    
    public Turismo(String matricula, String marca, String modelo, int cilindrada,int numPuertas, Combustible combustible) {
        super(matricula, marca, modelo, cilindrada);
        this.numPuertas=numPuertas;
        this.combustible=combustible;           
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + " Número de puertas: " + this.numPuertas + " Combustible: " + this.combustible; 
    }
}
