package fundamentos;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        String cpf = "234.765.987-27";
        LocalDate data = LocalDate.now();
        String numeroProtocolo;

        System.out.println(data.toString());
        String dataString = data.toString().replaceAll("\\D", "");
        System.out.println(dataString);

        System.out.println(cpf);
        String novoCpf = cpf.replaceAll("\\D", "");
        System.out.println(novoCpf);

        numeroProtocolo = dataString.substring(0, 7).concat(novoCpf.substring(5, 9));
        System.out.println(numeroProtocolo);

    }


}
