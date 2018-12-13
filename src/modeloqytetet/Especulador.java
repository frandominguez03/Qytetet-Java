package modeloqytetet;

public class Especulador extends Jugador {
    private int fianza;
    
    protected Especulador(Jugador jugador, int fianza) {
        super(jugador);
        this.fianza = fianza;
    }
    
    @Override
    protected void pagarImpuesto(){
        modificarSaldo(-(getCasillaActual().getCoste()/2));
    }
    
    @Override
    protected boolean deboIrACarcel(){
        boolean resultado = false;
        
        if(super.deboIrACarcel() && !pagarFianza()){
            resultado = true;
        }
        
        return resultado;
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    private boolean pagarFianza(){
        boolean puedePagar = false;
        
        if(getSaldo() > this.fianza){
            modificarSaldo(-(this.fianza));
            puedePagar = true;
        }
        
        return puedePagar;
    }
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        boolean hayEspacio = titulo.getNumCasas() < 8;
        boolean tengoSaldo = false;
        
        if(hayEspacio){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarCasa);
        }
        
        return hayEspacio && tengoSaldo;
    }
    
    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        int numHoteles = titulo.getNumHoteles();
        boolean tengoSaldo = tengoSaldo(titulo.getPrecioEdificar());
        
        return numHoteles < 8 && tengoSaldo;
    }

    @Override
    public String toString() {
        return super.toString() + " Especulador{" + "fianza=" + fianza + '}';
    }   
}
