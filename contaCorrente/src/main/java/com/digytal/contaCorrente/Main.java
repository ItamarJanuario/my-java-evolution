package com.digytal.contaCorrente;

import com.digytal.contaCorrente.Contas.ContaCorrente;
import com.digytal.contaCorrente.Contas.ContaPoupanca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.parse("2001-07-03");
        Cliente cliente = new Cliente("Itamar", dataNascimento, "213.321.321-80");
        ContaCorrente conta1 = new ContaCorrente(cliente, 123, 324, cliente.getCpf());

        Cliente cliente2 = new Cliente("Sharadon", LocalDate.now(), "123.321.456-70");
        ContaPoupanca conta2 = new ContaPoupanca(cliente2, 456, 654, cliente2.getCpf());

        LocalDate dataInical = LocalDate.now();
        LocalDate dataFinal = dataInical.plusMonths(1);

        conta1.depositar(1000.0);
        conta1.sacar(300.0);
        conta1.transferir(200.0, conta2);
        conta1.cancelarConta(MotivoCancelamento.INSASTIFEITO, "Sem dinheiro para fornecer ao banco");

        System.out.println(conta1);
        ArrayList<Extrato> extrato = conta1.consultarExtrato(dataInical, dataFinal);

        GenerateTxt.gerarArquivo(conta1);


    }
}
