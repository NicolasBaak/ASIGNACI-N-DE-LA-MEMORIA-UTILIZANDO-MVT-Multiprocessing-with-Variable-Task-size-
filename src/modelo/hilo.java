package modelo;

import vista.dibujos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

public class hilo extends Thread{
    JScrollPane graficos;
    listaDoble tal =new listaDoble();
    listaDoble tp =new listaDoble();
    
    public hilo(JScrollPane graficos, listaDoble tal){
        this.graficos=graficos;
        this.tal = tal;
    }
    public void vuelta(){
        try {
            graficos.setViewportView(new dibujos(tal.size(), tal));
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
