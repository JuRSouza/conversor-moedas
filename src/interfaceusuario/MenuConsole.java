package interfaceusuario;

import modelo.ConversaoMoeda;
import servico.ConversorMoeda;

import java.util.Scanner;

public class MenuConsole {
    private final ConversorMoeda conversor;

    public MenuConsole(ConversorMoeda conversor) {
        this.conversor = conversor;
    }

    //método para iniciar - chamar na classe Principal
    public void iniciar() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("""
                    **********************************************************
                    Seja bem-vindo (a) ao nosso Conversor de Moeda =]
                    1) Dólar =>>> Peso Argentino
                    2) Peso Argentino =>>> Dólar
                    3) Dólar =>>> Real brasileiro
                    4) Real brasileiro =>>> Dólar
                    5) Dólar =>>> Peso colombiano
                    6) Peso colombiano =>>> Dólar
                    7) Sair
                    Escolha uma opção válida:
                    ***********************************************************
                    """);
            opcao = entrada.nextInt();

            if (opcao == 7)
                break;
            System.out.println("Digite o valor que deseja converter: ");
            double valor = entrada.nextDouble();

            String de_pais = "";
            String para_pais = "";

            switch (opcao) {
                case 1 -> { de_pais = "USD"; para_pais = "ARS"; }
                case 2 -> { de_pais = "ARS"; para_pais = "USD"; }
                case 3 -> { de_pais = "USD"; para_pais = "BRL"; }
                case 4 -> { de_pais = "BRL"; para_pais = "USD"; }
                case 5 -> { de_pais = "USD"; para_pais = "COP"; }
                case 6 -> { de_pais = "COP"; para_pais = "USD"; }
                default -> { System.out.println("Opção inválida!"); continue; }
            }

            ConversaoMoeda resultado = conversor.converter(de_pais, para_pais, valor);
            if (resultado != null){
                System.out.println("Valor " + resultado.valor() + " [" + resultado.de_pais() + "] corresponde a " +
                        resultado.resultado() + " [" + resultado.para_pais() + "]");

            }

        } while (opcao != 7);

        entrada.close();
        System.out.println(" encerrando o programa...");

    }
}
