package PadraoObserverTest;

import PadraoObserver.Cliente;
import PadraoObserver.Loja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    void deveNotificarClientesQuandoHouverPromocao() {
        Loja loja = new Loja("Notebook");

        Cliente c1 = new Cliente("João");
        Cliente c2 = new Cliente("Maria");

        c1.seguirLoja(loja);
        c2.seguirLoja(loja);

        loja.novaPromocao();

        assertTrue(c1.getUltimaNotificacao().contains("João"));
        assertTrue(c2.getUltimaNotificacao().contains("Maria"));
    }

    @Test
    void clienteNaoInscritoNaoRecebeNotificacao() {
        Loja loja = new Loja("Notebook");

        Cliente c1 = new Cliente("João");

        loja.novaPromocao();

        assertNull(c1.getUltimaNotificacao());
    }

    @Test
    void mensagemDeveConterInformacoesDaLoja() {
        Loja loja = new Loja("Notebook");
        Cliente cliente = new Cliente("Carlos");

        cliente.seguirLoja(loja);

        loja.novaPromocao();

        String notificacao = cliente.getUltimaNotificacao();

        assertTrue(notificacao.contains("Notebook"));
        assertTrue(notificacao.contains("Loja"));
    }
}
