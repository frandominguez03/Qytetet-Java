package modeloqytetet;
public class Jugador {
    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        
    }
    
    boolean comprarTituloPropiedad(){
        
    }
    
    int cuantasCasasHotelesTengo(){
        
    }
    
    boolean deboPagarAlquiler(){
        
    }
    
    Sorpresa devolverCartaLibertad(){
        
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        
    }
    
    boolean estoyEnCalleLibre(){
        
    }
    
    Sorpresa getCartaLibertad(){
        
    }
    
    Casilla getCasillaActual(){
        return Casilla.getNumeroCasilla();
    }
    
    boolean getEncarcelado(){
        return this.encarcelado;
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    TituloPropiedad getPropiedades(){
        return TituloPropiedad;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        
    }
    
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad){
    
    }
    
    int obtenerCapital(){
        
    }
    
    TituloPropiedad obtenerPropiedades(boolean hipotecada){
    
    }
    
    void pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setCartaLibertad(Sorpresa carta){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setCasillaActual(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setEncarcelado(boolean encarcelado = false){
        this.encarcelado = encarcelado;
    }
    
    boolean tengoCartaLibertad(){
        
    }
    
    private boolean tengoSaldo(int cantidad){
    
    }
    
    boolean venderPropiedad(Casilla casilla){
        
    }
}
