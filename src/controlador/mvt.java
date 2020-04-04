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
     
    public void mvt(int tiempo, int aux1, int aux2, int aux1_ant, int i){
            
            listaDoble auxtal = tal;
            listaDoble auxtp = tp;
            
            listaDoble auxlistaDoble = this.listaDoble;
            System.out.println(" Ingresando valor de auxlistadoble: i ="+i);
            System.out.println(auxlistaDoble.get(i).dato.getNombreProceso() + " \t" +auxlistaDoble.get(i).dato.getTama()+ " \t"+ auxlistaDoble.get(i).dato.getTiempoLlegada() + " \t"+auxlistaDoble.get(i).dato.getDuracion()+" \n\n");
            System.out.println("tiempo: "+tiempo+" / listaDoble tiempoLlegada: "+auxlistaDoble.get(i).dato.getTiempoLlegada());
            if(tiempo >= auxlistaDoble.get(i).dato.getTiempoLlegada()){
            
            while( auxtal.get(aux1).dato.getTama() < auxlistaDoble.get(i).dato.getTama()){                
            aux1++;
            //Checar aux1 en avanzarTiempo
            avanzaTiempo(tp, tal, i, aux2, aux1, tiempo);
                if(auxtal.get(i).dato == null){
                auxtal = tal;
                System.out.println("Se cabaron los elementos de auxtal\n");
                //auxtal.imprimirTal();
                aux1 = 0;
                }             
            }
            
            if( aux1 == aux1_ant){
                System.out.println("Ingresado una fila en la tabla tal: aux1 =" + aux1);
                
                int a = auxtal.get(aux1).dato.getLocalidad() + auxlistaDoble.get(i).dato.getTama();
                System.out.println(" Localidad = " + a);
                
                auxtal.get(aux1).dato.setLocalidad(a);
                
                auxtal.get(aux1).dato.setTama(auxtal.get(aux1).dato.getTama() - auxlistaDoble.get(i).dato.getTama());
                auxtal.get(aux1).dato.setEstado('D');
                
                System.out.println(auxtal.get(aux1).dato.getNumero() + " \t" +auxtal.get(aux1).dato.getLocalidad()+ " \t"+ auxtal.get(i).dato.getTama() + " \t"+auxtal.get(aux1).dato.getEstado()+" \n\n");
            }
               
           
            int numero = aux2;
            int localidad = auxtal.get(aux1).dato.getLocalidad() - auxlistaDoble.get(i).dato.getTama();
            int tamaño = auxlistaDoble.get(i).dato.getTama();
            char estado = 'A';
            int proceso = aux2;
            int duracion = auxlistaDoble.get(i).dato.getDuracion();
            
            modelo.controlador a = new modelo.controlador(numero, localidad, tamaño, estado, proceso, duracion);
            tp.insertarFinal(a);
            
          
              
               System.out.println("Ingresado una fila en la tabla tp: aux2 ="+aux2);
               System.out.println(tp.get(aux2).dato.getNumero() + " \t" +tp.get(aux2).dato.getLocalidad()+ " \t"+ tp.get(aux2).dato.getTama() + " \t"+ tp.get(aux2).dato.getEstado()+" \t"+ tp.get(aux2).dato.getProceso()+" \t"+ tp.get(aux2).dato.getDuracion()+"\n\n");
            
               
              
                avanzaTiempo(tp, tal, i, aux2, aux1, tiempo);
                
            //aux1_ant = aux1;
            //aux2++;
            
            }
           // auxlistaDoble.get(i).dato = auxlistaDoble.get(i).siguiente.dato;
            
            i++;
     
   
    }

    public void avanzaTiempo(listaDoble tp, listaDoble tal, int i, int aux2, int aux1, int tiempo){
        int x = 0;
        listaDoble auxtp = tp;
        listaDoble auxtal = tal;
        while(auxtp.get(x).dato != null){
        
           auxtp.get(aux2).dato.setDuracion(auxtp.get(aux2).dato.getDuracion() - 1); 
           
           if(auxtp.get(aux2).dato.getDuracion() <= 0){
               if(auxtp.get(aux2).dato.getEstado() == 'A'){
               auxtp.get(aux2).dato.setEstado('D');
               
//               aux2.get(i).dato.setLocalidad( aux.get(i).dato.getLocalidad());
//               aux2.get(i).dato.setNumero(valor +1);
//               aux2.get(i).dato.setTama(aux.get(i).dato.getTama());
//               aux2.get(i).dato.setEstado('D');
                modelo.controlador a = new modelo.controlador(aux1+1, auxtp.get(aux2).dato.getLocalidad(), auxtp.get(aux2).dato.getTama(),'D');
                tal.insertarFinal(a);
                tiempo++;     
               }
           
           }
           x++;
           
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
