package modeloqytetet;
public class Sorpresa {
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    Sorpresa(String texto, int valor, TipoSorpresa tipo){
        this.texto=texto;
        this.valor=valor;
        this.tipo=tipo;
    }
    
    String getTexto(){
        return texto;
    }
    
    TipoSorpresa getTipo(){
        return tipo;
    }
    
    int getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return "Sorpresa{" + "texto=" + texto + ", tipo=" + tipo + ", valor=" + valor + '}';
    }
}
