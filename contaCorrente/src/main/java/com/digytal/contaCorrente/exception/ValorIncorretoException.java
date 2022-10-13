package com.digytal.contaCorrente.exception;

public class ValorIncorretoException extends RuntimeException{
    public ValorIncorretoException() {
        super("[ ERROR ] Há algo de errado com o valor que você deseja passar, Verifique e tente novamente");
    }

    public ValorIncorretoException(String message) {
        super(message);
    }
}
