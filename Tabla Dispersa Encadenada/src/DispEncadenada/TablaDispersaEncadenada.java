package DispEncadenada;

import java.time.LocalDate;
import java.util.Scanner;

public class TablaDispersaEncadenada {
    public static void main(String[] args) {
        Socios socio;
        int codigo, edad;
        String nombre;
        LocalDate fecha;
        TablaEnlazada tabla;
        tabla = new TablaEnlazada();
        
        int op;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\n Codigo (10 caracteres): "); //INGRESO DE DATOS
        codigo = scan.nextInt();
        scan.nextLine();
        System.out.print("\n Inserte nombre: ");
        nombre = scan.nextLine();
        System.out.print("\n Inserte edad: ");
        edad = scan.nextInt();
        fecha = LocalDate.now();
        scan.nextLine();
        
        socio = new Socios(codigo, nombre, edad, fecha); //LLAMAR AL CONSTRUCTOR
        tabla.insertar(socio);
        
        System.out.println("Información: "); //MOSTRAR INFORMACION
        System.out.println("-------------");
        tabla.buscar(codigo).getSocio().mostrar();
        System.out.println("-------------");
        
        System.out.println("Desea eliminar esta informacion? (Si: 1 || No: 2");
        op = scan.nextInt(); //VERIFICAR QUE ELIMINAR FUNCIONE
        
        if(op == 1){//METODO ELIMINAR
        System.out.println("Da de baja los datos de la casa en el mismo id");
        tabla.eliminar(socio.getCodigo());
        }
        
        if(tabla.buscar(codigo) == null){//PROBANDO METODO BUSCAR DENUEVO
            System.out.println("Informacion borrada de manera exitosa!");
        }
    }   
}
