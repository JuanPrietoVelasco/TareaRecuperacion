/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author juans
 */
public class Enumerados {
    
    public enum TipoCombustible{
        GASOLINA, DIESEL, HIBRIDO, ELECTRICO;
        
        TipoCombustible(){}
    }
    
    public enum CajaCambios{
        AUTOMATICO, MANUAL;
        
        CajaCambios(){}
    }
    
    public enum Tamanio{
        
        GRANDE, MEDIANO, PEQUENIO;
        
        Tamanio(){}
    }
}
