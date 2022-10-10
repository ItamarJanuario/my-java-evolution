package com.digytal.contaCorrente;

import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.JustificativaException;
import com.digytal.contaCorrente.exception.MesmaContaException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conta {
    Integer numeroConta;
    Integer numeroAgencia;
    String nome;
    Double saldo = 0.0;
    ArrayList<Extrato> extrato = new ArrayList<Extrato>();
    public Double getSaldo(){
        return saldo;
    }

    public void depositar(Double valor) throws ValorIncorretoException {
        validarSaldoMaiorQueZero(valor);
        saldo += valor;
        System.out.println("Deposito conlcuido com sucesso.");
        inserindoExtrato("Deposito", valor);
    }

    public Double sacar(Double valor) throws ValorIncorretoException {
        valorMaiorQueSaldo(valor);
        saldo -= valor;
        inserindoExtrato("Saque", valor);
        return valor;
    }

    public void transferir(Double valor, Conta contaDestino) throws ValorIncorretoException, MesmaContaException {
        valorMaiorQueSaldo(valor);
        validarContaDestino(contaDestino);
        VerificandoConta(contaDestino);
            System.out.println("conta - > " + this.numeroConta + " está transferindo para - > " + contaDestino.numeroConta);
            contaDestino.saldo += valor;
            saldo -= valor;
            inserindoExtrato("Transferencia", valor);
    }

    public boolean cancelarConta(String justificativa) throws JustificativaException{
        VerificandoJustificativa(justificativa);
        System.out.println("Conta cancelada com sucesso !");
        return true;
    }

    public void consultarExtrato(LocalDate dataInicial, LocalDate dataFinal) throws DataException {
        if(dataInicial.isAfter(dataFinal)) {
            throw new DataException();
        }

        for(Extrato x: extrato){
            System.out.println(x);
        }



    }

    //VALIDAÇÕES

    public void valorMaiorQueSaldo(Double valor) throws ValorIncorretoException {
        if(valor > saldo) {
            throw new ValorIncorretoException();
        }
    }

    public void validarContaDestino(Conta contaDestino) {
        if(contaDestino == null){
            throw new IllegalArgumentException("[ ERROR ] Não foi possivel tranferir, por favor informe o numero da conta do Destinatário");
        }
    }

    public void validarSaldoMaiorQueZero(Double valor) throws ValorIncorretoException {
        if(valor <= 0) {
            throw new ValorIncorretoException("[ ERROR ] O valor deve ser superior a zero");
        }
    }

    public void VerificandoConta(Conta contaDestino) throws MesmaContaException {
        if(this.numeroConta.equals(contaDestino.numeroConta)) {
            throw new MesmaContaException();
        }
    }

    public void VerificandoJustificativa(String justificativa) throws JustificativaException {
        if(justificativa == " ") {
            throw new JustificativaException();
        }
    }

    public void inserindoExtrato(String funcao, Double valor) {
        Extrato extratoEsqueleto = new Extrato(funcao, LocalDate.now(), valor);
        extrato.add(extratoEsqueleto);
    }
}
