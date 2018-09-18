/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author d3vcho
 */
public class PruebaQytetet {
    Qytetet juego = new Qytetet();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Qytetet.inicializarCartasSorpresa();
        Qytetet.getMazo().toString();
    }
    
}
