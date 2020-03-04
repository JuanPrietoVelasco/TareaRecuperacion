/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online6;

import online6.Enumerados.CajaCambios;

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

    public boolean isDescapotable() {
        return descapotable;
    }

    @Override
    public String toString() {
        
        String descapotable = (this.descapotable) ? "SI" : "NO"; 
        
        return super.toString() + " Tipo de cambio: " + cambio + " Descapotable: " + descapotable; 
    }
   
}
