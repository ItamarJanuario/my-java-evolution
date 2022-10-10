package fundamentos.dinamicas;

public class ContaCorrente {
    public static void main(String[] args) {
        Conta conta = new Conta();
        Conta outraConta = new Conta();

        conta.depositar(123.32);
        System.out.println(conta.getSaldo());

        conta.sacar(10.0);
        System.out.println(conta.getSaldo());

        conta.cancelarConta("amendoa");
    }
}
