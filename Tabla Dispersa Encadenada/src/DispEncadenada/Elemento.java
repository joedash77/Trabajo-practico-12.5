
package DispEncadenada;

 public class Elemento{
    private Socios socio;
    Elemento sgte;
    
    public Elemento(Socios e){
        socio = e;
        sgte = null;
    }

    public Socios getSocio(){
        return socio;
    }
}
