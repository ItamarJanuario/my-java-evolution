package com.digytal.contaCorrente;

import java.time.LocalDate;

public class Extrato {
    String funcao;
    LocalDate dataFuncao;
    Double valor;

    public Extrato(String funcao, LocalDate dataFuncao, Double valor) {
        this.funcao = funcao;
        this.dataFuncao = dataFuncao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[ EXTRATO ] ->  " +
                "[ " + funcao + " ] " +
                "[ DATA OCORRIDA ] -> " + dataFuncao + " -> [ VALOR " +
                 valor + " ]";
    }
}
