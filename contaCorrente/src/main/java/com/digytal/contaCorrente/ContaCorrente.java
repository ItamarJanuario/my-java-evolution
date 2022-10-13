package com.digytal.contaCorrente;

import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.JustificativaException;
import com.digytal.contaCorrente.exception.MesmaContaException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContaCorrente {
    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.parse("2001-07-03");
        Cliente cliente = new Cliente("Itamar", dataNascimento, "213.321.321-80");
        Conta conta1 = new Conta(cliente, 123, 324);

        Cliente cliente2 = new Cliente("Sharadon", LocalDate.now(), "123.321.456-70");
        Conta conta2 = new Conta(cliente2, 456, 654);

        LocalDate dataInical = LocalDate.now();
        LocalDate dataFinal = dataInical.plusMonths(1);

        conta1.depositar(1000.0);
        conta1.sacar(300.0);
        conta1.transferir(200.0, conta2);
        conta1.cancelarConta("Sem dinheiro para fornecer ao banco");
        ArrayList<Extrato> extrato = conta1.consultarExtrato(dataInical, dataFinal);

        GenerateTxt.gerarArquivo(conta1);


    }
}
