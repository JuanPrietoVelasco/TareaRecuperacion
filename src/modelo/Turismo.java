/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Enumerados.TipoCombustible;

/**
 *
 * @author juans
 */
public abstract class Turismo extends Vehiculo{
    
    protected int numeroPuertas;
    protected TipoCombustible combustible;
    
    public Turismo(String matricula, String marca, String modelo, int cilindrada,int numeroPuertas, TipoCombustible combustible) {
        super(matricula, marca, modelo, cilindrada);
        this.numeroPuertas=numeroPuertas;
        this.combustible=combustible;           
    }

    public int getNumPuertas() {
        return numeroPuertas;
    }

    public void setNumPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + "\t\tNúmero de puertas: " + this.numeroPuertas + "\t\tCombustible: " + this.combustible; 
    }
}
