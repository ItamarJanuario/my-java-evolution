package com.digytal.contaCorrente.exception;

public class MesmaContaException extends Exception{
    public MesmaContaException() {
        super("[ ERROR ] Você está tentando transferir para sua própria conta !!");
    }

    public MesmaContaException(String message) {
        super(message);
    }
}
