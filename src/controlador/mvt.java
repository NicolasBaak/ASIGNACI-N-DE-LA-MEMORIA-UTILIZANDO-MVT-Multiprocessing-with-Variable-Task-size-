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
            System.out.println("Lista doble tama= " + listaDoble.get(v.i).dato.getTama());
            System.out.println("tal tama =" + tal.get(au).dato.getTama());

            while (tal.get(au).dato.getTama() < listaDoble.get(v.i).dato.getTama()) {
                avanzaTiempo(tp, tal, v);
                if (tal.get(au + 1).siguiente.dato.getTama() < listaDoble.get(v.i).dato.getTama()) {
                    System.out.println("Lista doble tama= " + listaDoble.get(v.i).dato.getTama());
                    System.out.println("tal tama =" + tal.get(au).dato.getTama());

                    avanzaTiempo(tp, tal, v);
                    System.out.println("Se cabaron los elementos de tal\n");
                    //tal.imprimirTal();
                   
                } else {
                    au++;
                }
            }

            if (v.contadortal == v.ant_contadortal) {
                //  System.out.println("Ingresado una fila en la tabla tal: aux1 =" + v.contadortal);

                int a = tal.get(v.contadortal).dato.getLocalidad() + listaDoble.get(v.i).dato.getTama();

                tal.get(v.contadortal).dato.setLocalidad(a);

                tal.get(v.contadortal).dato.setTama(tal.get(v.contadortal).dato.getTama() - listaDoble.get(v.i).dato.getTama());
                tal.get(v.contadortal).dato.setEstado('D');

                //   System.out.println(tal.get(v.contadortal).dato.getNumero() + " \t" +tal.get(v.contadortal).dato.getLocalidad()+ " \t"+ tal.get(v.i).dato.getTama() + " \t"+tal.get(v.contadortal).dato.getEstado()+" \n\n");
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
            }
            //System.out.println("Ingresado una fila en la tabla tp: aux2 ="+v.contadortp);
            // System.out.println(tp.get(v.contadortp).dato.getNumero() + " \t" +tp.get(v.contadortp).dato.getLocalidad()+ " \t"+ tp.get(v.contadortp).dato.getTama() + " \t"+ tp.get(v.contadortp).dato.getEstado()+" \t"+ tp.get(v.contadortp).dato.getProceso()+" \t"+ tp.get(v.contadortp).dato.getDuracion()+"\n\n");
            v.contadortp++;

            avanzaTiempo(tp, tal, v);
            v.ant_contadortal = v.contadortal;
            //aux1_ant = aux1;
            //aux2++;
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
                    tp.get(i).dato.setEstado('D');
                    modelo.controlador a = new modelo.controlador(v.contadortal + 1, tp.get(i).dato.getLocalidad(), tp.get(i).dato.getTama(), 'D');
                    tal.insertarFinal(a);
                    v.contadortal++;
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
