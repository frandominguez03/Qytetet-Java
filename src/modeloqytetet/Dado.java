package modeloqytetet;

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
        return 0;
    }
    
    public int getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }
}
