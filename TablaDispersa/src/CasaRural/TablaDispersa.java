package CasaRural;
public class TablaDispersa {
    static final int TABLA = 101;
    private int numElementos;
    private double factorCarga;
    private claseCasa[] array;
    
    
    public TablaDispersa(){
    array = new claseCasa[TABLA];
    
    for(int j = 0; j < TABLA ; j++){
        array[j] = null;
        numElementos = 0;
        factorCarga = 0.0;
    }
    }
    
    public int direccion(String clave){
        int i = 0, p;
        long d;
        d = Integer.valueOf(clave);
        p = (int)(d % TABLA);
        
        while (array[p]!= null && !array[p].elCodigo().equals(clave)){
        i++;
        p = p + i*i;
        p = p % TABLA; 
        }
        return p;
    }
    
    public void insertar(claseCasa r){
        int posicion;
        posicion = direccion(r.elCodigo());
        array[posicion] = r;
        numElementos++;
        factorCarga = (double)(numElementos)/TABLA;
        if(factorCarga > 0.5){
            System.out.println("Factor de carga supera el 50%." + "Aumente el tamaño porfavor!");
        }
    }
    
    public claseCasa buscar(String clave){
        claseCasa pr;
        int posicion;
        posicion = direccion(clave);
        pr = array[posicion];
        if (pr != null){
            if(!pr.esAlta){
                pr = null;
            }
        }
        return pr;
    }
    
    public void eliminar(String clave){
        int posicion;
        posicion = direccion(clave);
        if(array[posicion] != null){
            array[posicion].esAlta = false;
        }
    }
}
