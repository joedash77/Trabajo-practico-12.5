package DispEncadenada;

public class TablaEnlazada{
    static final double R = 0.618;
    static final int M = 97;
    private int numElementos;
    private Elemento [] tabla;
    
    static int dispersion(long clave){
        double t;
        int v;
        t = R*clave - Math.floor(R * clave);
        v = (int) (M * t);
        return v;
    }
    
    public TablaEnlazada(){
        tabla = new Elemento[M];
        for(int i = 0; i<M; i++){
            tabla[i] = null;
            numElementos = 0;
        }
    }
    
    public void insertar(Socios socio){
        int posicion;
        Elemento nuevo;
        
        posicion = dispersion(socio.getCodigo());
        nuevo = new Elemento(socio);
        nuevo.sgte = tabla[posicion];
        tabla[posicion] = nuevo;
        numElementos++;
    }
    
    public void eliminar(int codigo){
        int posicion;
        posicion = dispersion(codigo);
        
        if(tabla[posicion] !=null){
            Elemento anterior, actual;
            
            anterior = null;
            actual = tabla[posicion];
            while(actual.sgte != null && actual.getSocio().getCodigo() != codigo){
                anterior = actual;
                actual = actual.sgte;
            }
            
            if(actual.getSocio().getCodigo() != codigo){
                System.out.println("No se ha encontrado en la tabla el codigo: " + codigo);
            }
            else if(actual.getSocio() != null)
            {
                if(anterior == null){
                    tabla[posicion] = actual.sgte;
                }else{
                    anterior.sgte = actual.sgte;
                }   
            actual = null;
            numElementos--;
            }
        }
    }
    
    public Elemento buscar(int codigo){
        Elemento actual = null;        
        int posicion;
        posicion = dispersion(codigo);
        
        if(tabla[posicion] != null){
            actual = tabla[posicion];
            while(actual.sgte != null && actual.getSocio().getCodigo() != codigo){
                actual = actual.sgte;
            }
            
            if(actual.getSocio().getCodigo() != codigo){
                actual = null;
            }
        }
        return actual;
    }
}