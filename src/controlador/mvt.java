/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.listaDoble;


public class mvt {
    
    listaDoble listaDoble = new listaDoble(); 
    listaDoble AuxlistaDoble = new listaDoble();
    
    listaDoble tal = new listaDoble();
    listaDoble tp = new listaDoble();
    
    
    public mvt(listaDoble lisDoble) {
    this.listaDoble = lisDoble;
    }
     
    public void mvt(){
    
        //Inserto el bloque del Sistema operativo
        modelo.controlador so = new modelo.controlador( 1, 10, 54, 'D');
        System.out.println(so.getNumero() + " "+ so.getLocalidad()+" "+ so.getTama()+" "+ so.getEstado());
        tal.insertarFinal(so);
          
        tal.imprimir();
    
    }

    public listaDoble getTal() {
        return tal;
    }

    public listaDoble getTp() {
        return tp;
    }

    public void setTal(listaDoble tal) {
        this.tal = tal;
    }

    public void setTp(listaDoble tp) {
        this.tp = tp;
    }
    
}
