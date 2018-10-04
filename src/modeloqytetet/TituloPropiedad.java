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
public class TituloPropiedad {
    private String Nombre;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private boolean hipotecada;
    private int numHoteles;
    private int numCasas;
    
    
    public TituloPropiedad(String nombre,int precioC,int alquilerB,float factorR,int hipotecaB,int precioE)
    {
        Nombre=nombre;
        precioCompra=precioC;
        alquilerBase=alquilerB;
        factorRevalorizacion=factorR;
        hipotecaBase=hipotecaB;
        precioEdificar=precioE;
        hipotecada=false;
        numHoteles=0;
        numCasas=0;
                       
    }

    @Override
    public String toString() {
        return "TituloPropiedad{" + "Nombre=" + Nombre + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase 
                + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase 
                + ", precioEdificar=" + precioEdificar + ", hipotecada=" + hipotecada 
                + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + '}';
    }
    
    int calcularCosteCancelar(){
        
    }
    
    int calcularCosteHipotecar(){
        
    }
    
    int calcularImporteAlquiler(){
        
    }
    
    int calcularPrecioVenta(){
        
    }
    
    int cancelarHipoteca(){
        
    }
    
    void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        
    }
    
    void edificarHotel(){
        
    }

    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    String getNombre() {
        return Nombre;
    }

    boolean getHipotecada() {
        return hipotecada;
    }

    int getPrecioCompra() {
        return precioCompra;
    }

    int getAlquilerBase() {
        return alquilerBase;
    }

    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    int getPrecioEdificar() {
        return precioEdificar;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    int getNumCasas() {
        return numCasas;
    }
    
    Jugador getPropietario(){ // Hay que hacerla
        
    }
    
    int hipotecar(){
        
    }
    
    int pagarAlquiler(){
        
    }
    
    boolean propietarioEncarcelado(){
        
    }
    
    void Jugador setPropietario(Jugador propietario){ // Hay que hacerla
        
    }
    
    boolean tengoPropietario(){
        
    }
}
