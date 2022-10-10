package fundamentos.powerclasses;

public class TiposDeDados {
    public static void main(String[] args) {
        byte idade = 123;
        short ano = 2013;

        // + RECOMENDADO

        int cep = 213332132; // SE COMEÇAR COM ZERO, TALVEZ TENHA QUE SER OUTRO TIPO
        long cpf = 23123123123123123L; // SE COMEÇAR COM ZERO, TALVEZ TENHA QUE SER OUTRO TIPO


        //CRIANDO UMA VARIAVEL CONSTANTE (TENDO QUE ACRESENTAR O "FINAL" NO COMEÇO DA INSTANCIA E SEU NOME MAISCULO) ;
        final float PI = 3.14F;
        final double SALARIO = 12332.33D;

        int number = 1;
        number++;

        System.out.println(number);
    }
}
