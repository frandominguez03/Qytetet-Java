package controladorqytetet;
import java.util.ArrayList;
import modeloqytetet.EstadoJuego;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;

public class ControladorQytetet {
    private static final ControladorQytetet instance = new ControladorQytetet();
    private ArrayList<String> nombreJugadores = new ArrayList<>();
    private static Qytetet modelo = Qytetet.getInstance();
    private EstadoJuego estado;
    private MetodoSalirCarcel metodo;
    
    private ControladorQytetet(){
        this.nombreJugadores = new ArrayList<>();
        this.estado = null;
    }
    
    public static ControladorQytetet getInstance(){
        return instance;
    }
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores){
        this.nombreJugadores = nombreJugadores;
        modelo.inicializarJuego(nombreJugadores);
    }

    public EstadoJuego getEstado() {
        return estado;
    }
    
    public Qytetet getModelo(){
        return modelo;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas(){
        ArrayList<Integer> operacionesValidas = new ArrayList<>();
        estado = modelo.getEstadoJuego();
        
        if(this.nombreJugadores.isEmpty()){
            operacionesValidas.add(OpcionMenu.INICIARJUEGO.ordinal());
            
            return operacionesValidas;
        }
        
        switch(estado){            
            case JA_ENCARCELADO:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                break;
            case JA_ENCARCELADOCONOPCIONDELIBERTAD:
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                break;
            case JA_PREPARADO:
                operacionesValidas.add(OpcionMenu.JUGAR.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                break;
            case JA_PUEDEGESTIONAR:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
                if(!modelo.obtenerPropiedadesJugador().isEmpty()){
                    operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                    operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                    operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                }
                break;
            case JA_CONSORPRESA:
                operacionesValidas.add(OpcionMenu.APLICARSORPRESA.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                break;
            case JA_PUEDECOMPRAROGESTIONAR:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());               
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
                if(!modelo.obtenerPropiedadesJugador().isEmpty()){
                    operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                    operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                    operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                }
                break;
            case ALGUNJUGADORENBANCARROTA:
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                break;
        }
        
        return operacionesValidas;       
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu){
        boolean necesita_elegir = false;

        if(opcionMenu == OpcionMenu.HIPOTECARPROPIEDAD.ordinal() ||
           opcionMenu == OpcionMenu.VENDERPROPIEDAD.ordinal() ||
           opcionMenu == OpcionMenu.CANCELARHIPOTECA.ordinal() ||
           opcionMenu == OpcionMenu.EDIFICARCASA.ordinal() ||
           opcionMenu == OpcionMenu.EDIFICARHOTEL.ordinal()){
            necesita_elegir = true;
        }
        
        return necesita_elegir;
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu){
        ArrayList<Integer> casillasValidas = new ArrayList<>();
        
        if(opcionMenu == OpcionMenu.HIPOTECARPROPIEDAD.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false);
        }
        
        else if(opcionMenu == OpcionMenu.EDIFICARCASA.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.EDIFICARHOTEL.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.VENDERPROPIEDAD.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.CANCELARHIPOTECA.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true);
        }
        
        return casillasValidas;        
    }
    
    public String realizarOperacion(int opcionElegida, int casillaElegida){
        String resultado = "";
        
        switch(opcionElegida){
            case 0: // INICIARJUEGO
                modelo.inicializarJuego(nombreJugadores);
                resultado = "Iniciando juego...";
                break;
            case 1: // JUGAR
                modelo.jugar();
                resultado = "Valor del dado: " + modelo.getValorDado() + ", Casilla actual: " + modelo.obtenerCasillaJugadorActual();
                break;
            case 2: // APLICARSORPRESA                
                modelo.aplicarSorpresa();
                resultado = "La sorpresa es: " + modelo.getCartaActual();
                break;
            case 3: // INTENTARSALIRCARCELPAGANDOLIBERTAD
                metodo = MetodoSalirCarcel.PAGANDOLIBERTAD;
                boolean salido_carta = modelo.intentarSalirCarcel(metodo);
                
                if(salido_carta){
                    resultado = "¡Has conseguido salir de la cárcel!";
                }
                
                else{
                    resultado = "¡Mala suerte! La próxima vez será";
                }
                break;
            case 4: // INTENTARSALIRCARCELTIRANDODADO
                metodo = MetodoSalirCarcel.TIRANDODADO;
                boolean salido_dado = modelo.intentarSalirCarcel(metodo);
                
                if(salido_dado){
                    resultado = "¡Has conseguido salir de la cárcel!";
                }
                
                else{
                    resultado = "¡Mala suerte! La próxima vez será";
                }
                break;
            case 5: // COMPRARTITULOPROPIEDAD
                boolean comprar_titulo = modelo.comprarTituloPropiedad();
                System.out.println(comprar_titulo);
                if(comprar_titulo){
                    resultado = "Comprando titulo de propiedad de la casilla actual";
                }
                
                else{
                    resultado = "No se ha podido comprar el titulo de la propiedad";
                }
                break;
            case 6: // HIPOTECARPROPIEDAD
                modelo.hipotecarPropiedad(casillaElegida);
                resultado = "Hipotecando la propiedad de la casilla actual";
                break;
            case 7: // CANCELARHIPOTECA
                boolean cancelar_hipoteca = modelo.cancelarHipoteca(casillaElegida);
                
                if(cancelar_hipoteca){
                    resultado = "Cancelando la hipoteca de la propiedad de la casilla actual";
                }
                
                else{
                    resultado = "No se ha podido cancelar la hipoteca...";
                }
                break;
            case 8: // EDIFICARCASA
                boolean edifica_casa = modelo.edificarCasa(casillaElegida);
                
                if(edifica_casa){
                    resultado = "Edificando casa en la casilla ";
                }
                
                else{
                    resultado = "No se ha podido edificar la casa...";
                }
                break;
            case 9: // EDIFICARHOTEL
                boolean edifica_hotel = modelo.edificarHotel(casillaElegida);
                
                if(edifica_hotel){
                    resultado = "Edificando hotel en la casilla actual";
                }
                
                else{
                    resultado = "No se ha podido edificar el hotel...";
                }
                break;
            case 10: // VENDERPROPIEDAD
                modelo.venderPropiedad(casillaElegida);
                resultado = "Vendiendo la propiedad de la casilla actual";
                break;
            case 11: // PASARTURNO
                modelo.siguienteJugador();
                resultado = "Pasando el turno...";
                break;
            case 12: // OBTENERRANKING
                modelo.obtenerRanking();
                System.out.println(modelo.getJugadores().toString());
                break;
            case 13: // TERMINARJUEGO
                System.out.println("Terminando juego...");
                modelo.obtenerRanking();
                System.out.println(modelo.getJugadores());
                System.exit(0);
                break;
            case 14: // MOSTRARJUGADORACTUAL
                System.out.println(modelo.getJugadorActual());
                break;
            case 15: // MOSTRARJUGADORES
                System.out.println(modelo.getJugadores());
                break;
            case 16: // MOSTRARTABLERO
                System.out.println(modelo.getTablero().toString());
                break;
            default:
                break;
        }
        
        return resultado;      
    }
}
