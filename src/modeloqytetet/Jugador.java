package modeloqytetet;
import java.util.ArrayList;

public class Jugador {
    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    
    private Jugador propietario;
    private ArrayList<TituloPropiedad> propiedades;
    
    Jugador(String nombre){
        this.nombre = nombre;
    }
    
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
        return this.cartaLibertad;
    }
    
    Casilla getCasillaActual(){
        return this.casillaActual;
    }
    
    boolean getEncarcelado(){
        return this.encarcelado;
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    ArrayList<TituloPropiedad> getPropiedades(){
        return this.propiedades;
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
        this.cartaLibertad = carta;
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado){
        if(encarcelado){         
            this.encarcelado = encarcelado;
        }
        
        else{
            this.encarcelado = false;
        }
    }
    
    boolean tengoCartaLibertad(){
        
    }
    
    private boolean tengoSaldo(int cantidad){
    
    }
    
    boolean venderPropiedad(Casilla casilla){
        
    }
    
    @Override
    public String toString(){
        return "Jugador{ " + "nombre:" + nombre + "encarcelado:" + encarcelado +
                "saldo:" + Integer.toString(saldo) + "cartaLibertad:" + cartaLibertad +
                "casillaActual:" + casillaActual + "propiedades:" + propiedades + "}";
    }
}
