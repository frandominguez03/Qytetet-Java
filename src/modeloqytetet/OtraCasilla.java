package modeloqytetet;

public class OtraCasilla extends Casilla{
    private TipoCasilla tipo;
    
    OtraCasilla(TipoCasilla tipo, int numCasilla){
        super(numCasilla);
        this.tipo = tipo;;
    }
    
    protected TipoCasilla getTipo(){
        return this.tipo;
    }
    
    @Override
    protected TituloPropiedad getTitulo(){
        return null;
    }
    
    @Override
    protected boolean soyEdificable(){
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString() + " OtraCasilla{" + "tipo=" + tipo + '}';
    }
}
