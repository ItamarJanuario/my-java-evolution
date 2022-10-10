package fundamentos.dinamicas;
import java.time.LocalDate;

public class Conta {
    Integer numeroConta;
    Integer numeroAgencia;
    String nome;
    LocalDate date;
    Boolean cancelada = false;
    /*
    SE EU NAO INSTANCIAR UM NUMERO 0.0 PARA O SALDO VOU FORÇAR UM ERRO DE EXPECTION POIS DOUBLE EM
    WRAPPERS ELE SEMPRE VA INICIALIZAR CONTENDO NULL
    */
    Double saldo = 0d;

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double saldo) {
        if(saldo > 0) {
            this.saldo += saldo;
        } else {
            System.out.println("[ ERROR ] O valor do depósito deve ser superior a zero");
        }

    }

    public void sacar(Double valor) {
        verifySaldo(saldo);
        saldo -= valor;
    }

    public void transferir(Double valor, Conta contaDestino) {
      verifySaldo(saldo);
      if(contaDestino.numeroConta == null) {
          System.out.println("[ ERROR ] Não foi possivel continuar essa transação");
      } else {
        saldo -= valor;
        contaDestino.saldo = valor;
      }
    }

//    public Boolean cancelarConta(String justificativa) {
//    }

    void verifySaldo (Double Saldo) {
        if(saldo == null) {
            System.out.println("[ ERROR ] Não foi possivel continuar essa transação");
        }
    }




}
