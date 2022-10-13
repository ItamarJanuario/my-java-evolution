package com.digytal.contaCorrente;

import java.time.LocalDate;

public class Extrato {
    TipoOperacao tipo;
    String descricao;
    LocalDate data;
    Double valor;

    public Extrato(TipoOperacao tipo,String descricao, LocalDate data, Double valor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder representacao = new StringBuilder();
        representacao.append("Data: " + this.data + "\n");
        representacao.append("Tipo: " + this.tipo + "\n");
        representacao.append("Descricao: " + this.descricao + "\n");
        representacao.append("Valor: " + this.valor + "\n");
        return representacao.toString();
    }
}
