package andrea;

public class Info_hilos {
    public static void main(String[] args) {
        
        Thread t= Thread.currentThread();
        System.out.println("ID: "+ t.getId()+" nombre: "+ t.getName()+ "prioridad: "+ 
            t.getPriority()+" estado: "+ t.getState().toString());
        System.out.println("vivo: "+t.isAlive()+ "interrumpido? : "+t.isInterrupted()+ " esDemonio? :"+ t.isDaemon());
    

    }
}
