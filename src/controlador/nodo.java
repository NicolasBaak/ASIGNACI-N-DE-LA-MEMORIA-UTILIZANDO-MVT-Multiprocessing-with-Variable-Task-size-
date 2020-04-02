package controlador;

public class nodo {
    public controlador dato; 
    public nodo siguiente;
    public nodo anterior;
    
    public nodo(controlador dato) {
        this.dato = dato;
        this.siguiente=null;
        this.anterior=null;
    } 

    public controlador getDato() {
        return dato;
    }

    public void setDato(controlador dato) {
        this.dato = dato;
    }
    
    public nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(nodo anterior) {
        this.anterior = anterior;
    }  
}
