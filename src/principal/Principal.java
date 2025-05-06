package principal;

import api.ServicoExchangeRate;
import interfaceusuario.MenuConsole;
import servico.ConversorMoeda;

public class Principal {
    public static void main(String[] args) {
        ServicoExchangeRate servico = new ServicoExchangeRate();
        ConversorMoeda conversor = new ConversorMoeda(servico);
        MenuConsole menu = new MenuConsole(conversor);
        menu.iniciar();

    }
}