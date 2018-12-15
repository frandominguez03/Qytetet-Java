package modeloqytetet;

public abstract class Casilla {
    private int numeroCasilla;
    private int coste;
    
    Casilla(int numCasilla){
        this.numeroCasilla = numCasilla;
    }

    int getNumeroCasilla() {
        return this.numeroCasilla;
    }

    int getCoste() {
        return this.coste;
    }
    
    protected abstract TituloPropiedad getTitulo();
    
    protected abstract boolean soyEdificable();
    
    public void setCoste(int coste){
        this.coste = coste;
    }   
    
    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla:" + numeroCasilla + ", coste:" + coste + '}';
    }
}
