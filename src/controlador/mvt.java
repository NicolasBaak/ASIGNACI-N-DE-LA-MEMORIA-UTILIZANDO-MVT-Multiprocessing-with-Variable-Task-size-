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

        listaDoble listaDoble = this.listaDoble;
        listaDoble.imprimirTablaPrincipal();
        // System.out.println(" Ingresando valor de listaDoble: i ="+i);

        //System.out.println(listaDoble.get(i).dato.getNombreProceso() + " \t" +listaDoble.get(i).dato.getTama()+ " \t"+ listaDoble.get(i).dato.getTiempoLlegada() + " \t"+listaDoble.get(i).dato.getDuracion()+" \n\n");
        // System.out.println("tiempo: "+ v.numeroPasos+" / listaDoble tiempoLlegada: "+listaDoble.get(v.i).dato.getTiempoLlegada());
        if (v.numeroPasos >= listaDoble.get(v.i).dato.getTiempoLlegada()) {
            int au = 0;
            System.out.println("Dentro de mvt: contadortal=" + v.contadortal);
            System.out.println("Dentro de mvt: i =" + v.i);
            //  tal.imprimirTal();
            //  tp.imprimirTp();

            System.out.println("tal tama = " + tal.get(v.contadortal).dato.getTama());
            System.out.println(" listaDoble = " + listaDoble.get(v.i).dato.getTama());
            while (tal.get(au).dato.getTama() < listaDoble.get(v.i).dato.getTama()) {

                //Checar aux1 en avanzarTiempo
                avanzaTiempo(tp, tal, v);
                if (tal.get(au).siguiente.dato == null) {

                    System.out.println("Se cabaron los elementos de tal\n");
                    //tal.imprimirTal();
                    au = 0;
                }
                au++;
            }

            if (v.contadortal == v.ant_contadortal) {
                //  System.out.println("Ingresado una fila en la tabla tal: aux1 =" + v.contadortal);

                int a = tal.get(v.contadortal).dato.getLocalidad() + listaDoble.get(v.i).dato.getTama();

                tal.get(v.contadortal).dato.setLocalidad(a);

                tal.get(v.contadortal).dato.setTama(tal.get(v.contadortal).dato.getTama() - listaDoble.get(v.i).dato.getTama());
                tal.get(v.contadortal).dato.setEstado('D');

                //   System.out.println(tal.get(v.contadortal).dato.getNumero() + " \t" +tal.get(v.contadortal).dato.getLocalidad()+ " \t"+ tal.get(v.i).dato.getTama() + " \t"+tal.get(v.contadortal).dato.getEstado()+" \n\n");
            }

            int numero = v.contadortp + 1;
            int localidad = tal.get(v.contadortal).dato.getLocalidad() - listaDoble.get(v.i).dato.getTama();
            int tamaño = listaDoble.get(v.i).dato.getTama();
            char estado = 'A';
            int proceso = v.contadortp + 1;
            int duracion = listaDoble.get(v.i).dato.getDuracion();

            modelo.controlador a = new modelo.controlador(numero, localidad, tamaño, estado, proceso, duracion);
            tp.insertarFinal(a);

            //System.out.println("Ingresado una fila en la tabla tp: aux2 ="+v.contadortp);
            // System.out.println(tp.get(v.contadortp).dato.getNumero() + " \t" +tp.get(v.contadortp).dato.getLocalidad()+ " \t"+ tp.get(v.contadortp).dato.getTama() + " \t"+ tp.get(v.contadortp).dato.getEstado()+" \t"+ tp.get(v.contadortp).dato.getProceso()+" \t"+ tp.get(v.contadortp).dato.getDuracion()+"\n\n");
            v.contadortp++;

            avanzaTiempo(tp, tal, v);

            //aux1_ant = aux1;
            //aux2++;
            v.i++;
        }
        // listaDoble.get(i).dato = listaDoble.get(i).siguiente.dato;
        v.numeroPasos++;
    }

    public void avanzaTiempo(listaDoble tp, listaDoble tal, modelo.valores v) {

        for (int i = 0; i < tp.size(); i++) {

            tp.get(i).dato.setDuracion(tp.get(i).dato.getDuracion() - 1);

            if (tp.get(i).dato.getDuracion() <= 0) {
                if (tp.get(i).dato.getEstado() == 'A') {
                    tp.get(i).dato.setEstado('D');
                    modelo.controlador a = new modelo.controlador(v.contadortal + 1, tp.get(i).dato.getLocalidad(), tp.get(i).dato.getTama(), 'D');
                    tal.insertarFinal(a);
                    v.contadortal++;
                }

            }
        }

    }

    public void finish(char finalizar, listaDoble tp) {
        listaDoble aux = tp;
        finalizar = 't';
        for (int i = 0; i < tp.size(); i++) {
            if (aux.get(i).dato.getEstado() == 'A') {
                finalizar = 'f';
            }
            //aux.get(i).dato = aux.get(i).siguiente.dato;
        }
    }

    public char getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(char finalizado) {
        this.finalizado = finalizado;
    }

}
