package modeloqytetet;

public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    Casilla(TipoCasilla un_tipo, int numCasilla, TituloPropiedad un_titulo){
        this.numeroCasilla = numCasilla;
        
        if(un_tipo == TipoCasilla.CALLE){
            this.tipo = un_tipo;
            setTitulo(un_titulo);
            coste = titulo.getPrecioCompra();
        }
    }

   int getNumeroCasilla() {
        return this.numeroCasilla;
    }

    int getCoste() {
        return this.coste;
    }
    
    private void setTipo(TipoCasilla tipo){
        this.tipo = tipo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    public void setCoste(int coste){
        this.coste = coste;
    }
    
    protected boolean soyEdificable(){
        return this.tipo == TipoCasilla.CALLE;
    }
    
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }
    
    @Override
    public String toString() {
        if(this.tipo == TipoCasilla.CALLE){
            return "Casilla{" + "numeroCasilla:" + numeroCasilla + ", precioCompra:" + coste + ", tipo:" + tipo + ", titulo:" + titulo + '}';
        }
        
        else{
            return "Casilla{" + "numeroCasilla:" + numeroCasilla + ", precioCompra:" + coste + ", tipo:" + tipo + '}';
        }
    }
}
