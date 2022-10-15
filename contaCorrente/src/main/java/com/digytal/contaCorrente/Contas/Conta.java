package com.digytal.contaCorrente.Contas;

import com.digytal.contaCorrente.Cliente;
import com.digytal.contaCorrente.Extrato;
import com.digytal.contaCorrente.MotivoCancelamento;
import com.digytal.contaCorrente.TipoOperacao;
import com.digytal.contaCorrente.exception.DataException;
import com.digytal.contaCorrente.exception.JustificativaException;
import com.digytal.contaCorrente.exception.MesmaContaException;
import com.digytal.contaCorrente.exception.ValorIncorretoException;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Conta {
    Cliente cliente;
    Integer numeroConta;
    String cpf;
    Integer numeroAgencia;
    String nome;
    Double saldo = 0.0;
    ArrayList<Extrato> extrato = new ArrayList<Extrato>();
    LocalDate dataAbertura;
    LocalDate dataCancelamento;
    MotivoCancelamento motivoCancelamento;
    String justificativa;

    public Conta(Cliente cliente, Integer numeroConta, Integer numeroAgencia, String cpf) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.cpf = cpf;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Double getSaldo(){
        return saldo;
    }

    public void depositar(Double valor) {
        validarSaldoMaiorQueZero(valor);
        saldo += valor;
        System.out.println("Deposito conlcuido com sucesso.");
        inserindoExtrato(TipoOperacao.DEBITO,"Deposito", valor);
    }

    public Double sacar(Double valor){
        valorMaiorQueSaldo(valor);
        saldo -= valor;
        inserindoExtrato(TipoOperacao.CREDITO,"Saque", valor);
        return valor;
    }

    public void transferir(Double valor, Conta contaDestino){
        valorMaiorQueSaldo(valor);
        validarContaDestino(contaDestino);
        VerificandoConta(contaDestino);
        System.out.println("conta - > " + this.numeroConta + " está transferindo para - > " + contaDestino.numeroConta);
        contaDestino.saldo += valor;
        saldo -= valor;
        inserindoExtrato(TipoOperacao.TRANSFERENCIA,"Transferencia", valor);
    }

    public boolean cancelarConta(MotivoCancelamento motivo, String justificativa){
        VerificandoJustificativa(justificativa);
        System.out.println("Conta cancelada com sucesso !");
        this.dataCancelamento = LocalDate.now();
        this.motivoCancelamento = motivo;
        return true;
    }

    public ArrayList<Extrato> consultarExtrato(LocalDate dataInicial, LocalDate dataFinal){
        validarData(dataInicial, dataFinal);
        for(Extrato x: extrato){
            System.out.println(x);
        }
        return extrato;
    }

    //VALIDAÇÕES

    public void valorMaiorQueSaldo(Double valor){
        if(valor > saldo) {
            throw new ValorIncorretoException();
        }
    }

    public void validarSaldoMaiorQueZero(Double valor){
        if(valor <= 0) {
            throw new ValorIncorretoException("[ ERROR ] O valor deve ser superior a zero");
        }
    }

    public void validarContaDestino(Conta contaDestino) {
        if(contaDestino == null){
            throw new IllegalArgumentException("[ ERROR ] Não foi possivel tranferir, por favor informe o numero da conta do Destinatário");
        }
    }

    public void VerificandoConta(Conta contaDestino){
        if(this.numeroConta.equals(contaDestino.numeroConta)) {
            throw new MesmaContaException();
        }
    }

    public void VerificandoJustificativa(String justificativa){
        if(justificativa.isEmpty()) {
            throw new JustificativaException();
        }
    }

    public void inserindoExtrato(TipoOperacao tipo, String descricao, Double valor) {
        Extrato extratoEsqueleto = new Extrato(tipo, descricao, LocalDate.now(), valor);
        extrato.add(extratoEsqueleto);
    }

    public void validarData(LocalDate dataInicial, LocalDate dataFinal){
        if(dataInicial == null || dataFinal == null || dataInicial.isAfter(dataFinal)) {
            throw new DataException();
        }
    }
}
