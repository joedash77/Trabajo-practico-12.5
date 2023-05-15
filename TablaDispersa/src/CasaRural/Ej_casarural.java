package CasaRural;

import java.util.Scanner;

public class Ej_casarural {
    public static void main(String[] args) {
        claseCasa casa;
        TablaDispersa tabla;
        int op;
        Scanner scan = new Scanner(System.in);
        
        casa = new claseCasa();
        tabla = new TablaDispersa();
        
        tabla.direccion(casa.elCodigo());
        tabla.insertar(casa);
        
        System.out.println("Información: ");
        System.out.println("-------------");
        tabla.buscar(casa.elCodigo()).muestra();
        System.out.println("-------------");
        
        System.out.println("Desea eliminar esta informacion? (Si: 1 || No: 2");
        op = scan.nextInt();
        
        if(op == 1){
        System.out.println("Da de baja los datos de la casa en el mismo id");
        tabla.eliminar(casa.elCodigo());
        }
        
        if(tabla.buscar(casa.elCodigo()) == null){
            System.out.println("Informacion borrada de manera exitosa!");
        }
    }
    
}
