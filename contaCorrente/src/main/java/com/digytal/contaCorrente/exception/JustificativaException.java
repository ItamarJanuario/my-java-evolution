package com.digytal.contaCorrente.exception;

public class JustificativaException extends RuntimeException{
    public JustificativaException() {
        super("[ ERROR ] Você precisa especificar o motivo no qual quer cancelar a conta !");
    }

    public JustificativaException(String message) {
        super(message);
    }
}
