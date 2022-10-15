package com.digytal.contaCorrente.Contas;

import com.digytal.contaCorrente.Cliente;
import com.digytal.contaCorrente.exception.ValorIncorretoException;

public class ContaCorrente extends Conta{

    Double saldoChequeEspecial = 50.0;
    public ContaCorrente(Cliente cliente, Integer numeroConta, Integer numeroAgencia, String cpf) {
        super(cliente, numeroConta, numeroAgencia, cpf);
    }

    @Override
    public Double sacar(Double valor) {
        Double soma = saldo + saldoChequeEspecial;
        Double dif = soma - valor;
        if(valor > saldo) {
            if(valor > soma) {
                throw new ValorIncorretoException("[ ERROR ] nao foi possivel efetuar o saque");
            } else {
                saldoChequeEspecial = dif;
                return saldo = 0.0;
            }
        }
        return saldo -= valor;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "motivoCancelamento=" + motivoCancelamento +
                '}';
    }
}
