package andrea.sumador;

class HiloSumador3 implements Runnable{
    int n1,n2;

    public HiloSumador3(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public synchronized void run () {
        long suma=0;
        for(int i=n1;i<=n2;i++ ){
            suma +=i;
        }
        System.out.println(suma);
    }
    
}

public class Eje2_HiloSumador {
    public static void main(String[] args) {
        
        Thread t1=new Thread(new HiloSumador2(1, 33333));
        Thread t2= new Thread(new HiloSumador2(33334, 66666));
        Thread t3= new Thread(new HiloSumador2(66667, 1000000));
        Thread t4=new Thread(new HiloSumador2(1000001,2000000 ));
        Thread t5= new Thread(new HiloSumador2(2000001, 3000000));
        Thread t6= new Thread(new HiloSumador2(3000001, 4000000));
        Thread t7=new Thread(new HiloSumador2(4000001, 6666666));
        Thread t8= new Thread(new HiloSumador2(600001, 888888));
        Thread t9= new Thread(new HiloSumador2(10000000, 20000000));
        Thread t10= new Thread(new HiloSumador2(500000000, 900000000));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (InterruptedException e) {
            System.out.println("Proseco interrumpido ");
        }

        System.out.println("hilos terminados y Proceso padre terminado");
    }
}
