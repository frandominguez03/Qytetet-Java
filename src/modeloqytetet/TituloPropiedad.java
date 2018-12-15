package modeloqytetet;

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
    
    
    TituloPropiedad(String nombre, int precioC, int alquilerB, float factorR, int hipotecaB, int precioE)
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
        int costeCancelar = 0;
        
        costeCancelar = (int) (calcularCosteHipotecar() + calcularCosteHipotecar()*0.1);
        
        return costeCancelar;
    }
    
    int calcularCosteHipotecar(){
        int costeHipoteca = 0;
        
        costeHipoteca = (int) (this.hipotecaBase + this.numCasas*0.5*this.hipotecaBase + this.numHoteles*this.hipotecaBase);
        
        return costeHipoteca;
    }
    
    int calcularImporteAlquiler(){
        int costeAlquiler;
            
        costeAlquiler = (int) (this.alquilerBase + this.numHoteles*0.5 + this.numCasas*2);
        
        return costeAlquiler;
    }
    
    int calcularPrecioVenta(){
        int precioVenta;
        
        precioVenta = (int) (precioCompra + (numCasas + numHoteles) * precioEdificar * factorRevalorizacion);
        
        return precioVenta;
    }
    
    boolean cancelarHipoteca(){
        this.hipotecada = false;
        
        return true;
    }

    void edificarCasa(){
        this.numCasas++;
    }
    
    void edificarHotel(){
        this.numHoteles++;
        this.numCasas -= 4;
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
        int costeHipoteca = calcularCosteHipotecar();
        this.setHipotecada(true);
        
        return costeHipoteca;
    }
    
    int pagarAlquiler(){
        int costeAlquiler = (int) calcularImporteAlquiler();
        this.propietario.modificarSaldo(costeAlquiler);
        
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado(){
        return propietario.getEncarcelado();
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    boolean tienePropietario(){
        return propietario != null;
    }

    @Override
    public String toString() {
        if(!tienePropietario()){
            return "TituloPropiedad{" + "Nombre=" + Nombre + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", hipotecada=" + hipotecada + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + '}';
        }
        
        else{
            return "TituloPropiedad{" + "Nombre=" + Nombre + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", hipotecada=" + hipotecada + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + ", propietario=" + propietario.getNombre() + '}';
        }
    }
}
