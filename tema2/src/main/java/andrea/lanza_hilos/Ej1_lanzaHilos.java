package andrea.lanza_hilos;

/* class Hilo implements Runnable {

    private final String nombre;

    public Hilo1(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Hola soy " + nombre);
        System.out.printf("Hola %s termonado. \n", nombre);
    }

} */

public class Ej1_lanzaHilos {

    public static void main(String[] args) {
        int numeroHilos = 4;
        Thread[] hilos = new Thread[numeroHilos];

        for (int i = 0; i < numeroHilos; i++) {
            hilos[i] = new Thread(new Hilo("Hilo " + (i + 1)));
            hilos[i].start();
        }
        System.out.println("proceso principar espeando que termine los hilos");

        for (Thread hilo : hilos) {
            try {
                hilo.join();

            } catch (InterruptedException e) {
                System.out.println("Proseco interrumpido ");
            }
        }

        System.out.println("hilos terminados y Proceso padre terminado");
    }

}
