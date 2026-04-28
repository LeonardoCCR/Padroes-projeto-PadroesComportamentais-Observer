package PadraoObserver;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void seguirLoja(Loja loja) {
        loja.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ", promoção disponível em " + o.toString();
    }
}