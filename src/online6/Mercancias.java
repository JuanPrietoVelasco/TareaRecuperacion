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
public abstract class Mercancias extends Vehiculo{
    private int pma;
    private int volumen;
    public Mercancias(int pma, int volumen,String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.pma=pma;
        this.volumen=volumen;   
    }
    
    public Mercancias(int pma, int volumen, Vehiculo vehiculo){
        super(vehiculo.getMatricula(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getCilindrada()); //Corregido
        this.pma=pma;
        this.volumen=volumen;
    }

    public int getPma() {
        return pma;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tPMA: " + pma + "\t\tVolumen: " + volumen; 
    }
    
}
