package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;
public class PruebaQytetet {
    private static Qytetet juego = Qytetet.getInstance();
    private static final Scanner in = new Scanner (System.in);
    
    private static ArrayList<Sorpresa> MayorCero(ArrayList<Sorpresa> juego)
    {
        ArrayList<Sorpresa> mayorq0 = new ArrayList();
                
        for (Sorpresa t: juego) 
        {
          if(t.getValor()>0)
          {
               mayorq0.add(t);
          }  
        }
        return mayorq0;
    }
    
    private static ArrayList<Sorpresa> TipoCasilla(ArrayList<Sorpresa> juego)
    {
        ArrayList<Sorpresa> tipoCasilla = new ArrayList();
               
        for (Sorpresa t: juego) 
        {
          if(t.getTipo()==TipoSorpresa.IRACASILLA)
          {
              tipoCasilla.add(t);
          }  
        }
        return tipoCasilla;
    }
    
    private static ArrayList<Sorpresa> TipoSorpresa(ArrayList<Sorpresa> juego, TipoSorpresa sorp)
    {
        ArrayList<Sorpresa> tipoSorpresa = new ArrayList();
               
        for (Sorpresa t: juego) 
        {
          if(t.getTipo()==sorp)
          {
              tipoSorpresa.add(t);
          }  
        }
        return tipoSorpresa;
    }
    
    private static String getNombreJugadores(){
        String s = in.nextLine();
        
        return s;
    } 
    
    public static void main(String[] args) {
        // Inicializaciones
       juego.inicializarCartasSorpresa();
       Tablero tab = new Tablero();
       
       // Imprime el mazo y los métodos de la clase Qytetet
       System.out.println(juego.getMazo().toString());
       System.out.println(MayorCero(juego.getMazo()));
       System.out.println(TipoCasilla(juego.getMazo()));
       
       for(TipoSorpresa t: TipoSorpresa.values()){
           System.out.println (TipoSorpresa(juego.getMazo(),t));
       }
       
       // Imprime el tablero
       System.out.println(tab);
        
       // Imprime todos los jugadores
       System.out.println();
       
       // Imprime la única instancia de Qytetet
       System.out.println(juego);
        
    }
    
}
