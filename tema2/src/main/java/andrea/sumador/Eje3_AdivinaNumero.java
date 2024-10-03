package andrea.sumador;

import java.util.Random;

class Adivina {

    private int numeroSecreto;
    private boolean adivinado = false;

    public Adivina(int numeroSecreto) {
        this.numeroSecreto = numeroSecreto;

    }
    //synchronized para q acceda uno a la vez
    public synchronized int intento_adivinar_numero(int intento) {
        if (adivinado) {
            return -99;
        }
        if (intento == numeroSecreto) {
            adivinado = true;
            return 0;
        }
        return 1;
    }

}

class Hilo_Adivina implements Runnable{
    private Adivina adivina;
    private String nombreHilo;
    private Random numero= new Random();


    @Override
    public void run() {
        
    }


}


public class Eje3_AdivinaNumero {

}
