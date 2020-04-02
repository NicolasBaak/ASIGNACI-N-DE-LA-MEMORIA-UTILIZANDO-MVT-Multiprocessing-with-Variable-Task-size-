package controlador;

import javax.swing.JOptionPane;

public class listaDoble {

    private nodo cabecera;

    public listaDoble() {
        cabecera = null;
    }

    public boolean esVacio() {
        return (this.cabecera == null);
    }

    public int size() {
        int tamano = 0;
        nodo aux = cabecera;
        if (!esVacio()) {
            tamano++;

            while (aux.siguiente != null) {
                tamano++;
                aux = aux.siguiente;
            }
        }
        return tamano;
    }

    public void insertarCabecera(controlador dato) {
        nodo nuevo = new nodo(dato);
        if (esVacio()) {
            cabecera = nuevo;
        }
    }

    public void inserta_inicio(controlador dato) {
        if (!esVacio()) {
            nodo nuevo = new nodo(dato);
            if (cabecera.dato.getTiempoLlegada() > nuevo.dato.getTiempoLlegada()) {
                nuevo.siguiente = cabecera;
                cabecera.anterior = nuevo;
                cabecera = nuevo;
            } else {
                cabecera.siguiente = nuevo;
                nuevo.anterior = cabecera;
            }
        }

    }

    public void insertarPrincipio(controlador dato) {
        nodo nuevo = new nodo(dato);
        if (esVacio()) {
            insertarCabecera(dato);
        } else {
            insertarInicio(dato);
        }
    }

    public void insertar(int pos, controlador dato) {
        if (!esVacio()) {
            nodo aux = cabecera;
            nodo nuevo = new nodo(dato);
            if (aux.siguiente == null) {
                inserta_inicio(dato);
            } else if (aux.siguiente.siguiente == null) {
                aux.siguiente = nuevo;
                nuevo.siguiente = aux.siguiente;
                nuevo.anterior = aux;
                aux.siguiente.anterior = nuevo;
            } else {

            }
        }
    }

    public void insertarInicio(controlador dato) {
        nodo nuevo = new nodo(dato);
        if (!esVacio()) {
            nuevo.siguiente = cabecera;
            cabecera.anterior = nuevo;
            cabecera = nuevo;
        }
    }

    public void insertarFinal(controlador dato) {
        nodo aux = cabecera;
        nodo nuevo = new nodo(dato);
        if (!esVacio()) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.anterior = aux;
        } else {
            insertarCabecera(dato);
        }
    }

    public void insertarPorPosicion(controlador dato, int posicion) {
        if (!esVacio()) {
            if (posicion == 1) {
                insertarInicio(dato);
            } else {
                if (posicion == size()) {
                    insertarFinal(dato);
                } else {
                    if (posicion > 0 && posicion < size()) {
                        nodo nuevo = new nodo(dato);
                        nodo aux = cabecera;
                        int con = 0;
                        while (con != (posicion - 1)) {
                            aux = aux.siguiente;
                            con++;
                        }
                        nodo a = aux.siguiente;
                        nuevo.siguiente = aux.siguiente;
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        a.anterior = nuevo;
                    }
                }

            }

        } else {
            insertarCabecera(dato);
        }
    }

    public void modificar(int pos, controlador datos) {
        nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                cabecera.dato = (controlador) datos;
            } else {
                if (pos == size()) {
                    get(pos).dato = (controlador) datos;
                } else {
                    if (pos > 0 & pos < size()) {
                        nodo nuevo = new nodo(datos);
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            recorrido++;
                        }
                        nuevo.siguiente = auxiliar.siguiente;
                        auxiliar.siguiente.dato = nuevo.dato;
                    } else {
                        JOptionPane.showMessageDialog(null, "EL ELEMENTO ES MAYOR AL TAMAÑO DE LA LISTA");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA LISTA ESTA VACIA");
        }

    }

    public nodo get(int posicion) {
        nodo aux = cabecera;
        int contador = 0;
        while (contador != posicion) {
            aux = aux.siguiente;
            contador++;
        }
        return aux;
    }

    public void eliminarLista() {
        if (!esVacio()) {
            cabecera.siguiente = null;
            cabecera = null;
        } else {
        }
    }

    public void eliminarInicio() {
        nodo aux = cabecera;
        if (cabecera.siguiente != null) {
            cabecera = aux.siguiente;
            cabecera.anterior = null;
            aux.siguiente = null;
        } else {
            cabecera = null;
        }
    }

    public void eliminarFinal() {
        nodo auxiliar = cabecera;
        nodo eliminar = auxiliar.siguiente;
        if (!esVacio()) {
            if (cabecera.siguiente != null) {
                while (auxiliar.siguiente.siguiente != null) {
                    auxiliar = auxiliar.siguiente;
                    eliminar = eliminar.siguiente;
                }
            }
            auxiliar.siguiente = null;
            eliminar.anterior = null;
        }
    }

    public void eliminarEntreNodos(int pos) {
        nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                eliminarInicio();
            } else {
                if (pos == size() - 1) {
                    eliminarFinal();
                } else {
                    if (pos > 0 & pos < size()) {
                        nodo eliminar = auxiliar.siguiente;
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            eliminar = eliminar.siguiente;
                            recorrido++;
                        }
                        auxiliar.siguiente = eliminar.siguiente;
                        eliminar.siguiente.anterior = auxiliar;
                        eliminar.siguiente = null;
                        eliminar.anterior = null;

                    } else {
                        JOptionPane.showMessageDialog(null, "NO EXISTE LA POSICION");

                    }
                }
            }
        }

    }

    public String imprimir() {
        String informacion = "";
        nodo actual = cabecera;
        System.out.println("DATOS INGRESADOS: ");
        while (actual != null) {
            informacion += actual.dato.toString() + "\n";
            actual = actual.siguiente;
        }
        return informacion;
    }

}
