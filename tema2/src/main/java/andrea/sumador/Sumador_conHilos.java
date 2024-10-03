package andrea.sumador;

    class Sumador implements Runnable {
    
    int n1,n2;

    public Sumador(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        long suma=0;
        for(int i= n1; i<=n2; i++){
            suma+=i;
        }
        System.out.println(suma);
    }
    
}

public class Sumador_conHilos {
    public static void main(String[] args) {
        
        Thread t1=new Thread(new Sumador(1, 10000));
        t1.start();
    }

    
}
