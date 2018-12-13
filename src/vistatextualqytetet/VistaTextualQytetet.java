package vistatextualqytetet;
import java.util.ArrayList;
import java.util.Scanner;
import controladorqytetet.ControladorQytetet;
import controladorqytetet.OpcionMenu;

public class VistaTextualQytetet {
    private static final Scanner in = new Scanner (System.in);
    private static ControladorQytetet controlador = ControladorQytetet.getInstance();

    public ArrayList<String> obtenerNombreJugadores(){
        ArrayList<String> lista = new ArrayList<>();
        int num_jugadores;
        
        do{
            System.out.println("Introduce el numero de jugadores:");
            num_jugadores = in.nextInt();
        }while(num_jugadores < 2);
        
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
            System.out.println("Casillas válidas: ");
            for(int i=0; i<casillasValidas.size(); i++){               
                System.out.println(casillasValidas.get(i));
                auxiliar.add(Integer.toString(casillasValidas.get(i)));
            }
            
            return Integer.parseInt(leerValorCorrecto(auxiliar, false));
        }
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos, boolean opcion){
        String valorCorrecto = null, introducido;
        boolean pertenece = false;
        
        System.out.println("Introduce una de las siguientes opciones:");
        if(opcion){
            for(int i=0; i<valoresCorrectos.size(); i++){
                System.out.println(valoresCorrectos.get(i) + " - " + OpcionMenu.values()[Integer.parseInt(valoresCorrectos.get(i))]);
            }
        }
        
        else{
            for(int i=0; i<valoresCorrectos.size(); i++){
                System.out.println("Casilla: " + valoresCorrectos.get(i));
            }
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
        
        return Integer.parseInt(leerValorCorrecto(convertidos, true));       
    }
    
    public static void main(String args[]) {
    VistaTextualQytetet ui = new VistaTextualQytetet();
    controlador.setNombreJugadores(ui.obtenerNombreJugadores());
    
    int operacionElegida, casillaElegida = 0;
    boolean necesitaElegirCasilla;
    do {
        operacionElegida = ui.elegirOperacion();
        necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
        if (necesitaElegirCasilla)
            casillaElegida = ui.elegirCasilla(operacionElegida);
        if (!necesitaElegirCasilla || casillaElegida >= 0)
            System.out.println(controlador.realizarOperacion(operacionElegida, casillaElegida));
        } while (1 == 1);
    }
}
