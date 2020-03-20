/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online7;

import online7.Enumerados.*;


/**
 *
 * @author juans
 */
public final class Deportivo extends Turismo {
    
    private CajaCambios cambio;
    private boolean descapotable;

    public Deportivo(String matricula, String marca, String modelo, int cilindrada,
        int numPuertas, Enumerados.Combustible combustible, CajaCambios cambio,boolean descapotable) {
        
        super(matricula, marca, modelo, cilindrada, numPuertas, combustible);
        this.cambio=cambio;
        this.descapotable=descapotable;
        
        
    }

    public CajaCambios getCambio() {
        return cambio;
    }

    public boolean getDescapotable() {
        return descapotable;
    }
    
    
    @Override
    public Combustible getCombustible(){
        return super.getCombustible();
    }
    
   
    public int getNumeroPuertas(){
        return super.getNumPuertas();
    }
    
   
    @Override
    public String toString() {
        
        String descapotable = (this.descapotable) ? "SI" : "NO"; 
        
        return super.toString() + "\t\tTipo de cambio: " + cambio + "\t\tDescapotable: " + descapotable; 
    }
   
}
