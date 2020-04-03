/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author nicol
 */
public class controlador {
    private String nombreProceso;
    private int tama;
    private int tiempoLlegada;
    private int duracion;
    
    
    int numero;
    int localidad;
    char estado;
    int orden;
    int proceso;
    
    public controlador(){
    }
    
    public controlador(String nombreProceso, int tama, int tiempoLlegada, int duracion){
        this.nombreProceso = nombreProceso;
        this.tama = tama;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
    }
    
    public controlador(int numero, int localidad, int tama, char estado){
    
    this.numero = numero;
    this.localidad = localidad;
    this.tama = tama;
    this.estado = estado;
    }

     public controlador(int numero, int localidad, int tama, char estado, int proceso){
    
    this.numero = numero;
    this.localidad = localidad;
    this.tama = tama;
    this.estado = estado;
    this.proceso = proceso;
    }
     
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getNumero() {
        return numero;
    }

    public int getLocalidad() {
        return localidad;
    }

    public char getEstado() {
        return estado;
    }

    public int getOrden() {
        return orden;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public int getTama() {
        return tama;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public void setTama(int tama) {
        this.tama = tama;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
