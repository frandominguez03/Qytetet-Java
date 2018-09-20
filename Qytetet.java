package modeloqytetet;
import java.util.ArrayList;

public class Qytetet {
    private static ArrayList<Sorpresa> mazo = new ArrayList<>();
    
    public static ArrayList getMazo(){
        return mazo;
    }
    
    public static void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa ("Te han pillado saqueando las arcas públicas del estado, vas a la cárcel.", 9, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa ("No sabemos si estabas cerca de la casilla inicial o no, pero ahora lo vas a estar.", 1, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa ("¿Eres supersticioso?", 13, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa ("Resulta que un funcionario de la cárcel es amigo tuyo. De casualidades está hecha la vida. Sales de la cárcel.", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa ("Tus rivales te odian tanto que les obligamos a que te den lo que lleven suelto en la cartera.", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa ("Parece que te está gustando el juego, por eso tendrás que recompensar a tus rivales.", -300, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa ("¡Enhorabuena! Te ha tocado la lotería, pero la agencia tributaria se va a quedar casi todo.", 250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa ("Vamos a jugar a algo, tú me das algo de dinero y yo no te doy nada. ¿Qué te parece?", -250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa ("Vaya, esta sorpresa parece que te va a quitar algo de dinero por los hoteles y casas de tus rivales, siempre y cuando tú estés de acuerdo... o no.", -150, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa ("Estás de suerte. Tus propiedades acaban de evadir impuestos y te dan algo más de dinero extra.", 200, TipoSorpresa.PORCASAHOTEL));
    }
}
