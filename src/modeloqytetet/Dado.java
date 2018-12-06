package modeloqytetet;
import java.util.Random;

class Dado {
    private static final Dado instance = new Dado();
    private int valor;
    
    private Dado(){
        valor = 0;
    }
    
    public static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        Random rand = new Random();
        
        int obtenido = rand.nextInt(6) + 1;
        this.valor = obtenido;
        
        return obtenido;
    }
    
    public int getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }
}
