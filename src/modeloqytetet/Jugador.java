package modeloqytetet;
import java.util.ArrayList;

public class Jugador implements Comparable {
    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    
    private ArrayList<TituloPropiedad> propiedades = new ArrayList<>();
    
    protected Jugador(String nombre){
        this.nombre = nombre;
    }
    
    protected Jugador(Jugador otroJugador){
        this.nombre = otroJugador.getNombre();
        this.saldo = otroJugador.getSaldo();
        this.encarcelado = otroJugador.getEncarcelado();
        this.cartaLibertad = otroJugador.getCartaLibertad();
        this.casillaActual = otroJugador.getCasillaActual();
        this.propiedades = otroJugador.getPropiedades();
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        boolean puedeCancelar = false;
        int costeCancelar = titulo.calcularCosteCancelar();
        
        if(tengoSaldo(costeCancelar)){
            titulo.cancelarHipoteca();
            modificarSaldo(-costeCancelar);
            puedeCancelar = true;
        }
        
        return puedeCancelar;
    }
    
    protected Especulador convertirme(int fianza){
        Especulador especula = new Especulador(this, fianza);
        
        return especula;
    }
    
    boolean comprarTituloPropiedad(){
        boolean comprado = false;
        int costeCompra = casillaActual.getCoste();
        
        if(costeCompra < saldo){
            comprado = true;
            Calle cas = (Calle) casillaActual;
            TituloPropiedad titulo = cas.getTitulo();
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
    
    protected boolean deboIrACarcel(){
        return !tengoCartaLibertad();
    }
    
    boolean deboPagarAlquiler(){
        Calle cas = (Calle) casillaActual;
        TituloPropiedad titulo = cas.getTitulo();
        boolean esDeMiPropiedad = esDeMiPropiedad(titulo);
        boolean tienePropietario = false;
        boolean esta_encarcelado = false;
        boolean estaHipotecada = false;
        
        if(!esDeMiPropiedad){
            tienePropietario = titulo.tienePropietario();
        }
        
        if(!esDeMiPropiedad && tienePropietario){
            encarcelado = titulo.propietarioEncarcelado();
        }
        
        if(!esDeMiPropiedad && tienePropietario && !encarcelado){
            estaHipotecada = titulo.getHipotecada();
        }
        
        return !esDeMiPropiedad && tienePropietario && !encarcelado && !estaHipotecada;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa intermedia = new Sorpresa(cartaLibertad.getTexto(), cartaLibertad.getValor(), cartaLibertad.getTipo());
        cartaLibertad = null;
        return intermedia;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificada = false;
        int costeEdificarCasa = titulo.getPrecioEdificar();
        
        if(puedoEdificarCasa(titulo)){
            titulo.edificarCasa();
            this.modificarSaldo(-costeEdificarCasa);
            edificada = true;
        }
        
        return edificada;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificado = false;
        
        if(puedoEdificarHotel(titulo)){
                titulo.edificarHotel();
                this.modificarSaldo(-titulo.getPrecioEdificar());
                edificado = true;
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
        Calle cas = (Calle) casillaActual;
        
        if(cas.getTitulo().getPropietario() != null){
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
        int costeHipoteca = titulo.hipotecar();
        modificarSaldo(costeHipoteca);
    }
    
    void irACarcel(Casilla casilla){
        setCasillaActual(casilla);
        setEncarcelado(true);
    }
    
    int modificarSaldo(int cantidad){
        return saldo+=cantidad;
    }
    
    int obtenerCapital(){
        int saldo_total = 0;
                
        for(int i=0; i<propiedades.size(); i++){
            saldo_total += propiedades.get(i).getPrecioCompra()
                    + (propiedades.get(i).getNumCasas()*propiedades.get(i).getPrecioEdificar())
                    + (propiedades.get(i).getNumHoteles()*propiedades.get(i).getPrecioEdificar());
            
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
        Calle cas = (Calle) casillaActual;
        int costeAlquiler = cas.pagarAlquiler();
        this.modificarSaldo(-costeAlquiler);
    }
    
    protected void pagarImpuesto(){
        this.saldo-=casillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        
        if(tengoSaldo){
            setEncarcelado(false);
            modificarSaldo(-cantidad);
        }
    }
    
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        boolean hayEspacio = titulo.getNumCasas() < 4;
        boolean tengoSaldo = false;
        
        if(hayEspacio){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarCasa);
        }
        
        return hayEspacio && tengoSaldo;
    }
    
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        int numHoteles = titulo.getNumHoteles();
        int numCasas = titulo.getNumCasas();
        boolean tengoSaldo = tengoSaldo(titulo.getPrecioEdificar());
        
        return numHoteles < 4 && tengoSaldo && numCasas >= 4;
    }
    
    void setCartaLibertad(Sorpresa carta){
        if(carta.getTipo() == TipoSorpresa.SALIRCARCEL) {
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
    
    protected boolean tengoSaldo(int cantidad){
        return this.saldo>cantidad;
    }
    
    void venderPropiedad(Casilla casilla){
        Calle cas = (Calle) casilla;
        eliminarDeMisPropiedades(cas.getTitulo());
        cas.getTitulo().setPropietario(null);
        int precioVenta = cas.getTitulo().calcularPrecioVenta();
        modificarSaldo(precioVenta);
    }
    
    @Override
    public String toString(){
        return "Jugador{ " + "nombre:" + nombre + " encarcelado:" + encarcelado +
                " saldo:" + Integer.toString(saldo) +" capital: " + this.obtenerCapital() + " cartaLibertad:"
                + cartaLibertad + " casillaActual:" + casillaActual + " propiedades:" + propiedades + "}";
    }
    
    @Override
    public int compareTo(Object otroJugador) {
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        
        return otroCapital-this.obtenerCapital();
    }
}
