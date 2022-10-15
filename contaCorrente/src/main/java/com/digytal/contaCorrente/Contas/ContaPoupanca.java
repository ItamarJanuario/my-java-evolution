package com.digytal.contaCorrente.Contas;

import com.digytal.contaCorrente.Cliente;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente, Integer numeroConta, Integer numeroAgencia, String cpf) {
        super(cliente, numeroConta, numeroAgencia, cpf);
    }
}
