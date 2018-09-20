package modeloqytetet;
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
