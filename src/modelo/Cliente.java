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
public class Cliente {

    private String dni;
    private String nombreEmpresa;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;
    private int edad;
    private boolean alta;

    public Cliente(int edad, String dni, String nombreEmpresa, String nombre, String direccion, String localidad, String codigo) {
        this.alta = true;
        this.dni = dni;
        this.nombreEmpresa = nombreEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigo;
        this.edad = edad;
    }

    public Cliente(Cliente cliente) {
        this.alta = cliente.alta;
        this.dni = cliente.dni;
        this.nombreEmpresa = cliente.nombreEmpresa;
        this.nombre = cliente.nombre;
        this.direccion = cliente.direccion;
        this.localidad = cliente.localidad;
        this.codigoPostal = cliente.codigoPostal;
        this.edad = cliente.edad;
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public int getEdad() {
        return edad;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        String alta = (this.alta) ? "SI" : "NO";

        return "\nAlta: " + alta + "\t\tEdad: " + this.edad + "\t\tDni/Nie: " + this.dni + "\t\tEmpresa: " + this.nombreEmpresa + "\t\tNombre: " + this.nombre 
                + "\t\tDirección: " + this.direccion + "\nLocalidad: " + this.localidad + "\t\tCódigo postal: " + this.codigoPostal;
    }
    
     public String escribirFichero(){
        
        return this.alta + "#" + this.edad + "#" + this.dni + "#" + this.nombreEmpresa + "#" + this.nombre
                        + "#" + this.direccion + "#" + this.localidad + "#" + this.codigoPostal + "\n";
    }
}


