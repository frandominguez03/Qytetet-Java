package modeloqytetet;
import java.util.ArrayList;
public class Qytetet {
    private static ArrayList<Sorpresa> mazo = new ArrayList<>(); 
    private static Tablero tablero;
    public static int MAX_JUGADORES = 4;
    static int NUM_SORPRESAS = 10;
    public static int NUM_CASILLAS = 20;
    static int PRECIO_LIBERTAD = 200;
    static int SALDO_SALIDA = 1000;
    
    void actuarSiEnCasillaEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void actuarSiEnCasillaNoEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void aplicarSorpresa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        
    }
    
    public boolean edificarCasa(int numeroCasilla){
        
    }
    
    public boolean edificarHotel(int numeroCasilla){
        
    }
    
    private void encarcelarJugador(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Sorpresa getCartaActual(){ // Hay que hacerlo
        return mazo;
    }
    
    Dado getDado(){ // Hay que hacerlo
        
    }
    
    Jugador getJugadorActual(){ // Hay que hacerlo
        
    }
    
    public Jugador getJugadores(){ // Hay que hacerlo
        
    }
    
    
    public ArrayList getMazo(){
        return mazo;   
    }
    
    public int getValorDado(){
        
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        
    }
    
    private void inicializarCartasSorpresa(){
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
    
    public void inicializarJuego(String nombres){ // Hay que hacerlo
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void inicializarJugadores(String nombres){ // Hay que hacerlo
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        
    }
    
    public void jugar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    protected void mover(int numCasillaDestino){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        
    }
    
    public Casilla obtenerCasillasTablero(){
        
    }
    
    public int obtenerPropiedadesJugador(){
        
    }
    
    public int obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca){
        
    }
    
    public void obtenerRanking(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int obtenerSaldoJugadorActual(){
        
    }
    
    private void salidaJugadores(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setCartaActual(){ // Hay que hacerla
        
    }
    
    public void siguienteJugador(){
        
    }
    
    int tirarDado(){
        
    }
    
    public boolean venderPropiedad(int numeroCasilla){
        
    }
}
