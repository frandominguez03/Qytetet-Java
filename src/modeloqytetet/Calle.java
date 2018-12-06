package modeloqytetet;

public class Calle extends Casilla{
    private TituloPropiedad titulo;
    private int coste;
    
    Calle(int numCasilla, TituloPropiedad titulo){
        super(TipoCasilla.CALLE, numCasilla, titulo);
        this.coste = titulo.getPrecioCompra();
        this.titulo = titulo;
    }
    
    public void asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
    }
    
    protected TipoCasilla getTipo(){
        return TipoCasilla.CALLE;
    }
    
    protected TituloPropiedad getTitulo(){
        return this.titulo;
    }
    
    public int pagarAlquiler(){
        return this.titulo.pagarAlquiler();
    }
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    @Override
    protected boolean soyEdificable(){
        return true;
    }
    
    public boolean tengoPropietario(){
        return titulo.tienePropietario();
    }
}
