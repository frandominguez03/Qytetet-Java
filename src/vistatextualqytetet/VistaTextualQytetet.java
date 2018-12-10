package vistatextualqytetet;
import java.util.ArrayList;
import java.util.Scanner;
import controladorqytetet.ControladorQytetet;

public class VistaTextualQytetet {
    private static final Scanner in = new Scanner (System.in);
    private static ControladorQytetet controlador = ControladorQytetet.getInstance();

    public ArrayList<String> obtenerNombreJugadores(){
        ArrayList<String> lista = new ArrayList<>();
        int num_jugadores;
        
        System.out.println("Introduce el numero de jugadores:");
        num_jugadores = in.nextInt();
        
        for(int i=0; i<num_jugadores; i++){
            System.out.println("Introduce el nombre del jugador:");
            String s = in.next();
            lista.add(s);
        }
        
        return lista;
    }
    
    public int elegirCasilla(int opcionMenu){
        ArrayList<Integer> casillasValidas = controlador.obtenerCasillasValidas(opcionMenu);
        ArrayList<String> auxiliar = new ArrayList<>();
        
        if(casillasValidas.isEmpty()){
            return -1;
        }
        
        else{
            for(int i=0; i<casillasValidas.size(); i++){
                System.out.println("Casillas válidas: ");
                System.out.println(casillasValidas.get(i));
                auxiliar.add(Integer.toString(casillasValidas.get(i)));
            }
            
            return Integer.parseInt(leerValorCorrecto(auxiliar));
        }
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos){
        String valorCorrecto = null, introducido;
        boolean pertenece = false;
        
        System.out.println("Introduce una de las siguientes opciones:");
        for(int i=0; i<valoresCorrectos.size(); i++){
            System.out.println(valoresCorrectos.get(i));
        }
        
        introducido = in.next();      
        
        for(int i=0; i<valoresCorrectos.size() && !pertenece; i++){
            if(Integer.parseInt(introducido) == Integer.parseInt(valoresCorrectos.get(i))){
                pertenece = true;
                valorCorrecto = valoresCorrectos.get(i);
            }
        }
        
        if(!pertenece){
            valorCorrecto =  "El valor introducido no coincide con ninguna de las opciones";
        }
        
        return valorCorrecto;
    }
    
    public int elegirOperacion(){
        ArrayList<Integer> listaOpciones = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> convertidos = new ArrayList<>();
        
        for(int i=0; i<listaOpciones.size(); i++){
            convertidos.add(Integer.toString(listaOpciones.get(i)));
        }
        
        return Integer.parseInt(leerValorCorrecto(convertidos));       
    }
    
    public static void main(String args[]) {
    VistaTextualQytetet ui = new VistaTextualQytetet();
    controlador.setNombreJugadores(ui.obtenerNombreJugadores());
    
    int operacionElegida, casillaElegida = 0;
    boolean necesitaElegirCasilla;
    do {
        operacionElegida = ui.elegirOperacion();
        controlador.getEstado();
        necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
        if (necesitaElegirCasilla)
            casillaElegida = ui.elegirCasilla(operacionElegida);
        if (!necesitaElegirCasilla || casillaElegida >= 0)
            System.out.println(controlador.realizarOperacion(operacionElegida, casillaElegida));
        } while (1 == 1);
    }
}
