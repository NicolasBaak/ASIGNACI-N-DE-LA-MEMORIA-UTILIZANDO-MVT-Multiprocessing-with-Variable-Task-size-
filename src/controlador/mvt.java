/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.listaDoble;

public class mvt {

    listaDoble listaDoble = new listaDoble();

    char finalizado = 'f';

    public mvt(listaDoble ListaDoble) {
        this.listaDoble = ListaDoble;
    }

    public void mvt(modelo.valores v, listaDoble tal, listaDoble tp) {
            
        if (v.numeroPasos >= listaDoble.get(v.i).dato.getTiempoLlegada()) {
           
            
            int au = 0;
            
            while(listaDoble.get(v.i).dato.getTama()> tal.get(au).dato.getTama()) {
               avanzaTiempo(tp, tal, v);  
                for( int i = 0; i < tal.size(); i++){
                    if(tal.get(i).dato.getTama() >=  listaDoble.get(v.i).dato.getTama()) 
                    {
                    au = i;
                    }
                }
            }

            if (v.contadortal == v.ant_contadortal) {
  
                int a = tal.get(v.contadortal).dato.getLocalidad() + listaDoble.get(v.i).dato.getTama();
                tal.get(v.contadortal).dato.setLocalidad(a);
                tal.get(v.contadortal).dato.setTama(tal.get(v.contadortal).dato.getTama() - listaDoble.get(v.i).dato.getTama());
                tal.get(v.contadortal).dato.setEstado('D');
            }

            if (v.contadortp < 5) {
                int numero = v.contadortp + 1;
                int localidad = tal.get(v.contadortal).dato.getLocalidad() - listaDoble.get(v.i).dato.getTama();
                int tamaño = listaDoble.get(v.i).dato.getTama();
                char estado = 'A';
                int proceso = v.contadortp + 1;
                int duracion = listaDoble.get(v.i).dato.getDuracion();

                modelo.controlador a = new modelo.controlador(numero, localidad, tamaño, estado, proceso, duracion);
                tp.insertarFinal(a);
                v.contadortp++;
            }

            avanzaTiempo(tp, tal, v);
            v.ant_contadortal = v.contadortal;
            v.i++;
            
        }
        // listaDoble.get(i).dato = listaDoble.get(i).siguiente.dato;
        v.numeroPasos++;

    }

    public void avanzaTiempo(listaDoble tp, listaDoble tal, modelo.valores v) {

        for (int i = 0; i < tp.size(); i++) {
            if (tp.get(i).dato.getDuracion() > 0) {
                tp.get(i).dato.setDuracion(tp.get(i).dato.getDuracion() - 1);
            }

            if (tp.get(i).dato.getDuracion() == 0) {
                if (tp.get(i).dato.getEstado() == 'A') {
                    v.contadortal++;
                    tp.get(i).dato.setEstado('D');
                    modelo.controlador a = new modelo.controlador(v.contadortal+1, tp.get(i).dato.getLocalidad(), tp.get(i).dato.getTama(), 'D');
                    tal.insertarFinal(a);
                    
                }

            }

        }

    }
    
    public void fucionarTal(listaDoble tal, modelo.valores v){
    
        for(int i = 0; i < tal.size(); i++){
        
            for(int j = 1;j < tal.size()-1; j++){
            
            int aux = tal.get(j).dato.getTama() + tal.get(j).dato.getLocalidad();
            if(tal.get(j).dato.getTama() <= 0){
                tal.eliminarEntreNodos(j);
                v.contadortal--;
                for(int a = j; a < (tal.size()-j); a++ ) tal.get(a).dato.setNumero(tal.get(a).dato.getNumero()-1);
            
            } 
            
            if(tal.get(i).dato.getTama() == aux){
            
                int numero = tal.get(i).dato.getNumero();
                int localidad;
                int tama;
                if(tal.get(j).dato.getLocalidad() < tal.get(i).dato.getLocalidad())
                { localidad = tal.get(j).dato.getLocalidad();
                  tama = tal.get(j).dato.getTama() + tal.get(i).dato.getTama()+tal.get(j).dato.getLocalidad();
           
                }
                else{
                 localidad = tal.get(i).dato.getLocalidad();
                   tama = tal.get(j).dato.getTama() + tal.get(i).dato.getTama()+tal.get(i).dato.getLocalidad();
                }
            char estado = 'D';
            modelo.controlador a = new modelo.controlador(numero, localidad, tama, estado);
            tal.insertarInicio(a);
            tal.eliminarEntreNodos(i);
            tal.eliminarEntreNodos(j); 
            v.contadortal--;
            }
            
            
            if(tal.get(i).dato.getLocalidad() == tal.get(j).dato.getLocalidad() && tal.get(j).dato.getTama() == tal.get(i).dato.getTama()){
                if(tal.get(i).dato.getLocalidad() <= tal.get(j).dato.getNumero())
                {
                    tal.eliminarEntreNodos(j);
                    v.contadortal--;
                }
                else{
                    tal.eliminarEntreNodos(i);
                    v.contadortal--;
                }
            }
            
            }   
        }       
    }

    public char finish(char finalizar, listaDoble tp) {
        listaDoble aux = tp;
        finalizar = 't';
        for (int i = 0; i < tp.size(); i++) {
            if (aux.get(i).dato.getEstado() == 'A') {
                finalizar = 'f';
            }
            //aux.get(i).dato = aux.get(i).siguiente.dato;
        }
        return finalizar;
    }

    public char getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(char finalizado) {
        this.finalizado = finalizado;
    }

}
