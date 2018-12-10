//package modeloqytetet;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PruebaQytetet {
//    private static Qytetet juego = Qytetet.getInstance();
//    private static final Scanner in = new Scanner (System.in);
//    
//    private static ArrayList<Sorpresa> MayorCero(ArrayList<Sorpresa> juego)
//    {
//        ArrayList<Sorpresa> mayorq0 = new ArrayList();
//                
//        for (Sorpresa t: juego) 
//        {
//          if(t.getValor()>0)
//          {
//               mayorq0.add(t);
//          }  
//        }
//        return mayorq0;
//    }
//    
//    private static ArrayList<Sorpresa> TipoCasilla(ArrayList<Sorpresa> juego)
//    {
//        ArrayList<Sorpresa> tipoCasilla = new ArrayList();
//               
//        for (Sorpresa t: juego) 
//        {
//          if(t.getTipo()==TipoSorpresa.IRACASILLA)
//          {
//              tipoCasilla.add(t);
//          }  
//        }
//        return tipoCasilla;
//    }
//    
//    private static ArrayList<Sorpresa> TipoSorpresa(ArrayList<Sorpresa> juego, TipoSorpresa sorp)
//    {
//        ArrayList<Sorpresa> tipoSorpresa = new ArrayList();
//               
//        for (Sorpresa t: juego) 
//        {
//          if(t.getTipo()==sorp)
//          {
//              tipoSorpresa.add(t);
//          }  
//        }
//        return tipoSorpresa;
//    }
//    
//    private static ArrayList<String> getNombreJugadores(){
//        ArrayList<String> lista = new ArrayList<>();
//        int num_jugadores;
//        
//        System.out.println("Introduce el numero de jugadores:");
//        num_jugadores = in.nextInt();
//        
//        for(int i=0; i<num_jugadores; i++){
//            System.out.println("Introduce el nombre del jugador:");
//            String s = in.next();
//            lista.add(s);
//        }
//        
//        return lista;
//    } 
//    
//    public static void main(String[] args) {
//        // Inicializaciones
//       ArrayList <String> nombres = new ArrayList<>();
//       nombres = getNombreJugadores();
//       juego.inicializarJuego(nombres);
//       Tablero tab = new Tablero();
       
       // Imprime el mazo y los métodos de la clase Qytetet
       /*System.out.println("Imprimimos el mazo y los métodos de la clase Qytetet");
       System.out.println(juego.getMazo().toString());
       System.out.println(MayorCero(juego.getMazo()));
       System.out.println(TipoCasilla(juego.getMazo()));
       
       for(TipoSorpresa t: TipoSorpresa.values()){
           System.out.println (TipoSorpresa(juego.getMazo(),t));
       }/*
       
       // Imprime el tablero
       /*System.out.println("Imprimimos el tablero");
       System.out.println(tab);*/
       
       // Imprime la única instancia de Qytetet
       /*System.out.println("Imprimimos la instancia Qytetet");
       System.out.println(juego);*/
       
       // Vamos a caer en todas las Sorpresas
//       juego.jugar();
//       juego.mover(2);
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       juego.aplicarSorpresa();
//       
//       juego.mover(8);
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       System.out.println(juego.getCartaActual());
//       juego.aplicarSorpresa();
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       
//       juego.mover(16);
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       juego.aplicarSorpresa();
//       
//       juego.mover(9);
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       
       // Probando a hipotecar, cancelar hipoteca, edificar...
//       juego.jugar();
//       juego.hipotecarPropiedad(5);
//       juego.cancelarHipoteca(5);
//       juego.venderPropiedad(5);
//       juego.comprarTituloPropiedad();
//       juego.edificarCasa(7);
       
       // Probar a salir de la cárcel
//       juego.getJugadorActual().irACarcel(juego.obtenerCasillasTablero().get(14));
//       System.out.println(juego.getJugadorActual().getCasillaActual());
//       if(juego.getJugadorActual().tengoCartaLibertad()){
//           juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
//       }
//       
//       else{
//           boolean consigue = juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
//           
//           if(consigue){
//               System.out.println("Consigue salir de la cárcel");
//           }
//           
//           else{
//               System.out.println("Al palo");
//           }
//       }
       
       // Probar obtener ránking
//       juego.jugar();
//       System.out.println(juego.getJugadores());
//       juego.getJugadorActual().modificarSaldo(-300);
//       juego.siguienteJugador();
//       juego.getJugadorActual().modificarSaldo(300);
//       juego.obtenerRanking();
//       System.out.println(juego.getJugadores());

//        // Probamos la clase Especulador
//        juego.jugar();
//        juego.mover(2); // La primera casilla de tipo sorpresa
//        juego.aplicarSorpresa();
//        System.out.println(juego.getJugadorActual());
//    }
//    
//}
