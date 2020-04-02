/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author nicol
 */
public class controlador {
    private String nombreProceso;
    private int tama;
    private int tiempoLlegada;
    private int duracion;
    
    public controlador(){
    }
    
    public controlador(String nombreProceso, int tama, int tiempoLlegada, int duracion){
    
        this.nombreProceso = nombreProceso;
        this.tama = tama;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
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
