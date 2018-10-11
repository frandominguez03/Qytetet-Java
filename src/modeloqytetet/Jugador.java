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
        return false;
    }
    
    boolean comprarTituloPropiedad(){
        return false;
    }
    
    int cuantasCasasHotelesTengo(){
        return 0;
    }
    
    boolean deboPagarAlquiler(){
        return false;
    }
    
    Sorpresa devolverCartaLibertad(){
        return null;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        return false;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        return false;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        return false;
    }
    
    boolean estoyEnCalleLibre(){
        return false;
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
        return false;
    }
    
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad){
        return 0;
    }
    
    int obtenerCapital(){
        return 0;
    }
    
    TituloPropiedad obtenerPropiedades(boolean hipotecada){
        return null;
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
        if(carta.getTipo() != TipoSorpresa.SALIRCARCEL) {
            this.cartaLibertad = carta;
        }
        
        else {
            throw new Error("La carta no es de tipo SALIRCARCEL");
        }
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
        return false;
    }
    
    private boolean tengoSaldo(int cantidad){
        return false;
    }
    
    boolean venderPropiedad(Casilla casilla){
        return false;
    }
    
    @Override
    public String toString(){
        return "Jugador{ " + "nombre:" + nombre + " encarcelado:" + encarcelado +
                " saldo:" + Integer.toString(saldo) + " cartaLibertad:" + cartaLibertad +
                " casillaActual:" + casillaActual + " propiedades:" + propiedades + "}";
    }
}
