/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop11;

/**
 *
 * @author Piky
 */
public class Alumno {
    
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public int numCuenta;
    public int edad;

    /**
     * Constructor vacio
     */
    public Alumno() {
    }

    /**
     * 
     * @param nombre es el nombre de pila del alumno
     * @param apellidoPaterno es el primer apellido del alumno
     * @param apellidoMaterno es el segundo apellido del alumno
     * @param numCuenta es el numero de cuenta del alumno
     * @param edad es la edad del alumno
     */
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int numCuenta, int edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numCuenta = numCuenta;
        this.edad = edad;
    }

    /**
     * 
     * @return regresa la impresion de los atributos
     */
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", numCuenta=" + numCuenta + ", edad=" + edad + '}';
    }
    
    
}
