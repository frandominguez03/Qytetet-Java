/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author david
 */
public class Casilla {
    private int numeroCasilla;
    private int precioCompra;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    public Casilla(TipoCasilla un_tipo, int numCasilla, TituloPropiedad un_titulo){
        this.numeroCasilla = numCasilla;
        
        if(tipo == TipoCasilla.CALLE){
            setTitulo(un_titulo);
            this.tipo = un_tipo;
            precioCompra = titulo.getPrecioCompra();
        }
    }
    
    public Casilla(TipoCasilla un_tipo, int numCasilla){
        numeroCasilla = numCasilla;
        
        if(tipo != TipoCasilla.CALLE){
            this.tipo = un_tipo;
            precioCompra = 0;
        }
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        if(this.tipo == TipoCasilla.CALLE){
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", precioCompra=" + precioCompra + ", tipo=" + tipo + ", titulo=" + titulo + '}';
        }
        
        else{
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", precioCompra=" + precioCompra + ", tipo=" + tipo + '}';
        }
    }
    
    

}
