package com.digytal.contaCorrente.exception;

public class DataException extends RuntimeException{
    public DataException() {
        super("[ ERROR ] OPS, não foi possivel prosseguir com a consulta de extrato, por favor verifique as datas !");
    }

    public DataException(String message) {
        super(message);
    }
}
