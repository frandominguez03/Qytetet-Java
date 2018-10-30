package modeloqytetet;
import java.util.ArrayList;

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
    
    private Jugador propietario;
    private ArrayList<TituloPropiedad> propiedades;
    
    
    TituloPropiedad(String nombre,int precioC,int alquilerB,float factorR,int hipotecaB,int precioE)
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
    
    int calcularCosteCancelar(){
        return 0;
    }
    
    int calcularCosteHipotecar(){
        return 0;
    }
    
    double calcularImporteAlquiler(){
        double costeAlquiler;
            
        costeAlquiler = this.alquilerBase + this.numHoteles*0.5 + this.numCasas*2;
        
        return costeAlquiler;
    }
    
    int calcularPrecioVenta(){
        return 0;
    }
    
    int cancelarHipoteca(){
        return 0;
    }
    
    void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
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
    
    Jugador getPropietario(){
        return this.propietario;
    }
    
    int hipotecar(){
        return 0;
    }
    
    int pagarAlquiler(){
        return 0;
    }
    
    boolean propietarioEncarcelado(){
        return propietario.getEncarcelado();
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    boolean tengoPropietario(){
        return propietario != null;
    }

    @Override
    public String toString() {
        return "TituloPropiedad{" + "Nombre=" + Nombre + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", hipotecada=" + hipotecada + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + ", propietario=" + propietario + ", propiedades=" + propiedades + '}';
    }
}
