package modeloqytetet;

public class OtraCasilla extends Casilla{
    private TipoCasilla tipo;
    
    OtraCasilla(TipoCasilla tipo, int numCasilla){
        super(tipo, numCasilla, null);
    }
    
    protected TipoCasilla getTipo(){
        return this.tipo;
    }
    
    @Override
    protected boolean soyEdificable(){
        return this.tipo == TipoCasilla.CALLE;
    }
    
    protected TituloPropiedad getTitulo(){
        return null;
    }
}
