package andrea.sumador;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Acumulador_{
    long acumulador=0;

    
    private final O
}

class Adivina_num {

    private int numeroSecreto;
    private boolean adivinado = false;

    public Adivina_num(int min, int max) {
        this.numeroSecreto = ThreadLocalRandom.current().nextInt(min, max +1);

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




public class Eje3_AdivinaNumero implements Runnable {

    private static final int NUM_HILOS=10;
    Adivina_num adivina;
    int contador;
    public static void main(String[] args) {
        
        Adivina_num adivina_numero= new Adivina_num(1, 10000000);
        System.out.println("numero a adivinar "+ adivina_numero);
        Thread[] hilos= new Thread[NUM_HILOS];

        // creo los hilos con numeros aleatorios
        for(int i=0; i< NUM_HILOS;i++){
            hilos[i]= new Thread(new Eje3_AdivinaNumero(adivina_numero));
            hilos[i].setName("HILO"+(i+1));
            hilos[i].start();
        }
    }

        Eje3_AdivinaNumero(Adivina_num adivina) {
        this.adivina = adivina;
        contador=0;


        
     }
   
     @Override
     public void run() {
         System.out.println("Inicio del hilo " + Thread.currentThread().getName());
         boolean fin = false;
         while (!fin) {
             int num = ThreadLocalRandom.current().nextInt(1, 10000001);
             contador++;
             int tiro = adivina.intento_adivinar_numero(num);

             if (tiro == 0) {
                 System.out.println(
                         "He acertado! soy " + Thread.currentThread().getName() + " al " + contador + " intentos ");
                 fin = true;
             }
             if(tiro ==99){
                System.out.println("ohhhh, no he ganado ("+ Thread.currentThread().getName()+") lo he intentado "+ contador +" veces");
                fin= true;
             }
         }
     }

    
}
