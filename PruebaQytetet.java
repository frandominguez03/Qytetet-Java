package modeloqytetet;
import java.util.ArrayList;

public class PruebaQytetet {
    private static Qytetet juego = new Qytetet();
    
    private static ArrayList<Sorpresa> mayorQueCero(ArrayList<Sorpresa> mazo){
        ArrayList<Sorpresa> mayorCero = new ArrayList<>();

        for(Sorpresa t: mazo){
            if(t.getValor() > 0){
                mayorCero.add(t);
            }
        }
        return mayorCero;
    }
    
    private static ArrayList<Sorpresa> tipoCasilla(ArrayList<Sorpresa> mazo){
        ArrayList<Sorpresa> tipoCasilla = new ArrayList<>();

        for(Sorpresa t: mazo){
            if(t.getTipo() == TipoSorpresa.IRACASILLA){
                tipoCasilla.add(t);
            }
        }
        return tipoCasilla;
    }
    
    private static ArrayList<Sorpresa> tipoSorpresa(ArrayList<Sorpresa> mazo, TipoSorpresa tipo){
        ArrayList<Sorpresa> tipoSorpresa = new ArrayList<>();

        for(Sorpresa t: mazo){
            if(t.getTipo() == tipo){
                tipoSorpresa.add(t);
            }
        }
        return tipoSorpresa;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Qytetet.inicializarCartasSorpresa();
        System.out.println(Qytetet.getMazo());
        
        System.out.println(mayorQueCero(Qytetet.getMazo()));
        System.out.println(tipoCasilla(Qytetet.getMazo()));
        
        for(TipoSorpresa t: TipoSorpresa.values()){
            System.out.println(tipoSorpresa(Qytetet.getMazo(), t));
        }
    }
    
}
