package modeloqytetet;
import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {
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
        boolean comprado = false;
        int costeCompra = casillaActual.getCoste();
        
        if(costeCompra<saldo){
            comprado = true;
            TituloPropiedad titulo = casillaActual.asignarPropietario(this);
            titulo.setPropietario(this);
            propiedades.add(titulo);
            this.modificarSaldo(-costeCompra);
        }
        
        return comprado;
    }
    
    int cuantasCasasHotelesTengo(){
        int contador = 0;
        for(int i=0; i<propiedades.size(); i++){
            contador += propiedades.get(i).getNumCasas() + propiedades.get(i).getNumHoteles();
        }
        
        return contador;
    }
    
    boolean deboPagarAlquiler(){
        boolean esDeMiPropiedad = esDeMiPropiedad(casillaActual.getTitulo());
        boolean tienePropietario = false;
        boolean encarcelado = false;
        boolean estaHipotecada = false;
        
        if(!esDeMiPropiedad && casillaActual.getTitulo().tengoPropietario()){
            tienePropietario = true;
        }
        
        if(!esDeMiPropiedad && tienePropietario && casillaActual.getTitulo().propietarioEncarcelado()){
            encarcelado = true;
        }
        
        if(!esDeMiPropiedad && tienePropietario && casillaActual.getTitulo().getHipotecada()){
            estaHipotecada = true;
        }
        
        return !esDeMiPropiedad && tienePropietario && !encarcelado && !estaHipotecada;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa intermedia = new Sorpresa(cartaLibertad.getTexto(), cartaLibertad.getValor(), cartaLibertad.getTipo());
        cartaLibertad = null;
        return intermedia;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        Casilla casilla = casillaActual.obtenerCasillaNumero(casillaActual);
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        return false;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        boolean resultado = false;
        if(propiedades.contains(titulo)){
            resultado = true;
        }
        
        return resultado;
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
        return saldo+=cantidad;
    }
    
    int obtenerCapital(){
        int saldo_total = 0;
        
        for(int i=0; i<propiedades.size(); i++){
            saldo_total += propiedades.get(i).getPrecioCompra()
                    + propiedades.get(i).getNumCasas()*propiedades.get(i).getPrecioEdificar()
                    + propiedades.get(i).getNumHoteles()*propiedades.get(i).getPrecioEdificar();
            
            if(propiedades.get(i).getHipotecada()){
                saldo_total -= propiedades.get(i).getHipotecaBase();
            }
        }
        
        return saldo+saldo_total;
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada){
        ArrayList<TituloPropiedad> nuevas_propiedades = new ArrayList<>();
        
        for(int i=0; i<propiedades.size(); i++){
            if(propiedades.get(i).getHipotecada() == hipotecada){
                nuevas_propiedades.add(propiedades.get(i));
            }
        }
        
        return nuevas_propiedades;
    }
    
    void pagarAlquiler(){
        int costeAlquiler = casillaActual.getTitulo().calcularImporteAlquiler();
        this.modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto(){
        this.saldo-=casillaActual.getCoste();
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
        return this.cartaLibertad != null;
    }
    
    boolean tengoSaldo(int cantidad){
        return this.saldo>cantidad;
    }
    
    boolean venderPropiedad(Casilla casilla){
        return false;
    }
    
    @Override
    public String toString(){
        return "Jugador{ " + "nombre:" + nombre + " encarcelado:" + encarcelado +
                " saldo:" + Integer.toString(saldo) +" capital: " + this.obtenerCapital() + " cartaLibertad:"
                + cartaLibertad + " casillaActual:" + casillaActual + " propiedades:" + propiedades + "}";
    }
    
    @Override
    public int compareTo(Jugador otroJugador) {
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        
        return otroCapital-this.obtenerCapital();
    }
}
