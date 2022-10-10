package com.digytal.contaCorrente;

import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.JustificativaException;
import com.digytal.contaCorrente.exception.MesmaContaException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class ContaCorrente {
    public static void main(String[] args) {
        Conta conta = new Conta();
        Conta contaSecundaria = new Conta();

        conta.numeroConta = 123;
        contaSecundaria.numeroConta = 321;

        try{
            conta.depositar(100.0);
        }catch(ValorIncorretoException e){
            e.printStackTrace();
        }
        System.out.println(conta.getSaldo());

        try {
            conta.sacar(20.0);
        } catch (ValorIncorretoException e) {
            e.printStackTrace();
        }
        System.out.println(conta.getSaldo());

        try {
            conta.transferir(10.0, contaSecundaria);
        }catch (ValorIncorretoException | MesmaContaException e) {
            e.printStackTrace();
        }
        try {
            conta.cancelarConta("amendoa");
        }catch(JustificativaException e){
            e.printStackTrace();
        }

        try{
            conta.consultarExtrato(LocalDate.parse("2022-12-20"), LocalDate.parse("2022-12-21"));
        }catch(DataException e){
            e.printStackTrace();
        }

    }
}
