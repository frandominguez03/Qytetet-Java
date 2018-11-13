package modeloqytetet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    private static ArrayList<Sorpresa> mazo = new ArrayList<>(); 
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Tablero tablero;
    private static Dado dado = Dado.getInstance();
    private Sorpresa cartaActual;
    private Jugador jugadorActual;
    private MetodoSalirCarcel metodo;
    private EstadoJuego estado;
    
    public static int MAX_JUGADORES = 4;
    static int NUM_SORPRESAS = 10;
    public static int NUM_CASILLAS = 20;
    static int PRECIO_LIBERTAD = 200;
    static int SALDO_SALIDA = 1000;
    
    private Qytetet(){
        mazo = new ArrayList<>();
    }
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    void actuarSiEnCasillaEdificable(){
        boolean deboPagar = jugadorActual.deboPagarAlquiler();
        jugadorActual.setCasillaActual(obtenerCasillaJugadorActual());
        
        if(deboPagar){
            jugadorActual.pagarAlquiler();
            
            if(jugadorActual.getSaldo() < 0){
                setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
            }
        }
        
        Casilla casilla = obtenerCasillaJugadorActual();
        boolean tengoPropietario = jugadorActual.getCasillaActual().tengoPropietario();
        
        if(estado != EstadoJuego.ALGUNJUGADORENBANCARROTA){
            if(tengoPropietario){
                setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
            }
            
            else{
                setEstadoJuego(EstadoJuego.JA_PUEDECOMPRAROGESTIONAR);
            }
        }
    }
    
    void actuarSiEnCasillaNoEdificable(){
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        Casilla casillaActual = jugadorActual.getCasillaActual();
        
        if(jugadorActual.getCasillaActual().getTipo() == TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }
        
        else{
            if(jugadorActual.getCasillaActual().getTipo() == TipoCasilla.JUEZ){
                encarcelarJugador();
            }
            
            else{
                cartaActual = mazo.get(0);
                mazo.remove(0);
                setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
            }
        }
    }
    
    public void aplicarSorpresa(){
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        if(cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            jugadorActual.setCartaLibertad(cartaActual);
        }
        
        else{
            mazo.add(cartaActual);
            
            if(null != cartaActual.getTipo())switch (cartaActual.getTipo()) {
            case PAGARCOBRAR:
                jugadorActual.modificarSaldo(cartaActual.getValor());
                if(jugadorActual.getSaldo() < 0){
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }   break;
            case IRACASILLA:
                int valor = cartaActual.getValor();
                boolean casillaCarcel = tablero.esCasillaCarcel(valor);
                if(casillaCarcel){
                    encarcelarJugador();
                }
                
                else{
                    mover(valor);
                }
                break;
            case PORCASAHOTEL:
                int cantidad = cartaActual.getValor();
                int numeroTotal = jugadorActual.cuantasCasasHotelesTengo();
                jugadorActual.modificarSaldo(numeroTotal*cantidad);
                if(jugadorActual.getSaldo() < 0){
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
                break;
            case PORJUGADOR:
                for(int i=0; i<MAX_JUGADORES-1; i++){
                    siguienteJugador();
                    
                    jugadorActual.modificarSaldo(cartaActual.getValor());
                    
                    if(jugadorActual.getSaldo() < 0){
                        setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    }
                }
                break;
            default:
                break;
            }
        }
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        boolean puedeCancelar = jugadorActual.cancelarHipoteca(titulo);
        
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return puedeCancelar;
    }
    
    public boolean comprarTituloPropiedad(){
        if(jugadorActual.comprarTituloPropiedad()){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        return jugadorActual.comprarTituloPropiedad();
    }
    
    public boolean edificarCasa(int numeroCasilla){
        boolean edificada = false;
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        jugadorActual.edificarCasa(titulo);
        int numCasas = titulo.getNumCasas();
        
        if(numCasas < 4){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            boolean tengoSaldo = jugadorActual.tengoSaldo(costeEdificarCasa);
            
            if(tengoSaldo){
                numCasas++;
                titulo.edificarCasa();
                jugadorActual.modificarSaldo(-costeEdificarCasa);
                edificada = true;
            }
        }
        
        if(edificada){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        return edificada;
    }
    
    public boolean edificarHotel(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        boolean edificado = false;
        
        if(casilla.getTipo() == TipoCasilla.CALLE && titulo.getNumCasas() == 4){
            edificado = jugadorActual.edificarHotel(titulo);
            
            if(edificado){
               setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR); 
            }
        }
        
        return edificado;
    }
    
    private void encarcelarJugador(){
        if(!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            jugadorActual.irACarcel(casillaCarcel);            
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }
        
        else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual;
    }
    
    Dado getDado(){
        return Dado.getInstance();
    }
    
    Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public ArrayList getMazo(){
        return mazo;   
    }
    
    public int getValorDado(){
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        jugadorActual.hipotecarPropiedad(titulo);
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }
    
    private static void inicializarCartasSorpresa(){
        inicializarTablero();
            mazo.add(new Sorpresa ("Te hemos pillado con las manos en los sobres, lo sentimos, ¡debes ir a la carcel!", 
                    tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
            
            mazo.add(new Sorpresa ("Pides un Uber que te lleva la casilla mitad del tablero",
                    10, TipoSorpresa.IRACASILLA));
            
            mazo.add(new Sorpresa ("Alquilas una bici amarilla que te lleva a la casilla 5, luego la tiras al río",
                    5, TipoSorpresa.IRACASILLA));
            
            mazo.add(new Sorpresa ("Pides a la gente que te de dinero para comprar un regalo en común, "
                    + "pero acabas quedándotelo tu para ir a Pedro",
                    200, TipoSorpresa.PORJUGADOR));
            
            mazo.add(new Sorpresa ("Dijiste que invitarías a chupitos pero no lo hiciste, pagas 50 euros a cada uno",
                    50, TipoSorpresa.PORJUGADOR));
            
            mazo.add(new Sorpresa ("Recibes un sobre con la letra B escrita, recibes 500 euros",
                    500, TipoSorpresa.PAGARCOBRAR));
            
            mazo.add(new Sorpresa ("Te vas a la ruleta, crees ganar pero el ruso de al lado te hace la jugada, pierdes 200 euros",
                    200, TipoSorpresa.PAGARCOBRAR));
           
            mazo.add(new Sorpresa ("Gracias a la burbuja del alquiler, la gente compra más casas "
                    + "y hay más turistas en hoteles, ganas 300 euros.",
                    300, TipoSorpresa.PORCASAHOTEL));
           
            mazo.add(new Sorpresa ("Mala suerte, Hacienda te ha pillado saltándote la declaración de bienes, debes 500 euros",
                    500, TipoSorpresa.PORCASAHOTEL));
           
            mazo.add(new Sorpresa ("Un afiliado de tu partido intercede. Sales de la cárcel",
                    0, TipoSorpresa.SALIRCARCEL));
    }
    
    public void inicializarJuego(ArrayList<String> nombres){
            inicializarTablero();
            inicializarCartasSorpresa();
            inicializarJugadores(nombres);
            salidaJugadores();
    }
    
    private static void inicializarJugadores(ArrayList<String> nombres){
        for(int i=0; i<nombres.size(); i++){
                jugadores.add(new Jugador(nombres.get(i)));
            }
    }
    
    private static void inicializarTablero(){
        tablero = new Tablero();
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            System.out.println("Tirando dado...");
            int resultado = tirarDado();
            System.out.println("El resultado es: " + resultado);
            
            if(resultado >= 5){
                jugadorActual.setEncarcelado(false);
            }
        }
        
        else{
            if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
                jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
            }
        }
        
        boolean encarcelado = jugadorActual.getEncarcelado();
        
        if(encarcelado){
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }
        
        else{
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        }
        
        return encarcelado;
    }
    
    public boolean jugadorActualEnCalleLibre(){
        boolean resultado = false;
        
        if(jugadorActual.getCasillaActual().soyEdificable() == true &&
                jugadorActual.getCasillaActual().getTitulo().getPropietario() != null){
            resultado = true;
        }
        
        return resultado;
    }
    
    public boolean jugadorActualEncarcelado(){
        return jugadorActual.getEncarcelado();
    }
    
    public void jugar(){
        int valor = tirarDado();
        int casilla = tablero.obtenerCasillaFinal(jugadorActual.getCasillaActual(), valor).getNumeroCasilla();
        mover(casilla);
    }
    
    void mover(int numCasillaDestino){
        Casilla casillaInicial = jugadorActual.getCasillaActual();
        Casilla casillaFinal = tablero.obtenerCasillaNumero(numCasillaDestino);
        jugadorActual.setCasillaActual(casillaFinal);
        
        if(numCasillaDestino < casillaInicial.getNumeroCasilla()){
            jugadorActual.modificarSaldo(SALDO_SALIDA);
        }
        
        if(casillaFinal.soyEdificable()){
            actuarSiEnCasillaEdificable();
        }
        
        else{
            actuarSiEnCasillaNoEdificable();
        }
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        return jugadorActual.getCasillaActual();
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero(){
        return tablero.getCasillas();
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador(){
        ArrayList<Integer> casillas = new ArrayList<>();
        String nombre;
        
        for(int i=0; i< jugadorActual.getPropiedades().size(); i++){
            nombre = jugadorActual.getPropiedades().get(i).getNombre();
            casillas.add(obtenerCasillasTablero().indexOf(nombre));
        }
        
        return casillas;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca){
        ArrayList<Integer> casillas = new ArrayList<>();
        String nombre;
        
        for (int i=0; i<jugadorActual.getPropiedades().size(); i++){
            if(jugadorActual.getPropiedades().get(i).getHipotecada() == estadoHipoteca){
                nombre = jugadorActual.getPropiedades().get(i).getNombre();
                casillas.add(obtenerCasillasTablero().indexOf(nombre));
            }
        }
        
        return casillas;
    }
    
    public void obtenerRanking(){
        Collections.sort(jugadores);
    }
    
    public int obtenerSaldoJugadorActual(){
        return jugadorActual.getSaldo();
    }
    
    private void salidaJugadores(){
        for(int i=0; i<jugadores.size(); i++){
            jugadores.get(i).setCasillaActual(tablero.obtenerCasillaNumero(0));
        }
        
        Random  jug_aleatorio = new Random();
        int jugador = jug_aleatorio.nextInt(jugadores.size())+1;
        
        jugadorActual = jugadores.get(jugador);
        
        setEstadoJuego(EstadoJuego.JA_PREPARADO);
    }
    
    private void setCartaActual(Sorpresa cartaActual){
        this.cartaActual = cartaActual;
    }
    
    public void setEstadoJuego(EstadoJuego estado){
        this.estado = estado;
    }
    
    public void siguienteJugador(){
        int indice = jugadores.indexOf(jugadorActual);
        jugadorActual = jugadores.get((indice+1)%jugadores.size());
        
        if(jugadorActual.getEncarcelado()){
            setEstadoJuego(EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD);
            intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
            intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
        }
        
        else{
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        }
    }
    
    private int tirarDado(){
            return dado.tirar();
    }
    
    public void venderPropiedad(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        jugadorActual.venderPropiedad(casilla);
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }
    
    @Override
    public String toString(){
        return "Tablero: {" + tablero + "}, Mazo: {" + mazo + "}, cartaActual: {" + cartaActual +
                "}, jugadorActual: {" + jugadorActual + "}";
    }
}
