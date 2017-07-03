package Cliente;

public class Aplicacion {

    public static void main(String[] args) {
        
        for (int i = 0; i < 1; i++) {
            Thread t = new Thread(new Mythread());
            t.start();
        }
{
            
        }
    }

}
