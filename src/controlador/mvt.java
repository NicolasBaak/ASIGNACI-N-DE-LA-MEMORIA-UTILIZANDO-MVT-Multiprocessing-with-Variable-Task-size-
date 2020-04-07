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
            char aux1 = 'f';
            int au = 0;
            
            while(listaDoble.get(v.i).dato.getTama()> tal.get(au).dato.getTama()) {
                avanzaTiempo(tp, tal, v);  
                for( int i = 0; i < tal.size(); i++){
                    if(tal.get(i).dato.getTama() >=  listaDoble.get(v.i).dato.getTama()) 
                    {
                    au = i;
                    aux1 = 't';
                    }
                }
            }
        
            if (v.contadortal == v.ant_contadortal) {
  
                int a = tal.get(v.contadortal).dato.getLocalidad() + listaDoble.get(v.i).dato.getTama();
                tal.get(v.contadortal).dato.setLocalidad(a);
                tal.get(v.contadortal).dato.setTama(tal.get(v.contadortal).dato.getTama() - listaDoble.get(v.i).dato.getTama());
            }

            if (v.contadortp < 5) {
                int localidad;
                int numero = v.contadortp + 1;
                if( aux1 == 'f')
                    localidad = tal.get(v.contadortal).dato.getLocalidad() - listaDoble.get(v.i).dato.getTama();
                else{
                    localidad = tal.get(au).dato.getLocalidad();
                    tal.get(au).dato.setLocalidad(tal.get(au).dato.getLocalidad() + listaDoble.get(v.i).dato.getTama() );
                    tal.get(au).dato.setTama( tal.get(au).dato.getTama() - listaDoble.get(v.i).dato.getTama());      
                    tal.imprimirTal();
                }
                int tamaño = listaDoble.get(v.i).dato.getTama();
                char estado = 'A';
                int proceso = v.contadortp + 1;
                int duracion = listaDoble.get(v.i).dato.getDuracion();

                modelo.controlador a = new modelo.controlador(numero, localidad, tamaño, estado, proceso, duracion);
                tp.insertarFinal(a);
                v.contadortp++;
            }
          
            v.ant_contadortal = v.contadortal;
            v.i++;
            
        }
        // listaDoble.get(i).dato = listaDoble.get(i).siguiente.dato;
        avanzaTiempo(tp, tal, v);
        v.numeroPasos++;

    }

    public void avanzaTiempo(listaDoble tp, listaDoble tal, modelo.valores v) {

        for (int i = 0; i < tp.size(); i++) {
            if (tp.get(i).dato.getDuracion() > 0) {
                tp.get(i).dato.setDuracion(tp.get(i).dato.getDuracion() - 1);
            }
            else{
                if (tp.get(i).dato.getEstado() == 'A') {
                    v.contadortal++;
                    tp.get(i).dato.setEstado('D');
                    modelo.controlador a = new modelo.controlador(v.contadortal+1, tp.get(i).dato.getLocalidad(), tp.get(i).dato.getTama(), 'D');
                    tal.insertarFinal(a);
                }

            }

        }
    }

    public char finish(char finalizar, listaDoble tp, listaDoble tal) {
        listaDoble aux = tp;
        finalizar = 't';
        for (int i = 0; i < tp.size(); i++) {
            if (aux.get(i).dato.getEstado() == 'A') {
                finalizar = 'f';
            }
        }
        
        if(tal.size() > 1)
            finalizar = 'f';
        return finalizar;
    }

}
