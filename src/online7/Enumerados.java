/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online7;

/**
 *
 * @author juans
 */
public class Enumerados {
    
    public enum Combustible{
        GASOLINA, DIESEL, HIBRIDO, ELECTRICO;
        
        Combustible(){}
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
