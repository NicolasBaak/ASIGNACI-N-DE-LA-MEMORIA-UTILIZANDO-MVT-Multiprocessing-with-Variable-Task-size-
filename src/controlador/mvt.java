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
    
     char finalizado = 'f';
     
    public mvt(listaDoble ListaDoble) {
    this.listaDoble = ListaDoble;
    }
     
    public void mvt(int tiempo){
    
        listaDoble auxlistaDoble = this.listaDoble;
        //listaDoble.imprimirTablaPrincipal();
   
        int aux1 = 1;
        int aux2 =1;
        int aux1_ant = 1;
        int i = 0;
        //Inserto el bloque del Sistema operativo
        modelo.controlador so = new modelo.controlador( 1, 10, 54, 'D');
       // System.out.println(so.getNumero() + " "+ so.getLocalidad()+" "+ so.getTama()+" "+ so.getEstado());
        tal.insertarFinal(so);
        
   
        
            System.out.println(auxlistaDoble.get(i).dato.getNombreProceso() + " \t" +auxlistaDoble.get(i).dato.getTama()+ " \t"+ auxlistaDoble.get(i).dato.getTiempoLlegada() + " \t"+auxlistaDoble.get(i).dato.getDuracion()+" \n\n");
            if(tiempo >= auxlistaDoble.get(i).dato.getTiempoLlegada()){
            
            while( tal.get(i).dato.getTama() < auxlistaDoble.get(i).dato.getTama()){
            
             tal.get(i).dato = tal.get(i).siguiente.dato; 
             avanzaTiempo(tp, tal, i, aux1, tiempo);
             if(tal.get(i).dato == null){
             tal.get(i).dato = tal.get(0).dato; 
             }
             
            }
            
            
            if( aux1 == aux1_ant){
            
                tal.get(i).dato.setLocalidad(tal.get(i).anterior.dato.getLocalidad() + auxlistaDoble.get(i).dato.getTama());
                tal.get(i).dato.setTama(tal.get(i).anterior.dato.getTama() - auxlistaDoble.get(i).dato.getTama());
                tal.get(i).dato.setEstado('D');
                  
               modelo.controlador a = new modelo.controlador( aux2, tal.get(i).dato.getLocalidad()- auxlistaDoble.get(i).dato.getTama(),  auxlistaDoble.get(i).dato.getTama(), 'A', aux2);

               tp.insertarFinal(a);
            }
            else{
            
                modelo.controlador a = new modelo.controlador( aux1, tal.get(i).dato.getLocalidad()+ auxlistaDoble.get(i).dato.getTama(),  auxlistaDoble.get(i).dato.getTama(), 'A', aux2);

            }
                avanzaTiempo(tp, tal, i, aux1, tiempo);
                
            aux1_ant = aux1;
            aux2++;
            
            }
           // auxlistaDoble.get(i).dato = auxlistaDoble.get(i).siguiente.dato;
            
            i++;
     
        
    }

    public void avanzaTiempo(listaDoble tp, listaDoble tal, int i, int valor, int tiempo){
   
        listaDoble aux = tp;
        listaDoble aux2 = tal;
        while(aux.get(i).dato != null){
        
           aux.get(i).dato.setDuracion(aux.get(i).dato.getDuracion() - 1); 
           
           if(aux.get(i).dato.getDuracion() == 0){
               if(aux.get(i).dato.getEstado() == 'A'){
               aux.get(i).dato.setEstado('D');
               
//               aux2.get(i).dato.setLocalidad( aux.get(i).dato.getLocalidad());
//               aux2.get(i).dato.setNumero(valor +1);
//               aux2.get(i).dato.setTama(aux.get(i).dato.getTama());
//               aux2.get(i).dato.setEstado('D');
                modelo.controlador a = new modelo.controlador(aux.get(i).dato.getLocalidad(),valor +1, aux.get(i).dato.getTama(),'D');
                tal.insertarFinal(a);
               tiempo++;     
               }
           
           }
           i++;
           aux.get(i).dato = aux.get(i).siguiente.dato;
        }
    
    }
    
    public void finish(char finalizar, listaDoble tp){
        listaDoble aux = tp;
        finalizar = 't';
      for(int i = 0; i < tp.size(); i++){
            if(aux.get(i).dato.getEstado() == 'A')
                    finalizar = 'f';
            //aux.get(i).dato = aux.get(i).siguiente.dato;
        }
    
    }

    public char getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(char finalizado) {
        this.finalizado = finalizado;
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
