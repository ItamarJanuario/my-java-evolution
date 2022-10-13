package com.digytal.contaCorrente;

public enum TipoOperacao {
    CREDITO('C'),
    DEBITO('D'),
    TRANSFERENCIA('F');

    private char sigla;

    public char getSigla() {
        return sigla;
    }

    TipoOperacao(char sigla) {
        this.sigla = sigla;
    }
}
