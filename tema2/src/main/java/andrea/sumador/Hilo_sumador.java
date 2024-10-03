package andrea.sumador;

class HiloSumador2 implements Runnable{
    int n1,n2;

    public HiloSumador2(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        long suma=0;
        for(int i=n1;i<=n2;i++ ){
            suma +=i;
        }
        System.out.println(suma);
    }
    
}



public class Hilo_sumador {
    public static void main(String[] args) {
        
        Thread t1=new Thread(new HiloSumador2(1, 33333));
        Thread t2= new Thread(new HiloSumador2(33334, 66666));
        Thread t3= new Thread(new HiloSumador2(66667, 1000000));

        t1.start();
        t2.start();
        t3.start();
    }
}
