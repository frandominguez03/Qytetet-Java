package modeloqytetet;
import java.util.ArrayList;
public class PruebaQytetet {
    private static Qytetet juego=new Qytetet();
    
    private static ArrayList<Sorpresa>MayorCero(ArrayList<Sorpresa>juego)
    {
        ArrayList<Sorpresa>mayorq0=new ArrayList();
                
        for (Sorpresa t: juego) 
        {
          if(t.getValor()>0)
          {
               mayorq0.add(t);
          }  
        }
        return mayorq0;
    }
    
    private static ArrayList<Sorpresa>TipoCasilla(ArrayList<Sorpresa>juego)
    {
        ArrayList<Sorpresa>tipoCasilla=new ArrayList();
               
        for (Sorpresa t: juego) 
        {
          if(t.getSorpresa()==TipoSorpresa.IRACASILLA)
          {
              tipoCasilla.add(t);
          }  
        }
        return tipoCasilla;
    }
    
    private static ArrayList<Sorpresa>TipoSorpresa(ArrayList<Sorpresa>juego,TipoSorpresa sorp)
    {
        ArrayList<Sorpresa>tipoSorpresa=new ArrayList();
               
        for (Sorpresa t: juego) 
        {
          if(t.getSorpresa()==sorp)
          {
              tipoSorpresa.add(t);
          }  
        }
        return tipoSorpresa;
    }
    public static void main(String[] args) {
       Qytetet.inicializarCartasSorpresa();
       Tablero tab = new Tablero();
       System.out.println(Qytetet.getMazo().toString());
       System.out.println(MayorCero(Qytetet.getMazo()));
       System.out.println(TipoCasilla(Qytetet.getMazo()));
       
       for(TipoSorpresa t: TipoSorpresa.values()){
           System.out.println (TipoSorpresa(Qytetet.getMazo(),t));
       }
       
       System.out.println(tab);
        
        
        
    }
    
}
