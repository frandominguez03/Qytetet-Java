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
public class Sorpresa {
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    public Sorpresa(String nuevoTexto, int nuevoValor, TipoSorpresa tSorpresa){
        texto = nuevoTexto;
        tipo = tSorpresa;
        valor = nuevoValor;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public TipoSorpresa getTipo(){
        return tipo;
    }
    
    public int getValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        return "Sorpresa{" + "texto=" + texto + "valor=" + Integer.toString(valor)
                + "tipo=" + tipo + "}";
    }
    
    
}
