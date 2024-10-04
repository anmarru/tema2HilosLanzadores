package andrea.sumador;

class Acumulador{
    long acumulador=0;
    private final Object bloqueo= new Object();

    synchronized void acumular (long l){
        acumulador+=l;
    }
    public long getAcumulador() {
        return acumulador;
    }

}
class HiloSumador3 implements Runnable{
    int n1,n2;
    Acumulador acu;
    int numero;

    public HiloSumador3(int num,int n1, int n2, Acumulador_ a) {
        this.n1 = n1;
        this.n2 = n2;
        this.acu = a;
        this.numero=num;
        System.out.println(n1+"-"+n2);
    }

    @Override
    public  void run () {
        System.out.println("inicio hilo "+ numero);
        int suma=0;
        for(int i=n1;i<=n2;i++ ){
            suma+=i;
        }
        acu.acumular(suma);
    }
    
}

public class Eje2_HiloSumador {
    
    static Acumulador_ suma;
    static final int NUM_HILOS=10;
    public static void main(String[] args) {
        
        suma =new Acumulador_();
        Thread[] hilos= new Thread[NUM_HILOS];
        int paso= 100000/NUM_HILOS-1;
        System.out.println(paso);
        int n1=l;
        for(int i=0; i< NUM_HILOS; i++){
            hilos[i]=new Thread(new HiloSumador3(i+1, n1, n1+paso, suma));
            n1=n1+paso+1;
            hilos[i].start();
        }
        for(Thread t: hilos){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
        System.out.println(" suma "+ suma.getAcumulador());
        
    }
}
