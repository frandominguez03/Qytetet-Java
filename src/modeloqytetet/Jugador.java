package modeloqytetet;
import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {
    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    
    private ArrayList<TituloPropiedad> propiedades;
    
    Jugador(String nombre){
        this.nombre = nombre;
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        boolean puedeCancelar = false;
        int costeCancelar = titulo.calcularCosteCancelar();
        
        if(saldo > costeCancelar){
            titulo.cancelarHipoteca(); 
            puedeCancelar = true;
        }
        
        return puedeCancelar;
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
        boolean esta_encarcelado = false;
        boolean estaHipotecada = false;
        
        if(!esDeMiPropiedad && casillaActual.getTitulo().tengoPropietario()){
            tienePropietario = true;
        }
        
        if(!esDeMiPropiedad && tienePropietario && casillaActual.getTitulo().propietarioEncarcelado()){
            esta_encarcelado = true;
        }
        
        if(!esDeMiPropiedad && tienePropietario && casillaActual.getTitulo().getHipotecada()){
            estaHipotecada = true;
        }
        
        return !esDeMiPropiedad && tienePropietario && !esta_encarcelado && !estaHipotecada;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa intermedia = new Sorpresa(cartaLibertad.getTexto(), cartaLibertad.getValor(), cartaLibertad.getTipo());
        cartaLibertad = null;
        return intermedia;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean hayEspacio = titulo.getNumCasas() < 4;
        boolean tengoSaldo = false;
        boolean edificada = hayEspacio && tengoSaldo;
        int costeEdificarCasa = 0;
        
        if(hayEspacio){
            costeEdificarCasa = titulo.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarCasa);
        }
        
        if(hayEspacio && tengoSaldo){
            titulo.edificarCasa();
            this.modificarSaldo(-costeEdificarCasa);
        }
        
        return edificada;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean hayEspacio = titulo.getNumHoteles() < 4;
        boolean tengoSaldo = false;
        boolean edificado = hayEspacio && tengoSaldo;
        int costeEdificarHotel = 0;
        
        if(hayEspacio){
            costeEdificarHotel = titulo.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarHotel);
        }
        
        if(hayEspacio && tengoSaldo){
            titulo.edificarCasa();
            this.modificarSaldo(-costeEdificarHotel);
        }
        
        return edificado;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        this.propiedades.remove(titulo);
        titulo.setPropietario(null);
        int precioVenta = titulo.calcularPrecioVenta();
        this.modificarSaldo(precioVenta);
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        boolean resultado = false;
        if(propiedades.contains(titulo)){
            resultado = true;
        }
        
        return resultado;
    }
    
    boolean estoyEnCalleLibre(){
        boolean calleLibre = false;
        
        if(casillaActual.getTitulo().getPropietario() != null){
            calleLibre = true;
        }
        
        return calleLibre;
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
    
    void hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca = casillaActual.getTitulo().hipotecar();
        modificarSaldo(costeHipoteca);
    }
    
    void irACarcel(Casilla casilla){
        setEncarcelado(true);
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
        double costeAlquiler = casillaActual.pagarAlquiler();
        this.modificarSaldo((int) -costeAlquiler);
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
    
    void venderPropiedad(Casilla casilla){
        eliminarDeMisPropiedades(casilla.getTitulo());
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
