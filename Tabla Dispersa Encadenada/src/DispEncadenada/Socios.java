package DispEncadenada;

import java.util.Scanner;
import java.time.LocalDate;

public class Socios {
    int codigo;
    private String nombre;
    private int edad;
    LocalDate fecha;
    Scanner scan = new Scanner(System.in);
    
    public Socios(int code, String name, int edad, LocalDate date){
        codigo = code;
        nombre = name;
        this.edad = edad;
        fecha = date;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void mostrar(){
        System.out.println("Nombre del socio: " + nombre);
        System.out.println("Edad del socio: " + edad);
        System.out.println("Fecha de ingreso: " + fecha);
    }
}