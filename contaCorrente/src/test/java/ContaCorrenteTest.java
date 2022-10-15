import com.digytal.contaCorrente.Contas.Conta;
import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaCorrenteTest {

    @DisplayName("Testando metodo sacar")
    @Test
    void testando_metodo_sacar() throws ValorIncorretoException {
        Double expectativa = 100.0;
        Conta contaTest = new Conta();
            contaTest.depositar(200.0);

         Double resultado = contaTest.sacar(100.0);

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
