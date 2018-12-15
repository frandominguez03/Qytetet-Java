package modeloqytetet;

public class Calle extends Casilla{
    private TituloPropiedad titulo;
    
    Calle(int numCasilla, TituloPropiedad titulo){
        super(numCasilla);
        setCoste(titulo.getPrecioCompra());
        setTitulo(titulo);
    }
    
    public void asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
    }
    
    protected TipoCasilla getTipo(){
        return TipoCasilla.CALLE;
    }
    
    @Override
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
    
    @Override
    public String toString(){
        return super.toString() + " Calle{" + "titulo=" + titulo + '}';
    }
}
