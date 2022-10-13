package fundamentos.dinamicas;
import java.time.LocalDate;

public class Conta {
    private Integer numeroConta;
    private Integer numeroAgencia;
    private String nome;
    private LocalDate date;
    private boolean cancelada;
    private Double saldo = 0d;

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

    public Boolean cancelarConta(String justificativa) {
        return false;
    }

    void verifySaldo (Double Saldo) {
        if(saldo == null) {
            System.out.println("[ ERROR ] Não foi possivel continuar essa transação");
        }
    }




}
