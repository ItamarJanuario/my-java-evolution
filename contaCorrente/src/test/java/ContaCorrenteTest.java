import com.digytal.contaCorrente.Cliente;
import com.digytal.contaCorrente.Contas.Conta;
import com.digytal.contaCorrente.Contas.ContaCorrente;
import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class ContaCorrenteTest {

    LocalDate dataTeste;
    LocalDate dataTesteFuture;
    Cliente clienteTeste;
    Cliente clienteTeste2;
    ContaCorrente contaCorrente;
    ContaCorrente contaCorrente2;

    @BeforeEach
    public void setUp() {
        dataTeste = LocalDate.now();
        dataTesteFuture = LocalDate.now().plusMonths(1);

        clienteTeste = new Cliente("Itamar Januario Teste", dataTeste, "122-444-666.80");
        clienteTeste = new Cliente("Jessica Antenas Parabolicas", dataTeste.plusMonths(2), "111-432-656.10");

        contaCorrente = new ContaCorrente(clienteTeste, 123, 323, clienteTeste.getCpf());
        contaCorrente2 = new ContaCorrente(clienteTeste2, 232, 355, clienteTeste2.getCpf());

    }

    @Nested
    @DisplayName("Testando todas as funcionalidades do metodoSacar")
    public class TesteMetodoSaque {
        
    }


}
