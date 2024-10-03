package andrea.lanza_hilos;

class Hilo implements Runnable{

    private final String nombre;

    Hilo(String nombre){
        this.nombre=nombre;
    }

    //este metodo es como el main de los hilos
    @Override
    public void run() {
        
        System.out.println("Hola soy "+ nombre);
        System.out.printf("Hola %s termonado. \n",nombre);
    }

    
}

public class LanzaHilos {

    public static void main(String[] args) {
        
        Thread t1= new Thread(new Hilo("Hilo1"));
        Thread t2=new Thread(new Hilo("Hilo2"));
        Thread t3= new Thread(new Hilo("Hilo3"));
        Thread t4=new Thread(new Hilo("Hilo4"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("Proceso principal terminado ");

        //si se quiere esperar a que los hilos finalicen primero para realizar acciones
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido");
        }

        System.out.println("Proceso principal terminado");
    }
}
