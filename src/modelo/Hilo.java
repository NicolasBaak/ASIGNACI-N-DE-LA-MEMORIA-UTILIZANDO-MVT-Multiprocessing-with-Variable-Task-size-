package modelo;

import vista.dibujos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

public class Hilo extends Thread{
    JScrollPane graficos;
    listaDoble listaDoble=new listaDoble();
    
    public Hilo(JScrollPane graficos, listaDoble listaDoble){
        this.graficos=graficos;
        this.listaDoble=listaDoble;
    }
    public void vuelta(){
        try {
            graficos.setViewportView(new dibujos(listaDoble.size(), listaDoble));
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
