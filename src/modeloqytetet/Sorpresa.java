package modeloqytetet;
public class Sorpresa {
    private String Texto;
    private TipoSorpresa Sorpresa;
    private int Valor;
    
    public Sorpresa(String texto, int valor, TipoSorpresa tipo){
        Texto=texto;
        Valor=valor;
        Sorpresa=tipo;
    }
    
    String getTexto(){
        return Texto;
    }
    
    TipoSorpresa getTipo(){
        return Sorpresa;
    }
    
    int getValor(){
        return Valor;
    }
    
    @Override
    public String toString() {
        return "Sorpresa{" + "texto=" + Texto + ", valor=" + 
        Integer.toString(Valor) + ", tipo=" + Sorpresa + "}";
     }
}
