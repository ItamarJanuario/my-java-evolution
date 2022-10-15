import com.digytal.contaCorrente.Cliente;
import com.digytal.contaCorrente.Contas.Conta;
import com.digytal.contaCorrente.Contas.ContaCorrente;
import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaCorrenteTest {


    @DisplayName("Fazendo testes de todos os metodos sacar")
    @Test
    void TestandoMetodoSacar(){

    }


    @DisplayName("Fazendo teste do metodo sacar da Conta Corrente")
    @Test
    void TestandoMetodoSacarContaCorrente() throws ValorIncorretoException {
        LocalDate dataNascimento = LocalDate.parse("2001-03-07");
        Cliente clienteTest = new Cliente("Itamar", dataNascimento, "124.741.574-80");
        ContaCorrente contaTest = new ContaCorrente(clienteTest, 123, 322, clienteTest.getCpf());

        Double expectativa = 100.0;

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Testando Exception de Data")
    @Test
    void testando_exception_DataException() throws ValorIncorretoException{
        Conta contaTest = new Conta();
          contaTest.depositar(100.0);

        Assertions.assertThrows(DataException.class, () -> {
           contaTest.consultarExtrato(LocalDate.parse("2022-12-20"), LocalDate.parse("2022-12-12"));
        });
    }

}
