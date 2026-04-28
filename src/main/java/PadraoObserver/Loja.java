package PadraoObserver;
import java.util.Observable;

public class Loja extends Observable {

    private String nomeProduto;

    public Loja(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void novaPromocao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Loja{" +
                "produto='" + nomeProduto + '\'' +
                '}';
    }
}
